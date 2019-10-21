public List<String> pdfbox_f5046_0()
{    List<String> components = new ArrayList<>();    COSArray cosComponents = (COSArray) dictionary.getDictionaryObject(COSName.COMPONENTS);    if (cosComponents == null) {        return components;    }    for (COSBase name : cosComponents) {        components.add(((COSName) name).getName());    }    return components;}
public String pdfbox_f5047_1()
{    StringBuilder sb = new StringBuilder("Process{");    try {        sb.append(getColorSpace());        for (String component : getComponents()) {            sb.append(" \"");            sb.append(component);            sb.append('\"');        }    } catch (IOException e) {                sb.append("ERROR");    }    sb.append('}');    return sb.toString();}
private void pdfbox_f5048_0()
{        if (awtColorSpace != null) {        return;    }    synchronized (this) {                if (awtColorSpace != null) {            return;        }        awtColorSpace = ColorSpace.getInstance(ColorSpace.CS_sRGB);                                awtColorSpace.toRGB(new float[] { 0, 0, 0, 0 });    }}
public String pdfbox_f5049_0()
{    return COSName.DEVICERGB.getName();}
public int pdfbox_f5050_0()
{    return 3;}
public float[] pdfbox_f5051_0(int bitsPerComponent)
{    return new float[] { 0, 1, 0, 1, 0, 1 };}
public PDColor pdfbox_f5052_0()
{    return initialColor;}
public float[] pdfbox_f5053_0(float[] value)
{    return value;}
public BufferedImage pdfbox_f5054_0(WritableRaster raster) throws IOException
{    init();                            BufferedImage image = new BufferedImage(raster.getWidth(), raster.getHeight(), BufferedImage.TYPE_INT_RGB);    image.setData(raster);    return image;}
public COSBase pdfbox_f5055_0()
{    return values;}
public COSArray pdfbox_f5056_0()
{    return values;}
public float pdfbox_f5057_0()
{    return ((COSNumber) values.get(0)).floatValue();}
public void pdfbox_f5058_0(float r)
{    values.set(0, new COSFloat(r));}
public float pdfbox_f5059_0()
{    return ((COSNumber) values.get(1)).floatValue();}
public void pdfbox_f5060_0(float g)
{    values.set(1, new COSFloat(g));}
public float pdfbox_f5061_0()
{    return ((COSNumber) values.get(2)).floatValue();}
public void pdfbox_f5062_0(float b)
{    values.set(2, new COSFloat(b));}
public static PDICCBased pdfbox_f5063_0(COSArray iccArray, PDResources resources) throws IOException
{    checkArray(iccArray);    COSBase base = iccArray.get(1);    COSObject indirect = null;    if (base instanceof COSObject) {        indirect = (COSObject) base;    }    if (indirect != null && resources != null && resources.getResourceCache() != null) {        PDColorSpace space = resources.getResourceCache().getColorSpace(indirect);        if (space != null && space instanceof PDICCBased) {            return (PDICCBased) space;        }    }    PDICCBased space = new PDICCBased(iccArray);    if (indirect != null && resources != null && resources.getResourceCache() != null) {        resources.getResourceCache().put(indirect, space);    }    return space;}
private static void pdfbox_f5064_0(COSArray iccArray) throws IOException
{    if (iccArray.size() < 2) {        throw new IOException("ICCBased colorspace array must have two elements");    }    if (!(iccArray.getObject(1) instanceof COSStream)) {        throw new IOException("ICCBased colorspace array must have a stream as second element");    }}
public String pdfbox_f5065_0()
{    return COSName.ICCBASED.getName();}
public PDStream pdfbox_f5066_0()
{    return stream;}
private void pdfbox_f5067_1() throws IOException
{    if (useOnlyAlternateColorSpace) {        try {            fallbackToAlternateColorSpace(null);            return;        } catch (IOException e) {                    }    }    try (InputStream input = this.stream.createInputStream()) {                        ICC_Profile profile;        synchronized (LOG) {            profile = ICC_Profile.getInstance(input);            if (is_sRGB(profile)) {                isRGB = true;                awtColorSpace = (ICC_ColorSpace) ColorSpace.getInstance(ColorSpace.CS_sRGB);                iccProfile = awtColorSpace.getProfile();            } else {                profile = ensureDisplayProfile(profile);                awtColorSpace = new ICC_ColorSpace(profile);                iccProfile = profile;            }                        float[] initial = new float[getNumberOfComponents()];            for (int c = 0; c < getNumberOfComponents(); c++) {                initial[c] = Math.max(0, getRangeForComponent(c).getMin());            }            initialColor = new PDColor(initial, this);            if (IS_KCMS) {                                                                                new Color(awtColorSpace, new float[getNumberOfComponents()], 1f);            } else {                                new ComponentColorModel(awtColorSpace, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);            }        }    } catch (ProfileDataException | CMMException | IllegalArgumentException | ArrayIndexOutOfBoundsException | IOException e) {        fallbackToAlternateColorSpace(e);    }}
private void pdfbox_f5068_1(Exception e) throws IOException
{    awtColorSpace = null;    alternateColorSpace = getAlternateColorSpace();    if (alternateColorSpace.equals(PDDeviceRGB.INSTANCE)) {        isRGB = true;    }    if (e != null) {            }    initialColor = alternateColorSpace.getInitialColor();}
private boolean pdfbox_f5069_0(ICC_Profile profile)
{    byte[] bytes = Arrays.copyOfRange(profile.getData(ICC_Profile.icSigHead), ICC_Profile.icHdrModel, ICC_Profile.icHdrModel + 7);    String deviceModel = new String(bytes, Charsets.US_ASCII).trim();    return deviceModel.equals("sRGB");}
private static ICC_Profile pdfbox_f5070_1(ICC_Profile profile)
{    if (profile.getProfileClass() != ICC_Profile.CLASS_DISPLAY) {                byte[] profileData = profile.getData();        if (profileData[ICC_Profile.icHdrRenderingIntent] == ICC_Profile.icPerceptual) {                        intToBigEndian(ICC_Profile.icSigDisplayClass, profileData, ICC_Profile.icHdrDeviceClass);            return ICC_Profile.getInstance(profileData);        }    }    return profile;}
private static void pdfbox_f5071_0(int value, byte[] array, int index)
{    array[index] = (byte) (value >> 24);    array[index + 1] = (byte) (value >> 16);    array[index + 2] = (byte) (value >> 8);    array[index + 3] = (byte) (value);}
public float[] pdfbox_f5072_0(float[] value) throws IOException
{    if (isRGB) {        return value;    }    if (awtColorSpace != null) {                return awtColorSpace.toRGB(clampColors(awtColorSpace, value));    } else {        return alternateColorSpace.toRGB(value);    }}
private float[] pdfbox_f5073_0(ICC_ColorSpace cs, float[] value)
{    float[] result = new float[value.length];    for (int i = 0; i < value.length; ++i) {        float minValue = cs.getMinValue(i);        float maxValue = cs.getMaxValue(i);        result[i] = value[i] < minValue ? minValue : (value[i] > maxValue ? maxValue : value[i]);    }    return result;}
public BufferedImage pdfbox_f5074_0(WritableRaster raster) throws IOException
{    if (awtColorSpace != null) {        return toRGBImageAWT(raster, awtColorSpace);    } else {        return alternateColorSpace.toRGBImage(raster);    }}
public int pdfbox_f5075_0()
{    if (numberOfComponents < 0) {        numberOfComponents = stream.getCOSObject().getInt(COSName.N);    }    return numberOfComponents;}
public float[] pdfbox_f5076_0(int bitsPerComponent)
{    if (awtColorSpace != null) {        int n = getNumberOfComponents();        float[] decode = new float[n * 2];        for (int i = 0; i < n; i++) {            decode[i * 2] = awtColorSpace.getMinValue(i);            decode[i * 2 + 1] = awtColorSpace.getMaxValue(i);        }        return decode;    } else {        return alternateColorSpace.getDefaultDecode(bitsPerComponent);    }}
public PDColor pdfbox_f5077_0()
{    return initialColor;}
public PDColorSpace pdfbox_f5078_0() throws IOException
{    COSBase alternate = stream.getCOSObject().getDictionaryObject(COSName.ALTERNATE);    COSArray alternateArray;    if (alternate == null) {        alternateArray = new COSArray();        int numComponents = getNumberOfComponents();        COSName csName;        switch(numComponents) {            case 1:                csName = COSName.DEVICEGRAY;                break;            case 3:                csName = COSName.DEVICERGB;                break;            case 4:                csName = COSName.DEVICECMYK;                break;            default:                throw new IOException("Unknown color space number of components:" + numComponents);        }        alternateArray.add(csName);    } else {        if (alternate instanceof COSArray) {            alternateArray = (COSArray) alternate;        } else if (alternate instanceof COSName) {            alternateArray = new COSArray();            alternateArray.add(alternate);        } else {            throw new IOException("Error: expected COSArray or COSName and not " + alternate.getClass().getName());        }    }    return PDColorSpace.create(alternateArray);}
public PDRange pdfbox_f5079_0(int n)
{    COSArray rangeArray = (COSArray) stream.getCOSObject().getDictionaryObject(COSName.RANGE);    if (rangeArray == null || rangeArray.size() < getNumberOfComponents() * 2) {                return new PDRange();    }    return new PDRange(rangeArray, n);}
public COSStream pdfbox_f5080_0()
{    return (COSStream) stream.getCOSObject().getDictionaryObject(COSName.METADATA);}
public int pdfbox_f5081_0()
{    if (iccProfile != null) {        return iccProfile.getColorSpaceType();    }        switch(alternateColorSpace.getNumberOfComponents()) {        case 1:            return ICC_ColorSpace.TYPE_GRAY;        case 3:            return ICC_ColorSpace.TYPE_RGB;        case 4:            return ICC_ColorSpace.TYPE_CMYK;        default:                        return -1;    }}
public void pdfbox_f5082_0(int n)
{    numberOfComponents = n;    stream.getCOSObject().setInt(COSName.N, n);}
public void pdfbox_f5083_0(List<PDColorSpace> list)
{    COSArray altArray = null;    if (list != null) {        altArray = COSArrayList.converterToCOSArray(list);    }    stream.getCOSObject().setItem(COSName.ALTERNATE, altArray);}
public void pdfbox_f5084_0(PDRange range, int n)
{    COSArray rangeArray = (COSArray) stream.getCOSObject().getDictionaryObject(COSName.RANGE);    if (rangeArray == null) {        rangeArray = new COSArray();        stream.getCOSObject().setItem(COSName.RANGE, rangeArray);    }        while (rangeArray.size() < (n + 1) * 2) {        rangeArray.add(new COSFloat(0));        rangeArray.add(new COSFloat(1));    }    rangeArray.set(n * 2, new COSFloat(range.getMin()));    rangeArray.set(n * 2 + 1, new COSFloat(range.getMax()));}
public void pdfbox_f5085_0(COSStream metadata)
{    stream.getCOSObject().setItem(COSName.METADATA, metadata);}
public String pdfbox_f5086_0()
{    return getName() + "{numberOfComponents: " + getNumberOfComponents() + "}";}
public String pdfbox_f5087_0()
{    return COSName.INDEXED.getName();}
public int pdfbox_f5088_0()
{    return 1;}
public float[] pdfbox_f5089_0(int bitsPerComponent)
{    return new float[] { 0, (float) Math.pow(2, bitsPerComponent) - 1 };}
public PDColor pdfbox_f5090_0()
{    return initialColor;}
private void pdfbox_f5091_0() throws IOException
{    int numBaseComponents = baseColorSpace.getNumberOfComponents();            WritableRaster baseRaster;    try {        baseRaster = Raster.createBandedRaster(DataBuffer.TYPE_BYTE, actualMaxIndex + 1, 1, numBaseComponents, new Point(0, 0));    } catch (IllegalArgumentException ex) {                throw new IOException(ex);    }    int[] base = new int[numBaseComponents];    for (int i = 0, n = actualMaxIndex; i <= n; i++) {        for (int c = 0; c < numBaseComponents; c++) {            base[c] = (int) (colorTable[i][c] * 255f);        }        baseRaster.setPixel(i, 0, base);    }        BufferedImage rgbImage = baseColorSpace.toRGBImage(baseRaster);    WritableRaster rgbRaster = rgbImage.getRaster();        rgbColorTable = new int[actualMaxIndex + 1][3];    int[] nil = null;    for (int i = 0, n = actualMaxIndex; i <= n; i++) {        rgbColorTable[i] = rgbRaster.getPixel(i, 0, nil);    }}
public float[] pdfbox_f5092_0(float[] value)
{    if (value.length > 1) {        throw new IllegalArgumentException("Indexed color spaces must have one color value");    }        int index = Math.round(value[0]);    index = Math.max(index, 0);    index = Math.min(index, actualMaxIndex);        int[] rgb = rgbColorTable[index];    return new float[] { rgb[0] / 255f, rgb[1] / 255f, rgb[2] / 255f };}
public BufferedImage pdfbox_f5093_0(WritableRaster raster) throws IOException
{        int width = raster.getWidth();    int height = raster.getHeight();    BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    WritableRaster rgbRaster = rgbImage.getRaster();    int[] src = new int[1];    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, src);                        int index = Math.min(src[0], actualMaxIndex);            rgbRaster.setPixel(x, y, rgbColorTable[index]);        }    }    return rgbImage;}
public PDColorSpace pdfbox_f5094_0()
{    return baseColorSpace;}
private int pdfbox_f5095_0()
{    return ((COSNumber) array.getObject(2)).intValue();}
private byte[] pdfbox_f5096_0() throws IOException
{    if (lookupData == null) {        COSBase lookupTable = array.getObject(3);        if (lookupTable instanceof COSString) {            lookupData = ((COSString) lookupTable).getBytes();        } else if (lookupTable instanceof COSStream) {            lookupData = new PDStream((COSStream) lookupTable).toByteArray();        } else if (lookupTable == null) {            lookupData = new byte[0];        } else {            throw new IOException("Error: Unknown type for lookup table " + lookupTable);        }    }    return lookupData;}
private void pdfbox_f5097_0() throws IOException
{    byte[] lookupData = getLookupData();    int maxIndex = Math.min(getHival(), 255);    int numComponents = baseColorSpace.getNumberOfComponents();        if (lookupData.length / numComponents < maxIndex + 1) {        maxIndex = lookupData.length / numComponents - 1;    }        actualMaxIndex = maxIndex;    colorTable = new float[maxIndex + 1][numComponents];    for (int i = 0, offset = 0; i <= maxIndex; i++) {        for (int c = 0; c < numComponents; c++) {            colorTable[i][c] = (lookupData[offset] & 0xff) / 255f;            offset++;        }    }}
public void pdfbox_f5098_0(PDColorSpace base)
{    array.set(1, base.getCOSObject());    baseColorSpace = base;}
public void pdfbox_f5099_0(int high)
{    array.set(2, high);}
public String pdfbox_f5100_0()
{    return "Indexed{base:" + baseColorSpace + " " + "hival:" + getHival() + " " + "lookup:(" + colorTable.length + " entries)}";}
public String pdfbox_f5101_0()
{    return "JPX";}
public int pdfbox_f5102_0()
{    return awtColorSpace.getNumComponents();}
public float[] pdfbox_f5103_0(int bitsPerComponent)
{    int n = getNumberOfComponents();    float[] decode = new float[n * 2];    for (int i = 0; i < n; i++) {        decode[i * 2] = awtColorSpace.getMinValue(i);        decode[i * 2 + 1] = awtColorSpace.getMaxValue(i);    }    return decode;}
public PDColor pdfbox_f5104_0()
{    throw new UnsupportedOperationException("JPX color spaces don't support drawing");}
public float[] pdfbox_f5105_0(float[] value)
{    throw new UnsupportedOperationException("JPX color spaces don't support drawing");}
public BufferedImage pdfbox_f5106_0(WritableRaster raster) throws IOException
{    return toRGBImageAWT(raster, awtColorSpace);}
public COSBase pdfbox_f5107_0()
{    throw new UnsupportedOperationException("JPX color spaces don't have COS objects");}
public String pdfbox_f5108_0()
{    return COSName.LAB.getName();}
public BufferedImage pdfbox_f5109_0(WritableRaster raster) throws IOException
{    int width = raster.getWidth();    int height = raster.getHeight();    BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    WritableRaster rgbRaster = rgbImage.getRaster();    float minA = getARange().getMin();    float maxA = getARange().getMax();    float minB = getBRange().getMin();    float maxB = getBRange().getMax();        float[] abc = new float[3];    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, abc);                        abc[0] /= 255;            abc[1] /= 255;            abc[2] /= 255;                        abc[0] *= 100;            abc[1] = minA + (abc[1] * (maxA - minA));            abc[2] = minB + (abc[2] * (maxB - minB));            float[] rgb = toRGB(abc);                        rgb[0] *= 255;            rgb[1] *= 255;            rgb[2] *= 255;            rgbRaster.setPixel(x, y, rgb);        }    }    return rgbImage;}
public float[] pdfbox_f5110_0(float[] value)
{            float lstar = (value[0] + 16f) * (1f / 116f);            float x = wpX * inverse(lstar + value[1] * (1f / 500f));    float y = wpY * inverse(lstar);    float z = wpZ * inverse(lstar - value[2] * (1f / 200f));    return convXYZtoRGB(x, y, z);}
private float pdfbox_f5111_0(float x)
{    if (x > 6.0 / 29.0) {        return x * x * x;    } else {        return (108f / 841f) * (x - (4f / 29f));    }}
public int pdfbox_f5112_0()
{    return 3;}
public float[] pdfbox_f5113_0(int bitsPerComponent)
{    PDRange a = getARange();    PDRange b = getARange();    return new float[] { 0, 100, a.getMin(), a.getMax(), b.getMin(), b.getMax() };}
public PDColor pdfbox_f5114_0()
{    if (initialColor == null) {        initialColor = new PDColor(new float[] { 0, Math.max(0, getARange().getMin()), Math.max(0, getBRange().getMin()) }, this);    }    return initialColor;}
private COSArray pdfbox_f5115_0()
{    COSArray range = new COSArray();    range.add(new COSFloat(-100));    range.add(new COSFloat(100));    range.add(new COSFloat(-100));    range.add(new COSFloat(100));    return range;}
public PDRange pdfbox_f5116_0()
{    COSArray rangeArray = (COSArray) dictionary.getDictionaryObject(COSName.RANGE);    if (rangeArray == null) {        rangeArray = getDefaultRangeArray();    }    return new PDRange(rangeArray, 0);}
public PDRange pdfbox_f5117_0()
{    COSArray rangeArray = (COSArray) dictionary.getDictionaryObject(COSName.RANGE);    if (rangeArray == null) {        rangeArray = getDefaultRangeArray();    }    return new PDRange(rangeArray, 1);}
public void pdfbox_f5118_0(PDRange range)
{    setComponentRangeArray(range, 0);}
public void pdfbox_f5119_0(PDRange range)
{    setComponentRangeArray(range, 2);}
private void pdfbox_f5120_0(PDRange range, int index)
{    COSArray rangeArray = (COSArray) dictionary.getDictionaryObject(COSName.RANGE);    if (rangeArray == null) {        rangeArray = getDefaultRangeArray();    }    if (range == null) {                rangeArray.set(index, new COSFloat(-100));        rangeArray.set(index + 1, new COSFloat(100));    } else {        rangeArray.set(index, new COSFloat(range.getMin()));        rangeArray.set(index + 1, new COSFloat(range.getMax()));    }    dictionary.setItem(COSName.RANGE, rangeArray);    initialColor = null;}
public COSBase pdfbox_f5121_0()
{    return dictionary;}
public COSStream pdfbox_f5122_0()
{    return (COSStream) dictionary.getDictionaryObject(COSName.DEST_OUTPUT_PROFILE);}
public String pdfbox_f5123_0()
{    return dictionary.getString(COSName.INFO);}
public void pdfbox_f5124_0(String value)
{    dictionary.setString(COSName.INFO, value);}
public String pdfbox_f5125_0()
{    return dictionary.getString(COSName.OUTPUT_CONDITION);}
public void pdfbox_f5126_0(String value)
{    dictionary.setString(COSName.OUTPUT_CONDITION, value);}
public String pdfbox_f5127_0()
{    return dictionary.getString(COSName.OUTPUT_CONDITION_IDENTIFIER);}
public void pdfbox_f5128_0(String value)
{    dictionary.setString(COSName.OUTPUT_CONDITION_IDENTIFIER, value);}
public String pdfbox_f5129_0()
{    return dictionary.getString(COSName.REGISTRY_NAME);}
public void pdfbox_f5130_0(String value)
{    dictionary.setString(COSName.REGISTRY_NAME, value);}
private PDStream pdfbox_f5131_0(PDDocument doc, InputStream colorProfile) throws IOException
{    ICC_Profile icc = ICC_Profile.getInstance(colorProfile);    PDStream stream = new PDStream(doc, new ByteArrayInputStream(icc.getData()), COSName.FLATE_DECODE);    stream.getCOSObject().setInt(COSName.N, icc.getNumComponents());    return stream;}
public String pdfbox_f5132_0()
{    return COSName.PATTERN.getName();}
public int pdfbox_f5133_0()
{    throw new UnsupportedOperationException();}
public float[] pdfbox_f5134_0(int bitsPerComponent)
{    throw new UnsupportedOperationException();}
public PDColor pdfbox_f5135_0()
{    return EMPTY_PATTERN;}
public float[] pdfbox_f5136_0(float[] value)
{    throw new UnsupportedOperationException();}
public BufferedImage pdfbox_f5137_0(WritableRaster raster) throws IOException
{    throw new UnsupportedOperationException();}
public PDAbstractPattern pdfbox_f5138_0(PDColor color) throws IOException
{    PDAbstractPattern pattern = resources.getPattern(color.getPatternName());    if (pattern == null) {        throw new IOException("pattern " + color.getPatternName() + " was not found");    } else {        return pattern;    }}
public PDColorSpace pdfbox_f5139_0()
{    return underlyingColorSpace;}
public String pdfbox_f5140_0()
{    return "Pattern";}
public String pdfbox_f5141_0()
{    return COSName.SEPARATION.getName();}
public int pdfbox_f5142_0()
{    return 1;}
public float[] pdfbox_f5143_0(int bitsPerComponent)
{    return new float[] { 0, 1 };}
public PDColor pdfbox_f5144_0()
{    return initialColor;}
public float[] pdfbox_f5145_0(float[] value) throws IOException
{    if (toRGBMap == null) {        toRGBMap = new HashMap<>();    }    int key = (int) (value[0] * 255);    float[] retval = toRGBMap.get(key);    if (retval != null) {        return retval;    }    float[] altColor = tintTransform.eval(value);    retval = alternateColorSpace.toRGB(altColor);    toRGBMap.put(key, retval);    return retval;}
public BufferedImage pdfbox_f5146_0(WritableRaster raster) throws IOException
{    if (alternateColorSpace instanceof PDLab) {                return toRGBImage2(raster);    }            WritableRaster altRaster = Raster.createBandedRaster(DataBuffer.TYPE_BYTE, raster.getWidth(), raster.getHeight(), alternateColorSpace.getNumberOfComponents(), new Point(0, 0));    int numAltComponents = alternateColorSpace.getNumberOfComponents();    int width = raster.getWidth();    int height = raster.getHeight();    float[] samples = new float[1];    Map<Integer, int[]> calculatedValues = new HashMap<>();    Integer hash;    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, samples);            hash = Float.floatToIntBits(samples[0]);            int[] alt = calculatedValues.get(hash);            if (alt == null) {                alt = new int[numAltComponents];                tintTransform(samples, alt);                calculatedValues.put(hash, alt);            }            altRaster.setPixel(x, y, alt);        }    }        return alternateColorSpace.toRGBImage(altRaster);}
private BufferedImage pdfbox_f5147_0(WritableRaster raster) throws IOException
{    int width = raster.getWidth();    int height = raster.getHeight();    BufferedImage rgbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    WritableRaster rgbRaster = rgbImage.getRaster();    float[] samples = new float[1];    Map<Integer, int[]> calculatedValues = new HashMap<>();    Integer hash;    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            raster.getPixel(x, y, samples);            int[] rgb = calculatedValues.get(hash = Float.floatToIntBits(samples[0]));            if (rgb == null) {                samples[0] /= 255;                float[] altColor = tintTransform.eval(samples);                float[] fltab = alternateColorSpace.toRGB(altColor);                rgb = new int[3];                rgb[0] = (int) (fltab[0] * 255);                rgb[1] = (int) (fltab[1] * 255);                rgb[2] = (int) (fltab[2] * 255);                calculatedValues.put(hash, rgb);            }            rgbRaster.setPixel(x, y, rgb);        }    }    return rgbImage;}
protected void pdfbox_f5148_0(float[] samples, int[] alt) throws IOException
{        samples[0] /= 255;    float[] result = tintTransform.eval(samples);    for (int s = 0; s < alt.length; s++) {                alt[s] = (int) (result[s] * 255);    }}
public PDColorSpace pdfbox_f5149_0()
{    return alternateColorSpace;}
public String pdfbox_f5150_0()
{    COSName name = (COSName) array.getObject(COLORANT_NAMES);    return name.getName();}
public void pdfbox_f5151_0(String name)
{    array.set(1, COSName.getPDFName(name));}
public void pdfbox_f5152_0(PDColorSpace colorSpace)
{    alternateColorSpace = colorSpace;    COSBase space = null;    if (colorSpace != null) {        space = colorSpace.getCOSObject();    }    array.set(ALTERNATE_CS, space);}
public void pdfbox_f5153_0(PDFunction tint)
{    tintTransform = tint;    array.set(TINT_TRANSFORM, tint);}
public String pdfbox_f5154_0()
{    return getName() + "{" + "\"" + getColorantName() + "\"" + " " + alternateColorSpace.getName() + " " + tintTransform + "}";}
public COSBase pdfbox_f5155_0()
{    return array;}
public COSBase pdfbox_f5156_0()
{    return values;}
public float pdfbox_f5157_0()
{    return ((COSNumber) values.get(0)).floatValue();}
public void pdfbox_f5158_0(float x)
{    values.set(0, new COSFloat(x));}
public float pdfbox_f5159_0()
{    return ((COSNumber) values.get(1)).floatValue();}
public void pdfbox_f5160_0(float y)
{    values.set(1, new COSFloat(y));}
public float pdfbox_f5161_0()
{    return ((COSNumber) values.get(2)).floatValue();}
public void pdfbox_f5162_0(float z)
{    values.set(2, new COSFloat(z));}
public int pdfbox_f5163_0()
{    return getCOSObject().getInt(COSName.FORMTYPE, 1);}
public void pdfbox_f5164_0(int formType)
{    getCOSObject().setInt(COSName.FORMTYPE, formType);}
public PDTransparencyGroupAttributes pdfbox_f5165_0()
{    if (group == null) {        COSDictionary dic = (COSDictionary) getCOSObject().getDictionaryObject(COSName.GROUP);        if (dic != null) {            group = new PDTransparencyGroupAttributes(dic);        }    }    return group;}
public PDStream pdfbox_f5166_0()
{    return new PDStream(getCOSObject());}
public InputStream pdfbox_f5167_0() throws IOException
{    return getCOSObject().createInputStream();}
public PDResources pdfbox_f5168_0()
{    COSDictionary resources = getCOSObject().getCOSDictionary(COSName.RESOURCES);    if (resources != null) {        return new PDResources(resources, cache);    }    if (getCOSObject().containsKey(COSName.RESOURCES)) {                return new PDResources();    }    return null;}
public void pdfbox_f5169_0(PDResources resources)
{    getCOSObject().setItem(COSName.RESOURCES, resources);}
public PDRectangle pdfbox_f5170_0()
{    PDRectangle retval = null;    COSArray array = (COSArray) getCOSObject().getDictionaryObject(COSName.BBOX);    if (array != null) {        retval = new PDRectangle(array);    }    return retval;}
public void pdfbox_f5171_0(PDRectangle bbox)
{    if (bbox == null) {        getCOSObject().removeItem(COSName.BBOX);    } else {        getCOSObject().setItem(COSName.BBOX, bbox.getCOSArray());    }}
public Matrix pdfbox_f5172_0()
{    return Matrix.createMatrix(getCOSObject().getDictionaryObject(COSName.MATRIX));}
public void pdfbox_f5173_0(AffineTransform transform)
{    COSArray matrix = new COSArray();    double[] values = new double[6];    transform.getMatrix(values);    for (double v : values) {        matrix.add(new COSFloat((float) v));    }    getCOSObject().setItem(COSName.MATRIX, matrix);}
public int pdfbox_f5174_0()
{    return getCOSObject().getInt(COSName.STRUCT_PARENTS);}
public void pdfbox_f5175_0(int structParent)
{    getCOSObject().setInt(COSName.STRUCT_PARENTS, structParent);}
public COSDictionary pdfbox_f5176_0()
{    return dictionary;}
public PDColorSpace pdfbox_f5177_0() throws IOException
{    return getColorSpace(null);}
public PDColorSpace pdfbox_f5178_0(PDResources resources) throws IOException
{    if (colorSpace == null && getCOSObject().containsKey(COSName.CS)) {        colorSpace = PDColorSpace.create(getCOSObject().getDictionaryObject(COSName.CS), resources);    }    return colorSpace;}
public boolean pdfbox_f5179_0()
{    return getCOSObject().getBoolean(COSName.I, false);}
public boolean pdfbox_f5180_0()
{    return getCOSObject().getBoolean(COSName.K, false);}
public static PDImageXObject pdfbox_f5181_0(PDDocument document, BufferedImage image) throws IOException
{    if (image.getType() != BufferedImage.TYPE_BYTE_BINARY && image.getColorModel().getPixelSize() != 1) {        throw new IllegalArgumentException("Only 1-bit b/w images supported");    }    int height = image.getHeight();    int width = image.getWidth();    ByteArrayOutputStream bos = new ByteArrayOutputStream();    try (MemoryCacheImageOutputStream mcios = new MemoryCacheImageOutputStream(bos)) {        for (int y = 0; y < height; ++y) {            for (int x = 0; x < width; ++x) {                                mcios.writeBits(~(image.getRGB(x, y) & 1), 1);            }            if (mcios.getBitOffset() != 0) {                mcios.writeBits(0, 8 - mcios.getBitOffset());            }        }        mcios.flush();    }    return prepareImageXObject(document, bos.toByteArray(), width, height, PDDeviceGray.INSTANCE);}
public static PDImageXObject pdfbox_f5182_0(PDDocument document, byte[] byteArray) throws IOException
{    return createFromByteArray(document, byteArray, 0);}
public static PDImageXObject pdfbox_f5183_0(PDDocument document, byte[] byteArray, int number) throws IOException
{    try (RandomAccess raf = new RandomAccessBuffer(byteArray)) {        return createFromRandomAccessImpl(document, raf, number);    }}
private static PDImageXObject pdfbox_f5184_0(PDDocument document, byte[] byteArray, int width, int height, PDColorSpace initColorSpace) throws IOException
{    ByteArrayOutputStream baos = new ByteArrayOutputStream();    Filter filter = FilterFactory.INSTANCE.getFilter(COSName.CCITTFAX_DECODE);    COSDictionary dict = new COSDictionary();    dict.setInt(COSName.COLUMNS, width);    dict.setInt(COSName.ROWS, height);    filter.encode(new ByteArrayInputStream(byteArray), baos, dict, 0);    ByteArrayInputStream encodedByteStream = new ByteArrayInputStream(baos.toByteArray());    PDImageXObject image = new PDImageXObject(document, encodedByteStream, COSName.CCITTFAX_DECODE, width, height, 1, initColorSpace);    dict.setInt(COSName.K, -1);    image.getCOSObject().setItem(COSName.DECODE_PARMS, dict);    return image;}
public static PDImageXObject pdfbox_f5185_0(PDDocument document, File file) throws IOException
{    return createFromFile(document, file, 0);}
public static PDImageXObject pdfbox_f5186_0(PDDocument document, File file, int number) throws IOException
{    try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {        return createFromRandomAccessImpl(document, raf, number);    }}
private static PDImageXObject pdfbox_f5187_0(PDDocument document, RandomAccess reader, int number) throws IOException
{    COSDictionary decodeParms = new COSDictionary();    ByteArrayOutputStream bos = new ByteArrayOutputStream();    extractFromTiff(reader, bos, decodeParms, number);    if (bos.size() == 0) {        return null;    }    ByteArrayInputStream encodedByteStream = new ByteArrayInputStream(bos.toByteArray());    PDImageXObject pdImage = new PDImageXObject(document, encodedByteStream, COSName.CCITTFAX_DECODE, decodeParms.getInt(COSName.COLUMNS), decodeParms.getInt(COSName.ROWS), 1, PDDeviceGray.INSTANCE);    COSDictionary dict = pdImage.getCOSObject();    dict.setItem(COSName.DECODE_PARMS, decodeParms);    return pdImage;}
private static void pdfbox_f5188_0(RandomAccess reader, OutputStream os, COSDictionary params, int number) throws IOException
{    try {                reader.seek(0);        char endianess = (char) reader.read();        if ((char) reader.read() != endianess) {            throw new IOException("Not a valid tiff file");        }                if (endianess != 'M' && endianess != 'I') {            throw new IOException("Not a valid tiff file");        }        int magicNumber = readshort(endianess, reader);        if (magicNumber != 42) {            throw new IOException("Not a valid tiff file");        }                int address = readlong(endianess, reader);        reader.seek(address);                for (int i = 0; i < number; i++) {            int numtags = readshort(endianess, reader);            if (numtags > 50) {                throw new IOException("Not a valid tiff file");            }            reader.seek(address + 2 + numtags * 12);            address = readlong(endianess, reader);            if (address == 0) {                return;            }            reader.seek(address);        }        int numtags = readshort(endianess, reader);                if (numtags > 50) {            throw new IOException("Not a valid tiff file");        }                                                int k = -1000;        int dataoffset = 0;        int datalength = 0;        for (int i = 0; i < numtags; i++) {            int tag = readshort(endianess, reader);            int type = readshort(endianess, reader);            int count = readlong(endianess, reader);            int val;                        switch(type) {                case                 1:                    val = reader.read();                    reader.read();                    reader.read();                    reader.read();                    break;                case                 3:                    val = readshort(endianess, reader);                    reader.read();                    reader.read();                    break;                default:                                        val = readlong(endianess, reader);                    break;            }            switch(tag) {                case 256:                    {                        params.setInt(COSName.COLUMNS, val);                        break;                    }                case 257:                    {                        params.setInt(COSName.ROWS, val);                        break;                    }                case 259:                    {                        if (val == 4) {                            k = -1;                        }                        if (val == 3) {                            k = 0;                        }                                                break;                    }                case 262:                    {                        if (val == 1) {                            params.setBoolean(COSName.BLACK_IS_1, true);                        }                        break;                    }                case 266:                    {                        if (val != 1) {                            throw new IOException("FillOrder " + val + " is not supported");                        }                        break;                    }                case 273:                    {                        if (count == 1) {                            dataoffset = val;                        }                        break;                    }                case 274:                    {                                                if (val != 1) {                            throw new IOException("Orientation " + val + " is not supported");                        }                        break;                    }                case 279:                    {                        if (count == 1) {                            datalength = val;                        }                        break;                    }                case 292:                    {                        if ((val & 1) != 0) {                                                        k = 50;                        }                                                if ((val & 4) != 0) {                            throw new IOException("CCITT Group 3 'uncompressed mode' is not supported");                        }                        if ((val & 2) != 0) {                            throw new IOException("CCITT Group 3 'fill bits before EOL' is not supported");                        }                        break;                    }                case 324:                    {                        if (count == 1) {                            dataoffset = val;                        }                        break;                    }                case 325:                    {                        if (count == 1) {                            datalength = val;                        }                        break;                    }                default:                    {                                        }            }        }        if (k == -1000) {            throw new IOException("First image in tiff is not CCITT T4 or T6 compressed");        }        if (dataoffset == 0) {            throw new IOException("First image in tiff is not a single tile/strip");        }        params.setInt(COSName.K, k);        reader.seek(dataoffset);        byte[] buf = new byte[8192];        int amountRead;        while ((amountRead = reader.read(buf, 0, Math.min(8192, datalength))) > 0) {            datalength -= amountRead;            os.write(buf, 0, amountRead);        }    } finally {        os.close();    }}
private static int pdfbox_f5189_0(char endianess, RandomAccess raf) throws IOException
{    if (endianess == 'I') {        return raf.read() | (raf.read() << 8);    }    return (raf.read() << 8) | raf.read();}
private static int pdfbox_f5190_0(char endianess, RandomAccess raf) throws IOException
{    if (endianess == 'I') {        return raf.read() | (raf.read() << 8) | (raf.read() << 16) | (raf.read() << 24);    }    return (raf.read() << 24) | (raf.read() << 16) | (raf.read() << 8) | raf.read();}
public static PDImageXObject pdfbox_f5191_0(PDDocument document, InputStream stream) throws IOException
{    return createFromByteArray(document, IOUtils.toByteArray(stream));}
public static PDImageXObject pdfbox_f5192_0(PDDocument document, byte[] byteArray) throws IOException
{        ByteArrayInputStream byteStream = new ByteArrayInputStream(byteArray);        Raster raster = readJPEGRaster(byteStream);    byteStream.reset();    PDColorSpace colorSpace;    switch(raster.getNumDataElements()) {        case 1:            colorSpace = PDDeviceGray.INSTANCE;            break;        case 3:            colorSpace = PDDeviceRGB.INSTANCE;            break;        case 4:            colorSpace = PDDeviceCMYK.INSTANCE;            break;        default:            throw new UnsupportedOperationException("number of data elements not supported: " + raster.getNumDataElements());    }        PDImageXObject pdImage = new PDImageXObject(document, byteStream, COSName.DCT_DECODE, raster.getWidth(), raster.getHeight(), 8, colorSpace);    if (colorSpace instanceof PDDeviceCMYK) {        COSArray decode = new COSArray();        decode.add(COSInteger.ONE);        decode.add(COSInteger.ZERO);        decode.add(COSInteger.ONE);        decode.add(COSInteger.ZERO);        decode.add(COSInteger.ONE);        decode.add(COSInteger.ZERO);        decode.add(COSInteger.ONE);        decode.add(COSInteger.ZERO);        pdImage.setDecode(decode);    }    return pdImage;}
private static Raster pdfbox_f5193_0(InputStream stream) throws IOException
{        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("JPEG");    ImageReader reader = null;    while (readers.hasNext()) {        reader = readers.next();        if (reader.canReadRaster()) {            break;        }    }    if (reader == null) {        throw new MissingImageReaderException("Cannot read JPEG image: a suitable JAI I/O image filter is not installed");    }    try (ImageInputStream iis = ImageIO.createImageInputStream(stream)) {        reader.setInput(iis);        ImageIO.setUseCache(false);        return reader.readRaster(0, null);    } finally {        reader.dispose();    }}
public static PDImageXObject pdfbox_f5194_0(PDDocument document, BufferedImage image) throws IOException
{    return createFromImage(document, image, 0.75f);}
public static PDImageXObject pdfbox_f5195_0(PDDocument document, BufferedImage image, float quality) throws IOException
{    return createFromImage(document, image, quality, 72);}
public static PDImageXObject pdfbox_f5196_0(PDDocument document, BufferedImage image, float quality, int dpi) throws IOException
{    return createJPEG(document, image, quality, dpi);}
private static BufferedImage pdfbox_f5197_0(BufferedImage image) throws IOException
{    if (!image.getColorModel().hasAlpha()) {        return null;    }    if (image.getTransparency() == Transparency.BITMASK) {        throw new UnsupportedOperationException("BITMASK Transparency JPEG compression is not" + " useful, use LosslessImageFactory instead");    }    WritableRaster alphaRaster = image.getAlphaRaster();    if (alphaRaster == null) {                return null;    }    BufferedImage alphaImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);    alphaImage.setData(alphaRaster);    return alphaImage;}
private static PDImageXObject pdfbox_f5198_0(PDDocument document, BufferedImage image, float quality, int dpi) throws IOException
{        BufferedImage awtColorImage = getColorImage(image);    BufferedImage awtAlphaImage = getAlphaImage(image);        ByteArrayOutputStream baos = new ByteArrayOutputStream();    encodeImageToJPEGStream(awtColorImage, quality, dpi, baos);    ByteArrayInputStream byteStream = new ByteArrayInputStream(baos.toByteArray());    PDImageXObject pdImage = new PDImageXObject(document, byteStream, COSName.DCT_DECODE, awtColorImage.getWidth(), awtColorImage.getHeight(), awtColorImage.getColorModel().getComponentSize(0), getColorSpaceFromAWT(awtColorImage));        if (awtAlphaImage != null) {        PDImage xAlpha = JPEGFactory.createFromImage(document, awtAlphaImage, quality);        pdImage.getCOSObject().setItem(COSName.SMASK, xAlpha);    }    return pdImage;}
private static ImageWriter pdfbox_f5199_0() throws IOException
{    ImageWriter writer = null;    Iterator<ImageWriter> writers = ImageIO.getImageWritersBySuffix("jpeg");    while (writers.hasNext()) {        if (writer != null) {            writer.dispose();        }        writer = writers.next();        if (writer == null) {            continue;        }                if (writer.getDefaultWriteParam() instanceof JPEGImageWriteParam) {            return writer;        }    }    throw new IOException("No ImageWriter found for JPEG format");}
private static void pdfbox_f5200_0(BufferedImage image, float quality, int dpi, OutputStream out) throws IOException
{        ImageOutputStream ios = null;    ImageWriter imageWriter = null;    try {                imageWriter = getJPEGImageWriter();        ios = ImageIO.createImageOutputStream(out);        imageWriter.setOutput(ios);                JPEGImageWriteParam jpegParam = (JPEGImageWriteParam) imageWriter.getDefaultWriteParam();        jpegParam.setCompressionMode(JPEGImageWriteParam.MODE_EXPLICIT);        jpegParam.setCompressionQuality(quality);                ImageTypeSpecifier imageTypeSpecifier = new ImageTypeSpecifier(image);        IIOMetadata data = imageWriter.getDefaultImageMetadata(imageTypeSpecifier, jpegParam);        Element tree = (Element) data.getAsTree("javax_imageio_jpeg_image_1.0");        Element jfif = (Element) tree.getElementsByTagName("app0JFIF").item(0);        jfif.setAttribute("Xdensity", Integer.toString(dpi));        jfif.setAttribute("Ydensity", Integer.toString(dpi));                jfif.setAttribute("resUnits", "1");                imageWriter.write(data, new IIOImage(image, null, null), jpegParam);    } finally {                IOUtils.closeQuietly(out);        if (ios != null) {            ios.close();        }        if (imageWriter != null) {            imageWriter.dispose();        }    }}
private static PDColorSpace pdfbox_f5201_0(BufferedImage awtImage)
{    if (awtImage.getColorModel().getNumComponents() == 1) {                return PDDeviceGray.INSTANCE;    }    ColorSpace awtColorSpace = awtImage.getColorModel().getColorSpace();    if (awtColorSpace instanceof ICC_ColorSpace && !awtColorSpace.isCS_sRGB()) {        throw new UnsupportedOperationException("ICC color spaces not implemented");    }    switch(awtColorSpace.getType()) {        case ColorSpace.TYPE_RGB:            return PDDeviceRGB.INSTANCE;        case ColorSpace.TYPE_GRAY:            return PDDeviceGray.INSTANCE;        case ColorSpace.TYPE_CMYK:            return PDDeviceCMYK.INSTANCE;        default:            throw new UnsupportedOperationException("color space not implemented: " + awtColorSpace.getType());    }}
private static BufferedImage pdfbox_f5202_0(BufferedImage image)
{    if (!image.getColorModel().hasAlpha()) {        return image;    }    if (image.getColorModel().getColorSpace().getType() != ColorSpace.TYPE_RGB) {        throw new UnsupportedOperationException("only RGB color spaces are implemented");    }                        BufferedImage rgbImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);    return new ColorConvertOp(null).filter(image, rgbImage);}
public static PDImageXObject pdfbox_f5203_0(PDDocument document, BufferedImage image) throws IOException
{    if ((image.getType() == BufferedImage.TYPE_BYTE_GRAY && image.getColorModel().getPixelSize() <= 8) || (image.getType() == BufferedImage.TYPE_BYTE_BINARY && image.getColorModel().getPixelSize() == 1)) {        return createFromGrayImage(image, document);    } else {                if (usePredictorEncoder) {            PDImageXObject pdImageXObject = new PredictorEncoder(document, image).encode();            if (pdImageXObject != null) {                if (pdImageXObject.getColorSpace() == PDDeviceRGB.INSTANCE && pdImageXObject.getBitsPerComponent() < 16 && image.getWidth() * image.getHeight() <= 50 * 50) {                                        PDImageXObject pdImageXObjectClassic = createFromRGBImage(image, document);                    if (pdImageXObjectClassic.getCOSObject().getLength() < pdImageXObject.getCOSObject().getLength()) {                        pdImageXObject.getCOSObject().close();                        return pdImageXObjectClassic;                    } else {                        pdImageXObjectClassic.getCOSObject().close();                    }                }                return pdImageXObject;            }        }                return createFromRGBImage(image, document);    }}
private static PDImageXObject pdfbox_f5204_0(BufferedImage image, PDDocument document) throws IOException
{    int height = image.getHeight();    int width = image.getWidth();    int[] rgbLineBuffer = new int[width];    int bpc = image.getColorModel().getPixelSize();    ByteArrayOutputStream baos = new ByteArrayOutputStream(((width * bpc / 8) + (width * bpc % 8 != 0 ? 1 : 0)) * height);    try (MemoryCacheImageOutputStream mcios = new MemoryCacheImageOutputStream(baos)) {        for (int y = 0; y < height; ++y) {            for (int pixel : image.getRGB(0, y, width, 1, rgbLineBuffer, 0, width)) {                mcios.writeBits(pixel & 0xFF, bpc);            }            int bitOffset = mcios.getBitOffset();            if (bitOffset != 0) {                mcios.writeBits(0, 8 - bitOffset);            }        }        mcios.flush();    }    return prepareImageXObject(document, baos.toByteArray(), image.getWidth(), image.getHeight(), bpc, PDDeviceGray.INSTANCE);}
private static PDImageXObject pdfbox_f5205_0(BufferedImage image, PDDocument document) throws IOException
{    int height = image.getHeight();    int width = image.getWidth();    int[] rgbLineBuffer = new int[width];    int bpc = 8;    PDDeviceColorSpace deviceColorSpace = PDDeviceRGB.INSTANCE;    byte[] imageData = new byte[width * height * 3];    int byteIdx = 0;    int alphaByteIdx = 0;    int alphaBitPos = 7;    int transparency = image.getTransparency();    int apbc = transparency == Transparency.BITMASK ? 1 : 8;    byte[] alphaImageData;    if (transparency != Transparency.OPAQUE) {        alphaImageData = new byte[((width * apbc / 8) + (width * apbc % 8 != 0 ? 1 : 0)) * height];    } else {        alphaImageData = new byte[0];    }    for (int y = 0; y < height; ++y) {        for (int pixel : image.getRGB(0, y, width, 1, rgbLineBuffer, 0, width)) {            imageData[byteIdx++] = (byte) ((pixel >> 16) & 0xFF);            imageData[byteIdx++] = (byte) ((pixel >> 8) & 0xFF);            imageData[byteIdx++] = (byte) (pixel & 0xFF);            if (transparency != Transparency.OPAQUE) {                                if (transparency == Transparency.BITMASK) {                                        alphaImageData[alphaByteIdx] |= ((pixel >> 24) & 1) << alphaBitPos;                    if (--alphaBitPos < 0) {                        alphaBitPos = 7;                        ++alphaByteIdx;                    }                } else {                                        alphaImageData[alphaByteIdx++] = (byte) ((pixel >> 24) & 0xFF);                }            }        }                if (transparency == Transparency.BITMASK && alphaBitPos != 7) {            alphaBitPos = 7;            ++alphaByteIdx;        }    }    PDImageXObject pdImage = prepareImageXObject(document, imageData, image.getWidth(), image.getHeight(), bpc, deviceColorSpace);    if (transparency != Transparency.OPAQUE) {        PDImageXObject pdMask = prepareImageXObject(document, alphaImageData, image.getWidth(), image.getHeight(), apbc, PDDeviceGray.INSTANCE);        pdImage.getCOSObject().setItem(COSName.SMASK, pdMask);    }    return pdImage;}
 static PDImageXObject pdfbox_f5206_0(PDDocument document, byte[] byteArray, int width, int height, int bitsPerComponent, PDColorSpace initColorSpace) throws IOException
{        ByteArrayOutputStream baos = new ByteArrayOutputStream(byteArray.length / 2);    Filter filter = FilterFactory.INSTANCE.getFilter(COSName.FLATE_DECODE);    filter.encode(new ByteArrayInputStream(byteArray), baos, new COSDictionary(), 0);    ByteArrayInputStream encodedByteStream = new ByteArrayInputStream(baos.toByteArray());    return new PDImageXObject(document, encodedByteStream, COSName.FLATE_DECODE, width, height, bitsPerComponent, initColorSpace);}
 PDImageXObject pdfbox_f5207_0() throws IOException
{    Raster imageRaster = image.getRaster();    final int elementsInRowPerPixel;            Object prevRow;    Object transferRow;    switch(imageType) {        case BufferedImage.TYPE_CUSTOM:            {                switch(imageRaster.getTransferType()) {                    case DataBuffer.TYPE_USHORT:                        elementsInRowPerPixel = componentsPerPixel;                        prevRow = new short[width * elementsInRowPerPixel];                        transferRow = new short[width * elementsInRowPerPixel];                        break;                    case DataBuffer.TYPE_BYTE:                        elementsInRowPerPixel = componentsPerPixel;                        prevRow = new byte[width * elementsInRowPerPixel];                        transferRow = new byte[width * elementsInRowPerPixel];                        break;                    default:                        return null;                }                break;            }        case BufferedImage.TYPE_3BYTE_BGR:        case BufferedImage.TYPE_4BYTE_ABGR:            {                elementsInRowPerPixel = componentsPerPixel;                prevRow = new byte[width * elementsInRowPerPixel];                transferRow = new byte[width * elementsInRowPerPixel];                break;            }        case BufferedImage.TYPE_INT_BGR:        case BufferedImage.TYPE_INT_ARGB:        case BufferedImage.TYPE_INT_RGB:            {                elementsInRowPerPixel = 1;                prevRow = new int[width * elementsInRowPerPixel];                transferRow = new int[width * elementsInRowPerPixel];                break;            }        default:                        return null;    }    final int elementsInTransferRow = width * elementsInRowPerPixel;        ByteArrayOutputStream stream = new ByteArrayOutputStream(height * width * bytesPerPixel / 2);    Deflater deflater = new Deflater(Filter.getCompressionLevel());    DeflaterOutputStream zip = new DeflaterOutputStream(stream, deflater);    int alphaPtr = 0;    for (int rowNum = 0; rowNum < height; rowNum++) {        imageRaster.getDataElements(0, rowNum, width, 1, transferRow);                int writerPtr = 1;        Arrays.fill(aValues, (byte) 0);        Arrays.fill(cValues, (byte) 0);        final byte[] transferRowByte;        final byte[] prevRowByte;        final int[] transferRowInt;        final int[] prevRowInt;        final short[] transferRowShort;        final short[] prevRowShort;        if (transferRow instanceof byte[]) {            transferRowByte = (byte[]) transferRow;            prevRowByte = (byte[]) prevRow;            transferRowInt = prevRowInt = null;            transferRowShort = prevRowShort = null;        } else if (transferRow instanceof int[]) {            transferRowInt = (int[]) transferRow;            prevRowInt = (int[]) prevRow;            transferRowShort = prevRowShort = null;            transferRowByte = prevRowByte = null;        } else {                        transferRowShort = (short[]) transferRow;            prevRowShort = (short[]) prevRow;            transferRowInt = prevRowInt = null;            transferRowByte = prevRowByte = null;        }        for (int indexInTransferRow = 0; indexInTransferRow < elementsInTransferRow; indexInTransferRow += elementsInRowPerPixel, alphaPtr += bytesPerComponent) {                        if (transferRowByte != null) {                copyImageBytes(transferRowByte, indexInTransferRow, xValues, alphaImageData, alphaPtr);                copyImageBytes(prevRowByte, indexInTransferRow, bValues, null, 0);            } else if (transferRowInt != null) {                copyIntToBytes(transferRowInt, indexInTransferRow, xValues, alphaImageData, alphaPtr);                copyIntToBytes(prevRowInt, indexInTransferRow, bValues, null, 0);            } else {                                copyShortsToBytes(transferRowShort, indexInTransferRow, xValues, alphaImageData, alphaPtr);                copyShortsToBytes(prevRowShort, indexInTransferRow, bValues, null, 0);            }                        int length = xValues.length;            for (int bytePtr = 0; bytePtr < length; bytePtr++) {                int x = xValues[bytePtr] & 0xFF;                int a = aValues[bytePtr] & 0xFF;                int b = bValues[bytePtr] & 0xFF;                int c = cValues[bytePtr] & 0xFF;                dataRawRowNone[writerPtr] = (byte) x;                dataRawRowSub[writerPtr] = pngFilterSub(x, a);                dataRawRowUp[writerPtr] = pngFilterUp(x, b);                dataRawRowAverage[writerPtr] = pngFilterAverage(x, a, b);                dataRawRowPaeth[writerPtr] = pngFilterPaeth(x, a, b, c);                writerPtr++;            }                        System.arraycopy(xValues, 0, aValues, 0, bytesPerPixel);            System.arraycopy(bValues, 0, cValues, 0, bytesPerPixel);        }        byte[] rowToWrite = chooseDataRowToWrite();                zip.write(rowToWrite, 0, rowToWrite.length);                Object temp = prevRow;        prevRow = transferRow;        transferRow = temp;    }    zip.close();    deflater.end();    return preparePredictorPDImage(stream, bytesPerComponent * 8);}
private void pdfbox_f5208_0(int[] transferRow, int indexInTranferRow, byte[] targetValues, byte[] alphaImageData, int alphaPtr)
{    int val = transferRow[indexInTranferRow];    byte b0 = (byte) (val & 0xFF);    byte b1 = (byte) ((val >> 8) & 0xFF);    byte b2 = (byte) ((val >> 16) & 0xFF);    switch(imageType) {        case BufferedImage.TYPE_INT_BGR:            targetValues[0] = b0;            targetValues[1] = b1;            targetValues[2] = b2;            break;        case BufferedImage.TYPE_INT_ARGB:            targetValues[0] = b2;            targetValues[1] = b1;            targetValues[2] = b0;            if (alphaImageData != null) {                byte b3 = (byte) ((val >> 24) & 0xFF);                alphaImageData[alphaPtr] = b3;            }            break;        case BufferedImage.TYPE_INT_RGB:            targetValues[0] = b2;            targetValues[1] = b1;            targetValues[2] = b0;            break;    }}
private void pdfbox_f5209_0(byte[] transferRow, int indexInTranferRow, byte[] targetValues, byte[] alphaImageData, int alphaPtr)
{    System.arraycopy(transferRow, indexInTranferRow, targetValues, 0, targetValues.length);    if (alphaImageData != null) {        alphaImageData[alphaPtr] = transferRow[indexInTranferRow + targetValues.length];    }}
private static void pdfbox_f5210_0(short[] transferRow, int indexInTranferRow, byte[] targetValues, byte[] alphaImageData, int alphaPtr)
{    int itr = indexInTranferRow;    for (int i = 0; i < targetValues.length; i += 2) {        short val = transferRow[itr++];        targetValues[i] = (byte) ((val >> 8) & 0xFF);        targetValues[i + 1] = (byte) (val & 0xFF);    }    if (alphaImageData != null) {        short alpha = transferRow[itr];        alphaImageData[alphaPtr] = (byte) ((alpha >> 8) & 0xFF);        alphaImageData[alphaPtr + 1] = (byte) (alpha & 0xFF);    }}
private PDImageXObject pdfbox_f5211_0(ByteArrayOutputStream stream, int bitsPerComponent) throws IOException
{    int h = image.getHeight();    int w = image.getWidth();    ColorSpace srcCspace = image.getColorModel().getColorSpace();    int srcCspaceType = srcCspace.getType();    PDColorSpace pdColorSpace = srcCspaceType == ColorSpace.TYPE_CMYK ? PDDeviceCMYK.INSTANCE : (srcCspaceType == ColorSpace.TYPE_GRAY ? PDDeviceGray.INSTANCE : PDDeviceRGB.INSTANCE);        if (srcCspace instanceof ICC_ColorSpace) {        ICC_Profile profile = ((ICC_ColorSpace) srcCspace).getProfile();                if (profile != ICC_Profile.getInstance(ColorSpace.CS_sRGB)) {            PDICCBased pdProfile = new PDICCBased(document);            try (OutputStream outputStream = pdProfile.getPDStream().createOutputStream(COSName.FLATE_DECODE)) {                outputStream.write(profile.getData());            }            pdProfile.getPDStream().getCOSObject().setInt(COSName.N, srcCspace.getNumComponents());            pdProfile.getPDStream().getCOSObject().setItem(COSName.ALTERNATE, srcCspaceType == ColorSpace.TYPE_GRAY ? COSName.DEVICEGRAY : (srcCspaceType == ColorSpace.TYPE_CMYK ? COSName.DEVICECMYK : COSName.DEVICERGB));            pdColorSpace = pdProfile;        }    }    PDImageXObject imageXObject = new PDImageXObject(document, new ByteArrayInputStream(stream.toByteArray()), COSName.FLATE_DECODE, w, h, bitsPerComponent, pdColorSpace);    COSDictionary decodeParms = new COSDictionary();    decodeParms.setItem(COSName.BITS_PER_COMPONENT, COSInteger.get(bitsPerComponent));    decodeParms.setItem(COSName.PREDICTOR, COSInteger.get(15));    decodeParms.setItem(COSName.COLUMNS, COSInteger.get(w));    decodeParms.setItem(COSName.COLORS, COSInteger.get(srcCspace.getNumComponents()));    imageXObject.getCOSObject().setItem(COSName.DECODE_PARMS, decodeParms);    if (image.getTransparency() != Transparency.OPAQUE) {        PDImageXObject pdMask = prepareImageXObject(document, alphaImageData, image.getWidth(), image.getHeight(), 8 * bytesPerComponent, PDDeviceGray.INSTANCE);        imageXObject.getCOSObject().setItem(COSName.SMASK, pdMask);    }    return imageXObject;}
private byte[] pdfbox_f5212_0()
{    byte[] rowToWrite = dataRawRowNone;    long estCompressSum = estCompressSum(dataRawRowNone);    long estCompressSumSub = estCompressSum(dataRawRowSub);    long estCompressSumUp = estCompressSum(dataRawRowUp);    long estCompressSumAvg = estCompressSum(dataRawRowAverage);    long estCompressSumPaeth = estCompressSum(dataRawRowPaeth);    if (estCompressSum > estCompressSumSub) {        rowToWrite = dataRawRowSub;        estCompressSum = estCompressSumSub;    }    if (estCompressSum > estCompressSumUp) {        rowToWrite = dataRawRowUp;        estCompressSum = estCompressSumUp;    }    if (estCompressSum > estCompressSumAvg) {        rowToWrite = dataRawRowAverage;        estCompressSum = estCompressSumAvg;    }    if (estCompressSum > estCompressSumPaeth) {        rowToWrite = dataRawRowPaeth;    }    return rowToWrite;}
private static byte pdfbox_f5213_0(int x, int a)
{    return (byte) ((x & 0xFF) - (a & 0xFF));}
private static byte pdfbox_f5214_0(int x, int b)
{        return pngFilterSub(x, b);}
private static byte pdfbox_f5215_0(int x, int a, int b)
{    return (byte) (x - ((b + a) / 2));}
private static byte pdfbox_f5216_0(int x, int a, int b, int c)
{    int p = a + b - c;    int pa = Math.abs(p - a);    int pb = Math.abs(p - b);    int pc = Math.abs(p - c);    final int pr;    if (pa <= pb && pa <= pc) {        pr = a;    } else if (pb <= pc) {        pr = b;    } else {        pr = c;    }    int r = x - pr;    return (byte) (r);}
private static long pdfbox_f5217_0(byte[] dataRawRowSub)
{    long sum = 0;    for (byte aDataRawRowSub : dataRawRowSub) {                sum += Math.abs(aDataRawRowSub);    }    return sum;}
public static PDImageXObject pdfbox_f5218_0(COSStream cosStream) throws IOException
{        PDStream pdStream = new PDStream(cosStream);    return new PDImageXObject(pdStream, null);}
private static COSStream pdfbox_f5219_0(PDDocument document, InputStream rawInput) throws IOException
{    COSStream stream = document.getDocument().createCOSStream();    try (OutputStream output = stream.createRawOutputStream()) {        IOUtils.copy(rawInput, output);    }    return stream;}
public static PDImageXObject pdfbox_f5220_0(String imagePath, PDDocument doc) throws IOException
{    return createFromFileByExtension(new File(imagePath), doc);}
public static PDImageXObject pdfbox_f5221_0(File file, PDDocument doc) throws IOException
{    String name = file.getName();    int dot = file.getName().lastIndexOf('.');    if (dot == -1) {        throw new IllegalArgumentException("Image type not supported: " + name);    }    String ext = name.substring(dot + 1).toLowerCase();    if ("jpg".equals(ext) || "jpeg".equals(ext)) {        try (FileInputStream fis = new FileInputStream(file)) {            return JPEGFactory.createFromStream(doc, fis);        }    }    if ("tif".equals(ext) || "tiff".equals(ext)) {        return CCITTFactory.createFromFile(doc, file);    }    if ("gif".equals(ext) || "bmp".equals(ext) || "png".equals(ext)) {        BufferedImage bim = ImageIO.read(file);        return LosslessFactory.createFromImage(doc, bim);    }    throw new IllegalArgumentException("Image type not supported: " + name);}
public static PDImageXObject pdfbox_f5222_1(File file, PDDocument doc) throws IOException
{    FileType fileType = null;    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {        fileType = FileTypeDetector.detectFileType(bufferedInputStream);    } catch (IOException e) {        throw new IOException("Could not determine file type: " + file.getName(), e);    }    if (fileType == null) {        throw new IllegalArgumentException("Image type not supported: " + file.getName());    }    if (fileType.equals(FileType.JPEG)) {        try (FileInputStream fis = new FileInputStream(file)) {            return JPEGFactory.createFromStream(doc, fis);        }    }    if (fileType.equals(FileType.TIFF)) {        try {            return CCITTFactory.createFromFile(doc, file);        } catch (IOException ex) {                                                            fileType = FileType.PNG;        }    }    if (fileType.equals(FileType.BMP) || fileType.equals(FileType.GIF) || fileType.equals(FileType.PNG)) {        BufferedImage bim = ImageIO.read(file);        return LosslessFactory.createFromImage(doc, bim);    }    throw new IllegalArgumentException("Image type " + fileType + " not supported: " + file.getName());}
public static PDImageXObject pdfbox_f5223_1(PDDocument document, byte[] byteArray, String name) throws IOException
{    FileType fileType;    try {        fileType = FileTypeDetector.detectFileType(byteArray);    } catch (IOException e) {        throw new IOException("Could not determine file type: " + name, e);    }    if (fileType == null) {        throw new IllegalArgumentException("Image type not supported: " + name);    }    if (fileType.equals(FileType.JPEG)) {        return JPEGFactory.createFromByteArray(document, byteArray);    }    if (fileType.equals(FileType.PNG)) {                PDImageXObject image = PNGConverter.convertPNGImage(document, byteArray);        if (image != null) {            return image;        }    }    if (fileType.equals(FileType.TIFF)) {        try {            return CCITTFactory.createFromByteArray(document, byteArray);        } catch (IOException ex) {                                                            fileType = FileType.PNG;        }    }    if (fileType.equals(FileType.BMP) || fileType.equals(FileType.GIF) || fileType.equals(FileType.PNG)) {        ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);        BufferedImage bim = ImageIO.read(bais);        return LosslessFactory.createFromImage(document, bim);    }    throw new IllegalArgumentException("Image type " + fileType + " not supported: " + name);}
public PDMetadata pdfbox_f5224_0()
{    COSStream cosStream = getCOSObject().getCOSStream(COSName.METADATA);    if (cosStream != null) {        return new PDMetadata(cosStream);    }    return null;}
public void pdfbox_f5225_0(PDMetadata meta)
{    getCOSObject().setItem(COSName.METADATA, meta);}
public int pdfbox_f5226_0()
{    return getCOSObject().getInt(COSName.STRUCT_PARENT);}
public void pdfbox_f5227_0(int key)
{    getCOSObject().setInt(COSName.STRUCT_PARENT, key);}
public BufferedImage pdfbox_f5228_0() throws IOException
{    return getImage(null, 1);}
public BufferedImage pdfbox_f5229_0(Rectangle region, int subsampling) throws IOException
{    if (region == null && subsampling == cachedImageSubsampling && cachedImage != null) {        BufferedImage cached = cachedImage.get();        if (cached != null) {            return cached;        }    }        BufferedImage image = SampledImageReader.getRGBImage(this, region, subsampling, getColorKeyMask());        PDImageXObject softMask = getSoftMask();    if (softMask != null) {        float[] matte = extractMatte(softMask);        image = applyMask(image, softMask.getOpaqueImage(), true, matte);    } else {                PDImageXObject mask = getMask();        if (mask != null && mask.isStencil()) {            image = applyMask(image, mask.getOpaqueImage(), false, null);        }    }    if (region == null && subsampling <= cachedImageSubsampling) {                        cachedImageSubsampling = subsampling;        cachedImage = new SoftReference<>(image);    }    return image;}
private float[] pdfbox_f5230_0(PDImageXObject softMask) throws IOException
{    COSBase base = softMask.getCOSObject().getItem(COSName.MATTE);    float[] matte = null;    if (base instanceof COSArray) {                        matte = ((COSArray) base).toFloatArray();                matte = getColorSpace().toRGB(matte);    }    return matte;}
public BufferedImage pdfbox_f5231_0(Paint paint) throws IOException
{    if (!isStencil()) {        throw new IllegalStateException("Image is not a stencil");    }    return SampledImageReader.getStencilImage(this, paint);}
public BufferedImage pdfbox_f5232_0() throws IOException
{    return SampledImageReader.getRGBImage(this, null);}
private BufferedImage pdfbox_f5233_0(BufferedImage image, BufferedImage mask, boolean isSoft, float[] matte) throws IOException
{    if (mask == null) {        return image;    }    int width = image.getWidth();    int height = image.getHeight();        if (mask.getWidth() < width || mask.getHeight() < height) {        mask = scaleImage(mask, width, height);    } else if (mask.getWidth() > width || mask.getHeight() > height) {        width = mask.getWidth();        height = mask.getHeight();        image = scaleImage(image, width, height);    } else if (image.getRaster().getPixel(0, 0, (int[]) null).length < 3) {                image = scaleImage(image, width, height);    }        BufferedImage masked = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);    WritableRaster src = image.getRaster();    WritableRaster dest = masked.getRaster();    WritableRaster alpha = mask.getRaster();    float[] rgb = new float[4];    float[] rgba = new float[4];    float[] alphaPixel = null;    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            src.getPixel(x, y, rgb);            rgba[0] = rgb[0];            rgba[1] = rgb[1];            rgba[2] = rgb[2];            alphaPixel = alpha.getPixel(x, y, alphaPixel);            if (isSoft) {                rgba[3] = alphaPixel[0];                if (matte != null && Float.compare(alphaPixel[0], 0) != 0) {                    rgba[0] = clampColor(((rgba[0] / 255 - matte[0]) / (alphaPixel[0] / 255) + matte[0]) * 255);                    rgba[1] = clampColor(((rgba[1] / 255 - matte[1]) / (alphaPixel[0] / 255) + matte[1]) * 255);                    rgba[2] = clampColor(((rgba[2] / 255 - matte[2]) / (alphaPixel[0] / 255) + matte[2]) * 255);                }            } else {                rgba[3] = 255 - alphaPixel[0];            }            dest.setPixel(x, y, rgba);        }    }    return masked;}
private float pdfbox_f5234_0(float color)
{    return color < 0 ? 0 : (color > 255 ? 255 : color);}
private BufferedImage pdfbox_f5235_0(BufferedImage image, int width, int height)
{    BufferedImage image2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    Graphics2D g = image2.createGraphics();    if (getInterpolate()) {        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);    }    g.drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(), image.getHeight(), null);    g.dispose();    return image2;}
public PDImageXObject pdfbox_f5236_0() throws IOException
{    COSBase mask = getCOSObject().getDictionaryObject(COSName.MASK);    if (mask instanceof COSArray) {                return null;    } else {        COSStream cosStream = getCOSObject().getCOSStream(COSName.MASK);        if (cosStream != null) {                        return new PDImageXObject(new PDStream(cosStream), null);        }        return null;    }}
public COSArray pdfbox_f5237_0()
{    COSBase mask = getCOSObject().getDictionaryObject(COSName.MASK);    if (mask instanceof COSArray) {        return (COSArray) mask;    }    return null;}
public PDImageXObject pdfbox_f5238_0() throws IOException
{    COSStream cosStream = getCOSObject().getCOSStream(COSName.SMASK);    if (cosStream != null) {                return new PDImageXObject(new PDStream(cosStream), null);    }    return null;}
public int pdfbox_f5239_0()
{    if (isStencil()) {        return 1;    } else {        return getCOSObject().getInt(COSName.BITS_PER_COMPONENT, COSName.BPC);    }}
public void pdfbox_f5240_0(int bpc)
{    getCOSObject().setInt(COSName.BITS_PER_COMPONENT, bpc);}
public PDColorSpace pdfbox_f5241_0() throws IOException
{    if (colorSpace == null) {        COSBase cosBase = getCOSObject().getItem(COSName.COLORSPACE, COSName.CS);        if (cosBase != null) {            COSObject indirect = null;            if (cosBase instanceof COSObject && resources != null && resources.getResourceCache() != null) {                                                indirect = (COSObject) cosBase;                colorSpace = resources.getResourceCache().getColorSpace(indirect);                if (colorSpace != null) {                    return colorSpace;                }            }            colorSpace = PDColorSpace.create(cosBase, resources);            if (indirect != null) {                resources.getResourceCache().put(indirect, colorSpace);            }        } else if (isStencil()) {                        return PDDeviceGray.INSTANCE;        } else {                        throw new IOException("could not determine color space");        }    }    return colorSpace;}
public InputStream pdfbox_f5242_0() throws IOException
{    return getStream().createInputStream();}
public InputStream pdfbox_f5243_0(DecodeOptions options) throws IOException
{    return getStream().createInputStream(options);}
public InputStream pdfbox_f5244_0(List<String> stopFilters) throws IOException
{    return getStream().createInputStream(stopFilters);}
public boolean pdfbox_f5245_0()
{    return getStream().getCOSObject().getLength() == 0;}
public void pdfbox_f5246_0(PDColorSpace cs)
{    getCOSObject().setItem(COSName.COLORSPACE, cs != null ? cs.getCOSObject() : null);    colorSpace = null;    cachedImage = null;}
public int pdfbox_f5247_0()
{    return getCOSObject().getInt(COSName.HEIGHT);}
public void pdfbox_f5248_0(int h)
{    getCOSObject().setInt(COSName.HEIGHT, h);}
public int pdfbox_f5249_0()
{    return getCOSObject().getInt(COSName.WIDTH);}
public void pdfbox_f5250_0(int w)
{    getCOSObject().setInt(COSName.WIDTH, w);}
public boolean pdfbox_f5251_0()
{    return getCOSObject().getBoolean(COSName.INTERPOLATE, false);}
public void pdfbox_f5252_0(boolean value)
{    getCOSObject().setBoolean(COSName.INTERPOLATE, value);}
public void pdfbox_f5253_0(COSArray decode)
{    getCOSObject().setItem(COSName.DECODE, decode);}
public COSArray pdfbox_f5254_0()
{    COSBase decode = getCOSObject().getDictionaryObject(COSName.DECODE);    if (decode instanceof COSArray) {        return (COSArray) decode;    }    return null;}
public boolean pdfbox_f5255_0()
{    return getCOSObject().getBoolean(COSName.IMAGE_MASK, false);}
public void pdfbox_f5256_0(boolean isStencil)
{    getCOSObject().setBoolean(COSName.IMAGE_MASK, isStencil);}
public String pdfbox_f5257_1()
{    List<COSName> filters = getStream().getFilters();    if (filters == null) {        return "png";    } else if (filters.contains(COSName.DCT_DECODE)) {        return "jpg";    } else if (filters.contains(COSName.JPX_DECODE)) {        return "jpx";    } else if (filters.contains(COSName.CCITTFAX_DECODE)) {        return "tiff";    } else if (filters.contains(COSName.FLATE_DECODE) || filters.contains(COSName.LZW_DECODE) || filters.contains(COSName.RUN_LENGTH_DECODE)) {        return "png";    } else if (filters.contains(COSName.JBIG2_DECODE)) {        return "jb2";    } else {                return null;    }}
public COSBase pdfbox_f5258_0()
{    return parameters;}
public int pdfbox_f5259_0()
{    if (isStencil()) {        return 1;    } else {        return parameters.getInt(COSName.BPC, COSName.BITS_PER_COMPONENT, -1);    }}
public void pdfbox_f5260_0(int bitsPerComponent)
{    parameters.setInt(COSName.BPC, bitsPerComponent);}
public PDColorSpace pdfbox_f5261_0() throws IOException
{    COSBase cs = parameters.getDictionaryObject(COSName.CS, COSName.COLORSPACE);    if (cs != null) {        return createColorSpace(cs);    } else if (isStencil()) {                return PDDeviceGray.INSTANCE;    } else {                throw new IOException("could not determine inline image color space");    }}
private COSBase pdfbox_f5262_0(COSBase cs)
{    if (COSName.RGB.equals(cs)) {        return COSName.DEVICERGB;    }    if (COSName.CMYK.equals(cs)) {        return COSName.DEVICECMYK;    }    if (COSName.G.equals(cs)) {        return COSName.DEVICEGRAY;    }    return cs;}
private PDColorSpace pdfbox_f5263_0(COSBase cs) throws IOException
{    if (cs instanceof COSName) {        return PDColorSpace.create(toLongName(cs), resources);    }    if (cs instanceof COSArray && ((COSArray) cs).size() > 1) {        COSArray srcArray = (COSArray) cs;        COSBase csType = srcArray.get(0);        if (COSName.I.equals(csType) || COSName.INDEXED.equals(csType)) {            COSArray dstArray = new COSArray();            dstArray.addAll(srcArray);            dstArray.set(0, COSName.INDEXED);            dstArray.set(1, toLongName(srcArray.get(1)));            return PDColorSpace.create(dstArray, resources);        }        throw new IOException("Illegal type of inline image color space: " + csType);    }    throw new IOException("Illegal type of object for inline image color space: " + cs);}
public void pdfbox_f5264_0(PDColorSpace colorSpace)
{    COSBase base = null;    if (colorSpace != null) {        base = colorSpace.getCOSObject();    }    parameters.setItem(COSName.CS, base);}
public int pdfbox_f5265_0()
{    return parameters.getInt(COSName.H, COSName.HEIGHT, -1);}
public void pdfbox_f5266_0(int height)
{    parameters.setInt(COSName.H, height);}
public int pdfbox_f5267_0()
{    return parameters.getInt(COSName.W, COSName.WIDTH, -1);}
public void pdfbox_f5268_0(int width)
{    parameters.setInt(COSName.W, width);}
public boolean pdfbox_f5269_0()
{    return parameters.getBoolean(COSName.I, COSName.INTERPOLATE, false);}
public void pdfbox_f5270_0(boolean value)
{    parameters.setBoolean(COSName.I, value);}
public List<String> pdfbox_f5271_0()
{    List<String> names = null;    COSBase filters = parameters.getDictionaryObject(COSName.F, COSName.FILTER);    if (filters instanceof COSName) {        COSName name = (COSName) filters;        names = new COSArrayList<>(name.getName(), name, parameters, COSName.FILTER);    } else if (filters instanceof COSArray) {        names = COSArrayList.convertCOSNameCOSArrayToList((COSArray) filters);    }    return names;}
public void pdfbox_f5272_0(List<String> filters)
{    COSBase obj = COSArrayList.convertStringListToCOSNameCOSArray(filters);    parameters.setItem(COSName.F, obj);}
public void pdfbox_f5273_0(COSArray decode)
{    parameters.setItem(COSName.D, decode);}
public COSArray pdfbox_f5274_0()
{    return (COSArray) parameters.getDictionaryObject(COSName.D, COSName.DECODE);}
public boolean pdfbox_f5275_0()
{    return parameters.getBoolean(COSName.IM, COSName.IMAGE_MASK, false);}
public void pdfbox_f5276_0(boolean isStencil)
{    parameters.setBoolean(COSName.IM, isStencil);}
public InputStream pdfbox_f5277_0() throws IOException
{    return new ByteArrayInputStream(decodedData);}
public InputStream pdfbox_f5278_0(DecodeOptions options) throws IOException
{        return createInputStream();}
public InputStream pdfbox_f5279_0(List<String> stopFilters) throws IOException
{    List<String> filters = getFilters();    ByteArrayInputStream in = new ByteArrayInputStream(rawData);    ByteArrayOutputStream out = new ByteArrayOutputStream(rawData.length);    for (int i = 0; filters != null && i < filters.size(); i++) {                out.reset();        if (stopFilters.contains(filters.get(i))) {            break;        } else {            Filter filter = FilterFactory.INSTANCE.getFilter(filters.get(i));            filter.decode(in, out, parameters, i);            in = new ByteArrayInputStream(out.toByteArray());        }    }    return new ByteArrayInputStream(out.toByteArray());}
public boolean pdfbox_f5280_0()
{    return decodedData.length == 0;}
public byte[] pdfbox_f5281_0()
{    return decodedData;}
public BufferedImage pdfbox_f5282_0() throws IOException
{    return SampledImageReader.getRGBImage(this, null);}
public BufferedImage pdfbox_f5283_0(Rectangle region, int subsampling) throws IOException
{    return SampledImageReader.getRGBImage(this, region, subsampling, null);}
public BufferedImage pdfbox_f5284_0(Paint paint) throws IOException
{    if (!isStencil()) {        throw new IllegalStateException("Image is not a stencil");    }    return SampledImageReader.getStencilImage(this, paint);}
public String pdfbox_f5285_0()
{        return null;}
 static PDImageXObject pdfbox_f5286_0(PDDocument doc, byte[] imageData) throws IOException
{    PNGConverterState state = parsePNGChunks(imageData);    if (!checkConverterState(state)) {                return null;    }    return convertPng(doc, state);}
private static PDImageXObject pdfbox_f5287_1(PDDocument doc, PNGConverterState state) throws IOException
{    Chunk ihdr = state.IHDR;    int ihdrStart = ihdr.start;    int width = readInt(ihdr.bytes, ihdrStart);    int height = readInt(ihdr.bytes, ihdrStart + 4);    int bitDepth = ihdr.bytes[ihdrStart + 8] & 0xFF;    int colorType = ihdr.bytes[ihdrStart + 9] & 0xFF;    int compressionMethod = ihdr.bytes[ihdrStart + 10] & 0xFF;    int filterMethod = ihdr.bytes[ihdrStart + 11] & 0xFF;    int interlaceMethod = ihdr.bytes[ihdrStart + 12] & 0xFF;    if (bitDepth != 1 && bitDepth != 2 && bitDepth != 4 && bitDepth != 8 && bitDepth != 16) {                return null;    }    if (width <= 0 || height <= 0) {                return null;    }    if (compressionMethod != 0) {                return null;    }    if (filterMethod != 0) {                return null;    }    if (interlaceMethod != 0) {                return null;    }    state.width = width;    state.height = height;    state.bitsPerComponent = bitDepth;    switch(colorType) {        case 0:                                    return null;        case 2:                        if (state.tRNS != null) {                                return null;            }            return buildImageObject(doc, state);        case 3:                        return buildIndexImage(doc, state);        case 4:                                    return null;        case 6:                                    return null;        default:                        return null;    }}
private static PDImageXObject pdfbox_f5288_1(PDDocument doc, PNGConverterState state) throws IOException
{    Chunk plte = state.PLTE;    if (plte == null) {                return null;    }    if (plte.length % 3 != 0) {                return null;    }    if (state.bitsPerComponent > 8) {                return null;    }    PDImageXObject image = buildImageObject(doc, state);    if (image == null) {        return null;    }    int highVal = (plte.length / 3) - 1;    if (highVal > 255) {                return null;    }    setupIndexedColorSpace(doc, plte, image, highVal);    if (state.tRNS != null) {        image.getCOSObject().setItem(COSName.SMASK, buildTransparencyMaskFromIndexedData(doc, image, state));    }    return image;}
private static PDImageXObject pdfbox_f5289_0(PDDocument doc, PDImageXObject image, PNGConverterState state) throws IOException
{    Filter flateDecode = FilterFactory.INSTANCE.getFilter(COSName.FLATE_DECODE);    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();    COSDictionary decodeParams = buildDecodeParams(state, PDDeviceGray.INSTANCE);    COSDictionary imageDict = new COSDictionary();    imageDict.setItem(COSName.FILTER, COSName.FLATE_DECODE);    imageDict.setItem(COSName.DECODE_PARMS, decodeParams);    flateDecode.decode(getIDATInputStream(state), outputStream, imageDict, 0);    int length = image.getWidth() * image.getHeight();    byte[] bytes = new byte[length];    byte[] transparencyTable = state.tRNS.getData();    byte[] decodedIDAT = outputStream.toByteArray();    try (ImageInputStream iis = new MemoryCacheImageInputStream(new ByteArrayInputStream(decodedIDAT))) {        int bitsPerComponent = state.bitsPerComponent;        int w = 0;        int neededBits = bitsPerComponent * state.width;        int bitPadding = neededBits % 8;        for (int i = 0; i < bytes.length; i++) {            int idx = (int) iis.readBits(bitsPerComponent);            byte v;            if (idx < transparencyTable.length) {                                v = transparencyTable[idx];            } else {                                v = (byte) 0xFF;            }            bytes[i] = v;            w++;            if (w == state.width) {                w = 0;                iis.readBits(bitPadding);            }        }    }    return LosslessFactory.prepareImageXObject(doc, bytes, image.getWidth(), image.getHeight(), 8, PDDeviceGray.INSTANCE);}
private static void pdfbox_f5290_0(PDDocument doc, Chunk lookupTable, PDImageXObject image, int highVal) throws IOException
{    COSArray indexedArray = new COSArray();    indexedArray.add(COSName.INDEXED);    indexedArray.add(image.getColorSpace());    ((COSDictionary) image.getCOSObject().getItem(COSName.DECODE_PARMS)).setItem(COSName.COLORS, COSInteger.ONE);    indexedArray.add(COSInteger.get(highVal));    PDStream colorTable = new PDStream(doc);    try (OutputStream colorTableStream = colorTable.createOutputStream(COSName.FLATE_DECODE)) {        colorTableStream.write(lookupTable.bytes, lookupTable.start, lookupTable.length);    }    indexedArray.add(colorTable);    PDIndexed indexed = new PDIndexed(indexedArray);    image.setColorSpace(indexed);}
private static PDImageXObject pdfbox_f5291_1(PDDocument document, PNGConverterState state) throws IOException
{    InputStream encodedByteStream = getIDATInputStream(state);    PDColorSpace colorSpace = PDDeviceRGB.INSTANCE;    PDImageXObject imageXObject = new PDImageXObject(document, encodedByteStream, COSName.FLATE_DECODE, state.width, state.height, state.bitsPerComponent, colorSpace);    COSDictionary decodeParams = buildDecodeParams(state, colorSpace);    imageXObject.getCOSObject().setItem(COSName.DECODE_PARMS, decodeParams);            boolean hasICCColorProfile = state.sRGB != null || state.iCCP != null;    if (state.gAMA != null && !hasICCColorProfile) {        if (state.gAMA.length != 4) {                        return null;        }        float gamma = readPNGFloat(state.gAMA.bytes, state.gAMA.start);                if (Math.abs(gamma - (1 / 2.2f)) > 0.00001) {                        return null;        }    }    if (state.sRGB != null) {        if (state.sRGB.length != 1) {                        return null;        }                int renderIntent = state.sRGB.bytes[state.sRGB.start];        COSName value = mapPNGRenderIntent(renderIntent);        imageXObject.getCOSObject().setItem(COSName.INTENT, value);    }    if (state.cHRM != null && !hasICCColorProfile) {        if (state.cHRM.length != 32) {                        return null;        }                return null;    }        if (state.iCCP != null || state.sRGB != null) {                PDICCBased profile = new PDICCBased(document);        COSStream cosStream = profile.getPDStream().getCOSObject();        cosStream.setInt(COSName.N, colorSpace.getNumberOfComponents());        cosStream.setItem(COSName.ALTERNATE, colorSpace.getNumberOfComponents() == 1 ? COSName.DEVICEGRAY : COSName.DEVICERGB);        if (state.iCCP != null) {                        int iccProfileDataStart = 0;            while (iccProfileDataStart < 80 && iccProfileDataStart < state.iCCP.length) {                if (state.iCCP.bytes[state.iCCP.start + iccProfileDataStart] == 0)                    break;                iccProfileDataStart++;            }            if (iccProfileDataStart >= state.iCCP.length) {                                return null;            }            byte compressionMethod = state.iCCP.bytes[state.iCCP.start + iccProfileDataStart];            if (compressionMethod != 0) {                                return null;            }                        iccProfileDataStart++;            try (OutputStream rawOutputStream = cosStream.createRawOutputStream()) {                rawOutputStream.write(state.iCCP.bytes, state.iCCP.start + iccProfileDataStart, state.iCCP.length - iccProfileDataStart);            }        } else {                        ICC_Profile rgbProfile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);            try (OutputStream outputStream = cosStream.createRawOutputStream()) {                outputStream.write(rgbProfile.getData());            }        }        imageXObject.setColorSpace(profile);    }    return imageXObject;}
private static COSDictionary pdfbox_f5292_0(PNGConverterState state, PDColorSpace colorSpace)
{    COSDictionary decodeParms = new COSDictionary();    decodeParms.setItem(COSName.BITS_PER_COMPONENT, COSInteger.get(state.bitsPerComponent));    decodeParms.setItem(COSName.PREDICTOR, COSInteger.get(15));    decodeParms.setItem(COSName.COLUMNS, COSInteger.get(state.width));    decodeParms.setItem(COSName.COLORS, COSInteger.get(colorSpace.getNumberOfComponents()));    return decodeParms;}
private static InputStream pdfbox_f5293_0(PNGConverterState state)
{    MultipleInputStream inputStream = new MultipleInputStream();    for (Chunk idat : state.IDATs) {        inputStream.inputStreams.add(new ByteArrayInputStream(idat.bytes, idat.start, idat.length));    }    return inputStream;}
private boolean pdfbox_f5294_0()
{    if (currentStream == null) {        if (currentStreamIdx >= inputStreams.size()) {            return false;        }        currentStream = inputStreams.get(currentStreamIdx++);    }    return true;}
public int pdfbox_f5295_0() throws IOException
{    throw new IllegalStateException("Only bulk reads are expected!");}
public int pdfbox_f5296_0() throws IOException
{    if (!ensureStream()) {        return 0;    }    return 1;}
public int pdfbox_f5297_0(byte[] b, int off, int len) throws IOException
{    if (!ensureStream()) {        return -1;    }    int ret = currentStream.read(b, off, len);    if (ret == -1) {        currentStream = null;        return read(b, off, len);    }    return ret;}
 static COSName pdfbox_f5298_0(int renderIntent)
{    COSName value;    switch(renderIntent) {        case 0:            value = COSName.PERCEPTUAL;            break;        case 1:            value = COSName.RELATIVE_COLORIMETRIC;            break;        case 2:            value = COSName.SATURATION;            break;        case 3:            value = COSName.ABSOLUTE_COLORIMETRIC;            break;        default:            value = null;            break;    }    return value;}
 static boolean pdfbox_f5299_1(PNGConverterState state)
{    if (state == null) {        return false;    }    if (state.IHDR == null || !checkChunkSane(state.IHDR)) {                return false;    }    if (!checkChunkSane(state.PLTE)) {                return false;    }    if (!checkChunkSane(state.iCCP)) {                return false;    }    if (!checkChunkSane(state.tRNS)) {                return false;    }    if (!checkChunkSane(state.sRGB)) {                return false;    }    if (!checkChunkSane(state.cHRM)) {                return false;    }    if (!checkChunkSane(state.gAMA)) {                return false;    }        if (state.IDATs.isEmpty()) {                return false;    }    for (Chunk idat : state.IDATs) {        if (!checkChunkSane(idat)) {                        return false;        }    }    return true;}
 static boolean pdfbox_f5300_1(Chunk chunk)
{    if (chunk == null) {                return true;    }    if (chunk.start + chunk.length > chunk.bytes.length) {        return false;    }    if (chunk.start < 4) {        return false;    }        int ourCRC = crc(chunk.bytes, chunk.start - 4, chunk.length + 4);    if (ourCRC != chunk.crc) {                return false;    }    return true;}
 byte[] pdfbox_f5301_0()
{    return Arrays.copyOfRange(bytes, start, start + length);}
private static int pdfbox_f5302_0(byte[] data, int offset)
{    int b1 = (data[offset] & 0xFF) << 24;    int b2 = (data[offset + 1] & 0xFF) << 16;    int b3 = (data[offset + 2] & 0xFF) << 8;    int b4 = (data[offset + 3] & 0xFF);    return b1 | b2 | b3 | b4;}
private static float pdfbox_f5303_0(byte[] bytes, int offset)
{    int v = readInt(bytes, offset);    return v / 100000f;}
private static PNGConverterState pdfbox_f5304_1(byte[] imageData)
{    if (imageData.length < 20) {                return null;    }    PNGConverterState state = new PNGConverterState();    int ptr = 8;    int firstChunkType = readInt(imageData, ptr + 4);    if (firstChunkType != CHUNK_IHDR) {                return null;    }    while (ptr + 12 <= imageData.length) {        int chunkLength = readInt(imageData, ptr);        int chunkType = readInt(imageData, ptr + 4);        ptr += 8;        if (ptr + chunkLength + 4 > imageData.length) {                        return null;        }        Chunk chunk = new Chunk();        chunk.chunkType = chunkType;        chunk.bytes = imageData;        chunk.start = ptr;        chunk.length = chunkLength;        switch(chunkType) {            case CHUNK_IHDR:                if (state.IHDR != null) {                                        return null;                }                state.IHDR = chunk;                break;            case CHUNK_IDAT:                                state.IDATs.add(chunk);                break;            case CHUNK_PLTE:                                if (state.PLTE != null) {                                        return null;                }                state.PLTE = chunk;                break;            case CHUNK_IEND:                                return state;            case CHUNK_TRNS:                                if (state.tRNS != null) {                                        return null;                }                state.tRNS = chunk;                break;            case CHUNK_GAMA:                                state.gAMA = chunk;                break;            case CHUNK_CHRM:                                state.cHRM = chunk;                break;            case CHUNK_ICCP:                                state.iCCP = chunk;                break;            case CHUNK_SBIT:                                break;            case CHUNK_SRGB:                                state.sRGB = chunk;                break;            case CHUNK_TEXT:            case CHUNK_ZTXT:            case CHUNK_ITXT:                                break;            case CHUNK_KBKG:                                break;            case CHUNK_HIST:                                break;            case CHUNK_PHYS:                                break;            case CHUNK_SPLT:                                break;            case CHUNK_TIME:                                break;            default:                                break;        }        ptr += chunkLength;                chunk.crc = readInt(imageData, ptr);        ptr += 4;    }        return null;}
private static void pdfbox_f5305_0()
{    int c;    for (int n = 0; n < 256; n++) {        c = n;        for (int k = 0; k < 8; k++) {            if ((c & 1) != 0) {                c = 0xEDB88320 ^ (c >>> 1);            } else {                c = c >>> 1;            }        }        CRC_TABLE[n] = c;    }}
private static int pdfbox_f5306_0(byte[] buf, int offset, int len)
{    int c = -1;    int end = offset + len;    for (int n = offset; n < end; n++) {        c = CRC_TABLE[(c ^ buf[n]) & 0xff] ^ (c >>> 8);    }    return c;}
 static int pdfbox_f5307_0(byte[] buf, int offset, int len)
{    return ~updateCrc(buf, offset, len);}
public static BufferedImage pdfbox_f5308_1(PDImage pdImage, Paint paint) throws IOException
{    int width = pdImage.getWidth();    int height = pdImage.getHeight();        BufferedImage masked = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);    Graphics2D g = masked.createGraphics();                    g.setPaint(paint);    g.fillRect(0, 0, width, height);    g.dispose();        WritableRaster raster = masked.getRaster();    final int[] transparent = new int[4];        try (InputStream iis = pdImage.createInputStream()) {        final float[] decode = getDecodeArray(pdImage);        int value = decode[0] < decode[1] ? 1 : 0;        int rowLen = width / 8;        if (width % 8 > 0) {            rowLen++;        }        byte[] buff = new byte[rowLen];        for (int y = 0; y < height; y++) {            int x = 0;            int readLen = iis.read(buff);            for (int r = 0; r < rowLen && r < readLen; r++) {                int byteValue = buff[r];                int mask = 128;                int shift = 7;                for (int i = 0; i < 8; i++) {                    int bit = (byteValue & mask) >> shift;                    mask >>= 1;                    --shift;                    if (bit == value) {                        raster.setPixel(x, y, transparent);                    }                    x++;                    if (x == width) {                        break;                    }                }            }            if (readLen != rowLen) {                                break;            }        }    }    return masked;}
public static BufferedImage pdfbox_f5309_0(PDImage pdImage, COSArray colorKey) throws IOException
{    return getRGBImage(pdImage, null, 1, colorKey);}
private static Rectangle pdfbox_f5310_0(PDImage pdImage, Rectangle region)
{    if (region == null) {        return new Rectangle(0, 0, pdImage.getWidth(), pdImage.getHeight());    } else {        int x = Math.max(0, region.x);        int y = Math.max(0, region.y);        int width = Math.min(region.width, pdImage.getWidth() - x);        int height = Math.min(region.height, pdImage.getHeight() - y);        return new Rectangle(x, y, width, height);    }}
public static BufferedImage pdfbox_f5311_0(PDImage pdImage, Rectangle region, int subsampling, COSArray colorKey) throws IOException
{    if (pdImage.isEmpty()) {        throw new IOException("Image stream is empty");    }    Rectangle clipped = clipRegion(pdImage, region);        final PDColorSpace colorSpace = pdImage.getColorSpace();    final int numComponents = colorSpace.getNumberOfComponents();    final int width = (int) Math.ceil(clipped.getWidth() / subsampling);    final int height = (int) Math.ceil(clipped.getHeight() / subsampling);    final int bitsPerComponent = pdImage.getBitsPerComponent();    final float[] decode = getDecodeArray(pdImage);    if (width <= 0 || height <= 0 || pdImage.getWidth() <= 0 || pdImage.getHeight() <= 0) {        throw new IOException("image width and height must be positive");    }    try {        if (bitsPerComponent == 1 && colorKey == null && numComponents == 1) {            return from1Bit(pdImage, clipped, subsampling, width, height);        }                                                WritableRaster raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, width, height, numComponents, new Point(0, 0));        final float[] defaultDecode = pdImage.getColorSpace().getDefaultDecode(8);        if (bitsPerComponent == 8 && Arrays.equals(decode, defaultDecode) && colorKey == null) {                        return from8bit(pdImage, raster, clipped, subsampling, width, height);        }        return fromAny(pdImage, raster, colorKey, clipped, subsampling, width, height);    } catch (NegativeArraySizeException ex) {        throw new IOException(ex);    }}
private static BufferedImage pdfbox_f5312_1(PDImage pdImage, Rectangle clipped, final int subsampling, final int width, final int height) throws IOException
{    int currentSubsampling = subsampling;    final PDColorSpace colorSpace = pdImage.getColorSpace();    final float[] decode = getDecodeArray(pdImage);    BufferedImage bim = null;    WritableRaster raster;    byte[] output;    DecodeOptions options = new DecodeOptions(currentSubsampling);    options.setSourceRegion(clipped);        try (InputStream iis = pdImage.createInputStream(options)) {        final int inputWidth;        final int startx;        final int starty;        final int scanWidth;        final int scanHeight;        if (options.isFilterSubsampled()) {                        inputWidth = width;            startx = 0;            starty = 0;            scanWidth = width;            scanHeight = height;            currentSubsampling = 1;        } else {                        inputWidth = pdImage.getWidth();            startx = clipped.x;            starty = clipped.y;            scanWidth = clipped.width;            scanHeight = clipped.height;        }        if (colorSpace instanceof PDDeviceGray) {                                                bim = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);            raster = bim.getRaster();        } else {            raster = Raster.createBandedRaster(DataBuffer.TYPE_BYTE, width, height, 1, new Point(0, 0));        }        output = ((DataBufferByte) raster.getDataBuffer()).getData();        final boolean isIndexed = colorSpace instanceof PDIndexed;        int rowLen = inputWidth / 8;        if (inputWidth % 8 > 0) {            rowLen++;        }                byte value0;        byte value1;        if (isIndexed || decode[0] < decode[1]) {            value0 = 0;            value1 = (byte) 255;        } else {            value0 = (byte) 255;            value1 = 0;        }        byte[] buff = new byte[rowLen];        int idx = 0;        for (int y = 0; y < starty + scanHeight; y++) {            int x = 0;            int readLen = iis.read(buff);            if (y < starty || y % currentSubsampling > 0) {                continue;            }            for (int r = 0; r < rowLen && r < readLen; r++) {                int value = buff[r];                int mask = 128;                for (int i = 0; i < 8; i++) {                    if (x >= startx + scanWidth) {                        break;                    }                    int bit = value & mask;                    mask >>= 1;                    if (x >= startx && x % currentSubsampling == 0) {                        output[idx++] = bit == 0 ? value0 : value1;                    }                    x++;                }            }            if (readLen != rowLen) {                                break;            }        }        if (bim != null) {            return bim;        }                return colorSpace.toRGBImage(raster);    }}
private static BufferedImage pdfbox_f5313_1(PDImage pdImage, WritableRaster raster, Rectangle clipped, final int subsampling, final int width, final int height) throws IOException
{    int currentSubsampling = subsampling;    DecodeOptions options = new DecodeOptions(currentSubsampling);    options.setSourceRegion(clipped);    try (InputStream input = pdImage.createInputStream(options)) {        final int inputWidth;        final int startx;        final int starty;        final int scanWidth;        final int scanHeight;        if (options.isFilterSubsampled()) {                        inputWidth = width;            startx = 0;            starty = 0;            scanWidth = width;            scanHeight = height;            currentSubsampling = 1;        } else {                        inputWidth = pdImage.getWidth();            startx = clipped.x;            starty = clipped.y;            scanWidth = clipped.width;            scanHeight = clipped.height;        }        final int numComponents = pdImage.getColorSpace().getNumberOfComponents();                byte[] bank = ((DataBufferByte) raster.getDataBuffer()).getData();        if (startx == 0 && starty == 0 && scanWidth == width && scanHeight == height && currentSubsampling == 1) {                        long inputResult = input.read(bank);            if (Long.compare(inputResult, width * height * (long) numComponents) != 0) {                            }            return pdImage.getColorSpace().toRGBImage(raster);        }                        byte[] tempBytes = new byte[numComponents * inputWidth];                                int i = 0;        for (int y = 0; y < starty + scanHeight; ++y) {            long inputResult = input.read(tempBytes);            if (Long.compare(inputResult, tempBytes.length) != 0) {                            }            if (y < starty || y % currentSubsampling > 0) {                continue;            }            if (currentSubsampling == 1) {                                                System.arraycopy(tempBytes, startx * numComponents, bank, y * inputWidth * numComponents, scanWidth * numComponents);            } else {                for (int x = startx; x < startx + scanWidth; x += currentSubsampling) {                    for (int c = 0; c < numComponents; c++) {                        bank[i] = tempBytes[x * numComponents + c];                        ++i;                    }                }            }        }                return pdImage.getColorSpace().toRGBImage(raster);    }}
private static BufferedImage pdfbox_f5314_0(PDImage pdImage, WritableRaster raster, COSArray colorKey, Rectangle clipped, final int subsampling, final int width, final int height) throws IOException
{    int currentSubsampling = subsampling;    final PDColorSpace colorSpace = pdImage.getColorSpace();    final int numComponents = colorSpace.getNumberOfComponents();    final int bitsPerComponent = pdImage.getBitsPerComponent();    final float[] decode = getDecodeArray(pdImage);    DecodeOptions options = new DecodeOptions(currentSubsampling);    options.setSourceRegion(clipped);        try (ImageInputStream iis = new MemoryCacheImageInputStream(pdImage.createInputStream(options))) {        final int inputWidth;        final int startx;        final int starty;        final int scanWidth;        final int scanHeight;        if (options.isFilterSubsampled()) {                        inputWidth = width;            startx = 0;            starty = 0;            scanWidth = width;            scanHeight = height;            currentSubsampling = 1;        } else {                        inputWidth = pdImage.getWidth();            startx = clipped.x;            starty = clipped.y;            scanWidth = clipped.width;            scanHeight = clipped.height;        }        final float sampleMax = (float) Math.pow(2, bitsPerComponent) - 1f;        final boolean isIndexed = colorSpace instanceof PDIndexed;                float[] colorKeyRanges = null;        BufferedImage colorKeyMask = null;        if (colorKey != null) {            colorKeyRanges = colorKey.toFloatArray();            colorKeyMask = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);        }                int padding = 0;        if (inputWidth * numComponents * bitsPerComponent % 8 > 0) {            padding = 8 - (inputWidth * numComponents * bitsPerComponent % 8);        }                byte[] srcColorValues = new byte[numComponents];        byte[] alpha = new byte[1];        for (int y = 0; y < starty + scanHeight; y++) {            for (int x = 0; x < startx + scanWidth; x++) {                boolean isMasked = true;                for (int c = 0; c < numComponents; c++) {                    int value = (int) iis.readBits(bitsPerComponent);                                        if (colorKeyRanges != null) {                        isMasked &= value >= colorKeyRanges[c * 2] && value <= colorKeyRanges[c * 2 + 1];                    }                                        final float dMin = decode[c * 2];                    final float dMax = decode[(c * 2) + 1];                                        float output = dMin + (value * ((dMax - dMin) / sampleMax));                    if (isIndexed) {                                                                                                srcColorValues[c] = (byte) Math.round(output);                    } else {                                                int outputByte = Math.round(((output - Math.min(dMin, dMax)) / Math.abs(dMax - dMin)) * 255f);                        srcColorValues[c] = (byte) outputByte;                    }                }                                if (x >= startx && y >= starty && x % currentSubsampling == 0 && y % currentSubsampling == 0) {                    raster.setDataElements((x - startx) / currentSubsampling, (y - starty) / currentSubsampling, srcColorValues);                                        if (colorKeyMask != null) {                        alpha[0] = (byte) (isMasked ? 255 : 0);                        colorKeyMask.getRaster().setDataElements((x - startx) / currentSubsampling, (y - starty) / currentSubsampling, alpha);                    }                }            }                        iis.readBits(padding);        }                BufferedImage rgbImage = colorSpace.toRGBImage(raster);                if (colorKeyMask != null) {            return applyColorKeyMask(rgbImage, colorKeyMask);        } else {            return rgbImage;        }    }}
private static BufferedImage pdfbox_f5315_0(BufferedImage image, BufferedImage mask) throws IOException
{    int width = image.getWidth();    int height = image.getHeight();        BufferedImage masked = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);    WritableRaster src = image.getRaster();    WritableRaster dest = masked.getRaster();    WritableRaster alpha = mask.getRaster();    float[] rgb = new float[3];    float[] rgba = new float[4];    float[] alphaPixel = null;    for (int y = 0; y < height; y++) {        for (int x = 0; x < width; x++) {            src.getPixel(x, y, rgb);            rgba[0] = rgb[0];            rgba[1] = rgb[1];            rgba[2] = rgb[2];            alphaPixel = alpha.getPixel(x, y, alphaPixel);            rgba[3] = 255 - alphaPixel[0];            dest.setPixel(x, y, rgba);        }    }    return masked;}
private static float[] pdfbox_f5316_1(PDImage pdImage) throws IOException
{    final COSArray cosDecode = pdImage.getDecode();    float[] decode = null;    if (cosDecode != null) {        int numberOfComponents = pdImage.getColorSpace().getNumberOfComponents();        if (cosDecode.size() != numberOfComponents * 2) {            if (pdImage.isStencil() && cosDecode.size() >= 2 && cosDecode.get(0) instanceof COSNumber && cosDecode.get(1) instanceof COSNumber) {                float decode0 = ((COSNumber) cosDecode.get(0)).floatValue();                float decode1 = ((COSNumber) cosDecode.get(1)).floatValue();                if (decode0 >= 0 && decode0 <= 1 && decode1 >= 0 && decode1 <= 1) {                                        return new float[] { decode0, decode1 };                }            }                    } else {            decode = cosDecode.toFloatArray();        }    }        if (decode == null) {        return pdImage.getColorSpace().getDefaultDecode(pdImage.getBitsPerComponent());    }    return decode;}
public static RenderState pdfbox_f5317_0(COSName state)
{    if (state == null) {        return null;    }    return RenderState.valueOf(state.getName().toUpperCase());}
public COSName pdfbox_f5318_0()
{    return this.name;}
public String pdfbox_f5319_0()
{    return dict.getString(COSName.NAME);}
public final void pdfbox_f5320_0(String name)
{    dict.setString(COSName.NAME, name);}
public RenderState pdfbox_f5321_0(RenderDestination destination)
{    COSName state = null;    COSDictionary usage = (COSDictionary) dict.getDictionaryObject("Usage");    if (usage != null) {        if (RenderDestination.PRINT.equals(destination)) {            COSDictionary print = (COSDictionary) usage.getDictionaryObject("Print");            state = print == null ? null : (COSName) print.getDictionaryObject("PrintState");        } else if (RenderDestination.VIEW.equals(destination)) {            COSDictionary view = (COSDictionary) usage.getDictionaryObject("View");            state = view == null ? null : (COSName) view.getDictionaryObject("ViewState");        }                if (state == null) {            COSDictionary export = (COSDictionary) usage.getDictionaryObject("Export");            state = export == null ? null : (COSName) export.getDictionaryObject("ExportState");        }    }    return state == null ? null : RenderState.valueOf(state);}
public String pdfbox_f5322_0()
{    return super.toString() + " (" + getName() + ")";}
public List<PDPropertyList> pdfbox_f5323_0()
{    List<PDPropertyList> list = new ArrayList<>();    COSBase base = dict.getDictionaryObject(COSName.OCGS);    if (base instanceof COSDictionary) {        list.add(PDPropertyList.create((COSDictionary) base));    } else if (base instanceof COSArray) {        COSArray ar = (COSArray) base;        for (int i = 0; i < ar.size(); ++i) {            COSBase elem = ar.getObject(i);            if (elem instanceof COSDictionary) {                list.add(PDPropertyList.create((COSDictionary) elem));            }        }    }    return list;}
public void pdfbox_f5324_0(List<PDPropertyList> ocgs)
{    COSArray ar = new COSArray();    for (PDPropertyList prop : ocgs) {        ar.add(prop);    }    dict.setItem(COSName.OCGS, ar);}
public COSName pdfbox_f5325_0()
{    return dict.getCOSName(COSName.P, COSName.ANY_ON);}
public void pdfbox_f5326_0(COSName visibilityPolicy)
{    dict.setItem(COSName.P, visibilityPolicy);}
public COSName pdfbox_f5327_0()
{    return this.name;}
public static BaseState pdfbox_f5328_0(COSName state)
{    if (state == null) {        return BaseState.ON;    }    return BaseState.valueOf(state.getName().toUpperCase());}
public COSBase pdfbox_f5329_0()
{    return this.dict;}
private COSArray pdfbox_f5330_0()
{    COSArray ocgs = this.dict.getCOSArray(COSName.OCGS);    if (ocgs == null) {        ocgs = new COSArray();                this.dict.setItem(COSName.OCGS, ocgs);    }    return ocgs;}
private COSDictionary pdfbox_f5331_0()
{    COSBase base = this.dict.getDictionaryObject(COSName.D);    if (base instanceof COSDictionary) {        return (COSDictionary) base;    }    COSDictionary d = new COSDictionary();        d.setString(COSName.NAME, "Top");        this.dict.setItem(COSName.D, d);    return d;}
public PDOptionalContentGroup pdfbox_f5332_0(String name)
{    COSArray ocgs = getOCGs();    for (COSBase o : ocgs) {        COSDictionary ocg = toDictionary(o);        String groupName = ocg.getString(COSName.NAME);        if (groupName.equals(name)) {            return new PDOptionalContentGroup(ocg);        }    }    return null;}
public void pdfbox_f5333_0(PDOptionalContentGroup ocg)
{    COSArray ocgs = getOCGs();    ocgs.add(ocg.getCOSObject());        COSArray order = (COSArray) getD().getDictionaryObject(COSName.ORDER);    if (order == null) {        order = new COSArray();        getD().setItem(COSName.ORDER, order);    }    order.add(ocg);}
public Collection<PDOptionalContentGroup> pdfbox_f5334_0()
{    Collection<PDOptionalContentGroup> coll = new ArrayList<>();    COSArray ocgs = getOCGs();    for (COSBase base : ocgs) {        coll.add(new PDOptionalContentGroup(toDictionary(base)));    }    return coll;}
public BaseState pdfbox_f5335_0()
{    COSDictionary d = getD();    COSName name = (COSName) d.getItem(COSName.BASE_STATE);    return BaseState.valueOf(name);}
public void pdfbox_f5336_0(BaseState state)
{    COSDictionary d = getD();    d.setItem(COSName.BASE_STATE, state.getName());}
public String[] pdfbox_f5337_0()
{    COSArray ocgs = (COSArray) dict.getDictionaryObject(COSName.OCGS);    int size = ocgs.size();    String[] groups = new String[size];    for (int i = 0; i < size; i++) {        COSBase obj = ocgs.get(i);        COSDictionary ocg = toDictionary(obj);        groups[i] = ocg.getString(COSName.NAME);    }    return groups;}
public boolean pdfbox_f5338_0(String groupName)
{    String[] layers = getGroupNames();    for (String layer : layers) {        if (layer.equals(groupName)) {            return true;        }    }    return false;}
public boolean pdfbox_f5339_0(String groupName)
{    boolean result = false;    COSArray ocgs = getOCGs();    for (COSBase o : ocgs) {        COSDictionary ocg = toDictionary(o);        String name = ocg.getString(COSName.NAME);        if (groupName.equals(name) && isGroupEnabled(new PDOptionalContentGroup(ocg))) {            result = true;        }    }    return result;}
public boolean pdfbox_f5340_0(PDOptionalContentGroup group)
{            PDOptionalContentProperties.BaseState baseState = getBaseState();    boolean enabled = !baseState.equals(BaseState.OFF);    if (group == null) {        return enabled;    }    COSDictionary d = getD();    COSBase base = d.getDictionaryObject(COSName.ON);    if (base instanceof COSArray) {        for (COSBase o : (COSArray) base) {            COSDictionary dictionary = toDictionary(o);            if (dictionary == group.getCOSObject()) {                return true;            }        }    }    base = d.getDictionaryObject(COSName.OFF);    if (base instanceof COSArray) {        for (COSBase o : (COSArray) base) {            COSDictionary dictionary = toDictionary(o);            if (dictionary == group.getCOSObject()) {                return false;            }        }    }    return enabled;}
private COSDictionary pdfbox_f5341_0(COSBase o)
{    if (o instanceof COSObject) {        return (COSDictionary) ((COSObject) o).getObject();    } else {        return (COSDictionary) o;    }}
public boolean pdfbox_f5342_0(String groupName, boolean enable)
{    boolean result = false;    COSArray ocgs = getOCGs();    for (COSBase o : ocgs) {        COSDictionary ocg = toDictionary(o);        String name = ocg.getString(COSName.NAME);        if (groupName.equals(name) && setGroupEnabled(new PDOptionalContentGroup(ocg), enable)) {            result = true;        }    }    return result;}
public boolean pdfbox_f5343_0(PDOptionalContentGroup group, boolean enable)
{    COSArray on;    COSArray off;    COSDictionary d = getD();    COSBase base = d.getDictionaryObject(COSName.ON);    if (!(base instanceof COSArray)) {        on = new COSArray();        d.setItem(COSName.ON, on);    } else {        on = (COSArray) base;    }    base = d.getDictionaryObject(COSName.OFF);    if (!(base instanceof COSArray)) {        off = new COSArray();        d.setItem(COSName.OFF, off);    } else {        off = (COSArray) base;    }    boolean found = false;    if (enable) {        for (COSBase o : off) {            COSDictionary groupDictionary = toDictionary(o);            if (groupDictionary == group.getCOSObject()) {                                off.remove(o);                on.add(o);                found = true;                break;            }        }    } else {        for (COSBase o : on) {            COSDictionary groupDictionary = toDictionary(o);            if (groupDictionary == group.getCOSObject()) {                                on.remove(o);                off.add(o);                found = true;                break;            }        }    }    if (!found) {        if (enable) {            on.add(group.getCOSObject());        } else {            off.add(group.getCOSObject());        }    }    return found;}
public static PDAbstractPattern pdfbox_f5344_0(COSDictionary dictionary) throws IOException
{    PDAbstractPattern pattern;    int patternType = dictionary.getInt(COSName.PATTERN_TYPE, 0);    switch(patternType) {        case TYPE_TILING_PATTERN:            pattern = new PDTilingPattern(dictionary);            break;        case TYPE_SHADING_PATTERN:            pattern = new PDShadingPattern(dictionary);            break;        default:            throw new IOException("Error: Unknown pattern type " + patternType);    }    return pattern;}
public COSDictionary pdfbox_f5345_0()
{    return patternDictionary;}
public void pdfbox_f5346_0(int paintType)
{    patternDictionary.setInt(COSName.PAINT_TYPE, paintType);}
public String pdfbox_f5347_0()
{    return COSName.PATTERN.getName();}
public void pdfbox_f5348_0(int patternType)
{    patternDictionary.setInt(COSName.PATTERN_TYPE, patternType);}
public Matrix pdfbox_f5349_0()
{    return Matrix.createMatrix(getCOSObject().getDictionaryObject(COSName.MATRIX));}
public void pdfbox_f5350_0(AffineTransform transform)
{    COSArray matrix = new COSArray();    double[] values = new double[6];    transform.getMatrix(values);    for (double v : values) {        matrix.add(new COSFloat((float) v));    }    getCOSObject().setItem(COSName.MATRIX, matrix);}
public int pdfbox_f5351_0()
{    return PDAbstractPattern.TYPE_SHADING_PATTERN;}
public PDExtendedGraphicsState pdfbox_f5352_0()
{    if (extendedGraphicsState == null) {        COSBase base = getCOSObject().getDictionaryObject(COSName.EXT_G_STATE);        if (base instanceof COSDictionary) {            extendedGraphicsState = new PDExtendedGraphicsState((COSDictionary) base);        }    }    return extendedGraphicsState;}
public void pdfbox_f5353_0(PDExtendedGraphicsState extendedGraphicsState)
{    this.extendedGraphicsState = extendedGraphicsState;    getCOSObject().setItem(COSName.EXT_G_STATE, extendedGraphicsState);}
public PDShading pdfbox_f5354_0() throws IOException
{    if (shading == null) {        COSBase base = getCOSObject().getDictionaryObject(COSName.SHADING);        if (base instanceof COSDictionary) {            shading = PDShading.create((COSDictionary) base);        }    }    return shading;}
public void pdfbox_f5355_0(PDShading shadingResources)
{    shading = shadingResources;    getCOSObject().setItem(COSName.SHADING, shadingResources);}
public int pdfbox_f5356_0()
{    return PDAbstractPattern.TYPE_TILING_PATTERN;}
public void pdfbox_f5357_0(int paintType)
{    getCOSObject().setInt(COSName.PAINT_TYPE, paintType);}
public int pdfbox_f5358_0()
{    return getCOSObject().getInt(COSName.PAINT_TYPE, 0);}
public void pdfbox_f5359_0(int tilingType)
{    getCOSObject().setInt(COSName.TILING_TYPE, tilingType);}
public int pdfbox_f5360_0()
{    return getCOSObject().getInt(COSName.TILING_TYPE, 0);}
public void pdfbox_f5361_0(float xStep)
{    getCOSObject().setFloat(COSName.X_STEP, xStep);}
public float pdfbox_f5362_0()
{    return getCOSObject().getFloat(COSName.X_STEP, 0);}
public void pdfbox_f5363_0(float yStep)
{    getCOSObject().setFloat(COSName.Y_STEP, yStep);}
public float pdfbox_f5364_0()
{    return getCOSObject().getFloat(COSName.Y_STEP, 0);}
public PDStream pdfbox_f5365_0()
{    return new PDStream((COSStream) getCOSObject());}
public InputStream pdfbox_f5366_0() throws IOException
{    COSDictionary dict = getCOSObject();    if (dict instanceof COSStream) {        return ((COSStream) getCOSObject()).createInputStream();    }    return null;}
public PDResources pdfbox_f5367_0()
{    PDResources retval = null;    COSBase base = getCOSObject().getDictionaryObject(COSName.RESOURCES);    if (base instanceof COSDictionary) {        retval = new PDResources((COSDictionary) base);    }    return retval;}
public final void pdfbox_f5368_0(PDResources resources)
{    getCOSObject().setItem(COSName.RESOURCES, resources);}
public PDRectangle pdfbox_f5369_0()
{    PDRectangle retval = null;    COSBase base = getCOSObject().getDictionaryObject(COSName.BBOX);    if (base instanceof COSArray) {        retval = new PDRectangle((COSArray) base);    }    return retval;}
public void pdfbox_f5370_0(PDRectangle bbox)
{    if (bbox == null) {        getCOSObject().removeItem(COSName.BBOX);    } else {        getCOSObject().setItem(COSName.BBOX, bbox.getCOSArray());    }}
public COSBase pdfbox_f5371_0()
{    return fontSetting;}
public PDFont pdfbox_f5372_0() throws IOException
{    PDFont retval = null;    COSBase font = fontSetting.getObject(0);    if (font instanceof COSDictionary) {        retval = PDFontFactory.createFont((COSDictionary) font);    }    return retval;}
public void pdfbox_f5373_0(PDFont font)
{    fontSetting.set(0, font);}
public float pdfbox_f5374_0()
{    COSNumber size = (COSNumber) fontSetting.get(1);    return size.floatValue();}
public void pdfbox_f5375_0(float size)
{    fontSetting.set(1, new COSFloat(size));}
public COSBase pdfbox_f5376_0()
{    COSArray cos = new COSArray();    COSArray patternArray = new COSArray();    patternArray.setFloatArray(array);    cos.add(patternArray);    cos.add(COSInteger.get(phase));    return cos;}
public int pdfbox_f5377_0()
{    return phase;}
public float[] pdfbox_f5378_0()
{    return array.clone();}
public String pdfbox_f5379_0()
{    return "PDLineDashPattern{array=" + Arrays.toString(array) + ", phase=" + phase + "}";}
public static PDXObject pdfbox_f5380_0(COSBase base, PDResources resources) throws IOException
{    if (base == null) {                return null;    }    if (!(base instanceof COSStream)) {        throw new IOException("Unexpected object type: " + base.getClass().getName());    }    COSStream stream = (COSStream) base;    String subtype = stream.getNameAsString(COSName.SUBTYPE);    if (COSName.IMAGE.getName().equals(subtype)) {        return new PDImageXObject(new PDStream(stream), resources);    } else if (COSName.FORM.getName().equals(subtype)) {        ResourceCache cache = resources != null ? resources.getResourceCache() : null;        COSDictionary group = (COSDictionary) stream.getDictionaryObject(COSName.GROUP);        if (group != null && COSName.TRANSPARENCY.equals(group.getCOSName(COSName.S))) {            return new PDTransparencyGroup(stream, cache);        }        return new PDFormXObject(stream, cache);    } else if (COSName.PS.getName().equals(subtype)) {        return new PDPostScriptXObject(stream);    } else {        throw new IOException("Invalid XObject Subtype: " + subtype);    }}
public final COSStream pdfbox_f5381_0()
{    return stream.getCOSObject();}
public final PDStream pdfbox_f5382_0()
{    return stream;}
private int[] pdfbox_f5383_0() throws IOException
{    int[] map = new int[factor + 1];    if (factor == 0 || Float.compare(d1d0, 0) == 0) {        float[] values = axialShadingType.evalFunction(domain[0]);        map[0] = convertToRGB(values);    } else {        for (int i = 0; i <= factor; i++) {            float t = domain[0] + d1d0 * i / factor;            float[] values = axialShadingType.evalFunction(t);            map[i] = convertToRGB(values);        }    }    return map;}
public void pdfbox_f5384_0()
{    super.dispose();    axialShadingType = null;}
public ColorModel pdfbox_f5385_0()
{    return super.getColorModel();}
public Raster pdfbox_f5386_0(int x, int y, int w, int h)
{        WritableRaster raster = getColorModel().createCompatibleWritableRaster(w, h);    boolean useBackground;    int[] data = new int[w * h * 4];    for (int j = 0; j < h; j++) {        for (int i = 0; i < w; i++) {            useBackground = false;            float[] values = new float[] { x + i, y + j };            rat.transform(values, 0, values, 0, 1);            double inputValue = x1x0 * (values[0] - coords[0]) + y1y0 * (values[1] - coords[1]);                        if (Double.compare(denom, 0) == 0) {                if (getBackground() == null) {                    continue;                }                useBackground = true;            } else {                inputValue /= denom;            }                        if (inputValue < 0) {                                if (extend[0]) {                    inputValue = 0;                } else {                    if (getBackground() == null) {                        continue;                    }                    useBackground = true;                }            } else             if (inputValue > 1) {                                if (extend[1]) {                    inputValue = 1;                } else {                    if (getBackground() == null) {                        continue;                    }                    useBackground = true;                }            }            int value;            if (useBackground) {                                value = getRgbBackground();            } else {                int key = (int) (inputValue * factor);                value = colorTable[key];            }            int index = (j * w + i) * 4;            data[index] = value & 255;            value >>= 8;            data[index + 1] = value & 255;            value >>= 8;            data[index + 2] = value & 255;            data[index + 3] = 255;        }    }    raster.setPixels(0, 0, w, h, data);    return raster;}
public float[] pdfbox_f5387_0()
{    return coords;}
public float[] pdfbox_f5388_0()
{    return domain;}
public boolean[] pdfbox_f5389_0()
{    return extend;}
public PDFunction pdfbox_f5390_0() throws IOException
{    return axialShadingType.getFunction();}
public int pdfbox_f5391_0()
{    return 0;}
public PaintContext pdfbox_f5392_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new AxialShadingContext(shading, cm, xform, matrix, deviceBounds);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
private Point2D[][] pdfbox_f5393_0(Point2D[] points)
{    Point2D[][] fourRows = new Point2D[4][4];    fourRows[2] = new Point2D[] { points[0], points[1], points[2], points[3] };        fourRows[1] = new Point2D[] { points[3], points[4], points[5], points[6] };        fourRows[3] = new Point2D[] { points[9], points[8], points[7], points[6] };        fourRows[0] = new Point2D[] { points[0], points[11], points[10], points[9] };        return fourRows;}
private int[] pdfbox_f5394_0()
{    int[] l = { 4, 4 };        if (isEdgeALine(controlPoints[0]) && isEdgeALine(controlPoints[1])) {        double lc1 = getLen(controlPoints[0][0], controlPoints[0][3]), lc2 = getLen(controlPoints[1][0], controlPoints[1][3]);                if (lc1 > 800 || lc2 > 800) {                } else if (lc1 > 400 || lc2 > 400) {            l[0] = 3;        } else if (lc1 > 200 || lc2 > 200) {            l[0] = 2;        } else {            l[0] = 1;        }    }        if (isEdgeALine(controlPoints[2]) && isEdgeALine(controlPoints[3])) {        double ld1 = getLen(controlPoints[2][0], controlPoints[2][3]), ld2 = getLen(controlPoints[3][0], controlPoints[3][3]);        if (ld1 > 800 || ld2 > 800) {                } else if (ld1 > 400 || ld2 > 400) {            l[1] = 3;        } else if (ld1 > 200 || ld2 > 200) {            l[1] = 2;        } else {            l[1] = 1;        }    }    return l;}
private List<ShadedTriangle> pdfbox_f5395_0()
{        CubicBezierCurve eC1 = new CubicBezierCurve(controlPoints[0], level[0]);    CubicBezierCurve eC2 = new CubicBezierCurve(controlPoints[1], level[0]);    CubicBezierCurve eD1 = new CubicBezierCurve(controlPoints[2], level[1]);    CubicBezierCurve eD2 = new CubicBezierCurve(controlPoints[3], level[1]);    CoordinateColorPair[][] patchCC = getPatchCoordinatesColor(eC1, eC2, eD1, eD2);    return getShadedTriangles(patchCC);}
protected Point2D[] pdfbox_f5396_0()
{    return controlPoints[1].clone();}
protected Point2D[] pdfbox_f5397_0()
{    Point2D[] implicitEdge = new Point2D[4];    implicitEdge[0] = controlPoints[3][3];    implicitEdge[1] = controlPoints[3][2];    implicitEdge[2] = controlPoints[3][1];    implicitEdge[3] = controlPoints[3][0];    return implicitEdge;}
protected Point2D[] pdfbox_f5398_0()
{    Point2D[] implicitEdge = new Point2D[4];    implicitEdge[0] = controlPoints[0][3];    implicitEdge[1] = controlPoints[0][2];    implicitEdge[2] = controlPoints[0][1];    implicitEdge[3] = controlPoints[0][0];    return implicitEdge;}
private CoordinateColorPair[][] pdfbox_f5399_0(CubicBezierCurve c1, CubicBezierCurve c2, CubicBezierCurve d1, CubicBezierCurve d2)
{    Point2D[] curveC1 = c1.getCubicBezierCurve();    Point2D[] curveC2 = c2.getCubicBezierCurve();    Point2D[] curveD1 = d1.getCubicBezierCurve();    Point2D[] curveD2 = d2.getCubicBezierCurve();    int numberOfColorComponents = cornerColor[0].length;    int szV = curveD1.length;    int szU = curveC1.length;    CoordinateColorPair[][] patchCC = new CoordinateColorPair[szV][szU];    double stepV = (double) 1 / (szV - 1);    double stepU = (double) 1 / (szU - 1);    double v = -stepV;    for (int i = 0; i < szV; i++) {                v += stepV;        double u = -stepU;        for (int j = 0; j < szU; j++) {            u += stepU;            double scx = (1 - v) * curveC1[j].getX() + v * curveC2[j].getX();            double scy = (1 - v) * curveC1[j].getY() + v * curveC2[j].getY();            double sdx = (1 - u) * curveD1[i].getX() + u * curveD2[i].getX();            double sdy = (1 - u) * curveD1[i].getY() + u * curveD2[i].getY();            double sbx = (1 - v) * ((1 - u) * controlPoints[0][0].getX() + u * controlPoints[0][3].getX()) + v * ((1 - u) * controlPoints[1][0].getX() + u * controlPoints[1][3].getX());            double sby = (1 - v) * ((1 - u) * controlPoints[0][0].getY() + u * controlPoints[0][3].getY()) + v * ((1 - u) * controlPoints[1][0].getY() + u * controlPoints[1][3].getY());            double sx = scx + sdx - sbx;            double sy = scy + sdy - sby;                        Point2D tmpC = new Point2D.Double(sx, sy);            float[] paramSC = new float[numberOfColorComponents];            for (int ci = 0; ci < numberOfColorComponents; ci++) {                paramSC[ci] = (float) ((1 - v) * ((1 - u) * cornerColor[0][ci] + u * cornerColor[3][ci]) +                 v * ((1 - u) * cornerColor[1][ci] + u * cornerColor[2][ci]));            }            patchCC[i][j] = new CoordinateColorPair(tmpC, paramSC);        }    }    return patchCC;}
 int pdfbox_f5400_0()
{    return level;}
private Point2D[] pdfbox_f5401_0(int l)
{    if (l < 0) {        l = 0;    }    int sz = (1 << l) + 1;    Point2D[] res = new Point2D[sz];    double step = (double) 1 / (sz - 1);    double t = -step;    for (int i = 0; i < sz; i++) {        t += step;        double tmpX = (1 - t) * (1 - t) * (1 - t) * controlPoints[0].getX() + 3 * t * (1 - t) * (1 - t) * controlPoints[1].getX() + 3 * t * t * (1 - t) * controlPoints[2].getX() + t * t * t * controlPoints[3].getX();        double tmpY = (1 - t) * (1 - t) * (1 - t) * controlPoints[0].getY() + 3 * t * (1 - t) * (1 - t) * controlPoints[1].getY() + 3 * t * t * (1 - t) * controlPoints[2].getY() + t * t * t * controlPoints[3].getY();        res[i] = new Point2D.Double(tmpX, tmpY);    }    return res;}
 Point2D[] pdfbox_f5402_0()
{    return curve;}
public String pdfbox_f5403_0()
{    StringBuilder sb = new StringBuilder();    for (Point2D p : controlPoints) {        if (sb.length() > 0) {            sb.append(' ');        }        sb.append(p);    }    return "Cubic Bezier curve{control points p0, p1, p2, p3: " + sb + "}";}
protected Vertex pdfbox_f5404_1(ImageInputStream input, long maxSrcCoord, long maxSrcColor, PDRange rangeX, PDRange rangeY, PDRange[] colRangeTab, Matrix matrix, AffineTransform xform) throws IOException
{    float[] colorComponentTab = new float[numberOfColorComponents];    long x = input.readBits(bitsPerCoordinate);    long y = input.readBits(bitsPerCoordinate);    float dstX = interpolate(x, maxSrcCoord, rangeX.getMin(), rangeX.getMax());    float dstY = interpolate(y, maxSrcCoord, rangeY.getMin(), rangeY.getMax());        Point2D p = matrix.transformPoint(dstX, dstY);    xform.transform(p, p);    for (int n = 0; n < numberOfColorComponents; ++n) {        int color = (int) input.readBits(bitsPerColorComponent);        colorComponentTab[n] = interpolate(color, maxSrcColor, colRangeTab[n].getMin(), colRangeTab[n].getMax());            }                int bitOffset = input.getBitOffset();    if (bitOffset != 0) {        input.readBits(8 - bitOffset);    }    return new Vertex(p, colorComponentTab);}
 final void pdfbox_f5405_0(List<ShadedTriangle> triangleList)
{    this.triangleList = triangleList;}
protected Map<Point, Integer> pdfbox_f5406_0(Rectangle deviceBounds) throws IOException
{    Map<Point, Integer> map = new HashMap<>();    super.calcPixelTable(triangleList, map, deviceBounds);    return map;}
public void pdfbox_f5407_0()
{    triangleList = null;    super.dispose();}
private float pdfbox_f5408_0(float src, long srcMax, float dstMin, float dstMax)
{    return dstMin + (src * (dstMax - dstMin) / srcMax);}
protected boolean pdfbox_f5409_0()
{    return triangleList.isEmpty();}
public int pdfbox_f5410_0()
{    return 89 * (623 + this.x) + this.y;}
public boolean pdfbox_f5411_1(Object obj)
{    if (this == obj) {        return true;    }    if (obj == null) {        return false;    }    if (getClass() != obj.getClass()) {        if (obj instanceof Point2D) {                                }        return false;    }    final IntPoint other = (IntPoint) obj;    return this.x == other.x && this.y == other.y;}
private Set<Point> pdfbox_f5412_0(int x0, int y0, int x1, int y1)
{    Set<Point> points = new HashSet<>(3);    int dx = Math.abs(x1 - x0);    int dy = Math.abs(y1 - y0);    int sx = x0 < x1 ? 1 : -1;    int sy = y0 < y1 ? 1 : -1;    int err = dx - dy;    while (true) {        points.add(new IntPoint(x0, y0));        if (x0 == x1 && y0 == y1) {            break;        }        int e2 = 2 * err;        if (e2 > -dy) {            err -= dy;            x0 += sx;        }        if (e2 < dx) {            err += dx;            y0 += sy;        }    }    return points;}
protected float[] pdfbox_f5413_0(Point p)
{    int numberOfColorComponents = color0.length;    float[] pc = new float[numberOfColorComponents];    if (point0.x == point1.x && point0.y == point1.y) {        return color0;    } else if (point0.x == point1.x) {        float l = point1.y - point0.y;        for (int i = 0; i < numberOfColorComponents; i++) {            pc[i] = (color0[i] * (point1.y - p.y) / l + color1[i] * (p.y - point0.y) / l);        }    } else {        float l = point1.x - point0.x;        for (int i = 0; i < numberOfColorComponents; i++) {            pc[i] = (color0[i] * (point1.x - p.x) / l + color1[i] * (p.x - point0.x) / l);        }    }    return pc;}
protected float[][] pdfbox_f5414_0()
{    int numberOfColorComponents = cornerColor[0].length;    float[][] implicitCornerColor = new float[2][numberOfColorComponents];    for (int i = 0; i < numberOfColorComponents; i++) {        implicitCornerColor[0][i] = cornerColor[1][i];        implicitCornerColor[1][i] = cornerColor[2][i];    }    return implicitCornerColor;}
protected float[][] pdfbox_f5415_0()
{    int numberOfColorComponents = cornerColor[0].length;    float[][] implicitCornerColor = new float[2][numberOfColorComponents];    for (int i = 0; i < numberOfColorComponents; i++) {        implicitCornerColor[0][i] = cornerColor[2][i];        implicitCornerColor[1][i] = cornerColor[3][i];    }    return implicitCornerColor;}
protected float[][] pdfbox_f5416_0()
{    int numberOfColorComponents = cornerColor[0].length;    float[][] implicitCornerColor = new float[2][numberOfColorComponents];    for (int i = 0; i < numberOfColorComponents; i++) {        implicitCornerColor[0][i] = cornerColor[3][i];        implicitCornerColor[1][i] = cornerColor[0][i];    }    return implicitCornerColor;}
protected double pdfbox_f5417_0(Point2D ps, Point2D pe)
{    double x = pe.getX() - ps.getX();    double y = pe.getY() - ps.getY();    return Math.sqrt(x * x + y * y);}
protected boolean pdfbox_f5418_0(Point2D[] ctl)
{    double ctl1 = Math.abs(edgeEquationValue(ctl[1], ctl[0], ctl[3]));    double ctl2 = Math.abs(edgeEquationValue(ctl[2], ctl[0], ctl[3]));    double x = Math.abs(ctl[0].getX() - ctl[3].getX());    double y = Math.abs(ctl[0].getY() - ctl[3].getY());    return (ctl1 <= x && ctl2 <= x) || (ctl1 <= y && ctl2 <= y);}
protected double pdfbox_f5419_0(Point2D p, Point2D p1, Point2D p2)
{    return (p2.getY() - p1.getY()) * (p.getX() - p1.getX()) - (p2.getX() - p1.getX()) * (p.getY() - p1.getY());}
protected List<ShadedTriangle> pdfbox_f5420_0(CoordinateColorPair[][] patchCC)
{    List<ShadedTriangle> list = new ArrayList<>();    int szV = patchCC.length;    int szU = patchCC[0].length;    for (int i = 1; i < szV; i++) {        for (int j = 1; j < szU; j++) {            Point2D p0 = patchCC[i - 1][j - 1].coordinate, p1 = patchCC[i - 1][j].coordinate, p2 = patchCC[i][j].coordinate, p3 = patchCC[i][j - 1].coordinate;            boolean ll = true;            if (overlaps(p0, p1) || overlaps(p0, p3)) {                ll = false;            } else {                                Point2D[] llCorner = { p0, p1, p3 };                float[][] llColor = { patchCC[i - 1][j - 1].color, patchCC[i - 1][j].color, patchCC[i][j - 1].color };                                ShadedTriangle tmpll = new ShadedTriangle(llCorner, llColor);                list.add(tmpll);            }            if (ll && (overlaps(p2, p1) || overlaps(p2, p3))) {            } else {                                Point2D[] urCorner = { p3, p1, p2 };                float[][] urColor = { patchCC[i][j - 1].color, patchCC[i - 1][j].color, patchCC[i][j].color };                                ShadedTriangle tmpur = new ShadedTriangle(urCorner, urColor);                list.add(tmpur);            }        }    }    return list;}
private boolean pdfbox_f5421_0(Point2D p0, Point2D p1)
{    return Math.abs(p0.getX() - p1.getX()) < 0.001 && Math.abs(p0.getY() - p1.getY()) < 0.001;}
 final List<Patch> pdfbox_f5422_1(PDShadingType6 shadingType, AffineTransform xform, Matrix matrix, int controlPoints) throws IOException
{    COSDictionary dict = shadingType.getCOSObject();    if (!(dict instanceof COSStream)) {        return Collections.emptyList();    }    PDRange rangeX = shadingType.getDecodeForParameter(0);    PDRange rangeY = shadingType.getDecodeForParameter(1);    if (Float.compare(rangeX.getMin(), rangeX.getMax()) == 0 || Float.compare(rangeY.getMin(), rangeY.getMax()) == 0) {        return Collections.emptyList();    }    int bitsPerFlag = shadingType.getBitsPerFlag();    PDRange[] colRange = new PDRange[numberOfColorComponents];    for (int i = 0; i < numberOfColorComponents; ++i) {        colRange[i] = shadingType.getDecodeForParameter(2 + i);        if (colRange[i] == null) {            throw new IOException("Range missing in shading /Decode entry");        }    }    List<Patch> list = new ArrayList<>();    long maxSrcCoord = (long) Math.pow(2, bitsPerCoordinate) - 1;    long maxSrcColor = (long) Math.pow(2, bitsPerColorComponent) - 1;    COSStream cosStream = (COSStream) dict;    try (ImageInputStream mciis = new MemoryCacheImageInputStream(cosStream.createInputStream())) {        Point2D[] implicitEdge = new Point2D[4];        float[][] implicitCornerColor = new float[2][numberOfColorComponents];        byte flag = 0;        try {            flag = (byte) (mciis.readBits(bitsPerFlag) & 3);        } catch (EOFException ex) {                    }        boolean eof = false;        while (!eof) {            try {                boolean isFree = (flag == 0);                Patch current = readPatch(mciis, isFree, implicitEdge, implicitCornerColor, maxSrcCoord, maxSrcColor, rangeX, rangeY, colRange, matrix, xform, controlPoints);                if (current == null) {                    break;                }                list.add(current);                flag = (byte) (mciis.readBits(bitsPerFlag) & 3);                switch(flag) {                    case 0:                        break;                    case 1:                        implicitEdge = current.getFlag1Edge();                        implicitCornerColor = current.getFlag1Color();                        break;                    case 2:                        implicitEdge = current.getFlag2Edge();                        implicitCornerColor = current.getFlag2Color();                        break;                    case 3:                        implicitEdge = current.getFlag3Edge();                        implicitCornerColor = current.getFlag3Color();                        break;                    default:                                                break;                }            } catch (EOFException ex) {                eof = true;            }        }    }    return list;}
protected Patch pdfbox_f5423_1(ImageInputStream input, boolean isFree, Point2D[] implicitEdge, float[][] implicitCornerColor, long maxSrcCoord, long maxSrcColor, PDRange rangeX, PDRange rangeY, PDRange[] colRange, Matrix matrix, AffineTransform xform, int controlPoints) throws IOException
{    float[][] color = new float[4][numberOfColorComponents];    Point2D[] points = new Point2D[controlPoints];    int pStart = 4, cStart = 2;    if (isFree) {        pStart = 0;        cStart = 0;    } else {        points[0] = implicitEdge[0];        points[1] = implicitEdge[1];        points[2] = implicitEdge[2];        points[3] = implicitEdge[3];        for (int i = 0; i < numberOfColorComponents; i++) {            color[0][i] = implicitCornerColor[0][i];            color[1][i] = implicitCornerColor[1][i];        }    }    try {        for (int i = pStart; i < controlPoints; i++) {            long x = input.readBits(bitsPerCoordinate);            long y = input.readBits(bitsPerCoordinate);            float px = interpolate(x, maxSrcCoord, rangeX.getMin(), rangeX.getMax());            float py = interpolate(y, maxSrcCoord, rangeY.getMin(), rangeY.getMax());            Point2D p = matrix.transformPoint(px, py);            xform.transform(p, p);            points[i] = p;        }        for (int i = cStart; i < 4; i++) {            for (int j = 0; j < numberOfColorComponents; j++) {                long c = input.readBits(bitsPerColorComponent);                color[i][j] = interpolate(c, maxSrcColor, colRange[j].getMin(), colRange[j].getMax());            }        }    } catch (EOFException ex) {                return null;    }    return generatePatch(points, color);}
private float pdfbox_f5424_0(float x, long maxValue, float rangeMin, float rangeMax)
{    return rangeMin + (x / maxValue) * (rangeMax - rangeMin);}
protected Map<Point, Integer> pdfbox_f5425_0(Rectangle deviceBounds) throws IOException
{    Map<Point, Integer> map = new HashMap<>();    for (Patch it : patchList) {        super.calcPixelTable(it.listOfTriangles, map, deviceBounds);    }    return map;}
public void pdfbox_f5426_0()
{    patchList = null;    super.dispose();}
protected boolean pdfbox_f5427_0()
{    return patchList.isEmpty();}
public COSDictionary pdfbox_f5428_0()
{    return dictionary;}
public String pdfbox_f5429_0()
{    return COSName.SHADING.getName();}
public void pdfbox_f5430_0(int shadingType)
{    dictionary.setInt(COSName.SHADING_TYPE, shadingType);}
public void pdfbox_f5431_0(COSArray newBackground)
{    background = newBackground;    dictionary.setItem(COSName.BACKGROUND, newBackground);}
public COSArray pdfbox_f5432_0()
{    if (background == null) {        background = (COSArray) dictionary.getDictionaryObject(COSName.BACKGROUND);    }    return background;}
public PDRectangle pdfbox_f5433_0()
{    if (bBox == null) {        COSArray array = (COSArray) dictionary.getDictionaryObject(COSName.BBOX);        if (array != null) {            bBox = new PDRectangle(array);        }    }    return bBox;}
public void pdfbox_f5434_0(PDRectangle newBBox)
{    bBox = newBBox;    if (bBox == null) {        dictionary.removeItem(COSName.BBOX);    } else {        dictionary.setItem(COSName.BBOX, bBox.getCOSArray());    }}
public void pdfbox_f5435_0(boolean antiAlias)
{    dictionary.setBoolean(COSName.ANTI_ALIAS, antiAlias);}
public boolean pdfbox_f5436_0()
{    return dictionary.getBoolean(COSName.ANTI_ALIAS, false);}
public PDColorSpace pdfbox_f5437_0() throws IOException
{    if (colorSpace == null) {        COSBase colorSpaceDictionary = dictionary.getDictionaryObject(COSName.CS, COSName.COLORSPACE);        colorSpace = PDColorSpace.create(colorSpaceDictionary);    }    return colorSpace;}
public void pdfbox_f5438_0(PDColorSpace colorSpace)
{    this.colorSpace = colorSpace;    if (colorSpace != null) {        dictionary.setItem(COSName.COLORSPACE, colorSpace.getCOSObject());    } else {        dictionary.removeItem(COSName.COLORSPACE);    }}
public static PDShading pdfbox_f5439_0(COSDictionary shadingDictionary) throws IOException
{    PDShading shading = null;    int shadingType = shadingDictionary.getInt(COSName.SHADING_TYPE, 0);    switch(shadingType) {        case SHADING_TYPE1:            shading = new PDShadingType1(shadingDictionary);            break;        case SHADING_TYPE2:            shading = new PDShadingType2(shadingDictionary);            break;        case SHADING_TYPE3:            shading = new PDShadingType3(shadingDictionary);            break;        case SHADING_TYPE4:            shading = new PDShadingType4(shadingDictionary);            break;        case SHADING_TYPE5:            shading = new PDShadingType5(shadingDictionary);            break;        case SHADING_TYPE6:            shading = new PDShadingType6(shadingDictionary);            break;        case SHADING_TYPE7:            shading = new PDShadingType7(shadingDictionary);            break;        default:            throw new IOException("Error: Unknown shading type " + shadingType);    }    return shading;}
public void pdfbox_f5440_0(PDFunction newFunction)
{    functionArray = null;    function = newFunction;    getCOSObject().setItem(COSName.FUNCTION, newFunction);}
public void pdfbox_f5441_0(COSArray newFunctions)
{    functionArray = null;    function = null;    getCOSObject().setItem(COSName.FUNCTION, newFunctions);}
public PDFunction pdfbox_f5442_0() throws IOException
{    if (function == null) {        COSBase dictionaryFunctionObject = getCOSObject().getDictionaryObject(COSName.FUNCTION);        if (dictionaryFunctionObject != null) {            function = PDFunction.create(dictionaryFunctionObject);        }    }    return function;}
private PDFunction[] pdfbox_f5443_0() throws IOException
{    if (functionArray == null) {        COSBase functionObject = getCOSObject().getDictionaryObject(COSName.FUNCTION);        if (functionObject instanceof COSDictionary) {            functionArray = new PDFunction[1];            functionArray[0] = PDFunction.create(functionObject);        } else if (functionObject instanceof COSArray) {            COSArray functionCOSArray = (COSArray) functionObject;            int numberOfFunctions = functionCOSArray.size();            functionArray = new PDFunction[numberOfFunctions];            for (int i = 0; i < numberOfFunctions; i++) {                functionArray[i] = PDFunction.create(functionCOSArray.get(i));            }        } else {            throw new IOException("mandatory /Function element must be a dictionary or an array");        }    }    return functionArray;}
public float[] pdfbox_f5444_0(float inputValue) throws IOException
{    return evalFunction(new float[] { inputValue });}
public float[] pdfbox_f5445_0(float[] input) throws IOException
{    PDFunction[] functions = getFunctionsArray();    int numberOfFunctions = functions.length;    float[] returnValues;    if (numberOfFunctions == 1) {        returnValues = functions[0].eval(input);    } else {        returnValues = new float[numberOfFunctions];        for (int i = 0; i < numberOfFunctions; i++) {            float[] newValue = functions[i].eval(input);            returnValues[i] = newValue[0];        }    }        for (int i = 0; i < returnValues.length; ++i) {        if (returnValues[i] < 0) {            returnValues[i] = 0;        } else if (returnValues[i] > 1) {            returnValues[i] = 1;        }    }    return returnValues;}
public int pdfbox_f5446_0()
{    return PDShading.SHADING_TYPE1;}
public Matrix pdfbox_f5447_0()
{    return Matrix.createMatrix(getCOSObject().getDictionaryObject(COSName.MATRIX));}
public void pdfbox_f5448_0(AffineTransform transform)
{    COSArray matrix = new COSArray();    double[] values = new double[6];    transform.getMatrix(values);    for (double v : values) {        matrix.add(new COSFloat((float) v));    }    getCOSObject().setItem(COSName.MATRIX, matrix);}
public COSArray pdfbox_f5449_0()
{    if (domain == null) {        domain = (COSArray) getCOSObject().getDictionaryObject(COSName.DOMAIN);    }    return domain;}
public void pdfbox_f5450_0(COSArray newDomain)
{    domain = newDomain;    getCOSObject().setItem(COSName.DOMAIN, newDomain);}
public Paint pdfbox_f5451_0(Matrix matrix)
{    return new Type1ShadingPaint(this, matrix);}
public int pdfbox_f5452_0()
{    return PDShading.SHADING_TYPE2;}
public COSArray pdfbox_f5453_0()
{    if (extend == null) {        extend = (COSArray) getCOSObject().getDictionaryObject(COSName.EXTEND);    }    return extend;}
public void pdfbox_f5454_0(COSArray newExtend)
{    extend = newExtend;    getCOSObject().setItem(COSName.EXTEND, newExtend);}
public COSArray pdfbox_f5455_0()
{    if (domain == null) {        domain = (COSArray) getCOSObject().getDictionaryObject(COSName.DOMAIN);    }    return domain;}
public void pdfbox_f5456_0(COSArray newDomain)
{    domain = newDomain;    getCOSObject().setItem(COSName.DOMAIN, newDomain);}
public COSArray pdfbox_f5457_0()
{    if (coords == null) {        coords = (COSArray) getCOSObject().getDictionaryObject(COSName.COORDS);    }    return coords;}
public void pdfbox_f5458_0(COSArray newCoords)
{    coords = newCoords;    getCOSObject().setItem(COSName.COORDS, newCoords);}
public Paint pdfbox_f5459_0(Matrix matrix)
{    return new AxialShadingPaint(this, matrix);}
public int pdfbox_f5460_0()
{    return PDShading.SHADING_TYPE3;}
public Paint pdfbox_f5461_0(Matrix matrix)
{    return new RadialShadingPaint(this, matrix);}
public int pdfbox_f5462_0()
{    return PDShading.SHADING_TYPE4;}
public int pdfbox_f5463_0()
{    return getCOSObject().getInt(COSName.BITS_PER_FLAG, -1);}
public void pdfbox_f5464_0(int bitsPerFlag)
{    getCOSObject().setInt(COSName.BITS_PER_FLAG, bitsPerFlag);}
public Paint pdfbox_f5465_0(Matrix matrix)
{    return new Type4ShadingPaint(this, matrix);}
public int pdfbox_f5466_0()
{    return PDShading.SHADING_TYPE5;}
public int pdfbox_f5467_0()
{    return getCOSObject().getInt(COSName.VERTICES_PER_ROW, -1);}
public void pdfbox_f5468_0(int verticesPerRow)
{    getCOSObject().setInt(COSName.VERTICES_PER_ROW, verticesPerRow);}
public Paint pdfbox_f5469_0(Matrix matrix)
{    return new Type5ShadingPaint(this, matrix);}
public int pdfbox_f5470_0()
{    return PDShading.SHADING_TYPE6;}
public Paint pdfbox_f5471_0(Matrix matrix)
{    return new Type6ShadingPaint(this, matrix);}
public int pdfbox_f5472_0()
{    return PDShading.SHADING_TYPE7;}
public Paint pdfbox_f5473_0(Matrix matrix)
{    return new Type7ShadingPaint(this, matrix);}
public int pdfbox_f5474_0()
{    return getCOSObject().getInt(COSName.BITS_PER_COMPONENT, -1);}
public void pdfbox_f5475_0(int bitsPerComponent)
{    getCOSObject().setInt(COSName.BITS_PER_COMPONENT, bitsPerComponent);}
public int pdfbox_f5476_0()
{    return getCOSObject().getInt(COSName.BITS_PER_COORDINATE, -1);}
public void pdfbox_f5477_0(int bitsPerComponent)
{    getCOSObject().setInt(COSName.BITS_PER_COORDINATE, bitsPerComponent);}
private COSArray pdfbox_f5478_0()
{    if (decode == null) {        decode = (COSArray) getCOSObject().getDictionaryObject(COSName.DECODE);    }    return decode;}
public void pdfbox_f5479_0(COSArray decodeValues)
{    decode = decodeValues;    getCOSObject().setItem(COSName.DECODE, decodeValues);}
public PDRange pdfbox_f5480_0(int paramNum)
{    PDRange retval = null;    COSArray decodeValues = getDecodeValues();    if (decodeValues != null && decodeValues.size() >= paramNum * 2 + 1) {        retval = new PDRange(decodeValues, paramNum);    }    return retval;}
private int[] pdfbox_f5481_0() throws IOException
{    int[] map = new int[factor + 1];    if (factor == 0 || Float.compare(d1d0, 0) == 0) {        float[] values = radialShadingType.evalFunction(domain[0]);        map[0] = convertToRGB(values);    } else {        for (int i = 0; i <= factor; i++) {            float t = domain[0] + d1d0 * i / factor;            float[] values = radialShadingType.evalFunction(t);            map[i] = convertToRGB(values);        }    }    return map;}
public void pdfbox_f5482_0()
{    super.dispose();    radialShadingType = null;}
public ColorModel pdfbox_f5483_0()
{    return super.getColorModel();}
public Raster pdfbox_f5484_0(int x, int y, int w, int h)
{        WritableRaster raster = getColorModel().createCompatibleWritableRaster(w, h);    float inputValue = -1;    boolean useBackground;    int[] data = new int[w * h * 4];    for (int j = 0; j < h; j++) {        for (int i = 0; i < w; i++) {            float[] values = new float[] { x + i, y + j };            rat.transform(values, 0, values, 0, 1);            useBackground = false;            float[] inputValues = calculateInputValues(values[0], values[1]);            if (Float.isNaN(inputValues[0]) && Float.isNaN(inputValues[1])) {                if (getBackground() == null) {                    continue;                }                useBackground = true;            } else {                                if (inputValues[0] >= 0 && inputValues[0] <= 1) {                                        if (inputValues[1] >= 0 && inputValues[1] <= 1) {                        inputValue = Math.max(inputValues[0], inputValues[1]);                    } else                     {                        inputValue = inputValues[0];                    }                } else {                                        if (inputValues[1] >= 0 && inputValues[1] <= 1) {                        inputValue = inputValues[1];                    } else                     {                        if (extend[0] && extend[1]) {                            inputValue = Math.max(inputValues[0], inputValues[1]);                        } else if (extend[0]) {                            inputValue = inputValues[0];                        } else if (extend[1]) {                            inputValue = inputValues[1];                        } else if (getBackground() != null) {                            useBackground = true;                        } else {                            continue;                        }                    }                }                                if (inputValue > 1) {                                        if (extend[1] && coords[5] > 0) {                        inputValue = 1;                    } else {                        if (getBackground() == null) {                            continue;                        }                        useBackground = true;                    }                } else                 if (inputValue < 0) {                                        if (extend[0] && coords[2] > 0) {                        inputValue = 0;                    } else {                        if (getBackground() == null) {                            continue;                        }                        useBackground = true;                    }                }            }            int value;            if (useBackground) {                                value = getRgbBackground();            } else {                int key = (int) (inputValue * factor);                value = colorTable[key];            }            int index = (j * w + i) * 4;            data[index] = value & 255;            value >>= 8;            data[index + 1] = value & 255;            value >>= 8;            data[index + 2] = value & 255;            data[index + 3] = 255;        }    }    raster.setPixels(0, 0, w, h, data);    return raster;}
private float[] pdfbox_f5485_0(double x, double y)
{                                                                    double p = -(x - coords[0]) * x1x0 - (y - coords[1]) * y1y0 - coords[2] * r1r0;    double q = (Math.pow(x - coords[0], 2) + Math.pow(y - coords[1], 2) - r0pow2);    double root = Math.sqrt(p * p - denom * q);    float root1 = (float) ((-p + root) / denom);    float root2 = (float) ((-p - root) / denom);    if (denom < 0) {        return new float[] { root1, root2 };    } else {        return new float[] { root2, root1 };    }}
public float[] pdfbox_f5486_0()
{    return coords;}
public float[] pdfbox_f5487_0()
{    return domain;}
public boolean[] pdfbox_f5488_0()
{    return extend;}
public PDFunction pdfbox_f5489_0() throws IOException
{    return radialShadingType.getFunction();}
public int pdfbox_f5490_0()
{    return 0;}
public PaintContext pdfbox_f5491_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new RadialShadingContext(shading, cm, xform, matrix, deviceBounds);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
private int pdfbox_f5492_0(Point2D[] p)
{    Set<Point> set = new HashSet<>();    for (Point2D itp : p) {        Point np = new Point((int) Math.round(itp.getX() * 1000), (int) Math.round(itp.getY() * 1000));        set.add(np);    }    return set.size();}
public int pdfbox_f5493_0()
{    return degree;}
public int[] pdfbox_f5494_0()
{    int[] boundary = new int[4];    int x0 = (int) Math.round(corner[0].getX());    int x1 = (int) Math.round(corner[1].getX());    int x2 = (int) Math.round(corner[2].getX());    int y0 = (int) Math.round(corner[0].getY());    int y1 = (int) Math.round(corner[1].getY());    int y2 = (int) Math.round(corner[2].getY());    boundary[0] = Math.min(Math.min(x0, x1), x2);    boundary[1] = Math.max(Math.max(x0, x1), x2);    boundary[2] = Math.min(Math.min(y0, y1), y2);    boundary[3] = Math.max(Math.max(y0, y1), y2);    return boundary;}
public Line pdfbox_f5495_0()
{    return line;}
public boolean pdfbox_f5496_0(Point2D p)
{    if (degree == 1) {        return overlaps(corner[0], p) || overlaps(corner[1], p) || overlaps(corner[2], p);    } else if (degree == 2) {        Point tp = new Point((int) Math.round(p.getX()), (int) Math.round(p.getY()));        return line.linePoints.contains(tp);    }    /*         the following code judges whether a point is contained in a normal triangle,          taking the on edge case as contained         */    double pv0 = edgeEquationValue(p, corner[1], corner[2]);    /*         if corner[0] and point p are on different sides of line from corner[1] to corner[2],          p is outside of the triangle         */    if (pv0 * v0 < 0) {        return false;    }    double pv1 = edgeEquationValue(p, corner[2], corner[0]);    /*         if vertex corner[1] and point p are on different sides of line from corner[2] to corner[0],          p is outside of the triangle         */    if (pv1 * v1 < 0) {        return false;    }    double pv2 = edgeEquationValue(p, corner[0], corner[1]);        return pv2 * v2 >= 0;}
private boolean pdfbox_f5497_0(Point2D p0, Point2D p1)
{    return Math.abs(p0.getX() - p1.getX()) < 0.001 && Math.abs(p0.getY() - p1.getY()) < 0.001;}
private double pdfbox_f5498_0(Point2D p, Point2D p1, Point2D p2)
{    return (p2.getY() - p1.getY()) * (p.getX() - p1.getX()) - (p2.getX() - p1.getX()) * (p.getY() - p1.getY());}
private double pdfbox_f5499_0(Point2D a, Point2D b, Point2D c)
{    return Math.abs((c.getX() - b.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (c.getY() - b.getY())) / 2.0;}
public float[] pdfbox_f5500_0(Point2D p)
{    int numberOfColorComponents = color[0].length;    float[] pCol = new float[numberOfColorComponents];    switch(degree) {        case 1:            for (int i = 0; i < numberOfColorComponents; i++) {                                pCol[i] = (color[0][i] + color[1][i] + color[2][i]) / 3.0f;            }            break;        case 2:                        Point tp = new Point((int) Math.round(p.getX()), (int) Math.round(p.getY()));            return line.calcColor(tp);        default:            float aw = (float) (getArea(p, corner[1], corner[2]) / area);            float bw = (float) (getArea(p, corner[2], corner[0]) / area);            float cw = (float) (getArea(p, corner[0], corner[1]) / area);            for (int i = 0; i < numberOfColorComponents; i++) {                                pCol[i] = color[0][i] * aw + color[1][i] * bw + color[2][i] * cw;            }            break;    }    return pCol;}
public String pdfbox_f5501_0()
{    return corner[0] + " " + corner[1] + " " + corner[2];}
 PDColorSpace pdfbox_f5502_0()
{    return shadingColorSpace;}
 PDShading pdfbox_f5503_0()
{    return shading;}
 float[] pdfbox_f5504_0()
{    return background;}
 int pdfbox_f5505_0()
{    return rgbBackground;}
 final int pdfbox_f5506_0(float[] values) throws IOException
{    int normRGBValues;    float[] rgbValues = shadingColorSpace.toRGB(values);    normRGBValues = (int) (rgbValues[0] * 255);    normRGBValues |= (int) (rgbValues[1] * 255) << 8;    normRGBValues |= (int) (rgbValues[2] * 255) << 16;    return normRGBValues;}
 ColorModel pdfbox_f5507_0()
{    return outputColorModel;}
 void pdfbox_f5508_0()
{    outputColorModel = null;    shadingColorSpace = null;}
public T pdfbox_f5509_0()
{    return shading;}
public Matrix pdfbox_f5510_0()
{    return matrix;}
private Point2D[][] pdfbox_f5511_0(Point2D[] tcp)
{    Point2D[][] square = new Point2D[4][4];    for (int i = 0; i <= 3; i++) {        square[0][i] = tcp[i];        square[3][i] = tcp[9 - i];    }    for (int i = 1; i <= 2; i++) {        square[i][0] = tcp[12 - i];        square[i][2] = tcp[12 + i];        square[i][3] = tcp[3 + i];    }    square[1][1] = tcp[12];    square[2][1] = tcp[15];    return square;}
private int[] pdfbox_f5512_0()
{    int[] l = { 4, 4 };    Point2D[] ctlC1 = new Point2D[4];    Point2D[] ctlC2 = new Point2D[4];    for (int j = 0; j < 4; j++) {        ctlC1[j] = controlPoints[j][0];        ctlC2[j] = controlPoints[j][3];    }        if (isEdgeALine(ctlC1) && isEdgeALine(ctlC2)) {        /*             if any of the 4 inner control points is out of the patch formed by the 4 edges,              keep the high dividing level,              otherwise, determine the dividing level by the lengths of edges             */        if (isOnSameSideCC(controlPoints[1][1]) || isOnSameSideCC(controlPoints[1][2]) || isOnSameSideCC(controlPoints[2][1]) || isOnSameSideCC(controlPoints[2][2])) {                } else {                        double lc1 = getLen(ctlC1[0], ctlC1[3]), lc2 = getLen(ctlC2[0], ctlC2[3]);            if (lc1 > 800 || lc2 > 800) {                        } else if (lc1 > 400 || lc2 > 400) {                l[0] = 3;            } else if (lc1 > 200 || lc2 > 200) {                l[0] = 2;            } else {                l[0] = 1;            }        }    }        if (isEdgeALine(controlPoints[0]) && isEdgeALine(controlPoints[3])) {        if (isOnSameSideDD(controlPoints[1][1]) || isOnSameSideDD(controlPoints[1][2]) || isOnSameSideDD(controlPoints[2][1]) || isOnSameSideDD(controlPoints[2][2])) {                } else {            double ld1 = getLen(controlPoints[0][0], controlPoints[0][3]);            double ld2 = getLen(controlPoints[3][0], controlPoints[3][3]);            if (ld1 > 800 || ld2 > 800) {                        } else if (ld1 > 400 || ld2 > 400) {                l[1] = 3;            } else if (ld1 > 200 || ld2 > 200) {                l[1] = 2;            } else {                l[1] = 1;            }        }    }    return l;}
private boolean pdfbox_f5513_0(Point2D p)
{    double cc = edgeEquationValue(p, controlPoints[0][0], controlPoints[3][0]) * edgeEquationValue(p, controlPoints[0][3], controlPoints[3][3]);    return cc > 0;}
private boolean pdfbox_f5514_0(Point2D p)
{    double dd = edgeEquationValue(p, controlPoints[0][0], controlPoints[0][3]) * edgeEquationValue(p, controlPoints[3][0], controlPoints[3][3]);    return dd > 0;}
private List<ShadedTriangle> pdfbox_f5515_0()
{    CoordinateColorPair[][] patchCC = getPatchCoordinatesColor();    return getShadedTriangles(patchCC);}
protected Point2D[] pdfbox_f5516_0()
{    Point2D[] implicitEdge = new Point2D[4];    for (int i = 0; i < 4; i++) {        implicitEdge[i] = controlPoints[i][3];    }    return implicitEdge;}
protected Point2D[] pdfbox_f5517_0()
{    Point2D[] implicitEdge = new Point2D[4];    for (int i = 0; i < 4; i++) {        implicitEdge[i] = controlPoints[3][3 - i];    }    return implicitEdge;}
protected Point2D[] pdfbox_f5518_0()
{    Point2D[] implicitEdge = new Point2D[4];    for (int i = 0; i < 4; i++) {        implicitEdge[i] = controlPoints[3 - i][0];    }    return implicitEdge;}
private CoordinateColorPair[][] pdfbox_f5519_0()
{    int numberOfColorComponents = cornerColor[0].length;    double[][] bernsteinPolyU = getBernsteinPolynomials(level[0]);    int szU = bernsteinPolyU[0].length;    double[][] bernsteinPolyV = getBernsteinPolynomials(level[1]);    int szV = bernsteinPolyV[0].length;    CoordinateColorPair[][] patchCC = new CoordinateColorPair[szV][szU];    double stepU = 1.0 / (szU - 1);    double stepV = 1.0 / (szV - 1);    double v = -stepV;    for (int k = 0; k < szV; k++) {                v += stepV;        double u = -stepU;        for (int l = 0; l < szU; l++) {            double tmpx = 0.0;            double tmpy = 0.0;                        for (int i = 0; i < 4; i++) {                for (int j = 0; j < 4; j++) {                    tmpx += controlPoints[i][j].getX() * bernsteinPolyU[i][l] * bernsteinPolyV[j][k];                    tmpy += controlPoints[i][j].getY() * bernsteinPolyU[i][l] * bernsteinPolyV[j][k];                }            }            Point2D tmpC = new Point2D.Double(tmpx, tmpy);            u += stepU;            float[] paramSC = new float[numberOfColorComponents];            for (int ci = 0; ci < numberOfColorComponents; ci++) {                paramSC[ci] = (float) ((1 - v) * ((1 - u) * cornerColor[0][ci] + u * cornerColor[3][ci]) +                 v * ((1 - u) * cornerColor[1][ci] + u * cornerColor[2][ci]));            }            patchCC[k][l] = new CoordinateColorPair(tmpC, paramSC);        }    }    return patchCC;}
private double[][] pdfbox_f5520_0(int lvl)
{    int sz = (1 << lvl) + 1;    double[][] poly = new double[4][sz];    double step = 1.0 / (sz - 1);    double t = -step;    for (int i = 0; i < sz; i++) {        t += step;        poly[0][i] = (1 - t) * (1 - t) * (1 - t);        poly[1][i] = 3 * t * (1 - t) * (1 - t);        poly[2][i] = 3 * t * t * (1 - t);        poly[3][i] = t * t * t;    }    return poly;}
protected final void pdfbox_f5521_0(Rectangle deviceBounds) throws IOException
{    pixelTable = calcPixelTable(deviceBounds);}
protected void pdfbox_f5522_0(List<ShadedTriangle> triangleList, Map<Point, Integer> map, Rectangle deviceBounds) throws IOException
{    for (ShadedTriangle tri : triangleList) {        int degree = tri.getDeg();        if (degree == 2) {            Line line = tri.getLine();            for (Point p : line.linePoints) {                map.put(p, evalFunctionAndConvertToRGB(line.calcColor(p)));            }        } else {            int[] boundary = tri.getBoundary();            boundary[0] = Math.max(boundary[0], deviceBounds.x);            boundary[1] = Math.min(boundary[1], deviceBounds.x + deviceBounds.width);            boundary[2] = Math.max(boundary[2], deviceBounds.y);            boundary[3] = Math.min(boundary[3], deviceBounds.y + deviceBounds.height);            for (int x = boundary[0]; x <= boundary[1]; x++) {                for (int y = boundary[2]; y <= boundary[3]; y++) {                    Point p = new IntPoint(x, y);                    if (tri.contains(p)) {                        map.put(p, evalFunctionAndConvertToRGB(tri.calcColor(p)));                    }                }            }                                    Point p0 = new IntPoint((int) Math.round(tri.corner[0].getX()), (int) Math.round(tri.corner[0].getY()));            Point p1 = new IntPoint((int) Math.round(tri.corner[1].getX()), (int) Math.round(tri.corner[1].getY()));            Point p2 = new IntPoint((int) Math.round(tri.corner[2].getX()), (int) Math.round(tri.corner[2].getY()));            Line l1 = new Line(p0, p1, tri.color[0], tri.color[1]);            Line l2 = new Line(p1, p2, tri.color[1], tri.color[2]);            Line l3 = new Line(p2, p0, tri.color[2], tri.color[0]);            for (Point p : l1.linePoints) {                map.put(p, evalFunctionAndConvertToRGB(l1.calcColor(p)));            }            for (Point p : l2.linePoints) {                map.put(p, evalFunctionAndConvertToRGB(l2.calcColor(p)));            }            for (Point p : l3.linePoints) {                map.put(p, evalFunctionAndConvertToRGB(l3.calcColor(p)));            }        }    }}
private int pdfbox_f5523_0(float[] values) throws IOException
{    if (hasFunction) {        values = getShading().evalFunction(values);    }    return convertToRGB(values);}
public final ColorModel pdfbox_f5524_0()
{    return super.getColorModel();}
public void pdfbox_f5525_0()
{    super.dispose();}
public final Raster pdfbox_f5526_0(int x, int y, int w, int h)
{    WritableRaster raster = getColorModel().createCompatibleWritableRaster(w, h);    int[] data = new int[w * h * 4];    if (!isDataEmpty() || getBackground() != null) {        for (int row = 0; row < h; row++) {            for (int col = 0; col < w; col++) {                Point p = new IntPoint(x + col, y + row);                int value;                Integer v = pixelTable.get(p);                if (v != null) {                    value = v;                } else {                    if (getBackground() == null) {                        continue;                    }                    value = getRgbBackground();                }                int index = (row * w + col) * 4;                data[index] = value & 255;                value >>= 8;                data[index + 1] = value & 255;                value >>= 8;                data[index + 2] = value & 255;                data[index + 3] = 255;            }        }    }    raster.setPixels(0, 0, w, h, data);    return raster;}
public void pdfbox_f5527_0()
{    super.dispose();    type1ShadingType = null;}
public ColorModel pdfbox_f5528_0()
{    return super.getColorModel();}
public Raster pdfbox_f5529_1(int x, int y, int w, int h)
{    WritableRaster raster = getColorModel().createCompatibleWritableRaster(w, h);    int[] data = new int[w * h * 4];    for (int j = 0; j < h; j++) {        for (int i = 0; i < w; i++) {            int index = (j * w + i) * 4;            boolean useBackground = false;            float[] values = new float[] { x + i, y + j };            rat.transform(values, 0, values, 0, 1);            if (values[0] < domain[0] || values[0] > domain[1] || values[1] < domain[2] || values[1] > domain[3]) {                if (getBackground() == null) {                    continue;                }                useBackground = true;            }                        if (useBackground) {                values = getBackground();            } else {                try {                    values = type1ShadingType.evalFunction(values);                } catch (IOException e) {                                    }            }                        PDColorSpace shadingColorSpace = getShadingColorSpace();            if (shadingColorSpace != null) {                try {                    values = shadingColorSpace.toRGB(values);                } catch (IOException e) {                                    }            }            data[index] = (int) (values[0] * 255);            data[index + 1] = (int) (values[1] * 255);            data[index + 2] = (int) (values[2] * 255);            data[index + 3] = 255;        }    }    raster.setPixels(0, 0, w, h, data);    return raster;}
public float[] pdfbox_f5530_0()
{    return domain;}
public int pdfbox_f5531_0()
{    return 0;}
public PaintContext pdfbox_f5532_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new Type1ShadingContext(shading, cm, xform, matrix);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
private List<ShadedTriangle> pdfbox_f5533_1(PDShadingType4 freeTriangleShadingType, AffineTransform xform, Matrix matrix) throws IOException
{    COSDictionary dict = freeTriangleShadingType.getCOSObject();    if (!(dict instanceof COSStream)) {        return Collections.emptyList();    }    PDRange rangeX = freeTriangleShadingType.getDecodeForParameter(0);    PDRange rangeY = freeTriangleShadingType.getDecodeForParameter(1);    if (Float.compare(rangeX.getMin(), rangeX.getMax()) == 0 || Float.compare(rangeY.getMin(), rangeY.getMax()) == 0) {        return Collections.emptyList();    }    PDRange[] colRange = new PDRange[numberOfColorComponents];    for (int i = 0; i < numberOfColorComponents; ++i) {        colRange[i] = freeTriangleShadingType.getDecodeForParameter(2 + i);    }    List<ShadedTriangle> list = new ArrayList<>();    long maxSrcCoord = (long) Math.pow(2, bitsPerCoordinate) - 1;    long maxSrcColor = (long) Math.pow(2, bitsPerColorComponent) - 1;    COSStream stream = (COSStream) dict;    try (ImageInputStream mciis = new MemoryCacheImageInputStream(stream.createInputStream())) {        byte flag = (byte) 0;        try {            flag = (byte) (mciis.readBits(bitsPerFlag) & 3);        } catch (EOFException ex) {                    }        boolean eof = false;        while (!eof) {            Vertex p0, p1, p2;            Point2D[] ps;            float[][] cs;            int lastIndex;            try {                switch(flag) {                    case 0:                        p0 = readVertex(mciis, maxSrcCoord, maxSrcColor, rangeX, rangeY, colRange, matrix, xform);                        flag = (byte) (mciis.readBits(bitsPerFlag) & 3);                        if (flag != 0) {                                                    }                        p1 = readVertex(mciis, maxSrcCoord, maxSrcColor, rangeX, rangeY, colRange, matrix, xform);                        mciis.readBits(bitsPerFlag);                        if (flag != 0) {                                                    }                        p2 = readVertex(mciis, maxSrcCoord, maxSrcColor, rangeX, rangeY, colRange, matrix, xform);                        ps = new Point2D[] { p0.point, p1.point, p2.point };                        cs = new float[][] { p0.color, p1.color, p2.color };                        list.add(new ShadedTriangle(ps, cs));                        flag = (byte) (mciis.readBits(bitsPerFlag) & 3);                        break;                    case 1:                    case 2:                        lastIndex = list.size() - 1;                        if (lastIndex < 0) {                                                    } else {                            ShadedTriangle preTri = list.get(lastIndex);                            p2 = readVertex(mciis, maxSrcCoord, maxSrcColor, rangeX, rangeY, colRange, matrix, xform);                            ps = new Point2D[] { flag == 1 ? preTri.corner[1] : preTri.corner[0], preTri.corner[2], p2.point };                            cs = new float[][] { flag == 1 ? preTri.color[1] : preTri.color[0], preTri.color[2], p2.color };                            list.add(new ShadedTriangle(ps, cs));                            flag = (byte) (mciis.readBits(bitsPerFlag) & 3);                        }                        break;                    default:                                                break;                }            } catch (EOFException ex) {                eof = true;            }        }    }    return list;}
public int pdfbox_f5534_0()
{    return 0;}
public PaintContext pdfbox_f5535_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new Type4ShadingContext(shading, cm, xform, matrix, deviceBounds);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
private List<ShadedTriangle> pdfbox_f5536_0(PDShadingType5 latticeTriangleShadingType, AffineTransform xform, Matrix matrix) throws IOException
{    COSDictionary dict = latticeTriangleShadingType.getCOSObject();    if (!(dict instanceof COSStream)) {        return Collections.emptyList();    }    PDRange rangeX = latticeTriangleShadingType.getDecodeForParameter(0);    PDRange rangeY = latticeTriangleShadingType.getDecodeForParameter(1);    if (Float.compare(rangeX.getMin(), rangeX.getMax()) == 0 || Float.compare(rangeY.getMin(), rangeY.getMax()) == 0) {        return Collections.emptyList();    }    int numPerRow = latticeTriangleShadingType.getVerticesPerRow();    PDRange[] colRange = new PDRange[numberOfColorComponents];    for (int i = 0; i < numberOfColorComponents; ++i) {        colRange[i] = latticeTriangleShadingType.getDecodeForParameter(2 + i);    }    List<Vertex> vlist = new ArrayList<>();    long maxSrcCoord = (long) Math.pow(2, bitsPerCoordinate) - 1;    long maxSrcColor = (long) Math.pow(2, bitsPerColorComponent) - 1;    COSStream cosStream = (COSStream) dict;    try (ImageInputStream mciis = new MemoryCacheImageInputStream(cosStream.createInputStream())) {        boolean eof = false;        while (!eof) {            Vertex p;            try {                p = readVertex(mciis, maxSrcCoord, maxSrcColor, rangeX, rangeY, colRange, matrix, xform);                vlist.add(p);            } catch (EOFException ex) {                eof = true;            }        }    }    int rowNum = vlist.size() / numPerRow;    Vertex[][] latticeArray = new Vertex[rowNum][numPerRow];    List<ShadedTriangle> list = new ArrayList<>();    if (rowNum < 2) {                return list;    }    for (int i = 0; i < rowNum; i++) {        for (int j = 0; j < numPerRow; j++) {            latticeArray[i][j] = vlist.get(i * numPerRow + j);        }    }    for (int i = 0; i < rowNum - 1; i++) {        for (int j = 0; j < numPerRow - 1; j++) {            Point2D[] ps = new Point2D[] { latticeArray[i][j].point, latticeArray[i][j + 1].point, latticeArray[i + 1][j].point };            float[][] cs = new float[][] { latticeArray[i][j].color, latticeArray[i][j + 1].color, latticeArray[i + 1][j].color };            list.add(new ShadedTriangle(ps, cs));            ps = new Point2D[] { latticeArray[i][j + 1].point, latticeArray[i + 1][j].point, latticeArray[i + 1][j + 1].point };            cs = new float[][] { latticeArray[i][j + 1].color, latticeArray[i + 1][j].color, latticeArray[i + 1][j + 1].color };            list.add(new ShadedTriangle(ps, cs));        }    }    return list;}
public int pdfbox_f5537_0()
{    return 0;}
public PaintContext pdfbox_f5538_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new Type5ShadingContext(shading, cm, xform, matrix, deviceBounds);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
protected Patch pdfbox_f5539_0(Point2D[] points, float[][] color)
{    return new CoonsPatch(points, color);}
public int pdfbox_f5540_0()
{    return 0;}
public PaintContext pdfbox_f5541_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new Type6ShadingContext(shading, cm, xform, matrix, deviceBounds);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
protected Patch pdfbox_f5542_0(Point2D[] points, float[][] color)
{    return new TensorPatch(points, color);}
public int pdfbox_f5543_0()
{    return 0;}
public PaintContext pdfbox_f5544_1(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints)
{    try {        return new Type7ShadingContext(shading, cm, xform, matrix, deviceBounds);    } catch (IOException e) {                return new Color(0, 0, 0, 0).createContext(cm, deviceBounds, userBounds, xform, hints);    }}
public String pdfbox_f5545_0()
{    StringBuilder sb = new StringBuilder();    for (float f : color) {        if (sb.length() > 0) {            sb.append(' ');        }        sb.append(String.format("%3.2f", f));    }    return "Vertex{ " + point + ", colors=[" + sb + "] }";}
public void pdfbox_f5546_0(PDGraphicsState gs) throws IOException
{    for (COSName key : dict.keySet()) {        if (key.equals(COSName.LW)) {            gs.setLineWidth(defaultIfNull(getLineWidth(), 1));        } else if (key.equals(COSName.LC)) {            gs.setLineCap(getLineCapStyle());        } else if (key.equals(COSName.LJ)) {            gs.setLineJoin(getLineJoinStyle());        } else if (key.equals(COSName.ML)) {            gs.setMiterLimit(defaultIfNull(getMiterLimit(), 10));        } else if (key.equals(COSName.D)) {            gs.setLineDashPattern(getLineDashPattern());        } else if (key.equals(COSName.RI)) {            gs.setRenderingIntent(getRenderingIntent());        } else if (key.equals(COSName.OPM)) {            gs.setOverprintMode(defaultIfNull(getOverprintMode(), 0));        } else if (key.equals(COSName.OP)) {            gs.setOverprint(getStrokingOverprintControl());        } else if (key.equals(COSName.OP_NS)) {            gs.setNonStrokingOverprint(getNonStrokingOverprintControl());        } else if (key.equals(COSName.FONT)) {            PDFontSetting setting = getFontSetting();            if (setting != null) {                gs.getTextState().setFont(setting.getFont());                gs.getTextState().setFontSize(setting.getFontSize());            }        } else if (key.equals(COSName.FL)) {            gs.setFlatness(defaultIfNull(getFlatnessTolerance(), 1.0f));        } else if (key.equals(COSName.SM)) {            gs.setSmoothness(defaultIfNull(getSmoothnessTolerance(), 0));        } else if (key.equals(COSName.SA)) {            gs.setStrokeAdjustment(getAutomaticStrokeAdjustment());        } else if (key.equals(COSName.CA)) {            gs.setAlphaConstant(defaultIfNull(getStrokingAlphaConstant(), 1.0f));        } else if (key.equals(COSName.CA_NS)) {            gs.setNonStrokeAlphaConstant(defaultIfNull(getNonStrokingAlphaConstant(), 1.0f));        } else if (key.equals(COSName.AIS)) {            gs.setAlphaSource(getAlphaSourceFlag());        } else if (key.equals(COSName.TK)) {            gs.getTextState().setKnockoutFlag(getTextKnockoutFlag());        } else if (key.equals(COSName.SMASK)) {            PDSoftMask softmask = getSoftMask();            if (softmask != null) {                                                softmask.setInitialTransformationMatrix(gs.getCurrentTransformationMatrix().clone());            }            gs.setSoftMask(softmask);        } else if (key.equals(COSName.BM)) {            gs.setBlendMode(getBlendMode());        } else if (key.equals(COSName.TR)) {            if (dict.containsKey(COSName.TR2)) {                                continue;            }            gs.setTransfer(getTransfer());        } else if (key.equals(COSName.TR2)) {            gs.setTransfer(getTransfer2());        }    }}
private float pdfbox_f5547_0(Float standardValue, float defaultValue)
{    return standardValue != null ? standardValue : defaultValue;}
public COSDictionary pdfbox_f5548_0()
{    return dict;}
public Float pdfbox_f5549_0()
{    return getFloatItem(COSName.LW);}
public void pdfbox_f5550_0(Float width)
{    setFloatItem(COSName.LW, width);}
public int pdfbox_f5551_0()
{    return dict.getInt(COSName.LC);}
public void pdfbox_f5552_0(int style)
{    dict.setInt(COSName.LC, style);}
public int pdfbox_f5553_0()
{    return dict.getInt(COSName.LJ);}
public void pdfbox_f5554_0(int style)
{    dict.setInt(COSName.LJ, style);}
public Float pdfbox_f5555_0()
{    return getFloatItem(COSName.ML);}
public void pdfbox_f5556_0(Float miterLimit)
{    setFloatItem(COSName.ML, miterLimit);}
public PDLineDashPattern pdfbox_f5557_0()
{    PDLineDashPattern retval = null;    COSBase dp = dict.getDictionaryObject(COSName.D);    if (dp instanceof COSArray && ((COSArray) dp).size() == 2) {        COSBase dashArray = ((COSArray) dp).getObject(0);        COSBase phase = ((COSArray) dp).getObject(1);        if (dashArray instanceof COSArray && phase instanceof COSNumber) {            retval = new PDLineDashPattern((COSArray) dashArray, ((COSNumber) phase).intValue());        }    }    return retval;}
public void pdfbox_f5558_0(PDLineDashPattern dashPattern)
{    dict.setItem(COSName.D, dashPattern.getCOSObject());}
public RenderingIntent pdfbox_f5559_0()
{    String ri = dict.getNameAsString("RI");    if (ri != null) {        return RenderingIntent.fromString(ri);    } else {        return null;    }}
public void pdfbox_f5560_0(String ri)
{    dict.setName("RI", ri);}
public boolean pdfbox_f5561_0()
{    return dict.getBoolean(COSName.OP, false);}
public void pdfbox_f5562_0(boolean op)
{    dict.setBoolean(COSName.OP, op);}
public boolean pdfbox_f5563_0()
{    return dict.getBoolean(COSName.OP_NS, getStrokingOverprintControl());}
public void pdfbox_f5564_0(boolean op)
{    dict.setBoolean(COSName.OP_NS, op);}
public Float pdfbox_f5565_0()
{    return getFloatItem(COSName.OPM);}
public void pdfbox_f5566_0(Float overprintMode)
{    setFloatItem(COSName.OPM, overprintMode);}
public PDFontSetting pdfbox_f5567_0()
{    PDFontSetting setting = null;    COSBase base = dict.getDictionaryObject(COSName.FONT);    if (base instanceof COSArray) {        COSArray font = (COSArray) base;        setting = new PDFontSetting(font);    }    return setting;}
public void pdfbox_f5568_0(PDFontSetting fs)
{    dict.setItem(COSName.FONT, fs);}
public Float pdfbox_f5569_0()
{    return getFloatItem(COSName.FL);}
public void pdfbox_f5570_0(Float flatness)
{    setFloatItem(COSName.FL, flatness);}
public Float pdfbox_f5571_0()
{    return getFloatItem(COSName.SM);}
public void pdfbox_f5572_0(Float smoothness)
{    setFloatItem(COSName.SM, smoothness);}
public boolean pdfbox_f5573_0()
{    return dict.getBoolean(COSName.SA, false);}
public void pdfbox_f5574_0(boolean sa)
{    dict.setBoolean(COSName.SA, sa);}
public Float pdfbox_f5575_0()
{    return getFloatItem(COSName.CA);}
public void pdfbox_f5576_0(Float alpha)
{    setFloatItem(COSName.CA, alpha);}
public Float pdfbox_f5577_0()
{    return getFloatItem(COSName.CA_NS);}
public void pdfbox_f5578_0(Float alpha)
{    setFloatItem(COSName.CA_NS, alpha);}
public boolean pdfbox_f5579_0()
{    return dict.getBoolean(COSName.AIS, false);}
public void pdfbox_f5580_0(boolean alpha)
{    dict.setBoolean(COSName.AIS, alpha);}
public BlendMode pdfbox_f5581_0()
{    return BlendMode.getInstance(dict.getDictionaryObject(COSName.BM));}
public void pdfbox_f5582_0(BlendMode bm)
{    dict.setItem(COSName.BM, BlendMode.getCOSName(bm));}
public PDSoftMask pdfbox_f5583_0()
{    if (!dict.containsKey(COSName.SMASK)) {        return null;    }    return PDSoftMask.create(dict.getDictionaryObject(COSName.SMASK));}
public boolean pdfbox_f5584_0()
{    return dict.getBoolean(COSName.TK, true);}
public void pdfbox_f5585_0(boolean tk)
{    dict.setBoolean(COSName.TK, tk);}
private Float pdfbox_f5586_0(COSName key)
{    Float retval = null;    COSBase base = dict.getDictionaryObject(key);    if (base instanceof COSNumber) {        COSNumber value = (COSNumber) base;        retval = value.floatValue();    }    return retval;}
private void pdfbox_f5587_0(COSName key, Float value)
{    if (value == null) {        dict.removeItem(key);    } else {        dict.setItem(key, new COSFloat(value));    }}
public COSBase pdfbox_f5588_0()
{    COSBase base = dict.getDictionaryObject(COSName.TR);    if (base instanceof COSArray && ((COSArray) base).size() != 4) {        return null;    }    return base;}
public void pdfbox_f5589_0(COSBase transfer)
{    dict.setItem(COSName.TR, transfer);}
public COSBase pdfbox_f5590_0()
{    COSBase base = dict.getDictionaryObject(COSName.TR2);    if (base instanceof COSArray && ((COSArray) base).size() != 4) {        return null;    }    return base;}
public void pdfbox_f5591_0(COSBase transfer2)
{    dict.setItem(COSName.TR2, transfer2);}
public Matrix pdfbox_f5592_0()
{    return currentTransformationMatrix;}
public void pdfbox_f5593_0(Matrix value)
{    currentTransformationMatrix = value;}
public float pdfbox_f5594_0()
{    return lineWidth;}
public void pdfbox_f5595_0(float value)
{    lineWidth = value;}
public int pdfbox_f5596_0()
{    return lineCap;}
public void pdfbox_f5597_0(int value)
{    lineCap = value;}
public int pdfbox_f5598_0()
{    return lineJoin;}
public void pdfbox_f5599_0(int value)
{    lineJoin = value;}
public float pdfbox_f5600_0()
{    return miterLimit;}
public void pdfbox_f5601_0(float value)
{    miterLimit = value;}
public boolean pdfbox_f5602_0()
{    return strokeAdjustment;}
public void pdfbox_f5603_0(boolean value)
{    strokeAdjustment = value;}
public double pdfbox_f5604_0()
{    return alphaConstant;}
public void pdfbox_f5605_0(double value)
{    alphaConstant = value;}
public double pdfbox_f5606_0()
{    return nonStrokingAlphaConstant;}
public void pdfbox_f5607_0(double value)
{    nonStrokingAlphaConstant = value;}
public boolean pdfbox_f5608_0()
{    return alphaSource;}
public void pdfbox_f5609_0(boolean value)
{    alphaSource = value;}
public PDSoftMask pdfbox_f5610_0()
{    return softMask;}
public void pdfbox_f5611_0(PDSoftMask softMask)
{    this.softMask = softMask;}
public BlendMode pdfbox_f5612_0()
{    return blendMode;}
public void pdfbox_f5613_0(BlendMode blendMode)
{    this.blendMode = blendMode;}
public boolean pdfbox_f5614_0()
{    return overprint;}
public void pdfbox_f5615_0(boolean value)
{    overprint = value;}
public boolean pdfbox_f5616_0()
{    return nonStrokingOverprint;}
public void pdfbox_f5617_0(boolean value)
{    nonStrokingOverprint = value;}
public double pdfbox_f5618_0()
{    return overprintMode;}
public void pdfbox_f5619_0(double value)
{    overprintMode = value;}
public double pdfbox_f5620_0()
{    return flatness;}
public void pdfbox_f5621_0(double value)
{    flatness = value;}
public double pdfbox_f5622_0()
{    return smoothness;}
public void pdfbox_f5623_0(double value)
{    smoothness = value;}
public PDTextState pdfbox_f5624_0()
{    return textState;}
public void pdfbox_f5625_0(PDTextState value)
{    textState = value;}
public PDLineDashPattern pdfbox_f5626_0()
{    return lineDashPattern;}
public void pdfbox_f5627_0(PDLineDashPattern value)
{    lineDashPattern = value;}
public RenderingIntent pdfbox_f5628_0()
{    return renderingIntent;}
public void pdfbox_f5629_0(RenderingIntent value)
{    renderingIntent = value;}
public PDGraphicsState pdfbox_f5630_0()
{    try {        PDGraphicsState clone = (PDGraphicsState) super.clone();        clone.textState = textState.clone();        clone.currentTransformationMatrix = currentTransformationMatrix.clone();                clone.strokingColor = strokingColor;                clone.nonStrokingColor = nonStrokingColor;                clone.lineDashPattern = lineDashPattern;                clone.clippingPath = clippingPath;        clone.isClippingPathDirty = false;        return clone;    } catch (CloneNotSupportedException e) {                throw new RuntimeException(e);    }}
public PDColor pdfbox_f5631_0()
{    return strokingColor;}
public void pdfbox_f5632_0(PDColor color)
{    strokingColor = color;}
public PDColor pdfbox_f5633_0()
{    return nonStrokingColor;}
public void pdfbox_f5634_0(PDColor color)
{    nonStrokingColor = color;}
public PDColorSpace pdfbox_f5635_0()
{    return strokingColorSpace;}
public void pdfbox_f5636_0(PDColorSpace colorSpace)
{    strokingColorSpace = colorSpace;}
public PDColorSpace pdfbox_f5637_0()
{    return nonStrokingColorSpace;}
public void pdfbox_f5638_0(PDColorSpace colorSpace)
{    nonStrokingColorSpace = colorSpace;}
public void pdfbox_f5639_0(GeneralPath path)
{    intersectClippingPath(new Area(path));}
public void pdfbox_f5640_0(Area area)
{        if (!isClippingPathDirty) {                Area cloned = new Area();        cloned.add(clippingPath);        clippingPath = cloned;        isClippingPathDirty = true;    }        clippingPath.intersect(area);}
public Area pdfbox_f5641_0()
{    return clippingPath;}
public Composite pdfbox_f5642_0()
{    return BlendComposite.getInstance(blendMode, (float) alphaConstant);}
public Composite pdfbox_f5643_0()
{    return BlendComposite.getInstance(blendMode, (float) nonStrokingAlphaConstant);}
public COSBase pdfbox_f5644_0()
{    return transfer;}
public void pdfbox_f5645_0(COSBase transfer)
{    this.transfer = transfer;}
public static PDSoftMask pdfbox_f5646_1(COSBase dictionary)
{    if (dictionary instanceof COSName) {        if (COSName.NONE.equals(dictionary)) {            return null;        } else {                        return null;        }    } else if (dictionary instanceof COSDictionary) {        return new PDSoftMask((COSDictionary) dictionary);    } else {                return null;    }}
public COSDictionary pdfbox_f5647_0()
{    return dictionary;}
public COSName pdfbox_f5648_0()
{    if (subType == null) {        subType = (COSName) getCOSObject().getDictionaryObject(COSName.S);    }    return subType;}
public PDTransparencyGroup pdfbox_f5649_0() throws IOException
{    if (group == null) {        COSBase cosGroup = getCOSObject().getDictionaryObject(COSName.G);        if (cosGroup != null) {            PDXObject x = PDXObject.createXObject(cosGroup, null);            if (x instanceof PDTransparencyGroup) {                group = (PDTransparencyGroup) x;            }        }    }    return group;}
public COSArray pdfbox_f5650_0()
{    if (backdropColor == null) {        backdropColor = (COSArray) getCOSObject().getDictionaryObject(COSName.BC);    }    return backdropColor;}
public PDFunction pdfbox_f5651_0() throws IOException
{    if (transferFunction == null) {        COSBase cosTF = getCOSObject().getDictionaryObject(COSName.TR);        if (cosTF != null) {            transferFunction = PDFunction.create(cosTF);        }    }    return transferFunction;}
 void pdfbox_f5652_0(Matrix ctm)
{    this.ctm = ctm;}
public Matrix pdfbox_f5653_0()
{    return ctm;}
public float pdfbox_f5654_0()
{    return characterSpacing;}
public void pdfbox_f5655_0(float value)
{    characterSpacing = value;}
public float pdfbox_f5656_0()
{    return wordSpacing;}
public void pdfbox_f5657_0(float value)
{    wordSpacing = value;}
public float pdfbox_f5658_0()
{    return horizontalScaling;}
public void pdfbox_f5659_0(float value)
{    horizontalScaling = value;}
public float pdfbox_f5660_0()
{    return leading;}
public void pdfbox_f5661_0(float value)
{    leading = value;}
public PDFont pdfbox_f5662_0()
{    return font;}
public void pdfbox_f5663_0(PDFont value)
{    font = value;}
public float pdfbox_f5664_0()
{    return fontSize;}
public void pdfbox_f5665_0(float value)
{    fontSize = value;}
public RenderingMode pdfbox_f5666_0()
{    return renderingMode;}
public void pdfbox_f5667_0(RenderingMode renderingMode)
{    this.renderingMode = renderingMode;}
public float pdfbox_f5668_0()
{    return rise;}
public void pdfbox_f5669_0(float value)
{    rise = value;}
public boolean pdfbox_f5670_0()
{    return knockout;}
public void pdfbox_f5671_0(boolean value)
{    knockout = value;}
public PDTextState pdfbox_f5672_0()
{    try {        return (PDTextState) super.clone();    } catch (CloneNotSupportedException e) {                throw new RuntimeException(e);    }}
public static RenderingIntent pdfbox_f5673_0(String value)
{    for (RenderingIntent instance : RenderingIntent.values()) {        if (instance.value.equals(value)) {            return instance;        }    }        return RELATIVE_COLORIMETRIC;}
public String pdfbox_f5674_0()
{    return value;}
public static RenderingMode pdfbox_f5675_0(int value)
{    return VALUES[value];}
public int pdfbox_f5676_0()
{    return value;}
public boolean pdfbox_f5677_0()
{    return this == FILL || this == FILL_STROKE || this == FILL_CLIP || this == FILL_STROKE_CLIP;}
public boolean pdfbox_f5678_0()
{    return this == STROKE || this == FILL_STROKE || this == STROKE_CLIP || this == FILL_STROKE_CLIP;}
public boolean pdfbox_f5679_0()
{    return this == FILL_CLIP || this == STROKE_CLIP || this == FILL_STROKE_CLIP || this == NEITHER_CLIP;}
public COSDictionary pdfbox_f5680_0()
{    return action;}
public final String pdfbox_f5681_0()
{    return action.getNameAsString(COSName.TYPE);}
protected final void pdfbox_f5682_0(String type)
{    action.setName(COSName.TYPE, type);}
public final String pdfbox_f5683_0()
{    return action.getNameAsString(COSName.S);}
protected final void pdfbox_f5684_0(String s)
{    action.setName(COSName.S, s);}
public List<PDAction> pdfbox_f5685_0()
{    List<PDAction> retval = null;    COSBase next = action.getDictionaryObject(COSName.NEXT);    if (next instanceof COSDictionary) {        PDAction pdAction = PDActionFactory.createAction((COSDictionary) next);        retval = new COSArrayList<>(pdAction, next, action, COSName.NEXT);    } else if (next instanceof COSArray) {        COSArray array = (COSArray) next;        List<PDAction> actions = new ArrayList<>();        for (int i = 0; i < array.size(); i++) {            actions.add(PDActionFactory.createAction((COSDictionary) array.getObject(i)));        }        retval = new COSArrayList<>(actions, array);    }    return retval;}
public void pdfbox_f5686_0(List<?> next)
{    action.setItem(COSName.NEXT, COSArrayList.converterToCOSArray(next));}
public PDDestination pdfbox_f5687_0() throws IOException
{    return PDDestination.create(getCOSObject().getDictionaryObject(COSName.D));}
public void pdfbox_f5688_0(PDDestination d)
{    if (d instanceof PDPageDestination) {        PDPageDestination pageDest = (PDPageDestination) d;        COSArray destArray = pageDest.getCOSObject();        if (destArray.size() >= 1) {            COSBase page = destArray.getObject(0);            if (!(page instanceof COSDictionary)) {                throw new IllegalArgumentException("Destination of a GoToE action must be " + "a page dictionary object");            }        }    }    getCOSObject().setItem(COSName.D, d);}
public PDFileSpecification pdfbox_f5689_0() throws IOException
{    return PDFileSpecification.createFS(getCOSObject().getDictionaryObject(COSName.F));}
public void pdfbox_f5690_0(PDFileSpecification fs)
{    getCOSObject().setItem(COSName.F, fs);}
public OpenMode pdfbox_f5691_0()
{    if (getCOSObject().getDictionaryObject(COSName.NEW_WINDOW) instanceof COSBoolean) {        COSBoolean b = (COSBoolean) getCOSObject().getDictionaryObject(COSName.NEW_WINDOW);        return b.getValue() ? OpenMode.NEW_WINDOW : OpenMode.SAME_WINDOW;    }    return OpenMode.USER_PREFERENCE;}
public void pdfbox_f5692_0(OpenMode value)
{    if (null == value) {        getCOSObject().removeItem(COSName.NEW_WINDOW);        return;    }    switch(value) {        case USER_PREFERENCE:            getCOSObject().removeItem(COSName.NEW_WINDOW);            break;        case SAME_WINDOW:            getCOSObject().setBoolean(COSName.NEW_WINDOW, false);            break;        case NEW_WINDOW:            getCOSObject().setBoolean(COSName.NEW_WINDOW, true);            break;        default:                        break;    }}
public PDTargetDirectory pdfbox_f5693_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.T);    if (base instanceof COSDictionary) {        return new PDTargetDirectory((COSDictionary) base);    }    return null;}
public void pdfbox_f5694_0(PDTargetDirectory targetDirectory)
{    getCOSObject().setItem(COSName.T, targetDirectory);}
public static PDAction pdfbox_f5695_0(COSDictionary action)
{    PDAction retval = null;    if (action != null) {        String type = action.getNameAsString(COSName.S);        if (type != null) {            switch(type) {                case PDActionJavaScript.SUB_TYPE:                    retval = new PDActionJavaScript(action);                    break;                case PDActionGoTo.SUB_TYPE:                    retval = new PDActionGoTo(action);                    break;                case PDActionLaunch.SUB_TYPE:                    retval = new PDActionLaunch(action);                    break;                case PDActionRemoteGoTo.SUB_TYPE:                    retval = new PDActionRemoteGoTo(action);                    break;                case PDActionURI.SUB_TYPE:                    retval = new PDActionURI(action);                    break;                case PDActionNamed.SUB_TYPE:                    retval = new PDActionNamed(action);                    break;                case PDActionSound.SUB_TYPE:                    retval = new PDActionSound(action);                    break;                case PDActionMovie.SUB_TYPE:                    retval = new PDActionMovie(action);                    break;                case PDActionImportData.SUB_TYPE:                    retval = new PDActionImportData(action);                    break;                case PDActionResetForm.SUB_TYPE:                    retval = new PDActionResetForm(action);                    break;                case PDActionHide.SUB_TYPE:                    retval = new PDActionHide(action);                    break;                case PDActionSubmitForm.SUB_TYPE:                    retval = new PDActionSubmitForm(action);                    break;                case PDActionThread.SUB_TYPE:                    retval = new PDActionThread(action);                    break;                case PDActionEmbeddedGoTo.SUB_TYPE:                    retval = new PDActionEmbeddedGoTo(action);                    break;                default:                    break;            }        }    }    return retval;}
public PDDestination pdfbox_f5696_0() throws IOException
{    return PDDestination.create(getCOSObject().getDictionaryObject(COSName.D));}
public void pdfbox_f5697_0(PDDestination d)
{    if (d instanceof PDPageDestination) {        PDPageDestination pageDest = (PDPageDestination) d;        COSArray destArray = pageDest.getCOSObject();        if (destArray.size() >= 1) {            COSBase page = destArray.getObject(0);            if (!(page instanceof COSDictionary)) {                throw new IllegalArgumentException("Destination of a GoTo action must be " + "a page dictionary object");            }        }    }    getCOSObject().setItem(COSName.D, d);}
public COSBase pdfbox_f5698_0()
{        return this.action.getDictionaryObject(COSName.T);}
public void pdfbox_f5699_0(COSBase t)
{    this.action.setItem(COSName.T, t);}
public boolean pdfbox_f5700_0()
{    return this.action.getBoolean(COSName.H, true);}
public void pdfbox_f5701_0(boolean h)
{    this.action.setItem(COSName.H, COSBoolean.getBoolean(h));}
public PDFileSpecification pdfbox_f5702_0() throws IOException
{    return PDFileSpecification.createFS(action.getDictionaryObject(COSName.F));}
public void pdfbox_f5703_0(PDFileSpecification fs)
{    action.setItem(COSName.F, fs);}
public final void pdfbox_f5704_0(String sAction)
{    action.setString(COSName.JS, sAction);}
public String pdfbox_f5705_0()
{    COSBase base = action.getDictionaryObject(COSName.JS);    if (base instanceof COSString) {        return ((COSString) base).getString();    } else if (base instanceof COSStream) {        return ((COSStream) base).toTextString();    } else {        return null;    }}
public PDFileSpecification pdfbox_f5706_0() throws IOException
{    return PDFileSpecification.createFS(getCOSObject().getDictionaryObject(COSName.F));}
public void pdfbox_f5707_0(PDFileSpecification fs)
{    getCOSObject().setItem(COSName.F, fs);}
public PDWindowsLaunchParams pdfbox_f5708_0()
{    COSDictionary win = (COSDictionary) action.getDictionaryObject("Win");    PDWindowsLaunchParams retval = null;    if (win != null) {        retval = new PDWindowsLaunchParams(win);    }    return retval;}
public void pdfbox_f5709_0(PDWindowsLaunchParams win)
{    action.setItem("Win", win);}
public String pdfbox_f5710_0()
{    return action.getString(COSName.F);}
public void pdfbox_f5711_0(String f)
{    action.setString(COSName.F, f);}
public String pdfbox_f5712_0()
{    return action.getString(COSName.D);}
public void pdfbox_f5713_0(String d)
{    action.setString(COSName.D, d);}
public String pdfbox_f5714_0()
{    return action.getString(COSName.O);}
public void pdfbox_f5715_0(String o)
{    action.setString(COSName.O, o);}
public String pdfbox_f5716_0()
{    return action.getString(COSName.P);}
public void pdfbox_f5717_0(String p)
{    action.setString(COSName.P, p);}
public OpenMode pdfbox_f5718_0()
{    if (getCOSObject().getDictionaryObject(COSName.NEW_WINDOW) instanceof COSBoolean) {        COSBoolean b = (COSBoolean) getCOSObject().getDictionaryObject(COSName.NEW_WINDOW);        return b.getValue() ? OpenMode.NEW_WINDOW : OpenMode.SAME_WINDOW;    }    return OpenMode.USER_PREFERENCE;}
public void pdfbox_f5719_0(OpenMode value)
{    if (null == value) {        getCOSObject().removeItem(COSName.NEW_WINDOW);        return;    }    switch(value) {        case USER_PREFERENCE:            getCOSObject().removeItem(COSName.NEW_WINDOW);            break;        case SAME_WINDOW:            getCOSObject().setBoolean(COSName.NEW_WINDOW, false);            break;        case NEW_WINDOW:            getCOSObject().setBoolean(COSName.NEW_WINDOW, true);            break;        default:                        break;    }}
public String pdfbox_f5720_0()
{    return action.getNameAsString("N");}
public void pdfbox_f5721_0(String name)
{    action.setName("N", name);}
public PDFileSpecification pdfbox_f5722_0() throws IOException
{    return PDFileSpecification.createFS(action.getDictionaryObject(COSName.F));}
public void pdfbox_f5723_0(PDFileSpecification fs)
{    action.setItem(COSName.F, fs);}
public COSBase pdfbox_f5724_0()
{    return action.getDictionaryObject(COSName.D);}
public void pdfbox_f5725_0(COSBase d)
{    action.setItem(COSName.D, d);}
public OpenMode pdfbox_f5726_0()
{    if (getCOSObject().getDictionaryObject(COSName.NEW_WINDOW) instanceof COSBoolean) {        COSBoolean b = (COSBoolean) getCOSObject().getDictionaryObject(COSName.NEW_WINDOW);        return b.getValue() ? OpenMode.NEW_WINDOW : OpenMode.SAME_WINDOW;    }    return OpenMode.USER_PREFERENCE;}
public void pdfbox_f5727_0(OpenMode value)
{    if (null == value) {        getCOSObject().removeItem(COSName.NEW_WINDOW);        return;    }    switch(value) {        case USER_PREFERENCE:            getCOSObject().removeItem(COSName.NEW_WINDOW);            break;        case SAME_WINDOW:            getCOSObject().setBoolean(COSName.NEW_WINDOW, false);            break;        case NEW_WINDOW:            getCOSObject().setBoolean(COSName.NEW_WINDOW, true);            break;        default:                        break;    }}
public COSArray pdfbox_f5728_0()
{    COSBase retval = this.action.getDictionaryObject(COSName.FIELDS);    return retval instanceof COSArray ? (COSArray) retval : null;}
public void pdfbox_f5729_0(COSArray array)
{    this.action.setItem(COSName.FIELDS, array);}
public int pdfbox_f5730_0()
{    return this.action.getInt(COSName.FLAGS, 0);}
public void pdfbox_f5731_0(int flags)
{    this.action.setInt(COSName.FLAGS, flags);}
public void pdfbox_f5732_0(COSStream sound)
{    action.setItem(COSName.SOUND, sound);}
public COSStream pdfbox_f5733_0()
{    COSBase base = action.getDictionaryObject(COSName.SOUND);    if (base instanceof COSStream) {        return (COSStream) base;    }    return null;}
public void pdfbox_f5734_0(float volume)
{    if (volume < -1 || volume > 1) {        throw new IllegalArgumentException("volume outside of the range −1.0 to 1.0");    }    action.setFloat(COSName.VOLUME, volume);}
public float pdfbox_f5735_0()
{    COSBase base = action.getDictionaryObject(COSName.VOLUME);    if (base instanceof COSNumber) {        float volume = ((COSNumber) base).floatValue();        if (volume < -1 || volume > 1) {            volume = 1;        }        return volume;    }    return 1;}
public void pdfbox_f5736_0(boolean synchronous)
{    action.setBoolean(COSName.SYNCHRONOUS, synchronous);}
public boolean pdfbox_f5737_0()
{    COSBase base = action.getDictionaryObject(COSName.SYNCHRONOUS);    if (base instanceof COSBoolean) {        return ((COSBoolean) base).getValue();    }    return false;}
public void pdfbox_f5738_0(boolean repeat)
{    action.setBoolean(COSName.REPEAT, repeat);}
public boolean pdfbox_f5739_0()
{    COSBase base = action.getDictionaryObject(COSName.REPEAT);    if (base instanceof COSBoolean) {        return ((COSBoolean) base).getValue();    }    return false;}
public void pdfbox_f5740_0(boolean mix)
{    action.setBoolean(COSName.MIX, mix);}
public boolean pdfbox_f5741_0()
{    COSBase base = action.getDictionaryObject(COSName.MIX);    if (base instanceof COSBoolean) {        return ((COSBoolean) base).getValue();    }    return false;}
public PDFileSpecification pdfbox_f5742_0() throws IOException
{    return PDFileSpecification.createFS(action.getDictionaryObject(COSName.F));}
public void pdfbox_f5743_0(PDFileSpecification fs)
{    action.setItem(COSName.F, fs);}
public COSArray pdfbox_f5744_0()
{    COSBase retval = this.action.getDictionaryObject(COSName.FIELDS);    return retval instanceof COSArray ? (COSArray) retval : null;}
public void pdfbox_f5745_0(COSArray array)
{    this.action.setItem(COSName.FIELDS, array);}
public int pdfbox_f5746_0()
{    return this.action.getInt(COSName.FLAGS, 0);}
public void pdfbox_f5747_0(int flags)
{    this.action.setInt(COSName.FLAGS, flags);}
public COSBase pdfbox_f5748_0()
{    return action.getDictionaryObject(COSName.D);}
public void pdfbox_f5749_0(COSBase d)
{    action.setItem(COSName.D, d);}
public PDFileSpecification pdfbox_f5750_0() throws IOException
{    return PDFileSpecification.createFS(action.getDictionaryObject(COSName.F));}
public void pdfbox_f5751_0(PDFileSpecification fs)
{    action.setItem(COSName.F, fs);}
public COSBase pdfbox_f5752_0()
{    return action.getDictionaryObject(COSName.B);}
public void pdfbox_f5753_0(COSBase b)
{    action.setItem(COSName.B, b);}
public String pdfbox_f5754_0()
{    COSBase base = action.getDictionaryObject(COSName.URI);    if (base instanceof COSString) {        byte[] bytes = ((COSString) base).getBytes();        if (bytes.length >= 2) {                        if ((bytes[0] & 0xFF) == 0xFE && (bytes[1] & 0xFF) == 0xFF) {                return action.getString(COSName.URI);            }                        if ((bytes[0] & 0xFF) == 0xFF && (bytes[1] & 0xFF) == 0xFE) {                return action.getString(COSName.URI);            }        }        return new String(bytes, Charsets.UTF_8);    }    return null;}
public void pdfbox_f5755_0(String uri)
{    action.setString(COSName.URI, uri);}
public boolean pdfbox_f5756_0()
{    return this.action.getBoolean("IsMap", false);}
public void pdfbox_f5757_0(boolean value)
{    this.action.setBoolean("IsMap", value);}
public COSDictionary pdfbox_f5758_0()
{    return actions;}
public PDAction pdfbox_f5759_0()
{    return PDActionFactory.createAction((COSDictionary) actions.getDictionaryObject(COSName.F));}
public void pdfbox_f5760_0(PDAction action)
{    actions.setItem(COSName.F, action);}
public COSDictionary pdfbox_f5761_0()
{    return actions;}
public PDAction pdfbox_f5762_0()
{    COSDictionary e = (COSDictionary) actions.getDictionaryObject("E");    PDAction retval = null;    if (e != null) {        retval = PDActionFactory.createAction(e);    }    return retval;}
public void pdfbox_f5763_0(PDAction e)
{    actions.setItem("E", e);}
public PDAction pdfbox_f5764_0()
{    COSDictionary x = (COSDictionary) actions.getDictionaryObject("X");    PDAction retval = null;    if (x != null) {        retval = PDActionFactory.createAction(x);    }    return retval;}
public void pdfbox_f5765_0(PDAction x)
{    actions.setItem("X", x);}
public PDAction pdfbox_f5766_0()
{    COSDictionary d = (COSDictionary) actions.getDictionaryObject(COSName.D);    PDAction retval = null;    if (d != null) {        retval = PDActionFactory.createAction(d);    }    return retval;}
public void pdfbox_f5767_0(PDAction d)
{    actions.setItem(COSName.D, d);}
public PDAction pdfbox_f5768_0()
{    COSDictionary u = (COSDictionary) actions.getDictionaryObject("U");    PDAction retval = null;    if (u != null) {        retval = PDActionFactory.createAction(u);    }    return retval;}
public void pdfbox_f5769_0(PDAction u)
{    actions.setItem("U", u);}
public PDAction pdfbox_f5770_0()
{    COSDictionary fo = (COSDictionary) actions.getDictionaryObject("Fo");    PDAction retval = null;    if (fo != null) {        retval = PDActionFactory.createAction(fo);    }    return retval;}
public void pdfbox_f5771_0(PDAction fo)
{    actions.setItem("Fo", fo);}
public PDAction pdfbox_f5772_0()
{    COSDictionary bl = (COSDictionary) actions.getDictionaryObject("Bl");    PDAction retval = null;    if (bl != null) {        retval = PDActionFactory.createAction(bl);    }    return retval;}
public void pdfbox_f5773_0(PDAction bl)
{    actions.setItem("Bl", bl);}
public PDAction pdfbox_f5774_0()
{    COSDictionary po = (COSDictionary) actions.getDictionaryObject("PO");    PDAction retval = null;    if (po != null) {        retval = PDActionFactory.createAction(po);    }    return retval;}
public void pdfbox_f5775_0(PDAction po)
{    actions.setItem("PO", po);}
public PDAction pdfbox_f5776_0()
{    COSDictionary pc = (COSDictionary) actions.getDictionaryObject("PC");    PDAction retval = null;    if (pc != null) {        retval = PDActionFactory.createAction(pc);    }    return retval;}
public void pdfbox_f5777_0(PDAction pc)
{    actions.setItem("PC", pc);}
public PDAction pdfbox_f5778_0()
{    COSDictionary pv = (COSDictionary) actions.getDictionaryObject("PV");    PDAction retval = null;    if (pv != null) {        retval = PDActionFactory.createAction(pv);    }    return retval;}
public void pdfbox_f5779_0(PDAction pv)
{    actions.setItem("PV", pv);}
public PDAction pdfbox_f5780_0()
{    COSDictionary pi = (COSDictionary) actions.getDictionaryObject("PI");    PDAction retval = null;    if (pi != null) {        retval = PDActionFactory.createAction(pi);    }    return retval;}
public void pdfbox_f5781_0(PDAction pi)
{    actions.setItem("PI", pi);}
public COSDictionary pdfbox_f5782_0()
{    return actions;}
public PDAction pdfbox_f5783_0()
{    COSDictionary wc = (COSDictionary) actions.getDictionaryObject("WC");    PDAction retval = null;    if (wc != null) {        retval = PDActionFactory.createAction(wc);    }    return retval;}
public void pdfbox_f5784_0(PDAction wc)
{    actions.setItem("WC", wc);}
public PDAction pdfbox_f5785_0()
{    COSDictionary ws = (COSDictionary) actions.getDictionaryObject("WS");    PDAction retval = null;    if (ws != null) {        retval = PDActionFactory.createAction(ws);    }    return retval;}
public void pdfbox_f5786_0(PDAction ws)
{    actions.setItem("WS", ws);}
public PDAction pdfbox_f5787_0()
{    COSDictionary ds = (COSDictionary) actions.getDictionaryObject("DS");    PDAction retval = null;    if (ds != null) {        retval = PDActionFactory.createAction(ds);    }    return retval;}
public void pdfbox_f5788_0(PDAction ds)
{    actions.setItem("DS", ds);}
public PDAction pdfbox_f5789_0()
{    COSDictionary wp = (COSDictionary) actions.getDictionaryObject("WP");    PDAction retval = null;    if (wp != null) {        retval = PDActionFactory.createAction(wp);    }    return retval;}
public void pdfbox_f5790_0(PDAction wp)
{    actions.setItem("WP", wp);}
public PDAction pdfbox_f5791_0()
{    COSDictionary dp = (COSDictionary) actions.getDictionaryObject("DP");    PDAction retval = null;    if (dp != null) {        retval = PDActionFactory.createAction(dp);    }    return retval;}
public void pdfbox_f5792_0(PDAction dp)
{    actions.setItem("DP", dp);}
public COSDictionary pdfbox_f5793_0()
{    return actions;}
public PDAction pdfbox_f5794_0()
{    COSDictionary k = (COSDictionary) actions.getDictionaryObject(COSName.K);    PDAction retval = null;    if (k != null) {        retval = PDActionFactory.createAction(k);    }    return retval;}
public void pdfbox_f5795_0(PDAction k)
{    actions.setItem(COSName.K, k);}
public PDAction pdfbox_f5796_0()
{    COSDictionary f = (COSDictionary) actions.getDictionaryObject(COSName.F);    PDAction retval = null;    if (f != null) {        retval = PDActionFactory.createAction(f);    }    return retval;}
public void pdfbox_f5797_0(PDAction f)
{    actions.setItem(COSName.F, f);}
public PDAction pdfbox_f5798_0()
{    COSDictionary v = (COSDictionary) actions.getDictionaryObject(COSName.V);    PDAction retval = null;    if (v != null) {        retval = PDActionFactory.createAction(v);    }    return retval;}
public void pdfbox_f5799_0(PDAction v)
{    actions.setItem(COSName.V, v);}
public PDAction pdfbox_f5800_0()
{    COSDictionary c = (COSDictionary) actions.getDictionaryObject(COSName.C);    PDAction retval = null;    if (c != null) {        retval = PDActionFactory.createAction(c);    }    return retval;}
public void pdfbox_f5801_0(PDAction c)
{    actions.setItem(COSName.C, c);}
public COSDictionary pdfbox_f5802_0()
{    return actions;}
public PDAction pdfbox_f5803_0()
{    COSDictionary o = (COSDictionary) actions.getDictionaryObject(COSName.O);    PDAction retval = null;    if (o != null) {        retval = PDActionFactory.createAction(o);    }    return retval;}
public void pdfbox_f5804_0(PDAction o)
{    actions.setItem(COSName.O, o);}
public PDAction pdfbox_f5805_0()
{    COSDictionary c = (COSDictionary) actions.getDictionaryObject("C");    PDAction retval = null;    if (c != null) {        retval = PDActionFactory.createAction(c);    }    return retval;}
public void pdfbox_f5806_0(PDAction c)
{    actions.setItem("C", c);}
public COSDictionary pdfbox_f5807_0()
{    return dict;}
public COSName pdfbox_f5808_0()
{    COSBase base = dict.getItem(COSName.R);    if (base instanceof COSName) {        return (COSName) base;    }    return null;}
public void pdfbox_f5809_0(COSName relationship)
{    if (!COSName.P.equals(relationship) && !COSName.C.equals(relationship)) {        throw new IllegalArgumentException("The only valid are P or C, not " + relationship.getName());    }    dict.setItem(COSName.R, relationship);}
public String pdfbox_f5810_0()
{    return dict.getString(COSName.N);}
public void pdfbox_f5811_0(String filename)
{    dict.setString(COSName.N, filename);}
public PDTargetDirectory pdfbox_f5812_0()
{    COSBase base = dict.getDictionaryObject(COSName.T);    if (base instanceof COSDictionary) {        return new PDTargetDirectory((COSDictionary) base);    }    return null;}
public void pdfbox_f5813_0(PDTargetDirectory targetDirectory)
{    dict.setItem(COSName.T, targetDirectory);}
public int pdfbox_f5814_0()
{    COSBase base = dict.getDictionaryObject(COSName.P);    if (base instanceof COSInteger) {        return ((COSInteger) base).intValue();    }    return -1;}
public void pdfbox_f5815_0(int pageNumber)
{    if (pageNumber < 0) {        dict.removeItem(COSName.P);    } else {        dict.setInt(COSName.P, pageNumber);    }}
public PDNamedDestination pdfbox_f5816_0()
{    COSBase base = dict.getDictionaryObject(COSName.P);    if (base instanceof COSString) {        return new PDNamedDestination((COSString) base);    }    return null;}
public void pdfbox_f5817_0(PDNamedDestination dest)
{    if (dest == null) {        dict.removeItem(COSName.P);    } else {        dict.setItem(COSName.P, dest);    }}
public int pdfbox_f5818_0()
{    COSBase base = dict.getDictionaryObject(COSName.A);    if (base instanceof COSInteger) {        return ((COSInteger) base).intValue();    }    return -1;}
public void pdfbox_f5819_0(int index)
{    if (index < 0) {        dict.removeItem(COSName.A);    } else {        dict.setInt(COSName.A, index);    }}
public String pdfbox_f5820_0()
{    COSBase base = dict.getDictionaryObject(COSName.A);    if (base instanceof COSString) {        return ((COSString) base).getString();    }    return null;}
public void pdfbox_f5821_0(String name)
{    dict.setString(COSName.A, name);}
public COSDictionary pdfbox_f5822_0()
{    return this.uriDictionary;}
public String pdfbox_f5823_0()
{    return this.getCOSObject().getString("Base");}
public void pdfbox_f5824_0(String base)
{    this.getCOSObject().setString("Base", base);}
public COSDictionary pdfbox_f5825_0()
{    return params;}
public String pdfbox_f5826_0()
{    return params.getString(COSName.F);}
public void pdfbox_f5827_0(String file)
{    params.setString(COSName.F, file);}
public String pdfbox_f5828_0()
{    return params.getString(COSName.D);}
public void pdfbox_f5829_0(String dir)
{    params.setString(COSName.D, dir);}
public String pdfbox_f5830_0()
{    return params.getString(COSName.O, OPERATION_OPEN);}
public void pdfbox_f5831_0(String op)
{    params.setString(COSName.D, op);}
public String pdfbox_f5832_0()
{    return params.getString(COSName.P);}
public void pdfbox_f5833_0(String param)
{    params.setString(COSName.P, param);}
 static AnnotationBorder pdfbox_f5834_0(PDAnnotation annotation, PDBorderStyleDictionary borderStyle)
{    AnnotationBorder ab = new AnnotationBorder();    if (borderStyle == null) {        COSArray border = annotation.getBorder();        if (border.size() >= 3 && border.getObject(2) instanceof COSNumber) {            ab.width = ((COSNumber) border.getObject(2)).floatValue();        }        if (border.size() > 3) {            COSBase base3 = border.getObject(3);            if (base3 instanceof COSArray) {                ab.dashArray = ((COSArray) base3).toFloatArray();            }        }    } else {        ab.width = borderStyle.getWidth();        if (borderStyle.getStyle().equals(PDBorderStyleDictionary.STYLE_DASHED)) {            ab.dashArray = borderStyle.getDashStyle().getDashArray();        }        if (borderStyle.getStyle().equals(PDBorderStyleDictionary.STYLE_UNDERLINE)) {            ab.underline = true;        }    }    if (ab.dashArray != null) {        boolean allZero = true;        for (float f : ab.dashArray) {            if (Float.compare(f, 0) != 0) {                allZero = false;                break;            }        }        if (allZero) {            ab.dashArray = null;        }    }    return ab;}
 void pdfbox_f5835_0(PDRectangle rd) throws IOException
{    rectWithDiff = applyRectDiff(rd, lineWidth / 2);    double left = rectWithDiff.getLowerLeftX();    double bottom = rectWithDiff.getLowerLeftY();    double right = rectWithDiff.getUpperRightX();    double top = rectWithDiff.getUpperRightY();    cloudyRectangleImpl(left, bottom, right, top, false);    finish();}
 void pdfbox_f5836_0(float[][] path) throws IOException
{    int n = path.length;    Point2D.Double[] polygon = new Point2D.Double[n];    for (int i = 0; i < n; i++) {        float[] array = path[i];        if (array.length == 2) {            polygon[i] = new Point2D.Double(array[0], array[1]);        } else if (array.length == 6) {                        polygon[i] = new Point2D.Double(array[4], array[5]);        }    }    cloudyPolygonImpl(polygon, false);    finish();}
 void pdfbox_f5837_0(PDRectangle rd) throws IOException
{    rectWithDiff = applyRectDiff(rd, 0);    double left = rectWithDiff.getLowerLeftX();    double bottom = rectWithDiff.getLowerLeftY();    double right = rectWithDiff.getUpperRightX();    double top = rectWithDiff.getUpperRightY();    cloudyEllipseImpl(left, bottom, right, top);    finish();}
 PDRectangle pdfbox_f5838_0()
{    return getRectangle();}
 PDRectangle pdfbox_f5839_0()
{    return new PDRectangle((float) bboxMinX, (float) bboxMinY, (float) (bboxMaxX - bboxMinX), (float) (bboxMaxY - bboxMinY));}
 AffineTransform pdfbox_f5840_0()
{    return AffineTransform.getTranslateInstance(-bboxMinX, -bboxMinY);}
 PDRectangle pdfbox_f5841_0()
{    if (annotRect == null) {        float d = (float) lineWidth / 2;        return new PDRectangle(d, d, (float) lineWidth, (float) lineWidth);    }    PDRectangle re = (rectWithDiff != null) ? rectWithDiff : annotRect;    float left = re.getLowerLeftX() - (float) bboxMinX;    float bottom = re.getLowerLeftY() - (float) bboxMinY;    float right = (float) bboxMaxX - re.getUpperRightX();    float top = (float) bboxMaxY - re.getUpperRightY();    return new PDRectangle(left, bottom, right - left, top - bottom);}
private static double pdfbox_f5842_0(double dx, double hypot)
{    if (Double.compare(hypot, 0.0) == 0) {        return 0;    }    return dx / hypot;}
private static double pdfbox_f5843_0(double dy, double hypot)
{    if (Double.compare(hypot, 0.0) == 0) {        return 0;    }    return dy / hypot;}
private void pdfbox_f5844_0(double left, double bottom, double right, double top, boolean isEllipse) throws IOException
{    double w = right - left;    double h = top - bottom;    if (intensity <= 0.0) {        output.addRect((float) left, (float) bottom, (float) w, (float) h);        bboxMinX = left;        bboxMinY = bottom;        bboxMaxX = right;        bboxMaxY = top;        return;    }        Point2D.Double[] polygon;    if (w < 1.0) {        polygon = new Point2D.Double[] { new Point2D.Double(left, bottom), new Point2D.Double(left, top), new Point2D.Double(left, bottom) };    } else if (h < 1.0) {        polygon = new Point2D.Double[] { new Point2D.Double(left, bottom), new Point2D.Double(right, bottom), new Point2D.Double(left, bottom) };    } else {        polygon = new Point2D.Double[] { new Point2D.Double(left, bottom), new Point2D.Double(right, bottom), new Point2D.Double(right, top), new Point2D.Double(left, top), new Point2D.Double(left, bottom) };    }    cloudyPolygonImpl(polygon, isEllipse);}
private void pdfbox_f5845_0(Point2D.Double[] vertices, boolean isEllipse) throws IOException
{    Point2D.Double[] polygon = removeZeroLengthSegments(vertices);    getPositivePolygon(polygon);    int numPoints = polygon.length;    if (numPoints < 2) {        return;    }    if (intensity <= 0.0) {        moveTo(polygon[0]);        for (int i = 1; i < numPoints; i++) {            lineTo(polygon[i]);        }        return;    }    double cloudRadius = isEllipse ? getEllipseCloudRadius() : getPolygonCloudRadius();    if (cloudRadius < 0.5) {        cloudRadius = 0.5;    }    final double k = Math.cos(ANGLE_34_DEG);    final double advIntermDefault = 2 * k * cloudRadius;    final double advCornerDefault = k * cloudRadius;    double[] array = new double[2];    double anglePrev = 0;                                    int n0 = computeParamsPolygon(advIntermDefault, advCornerDefault, k, cloudRadius, polygon[numPoints - 2].distance(polygon[0]), array);    double alphaPrev = (n0 == 0) ? array[0] : ANGLE_34_DEG;    for (int j = 0; j + 1 < numPoints; j++) {        Point2D.Double pt = polygon[j];        Point2D.Double ptNext = polygon[j + 1];        double length = pt.distance(ptNext);        if (Double.compare(length, 0.0) == 0) {            alphaPrev = ANGLE_34_DEG;            continue;        }                int n = computeParamsPolygon(advIntermDefault, advCornerDefault, k, cloudRadius, length, array);        if (n < 0) {            if (!outputStarted) {                moveTo(pt);            }            continue;        }        double alpha = array[0];        double dx = array[1];        double angleCur = Math.atan2(ptNext.y - pt.y, ptNext.x - pt.x);        if (j == 0) {            Point2D.Double ptPrev = polygon[numPoints - 2];            anglePrev = Math.atan2(pt.y - ptPrev.y, pt.x - ptPrev.x);        }        double cos = cosine(ptNext.x - pt.x, length);        double sin = sine(ptNext.y - pt.y, length);        double x = pt.x;        double y = pt.y;        addCornerCurl(anglePrev, angleCur, cloudRadius, pt.x, pt.y, alpha, alphaPrev, !outputStarted);                double adv = 2 * k * cloudRadius + 2 * dx;        x += adv * cos;        y += adv * sin;                int numInterm = n;        if (n >= 1) {            addFirstIntermediateCurl(angleCur, cloudRadius, alpha, x, y);            x += advIntermDefault * cos;            y += advIntermDefault * sin;            numInterm = n - 1;        }                Point2D.Double[] template = getIntermediateCurlTemplate(angleCur, cloudRadius);        for (int i = 0; i < numInterm; i++) {            outputCurlTemplate(template, x, y);            x += advIntermDefault * cos;            y += advIntermDefault * sin;        }        anglePrev = angleCur;        alphaPrev = (n == 0) ? alpha : ANGLE_34_DEG;    }}
private int pdfbox_f5846_0(double advInterm, double advCorner, double k, double r, double length, double[] array)
{    if (Double.compare(length, 0.0) == 0) {        array[0] = ANGLE_34_DEG;        array[1] = 0;        return -1;    }        int n = (int) Math.ceil((length - 2 * advCorner) / advInterm);        double e = length - (2 * advCorner + n * advInterm);        double dx = e / 2;        double arg = (k * r + dx) / r;    double alpha = (arg < -1.0 || arg > 1.0) ? 0.0 : Math.acos(arg);    array[0] = alpha;    array[1] = dx;    return n;}
private void pdfbox_f5847_0(double anglePrev, double angleCur, double radius, double cx, double cy, double alpha, double alphaPrev, boolean addMoveTo) throws IOException
{    double a = anglePrev + ANGLE_180_DEG + alphaPrev;    double b = anglePrev + ANGLE_180_DEG + alphaPrev - Math.toRadians(22);    getArcSegment(a, b, cx, cy, radius, radius, null, addMoveTo);    a = b;    b = angleCur - alpha;    getArc(a, b, radius, radius, cx, cy, null, false);}
private void pdfbox_f5848_0(double angleCur, double r, double alpha, double cx, double cy) throws IOException
{    double a = angleCur + ANGLE_180_DEG;    getArcSegment(a + alpha, a + alpha - ANGLE_30_DEG, cx, cy, r, r, null, false);    getArcSegment(a + alpha - ANGLE_30_DEG, a + ANGLE_90_DEG, cx, cy, r, r, null, false);    getArcSegment(a + ANGLE_90_DEG, a + ANGLE_180_DEG - ANGLE_34_DEG, cx, cy, r, r, null, false);}
private Point2D.Double[] pdfbox_f5849_0(double angleCur, double r) throws IOException
{    ArrayList<Point2D.Double> points = new ArrayList<>();    double a = angleCur + ANGLE_180_DEG;    getArcSegment(a + ANGLE_34_DEG, a + ANGLE_12_DEG, 0, 0, r, r, points, false);    getArcSegment(a + ANGLE_12_DEG, a + ANGLE_90_DEG, 0, 0, r, r, points, false);    getArcSegment(a + ANGLE_90_DEG, a + ANGLE_180_DEG - ANGLE_34_DEG, 0, 0, r, r, points, false);    return points.toArray(new Point2D.Double[points.size()]);}
private void pdfbox_f5850_0(Point2D.Double[] template, double x, double y) throws IOException
{    int n = template.length;    int i = 0;    if ((n % 3) == 1) {        Point2D.Double a = template[0];        moveTo(a.x + x, a.y + y);        i++;    }    for (; i + 2 < n; i += 3) {        Point2D.Double a = template[i];        Point2D.Double b = template[i + 1];        Point2D.Double c = template[i + 2];        curveTo(a.x + x, a.y + y, b.x + x, b.y + y, c.x + x, c.y + y);    }}
private PDRectangle pdfbox_f5851_0(PDRectangle rd, double min)
{    float rectLeft = annotRect.getLowerLeftX();    float rectBottom = annotRect.getLowerLeftY();    float rectRight = annotRect.getUpperRightX();    float rectTop = annotRect.getUpperRightY();        rectLeft = Math.min(rectLeft, rectRight);    rectBottom = Math.min(rectBottom, rectTop);    rectRight = Math.max(rectLeft, rectRight);    rectTop = Math.max(rectBottom, rectTop);    double rdLeft;    double rdBottom;    double rdRight;    double rdTop;    if (rd != null) {        rdLeft = Math.max(rd.getLowerLeftX(), min);        rdBottom = Math.max(rd.getLowerLeftY(), min);        rdRight = Math.max(rd.getUpperRightX(), min);        rdTop = Math.max(rd.getUpperRightY(), min);    } else {        rdLeft = min;        rdBottom = min;        rdRight = min;        rdTop = min;    }    rectLeft += rdLeft;    rectBottom += rdBottom;    rectRight -= rdRight;    rectTop -= rdTop;    return new PDRectangle(rectLeft, rectBottom, rectRight - rectLeft, rectTop - rectBottom);}
private void pdfbox_f5852_0(Point2D.Double[] points)
{    int len = points.length;    int n = len / 2;    for (int i = 0; i < n; i++) {        int j = len - i - 1;        Point2D.Double pi = points[i];        Point2D.Double pj = points[j];        points[i] = pj;        points[j] = pi;    }}
private void pdfbox_f5853_0(Point2D.Double[] points)
{    if (getPolygonDirection(points) < 0) {        reversePolygon(points);    }}
private double pdfbox_f5854_0(Point2D.Double[] points)
{    double a = 0;    int len = points.length;    for (int i = 0; i < len; i++) {        int j = (i + 1) % len;        a += points[i].x * points[j].y - points[i].y * points[j].x;    }    return a;}
private void pdfbox_f5855_0(double startAng, double endAng, double rx, double ry, double cx, double cy, ArrayList<Point2D.Double> out, boolean addMoveTo) throws IOException
{    final double angleIncr = Math.PI / 2;    double startx = rx * Math.cos(startAng) + cx;    double starty = ry * Math.sin(startAng) + cy;    double angleTodo = endAng - startAng;    while (angleTodo < 0) {        angleTodo += 2 * Math.PI;    }    double sweep = angleTodo;    double angleDone = 0;    if (addMoveTo) {        if (out != null) {            out.add(new Point2D.Double(startx, starty));        } else {            moveTo(startx, starty);        }    }    while (angleTodo > angleIncr) {        getArcSegment(startAng + angleDone, startAng + angleDone + angleIncr, cx, cy, rx, ry, out, false);        angleDone += angleIncr;        angleTodo -= angleIncr;    }    if (angleTodo > 0) {        getArcSegment(startAng + angleDone, startAng + sweep, cx, cy, rx, ry, out, false);    }}
private void pdfbox_f5856_0(double startAng, double endAng, double cx, double cy, double rx, double ry, ArrayList<Point2D.Double> out, boolean addMoveTo) throws IOException
{        double cosA = Math.cos(startAng);    double sinA = Math.sin(startAng);    double cosB = Math.cos(endAng);    double sinB = Math.sin(endAng);    double denom = Math.sin((endAng - startAng) / 2.0);    if (Double.compare(denom, 0.0) == 0) {                if (addMoveTo) {            double xs = cx + rx * cosA;            double ys = cy + ry * sinA;            if (out != null) {                out.add(new Point2D.Double(xs, ys));            } else {                moveTo(xs, ys);            }        }        return;    }    double bcp = 1.333333333 * (1 - Math.cos((endAng - startAng) / 2.0)) / denom;    double p1x = cx + rx * (cosA - bcp * sinA);    double p1y = cy + ry * (sinA + bcp * cosA);    double p2x = cx + rx * (cosB + bcp * sinB);    double p2y = cy + ry * (sinB - bcp * cosB);    double p3x = cx + rx * cosB;    double p3y = cy + ry * sinB;    if (addMoveTo) {        double xs = cx + rx * cosA;        double ys = cy + ry * sinA;        if (out != null) {            out.add(new Point2D.Double(xs, ys));        } else {            moveTo(xs, ys);        }    }    if (out != null) {        out.add(new Point2D.Double(p1x, p1y));        out.add(new Point2D.Double(p2x, p2y));        out.add(new Point2D.Double(p3x, p3y));    } else {        curveTo(p1x, p1y, p2x, p2y, p3x, p3y);    }}
private static Point2D.Double[] pdfbox_f5857_0(double left, double bottom, double right, double top)
{    Ellipse2D.Double ellipse = new Ellipse2D.Double(left, bottom, right - left, top - bottom);    final double flatness = 0.50;    PathIterator iterator = ellipse.getPathIterator(null, flatness);    double[] coords = new double[6];    ArrayList<Point2D.Double> points = new ArrayList<>();    while (!iterator.isDone()) {        switch(iterator.currentSegment(coords)) {            case PathIterator.SEG_MOVETO:            case PathIterator.SEG_LINETO:                points.add(new Point2D.Double(coords[0], coords[1]));                break;                        default:                break;        }        iterator.next();    }    int size = points.size();    final double closeTestLimit = 0.05;    if (size >= 2 && points.get(size - 1).distance(points.get(0)) > closeTestLimit) {        points.add(points.get(points.size() - 1));    }    return points.toArray(new Point2D.Double[points.size()]);}
private void pdfbox_f5858_0(final double leftOrig, final double bottomOrig, final double rightOrig, final double topOrig) throws IOException
{    if (intensity <= 0.0) {        drawBasicEllipse(leftOrig, bottomOrig, rightOrig, topOrig);        return;    }    double left = leftOrig;    double bottom = bottomOrig;    double right = rightOrig;    double top = topOrig;    double width = right - left;    double height = top - bottom;    double cloudRadius = getEllipseCloudRadius();        final double threshold1 = 0.50 * cloudRadius;    if (width < threshold1 && height < threshold1) {        drawBasicEllipse(left, bottom, right, top);        return;    }            final double threshold2 = 5;    if ((width < threshold2 && height > 20) || (width > 20 && height < threshold2)) {        cloudyRectangleImpl(left, bottom, right, top, true);        return;    }            double radiusAdj = Math.sin(ANGLE_12_DEG) * cloudRadius - 1.50;    if (width > 2 * radiusAdj) {        left += radiusAdj;        right -= radiusAdj;    } else {        double mid = (left + right) / 2;        left = mid - 0.10;        right = mid + 0.10;    }    if (height > 2 * radiusAdj) {        top -= radiusAdj;        bottom += radiusAdj;    } else {        double mid = (top + bottom) / 2;        top = mid + 0.10;        bottom = mid - 0.10;    }                    Point2D.Double[] flatPolygon = flattenEllipse(left, bottom, right, top);    int numPoints = flatPolygon.length;    if (numPoints < 2) {        return;    }    double totLen = 0;    for (int i = 1; i < numPoints; i++) {        totLen += flatPolygon[i - 1].distance(flatPolygon[i]);    }    final double k = Math.cos(ANGLE_34_DEG);    double curlAdvance = 2 * k * cloudRadius;    int n = (int) Math.ceil(totLen / curlAdvance);    if (n < 2) {        drawBasicEllipse(leftOrig, bottomOrig, rightOrig, topOrig);        return;    }    curlAdvance = totLen / n;    cloudRadius = curlAdvance / (2 * k);    if (cloudRadius < 0.5) {        cloudRadius = 0.5;        curlAdvance = 2 * k * cloudRadius;    } else if (cloudRadius < 3.0) {                        drawBasicEllipse(leftOrig, bottomOrig, rightOrig, topOrig);        return;    }                int centerPointsLength = n;    Point2D.Double[] centerPoints = new Point2D.Double[centerPointsLength];    int centerPointsIndex = 0;    double lengthRemain = 0;    final double comparisonToler = lineWidth * 0.10;    for (int i = 0; i + 1 < numPoints; i++) {        Point2D.Double p1 = flatPolygon[i];        Point2D.Double p2 = flatPolygon[i + 1];        double dx = p2.x - p1.x;        double dy = p2.y - p1.y;        double length = p1.distance(p2);        if (Double.compare(length, 0.0) == 0) {            continue;        }        double lengthTodo = length + lengthRemain;        if (lengthTodo >= curlAdvance - comparisonToler || i == numPoints - 2) {            double cos = cosine(dx, length);            double sin = sine(dy, length);            double d = curlAdvance - lengthRemain;            do {                double x = p1.x + d * cos;                double y = p1.y + d * sin;                if (centerPointsIndex < centerPointsLength) {                    centerPoints[centerPointsIndex++] = new Point2D.Double(x, y);                }                lengthTodo -= curlAdvance;                d += curlAdvance;            } while (lengthTodo >= curlAdvance - comparisonToler);            lengthRemain = lengthTodo;            if (lengthRemain < 0) {                lengthRemain = 0;            }        } else {            lengthRemain += length;        }    }                            numPoints = centerPointsIndex;    double anglePrev = 0;    double alphaPrev = 0;    for (int i = 0; i < numPoints; i++) {        int idxNext = i + 1;        if (i + 1 >= numPoints) {            idxNext = 0;        }        Point2D.Double pt = centerPoints[i];        Point2D.Double ptNext = centerPoints[idxNext];        if (i == 0) {            Point2D.Double ptPrev = centerPoints[numPoints - 1];            anglePrev = Math.atan2(pt.y - ptPrev.y, pt.x - ptPrev.x);            alphaPrev = computeParamsEllipse(ptPrev, pt, cloudRadius, curlAdvance);        }        double angleCur = Math.atan2(ptNext.y - pt.y, ptNext.x - pt.x);        double alpha = computeParamsEllipse(pt, ptNext, cloudRadius, curlAdvance);        addCornerCurl(anglePrev, angleCur, cloudRadius, pt.x, pt.y, alpha, alphaPrev, !outputStarted);        anglePrev = angleCur;        alphaPrev = alpha;    }}
private double pdfbox_f5859_0(Point2D.Double pt, Point2D.Double ptNext, double r, double curlAdv)
{    double length = pt.distance(ptNext);    if (Double.compare(length, 0.0) == 0) {        return ANGLE_34_DEG;    }    double e = length - curlAdv;    double arg = (curlAdv / 2 + e / 2) / r;    return (arg < -1.0 || arg > 1.0) ? 0.0 : Math.acos(arg);}
private Point2D.Double[] pdfbox_f5860_0(Point2D.Double[] polygon)
{    int np = polygon.length;    if (np <= 2) {        return polygon;    }    final double toler = 0.50;    int npNew = np;    Point2D.Double ptPrev = polygon[0];        for (int i = 1; i < np; i++) {        Point2D.Double pt = polygon[i];        if (Math.abs(pt.x - ptPrev.x) < toler && Math.abs(pt.y - ptPrev.y) < toler) {            polygon[i] = null;            npNew--;        }        ptPrev = pt;    }    if (npNew == np) {        return polygon;    }    Point2D.Double[] polygonNew = new Point2D.Double[npNew];    int j = 0;    for (int i = 0; i < np; i++) {        Point2D.Double pt = polygon[i];        if (pt != null) {            polygonNew[j++] = pt;        }    }    return polygonNew;}
private void pdfbox_f5861_0(double left, double bottom, double right, double top) throws IOException
{    double rx = Math.abs(right - left) / 2;    double ry = Math.abs(top - bottom) / 2;    double cx = (left + right) / 2;    double cy = (bottom + top) / 2;    getArc(0, 2 * Math.PI, rx, ry, cx, cy, null, true);}
private void pdfbox_f5862_0(double x, double y) throws IOException
{    bboxMinX = x;    bboxMinY = y;    bboxMaxX = x;    bboxMaxY = y;    outputStarted = true;        output.setLineJoinStyle(2);}
private void pdfbox_f5863_0(double x, double y)
{    bboxMinX = Math.min(bboxMinX, x);    bboxMinY = Math.min(bboxMinY, y);    bboxMaxX = Math.max(bboxMaxX, x);    bboxMaxY = Math.max(bboxMaxY, y);}
private void pdfbox_f5864_0(Point2D.Double p) throws IOException
{    moveTo(p.x, p.y);}
private void pdfbox_f5865_0(double x, double y) throws IOException
{    if (outputStarted) {        updateBBox(x, y);    } else {        beginOutput(x, y);    }    output.moveTo((float) x, (float) y);}
private void pdfbox_f5866_0(Point2D.Double p) throws IOException
{    lineTo(p.x, p.y);}
private void pdfbox_f5867_0(double x, double y) throws IOException
{    if (outputStarted) {        updateBBox(x, y);    } else {        beginOutput(x, y);    }    output.lineTo((float) x, (float) y);}
private void pdfbox_f5868_0(double ax, double ay, double bx, double by, double cx, double cy) throws IOException
{    updateBBox(ax, ay);    updateBBox(bx, by);    updateBBox(cx, cy);    output.curveTo((float) ax, (float) ay, (float) bx, (float) by, (float) cx, (float) cy);}
private void pdfbox_f5869_0() throws IOException
{    if (outputStarted) {        output.closePath();    }    if (lineWidth > 0) {        double d = lineWidth / 2;        bboxMinX -= d;        bboxMinY -= d;        bboxMaxX += d;        bboxMaxY += d;    }}
private double pdfbox_f5870_0()
{        return 4.75 * intensity + 0.5 * lineWidth;}
private double pdfbox_f5871_0()
{        return 4 * intensity + 0.5 * lineWidth;}
 PDAnnotation pdfbox_f5872_0()
{    return annotation;}
 PDColor pdfbox_f5873_0()
{    return annotation.getColor();}
 PDRectangle pdfbox_f5874_0()
{    return annotation.getRectangle();}
protected COSStream pdfbox_f5875_0()
{    return document == null ? new COSStream() : document.getDocument().createCOSStream();}
 PDAppearanceDictionary pdfbox_f5876_0()
{    PDAppearanceDictionary appearanceDictionary = annotation.getAppearance();    if (appearanceDictionary == null) {        appearanceDictionary = new PDAppearanceDictionary();        annotation.setAppearance(appearanceDictionary);    }    return appearanceDictionary;}
 PDAppearanceContentStream pdfbox_f5877_0() throws IOException
{    return getNormalAppearanceAsContentStream(false);}
 PDAppearanceContentStream pdfbox_f5878_0(boolean compress) throws IOException
{    PDAppearanceEntry appearanceEntry = getNormalAppearance();    return getAppearanceEntryAsContentStream(appearanceEntry, compress);}
 PDAppearanceEntry pdfbox_f5879_0()
{    PDAppearanceDictionary appearanceDictionary = getAppearance();    PDAppearanceEntry downAppearanceEntry = appearanceDictionary.getDownAppearance();    if (downAppearanceEntry.isSubDictionary()) {        downAppearanceEntry = new PDAppearanceEntry(createCOSStream());        appearanceDictionary.setDownAppearance(downAppearanceEntry);    }    return downAppearanceEntry;}
 PDAppearanceEntry pdfbox_f5880_0()
{    PDAppearanceDictionary appearanceDictionary = getAppearance();    PDAppearanceEntry rolloverAppearanceEntry = appearanceDictionary.getRolloverAppearance();    if (rolloverAppearanceEntry.isSubDictionary()) {        rolloverAppearanceEntry = new PDAppearanceEntry(createCOSStream());        appearanceDictionary.setRolloverAppearance(rolloverAppearanceEntry);    }    return rolloverAppearanceEntry;}
 PDRectangle pdfbox_f5881_0(PDRectangle rectangle, float padding)
{    return new PDRectangle(rectangle.getLowerLeftX() + padding, rectangle.getLowerLeftY() + padding, rectangle.getWidth() - 2 * padding, rectangle.getHeight() - 2 * padding);}
 PDRectangle pdfbox_f5882_0(PDRectangle rectangle, float[] differences)
{    if (differences == null || differences.length != 4) {        return rectangle;    }    return new PDRectangle(rectangle.getLowerLeftX() - differences[0], rectangle.getLowerLeftY() - differences[1], rectangle.getWidth() + differences[0] + differences[2], rectangle.getHeight() + differences[1] + differences[3]);}
 PDRectangle pdfbox_f5883_0(PDRectangle rectangle, float[] differences)
{    if (differences == null || differences.length != 4) {        return rectangle;    }    return new PDRectangle(rectangle.getLowerLeftX() + differences[0], rectangle.getLowerLeftY() + differences[1], rectangle.getWidth() - differences[0] - differences[2], rectangle.getHeight() - differences[1] - differences[3]);}
 void pdfbox_f5884_0(PDAppearanceContentStream contentStream, float opacity) throws IOException
{    if (opacity < 1) {        PDExtendedGraphicsState gs = new PDExtendedGraphicsState();        gs.setStrokingAlphaConstant(opacity);        gs.setNonStrokingAlphaConstant(opacity);        contentStream.setGraphicsStateParameters(gs);    }}
 void pdfbox_f5885_0(String style, final PDAppearanceContentStream cs, float x, float y, float width, boolean hasStroke, boolean hasBackground, boolean ending) throws IOException
{    int sign = ending ? -1 : 1;    switch(style) {        case PDAnnotationLine.LE_OPEN_ARROW:        case PDAnnotationLine.LE_CLOSED_ARROW:            drawArrow(cs, x + sign * width, y, sign * width * 9);            break;        case PDAnnotationLine.LE_BUTT:            cs.moveTo(x, y - width * 3);            cs.lineTo(x, y + width * 3);            break;        case PDAnnotationLine.LE_DIAMOND:            drawDiamond(cs, x, y, width * 3);            break;        case PDAnnotationLine.LE_SQUARE:            cs.addRect(x - width * 3, y - width * 3, width * 6, width * 6);            break;        case PDAnnotationLine.LE_CIRCLE:            drawCircle(cs, x, y, width * 3);            break;        case PDAnnotationLine.LE_R_OPEN_ARROW:        case PDAnnotationLine.LE_R_CLOSED_ARROW:            drawArrow(cs, x + (0 - sign) * width, y, (0 - sign) * width * 9);            break;        case PDAnnotationLine.LE_SLASH:                        cs.moveTo(x + (float) (Math.cos(Math.toRadians(60)) * width * 9), y + (float) (Math.sin(Math.toRadians(60)) * width * 9));            cs.lineTo(x + (float) (Math.cos(Math.toRadians(240)) * width * 9), y + (float) (Math.sin(Math.toRadians(240)) * width * 9));            break;        default:            return;    }    if (PDAnnotationLine.LE_R_CLOSED_ARROW.equals(style) || PDAnnotationLine.LE_CLOSED_ARROW.equals(style)) {        cs.closePath();    }    cs.drawShape(width, hasStroke,     INTERIOR_COLOR_STYLES.contains(style) ? hasBackground : false);}
 void pdfbox_f5886_0(PDAppearanceContentStream cs, float x, float y, float len) throws IOException
{                    cs.moveTo(x + (float) (Math.cos(ARROW_ANGLE) * len), y + (float) (Math.sin(ARROW_ANGLE) * len));    cs.lineTo(x, y);    cs.lineTo(x + (float) (Math.cos(ARROW_ANGLE) * len), y - (float) (Math.sin(ARROW_ANGLE) * len));}
 void pdfbox_f5887_0(PDAppearanceContentStream cs, float x, float y, float r) throws IOException
{    cs.moveTo(x - r, y);    cs.lineTo(x, y + r);    cs.lineTo(x + r, y);    cs.lineTo(x, y - r);    cs.closePath();}
 void pdfbox_f5888_0(PDAppearanceContentStream cs, float x, float y, float r) throws IOException
{        float magic = r * 0.551784f;    cs.moveTo(x, y + r);    cs.curveTo(x + magic, y + r, x + r, y + magic, x + r, y);    cs.curveTo(x + r, y - magic, x + magic, y - r, x, y - r);    cs.curveTo(x - magic, y - r, x - r, y - magic, x - r, y);    cs.curveTo(x - r, y + magic, x - magic, y + r, x, y + r);    cs.closePath();}
 void pdfbox_f5889_0(PDAppearanceContentStream cs, float x, float y, float r) throws IOException
{        float magic = r * 0.551784f;    cs.moveTo(x, y + r);    cs.curveTo(x - magic, y + r, x - r, y + magic, x - r, y);    cs.curveTo(x - r, y - magic, x - magic, y - r, x, y - r);    cs.curveTo(x + magic, y - r, x + r, y - magic, x + r, y);    cs.curveTo(x + r, y + magic, x + magic, y + r, x, y + r);    cs.closePath();}
private static Set<String> pdfbox_f5890_0()
{    Set<String> shortStyles = new HashSet<>();    shortStyles.add(PDAnnotationLine.LE_OPEN_ARROW);    shortStyles.add(PDAnnotationLine.LE_CLOSED_ARROW);    shortStyles.add(PDAnnotationLine.LE_SQUARE);    shortStyles.add(PDAnnotationLine.LE_CIRCLE);    shortStyles.add(PDAnnotationLine.LE_DIAMOND);    return Collections.unmodifiableSet(shortStyles);}
private static Set<String> pdfbox_f5891_0()
{    Set<String> interiorColorStyles = new HashSet<>();    interiorColorStyles.add(PDAnnotationLine.LE_CLOSED_ARROW);    interiorColorStyles.add(PDAnnotationLine.LE_CIRCLE);    interiorColorStyles.add(PDAnnotationLine.LE_DIAMOND);    interiorColorStyles.add(PDAnnotationLine.LE_R_CLOSED_ARROW);    interiorColorStyles.add(PDAnnotationLine.LE_SQUARE);    return Collections.unmodifiableSet(interiorColorStyles);}
private static Set<String> pdfbox_f5892_0()
{    Set<String> angledStyles = new HashSet<>();    angledStyles.add(PDAnnotationLine.LE_CLOSED_ARROW);    angledStyles.add(PDAnnotationLine.LE_OPEN_ARROW);    angledStyles.add(PDAnnotationLine.LE_R_CLOSED_ARROW);    angledStyles.add(PDAnnotationLine.LE_R_OPEN_ARROW);    angledStyles.add(PDAnnotationLine.LE_BUTT);    angledStyles.add(PDAnnotationLine.LE_SLASH);    return Collections.unmodifiableSet(angledStyles);}
private PDAppearanceEntry pdfbox_f5893_0()
{    PDAppearanceDictionary appearanceDictionary = getAppearance();    PDAppearanceEntry normalAppearanceEntry = appearanceDictionary.getNormalAppearance();    if (normalAppearanceEntry == null || normalAppearanceEntry.isSubDictionary()) {        normalAppearanceEntry = new PDAppearanceEntry(createCOSStream());        appearanceDictionary.setNormalAppearance(normalAppearanceEntry);    }    return normalAppearanceEntry;}
private PDAppearanceContentStream pdfbox_f5894_0(PDAppearanceEntry appearanceEntry, boolean compress) throws IOException
{    PDAppearanceStream appearanceStream = appearanceEntry.getAppearanceStream();    setTransformationMatrix(appearanceStream);        PDResources resources = appearanceStream.getResources();    if (resources == null) {        resources = new PDResources();        appearanceStream.setResources(resources);    }    return new PDAppearanceContentStream(appearanceStream, compress);}
private void pdfbox_f5895_0(PDAppearanceStream appearanceStream)
{    PDRectangle bbox = getRectangle();    appearanceStream.setBBox(bbox);    AffineTransform transform = AffineTransform.getTranslateInstance(-bbox.getLowerLeftX(), -bbox.getLowerLeftY());    appearanceStream.setMatrix(transform);}
 PDRectangle pdfbox_f5896_0(PDAnnotationSquareCircle annotation, float lineWidth)
{                            PDRectangle borderBox;    float[] rectDifferences = annotation.getRectDifferences();    if (rectDifferences.length == 0) {        borderBox = getPaddedRectangle(getRectangle(), lineWidth / 2);                annotation.setRectDifferences(lineWidth / 2);        annotation.setRectangle(addRectDifferences(getRectangle(), annotation.getRectDifferences()));                        annotation.getNormalAppearanceStream().setBBox(getRectangle());        AffineTransform transform = AffineTransform.getTranslateInstance(-getRectangle().getLowerLeftX(), -getRectangle().getLowerLeftY());        annotation.getNormalAppearanceStream().setMatrix(transform);    } else {        borderBox = applyRectDifferences(getRectangle(), rectDifferences);        borderBox = getPaddedRectangle(borderBox, lineWidth / 2);    }    return borderBox;}
public void pdfbox_f5897_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5898_1()
{    PDAnnotationCaret annotation = (PDAnnotationCaret) getAnnotation();    try (PDAppearanceContentStream contentStream = getNormalAppearanceAsContentStream()) {        contentStream.setStrokingColor(getColor());        contentStream.setNonStrokingColor(getColor());        setOpacity(contentStream, annotation.getConstantOpacity());        PDRectangle rect = getRectangle();        PDRectangle bbox = new PDRectangle(rect.getWidth(), rect.getHeight());        if (!annotation.getCOSObject().containsKey(COSName.RD)) {                                                                                    float rd = Math.min(rect.getHeight() / 10, 5);            annotation.setRectDifferences(rd);            bbox = new PDRectangle(-rd, -rd, rect.getWidth() + 2 * rd, rect.getHeight() + 2 * rd);            Matrix matrix = annotation.getNormalAppearanceStream().getMatrix();            matrix.transformPoint(rd, rd);            annotation.getNormalAppearanceStream().setMatrix(matrix.createAffineTransform());            PDRectangle rect2 = new PDRectangle(rect.getLowerLeftX() - rd, rect.getLowerLeftY() - rd, rect.getWidth() + 2 * rd, rect.getHeight() + 2 * rd);            annotation.setRectangle(rect2);        }        annotation.getNormalAppearanceStream().setBBox(bbox);        float halfX = rect.getWidth() / 2;        float halfY = rect.getHeight() / 2;        contentStream.moveTo(0, 0);        contentStream.curveTo(halfX, 0, halfX, halfY, halfX, rect.getHeight());        contentStream.curveTo(halfX, halfY, halfX, 0, rect.getWidth(), 0);        contentStream.closePath();        contentStream.fill();            } catch (IOException e) {            }}
public void pdfbox_f5901_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5902_1()
{    float lineWidth = getLineWidth();    PDAnnotationCircle annotation = (PDAnnotationCircle) getAnnotation();    try (PDAppearanceContentStream contentStream = getNormalAppearanceAsContentStream()) {        boolean hasStroke = contentStream.setStrokingColorOnDemand(getColor());        boolean hasBackground = contentStream.setNonStrokingColorOnDemand(annotation.getInteriorColor());        setOpacity(contentStream, annotation.getConstantOpacity());        contentStream.setBorderLine(lineWidth, annotation.getBorderStyle(), annotation.getBorder());        PDBorderEffectDictionary borderEffect = annotation.getBorderEffect();        if (borderEffect != null && borderEffect.getStyle().equals(PDBorderEffectDictionary.STYLE_CLOUDY)) {            CloudyBorder cloudyBorder = new CloudyBorder(contentStream, borderEffect.getIntensity(), lineWidth, getRectangle());            cloudyBorder.createCloudyEllipse(annotation.getRectDifference());            annotation.setRectangle(cloudyBorder.getRectangle());            annotation.setRectDifference(cloudyBorder.getRectDifference());            PDAppearanceStream appearanceStream = annotation.getNormalAppearanceStream();            appearanceStream.setBBox(cloudyBorder.getBBox());            appearanceStream.setMatrix(cloudyBorder.getMatrix());        } else {                                    PDRectangle borderBox = handleBorderBox(annotation, lineWidth);                        float x0 = borderBox.getLowerLeftX();            float y0 = borderBox.getLowerLeftY();                        float x1 = borderBox.getUpperRightX();            float y1 = borderBox.getUpperRightY();                        float xm = x0 + borderBox.getWidth() / 2;            float ym = y0 + borderBox.getHeight() / 2;                                                float magic = 0.55555417f;                        float vOffset = borderBox.getHeight() / 2 * magic;            float hOffset = borderBox.getWidth() / 2 * magic;            contentStream.moveTo(xm, y1);            contentStream.curveTo((xm + hOffset), y1, x1, (ym + vOffset), x1, ym);            contentStream.curveTo(x1, (ym - vOffset), (xm + hOffset), y0, xm, y0);            contentStream.curveTo((xm - hOffset), y0, x0, (ym - vOffset), x0, ym);            contentStream.curveTo(x0, (ym + vOffset), (xm - hOffset), y1, xm, y1);            contentStream.closePath();        }        contentStream.drawShape(lineWidth, hasStroke, hasBackground);    } catch (IOException e) {            }}
 float pdfbox_f5905_0()
{    PDAnnotationMarkup annotation = (PDAnnotationMarkup) getAnnotation();    PDBorderStyleDictionary bs = annotation.getBorderStyle();    if (bs != null) {        return bs.getWidth();    }    COSArray borderCharacteristics = annotation.getBorder();    if (borderCharacteristics.size() >= 3) {        COSBase base = borderCharacteristics.getObject(2);        if (base instanceof COSNumber) {            return ((COSNumber) base).floatValue();        }    }    return 1;}
public void pdfbox_f5906_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5907_1()
{    PDAnnotationFreeText annotation = (PDAnnotationFreeText) getAnnotation();    float[] pathsArray = new float[0];    if (PDAnnotationFreeText.IT_FREE_TEXT_CALLOUT.equals(annotation.getIntent())) {        pathsArray = annotation.getCallout();        if (pathsArray == null || pathsArray.length != 4 && pathsArray.length != 6) {            pathsArray = new float[0];        }    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream(true)) {                boolean hasBackground = cs.setNonStrokingColorOnDemand(annotation.getColor());        setOpacity(cs, annotation.getConstantOpacity());                        PDColor strokingColor = extractNonStrokingColor(annotation);        boolean hasStroke = cs.setStrokingColorOnDemand(strokingColor);        PDColor textColor = strokingColor;        String defaultStyleString = annotation.getDefaultStyleString();        if (defaultStyleString != null) {            Matcher m = COLOR_PATTERN.matcher(defaultStyleString);            if (m.find()) {                int color = Integer.parseInt(m.group(1), 16);                float r = ((color >> 16) & 0xFF) / 255f;                float g = ((color >> 8) & 0xFF) / 255f;                float b = (color & 0xFF) / 255f;                textColor = new PDColor(new float[] { r, g, b }, PDDeviceRGB.INSTANCE);            }        }        if (ab.dashArray != null) {            cs.setLineDashPattern(ab.dashArray, 0);        }        cs.setLineWidth(ab.width);                for (int i = 0; i < pathsArray.length / 2; ++i) {            float x = pathsArray[i * 2];            float y = pathsArray[i * 2 + 1];            if (i == 0) {                if (SHORT_STYLES.contains(annotation.getLineEndingStyle())) {                                                            float x1 = pathsArray[2];                    float y1 = pathsArray[3];                    float len = (float) (Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2)));                    if (Float.compare(len, 0) != 0) {                        x += (x1 - x) / len * ab.width;                        y += (y1 - y) / len * ab.width;                    }                }                cs.moveTo(x, y);            } else {                cs.lineTo(x, y);            }        }        if (pathsArray.length > 0) {            cs.stroke();        }                if (PDAnnotationFreeText.IT_FREE_TEXT_CALLOUT.equals(annotation.getIntent()) &&         !LE_NONE.equals(annotation.getLineEndingStyle()) && pathsArray.length >= 4) {            float x2 = pathsArray[2];            float y2 = pathsArray[3];            float x1 = pathsArray[0];            float y1 = pathsArray[1];            cs.saveGraphicsState();            if (ANGLED_STYLES.contains(annotation.getLineEndingStyle())) {                                                                                                double angle = Math.atan2(y2 - y1, x2 - x1);                cs.transform(Matrix.getRotateInstance(angle, x1, y1));            } else {                cs.transform(Matrix.getTranslateInstance(x1, y1));            }            drawStyle(annotation.getLineEndingStyle(), cs, 0, 0, ab.width, hasStroke, hasBackground, false);            cs.restoreGraphicsState();        }        PDRectangle borderBox;        PDBorderEffectDictionary borderEffect = annotation.getBorderEffect();        if (borderEffect != null && borderEffect.getStyle().equals(PDBorderEffectDictionary.STYLE_CLOUDY)) {                                                borderBox = applyRectDifferences(getRectangle(), annotation.getRectDifferences());                        CloudyBorder cloudyBorder = new CloudyBorder(cs, borderEffect.getIntensity(), ab.width, getRectangle());            cloudyBorder.createCloudyRectangle(annotation.getRectDifference());            annotation.setRectangle(cloudyBorder.getRectangle());            annotation.setRectDifference(cloudyBorder.getRectDifference());            PDAppearanceStream appearanceStream = annotation.getNormalAppearanceStream();            appearanceStream.setBBox(cloudyBorder.getBBox());            appearanceStream.setMatrix(cloudyBorder.getMatrix());        } else {                                                                                                borderBox = applyRectDifferences(getRectangle(), annotation.getRectDifferences());            annotation.getNormalAppearanceStream().setBBox(borderBox);                        PDRectangle paddedRectangle = getPaddedRectangle(borderBox, ab.width / 2);            cs.addRect(paddedRectangle.getLowerLeftX(), paddedRectangle.getLowerLeftY(), paddedRectangle.getWidth(), paddedRectangle.getHeight());        }        cs.drawShape(ab.width, hasStroke, hasBackground);                        int rotation = annotation.getCOSObject().getInt(COSName.ROTATE, 0);        cs.transform(Matrix.getRotateInstance(Math.toRadians(rotation), 0, 0));        float xOffset;        float yOffset;        float width = rotation == 90 || rotation == 270 ? borderBox.getHeight() : borderBox.getWidth();                        PDFont font = PDType1Font.HELVETICA;        float clipY;        float clipWidth = width - ab.width * 4;        float clipHeight = rotation == 90 || rotation == 270 ? borderBox.getWidth() - ab.width * 4 : borderBox.getHeight() - ab.width * 4;        extractFontDetails(annotation);        if (document != null && document.getDocumentCatalog().getAcroForm() != null) {                                    PDResources defaultResources = document.getDocumentCatalog().getAcroForm().getDefaultResources();            if (defaultResources != null) {                PDFont defaultResourcesFont = defaultResources.getFont(fontName);                if (defaultResourcesFont != null) {                    font = defaultResourcesFont;                }            }        }                        float yDelta = 0.7896f;        switch(rotation) {            case 180:                xOffset = -borderBox.getUpperRightX() + ab.width * 2;                yOffset = -borderBox.getLowerLeftY() - ab.width * 2 - yDelta * fontSize;                clipY = -borderBox.getUpperRightY() + ab.width * 2;                break;            case 90:                xOffset = borderBox.getLowerLeftY() + ab.width * 2;                yOffset = -borderBox.getLowerLeftX() - ab.width * 2 - yDelta * fontSize;                clipY = -borderBox.getUpperRightX() + ab.width * 2;                break;            case 270:                xOffset = -borderBox.getUpperRightY() + ab.width * 2;                yOffset = borderBox.getUpperRightX() - ab.width * 2 - yDelta * fontSize;                clipY = borderBox.getLowerLeftX() + ab.width * 2;                break;            case 0:            default:                xOffset = borderBox.getLowerLeftX() + ab.width * 2;                yOffset = borderBox.getUpperRightY() - ab.width * 2 - yDelta * fontSize;                clipY = borderBox.getLowerLeftY() + ab.width * 2;                break;        }                cs.addRect(xOffset, clipY, clipWidth, clipHeight);        cs.clip();        cs.beginText();        cs.setFont(font, fontSize);        cs.setNonStrokingColor(textColor.getComponents());        AppearanceStyle appearanceStyle = new AppearanceStyle();        appearanceStyle.setFont(font);        appearanceStyle.setFontSize(fontSize);        PlainTextFormatter formatter = new PlainTextFormatter.Builder(cs).style(appearanceStyle).text(new PlainText(annotation.getContents())).width(width - ab.width * 4).wrapLines(true).initialOffset(xOffset, yOffset).build();        try {            formatter.format();        } catch (IllegalArgumentException ex) {            throw new IOException(ex);        }        cs.endText();        if (pathsArray.length > 0) {            PDRectangle rect = getRectangle();                                                                        float minX = Float.MAX_VALUE;            float minY = Float.MAX_VALUE;            float maxX = Float.MIN_VALUE;            float maxY = Float.MIN_VALUE;            for (int i = 0; i < pathsArray.length / 2; ++i) {                float x = pathsArray[i * 2];                float y = pathsArray[i * 2 + 1];                minX = Math.min(minX, x);                minY = Math.min(minY, y);                maxX = Math.max(maxX, x);                maxY = Math.max(maxY, y);            }                        rect.setLowerLeftX(Math.min(minX - ab.width * 10, rect.getLowerLeftX()));            rect.setLowerLeftY(Math.min(minY - ab.width * 10, rect.getLowerLeftY()));            rect.setUpperRightX(Math.max(maxX + ab.width * 10, rect.getUpperRightX()));            rect.setUpperRightY(Math.max(maxY + ab.width * 10, rect.getUpperRightY()));            annotation.setRectangle(rect);                        annotation.getNormalAppearanceStream().setBBox(getRectangle());                }    } catch (IOException ex) {            }}
private PDColor pdfbox_f5908_1(PDAnnotationFreeText annotation)
{                    PDColor strokingColor = new PDColor(new float[] { 0 }, PDDeviceGray.INSTANCE);    String defaultAppearance = annotation.getDefaultAppearance();    if (defaultAppearance == null) {        return strokingColor;    }    try {                PDFStreamParser parser = new PDFStreamParser(defaultAppearance.getBytes(Charsets.US_ASCII));        COSArray arguments = new COSArray();        COSArray colors = null;        Operator graphicOp = null;        for (Object token = parser.parseNextToken(); token != null; token = parser.parseNextToken()) {            if (token instanceof COSObject) {                arguments.add(((COSObject) token).getObject());            } else if (token instanceof Operator) {                Operator op = (Operator) token;                String name = op.getName();                if (OperatorName.NON_STROKING_GRAY.equals(name) || OperatorName.NON_STROKING_RGB.equals(name) || OperatorName.NON_STROKING_CMYK.equals(name)) {                    graphicOp = op;                    colors = arguments;                }                arguments = new COSArray();            } else {                arguments.add((COSBase) token);            }        }        if (graphicOp != null) {            switch(graphicOp.getName()) {                case OperatorName.NON_STROKING_GRAY:                    strokingColor = new PDColor(colors, PDDeviceGray.INSTANCE);                    break;                case OperatorName.NON_STROKING_RGB:                    strokingColor = new PDColor(colors, PDDeviceRGB.INSTANCE);                    break;                case OperatorName.NON_STROKING_CMYK:                    strokingColor = new PDColor(colors, PDDeviceCMYK.INSTANCE);                    break;                default:                    break;            }        }    } catch (IOException ex) {            }    return strokingColor;}
private void pdfbox_f5909_1(PDAnnotationFreeText annotation)
{    String defaultAppearance = annotation.getDefaultAppearance();    if (defaultAppearance == null && document != null && document.getDocumentCatalog().getAcroForm() != null) {        defaultAppearance = document.getDocumentCatalog().getAcroForm().getDefaultAppearance();    }    if (defaultAppearance == null) {        return;    }    try {                PDFStreamParser parser = new PDFStreamParser(defaultAppearance.getBytes(Charsets.US_ASCII));        COSArray arguments = new COSArray();        COSArray fontArguments = new COSArray();        for (Object token = parser.parseNextToken(); token != null; token = parser.parseNextToken()) {            if (token instanceof COSObject) {                arguments.add(((COSObject) token).getObject());            } else if (token instanceof Operator) {                Operator op = (Operator) token;                String name = op.getName();                if (OperatorName.SET_FONT_AND_SIZE.equals(name)) {                    fontArguments = arguments;                }                arguments = new COSArray();            } else {                arguments.add((COSBase) token);            }        }        if (fontArguments.size() >= 2) {            COSBase base = fontArguments.get(0);            if (base instanceof COSName) {                fontName = (COSName) base;            }            base = fontArguments.get(1);            if (base instanceof COSNumber) {                fontSize = ((COSNumber) base).floatValue();            }        }    } catch (IOException ex) {            }}
public void pdfbox_f5912_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5913_1()
{    PDAnnotationHighlight annotation = (PDAnnotationHighlight) getAnnotation();    PDRectangle rect = annotation.getRectangle();    float[] pathsArray = annotation.getQuadPoints();    if (pathsArray == null) {        return;    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    PDColor color = annotation.getColor();    if (color == null || color.getComponents().length == 0) {        return;    }                    float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    for (int i = 0; i < pathsArray.length / 2; ++i) {        float x = pathsArray[i * 2];        float y = pathsArray[i * 2 + 1];        minX = Math.min(minX, x);        minY = Math.min(minY, y);        maxX = Math.max(maxX, x);        maxY = Math.max(maxY, y);    }        float maxDelta = 0;    for (int i = 0; i < pathsArray.length / 8; ++i) {                                float delta = Math.max((pathsArray[i + 0] - pathsArray[i + 4]) / 4, (pathsArray[i + 1] - pathsArray[i + 5]) / 4);        maxDelta = Math.max(delta, maxDelta);    }    rect.setLowerLeftX(Math.min(minX - ab.width / 2 - maxDelta, rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - ab.width / 2 - maxDelta, rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + ab.width + maxDelta, rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + ab.width + maxDelta, rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        PDExtendedGraphicsState r0 = new PDExtendedGraphicsState();        PDExtendedGraphicsState r1 = new PDExtendedGraphicsState();        r0.setAlphaSourceFlag(false);        r0.setStrokingAlphaConstant(annotation.getConstantOpacity());        r0.setNonStrokingAlphaConstant(annotation.getConstantOpacity());        r1.setAlphaSourceFlag(false);        r1.setBlendMode(BlendMode.MULTIPLY);        cs.setGraphicsStateParameters(r0);        cs.setGraphicsStateParameters(r1);                        PDFormXObject frm1 = new PDFormXObject(createCOSStream());        PDFormXObject frm2 = new PDFormXObject(createCOSStream());        frm1.setResources(new PDResources());        try (PDFormContentStream mwfofrmCS = new PDFormContentStream(frm1)) {            mwfofrmCS.drawForm(frm2);        }        frm1.setBBox(annotation.getRectangle());        COSDictionary groupDict = new COSDictionary();        groupDict.setItem(COSName.S, COSName.TRANSPARENCY);                frm1.getCOSObject().setItem(COSName.GROUP, groupDict);        cs.drawForm(frm1);        frm2.setBBox(annotation.getRectangle());        try (PDFormContentStream frm2CS = new PDFormContentStream(frm2)) {            frm2CS.setNonStrokingColor(color);            int of = 0;            while (of + 7 < pathsArray.length) {                                                                                                float delta = 0;                if (Float.compare(pathsArray[of + 0], pathsArray[of + 4]) == 0 && Float.compare(pathsArray[of + 1], pathsArray[of + 3]) == 0 && Float.compare(pathsArray[of + 2], pathsArray[of + 6]) == 0 && Float.compare(pathsArray[of + 5], pathsArray[of + 7]) == 0) {                                        delta = (pathsArray[of + 1] - pathsArray[of + 5]) / 4;                } else if (Float.compare(pathsArray[of + 1], pathsArray[of + 5]) == 0 && Float.compare(pathsArray[of + 0], pathsArray[of + 2]) == 0 && Float.compare(pathsArray[of + 3], pathsArray[of + 7]) == 0 && Float.compare(pathsArray[of + 4], pathsArray[of + 6]) == 0) {                                        delta = (pathsArray[of + 0] - pathsArray[of + 4]) / 4;                }                frm2CS.moveTo(pathsArray[of + 4], pathsArray[of + 5]);                if (Float.compare(pathsArray[of + 0], pathsArray[of + 4]) == 0) {                                        frm2CS.curveTo(pathsArray[of + 4] - delta, pathsArray[of + 5] + delta, pathsArray[of + 0] - delta, pathsArray[of + 1] - delta, pathsArray[of + 0], pathsArray[of + 1]);                } else if (Float.compare(pathsArray[of + 5], pathsArray[of + 1]) == 0) {                                        frm2CS.curveTo(pathsArray[of + 4] + delta, pathsArray[of + 5] + delta, pathsArray[of + 0] - delta, pathsArray[of + 1] + delta, pathsArray[of + 0], pathsArray[of + 1]);                } else {                    frm2CS.lineTo(pathsArray[of + 0], pathsArray[of + 1]);                }                frm2CS.lineTo(pathsArray[of + 2], pathsArray[of + 3]);                if (Float.compare(pathsArray[of + 2], pathsArray[of + 6]) == 0) {                                        frm2CS.curveTo(pathsArray[of + 2] + delta, pathsArray[of + 3] - delta, pathsArray[of + 6] + delta, pathsArray[of + 7] + delta, pathsArray[of + 6], pathsArray[of + 7]);                } else if (Float.compare(pathsArray[of + 3], pathsArray[of + 7]) == 0) {                                        frm2CS.curveTo(pathsArray[of + 2] - delta, pathsArray[of + 3] - delta, pathsArray[of + 6] + delta, pathsArray[of + 7] - delta, pathsArray[of + 6], pathsArray[of + 7]);                } else {                    frm2CS.lineTo(pathsArray[of + 6], pathsArray[of + 7]);                }                frm2CS.fill();                of += 8;            }        }    } catch (IOException ex) {            }}
public void pdfbox_f5916_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5917_1()
{    PDAnnotationInk ink = (PDAnnotationInk) getAnnotation();        AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(ink, ink.getBorderStyle());    PDColor color = ink.getColor();    if (color == null || color.getComponents().length == 0 || Float.compare(ab.width, 0) == 0) {        return;    }    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        setOpacity(cs, ink.getConstantOpacity());        cs.setStrokingColor(color);        if (ab.dashArray != null) {            cs.setLineDashPattern(ab.dashArray, 0);        }        cs.setLineWidth(ab.width);        for (float[] pathArray : ink.getInkList()) {            int nPoints = pathArray.length / 2;                        for (int i = 0; i < nPoints; ++i) {                float x = pathArray[i * 2];                float y = pathArray[i * 2 + 1];                if (i == 0) {                    cs.moveTo(x, y);                } else {                    cs.lineTo(x, y);                }            }            cs.stroke();        }    } catch (IOException ex) {            }}
public void pdfbox_f5920_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5921_1()
{    PDAnnotationLine annotation = (PDAnnotationLine) getAnnotation();    PDRectangle rect = annotation.getRectangle();    float[] pathsArray = annotation.getLine();    if (pathsArray == null) {        return;    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    PDColor color = annotation.getColor();    if (color == null || color.getComponents().length == 0) {        return;    }    float ll = annotation.getLeaderLineLength();    float lle = annotation.getLeaderLineExtensionLength();    float llo = annotation.getLeaderLineOffsetLength();        float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    for (int i = 0; i < pathsArray.length / 2; ++i) {        float x = pathsArray[i * 2];        float y = pathsArray[i * 2 + 1];        minX = Math.min(minX, x);        minY = Math.min(minY, y);        maxX = Math.max(maxX, x);        maxY = Math.max(maxY, y);    }        if (ll < 0) {                llo = -llo;        lle = -lle;    }                float lineEndingSize = (ab.width < 1e-5) ? 1 : ab.width;                    rect.setLowerLeftX(Math.min(minX - Math.max(lineEndingSize * 10, Math.abs(llo + ll + lle)), rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - Math.max(lineEndingSize * 10, Math.abs(llo + ll + lle)), rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + Math.max(lineEndingSize * 10, Math.abs(llo + ll + lle)), rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + Math.max(lineEndingSize * 10, Math.abs(llo + ll + lle)), rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        setOpacity(cs, annotation.getConstantOpacity());                                                boolean hasStroke = cs.setStrokingColorOnDemand(color);        if (ab.dashArray != null) {            cs.setLineDashPattern(ab.dashArray, 0);        }        cs.setLineWidth(ab.width);        float x1 = pathsArray[0];        float y1 = pathsArray[1];        float x2 = pathsArray[2];        float y2 = pathsArray[3];                                float y = llo + ll;        String contents = annotation.getContents();        if (contents == null) {            contents = "";        }        cs.saveGraphicsState();        double angle = Math.atan2(y2 - y1, x2 - x1);        cs.transform(Matrix.getRotateInstance(angle, x1, y1));        float lineLength = (float) Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));                cs.moveTo(0, llo);        cs.lineTo(0, llo + ll + lle);        cs.moveTo(lineLength, llo);        cs.lineTo(lineLength, llo + ll + lle);        if (annotation.hasCaption() && !contents.isEmpty()) {                                                PDType1Font font = PDType1Font.HELVETICA;                                    float contentLength = 0;            try {                contentLength = font.getStringWidth(annotation.getContents()) / 1000 * FONT_SIZE;                                                } catch (IllegalArgumentException ex) {                                            }            float xOffset = (lineLength - contentLength) / 2;            float yOffset;            String captionPositioning = annotation.getCaptionPositioning();                        if (SHORT_STYLES.contains(annotation.getStartPointEndingStyle())) {                cs.moveTo(lineEndingSize, y);            } else {                cs.moveTo(0, y);            }            if ("Top".equals(captionPositioning)) {                                yOffset = 1.908f;            } else {                                                yOffset = -2.6f;                cs.lineTo(xOffset - lineEndingSize, y);                cs.moveTo(lineLength - xOffset + lineEndingSize, y);            }            if (SHORT_STYLES.contains(annotation.getEndPointEndingStyle())) {                cs.lineTo(lineLength - lineEndingSize, y);            } else {                cs.lineTo(lineLength, y);            }            cs.drawShape(lineEndingSize, hasStroke, false);                        float captionHorizontalOffset = annotation.getCaptionHorizontalOffset();            float captionVerticalOffset = annotation.getCaptionVerticalOffset();                        if (contentLength > 0) {                cs.beginText();                cs.setFont(font, FONT_SIZE);                cs.newLineAtOffset(xOffset + captionHorizontalOffset, y + yOffset + captionVerticalOffset);                cs.showText(annotation.getContents());                cs.endText();            }            if (Float.compare(captionVerticalOffset, 0) != 0) {                                cs.moveTo(0 + lineLength / 2, y);                cs.lineTo(0 + lineLength / 2, y + captionVerticalOffset);                cs.drawShape(lineEndingSize, hasStroke, false);            }        } else {            if (SHORT_STYLES.contains(annotation.getStartPointEndingStyle())) {                cs.moveTo(lineEndingSize, y);            } else {                cs.moveTo(0, y);            }            if (SHORT_STYLES.contains(annotation.getEndPointEndingStyle())) {                cs.lineTo(lineLength - lineEndingSize, y);            } else {                cs.lineTo(lineLength, y);            }            cs.drawShape(lineEndingSize, hasStroke, false);        }        cs.restoreGraphicsState();                        boolean hasBackground = cs.setNonStrokingColorOnDemand(annotation.getInteriorColor());                if (ab.width < 1e-5) {            hasStroke = false;        }                if (!LE_NONE.equals(annotation.getStartPointEndingStyle())) {            cs.saveGraphicsState();            if (ANGLED_STYLES.contains(annotation.getStartPointEndingStyle())) {                cs.transform(Matrix.getRotateInstance(angle, x1, y1));                drawStyle(annotation.getStartPointEndingStyle(), cs, 0, y, lineEndingSize, hasStroke, hasBackground, false);            } else {                                                                                float xx1 = x1 - (float) (y * Math.sin(angle));                float yy1 = y1 + (float) (y * Math.cos(angle));                drawStyle(annotation.getStartPointEndingStyle(), cs, xx1, yy1, lineEndingSize, hasStroke, hasBackground, false);            }            cs.restoreGraphicsState();        }                if (!LE_NONE.equals(annotation.getEndPointEndingStyle())) {                        if (ANGLED_STYLES.contains(annotation.getEndPointEndingStyle())) {                cs.transform(Matrix.getRotateInstance(angle, x2, y2));                drawStyle(annotation.getEndPointEndingStyle(), cs, 0, y, lineEndingSize, hasStroke, hasBackground, true);            } else {                                                                                float xx2 = x2 - (float) (y * Math.sin(angle));                float yy2 = y2 + (float) (y * Math.cos(angle));                drawStyle(annotation.getEndPointEndingStyle(), cs, xx2, yy2, lineEndingSize, hasStroke, hasBackground, true);            }        }    } catch (IOException ex) {            }}
public void pdfbox_f5924_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
 float pdfbox_f5928_0()
{    PDAnnotationLink annotation = (PDAnnotationLink) getAnnotation();    PDBorderStyleDictionary bs = annotation.getBorderStyle();    if (bs != null) {        return bs.getWidth();    }    COSArray borderCharacteristics = annotation.getBorder();    if (borderCharacteristics.size() >= 3) {        COSBase base = borderCharacteristics.getObject(2);        if (base instanceof COSNumber) {            return ((COSNumber) base).floatValue();        }    }    return 1;}
public void pdfbox_f5929_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5930_1()
{    PDAnnotationPolygon annotation = (PDAnnotationPolygon) getAnnotation();    float lineWidth = getLineWidth();    PDRectangle rect = annotation.getRectangle();            float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    float[][] pathArray = getPathArray(annotation);    if (pathArray == null) {        return;    }    for (int i = 0; i < pathArray.length; ++i) {        for (int j = 0; j < pathArray[i].length / 2; ++j) {            float x = pathArray[i][j * 2];            float y = pathArray[i][j * 2 + 1];            minX = Math.min(minX, x);            minY = Math.min(minY, y);            maxX = Math.max(maxX, x);            maxY = Math.max(maxY, y);        }    }    rect.setLowerLeftX(Math.min(minX - lineWidth, rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - lineWidth, rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + lineWidth, rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + lineWidth, rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream contentStream = getNormalAppearanceAsContentStream()) {        boolean hasStroke = contentStream.setStrokingColorOnDemand(getColor());        boolean hasBackground = contentStream.setNonStrokingColorOnDemand(annotation.getInteriorColor());        setOpacity(contentStream, annotation.getConstantOpacity());        contentStream.setBorderLine(lineWidth, annotation.getBorderStyle(), annotation.getBorder());        PDBorderEffectDictionary borderEffect = annotation.getBorderEffect();        if (borderEffect != null && borderEffect.getStyle().equals(PDBorderEffectDictionary.STYLE_CLOUDY)) {            CloudyBorder cloudyBorder = new CloudyBorder(contentStream, borderEffect.getIntensity(), lineWidth, getRectangle());            cloudyBorder.createCloudyPolygon(pathArray);            annotation.setRectangle(cloudyBorder.getRectangle());            PDAppearanceStream appearanceStream = annotation.getNormalAppearanceStream();            appearanceStream.setBBox(cloudyBorder.getBBox());            appearanceStream.setMatrix(cloudyBorder.getMatrix());        } else {            for (int i = 0; i < pathArray.length; i++) {                float[] pointsArray = pathArray[i];                                if (i == 0 && pointsArray.length == 2) {                    contentStream.moveTo(pointsArray[0], pointsArray[1]);                } else {                                        if (pointsArray.length == 2) {                        contentStream.lineTo(pointsArray[0], pointsArray[1]);                    } else if (pointsArray.length == 6) {                        contentStream.curveTo(pointsArray[0], pointsArray[1], pointsArray[2], pointsArray[3], pointsArray[4], pointsArray[5]);                    }                }            }            contentStream.closePath();        }        contentStream.drawShape(lineWidth, hasStroke, hasBackground);    } catch (IOException e) {            }}
private float[][] pdfbox_f5931_0(PDAnnotationPolygon annotation)
{        float[][] pathArray = annotation.getPath();    if (pathArray == null) {                float[] verticesArray = annotation.getVertices();        if (verticesArray == null) {            return null;        }        int points = verticesArray.length / 2;        pathArray = new float[points][2];        for (int i = 0; i < points; ++i) {            pathArray[i][0] = verticesArray[i * 2];            pathArray[i][1] = verticesArray[i * 2 + 1];        }    }    return pathArray;}
 float pdfbox_f5934_0()
{    PDAnnotationMarkup annotation = (PDAnnotationMarkup) getAnnotation();    PDBorderStyleDictionary bs = annotation.getBorderStyle();    if (bs != null) {        return bs.getWidth();    }    COSArray borderCharacteristics = annotation.getBorder();    if (borderCharacteristics.size() >= 3) {        COSBase base = borderCharacteristics.getObject(2);        if (base instanceof COSNumber) {            return ((COSNumber) base).floatValue();        }    }    return 1;}
public void pdfbox_f5935_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5936_1()
{    PDAnnotationPolyline annotation = (PDAnnotationPolyline) getAnnotation();    PDRectangle rect = annotation.getRectangle();    float[] pathsArray = annotation.getVertices();    if (pathsArray == null || pathsArray.length < 4) {        return;    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    PDColor color = annotation.getColor();    if (color == null || color.getComponents().length == 0 || Float.compare(ab.width, 0) == 0) {        return;    }                float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    for (int i = 0; i < pathsArray.length / 2; ++i) {        float x = pathsArray[i * 2];        float y = pathsArray[i * 2 + 1];        minX = Math.min(minX, x);        minY = Math.min(minY, y);        maxX = Math.max(maxX, x);        maxY = Math.max(maxY, y);    }        rect.setLowerLeftX(Math.min(minX - ab.width * 10, rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - ab.width * 10, rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + ab.width * 10, rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + ab.width * 10, rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        boolean hasBackground = cs.setNonStrokingColorOnDemand(annotation.getInteriorColor());        setOpacity(cs, annotation.getConstantOpacity());        boolean hasStroke = cs.setStrokingColorOnDemand(color);        if (ab.dashArray != null) {            cs.setLineDashPattern(ab.dashArray, 0);        }        cs.setLineWidth(ab.width);        for (int i = 0; i < pathsArray.length / 2; ++i) {            float x = pathsArray[i * 2];            float y = pathsArray[i * 2 + 1];            if (i == 0) {                if (SHORT_STYLES.contains(annotation.getStartPointEndingStyle())) {                                                            float x1 = pathsArray[2];                    float y1 = pathsArray[3];                    float len = (float) (Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2)));                    if (Float.compare(len, 0) != 0) {                        x += (x1 - x) / len * ab.width;                        y += (y1 - y) / len * ab.width;                    }                }                cs.moveTo(x, y);            } else {                if (i == pathsArray.length / 2 - 1 && SHORT_STYLES.contains(annotation.getEndPointEndingStyle())) {                                                            float x0 = pathsArray[pathsArray.length - 4];                    float y0 = pathsArray[pathsArray.length - 3];                    float len = (float) (Math.sqrt(Math.pow(x0 - x, 2) + Math.pow(y0 - y, 2)));                    if (Float.compare(len, 0) != 0) {                        x -= (x - x0) / len * ab.width;                        y -= (y - y0) / len * ab.width;                    }                }                cs.lineTo(x, y);            }        }        cs.stroke();                if (!LE_NONE.equals(annotation.getStartPointEndingStyle())) {                        float x2 = pathsArray[2];            float y2 = pathsArray[3];            float x1 = pathsArray[0];            float y1 = pathsArray[1];            cs.saveGraphicsState();            if (ANGLED_STYLES.contains(annotation.getStartPointEndingStyle())) {                double angle = Math.atan2(y2 - y1, x2 - x1);                cs.transform(Matrix.getRotateInstance(angle, x1, y1));            } else {                cs.transform(Matrix.getTranslateInstance(x1, y1));            }            drawStyle(annotation.getStartPointEndingStyle(), cs, 0, 0, ab.width, hasStroke, hasBackground, false);            cs.restoreGraphicsState();        }        if (!LE_NONE.equals(annotation.getEndPointEndingStyle())) {                        float x1 = pathsArray[pathsArray.length - 4];            float y1 = pathsArray[pathsArray.length - 3];            float x2 = pathsArray[pathsArray.length - 2];            float y2 = pathsArray[pathsArray.length - 1];                        if (ANGLED_STYLES.contains(annotation.getEndPointEndingStyle())) {                double angle = Math.atan2(y2 - y1, x2 - x1);                cs.transform(Matrix.getRotateInstance(angle, x2, y2));            } else {                cs.transform(Matrix.getTranslateInstance(x2, y2));            }            drawStyle(annotation.getEndPointEndingStyle(), cs, 0, 0, ab.width, hasStroke, hasBackground, true);        }    } catch (IOException ex) {            }}
 float pdfbox_f5939_0()
{    PDAnnotationMarkup annotation = (PDAnnotationMarkup) getAnnotation();    PDBorderStyleDictionary bs = annotation.getBorderStyle();    if (bs != null) {        return bs.getWidth();    }    COSArray borderCharacteristics = annotation.getBorder();    if (borderCharacteristics.size() >= 3) {        COSBase base = borderCharacteristics.getObject(2);        if (base instanceof COSNumber) {            return ((COSNumber) base).floatValue();        }    }    return 1;}
public void pdfbox_f5940_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5944_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5945_1()
{    float lineWidth = getLineWidth();    PDAnnotationSquare annotation = (PDAnnotationSquare) getAnnotation();    try (PDAppearanceContentStream contentStream = getNormalAppearanceAsContentStream()) {        boolean hasStroke = contentStream.setStrokingColorOnDemand(getColor());        boolean hasBackground = contentStream.setNonStrokingColorOnDemand(annotation.getInteriorColor());        setOpacity(contentStream, annotation.getConstantOpacity());        contentStream.setBorderLine(lineWidth, annotation.getBorderStyle(), annotation.getBorder());        PDBorderEffectDictionary borderEffect = annotation.getBorderEffect();        if (borderEffect != null && borderEffect.getStyle().equals(PDBorderEffectDictionary.STYLE_CLOUDY)) {            CloudyBorder cloudyBorder = new CloudyBorder(contentStream, borderEffect.getIntensity(), lineWidth, getRectangle());            cloudyBorder.createCloudyRectangle(annotation.getRectDifference());            annotation.setRectangle(cloudyBorder.getRectangle());            annotation.setRectDifference(cloudyBorder.getRectDifference());            PDAppearanceStream appearanceStream = annotation.getNormalAppearanceStream();            appearanceStream.setBBox(cloudyBorder.getBBox());            appearanceStream.setMatrix(cloudyBorder.getMatrix());        } else {            PDRectangle borderBox = handleBorderBox(annotation, lineWidth);            contentStream.addRect(borderBox.getLowerLeftX(), borderBox.getLowerLeftY(), borderBox.getWidth(), borderBox.getHeight());        }        contentStream.drawShape(lineWidth, hasStroke, hasBackground);    } catch (IOException e) {            }}
 float pdfbox_f5948_0()
{    PDAnnotationMarkup annotation = (PDAnnotationMarkup) getAnnotation();    PDBorderStyleDictionary bs = annotation.getBorderStyle();    if (bs != null) {        return bs.getWidth();    }    COSArray borderCharacteristics = annotation.getBorder();    if (borderCharacteristics.size() >= 3) {        COSBase base = borderCharacteristics.getObject(2);        if (base instanceof COSNumber) {            return ((COSNumber) base).floatValue();        }    }    return 1;}
public void pdfbox_f5949_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5950_1()
{    PDAnnotationSquiggly annotation = (PDAnnotationSquiggly) getAnnotation();    PDRectangle rect = annotation.getRectangle();    float[] pathsArray = annotation.getQuadPoints();    if (pathsArray == null) {        return;    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    PDColor color = annotation.getColor();    if (color == null || color.getComponents().length == 0) {        return;    }    if (Float.compare(ab.width, 0) == 0) {                ab.width = 1.5f;    }                    float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    for (int i = 0; i < pathsArray.length / 2; ++i) {        float x = pathsArray[i * 2];        float y = pathsArray[i * 2 + 1];        minX = Math.min(minX, x);        minY = Math.min(minY, y);        maxX = Math.max(maxX, x);        maxY = Math.max(maxY, y);    }    rect.setLowerLeftX(Math.min(minX - ab.width / 2, rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - ab.width / 2, rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + ab.width / 2, rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + ab.width / 2, rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        setOpacity(cs, annotation.getConstantOpacity());        cs.setStrokingColor(color);                for (int i = 0; i < pathsArray.length / 8; ++i) {                                                            float height = pathsArray[i * 8 + 1] - pathsArray[i * 8 + 5];            cs.transform(new Matrix(height / 40f, 0, 0, height / 40f / 1.8f, pathsArray[i * 8 + 4], pathsArray[i * 8 + 5]));                                                PDFormXObject form = new PDFormXObject(createCOSStream());            form.setBBox(new PDRectangle(-0.5f, -0.5f, (pathsArray[i * 8 + 2] - pathsArray[i * 8]) / height * 40f + 0.5f, 13));            form.setResources(new PDResources());            form.setMatrix(AffineTransform.getTranslateInstance(0.5f, 0.5f));            cs.drawForm(form);            try (PDFormContentStream formCS = new PDFormContentStream(form)) {                PDTilingPattern pattern = new PDTilingPattern();                pattern.setBBox(new PDRectangle(0, 0, 10, 12));                pattern.setXStep(10);                pattern.setYStep(13);                pattern.setTilingType(PDTilingPattern.TILING_CONSTANT_SPACING_FASTER_TILING);                pattern.setPaintType(PDTilingPattern.PAINT_UNCOLORED);                try (PDPatternContentStream patternCS = new PDPatternContentStream(pattern)) {                                        patternCS.setLineCapStyle(1);                    patternCS.setLineJoinStyle(1);                    patternCS.setLineWidth(1);                    patternCS.setMiterLimit(10);                    patternCS.moveTo(0, 1);                    patternCS.lineTo(5, 11);                    patternCS.lineTo(10, 1);                    patternCS.stroke();                }                COSName patternName = form.getResources().add(pattern);                PDColorSpace patternColorSpace = new PDPattern(null, PDDeviceRGB.INSTANCE);                PDColor patternColor = new PDColor(color.getComponents(), patternName, patternColorSpace);                formCS.setNonStrokingColor(patternColor);                                formCS.addRect(0, 0, (pathsArray[i * 8 + 2] - pathsArray[i * 8]) / height * 40f, 12);                formCS.fill();            }        }    } catch (IOException ex) {            }}
public void pdfbox_f5953_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5954_1()
{    PDAnnotationStrikeout annotation = (PDAnnotationStrikeout) getAnnotation();    PDRectangle rect = annotation.getRectangle();    float[] pathsArray = annotation.getQuadPoints();    if (pathsArray == null) {        return;    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    PDColor color = annotation.getColor();    if (color == null || color.getComponents().length == 0) {        return;    }    if (Float.compare(ab.width, 0) == 0) {                ab.width = 1.5f;    }                float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    for (int i = 0; i < pathsArray.length / 2; ++i) {        float x = pathsArray[i * 2];        float y = pathsArray[i * 2 + 1];        minX = Math.min(minX, x);        minY = Math.min(minY, y);        maxX = Math.max(maxX, x);        maxY = Math.max(maxY, y);    }    rect.setLowerLeftX(Math.min(minX - ab.width / 2, rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - ab.width / 2, rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + ab.width / 2, rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + ab.width / 2, rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        setOpacity(cs, annotation.getConstantOpacity());        cs.setStrokingColor(color);        if (ab.dashArray != null) {            cs.setLineDashPattern(ab.dashArray, 0);        }        cs.setLineWidth(ab.width);                for (int i = 0; i < pathsArray.length / 8; ++i) {                                                                        float len0 = (float) (Math.sqrt(Math.pow(pathsArray[i * 8] - pathsArray[i * 8 + 4], 2) + Math.pow(pathsArray[i * 8 + 1] - pathsArray[i * 8 + 5], 2)));            float x0 = pathsArray[i * 8 + 4];            float y0 = pathsArray[i * 8 + 5];            if (Float.compare(len0, 0) != 0) {                                x0 += (pathsArray[i * 8] - pathsArray[i * 8 + 4]) / len0 * (len0 / 2 - ab.width);                y0 += (pathsArray[i * 8 + 1] - pathsArray[i * 8 + 5]) / len0 * (len0 / 2 - ab.width);            }            float len1 = (float) (Math.sqrt(Math.pow(pathsArray[i * 8 + 2] - pathsArray[i * 8 + 6], 2) + Math.pow(pathsArray[i * 8 + 3] - pathsArray[i * 8 + 7], 2)));            float x1 = pathsArray[i * 8 + 6];            float y1 = pathsArray[i * 8 + 7];            if (Float.compare(len1, 0) != 0) {                                x1 += (pathsArray[i * 8 + 2] - pathsArray[i * 8 + 6]) / len1 * (len1 / 2 - ab.width);                y1 += (pathsArray[i * 8 + 3] - pathsArray[i * 8 + 7]) / len1 * (len1 / 2 - ab.width);            }            cs.moveTo(x0, y0);            cs.lineTo(x1, y1);        }        cs.stroke();    } catch (IOException ex) {            }}
public void pdfbox_f5957_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5958_1()
{    PDAnnotationText annotation = (PDAnnotationText) getAnnotation();    if (!SUPPORTED_NAMES.contains(annotation.getName())) {        return;    }    try (PDAppearanceContentStream contentStream = getNormalAppearanceAsContentStream()) {        PDColor bgColor = getColor();        if (bgColor == null) {                        contentStream.setNonStrokingColor(1f);        } else {            contentStream.setNonStrokingColor(bgColor);        }                setOpacity(contentStream, annotation.getConstantOpacity());        switch(annotation.getName()) {            case PDAnnotationText.NAME_NOTE:                drawNote(annotation, contentStream);                break;            case PDAnnotationText.NAME_CROSS:                drawCross(annotation, contentStream);                break;            case PDAnnotationText.NAME_CIRCLE:                drawCircles(annotation, contentStream);                break;            case PDAnnotationText.NAME_INSERT:                drawInsert(annotation, contentStream);                break;            case PDAnnotationText.NAME_HELP:                drawHelp(annotation, contentStream);                break;            case PDAnnotationText.NAME_PARAGRAPH:                drawParagraph(annotation, contentStream);                break;            case PDAnnotationText.NAME_NEW_PARAGRAPH:                drawNewParagraph(annotation, contentStream);                break;            case PDAnnotationText.NAME_STAR:                drawStar(annotation, contentStream);                break;            case PDAnnotationText.NAME_CHECK:                drawCheck(annotation, contentStream);                break;            case PDAnnotationText.NAME_RIGHT_ARROW:                drawRightArrow(annotation, contentStream);                break;            case PDAnnotationText.NAME_RIGHT_POINTER:                drawRightPointer(annotation, contentStream);                break;            case PDAnnotationText.NAME_CROSS_HAIRS:                drawCrossHairs(annotation, contentStream);                break;            case PDAnnotationText.NAME_UP_ARROW:                drawUpArrow(annotation, contentStream);                break;            case PDAnnotationText.NAME_UP_LEFT_ARROW:                drawUpLeftArrow(annotation, contentStream);                break;            case PDAnnotationText.NAME_COMMENT:                drawComment(annotation, contentStream);                break;            case PDAnnotationText.NAME_KEY:                drawKey(annotation, contentStream);                break;            default:                break;        }    } catch (IOException e) {            }}
private PDRectangle pdfbox_f5959_0(PDAnnotationText annotation, float width, float height)
{                            PDRectangle rect = getRectangle();    PDRectangle bbox;    if (!annotation.isNoZoom()) {        rect.setUpperRightX(rect.getLowerLeftX() + width);        rect.setLowerLeftY(rect.getUpperRightY() - height);        annotation.setRectangle(rect);    }    if (!annotation.getCOSObject().containsKey(COSName.F)) {                annotation.setNoRotate(true);        annotation.setNoZoom(true);    }    bbox = new PDRectangle(width, height);    annotation.getNormalAppearanceStream().setBBox(bbox);    return bbox;}
private void pdfbox_f5960_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 18, 20);    contentStream.setMiterLimit(4);        contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.61f);    contentStream.addRect(1, 1, bbox.getWidth() - 2, bbox.getHeight() - 2);    contentStream.moveTo(bbox.getWidth() / 4, bbox.getHeight() / 7 * 2);    contentStream.lineTo(bbox.getWidth() * 3 / 4 - 1, bbox.getHeight() / 7 * 2);    contentStream.moveTo(bbox.getWidth() / 4, bbox.getHeight() / 7 * 3);    contentStream.lineTo(bbox.getWidth() * 3 / 4 - 1, bbox.getHeight() / 7 * 3);    contentStream.moveTo(bbox.getWidth() / 4, bbox.getHeight() / 7 * 4);    contentStream.lineTo(bbox.getWidth() * 3 / 4 - 1, bbox.getHeight() / 7 * 4);    contentStream.moveTo(bbox.getWidth() / 4, bbox.getHeight() / 7 * 5);    contentStream.lineTo(bbox.getWidth() * 3 / 4 - 1, bbox.getHeight() / 7 * 5);    contentStream.fillAndStroke();}
private void pdfbox_f5961_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 20);                                float smallR = 6.36f;    float largeR = 9.756f;    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);    contentStream.saveGraphicsState();    contentStream.setLineWidth(1);    PDExtendedGraphicsState gs = new PDExtendedGraphicsState();    gs.setAlphaSourceFlag(false);    gs.setStrokingAlphaConstant(0.6f);    gs.setNonStrokingAlphaConstant(0.6f);    gs.setBlendMode(BlendMode.NORMAL);    contentStream.setGraphicsStateParameters(gs);    contentStream.setNonStrokingColor(1f);    drawCircle(contentStream, bbox.getWidth() / 2, bbox.getHeight() / 2, smallR);    contentStream.fill();    contentStream.restoreGraphicsState();        contentStream.setLineWidth(0.59f);    drawCircle(contentStream, bbox.getWidth() / 2, bbox.getHeight() / 2, smallR);    drawCircle2(contentStream, bbox.getWidth() / 2, bbox.getHeight() / 2, largeR);    contentStream.fillAndStroke();}
private void pdfbox_f5962_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 17, 20);    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(0);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.moveTo(bbox.getWidth() / 2 - 1, bbox.getHeight() - 2);    contentStream.lineTo(1, 1);    contentStream.lineTo(bbox.getWidth() - 2, 1);    contentStream.closeAndFillAndStroke();}
private void pdfbox_f5963_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 19, 19);        float min = Math.min(bbox.getWidth(), bbox.getHeight());            float small = min / 10;    float large = min / 5;    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.moveTo(small, large);    contentStream.lineTo(large, small);    contentStream.lineTo(min / 2, min / 2 - small);    contentStream.lineTo(min - large, small);    contentStream.lineTo(min - small, large);    contentStream.lineTo(min / 2 + small, min / 2);    contentStream.lineTo(min - small, min - large);    contentStream.lineTo(min - large, min - small);    contentStream.lineTo(min / 2, min / 2 + small);    contentStream.lineTo(large, min - small);    contentStream.lineTo(small, min - large);    contentStream.lineTo(min / 2 - small, min / 2);    contentStream.closeAndFillAndStroke();}
private void pdfbox_f5964_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 20);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);        contentStream.saveGraphicsState();    contentStream.setLineWidth(1);    PDExtendedGraphicsState gs = new PDExtendedGraphicsState();    gs.setAlphaSourceFlag(false);    gs.setStrokingAlphaConstant(0.6f);    gs.setNonStrokingAlphaConstant(0.6f);    gs.setBlendMode(BlendMode.NORMAL);    contentStream.setGraphicsStateParameters(gs);    contentStream.setNonStrokingColor(1f);    drawCircle2(contentStream, min / 2, min / 2, min / 2 - 1);    contentStream.fill();    contentStream.restoreGraphicsState();    contentStream.saveGraphicsState();            contentStream.transform(Matrix.getScaleInstance(0.001f * min / 2.25f, 0.001f * min / 2.25f));    contentStream.transform(Matrix.getTranslateInstance(500, 375));            GeneralPath path = PDType1Font.HELVETICA_BOLD.getPath("question");    addPath(contentStream, path);    contentStream.restoreGraphicsState();        drawCircle2(contentStream, min / 2, min / 2, min / 2 - 1);    contentStream.fillAndStroke();}
private void pdfbox_f5965_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 20);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);        contentStream.saveGraphicsState();    contentStream.setLineWidth(1);    PDExtendedGraphicsState gs = new PDExtendedGraphicsState();    gs.setAlphaSourceFlag(false);    gs.setStrokingAlphaConstant(0.6f);    gs.setNonStrokingAlphaConstant(0.6f);    gs.setBlendMode(BlendMode.NORMAL);    contentStream.setGraphicsStateParameters(gs);    contentStream.setNonStrokingColor(1f);    drawCircle2(contentStream, min / 2, min / 2, min / 2 - 1);    contentStream.fill();    contentStream.restoreGraphicsState();    contentStream.saveGraphicsState();            contentStream.transform(Matrix.getScaleInstance(0.001f * min / 3, 0.001f * min / 3));    contentStream.transform(Matrix.getTranslateInstance(850, 900));            GeneralPath path = PDType1Font.HELVETICA.getPath("paragraph");    addPath(contentStream, path);    contentStream.restoreGraphicsState();    contentStream.fillAndStroke();    drawCircle(contentStream, min / 2, min / 2, min / 2 - 1);    contentStream.stroke();}
private void pdfbox_f5966_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    adjustRectAndBBox(annotation, 13, 20);    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(0);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);        contentStream.moveTo(6.4995f, 20);    contentStream.lineTo(0.295f, 7.287f);    contentStream.lineTo(12.705f, 7.287f);    contentStream.closeAndFillAndStroke();            contentStream.transform(Matrix.getScaleInstance(0.001f * 4, 0.001f * 4));    contentStream.transform(Matrix.getTranslateInstance(200, 0));    addPath(contentStream, PDType1Font.HELVETICA_BOLD.getPath("N"));    contentStream.transform(Matrix.getTranslateInstance(1300, 0));    addPath(contentStream, PDType1Font.HELVETICA_BOLD.getPath("P"));    contentStream.fill();}
private void pdfbox_f5967_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 19);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.transform(Matrix.getScaleInstance(0.001f * min / 0.8f, 0.001f * min / 0.8f));            GeneralPath path = PDType1Font.ZAPF_DINGBATS.getPath("a35");    addPath(contentStream, path);    contentStream.fillAndStroke();}
private void pdfbox_f5968_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 19);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.transform(Matrix.getScaleInstance(0.001f * min / 0.8f, 0.001f * min / 0.8f));    contentStream.transform(Matrix.getTranslateInstance(0, 50));            GeneralPath path = PDType1Font.ZAPF_DINGBATS.getPath("a20");    addPath(contentStream, path);    contentStream.fillAndStroke();}
private void pdfbox_f5969_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 17);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.transform(Matrix.getScaleInstance(0.001f * min / 0.8f, 0.001f * min / 0.8f));    contentStream.transform(Matrix.getTranslateInstance(0, 50));            GeneralPath path = PDType1Font.ZAPF_DINGBATS.getPath("a174");    addPath(contentStream, path);    contentStream.fillAndStroke();}
private void pdfbox_f5970_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 20);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(0);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.61f);    contentStream.transform(Matrix.getScaleInstance(0.001f * min / 1.5f, 0.001f * min / 1.5f));    contentStream.transform(Matrix.getTranslateInstance(0, 50));            GeneralPath path = PDType1Font.SYMBOL.getPath("circleplus");    addPath(contentStream, path);    contentStream.fillAndStroke();}
private void pdfbox_f5971_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    adjustRectAndBBox(annotation, 17, 20);    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.moveTo(1, 7);    contentStream.lineTo(5, 7);    contentStream.lineTo(5, 1);    contentStream.lineTo(12, 1);    contentStream.lineTo(12, 7);    contentStream.lineTo(16, 7);    contentStream.lineTo(8.5f, 19);    contentStream.closeAndFillAndStroke();}
private void pdfbox_f5972_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    adjustRectAndBBox(annotation, 17, 17);    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);    contentStream.transform(Matrix.getRotateInstance(Math.toRadians(45), 8, -4));    contentStream.moveTo(1, 7);    contentStream.lineTo(5, 7);    contentStream.lineTo(5, 1);    contentStream.lineTo(12, 1);    contentStream.lineTo(12, 7);    contentStream.lineTo(16, 7);    contentStream.lineTo(8.5f, 19);    contentStream.closeAndFillAndStroke();}
private void pdfbox_f5973_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    PDRectangle bbox = adjustRectAndBBox(annotation, 20, 20);    float min = Math.min(bbox.getWidth(), bbox.getHeight());    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);        contentStream.setLineWidth(0.59f);        contentStream.saveGraphicsState();    contentStream.setLineWidth(1);    PDExtendedGraphicsState gs = new PDExtendedGraphicsState();    gs.setAlphaSourceFlag(false);    gs.setStrokingAlphaConstant(0.6f);    gs.setNonStrokingAlphaConstant(0.6f);    gs.setBlendMode(BlendMode.NORMAL);    contentStream.setGraphicsStateParameters(gs);    contentStream.setNonStrokingColor(1f);    drawCircle2(contentStream, min / 2, min / 2, min / 2 - 1);    contentStream.fill();    contentStream.restoreGraphicsState();    contentStream.saveGraphicsState();            contentStream.transform(Matrix.getScaleInstance(0.001f * min / 1.3f, 0.001f * min / 1.3f));    contentStream.transform(Matrix.getTranslateInstance(200, 300));            GeneralPath path = PDType1Font.ZAPF_DINGBATS.getPath("a160");    addPath(contentStream, path);    contentStream.restoreGraphicsState();        drawCircle(contentStream, min / 2, min / 2, min / 2 - 1);    contentStream.fillAndStroke();}
private void pdfbox_f5974_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    adjustRectAndBBox(annotation, 18, 18);    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);    contentStream.setLineWidth(200);        contentStream.saveGraphicsState();    contentStream.setLineWidth(1);    PDExtendedGraphicsState gs = new PDExtendedGraphicsState();    gs.setAlphaSourceFlag(false);    gs.setStrokingAlphaConstant(0.6f);    gs.setNonStrokingAlphaConstant(0.6f);    gs.setBlendMode(BlendMode.NORMAL);    contentStream.setGraphicsStateParameters(gs);    contentStream.setNonStrokingColor(1f);    contentStream.addRect(0.3f, 0.3f, 18 - 0.6f, 18 - 0.6f);    contentStream.fill();    contentStream.restoreGraphicsState();    contentStream.transform(Matrix.getScaleInstance(0.003f, 0.003f));    contentStream.transform(Matrix.getTranslateInstance(500, -300));            contentStream.moveTo(2549, 5269);    contentStream.curveTo(1307, 5269, 300, 4451, 300, 3441);    contentStream.curveTo(300, 3023, 474, 2640, 764, 2331);    contentStream.curveTo(633, 1985, 361, 1691, 357, 1688);    contentStream.curveTo(299, 1626, 283, 1537, 316, 1459);    contentStream.curveTo(350, 1382, 426, 1332, 510, 1332);    contentStream.curveTo(1051, 1332, 1477, 1558, 1733, 1739);    contentStream.curveTo(1987, 1659, 2261, 1613, 2549, 1613);    contentStream.curveTo(3792, 1613, 4799, 2431, 4799, 3441);    contentStream.curveTo(4799, 4451, 3792, 5269, 2549, 5269);    contentStream.closePath();        contentStream.moveTo(0.3f / 0.003f - 500, 0.3f / 0.003f + 300);    contentStream.lineTo(0.3f / 0.003f - 500, 0.3f / 0.003f + 300 + 17.4f / 0.003f);    contentStream.lineTo(0.3f / 0.003f - 500 + 17.4f / 0.003f, 0.3f / 0.003f + 300 + 17.4f / 0.003f);    contentStream.lineTo(0.3f / 0.003f - 500 + 17.4f / 0.003f, 0.3f / 0.003f + 300);    contentStream.closeAndFillAndStroke();}
private void pdfbox_f5975_0(PDAnnotationText annotation, final PDAppearanceContentStream contentStream) throws IOException
{    adjustRectAndBBox(annotation, 13, 18);    contentStream.setMiterLimit(4);    contentStream.setLineJoinStyle(1);    contentStream.setLineCapStyle(0);    contentStream.setLineWidth(200);    contentStream.transform(Matrix.getScaleInstance(0.003f, 0.003f));    contentStream.transform(Matrix.getRotateInstance(Math.toRadians(45), 2500, -800));            contentStream.moveTo(4799, 4004);    contentStream.curveTo(4799, 3149, 4107, 2457, 3253, 2457);    contentStream.curveTo(3154, 2457, 3058, 2466, 2964, 2484);    contentStream.lineTo(2753, 2246);    contentStream.curveTo(2713, 2201, 2656, 2175, 2595, 2175);    contentStream.lineTo(2268, 2175);    contentStream.lineTo(2268, 1824);    contentStream.curveTo(2268, 1707, 2174, 1613, 2057, 1613);    contentStream.lineTo(1706, 1613);    contentStream.lineTo(1706, 1261);    contentStream.curveTo(1706, 1145, 1611, 1050, 1495, 1050);    contentStream.lineTo(510, 1050);    contentStream.curveTo(394, 1050, 300, 1145, 300, 1261);    contentStream.lineTo(300, 1947);    contentStream.curveTo(300, 2003, 322, 2057, 361, 2097);    contentStream.lineTo(1783, 3519);    contentStream.curveTo(1733, 3671, 1706, 3834, 1706, 4004);    contentStream.curveTo(1706, 4858, 2398, 5550, 3253, 5550);    contentStream.curveTo(4109, 5550, 4799, 4860, 4799, 4004);    contentStream.closePath();    contentStream.moveTo(3253, 4425);    contentStream.curveTo(3253, 4192, 3441, 4004, 3674, 4004);    contentStream.curveTo(3907, 4004, 4096, 4192, 4096, 4425);    contentStream.curveTo(4096, 4658, 3907, 4847, 3674, 4847);    contentStream.curveTo(3441, 4847, 3253, 4658, 3253, 4425);    contentStream.fillAndStroke();}
private void pdfbox_f5976_0(final PDAppearanceContentStream contentStream, GeneralPath path) throws IOException
{    double curX = 0;    double curY = 0;    PathIterator it = path.getPathIterator(new AffineTransform());    double[] coords = new double[6];    while (!it.isDone()) {        int type = it.currentSegment(coords);        switch(type) {            case PathIterator.SEG_CLOSE:                contentStream.closePath();                break;            case PathIterator.SEG_CUBICTO:                contentStream.curveTo((float) coords[0], (float) coords[1], (float) coords[2], (float) coords[3], (float) coords[4], (float) coords[5]);                curX = coords[4];                curY = coords[5];                break;            case PathIterator.SEG_QUADTO:                                                                                double cp1x = curX + 2d / 3d * (coords[0] - curX);                double cp1y = curY + 2d / 3d * (coords[1] - curY);                double cp2x = coords[2] + 2d / 3d * (coords[0] - coords[2]);                double cp2y = coords[3] + 2d / 3d * (coords[1] - coords[3]);                contentStream.curveTo((float) cp1x, (float) cp1y, (float) cp2x, (float) cp2y, (float) coords[2], (float) coords[3]);                curX = coords[2];                curY = coords[3];                break;            case PathIterator.SEG_LINETO:                contentStream.lineTo((float) coords[0], (float) coords[1]);                curX = coords[0];                curY = coords[1];                break;            case PathIterator.SEG_MOVETO:                contentStream.moveTo((float) coords[0], (float) coords[1]);                curX = coords[0];                curY = coords[1];                break;            default:                break;        }        it.next();    }}
public void pdfbox_f5979_0()
{    generateNormalAppearance();    generateRolloverAppearance();    generateDownAppearance();}
public void pdfbox_f5980_1()
{    PDAnnotationUnderline annotation = (PDAnnotationUnderline) getAnnotation();    PDRectangle rect = annotation.getRectangle();    float[] pathsArray = annotation.getQuadPoints();    if (pathsArray == null) {        return;    }    AnnotationBorder ab = AnnotationBorder.getAnnotationBorder(annotation, annotation.getBorderStyle());    PDColor color = annotation.getColor();    if (color == null || color.getComponents().length == 0) {        return;    }    if (Float.compare(ab.width, 0) == 0) {                ab.width = 1.5f;    }                    float minX = Float.MAX_VALUE;    float minY = Float.MAX_VALUE;    float maxX = Float.MIN_VALUE;    float maxY = Float.MIN_VALUE;    for (int i = 0; i < pathsArray.length / 2; ++i) {        float x = pathsArray[i * 2];        float y = pathsArray[i * 2 + 1];        minX = Math.min(minX, x);        minY = Math.min(minY, y);        maxX = Math.max(maxX, x);        maxY = Math.max(maxY, y);    }    rect.setLowerLeftX(Math.min(minX - ab.width / 2, rect.getLowerLeftX()));    rect.setLowerLeftY(Math.min(minY - ab.width / 2, rect.getLowerLeftY()));    rect.setUpperRightX(Math.max(maxX + ab.width / 2, rect.getUpperRightX()));    rect.setUpperRightY(Math.max(maxY + ab.width / 2, rect.getUpperRightY()));    annotation.setRectangle(rect);    try (PDAppearanceContentStream cs = getNormalAppearanceAsContentStream()) {        setOpacity(cs, annotation.getConstantOpacity());        cs.setStrokingColor(color);        if (ab.dashArray != null) {            cs.setLineDashPattern(ab.dashArray, 0);        }        cs.setLineWidth(ab.width);                for (int i = 0; i < pathsArray.length / 8; ++i) {                                                float len0 = (float) (Math.sqrt(Math.pow(pathsArray[i * 8] - pathsArray[i * 8 + 4], 2) + Math.pow(pathsArray[i * 8 + 1] - pathsArray[i * 8 + 5], 2)));            float x0 = pathsArray[i * 8 + 4];            float y0 = pathsArray[i * 8 + 5];            if (Float.compare(len0, 0) != 0) {                                x0 += (pathsArray[i * 8] - pathsArray[i * 8 + 4]) / len0 * len0 / 7;                y0 += (pathsArray[i * 8 + 1] - pathsArray[i * 8 + 5]) / len0 * (len0 / 7);            }            float len1 = (float) (Math.sqrt(Math.pow(pathsArray[i * 8 + 2] - pathsArray[i * 8 + 6], 2) + Math.pow(pathsArray[i * 8 + 3] - pathsArray[i * 8 + 7], 2)));            float x1 = pathsArray[i * 8 + 6];            float y1 = pathsArray[i * 8 + 7];            if (Float.compare(len1, 0) != 0) {                                x1 += (pathsArray[i * 8 + 2] - pathsArray[i * 8 + 6]) / len1 * len1 / 7;                y1 += (pathsArray[i * 8 + 3] - pathsArray[i * 8 + 7]) / len1 * len1 / 7;            }            cs.moveTo(x0, y0);            cs.lineTo(x1, y1);        }        cs.stroke();    } catch (IOException ex) {            }}
 PDFont pdfbox_f5983_0()
{    return font;}
public void pdfbox_f5984_0(PDFont font)
{    this.font = font;}
 float pdfbox_f5985_0()
{    return fontSize;}
public void pdfbox_f5986_0(float fontSize)
{    this.fontSize = fontSize;    leading = fontSize * 1.2f;}
 float pdfbox_f5987_0()
{    return leading;}
 void pdfbox_f5988_0(float leading)
{    this.leading = leading;}
 List<Paragraph> pdfbox_f5989_0()
{    return paragraphs;}
 String pdfbox_f5990_0()
{    return textContent;}
 List<Line> pdfbox_f5991_0(PDFont font, float fontSize, float width) throws IOException
{    BreakIterator iterator = BreakIterator.getLineInstance();    iterator.setText(textContent);    final float scale = fontSize / FONTSCALE;    int start = iterator.first();    int end = iterator.next();    float lineWidth = 0;    List<Line> textLines = new ArrayList<>();    Line textLine = new Line();    while (end != BreakIterator.DONE) {        String word = textContent.substring(start, end);        float wordWidth = font.getStringWidth(word) * scale;        lineWidth = lineWidth + wordWidth;                if (lineWidth >= width && Character.isWhitespace(word.charAt(word.length() - 1))) {            float whitespaceWidth = font.getStringWidth(word.substring(word.length() - 1)) * scale;            lineWidth = lineWidth - whitespaceWidth;        }        if (lineWidth >= width) {            textLine.setWidth(textLine.calculateWidth(font, fontSize));            textLines.add(textLine);            textLine = new Line();            lineWidth = font.getStringWidth(word) * scale;        }        AttributedString as = new AttributedString(word);        as.addAttribute(TextAttribute.WIDTH, wordWidth);        Word wordInstance = new Word(word);        wordInstance.setAttributes(as);        textLine.addWord(wordInstance);        start = end;        end = iterator.next();    }    textLine.setWidth(textLine.calculateWidth(font, fontSize));    textLines.add(textLine);    return textLines;}
 float pdfbox_f5992_0()
{    return lineWidth;}
 void pdfbox_f5993_0(float width)
{    lineWidth = width;}
 float pdfbox_f5994_0(PDFont font, float fontSize) throws IOException
{    final float scale = fontSize / FONTSCALE;    float calculatedWidth = 0f;    for (Word word : words) {        calculatedWidth = calculatedWidth + (Float) word.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH);        String text = word.getText();        if (words.indexOf(word) == words.size() - 1 && Character.isWhitespace(text.charAt(text.length() - 1))) {            float whitespaceWidth = font.getStringWidth(text.substring(text.length() - 1)) * scale;            calculatedWidth = calculatedWidth - whitespaceWidth;        }    }    return calculatedWidth;}
 List<Word> pdfbox_f5995_0()
{    return words;}
 float pdfbox_f5996_0(float width)
{    return (width - lineWidth) / (words.size() - 1);}
 void pdfbox_f5997_0(Word word)
{    words.add(word);}
 String pdfbox_f5998_0()
{    return textContent;}
 AttributedString pdfbox_f5999_0()
{    return attributedString;}
 void pdfbox_f6000_0(AttributedString as)
{    this.attributedString = as;}
 int pdfbox_f6001_0()
{    return alignment;}
public static TextAlign pdfbox_f6002_0(int alignment)
{    for (TextAlign textAlignment : TextAlign.values()) {        if (textAlignment.getTextAlign() == alignment) {            return textAlignment;        }    }    return TextAlign.LEFT;}
public Builder pdfbox_f6003_0(AppearanceStyle appearanceStyle)
{    this.appearanceStyle = appearanceStyle;    return this;}
public Builder pdfbox_f6004_0(boolean wrapLines)
{    this.wrapLines = wrapLines;    return this;}
public Builder pdfbox_f6005_0(float width)
{    this.width = width;    return this;}
public Builder pdfbox_f6006_0(int alignment)
{    this.textAlignment = TextAlign.valueOf(alignment);    return this;}
public Builder pdfbox_f6007_0(TextAlign alignment)
{    this.textAlignment = alignment;    return this;}
public Builder pdfbox_f6008_0(PlainText textContent)
{    this.textContent = textContent;    return this;}
public Builder pdfbox_f6009_0(float horizontalOffset, float verticalOffset)
{    this.horizontalOffset = horizontalOffset;    this.verticalOffset = verticalOffset;    return this;}
public PlainTextFormatter pdfbox_f6010_0()
{    return new PlainTextFormatter(this);}
public void pdfbox_f6011_0() throws IOException
{    if (textContent != null && !textContent.getParagraphs().isEmpty()) {        boolean isFirstParagraph = true;        for (Paragraph paragraph : textContent.getParagraphs()) {            if (wrapLines) {                List<Line> lines = paragraph.getLines(appearanceStyle.getFont(), appearanceStyle.getFontSize(), width);                processLines(lines, isFirstParagraph);                isFirstParagraph = false;            } else {                float startOffset = 0f;                float lineWidth = appearanceStyle.getFont().getStringWidth(paragraph.getText()) * appearanceStyle.getFontSize() / FONTSCALE;                if (lineWidth < width) {                    switch(textAlignment) {                        case CENTER:                            startOffset = (width - lineWidth) / 2;                            break;                        case RIGHT:                            startOffset = width - lineWidth;                            break;                        case JUSTIFY:                        default:                            startOffset = 0f;                    }                }                contents.newLineAtOffset(horizontalOffset + startOffset, verticalOffset);                contents.showText(paragraph.getText());            }        }    }}
private void pdfbox_f6012_0(List<Line> lines, boolean isFirstParagraph) throws IOException
{    float wordWidth;    float lastPos = 0f;    float startOffset = 0f;    float interWordSpacing = 0f;    for (Line line : lines) {        switch(textAlignment) {            case CENTER:                startOffset = (width - line.getWidth()) / 2;                break;            case RIGHT:                startOffset = width - line.getWidth();                break;            case JUSTIFY:                if (lines.indexOf(line) != lines.size() - 1) {                    interWordSpacing = line.getInterWordSpacing(width);                }                break;            default:                startOffset = 0f;        }        float offset = -lastPos + startOffset + horizontalOffset;        if (lines.indexOf(line) == 0 && isFirstParagraph) {            contents.newLineAtOffset(offset, verticalOffset);        } else {                        verticalOffset = verticalOffset - appearanceStyle.getLeading();            contents.newLineAtOffset(offset, -appearanceStyle.getLeading());        }        lastPos += offset;        List<Word> words = line.getWords();        for (Word word : words) {            contents.showText(word.getText());            wordWidth = (Float) word.getAttributes().getIterator().getAttribute(TextAttribute.WIDTH);            if (words.indexOf(word) != words.size() - 1) {                contents.newLineAtOffset(wordWidth + interWordSpacing, 0f);                lastPos = lastPos + wordWidth + interWordSpacing;            }        }    }    horizontalOffset = horizontalOffset - lastPos;}
public static PDAnnotation pdfbox_f6013_1(COSBase base) throws IOException
{    PDAnnotation annot = null;    if (base instanceof COSDictionary) {        COSDictionary annotDic = (COSDictionary) base;        String subtype = annotDic.getNameAsString(COSName.SUBTYPE);        if (PDAnnotationFileAttachment.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationFileAttachment(annotDic);        } else if (PDAnnotationLine.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationLine(annotDic);        } else if (PDAnnotationLink.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationLink(annotDic);        } else if (PDAnnotationPopup.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationPopup(annotDic);        } else if (PDAnnotationRubberStamp.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationRubberStamp(annotDic);        } else if (PDAnnotationSquare.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationSquare(annotDic);        } else if (PDAnnotationCircle.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationCircle(annotDic);        } else if (PDAnnotationPolygon.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationPolygon(annotDic);        } else if (PDAnnotationPolyline.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationPolyline(annotDic);        } else if (PDAnnotationInk.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationInk(annotDic);        } else if (PDAnnotationText.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationText(annotDic);        } else if (PDAnnotationHighlight.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationHighlight(annotDic);        } else if (PDAnnotationUnderline.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationUnderline(annotDic);        } else if (PDAnnotationStrikeout.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationStrikeout(annotDic);        } else if (PDAnnotationSquiggly.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationSquiggly(annotDic);        } else if (PDAnnotationWidget.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationWidget(annotDic);        } else if (PDAnnotationFreeText.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationFreeText(annotDic);        } else if (PDAnnotationCaret.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationCaret(annotDic);        } else if (PDAnnotationSound.SUB_TYPE.equals(subtype)) {            annot = new PDAnnotationSound(annotDic);        } else {                                    annot = new PDAnnotationUnknown(annotDic);                    }    } else {        throw new IOException("Error: Unknown annotation type " + base);    }    return annot;}
protected final void pdfbox_f6014_0(String subType)
{    getCOSObject().setName(COSName.SUBTYPE, subType);}
public final String pdfbox_f6015_0()
{    return getCOSObject().getNameAsString(COSName.SUBTYPE);}
public PDRectangle pdfbox_f6016_1()
{    COSArray rectArray = (COSArray) dictionary.getDictionaryObject(COSName.RECT);    PDRectangle rectangle = null;    if (rectArray != null) {        if (rectArray.size() == 4 && rectArray.getObject(0) instanceof COSNumber && rectArray.getObject(1) instanceof COSNumber && rectArray.getObject(2) instanceof COSNumber && rectArray.getObject(3) instanceof COSNumber) {            rectangle = new PDRectangle(rectArray);        } else {                    }    }    return rectangle;}
public void pdfbox_f6017_0(PDRectangle rectangle)
{    dictionary.setItem(COSName.RECT, rectangle.getCOSArray());}
public int pdfbox_f6018_0()
{    return getCOSObject().getInt(COSName.F, 0);}
public void pdfbox_f6019_0(int flags)
{    getCOSObject().setInt(COSName.F, flags);}
public COSDictionary pdfbox_f6020_0()
{    return dictionary;}
public COSName pdfbox_f6021_0()
{    return getCOSObject().getCOSName(COSName.AS);}
public void pdfbox_f6022_0(String as)
{    getCOSObject().setName(COSName.AS, as);}
public PDAppearanceDictionary pdfbox_f6023_0()
{    COSBase base = dictionary.getDictionaryObject(COSName.AP);    if (base instanceof COSDictionary) {        return new PDAppearanceDictionary((COSDictionary) base);    }    return null;}
public void pdfbox_f6024_0(PDAppearanceDictionary appearance)
{    dictionary.setItem(COSName.AP, appearance);}
public PDAppearanceStream pdfbox_f6025_0()
{    PDAppearanceDictionary appearanceDict = getAppearance();    if (appearanceDict == null) {        return null;    }    PDAppearanceEntry normalAppearance = appearanceDict.getNormalAppearance();    if (normalAppearance == null) {        return null;    }    if (normalAppearance.isSubDictionary()) {        COSName state = getAppearanceState();        return normalAppearance.getSubDictionary().get(state);    } else {        return normalAppearance.getAppearanceStream();    }}
public boolean pdfbox_f6026_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_INVISIBLE);}
public void pdfbox_f6027_0(boolean invisible)
{    getCOSObject().setFlag(COSName.F, FLAG_INVISIBLE, invisible);}
public boolean pdfbox_f6028_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_HIDDEN);}
public void pdfbox_f6029_0(boolean hidden)
{    getCOSObject().setFlag(COSName.F, FLAG_HIDDEN, hidden);}
public boolean pdfbox_f6030_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_PRINTED);}
public void pdfbox_f6031_0(boolean printed)
{    getCOSObject().setFlag(COSName.F, FLAG_PRINTED, printed);}
public boolean pdfbox_f6032_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_NO_ZOOM);}
public void pdfbox_f6033_0(boolean noZoom)
{    getCOSObject().setFlag(COSName.F, FLAG_NO_ZOOM, noZoom);}
public boolean pdfbox_f6034_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_NO_ROTATE);}
public void pdfbox_f6035_0(boolean noRotate)
{    getCOSObject().setFlag(COSName.F, FLAG_NO_ROTATE, noRotate);}
public boolean pdfbox_f6036_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_NO_VIEW);}
public void pdfbox_f6037_0(boolean noView)
{    getCOSObject().setFlag(COSName.F, FLAG_NO_VIEW, noView);}
public boolean pdfbox_f6038_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_READ_ONLY);}
public void pdfbox_f6039_0(boolean readOnly)
{    getCOSObject().setFlag(COSName.F, FLAG_READ_ONLY, readOnly);}
public boolean pdfbox_f6040_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_LOCKED);}
public void pdfbox_f6041_0(boolean locked)
{    getCOSObject().setFlag(COSName.F, FLAG_LOCKED, locked);}
public boolean pdfbox_f6042_0()
{    return getCOSObject().getFlag(COSName.F, FLAG_TOGGLE_NO_VIEW);}
public void pdfbox_f6043_0(boolean toggleNoView)
{    getCOSObject().setFlag(COSName.F, FLAG_TOGGLE_NO_VIEW, toggleNoView);}
public String pdfbox_f6044_0()
{    return dictionary.getString(COSName.CONTENTS);}
public void pdfbox_f6045_0(String value)
{    dictionary.setString(COSName.CONTENTS, value);}
public String pdfbox_f6046_0()
{    return getCOSObject().getString(COSName.M);}
public void pdfbox_f6047_0(String m)
{    getCOSObject().setString(COSName.M, m);}
public void pdfbox_f6048_0(Calendar c)
{    getCOSObject().setDate(COSName.M, c);}
public String pdfbox_f6049_0()
{    return getCOSObject().getString(COSName.NM);}
public void pdfbox_f6050_0(String nm)
{    getCOSObject().setString(COSName.NM, nm);}
public int pdfbox_f6051_0()
{    return getCOSObject().getInt(COSName.STRUCT_PARENT);}
public void pdfbox_f6052_0(int structParent)
{    getCOSObject().setInt(COSName.STRUCT_PARENT, structParent);}
public PDPropertyList pdfbox_f6053_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.OC);    if (base instanceof COSDictionary) {        return PDPropertyList.create((COSDictionary) base);    }    return null;}
public void pdfbox_f6054_0(PDPropertyList oc)
{    getCOSObject().setItem(COSName.OC, oc);}
public COSArray pdfbox_f6055_0()
{    COSBase base = getCOSObject().getDictionaryObject(COSName.BORDER);    COSArray border;    if (base instanceof COSArray) {        border = (COSArray) base;        if (border.size() < 3) {                        COSArray newBorder = new COSArray();            newBorder.addAll(border);            border = newBorder;                        while (border.size() < 3) {                border.add(COSInteger.ZERO);            }        }    } else {        border = new COSArray();        border.add(COSInteger.ZERO);        border.add(COSInteger.ZERO);        border.add(COSInteger.ONE);    }    return border;}
public void pdfbox_f6056_0(COSArray borderArray)
{    getCOSObject().setItem(COSName.BORDER, borderArray);}
public void pdfbox_f6057_0(PDColor c)
{    getCOSObject().setItem(COSName.C, c.toCOSArray());}
public PDColor pdfbox_f6058_0()
{    return getColor(COSName.C);}
protected PDColor pdfbox_f6059_0(COSName itemName)
{    COSBase c = this.getCOSObject().getItem(itemName);    if (c instanceof COSArray) {        PDColorSpace colorSpace = null;        switch(((COSArray) c).size()) {            case 1:                colorSpace = PDDeviceGray.INSTANCE;                break;            case 3:                colorSpace = PDDeviceRGB.INSTANCE;                break;            case 4:                colorSpace = PDDeviceCMYK.INSTANCE;                break;            default:                break;        }        return new PDColor((COSArray) c, colorSpace);    }    return null;}
public void pdfbox_f6060_0(PDPage page)
{    this.getCOSObject().setItem(COSName.P, page);}
public PDPage pdfbox_f6061_0()
{    COSBase base = this.getCOSObject().getDictionaryObject(COSName.P);    if (base instanceof COSDictionary) {        return new PDPage((COSDictionary) base);    }    return null;}
public void pdfbox_f6064_0(float difference)
{    setRectDifferences(difference, difference, difference, difference);}
public void pdfbox_f6065_0(float differenceLeft, float differenceTop, float differenceRight, float differenceBottom)
{    COSArray margins = new COSArray();    margins.add(new COSFloat(differenceLeft));    margins.add(new COSFloat(differenceTop));    margins.add(new COSFloat(differenceRight));    margins.add(new COSFloat(differenceBottom));    getCOSObject().setItem(COSName.RD, margins);}
public float[] pdfbox_f6066_0()
{    COSBase margin = getCOSObject().getItem(COSName.RD);    if (margin instanceof COSArray) {        return ((COSArray) margin).toFloatArray();    }    return new float[] {};}
public void pdfbox_f6067_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6068_0()
{    this.constructAppearances(null);}
public void pdfbox_f6069_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public void pdfbox_f6070_0(PDAppearanceHandler appearanceHandler)
{    customAppearanceHandler = appearanceHandler;}
public void pdfbox_f6071_0()
{    this.constructAppearances(null);}
public void pdfbox_f6072_0(PDDocument document)
{    if (customAppearanceHandler == null) {        PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(this, document);        appearanceHandler.generateAppearanceStreams();    } else {        customAppearanceHandler.generateAppearanceStreams();    }}
public PDFileSpecification pdfbox_f6073_0() throws IOException
{    return PDFileSpecification.createFS(getCOSObject().getDictionaryObject("FS"));}
public void pdfbox_f6074_0(PDFileSpecification file)
{    getCOSObject().setItem("FS", file);}
public String pdfbox_f6075_0()
{    return getCOSObject().getNameAsString(COSName.NAME, ATTACHMENT_NAME_PUSH_PIN);}
public void pdfbox_f6076_0(String name)
{    getCOSObject().setName(COSName.NAME, name);}
public String pdfbox_f6077_0()
{    return getCOSObject().getString(COSName.DA);}
public void pdfbox_f6078_0(String daValue)
{    getCOSObject().setString(COSName.DA, daValue);}
public String pdfbox_f6079_0()
{    return getCOSObject().getString(COSName.DS);}
public void pdfbox_f6080_0(String defaultStyleString)
{    getCOSObject().setString(COSName.DS, defaultStyleString);}
