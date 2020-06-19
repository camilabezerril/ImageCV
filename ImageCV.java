package appcv.ImageCV;

import android.Manifest;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.errors.IllegalArgumentError;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.YailList;

import android.util.Log;
import java.io.IOException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import android.os.Environment;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Matrix;
import android.graphics.Color;

import boofcv.android.ConvertBitmap;
import boofcv.android.ImplConvertBitmap;
import boofcv.alg.filter.binary.GThresholdImageOps;
import boofcv.alg.filter.binary.ThresholdImageOps;
import boofcv.alg.shapes.ellipse.BinaryEllipseDetector;
import boofcv.alg.shapes.polygon.BinaryPolygonDetector;
import boofcv.alg.color.ColorHsv;
import boofcv.factory.filter.binary.FactoryThresholdBinary;
import boofcv.factory.shape.FactoryShapeDetector;
import boofcv.factory.shape.ConfigPolygonDetector;
import georegression.metric.UtilAngle;
import georegression.struct.shapes.EllipseRotated_F64;
import georegression.struct.point.Point2D_F64;
import georegression.struct.shapes.Polygon2D_F64;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.GrayF32;
import boofcv.struct.image.Planar;
import boofcv.struct.image.ImageType;
import org.ddogleg.struct.FastQueue;

/**
 * ==================================================
 * Componente para Visão Computacional no App Inventor:
 * Utilizando a Biblioteca BoofCV
 * =====================================================
 */

@DesignerComponent(version = 1,
        category = ComponentCategory.EXTENSION,
        description = "Componente para Visao Computacional no App Inventor",
        nonVisible = true,
        iconName = "images/extension.png")
@SimpleObject(external = true)
@UsesLibraries(libraries = "boofcv-android.jar," + "boofcv-ip.jar,"
        + "ddogleg.jar," + "georegression.jar," + "boofcv-feature.jar," + "ejml-core.jar,"
        + "ejml-ddense.jar," + "ejml-fdense.jar," + "ejml-simple.jar")

public class ImageCV extends AndroidNonvisibleComponent implements Component {

    private ComponentContainer componentContainer;

    public ImageCV(ComponentContainer container) {
        super(container.$form());
        this.componentContainer = container;
    };

    private String picturePath = "";
    private String altImagePath = "";

    private int nElipses = 0;
    private int nPoligonos = 0;
    private String formaCor = "";
    private static final int MAX_SIDES = 20;
    private static final int MIN_SIDES = 3;
    private YailList ListaDeElipses = new YailList();
    private YailList ListaDePoligonos = new YailList();

    private float Hhsv = 0;
    private float Shsv = 0;
    private float Vhsv = 0;

    /** ==================================================
     Métodos para funcionalidades básicas da extensão
     - Getters e Setters para o usuário
     - Conversão e armazenamento de imagens
     ===================================================== */

    /**
     * Retorna imagem alterada pela extensao
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String getAltImagePath() {
        return altImagePath;
    }

    /**
     * Retorna numero de elipses encontradas
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public int getnElipses() {
        return nElipses;
    }

    /**
     * Retorna numero de poligonos encontrados
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public int getnPoligonos() {
        return nPoligonos;
    }

    /**
     * Retorna H de conversão RGB para HSV
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public float getHfromRGBtoHSV() {
        return Hhsv;
    }

    /**
     * Retorna S de conversão RGB para HSV
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public float getSfromRGBtoHSV() {
        return Shsv;
    }

    /**
     * Retorna V de conversão RGB para HSV
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public float getVfromRGBtoHSV() {
        return Vhsv;
    }

    /**
     * Modifica numero de elipses encontradas
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void setnElipses(int setTo) {
        nElipses = setTo;
    }

    /**
     * Modifica numero de poligonos encontrados
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void setnPoligonos(int setTo) {
        nPoligonos = setTo;
    }

    /**
     * Retorna lista de elipses que contém as informações de cada elipse em forma de listas
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public YailList getListaDeElipses() {
        return ListaDeElipses;
    }

    /**
     * Retorna lista de elipses que contém as informações de cada elipse em forma de listas
     */

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public YailList getListaDePoligonos() {
        return ListaDePoligonos;
    }

    /**
     * Método para converter imagem (tratada como drawable)
     * recebida pela câmera em bitmap - retorna Bitmap
     */
    public Bitmap converteDrawableToBitmap(String picturePath) {

        Drawable drawable;
        try {
            drawable = MediaUtil.getBitmapDrawable(form, picturePath);
        } catch (IOException ioe) {
            Log.e("Image", "Unable to load " + picturePath);
            drawable = null;
        }

        int scaledWidth = (int) (form.deviceDensity() * drawable.getIntrinsicWidth());
        int scaledHeight = (int) (form.deviceDensity() * drawable.getIntrinsicHeight());

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(),
                scaledWidth, scaledHeight, false);

        return scaledBitmap;
    }

    /**
     * Método para salvar imagem (bitmap para jpeg) alterada
     * pela extensão e gerar caminho desta
     */
    public void salvaAltImage(Bitmap bitmap) {

        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
        File myDir = new File(root + "/ImageCV/");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "AltImage_" + n + ".jpg";  //nome da imagem alterada
        File file = new File(myDir, fname);

        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //SALVANDO PATH DA IMAGEM ALTERADA
        altImagePath = root + "/ImageCV/AltImage_" + n + ".jpg";
    }

    /**
     * ==================================================
     * Métodos para Visão Computacional no App Inventor
     * ==================================================
     */

    @SimpleFunction(description = "Substitui os tons de uma cor por preto por meio do sistema HSV [FORMATO: 0-6.28, 0-1.0]")
    public void stepHSV(String picturePath, String HSmin, String HSmax){
        Bitmap bitmap = converteDrawableToBitmap(picturePath);

        String[] aux = HSmin.split(",");
        float Hmin = Float.parseFloat(aux[0]);
        float Smin = Float.parseFloat(aux[1]);

        aux = HSmax.split(",");
        float Hmax = Float.parseFloat(aux[0]);
        float Smax = Float.parseFloat(aux[1]);

        //reinicia para outro reconhecimento
        formaCor = "";

        //Para que cor (rgb) o tom aplicado pelo usuário está mais semelhante:
        //Duas condições para o vermelho (hue é circular, o vermelho atinge tanto ~6.2 como ~0)
        if (Smax <= 0.1) formaCor = "Branco";
        else if (Hmin >= 0 && Hmax <= 1.199) formaCor = "Vermelho";
        else if (Hmin >= 1.2 && Hmax <= 2.619) formaCor = "Verde";
        else if (Hmin >= 2.62 && Hmax <= 5.299) formaCor = "Azul";
        else if (Hmin >= 5.3 && Hmax <= 6.28) formaCor = "Vermelho";

        Planar<GrayF32> input = ConvertBitmap.bitmapToPlanar(bitmap, null, GrayF32.class, null);
        ImplConvertBitmap.bitmapToPlanarRGB_F32(bitmap, input);
        Planar<GrayF32> hsv = input.createSameShape();

        // Convert RGB image to HSV
        ColorHsv.rgbToHsv_F32(input, hsv); //output hsv

        // Extract hue and saturation bands which are independent of intensity
        GrayF32 H = hsv.getBand(0);
        GrayF32 S = hsv.getBand(1);

        int pixel;
        int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];

        // Hue has a range of 0 to 2*PI and Saturation from 0 to 1.
        bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        for (int y = 0; y < hsv.height; y++) {
            for (int x = 0; x < hsv.width; x++) {
                int index = y * hsv.width + x;
                pixel = pixels[index];

                //unsafe_get pega dados (H ou S) do ponto x,y
                float h = H.unsafe_get(x, y);
                float s = S.unsafe_get(x, y);

                if (h >= Hmin && h <= Hmax && s >= Smin && s <= Smax) pixels[index] = Color.BLACK;
                else pixels[index] = Color.WHITE;
            }
        }

        bitmap.setPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        salvaAltImage(bitmap);
    }

    /**
     * Converte RGB para HSV para o usuário usando a biblioteca BoofCV
     */
    @SimpleFunction(description = "Converte RGB em HSV [FORMATO:x,x,x]")
    public void converteRGBtoHSV(String RGB) {
        float[] hsv = new float[3];
        float[] rgb = new float[3];

        String[] aux = RGB.split(",");
        for (int i = 0; i < 3; i++) rgb[i] = Float.parseFloat(aux[i]);

        ColorHsv.rgbToHsv(rgb[0], rgb[1], rgb[2], hsv);

        Hhsv = hsv[0];
        Shsv = hsv[1];
        Vhsv = hsv[2];
    }

    /**
     * Reconhece elipses em uma imagem que são desenhadas por meio de uma canvas,
     * cria uma lista contendo as características de cada elipse e salva imagem alterada.
     */
    @SimpleFunction(description = "Reconhece elipses em uma imagem")
    public void reconheceElipses(String picturePath){
        Bitmap bitmap = converteDrawableToBitmap(picturePath);

        GrayU8 input = ConvertBitmap.bitmapToGray(bitmap, (GrayU8) null, null);
        GrayU8 binary = new GrayU8(input.width, input.height);

        BinaryEllipseDetector<GrayU8> detector = FactoryShapeDetector.ellipse(null, GrayU8.class);

        int threshold = (int) GThresholdImageOps.computeOtsu(input, 0, 255);
        ThresholdImageOps.threshold(input, binary, threshold, true);

        detector.process(input, binary);

        FastQueue<EllipseRotated_F64> found = detector.getFoundEllipses();

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        int cameraToDisplayDensity = 3;

        Paint paint = new Paint();
        paint.setARGB(0xFF, 0xFF, 0, 0);
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);

        RectF r = new RectF();

        binary.reshape(width, height);
        paint.setStrokeWidth(5.0f * cameraToDisplayDensity);

        Canvas canvas = new Canvas(bitmap);
        canvas.setBitmap(bitmap);

        int i = 0;
        for (EllipseRotated_F64 elipse : found.toList()) {
            i++;
        }

        Object[] todasElipses = new Object[i];
        int j = 0;

        for (EllipseRotated_F64 elipse : found.toList()){
            float phi = (float) UtilAngle.degree(elipse.phi);
            float cx = (float) elipse.center.x;
            float cy = (float) elipse.center.y;
            float w = (float) elipse.a; //semi major axis
            float h = (float) elipse.b; //semi minor axis

            //  really skinny ones are probably just a line and not what the user wants
            if (w <= 2 || h <= 2) return;

            canvas.save();
            canvas.rotate(phi, cx, cy);
            r.set(cx - w, cy - h, cx + w + 1, cy + h + 1);
            canvas.drawOval(r, paint);
            canvas.restore();

            int compElipse = (int) (Math.PI * ((Math.sqrt((w * w + h * h) / 2)) * 2));
            if (formaCor.equals("")) formaCor = "Não especificado";

            ArrayList<String> cElipse = new ArrayList<>();
            cElipse.add(Float.toString(cx));
            cElipse.add(Float.toString(cy));
            cElipse.add(formaCor);
            cElipse.add(Integer.toString(compElipse));

            if (!cElipse.isEmpty()) todasElipses[j] = YailList.makeList(cElipse);

            nElipses++;
            j++;
        }

        if (todasElipses != null) ListaDeElipses = YailList.makeList(todasElipses);
        salvaAltImage(bitmap);
    }

    /**
     * Método que cria detector de polígonos para uma imagem, minLados > 3 e maxLados < 20
     * e salva imagem alterada pelos outros métodos
     */
    @SimpleFunction(description = "Reconhece polígonos em uma imagem, minLados > 3 e maxLados < 20")
    public void reconhecePoligonos(String picturePath, int minLados, int maxLados) {
        Bitmap bitmap = converteDrawableToBitmap(picturePath);

        if (minLados < 3 || minLados > 20) minLados = 3;
        if (maxLados > 20 || maxLados < 3) maxLados = 20;

        Canvas canvas = new Canvas(bitmap);
        canvas.setBitmap(bitmap);

        ConfigPolygonDetector config = new ConfigPolygonDetector(minLados, maxLados);
        BinaryPolygonDetector<GrayU8> detector = FactoryShapeDetector.polygon(config, GrayU8.class);

        processaPoligonos(bitmap, detector, canvas);

        salvaAltImage(bitmap);
    }

    /**
     * Reconhece tanto polígonos côncavos como os convexos e
     * cria lista contendo as características de cada polígonos.
     */
    public void processaPoligonos(Bitmap bitmap, BinaryPolygonDetector<GrayU8> detector, Canvas canvas) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        GrayU8 input = ConvertBitmap.bitmapToGray(bitmap, (GrayU8) null, null);
        GrayU8 binary = new GrayU8(input.width, input.height);

        int threshold = (int) GThresholdImageOps.computeOtsu(input, 0, 255);
        ThresholdImageOps.threshold(input, binary, threshold, true);

        detector.process(input, binary);

        FastQueue<Polygon2D_F64> foundpol = detector.getFoundPolygons();

        Path path = new Path();
        int colors[] = new int[MAX_SIDES - MIN_SIDES + 1];
        int cameraToDisplayDensity = 3;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);

        paint.setStrokeWidth(4.0f * cameraToDisplayDensity);
        binary.reshape(width, height);

        double rgb[] = new double[3];

        for (int i = 0; i < colors.length; i++) {
            double frac = i / (double) (colors.length);

            double hue = 2 * Math.PI * frac;
            double sat = 1.0;

            ColorHsv.hsvToRgb(hue, sat, 255, rgb);

            colors[i] = 255 << 24 | ((int) rgb[0] << 16) | ((int) rgb[1] << 8) | (int) rgb[2];
        }

        int i = 0;
        for (Polygon2D_F64 polygon : foundpol.toList()) {
            i++;
        }

        Object[] todosPoligonos = new Object[i];
        int j = 0;

        for (Polygon2D_F64 polygon : foundpol.toList()) {

            paint.setColor(colors[polygon.size() - MIN_SIDES]);
            todosPoligonos[j] = renderPolygon(polygon, path, canvas, paint);

            nPoligonos++;
            j++;
        }

        if (todosPoligonos != null) ListaDePoligonos = YailList.makeList(todosPoligonos);
    }


    /**
     * Copia parcial do código miscutil do BoofCV (0.35)
     * Desenha polígono por meio de um canvas, salva imagem alterada
     * e retorna as informações deste polígono.
     */
    public Object renderPolygon(Polygon2D_F64 s, Path path, Canvas canvas, Paint paint) {
        path.reset();

        if (formaCor.equals("")) formaCor = "Não especificado";

        ArrayList<String> cPoligono = new ArrayList<>();
        cPoligono.add(formaCor);

        for (int j = 0; j < s.size(); j++) {
            Point2D_F64 p = s.get(j);
            if (j == 0) {
                path.moveTo((float) p.x, (float) p.y);

                //Para lista de coodernadas de vértices do polígono
                cPoligono.add(Float.toString((float)p.x));
                cPoligono.add(Float.toString((float)p.y));

            } else {
                path.lineTo((float) p.x, (float) p.y);

                //Para lista de coodernadas de vértices do polígono
                cPoligono.add(Float.toString((float)p.x));
                cPoligono.add(Float.toString((float)p.y));
            }
        }
        Point2D_F64 p = s.get(0);
        path.lineTo((float) p.x, (float) p.y);
        path.close();
        canvas.drawPath(path, paint);

        if (!cPoligono.isEmpty()) return YailList.makeList(cPoligono);
        return null;
    }
}
