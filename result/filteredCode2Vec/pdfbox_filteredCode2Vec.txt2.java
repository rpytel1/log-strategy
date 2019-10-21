 void pdfbox_f2028_0(long checkSumValue)
{    this.checkSum = checkSumValue;}
public long pdfbox_f2029_0()
{    return length;}
 void pdfbox_f2030_0(long lengthValue)
{    this.length = lengthValue;}
public long pdfbox_f2031_0()
{    return offset;}
 void pdfbox_f2032_0(long offsetValue)
{    this.offset = offsetValue;}
public String pdfbox_f2033_0()
{    return tag;}
 void pdfbox_f2034_0(String tagValue)
{    this.tag = tagValue;}
public boolean pdfbox_f2035_0()
{    return initialized;}
 void pdfbox_f2037_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    version = data.read32Fixed();    ascender = data.readSignedShort();    descender = data.readSignedShort();    lineGap = data.readSignedShort();    advanceHeightMax = data.readUnsignedShort();    minTopSideBearing = data.readSignedShort();    minBottomSideBearing = data.readSignedShort();    yMaxExtent = data.readSignedShort();    caretSlopeRise = data.readSignedShort();    caretSlopeRun = data.readSignedShort();    caretOffset = data.readSignedShort();    reserved1 = data.readSignedShort();    reserved2 = data.readSignedShort();    reserved3 = data.readSignedShort();    reserved4 = data.readSignedShort();    metricDataFormat = data.readSignedShort();    numberOfVMetrics = data.readUnsignedShort();    initialized = true;}
public int pdfbox_f2038_0()
{    return advanceHeightMax;}
public short pdfbox_f2039_0()
{    return ascender;}
public short pdfbox_f2040_0()
{    return caretSlopeRise;}
public short pdfbox_f2041_0()
{    return caretSlopeRun;}
public short pdfbox_f2042_0()
{    return caretOffset;}
public short pdfbox_f2043_0()
{    return descender;}
public short pdfbox_f2044_0()
{    return lineGap;}
public short pdfbox_f2045_0()
{    return metricDataFormat;}
public short pdfbox_f2046_0()
{    return minTopSideBearing;}
public short pdfbox_f2047_0()
{    return minBottomSideBearing;}
public int pdfbox_f2048_0()
{    return numberOfVMetrics;}
public short pdfbox_f2049_0()
{    return reserved1;}
public short pdfbox_f2050_0()
{    return reserved2;}
public short pdfbox_f2051_0()
{    return reserved3;}
public short pdfbox_f2052_0()
{    return reserved4;}
public float pdfbox_f2053_0()
{    return version;}
public short pdfbox_f2054_0()
{    return yMaxExtent;}
 void pdfbox_f2055_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    VerticalHeaderTable vHeader = ttf.getVerticalHeader();    if (vHeader == null) {        throw new IOException("Could not get vhea table");    }    numVMetrics = vHeader.getNumberOfVMetrics();    int numGlyphs = ttf.getNumberOfGlyphs();    int bytesRead = 0;    advanceHeight = new int[numVMetrics];    topSideBearing = new short[numVMetrics];    for (int i = 0; i < numVMetrics; i++) {        advanceHeight[i] = data.readUnsignedShort();        topSideBearing[i] = data.readSignedShort();        bytesRead += 4;    }    if (bytesRead < getLength()) {        int numberNonVertical = numGlyphs - numVMetrics;                if (numberNonVertical < 0) {            numberNonVertical = numGlyphs;        }        additionalTopSideBearing = new short[numberNonVertical];        for (int i = 0; i < numberNonVertical; i++) {            if (bytesRead < getLength()) {                additionalTopSideBearing[i] = data.readSignedShort();                bytesRead += 2;            }        }    }    initialized = true;}
public int pdfbox_f2056_0(int gid)
{    if (gid < numVMetrics) {        return topSideBearing[gid];    } else {        return additionalTopSideBearing[gid - numVMetrics];    }}
public int pdfbox_f2057_0(int gid)
{    if (gid < numVMetrics) {        return advanceHeight[gid];    } else {                return advanceHeight[advanceHeight.length - 1];    }}
 void pdfbox_f2058_0(TrueTypeFont ttf, TTFDataStream data) throws IOException
{    version = data.read32Fixed();    defaultVertOriginY = data.readSignedShort();    int numVertOriginYMetrics = data.readUnsignedShort();    origins = new ConcurrentHashMap<>(numVertOriginYMetrics);    for (int i = 0; i < numVertOriginYMetrics; ++i) {        int g = data.readUnsignedShort();        int y = data.readSignedShort();        origins.put(g, y);    }    initialized = true;}
public float pdfbox_f2059_0()
{    return version;}
public int pdfbox_f2060_0(int gid)
{    if (origins.containsKey(gid)) {        return origins.get(gid);    } else {        return defaultVertOriginY;    }}
public String pdfbox_f2061_0()
{    return text;}
public Kind pdfbox_f2062_0()
{    return kind;}
public int pdfbox_f2063_0()
{        return (int) Float.parseFloat(text);}
public float pdfbox_f2064_0()
{    return Float.parseFloat(text);}
public boolean pdfbox_f2065_0()
{    return text.equals("true");}
public byte[] pdfbox_f2066_0()
{    return data;}
public String pdfbox_f2067_0()
{    if (kind == CHARSTRING) {        return "Token[kind=CHARSTRING, data=" + data.length + " bytes]";    } else {        return "Token[kind=" + kind + ", text=" + text + "]";    }}
public static Type1Font pdfbox_f2068_0(InputStream pfbStream) throws IOException
{    PfbParser pfb = new PfbParser(pfbStream);    Type1Parser parser = new Type1Parser();    return parser.parse(pfb.getSegment1(), pfb.getSegment2());}
public static Type1Font pdfbox_f2069_0(byte[] pfbBytes) throws IOException
{    PfbParser pfb = new PfbParser(pfbBytes);    Type1Parser parser = new Type1Parser();    return parser.parse(pfb.getSegment1(), pfb.getSegment2());}
public static Type1Font pdfbox_f2070_0(byte[] segment1, byte[] segment2) throws IOException
{    Type1Parser parser = new Type1Parser();    return parser.parse(segment1, segment2);}
public List<byte[]> pdfbox_f2071_0()
{    return Collections.unmodifiableList(subrs);}
public Map<String, byte[]> pdfbox_f2072_0()
{    return Collections.unmodifiableMap(charstrings);}
public String pdfbox_f2073_0()
{    return fontName;}
public GeneralPath pdfbox_f2074_0(String name) throws IOException
{    return getType1CharString(name).getPath();}
public float pdfbox_f2075_0(String name) throws IOException
{    return getType1CharString(name).getWidth();}
public boolean pdfbox_f2076_0(String name)
{    return charstrings.get(name) != null;}
public Type1CharString pdfbox_f2077_0(String name) throws IOException
{    Type1CharString type1 = charStringCache.get(name);    if (type1 == null) {        byte[] bytes = charstrings.get(name);        if (bytes == null) {            bytes = charstrings.get(".notdef");        }        Type1CharStringParser parser = new Type1CharStringParser(fontName, name);        List<Object> sequence = parser.parse(bytes, subrs);        type1 = new Type1CharString(this, fontName, name, sequence);        charStringCache.put(name, type1);    }    return type1;}
public String pdfbox_f2078_0()
{    return fontName;}
public Encoding pdfbox_f2079_0()
{    return encoding;}
public int pdfbox_f2080_0()
{    return paintType;}
public int pdfbox_f2081_0()
{    return fontType;}
public List<Number> pdfbox_f2082_0()
{    return Collections.unmodifiableList(fontMatrix);}
public BoundingBox pdfbox_f2083_0()
{    return new BoundingBox(fontBBox);}
public int pdfbox_f2084_0()
{    return uniqueID;}
public float pdfbox_f2085_0()
{    return strokeWidth;}
public String pdfbox_f2086_0()
{    return fontID;}
public String pdfbox_f2087_0()
{    return version;}
public String pdfbox_f2088_0()
{    return notice;}
public String pdfbox_f2089_0()
{    return fullName;}
public String pdfbox_f2090_0()
{    return familyName;}
public String pdfbox_f2091_0()
{    return weight;}
public float pdfbox_f2092_0()
{    return italicAngle;}
public boolean pdfbox_f2093_0()
{    return isFixedPitch;}
public float pdfbox_f2094_0()
{    return underlinePosition;}
public float pdfbox_f2095_0()
{    return underlineThickness;}
public List<Number> pdfbox_f2096_0()
{    return Collections.unmodifiableList(blueValues);}
public List<Number> pdfbox_f2097_0()
{    return Collections.unmodifiableList(otherBlues);}
public List<Number> pdfbox_f2098_0()
{    return Collections.unmodifiableList(familyBlues);}
public List<Number> pdfbox_f2099_0()
{    return Collections.unmodifiableList(familyOtherBlues);}
public float pdfbox_f2100_0()
{    return blueScale;}
public int pdfbox_f2101_0()
{    return blueShift;}
public int pdfbox_f2102_0()
{    return blueFuzz;}
public List<Number> pdfbox_f2103_0()
{    return Collections.unmodifiableList(stdHW);}
public List<Number> pdfbox_f2104_0()
{    return Collections.unmodifiableList(stdVW);}
public List<Number> pdfbox_f2105_0()
{    return Collections.unmodifiableList(stemSnapH);}
public List<Number> pdfbox_f2106_0()
{    return Collections.unmodifiableList(stemSnapV);}
public boolean pdfbox_f2107_0()
{    return forceBold;}
public int pdfbox_f2108_0()
{    return languageGroup;}
public byte[] pdfbox_f2109_0()
{    return segment1;}
public byte[] pdfbox_f2110_0()
{    return segment2;}
public String pdfbox_f2111_0()
{    return getClass().getName() + "[fontName=" + fontName + ", fullName=" + fullName + ", encoding=" + encoding + ", charStringsDict=" + charstrings + "]";}
public Token pdfbox_f2112_0() throws IOException
{    Token curToken = aheadToken;        aheadToken = readToken(curToken);    return curToken;}
public Token pdfbox_f2113_0()
{    return aheadToken;}
private char pdfbox_f2114_0()
{    return (char) buffer.get();}
private Token pdfbox_f2115_1(Token prevToken) throws IOException
{    boolean skip;    do {        skip = false;        while (buffer.hasRemaining()) {            char c = getChar();                        if (c == '%') {                                readComment();            } else if (c == '(') {                return readString();            } else if (c == ')') {                                throw new IOException("unexpected closing parenthesis");            } else if (c == '[') {                return new Token(c, Token.START_ARRAY);            } else if (c == '{') {                return new Token(c, Token.START_PROC);            } else if (c == ']') {                return new Token(c, Token.END_ARRAY);            } else if (c == '}') {                return new Token(c, Token.END_PROC);            } else if (c == '/') {                return new Token(readRegular(), Token.LITERAL);            } else if (c == '<') {                char c2 = getChar();                if (c2 == c) {                    return new Token("<<", Token.START_DICT);                } else {                                        buffer.position(buffer.position() - 1);                    return new Token(c, Token.NAME);                }            } else if (c == '>') {                char c2 = getChar();                if (c2 == c) {                    return new Token(">>", Token.END_DICT);                } else {                                        buffer.position(buffer.position() - 1);                    return new Token(c, Token.NAME);                }            } else if (Character.isWhitespace(c)) {                skip = true;            } else if (c == 0) {                                skip = true;            } else {                buffer.position(buffer.position() - 1);                                Token number = tryReadNumber();                if (number != null) {                    return number;                } else {                                        String name = readRegular();                    if (name == null) {                                                throw new DamagedFontException("Could not read token at position " + buffer.position());                    }                    if (name.equals("RD") || name.equals("-|")) {                                                if (prevToken.getKind() == Token.INTEGER) {                            return readCharString(prevToken.intValue());                        } else {                            throw new IOException("expected INTEGER before -| or RD");                        }                    } else {                        return new Token(name, Token.NAME);                    }                }            }        }    } while (skip);    return null;}
private Token pdfbox_f2116_0()
{    buffer.mark();    StringBuilder sb = new StringBuilder();    StringBuilder radix = null;    char c = getChar();    boolean hasDigit = false;        if (c == '+' || c == '-') {        sb.append(c);        c = getChar();    }        while (Character.isDigit(c)) {        sb.append(c);        c = getChar();        hasDigit = true;    }        if (c == '.') {        sb.append(c);        c = getChar();    } else if (c == '#') {                radix = sb;        sb = new StringBuilder();        c = getChar();    } else if (sb.length() == 0 || !hasDigit) {                buffer.reset();        return null;    } else {                buffer.position(buffer.position() - 1);        return new Token(sb.toString(), Token.INTEGER);    }        if (Character.isDigit(c)) {        sb.append(c);        c = getChar();    } else {                buffer.reset();        return null;    }        while (Character.isDigit(c)) {        sb.append(c);        c = getChar();    }        if (c == 'E') {        sb.append(c);        c = getChar();                if (c == '-') {            sb.append(c);            c = getChar();        }                if (Character.isDigit(c)) {            sb.append(c);            c = getChar();        } else {                        buffer.reset();            return null;        }                while (Character.isDigit(c)) {            sb.append(c);            c = getChar();        }    }    buffer.position(buffer.position() - 1);    if (radix != null) {        Integer val = Integer.parseInt(sb.toString(), Integer.parseInt(radix.toString()));        return new Token(val.toString(), Token.INTEGER);    }    return new Token(sb.toString(), Token.REAL);}
private String pdfbox_f2117_0()
{    StringBuilder sb = new StringBuilder();    while (buffer.hasRemaining()) {        buffer.mark();        char c = getChar();        if (Character.isWhitespace(c) || c == '(' || c == ')' || c == '<' || c == '>' || c == '[' || c == ']' || c == '{' || c == '}' || c == '/' || c == '%') {            buffer.reset();            break;        } else {            sb.append(c);        }    }    String regular = sb.toString();    if (regular.length() == 0) {        return null;    }    return regular;}
private String pdfbox_f2118_0()
{    StringBuilder sb = new StringBuilder();    while (buffer.hasRemaining()) {        char c = getChar();        if (c == '\r' || c == '\n') {            break;        } else {            sb.append(c);        }    }    return sb.toString();}
private Token pdfbox_f2119_0()
{    StringBuilder sb = new StringBuilder();    while (buffer.hasRemaining()) {        char c = getChar();                switch(c) {            case '(':                openParens++;                sb.append('(');                break;            case ')':                if (openParens == 0) {                                        return new Token(sb.toString(), Token.STRING);                }                sb.append(')');                openParens--;                break;            case '\\':                                char c1 = getChar();                switch(c1) {                    case 'n':                    case 'r':                        sb.append("\n");                        break;                    case 't':                        sb.append('\t');                        break;                    case 'b':                        sb.append('\b');                        break;                    case 'f':                        sb.append('\f');                        break;                    case '\\':                        sb.append('\\');                        break;                    case '(':                        sb.append('(');                        break;                    case ')':                        sb.append(')');                        break;                }                                if (Character.isDigit(c1)) {                    String num = String.valueOf(new char[] { c1, getChar(), getChar() });                    Integer code = Integer.parseInt(num, 8);                    sb.append((char) (int) code);                }                break;            case '\r':            case '\n':                sb.append("\n");                break;            default:                sb.append(c);                break;        }    }    return null;}
private Token pdfbox_f2120_0(int length)
{        buffer.get();    byte[] data = new byte[length];    buffer.get(data);    return new Token(data, Token.CHARSTRING);}
public Type1Font pdfbox_f2121_0(byte[] segment1, byte[] segment2) throws IOException
{    font = new Type1Font(segment1, segment2);    parseASCII(segment1);    if (segment2.length > 0) {        parseBinary(segment2);    }    return font;}
private void pdfbox_f2122_0(byte[] bytes) throws IOException
{    if (bytes.length == 0) {        throw new IllegalArgumentException("byte[] is empty");    }        if (bytes.length < 2 || (bytes[0] != '%' && bytes[1] != '!')) {        throw new IOException("Invalid start of ASCII segment");    }    lexer = new Type1Lexer(bytes);        if (lexer.peekToken().getText().equals("FontDirectory")) {        read(Token.NAME, "FontDirectory");                read(Token.LITERAL);        read(Token.NAME, "known");        read(Token.START_PROC);        readProc();        read(Token.START_PROC);        readProc();        read(Token.NAME, "ifelse");    }        int length = read(Token.INTEGER).intValue();    read(Token.NAME, "dict");        readMaybe(Token.NAME, "dup");        read(Token.NAME, "begin");    for (int i = 0; i < length; i++) {                Token token = lexer.peekToken();        if (token == null) {            break;        }        if (token.getKind() == Token.NAME && ("currentdict".equals(token.getText()) || "end".equals(token.getText()))) {            break;        }                String key = read(Token.LITERAL).getText();        switch(key) {            case "FontInfo":            case "Fontinfo":                readFontInfo(readSimpleDict());                break;            case "Metrics":                readSimpleDict();                break;            case "Encoding":                readEncoding();                break;            default:                readSimpleValue(key);                break;        }    }    readMaybe(Token.NAME, "currentdict");    read(Token.NAME, "end");    read(Token.NAME, "currentfile");    read(Token.NAME, "eexec");}
private void pdfbox_f2123_0(String key) throws IOException
{    List<Token> value = readDictValue();    switch(key) {        case "FontName":            font.fontName = value.get(0).getText();            break;        case "PaintType":            font.paintType = value.get(0).intValue();            break;        case "FontType":            font.fontType = value.get(0).intValue();            break;        case "FontMatrix":            font.fontMatrix = arrayToNumbers(value);            break;        case "FontBBox":            font.fontBBox = arrayToNumbers(value);            break;        case "UniqueID":            font.uniqueID = value.get(0).intValue();            break;        case "StrokeWidth":            font.strokeWidth = value.get(0).floatValue();            break;        case "FID":            font.fontID = value.get(0).getText();            break;        default:            break;    }}
private void pdfbox_f2124_0() throws IOException
{    if (lexer.peekToken().getKind() == Token.NAME) {        String name = lexer.nextToken().getText();        if (name.equals("StandardEncoding")) {            font.encoding = StandardEncoding.INSTANCE;        } else {            throw new IOException("Unknown encoding: " + name);        }        readMaybe(Token.NAME, "readonly");        read(Token.NAME, "def");    } else {        read(Token.INTEGER).intValue();        readMaybe(Token.NAME, "array");                while (!(lexer.peekToken().getKind() == Token.NAME && (lexer.peekToken().getText().equals("dup") || lexer.peekToken().getText().equals("readonly") || lexer.peekToken().getText().equals("def")))) {            lexer.nextToken();        }        Map<Integer, String> codeToName = new HashMap<>();        while (lexer.peekToken().getKind() == Token.NAME && lexer.peekToken().getText().equals("dup")) {            read(Token.NAME, "dup");            int code = read(Token.INTEGER).intValue();            String name = read(Token.LITERAL).getText();            read(Token.NAME, "put");            codeToName.put(code, name);        }        font.encoding = new BuiltInEncoding(codeToName);        readMaybe(Token.NAME, "readonly");        read(Token.NAME, "def");    }}
private List<Number> pdfbox_f2125_0(List<Token> value) throws IOException
{    List<Number> numbers = new ArrayList<>();    for (int i = 1, size = value.size() - 1; i < size; i++) {        Token token = value.get(i);        if (token.getKind() == Token.REAL) {            numbers.add(token.floatValue());        } else if (token.getKind() == Token.INTEGER) {            numbers.add(token.intValue());        } else {            throw new IOException("Expected INTEGER or REAL but got " + token.getKind());        }    }    return numbers;}
private void pdfbox_f2126_0(Map<String, List<Token>> fontInfo)
{    for (Map.Entry<String, List<Token>> entry : fontInfo.entrySet()) {        String key = entry.getKey();        List<Token> value = entry.getValue();        switch(key) {            case "version":                font.version = value.get(0).getText();                break;            case "Notice":                font.notice = value.get(0).getText();                break;            case "FullName":                font.fullName = value.get(0).getText();                break;            case "FamilyName":                font.familyName = value.get(0).getText();                break;            case "Weight":                font.weight = value.get(0).getText();                break;            case "ItalicAngle":                font.italicAngle = value.get(0).floatValue();                break;            case "isFixedPitch":                font.isFixedPitch = value.get(0).booleanValue();                break;            case "UnderlinePosition":                font.underlinePosition = value.get(0).floatValue();                break;            case "UnderlineThickness":                font.underlineThickness = value.get(0).floatValue();                break;            default:                break;        }    }}
private Map<String, List<Token>> pdfbox_f2127_0() throws IOException
{    Map<String, List<Token>> dict = new HashMap<>();    int length = read(Token.INTEGER).intValue();    read(Token.NAME, "dict");    readMaybe(Token.NAME, "dup");    read(Token.NAME, "begin");    for (int i = 0; i < length; i++) {        if (lexer.peekToken() == null) {            break;        }        if (lexer.peekToken().getKind() == Token.NAME && !lexer.peekToken().getText().equals("end")) {            read(Token.NAME);        }                if (lexer.peekToken() == null) {            break;        }        if (lexer.peekToken().getKind() == Token.NAME && lexer.peekToken().getText().equals("end")) {            break;        }                String key = read(Token.LITERAL).getText();        List<Token> value = readDictValue();        dict.put(key, value);    }    read(Token.NAME, "end");    readMaybe(Token.NAME, "readonly");    read(Token.NAME, "def");    return dict;}
private List<Token> pdfbox_f2128_0() throws IOException
{    List<Token> value = readValue();    readDef();    return value;}
private List<Token> pdfbox_f2129_0() throws IOException
{    List<Token> value = new ArrayList<>();    Token token = lexer.nextToken();    if (lexer.peekToken() == null) {        return value;    }    value.add(token);    if (token.getKind() == Token.START_ARRAY) {        int openArray = 1;        while (true) {            if (lexer.peekToken() == null) {                return value;            }            if (lexer.peekToken().getKind() == Token.START_ARRAY) {                openArray++;            }            token = lexer.nextToken();            value.add(token);            if (token.getKind() == Token.END_ARRAY) {                openArray--;                if (openArray == 0) {                    break;                }            }        }    } else if (token.getKind() == Token.START_PROC) {        value.addAll(readProc());    } else if (token.getKind() == Token.START_DICT) {                read(Token.END_DICT);        return value;    }    readPostScriptWrapper(value);    return value;}
private void pdfbox_f2130_0(List<Token> value) throws IOException
{        if (lexer.peekToken().getText().equals("systemdict")) {        read(Token.NAME, "systemdict");        read(Token.LITERAL, "internaldict");        read(Token.NAME, "known");        read(Token.START_PROC);        readProc();        read(Token.START_PROC);        readProc();        read(Token.NAME, "ifelse");                read(Token.START_PROC);        read(Token.NAME, "pop");        value.clear();        value.addAll(readValue());        read(Token.END_PROC);        read(Token.NAME, "if");    }}
private List<Token> pdfbox_f2131_0() throws IOException
{    List<Token> value = new ArrayList<>();    int openProc = 1;    while (true) {        if (lexer.peekToken().getKind() == Token.START_PROC) {            openProc++;        }        Token token = lexer.nextToken();        value.add(token);        if (token.getKind() == Token.END_PROC) {            openProc--;            if (openProc == 0) {                break;            }        }    }    Token executeonly = readMaybe(Token.NAME, "executeonly");    if (executeonly != null) {        value.add(executeonly);    }    return value;}
private void pdfbox_f2132_0(byte[] bytes) throws IOException
{    byte[] decrypted;        if (isBinary(bytes)) {        decrypted = decrypt(bytes, EEXEC_KEY, 4);    } else {        decrypted = decrypt(hexToBinary(bytes), EEXEC_KEY, 4);    }    lexer = new Type1Lexer(decrypted);        Token peekToken = lexer.peekToken();    while (peekToken != null && !peekToken.getText().equals("Private")) {                                lexer.nextToken();        peekToken = lexer.peekToken();    }    if (peekToken == null) {        throw new IOException("/Private token not found");    }        read(Token.LITERAL, "Private");    int length = read(Token.INTEGER).intValue();    read(Token.NAME, "dict");            readMaybe(Token.NAME, "dup");    read(Token.NAME, "begin");        int lenIV = 4;    for (int i = 0; i < length; i++) {                if (lexer.peekToken() == null || lexer.peekToken().getKind() != Token.LITERAL) {            break;        }                String key = read(Token.LITERAL).getText();        switch(key) {            case "Subrs":                readSubrs(lenIV);                break;            case "OtherSubrs":                readOtherSubrs();                break;            case "lenIV":                lenIV = readDictValue().get(0).intValue();                break;            case "ND":                read(Token.START_PROC);                                readMaybe(Token.NAME, "noaccess");                read(Token.NAME, "def");                read(Token.END_PROC);                readMaybe(Token.NAME, "executeonly");                read(Token.NAME, "def");                break;            case "NP":                read(Token.START_PROC);                readMaybe(Token.NAME, "noaccess");                read(Token.NAME);                read(Token.END_PROC);                readMaybe(Token.NAME, "executeonly");                read(Token.NAME, "def");                break;            case "RD":                                read(Token.START_PROC);                readProc();                readMaybe(Token.NAME, "bind");                readMaybe(Token.NAME, "executeonly");                read(Token.NAME, "def");                break;            default:                readPrivate(key, readDictValue());                break;        }    }        while (!(lexer.peekToken().getKind() == Token.LITERAL && lexer.peekToken().getText().equals("CharStrings"))) {        lexer.nextToken();    }        read(Token.LITERAL, "CharStrings");    readCharStrings(lenIV);}
private void pdfbox_f2133_0(String key, List<Token> value) throws IOException
{    switch(key) {        case "BlueValues":            font.blueValues = arrayToNumbers(value);            break;        case "OtherBlues":            font.otherBlues = arrayToNumbers(value);            break;        case "FamilyBlues":            font.familyBlues = arrayToNumbers(value);            break;        case "FamilyOtherBlues":            font.familyOtherBlues = arrayToNumbers(value);            break;        case "BlueScale":            font.blueScale = value.get(0).floatValue();            break;        case "BlueShift":            font.blueShift = value.get(0).intValue();            break;        case "BlueFuzz":            font.blueFuzz = value.get(0).intValue();            break;        case "StdHW":            font.stdHW = arrayToNumbers(value);            break;        case "StdVW":            font.stdVW = arrayToNumbers(value);            break;        case "StemSnapH":            font.stemSnapH = arrayToNumbers(value);            break;        case "StemSnapV":            font.stemSnapV = arrayToNumbers(value);            break;        case "ForceBold":            font.forceBold = value.get(0).booleanValue();            break;        case "LanguageGroup":            font.languageGroup = value.get(0).intValue();            break;        default:            break;    }}
private void pdfbox_f2134_0(int lenIV) throws IOException
{        int length = read(Token.INTEGER).intValue();    for (int i = 0; i < length; i++) {        font.subrs.add(null);    }    read(Token.NAME, "array");    for (int i = 0; i < length; i++) {                if (lexer.peekToken() == null) {            break;        }        if (!(lexer.peekToken().getKind() == Token.NAME && lexer.peekToken().getText().equals("dup"))) {            break;        }        read(Token.NAME, "dup");        Token index = read(Token.INTEGER);        read(Token.INTEGER);                Token charstring = read(Token.CHARSTRING);        font.subrs.set(index.intValue(), decrypt(charstring.getData(), CHARSTRING_KEY, lenIV));        readPut();    }    readDef();}
private void pdfbox_f2135_0() throws IOException
{    if (lexer.peekToken().getKind() == Token.START_ARRAY) {        readValue();        readDef();    } else {        int length = read(Token.INTEGER).intValue();        read(Token.NAME, "array");        for (int i = 0; i < length; i++) {            read(Token.NAME, "dup");                        read(Token.INTEGER);                        readValue();            readPut();        }        readDef();    }}
private void pdfbox_f2136_0(int lenIV) throws IOException
{    int length = read(Token.INTEGER).intValue();    read(Token.NAME, "dict");            read(Token.NAME, "dup");    read(Token.NAME, "begin");    for (int i = 0; i < length; i++) {                if (lexer.peekToken() == null) {            break;        }        if (lexer.peekToken().getKind() == Token.NAME && lexer.peekToken().getText().equals("end")) {            break;        }                String name = read(Token.LITERAL).getText();                read(Token.INTEGER);        Token charstring = read(Token.CHARSTRING);        font.charstrings.put(name, decrypt(charstring.getData(), CHARSTRING_KEY, lenIV));        readDef();    }        read(Token.NAME, "end");}
private void pdfbox_f2137_0() throws IOException
{    readMaybe(Token.NAME, "readonly");        readMaybe(Token.NAME, "noaccess");    Token token = read(Token.NAME);    switch(token.getText()) {        case "ND":        case "|-":            return;        case "noaccess":            token = read(Token.NAME);            break;        default:            break;    }    if (token.getText().equals("def")) {        return;    }    throw new IOException("Found " + token + " but expected ND");}
private void pdfbox_f2138_0() throws IOException
{    readMaybe(Token.NAME, "readonly");    Token token = read(Token.NAME);    switch(token.getText()) {        case "NP":        case "|":            return;        case "noaccess":            token = read(Token.NAME);            break;        default:            break;    }    if (token.getText().equals("put")) {        return;    }    throw new IOException("Found " + token + " but expected NP");}
private Token pdfbox_f2139_0(Token.Kind kind) throws IOException
{    Token token = lexer.nextToken();    if (token == null || token.getKind() != kind) {        throw new IOException("Found " + token + " but expected " + kind);    }    return token;}
private void pdfbox_f2140_0(Token.Kind kind, String name) throws IOException
{    Token token = read(kind);    if (!token.getText().equals(name)) {        throw new IOException("Found " + token + " but expected " + name);    }}
private Token pdfbox_f2141_0(Token.Kind kind, String name) throws IOException
{    Token token = lexer.peekToken();    if (token != null && token.getKind() == kind && token.getText().equals(name)) {        return lexer.nextToken();    }    return null;}
private byte[] pdfbox_f2142_0(byte[] cipherBytes, int r, int n)
{        if (n == -1) {        return cipherBytes;    }        if (cipherBytes.length == 0 || n > cipherBytes.length) {        return new byte[] {};    }        int c1 = 52845;    int c2 = 22719;    byte[] plainBytes = new byte[cipherBytes.length - n];    for (int i = 0; i < cipherBytes.length; i++) {        int cipher = cipherBytes[i] & 0xFF;        int plain = cipher ^ r >> 8;        if (i >= n) {            plainBytes[i - n] = (byte) plain;        }        r = (cipher + r) * c1 + c2 & 0xffff;    }    return plainBytes;}
private boolean pdfbox_f2143_0(byte[] bytes)
{    if (bytes.length < 4) {        return true;    }        for (int i = 0; i < 4; ++i) {        byte by = bytes[i];        if (by != 0x0a && by != 0x0d && by != 0x20 && by != '\t' && Character.digit((char) by, 16) == -1) {            return true;        }    }    return false;}
private byte[] pdfbox_f2144_0(byte[] bytes)
{        int len = 0;    for (byte by : bytes) {        if (Character.digit((char) by, 16) != -1) {            ++len;        }    }    byte[] res = new byte[len / 2];    int r = 0;    int prev = -1;    for (byte by : bytes) {        int digit = Character.digit((char) by, 16);        if (digit != -1) {            if (prev == -1) {                prev = digit;            } else {                res[r++] = (byte) (prev * 16 + digit);                prev = -1;            }        }    }    return res;}
private FontDirFinder pdfbox_f2145_0()
{    final String osName = System.getProperty("os.name");    if (osName.startsWith("Windows")) {        return new WindowsFontDirFinder();    } else if (osName.startsWith("Mac")) {        return new MacFontDirFinder();    } else if (osName.startsWith("OS/400")) {        return new OS400FontDirFinder();    } else {        return new UnixFontDirFinder();    }}
public List<URI> pdfbox_f2146_0()
{    if (fontDirFinder == null) {        fontDirFinder = determineDirFinder();    }    List<File> fontDirs = fontDirFinder.find();    List<URI> results = new ArrayList<>();    fontDirs.forEach(dir -> walk(dir, results));    return results;}
public List<URI> pdfbox_f2147_0(String dir)
{    List<URI> results = new ArrayList<>();    File directory = new File(dir);    if (directory.isDirectory()) {        walk(directory, results);    }    return results;}
private void pdfbox_f2148_1(File directory, List<URI> results)
{        if (!directory.isDirectory()) {        return;    }    File[] filelist = directory.listFiles();    if (filelist == null) {        return;    }    for (File file : filelist) {        if (file.isDirectory()) {                        if (file.getName().startsWith(".")) {                continue;            }            walk(file, results);        } else {            if (LOG.isDebugEnabled()) {                            }            if (checkFontfile(file)) {                if (LOG.isDebugEnabled()) {                                    }                results.add(file.toURI());            }        }    }}
private boolean pdfbox_f2149_0(File file)
{    String name = file.getName().toLowerCase(Locale.US);    return (name.endsWith(".ttf") || name.endsWith(".otf") || name.endsWith(".pfb") || name.endsWith(".ttc")) &&     !name.startsWith("fonts.");}
protected String[] pdfbox_f2150_0()
{    return new String[] {     System.getProperty("user.home") + "/Library/Fonts/",     "/Library/Fonts/",     "/System/Library/Fonts/",     "/Network/Library/Fonts/" };}
public List<File> pdfbox_f2151_1()
{    List<File> fontDirList = new java.util.ArrayList<>();    String[] searchableDirectories = getSearchableDirectories();    if (searchableDirectories != null) {        for (String searchableDirectorie : searchableDirectories) {            File fontDir = new File(searchableDirectorie);            try {                if (fontDir.exists() && fontDir.canRead()) {                    fontDirList.add(fontDir);                }            } catch (SecurityException e) {                                        }        }    }    return fontDirList;}
protected String[] pdfbox_f2152_0()
{    return new String[] {     System.getProperty("user.home") + "/.fonts", "/QIBM/ProdData/OS400/Fonts" };}
protected String[] pdfbox_f2153_0()
{    return new String[] {     System.getProperty("user.home") + "/.fonts",     "/usr/local/fonts",     "/usr/local/share/fonts",     "/usr/share/fonts",     "/usr/X11R6/lib/X11/fonts" };}
private String pdfbox_f2154_0(String osName) throws IOException
{    Process process;    Runtime runtime = Runtime.getRuntime();    if (osName.startsWith("Windows 9")) {        process = runtime.exec("command.com /c echo %windir%");    } else {        process = runtime.exec("cmd.exe /c echo %windir%");    }    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charsets.ISO_8859_1))) {        return bufferedReader.readLine();    }}
public List<File> pdfbox_f2155_1()
{    List<File> fontDirList = new java.util.ArrayList<>();    String windir = null;    try {        windir = System.getProperty("env.windir");    } catch (SecurityException e) {                }    String osName = System.getProperty("os.name");    if (windir == null) {        try {            windir = getWinDir(osName);        } catch (IOException | SecurityException e) {                            }    }    File osFontsDir;    File psFontsDir;    if (windir != null && windir.length() > 2) {                if (windir.endsWith("/")) {            windir = windir.substring(0, windir.length() - 1);        }        osFontsDir = new File(windir + File.separator + "FONTS");        if (osFontsDir.exists() && osFontsDir.canRead()) {            fontDirList.add(osFontsDir);        }        psFontsDir = new File(windir.substring(0, 2) + File.separator + "PSFONTS");        if (psFontsDir.exists() && psFontsDir.canRead()) {            fontDirList.add(psFontsDir);        }    } else {        String windowsDirName = osName.endsWith("NT") ? "WINNT" : "WINDOWS";                for (char driveLetter = 'C'; driveLetter <= 'E'; driveLetter++) {            osFontsDir = new File(driveLetter + ":" + File.separator + windowsDirName + File.separator + "FONTS");            try {                if (osFontsDir.exists() && osFontsDir.canRead()) {                    fontDirList.add(osFontsDir);                    break;                }            } catch (SecurityException e) {                                        }        }                for (char driveLetter = 'C'; driveLetter <= 'E'; driveLetter++) {            psFontsDir = new File(driveLetter + ":" + File.separator + "PSFONTS");            try {                if (psFontsDir.exists() && psFontsDir.canRead()) {                    fontDirList.add(psFontsDir);                    break;                }            } catch (SecurityException e) {                                        }        }    }    return fontDirList;}
public float pdfbox_f2156_0()
{    return lowerLeftX;}
public void pdfbox_f2157_0(float lowerLeftXValue)
{    this.lowerLeftX = lowerLeftXValue;}
public float pdfbox_f2158_0()
{    return lowerLeftY;}
public void pdfbox_f2159_0(float lowerLeftYValue)
{    this.lowerLeftY = lowerLeftYValue;}
public float pdfbox_f2160_0()
{    return upperRightX;}
public void pdfbox_f2161_0(float upperRightXValue)
{    this.upperRightX = upperRightXValue;}
public float pdfbox_f2162_0()
{    return upperRightY;}
public void pdfbox_f2163_0(float upperRightYValue)
{    this.upperRightY = upperRightYValue;}
public float pdfbox_f2164_0()
{    return getUpperRightX() - getLowerLeftX();}
public float pdfbox_f2165_0()
{    return getUpperRightY() - getLowerLeftY();}
public boolean pdfbox_f2166_0(float x, float y)
{    return x >= lowerLeftX && x <= upperRightX && y >= lowerLeftY && y <= upperRightY;}
public String pdfbox_f2167_0()
{    return "[" + getLowerLeftX() + "," + getLowerLeftY() + "," + getUpperRightX() + "," + getUpperRightY() + "]";}
public void pdfbox_f2168_0() throws IOException
{    try {        new AFMParser(new ByteArrayInputStream("huhu".getBytes(Charsets.US_ASCII))).parse();    } catch (IOException ex) {        Assert.assertEquals("Error: The AFM file should start with StartFontMetrics and not 'huhu'", ex.getMessage());    }}
public void pdfbox_f2169_0() throws IOException
{    List<CFFFont> fonts = readFont("target/pdfs/SourceSansProBold.otf");    CFFType1Font font = (CFFType1Font) fonts.get(0);    @SuppressWarnings("unchecked")    List<Number> blues = (List<Number>) font.getPrivateDict().get("BlueValues");        assertNumberList("Blue values are different than expected: " + blues.toString(), new int[] { -12, 0, 496, 508, 578, 590, 635, 647, 652, 664, 701, 713 }, blues);    @SuppressWarnings("unchecked")    List<Number> otherBlues = (List<Number>) font.getPrivateDict().get("OtherBlues");    assertNumberList("Other blues are different than expected: " + otherBlues.toString(), new int[] { -196, -184 }, otherBlues);    @SuppressWarnings("unchecked")    List<Number> familyBlues = (List<Number>) font.getPrivateDict().get("FamilyBlues");    assertNumberList("Other blues are different than expected: " + familyBlues.toString(), new int[] { -12, 0, 486, 498, 574, 586, 638, 650, 656, 668, 712, 724 }, familyBlues);    @SuppressWarnings("unchecked")    List<Number> familyOtherBlues = (List<Number>) font.getPrivateDict().get("FamilyOtherBlues");    assertNumberList("Other blues are different than expected: " + familyOtherBlues.toString(), new int[] { -217, -205 }, familyOtherBlues);    @SuppressWarnings("unchecked")    List<Number> stemSnapH = (List<Number>) font.getPrivateDict().get("StemSnapH");    assertNumberList("StemSnapH values are different than expected: " + stemSnapH.toString(), new int[] { 115 }, stemSnapH);    @SuppressWarnings("unchecked")    List<Number> stemSnapV = (List<Number>) font.getPrivateDict().get("StemSnapV");    assertNumberList("StemSnapV values are different than expected: " + stemSnapV.toString(), new int[] { 146, 150 }, stemSnapV);}
private List<CFFFont> pdfbox_f2170_0(String filename) throws IOException
{    ByteArrayOutputStream content = new ByteArrayOutputStream();    Files.copy(Paths.get(filename), content);    CFFParser parser = new CFFParser();    return parser.parse(content.toByteArray());}
private void pdfbox_f2171_0(String message, int[] expected, List<Number> found)
{    assertEquals(message, expected.length, found.size());    for (int i = 0; i < expected.length; i++) {        assertEquals(message, expected[i], found.get(i).intValue());    }}
public void pdfbox_f2172_0()
{    long seed = DEFAULTSEED;    tryHexEncoding(seed);    for (int i = 0; i < LOOPS; ++i) {        tryHexEncoding(System.currentTimeMillis());    }}
private void pdfbox_f2173_0(long seed) throws ArrayComparisonFailure
{    byte[] bytes = createRandomByteArray(128, seed);    String encodedBytes = Type1FontUtil.hexEncode(bytes);    byte[] decodedBytes = Type1FontUtil.hexDecode(encodedBytes);    assertArrayEquals("Seed: " + seed, bytes, decodedBytes);}
public void pdfbox_f2174_0()
{    long seed = DEFAULTSEED;    tryEexecEncryption(seed);    for (int i = 0; i < LOOPS; ++i) {        tryEexecEncryption(System.currentTimeMillis());    }}
private void pdfbox_f2175_0(long seed) throws ArrayComparisonFailure
{    byte[] bytes = createRandomByteArray(128, seed);    byte[] encryptedBytes = Type1FontUtil.eexecEncrypt(bytes);    byte[] decryptedBytes = Type1FontUtil.eexecDecrypt(encryptedBytes);    assertArrayEquals("Seed: " + seed, bytes, decryptedBytes);}
public void pdfbox_f2176_0()
{    long seed = DEFAULTSEED;    tryCharstringEncryption(seed);    for (int i = 0; i < LOOPS; ++i) {        tryCharstringEncryption(System.currentTimeMillis());    }}
private void pdfbox_f2177_0(long seed) throws ArrayComparisonFailure
{    byte[] bytes = createRandomByteArray(128, seed);    byte[] encryptedBytes = Type1FontUtil.charstringEncrypt(bytes, 4);    byte[] decryptedBytes = Type1FontUtil.charstringDecrypt(encryptedBytes, 4);    assertArrayEquals("Seed: " + seed, bytes, decryptedBytes);}
private static byte[] pdfbox_f2178_0(int arrayLength, long seed)
{    byte[] bytes = new byte[arrayLength];    Random ramdom = new Random(seed);    for (int i = 0; i < arrayLength; i++) {        bytes[i] = (byte) ramdom.nextInt(256);    }    return bytes;}
public void pdfbox_f2179_0() throws IOException
{    byte[] bs = new byte[1];    bs[0] = (byte) 200;    CMap cMap = new CMap();    cMap.addCharMapping(bs, "a");    assertTrue("a".equals(cMap.toUnicode(200)));}
public void pdfbox_f2180_0() throws IOException
{    try (TrueTypeFont ttf = new TTFParser().parse("target/pdfs/NotoEmoji-Regular.ttf")) {        CmapLookup cmap = ttf.getUnicodeCmapLookup(false);        assertEquals(886, cmap.getGlyphId(0x1F681));    }}
public void pdfbox_f2181_0() throws IOException
{    final String resourceDir = "src/test/resources/cmap";    File inDir = new File(resourceDir);    CMapParser parser = new CMapParser();    CMap cMap = parser.parse(new File(inDir, "CMapTest"));        byte[] bytes1 = { 0, 1 };    assertEquals("bytes 00 01 from bfrange <0001> <0005> <0041>", "A", cMap.toUnicode(toInt(bytes1, bytes1.length)));    byte[] bytes2 = { 1, 00 };    String str2 = "0";    assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", str2, cMap.toUnicode(toInt(bytes2, bytes2.length)));    byte[] bytes3 = { 1, 32 };    assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "P", cMap.toUnicode(toInt(bytes3, bytes3.length)));    byte[] bytes4 = { 1, 33 };    assertEquals("bytes 01 00 from bfrange <0100> <0109> <0030>", "R", cMap.toUnicode(toInt(bytes4, bytes4.length)));    byte[] bytes5 = { 0, 10 };    String str5 = "*";    assertEquals("bytes 00 0A from bfchar <000A> <002A>", str5, cMap.toUnicode(toInt(bytes5, bytes5.length)));    byte[] bytes6 = { 1, 10 };    String str6 = "+";    assertEquals("bytes 01 0A from bfchar <010A> <002B>", str6, cMap.toUnicode(toInt(bytes6, bytes6.length)));        int cid1 = 65;    assertEquals("CID 65 from cidrange <0000> <00ff> 0 ", 65, cMap.toCID(cid1));    int cid2 = 280;    int strCID2 = 0x0118;    assertEquals("CID 280 from cidrange <0100> <01ff> 256", strCID2, cMap.toCID(cid2));    int cid3 = 520;    int strCID3 = 0x0208;    assertEquals("CID 520 from cidchar <0208> 520", strCID3, cMap.toCID(cid3));    int cid4 = 300;    int strCID4 = 0x12C;    assertEquals("CID 300 from cidrange <0300> <0300> 300", strCID4, cMap.toCID(cid4));}
public void pdfbox_f2182_0() throws IOException
{    final String resourceDir = "src/main/resources/org/apache/fontbox/cmap";    File inDir = new File(resourceDir);    CMapParser parser = new CMapParser();    CMap cMap = parser.parse(new File(inDir, "Identity-H"));    assertEquals("Indentity-H CID 65", 65, cMap.toCID(65));    assertEquals("Indentity-H CID 12345", 12345, cMap.toCID(12345));    assertEquals("Indentity-H CID 0xFFFF", 0xFFFF, cMap.toCID(0xFFFF));}
public void pdfbox_f2183_0() throws IOException
{    final String resourceDir = "src/main/resources/org/apache/fontbox/cmap";    File inDir = new File(resourceDir);    CMapParser parser = new CMapParser();    CMap cMap = parser.parse(new File(inDir, "UniJIS-UCS2-H"));    assertEquals("UniJIS-UCS2-H CID 65 -> 34", 34, cMap.toCID(65));}
public void pdfbox_f2184_0() throws IOException
{    CMap cMap = new CMapParser().parse(new File("src/test/resources/cmap", "CMapNoWhitespace"));    assertNotNull("Failed to parse nasty CMap file", cMap);}
public void pdfbox_f2185_0() throws IOException
{    CMap cMap = new CMapParser().parse(new File("src/test/resources/cmap", "CMapMalformedbfrange1"));    assertNotNull("Failed to parse malformed CMap file", cMap);    byte[] bytes1 = { 0, 1 };    assertEquals("bytes 00 01 from bfrange <0001> <0009> <0041>", "A", cMap.toUnicode(toInt(bytes1, bytes1.length)));    byte[] bytes2 = { 1, 00 };    assertNull(cMap.toUnicode(toInt(bytes2, bytes2.length)));}
public void pdfbox_f2186_0() throws IOException
{    CMap cMap = new CMapParser().parse(new File("src/test/resources/cmap", "CMapMalformedbfrange2"));    assertNotNull("Failed to parse malformed CMap file", cMap);    assertEquals("bytes 00 01 from bfrange <0001> <0009> <0030>", "0", cMap.toUnicode(0x001));    assertEquals("bytes 02 32 from bfrange <0232> <0432> <0041>", "A", cMap.toUnicode(0x232));        assertNotNull(cMap.toUnicode(0x2F0));    assertNull(cMap.toUnicode(0x2F1));}
public void pdfbox_f2187_0() throws IOException
{    final File file = File.createTempFile("apache-pdfbox", ".dat");    try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {        final String content = "1234567890";        outputStream.write(content.getBytes("UTF-8"));        outputStream.flush();    }    final byte[] readBuffer = new byte[2];    final BufferedRandomAccessFile buffer = new BufferedRandomAccessFile(file, "r", 4);    int amountRead;    int totalAmountRead = 0;    while ((amountRead = buffer.read(readBuffer, 0, 2)) != -1) {        totalAmountRead += amountRead;    }    Assert.assertEquals(10, totalAmountRead);}
public void pdfbox_f2188_0() throws IOException
{        MemoryTTFDataStream memoryTTFDataStream = new MemoryTTFDataStream(GlyphSubstitutionTableTest.class.getResourceAsStream("/ttf/Lohit-Bengali.ttf"));    memoryTTFDataStream.seek(DATA_POSITION_FOR_GSUB_TABLE);    GlyphSubstitutionTable testClass = new GlyphSubstitutionTable(null);        testClass.read(null, memoryTTFDataStream);        GsubData gsubData = testClass.getGsubData();    assertNotNull(gsubData);    assertNotEquals(GsubData.NO_DATA_FOUND, gsubData);    assertEquals(Language.BENGALI, gsubData.getLanguage());    assertEquals("bng2", gsubData.getActiveScriptName());    assertEquals(new HashSet<>(EXPECTED_FEATURE_NAMES), gsubData.getSupportedFeatures());    String templatePathToFile = "/gsub/lohit_bengali/bng2/%s.txt";    for (String featureName : EXPECTED_FEATURE_NAMES) {        System.out.println("******* Testing feature: " + featureName);        Map<List<Integer>, Integer> expectedGsubTableRawData = getExpectedGsubTableRawData(String.format(templatePathToFile, featureName));        ScriptFeature scriptFeature = new MapBackedScriptFeature(featureName, expectedGsubTableRawData);        assertEquals(scriptFeature, gsubData.getFeature(featureName));    }}
private Map<List<Integer>, Integer> pdfbox_f2189_0(String pathToResource) throws IOException
{    Map<List<Integer>, Integer> gsubData = new HashMap<>();    try (BufferedReader br = new BufferedReader(new InputStreamReader(TestTTFParser.class.getResourceAsStream(pathToResource)))) {        while (true) {            String line = br.readLine();            if (line == null) {                break;            }            if (line.trim().length() == 0) {                continue;            }            if (line.startsWith("#")) {                continue;            }            String[] lineSplittedByKeyValue = line.split("=");            if (lineSplittedByKeyValue.length != 2) {                throw new IllegalArgumentException("invalid format");            }            List<Integer> oldGlyphIds = new ArrayList<>();            for (String value : lineSplittedByKeyValue[0].split(",")) {                oldGlyphIds.add(Integer.valueOf(value));            }            Integer newGlyphId = Integer.valueOf(lineSplittedByKeyValue[1]);            gsubData.put(oldGlyphIds, newGlyphId);        }    }    return gsubData;}
public void pdfbox_f2190_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "HrkJj", "68RetP", "Yx!23uyt" })));    String text = "12345HrkJjxabbcc68RetPxxxcfb1245678Yx!23uyt889000";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    assertEquals(Arrays.asList("12345", "HrkJj", "xabbcc", "68RetP", "xxxcfb1245678", "Yx!23uyt", "889000"), tokens);}
public void pdfbox_f2191_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "84_93", "104_82", "104_87" })));    String text = "84_112_93_104_82_61_96_102_93_104_87_110";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    assertEquals(Arrays.asList("84_112_93_", "104_82", "_61_96_102_93_", "104_87", "_110"), tokens);}
public void pdfbox_f2192_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "67_112_96", "74_112_76" })));    String text = "67_112_96_103_93_108_93";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    assertEquals(Arrays.asList("67_112_96", "_103_93_108_93"), tokens);}
public void pdfbox_f2193_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "67_112_96", "74_112_76" })));    String text = "94_67_112_96_112_91_103";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    assertEquals(Arrays.asList("94_", "67_112_96", "_112_91_103"), tokens);}
public void pdfbox_f2194_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "67_112", "76_112" })));    String text = "94_167_112_91_103";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    assertEquals(Arrays.asList("94_1", "67_112", "_91_103"), tokens);}
public void pdfbox_f2195_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "HrkJj", "68RetP", "Yx!23uyt" })));    String text = "Yx!23uyte12345HrkJjxabbcc68RetPxxxcfb1245678Yx!23uyt889000";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    List<String> tokenList = tokens;    assertEquals(0, tokenList.indexOf("Yx!23uyt"));}
public void pdfbox_f2196_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "HrkJj", "68RetP", "Yx!23uyt" })));    String text = "Yx!23uyte12345HrkJjxabbcc68RetPxxxcfb1245678Yx!23uyt889000HrkJj";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    assertEquals(0, tokens.indexOf("Yx!23uyt"));    assertEquals(2, tokens.indexOf("HrkJj"));    assertEquals(tokens.size() - 1, tokens.lastIndexOf("HrkJj"));}
public void pdfbox_f2197_0()
{        CompoundCharacterTokenizer tokenizer = new CompoundCharacterTokenizer(new HashSet<>(Arrays.asList(new String[] { "\u0995\u09cd\u09b7", "\u09aa\u09c1\u09a4\u09c1" })));    String text = "\u0986\u09ae\u09bf \u0995\u09cb\u09a8 \u09aa\u09a5\u09c7  \u0995\u09cd\u09b7\u09c0\u09b0\u09c7\u09b0 \u09b7\u09a8\u09cd\u09a1  \u09aa\u09c1\u09a4\u09c1\u09b2 \u09b0\u09c1\u09aa\u09cb  \u0997\u0999\u09cd\u0997\u09be \u098b\u09b7\u09bf";        List<String> tokens = tokenizer.tokenize(text);        StringBuilder sb = new StringBuilder();    tokens.forEach(token -> sb.append(token));    assertEquals(text, sb.toString());    List<String> tokenList = tokens;    assertTrue(tokenList.contains("\u0995\u09cd\u09b7"));    assertTrue(tokenList.contains("\u09aa\u09c1\u09a4\u09c1"));}
public void pdfbox_f2198_0()
{        Set<List<Integer>> matchers = new HashSet<>(Arrays.asList(Arrays.asList(84, 93), Arrays.asList(102, 82), Arrays.asList(104, 87)));    GlyphArraySplitter testClass = new GlyphArraySplitterRegexImpl(matchers);    List<Integer> glyphIds = Arrays.asList(84, 112, 93, 104, 82, 61, 96, 102, 93, 104, 87, 110);        List<List<Integer>> tokens = testClass.split(glyphIds);        assertEquals(Arrays.asList(Arrays.asList(84, 112, 93, 104, 82, 61, 96, 102, 93), Arrays.asList(104, 87), Arrays.asList(110)), tokens);}
public void pdfbox_f2199_0()
{        Set<List<Integer>> matchers = new HashSet<>(Arrays.asList(Arrays.asList(67, 112, 96), Arrays.asList(74, 112, 76)));    GlyphArraySplitter testClass = new GlyphArraySplitterRegexImpl(matchers);    List<Integer> glyphIds = Arrays.asList(67, 112, 96, 103, 93, 108, 93);        List<List<Integer>> tokens = testClass.split(glyphIds);        assertEquals(Arrays.asList(Arrays.asList(67, 112, 96), Arrays.asList(103, 93, 108, 93)), tokens);}
public void pdfbox_f2200_0()
{        Set<List<Integer>> matchers = new HashSet<>(Arrays.asList(Arrays.asList(67, 112, 96), Arrays.asList(74, 112, 76)));    GlyphArraySplitter testClass = new GlyphArraySplitterRegexImpl(matchers);    List<Integer> glyphIds = Arrays.asList(94, 67, 112, 96, 112, 91, 103);        List<List<Integer>> tokens = testClass.split(glyphIds);        assertEquals(Arrays.asList(Arrays.asList(94), Arrays.asList(67, 112, 96), Arrays.asList(112, 91, 103)), tokens);}
public void pdfbox_f2201_0()
{        Set<List<Integer>> matchers = new HashSet<>(Arrays.asList(Arrays.asList(67, 112), Arrays.asList(76, 112)));    GlyphArraySplitter testClass = new GlyphArraySplitterRegexImpl(matchers);    List<Integer> glyphIds = Arrays.asList(94, 167, 112, 91, 103);        List<List<Integer>> tokens = testClass.split(glyphIds);        assertEquals(Arrays.asList(Arrays.asList(94, 167, 112, 91, 103)), tokens);}
public void pdfbox_f2202_0(GsubData gsubData, CmapLookup cmap)
{    System.err.println("Format:\n<Serial no.>.) <Space separated characters to be replaced> : RawUnicode: [<Space separated unicode representation of each character to be replaced in hexadecimal>] : <The compound character> : <The GlyphId with which these characters are replaced>");    Map<Integer, List<Integer>> rawGSubTableData = new HashMap<>();    for (String featureName : gsubData.getSupportedFeatures()) {        ScriptFeature scriptFeature = gsubData.getFeature(featureName);        for (List<Integer> glyphsToBeReplaced : scriptFeature.getAllGlyphIdsForSubstitution()) {            rawGSubTableData.put(scriptFeature.getReplacementForGlyphs(glyphsToBeReplaced), glyphsToBeReplaced);        }    }    for (String featureName : gsubData.getSupportedFeatures()) {        System.out.println("******************      " + featureName + "      ******************");        ScriptFeature scriptFeature = gsubData.getFeature(featureName);        int index = 0;        for (List<Integer> glyphsToBeReplaced : scriptFeature.getAllGlyphIdsForSubstitution()) {            String unicodeText = getUnicodeString(rawGSubTableData, cmap, glyphsToBeReplaced);            System.out.println(++index + ".) " + getExplainedUnicodeText(unicodeText) + " : " + scriptFeature.getReplacementForGlyphs(glyphsToBeReplaced));        }    }}
private String pdfbox_f2203_0(Map<Integer, List<Integer>> rawGSubTableData, CmapLookup cmap, Integer glyphId)
{    List<Integer> keyChars = cmap.getCharCodes(glyphId);        if (keyChars == null) {        List<Integer> constituentGlyphs = rawGSubTableData.get(glyphId);        if (constituentGlyphs == null || constituentGlyphs.isEmpty()) {            String message = "lookup for the glyphId: " + glyphId + " failed, as no corresponding Unicode char found mapped to it";            throw new IllegalStateException(message);        } else {            return getUnicodeString(rawGSubTableData, cmap, constituentGlyphs);        }    } else {        StringBuilder sb = new StringBuilder();        for (int unicodeChar : keyChars) {            sb.append((char) unicodeChar);        }        return sb.toString();    }}
private String pdfbox_f2204_0(Map<Integer, List<Integer>> rawGSubTableData, CmapLookup cmap, List<Integer> glyphIDs)
{    StringBuilder sb = new StringBuilder();    for (Integer glyphId : glyphIDs) {        sb.append(getUnicodeChar(rawGSubTableData, cmap, glyphId));    }    return sb.toString();}
private String pdfbox_f2205_0(String unicodeText)
{    StringBuilder sb = new StringBuilder();    for (char unicode : unicodeText.toCharArray()) {        sb.append(unicode).append(" ");    }    sb.append(":");    sb.append(" RawUnicode: [");    for (char unicode : unicodeText.toCharArray()) {        sb.append("\\u0").append(Integer.toHexString(unicode).toUpperCase()).append(" ");    }    sb.append("] : ");    sb.append(unicodeText);    return sb.toString();}
public void pdfbox_f2206_0() throws IOException
{    MemoryTTFDataStream memoryTTFDataStream = new MemoryTTFDataStream(GSUBTableDebugger.class.getResourceAsStream(LOHIT_BENGALI_FONT_FILE));    memoryTTFDataStream.seek(GlyphSubstitutionTableTest.DATA_POSITION_FOR_GSUB_TABLE);    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable(null);    glyphSubstitutionTable.read(null, memoryTTFDataStream);    TrueTypeFont trueTypeFont = new TTFParser().parse(GSUBTableDebugger.class.getResourceAsStream(LOHIT_BENGALI_FONT_FILE));    GsubData gsubData = glyphSubstitutionTable.getGsubData();    new GSUBTablePrintUtil().printCharacterToGlyph(gsubData, trueTypeFont.getUnicodeCmapLookup());}
public void pdfbox_f2207_0() throws IOException
{    RAFDataStream raf = new RAFDataStream("src/test/resources/ttf/LiberationSans-Regular.ttf", "r");    raf.close();    raf.close();}
public void pdfbox_f2208_0() throws IOException
{    byte[] byteArray = new byte[10];    ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);    MemoryTTFDataStream dataStream = new MemoryTTFDataStream(inputStream);    int value = dataStream.read();    try {        while (value > -1) {            value = dataStream.read();        }    } catch (ArrayIndexOutOfBoundsException exception) {        fail("EOF not detected!");    } finally {        dataStream.close();    }}
public void pdfbox_f2209_0() throws IOException
{    final File testFile = new File("src/test/resources/ttf/LiberationSans-Regular.ttf");    TimeZone utc = TimeZone.getTimeZone("UTC");            TimeZone.setDefault(TimeZone.getTimeZone("America/Los Angeles"));    TTFParser parser = new TTFParser();    TrueTypeFont ttf = parser.parse(testFile);    Calendar created = ttf.getHeader().getCreated();    assertEquals(created.getTimeZone(), utc);    Calendar target = Calendar.getInstance(utc);    target.set(2012, 9, 4, 11, 2, 31);    target.set(Calendar.MILLISECOND, 0);    assertEquals(target, created);}
public void pdfbox_f2210_0() throws IOException
{    TrueTypeFont x = new TTFParser().parse("src/test/resources/ttf/LiberationSans-Regular.ttf");    TTFSubsetter ttfSubsetter = new TTFSubsetter(x);    ByteArrayOutputStream baos = new ByteArrayOutputStream();    ttfSubsetter.writeToStream(baos);    try (TrueTypeFont subset = new TTFParser(true).parse(new ByteArrayInputStream(baos.toByteArray()))) {        assertEquals(1, subset.getNumberOfGlyphs());        assertEquals(0, subset.nameToGID(".notdef"));        assertNotNull(subset.getGlyph().getGlyph(0));    }}
public void pdfbox_f2211_0() throws IOException
{    TrueTypeFont x = new TTFParser().parse("src/test/resources/ttf/LiberationSans-Regular.ttf");        List<String> tables = new ArrayList<>();    tables.add("head");    tables.add("hhea");    tables.add("loca");    tables.add("maxp");    tables.add("cvt ");    tables.add("prep");    tables.add("glyf");    tables.add("hmtx");    tables.add("fpgm");    tables.add("gasp");    TTFSubsetter ttfSubsetter = new TTFSubsetter(x, tables);    ByteArrayOutputStream baos = new ByteArrayOutputStream();    ttfSubsetter.writeToStream(baos);    try (TrueTypeFont subset = new TTFParser(true).parse(new ByteArrayInputStream(baos.toByteArray()))) {        assertEquals(1, subset.getNumberOfGlyphs());        assertEquals(0, subset.nameToGID(".notdef"));        assertNotNull(subset.getGlyph().getGlyph(0));    }}
public void pdfbox_f2212_0() throws IOException
{    TrueTypeFont full = new TTFParser().parse("src/test/resources/ttf/LiberationSans-Regular.ttf");    TTFSubsetter ttfSubsetter = new TTFSubsetter(full);    ttfSubsetter.add('a');    ByteArrayOutputStream baos = new ByteArrayOutputStream();    ttfSubsetter.writeToStream(baos);    try (TrueTypeFont subset = new TTFParser(true).parse(new ByteArrayInputStream(baos.toByteArray()))) {        assertEquals(2, subset.getNumberOfGlyphs());        assertEquals(0, subset.nameToGID(".notdef"));        assertEquals(1, subset.nameToGID("a"));        assertNotNull(subset.getGlyph().getGlyph(0));        assertNotNull(subset.getGlyph().getGlyph(1));        assertNull(subset.getGlyph().getGlyph(2));        assertEquals(full.getAdvanceWidth(full.nameToGID("a")), subset.getAdvanceWidth(subset.nameToGID("a")));        assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID("a")), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID("a")));    }}
public void pdfbox_f2213_0() throws IOException
{    System.out.println("Searching for SimHei font...");    FontFileFinder fontFileFinder = new FontFileFinder();    List<URI> files = fontFileFinder.find();    File simhei = null;    for (URI uri : files) {        if (uri.getPath() != null && uri.getPath().toLowerCase(Locale.US).endsWith("simhei.ttf")) {            simhei = new File(uri);        }    }    if (simhei == null) {        System.err.println("SimHei font not available on this machine, test skipped");        return;    }    System.out.println("SimHei font found!");    TrueTypeFont full = new TTFParser().parse(simhei);            List<String> tables = new ArrayList<>();    tables.add("head");    tables.add("hhea");    tables.add("loca");    tables.add("maxp");    tables.add("cvt ");    tables.add("prep");    tables.add("glyf");    tables.add("hmtx");    tables.add("fpgm");    tables.add("gasp");    TTFSubsetter ttfSubsetter = new TTFSubsetter(full, tables);    String chinese = "中国你好!";    for (int offset = 0; offset < chinese.length(); ) {        int codePoint = chinese.codePointAt(offset);        ttfSubsetter.add(codePoint);        offset += Character.charCount(codePoint);    }    ByteArrayOutputStream baos = new ByteArrayOutputStream();    ttfSubsetter.writeToStream(baos);    try (TrueTypeFont subset = new TTFParser(true).parse(new ByteArrayInputStream(baos.toByteArray()))) {        assertEquals(6, subset.getNumberOfGlyphs());        for (Entry<Integer, Integer> entry : ttfSubsetter.getGIDMap().entrySet()) {            Integer newGID = entry.getKey();            Integer oldGID = entry.getValue();            assertEquals(full.getAdvanceWidth(oldGID), subset.getAdvanceWidth(newGID));            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(oldGID), subset.getHorizontalMetrics().getLeftSideBearing(newGID));        }    }}
public void pdfbox_f2214_0() throws IOException
{    TrueTypeFont full = new TTFParser().parse("target/pdfs/DejaVuSansMono.ttf");    TTFSubsetter ttfSubsetter = new TTFSubsetter(full);    ttfSubsetter.add('A');    ttfSubsetter.add(' ');    ttfSubsetter.add('B');    ByteArrayOutputStream baos = new ByteArrayOutputStream();    ttfSubsetter.writeToStream(baos);    try (TrueTypeFont subset = new TTFParser().parse(new ByteArrayInputStream(baos.toByteArray()))) {        assertEquals(4, subset.getNumberOfGlyphs());        assertEquals(0, subset.nameToGID(".notdef"));        assertEquals(1, subset.nameToGID("space"));        assertEquals(2, subset.nameToGID("A"));        assertEquals(3, subset.nameToGID("B"));        String[] names = new String[] { "A", "B", "space" };        for (String name : names) {            assertEquals(full.getAdvanceWidth(full.nameToGID(name)), subset.getAdvanceWidth(subset.nameToGID(name)));            assertEquals(full.getHorizontalMetrics().getLeftSideBearing(full.nameToGID(name)), subset.getHorizontalMetrics().getLeftSideBearing(subset.nameToGID(name)));        }    }}
public void pdfbox_f2215_0() throws IOException
{    final File testFile = new File("src/test/resources/ttf/LiberationSans-Regular.ttf");    TrueTypeFont ttf = new TTFParser().parse(testFile);    TTFSubsetter ttfSubsetter = new TTFSubsetter(ttf);    ttfSubsetter.add('Ö');    ttfSubsetter.add('\u200A');    ByteArrayOutputStream baos = new ByteArrayOutputStream();    ttfSubsetter.writeToStream(baos);    try (TrueTypeFont subset = new TTFParser(true).parse(new ByteArrayInputStream(baos.toByteArray()))) {        assertEquals(5, subset.getNumberOfGlyphs());        assertEquals(0, subset.nameToGID(".notdef"));        assertEquals(1, subset.nameToGID("O"));        assertEquals(2, subset.nameToGID("Odieresis"));        assertEquals(3, subset.nameToGID("uni200A"));        assertEquals(4, subset.nameToGID("dieresis.uc"));        PostScriptTable pst = subset.getPostScript();        assertEquals(pst.getName(0), ".notdef");        assertEquals(pst.getName(1), "O");        assertEquals(pst.getName(2), "Odieresis");        assertEquals(pst.getName(3), "uni200A");        assertEquals(pst.getName(4), "dieresis.uc");        assertTrue("Hair space path should be empty", subset.getPath("uni200A").getBounds2D().isEmpty());        assertFalse("UC dieresis path should not be empty", subset.getPath("dieresis.uc").getBounds2D().isEmpty());    }}
public void pdfbox_f2216_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace colorSpace = getColorSpace();    if (!(colorSpace instanceof PDPattern)) {        if (arguments.size() < colorSpace.getNumberOfComponents()) {            throw new MissingOperandException(operator, arguments);        }        if (!checkArrayTypesClass(arguments, COSNumber.class)) {            return;        }    }    COSArray array = new COSArray();    array.addAll(arguments);    setColor(new PDColor(array, colorSpace));}
protected PDColor pdfbox_f2217_0()
{    return context.getGraphicsState().getNonStrokingColor();}
protected void pdfbox_f2218_0(PDColor color)
{    context.getGraphicsState().setNonStrokingColor(color);}
protected PDColorSpace pdfbox_f2219_0()
{    return context.getGraphicsState().getNonStrokingColorSpace();}
public String pdfbox_f2220_0()
{    return OperatorName.NON_STROKING_COLOR;}
public String pdfbox_f2221_0()
{    return OperatorName.NON_STROKING_COLOR_N;}
public void pdfbox_f2222_0(Operator operator, List<COSBase> arguments) throws IOException
{    COSName name = (COSName) arguments.get(0);    PDColorSpace cs = context.getResources().getColorSpace(name);    context.getGraphicsState().setNonStrokingColorSpace(cs);    context.getGraphicsState().setNonStrokingColor(cs.getInitialColor());}
public String pdfbox_f2223_0()
{    return OperatorName.NON_STROKING_COLORSPACE;}
public void pdfbox_f2224_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace cs = context.getResources().getColorSpace(COSName.DEVICECMYK);    context.getGraphicsState().setNonStrokingColorSpace(cs);    super.process(operator, arguments);}
public String pdfbox_f2225_0()
{    return OperatorName.NON_STROKING_CMYK;}
public void pdfbox_f2226_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace cs = context.getResources().getColorSpace(COSName.DEVICEGRAY);    context.getGraphicsState().setNonStrokingColorSpace(cs);    super.process(operator, arguments);}
public String pdfbox_f2227_0()
{    return OperatorName.NON_STROKING_GRAY;}
public void pdfbox_f2228_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace cs = context.getResources().getColorSpace(COSName.DEVICERGB);    context.getGraphicsState().setNonStrokingColorSpace(cs);    super.process(operator, arguments);}
public String pdfbox_f2229_0()
{    return OperatorName.NON_STROKING_RGB;}
protected PDColor pdfbox_f2230_0()
{    return context.getGraphicsState().getStrokingColor();}
protected void pdfbox_f2231_0(PDColor color)
{    context.getGraphicsState().setStrokingColor(color);}
protected PDColorSpace pdfbox_f2232_0()
{    return context.getGraphicsState().getStrokingColorSpace();}
public String pdfbox_f2233_0()
{    return OperatorName.STROKING_COLOR;}
public String pdfbox_f2234_0()
{    return OperatorName.STROKING_COLOR_N;}
public void pdfbox_f2235_0(Operator operator, List<COSBase> arguments) throws IOException
{    COSBase base = arguments.get(0);    if (!(base instanceof COSName)) {        return;    }    PDColorSpace cs = context.getResources().getColorSpace((COSName) base);    context.getGraphicsState().setStrokingColorSpace(cs);    context.getGraphicsState().setStrokingColor(cs.getInitialColor());}
public String pdfbox_f2236_0()
{    return OperatorName.STROKING_COLORSPACE;}
public void pdfbox_f2237_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace cs = context.getResources().getColorSpace(COSName.DEVICECMYK);    context.getGraphicsState().setStrokingColorSpace(cs);    super.process(operator, arguments);}
public String pdfbox_f2238_0()
{    return OperatorName.STROKING_COLOR_CMYK;}
public void pdfbox_f2239_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace cs = context.getResources().getColorSpace(COSName.DEVICEGRAY);    context.getGraphicsState().setStrokingColorSpace(cs);    super.process(operator, arguments);}
public String pdfbox_f2240_0()
{    return OperatorName.STROKING_COLOR_GRAY;}
public void pdfbox_f2241_0(Operator operator, List<COSBase> arguments) throws IOException
{    PDColorSpace cs = context.getResources().getColorSpace(COSName.DEVICERGB);    context.getGraphicsState().setStrokingColorSpace(cs);    super.process(operator, arguments);}
public String pdfbox_f2242_0()
{    return OperatorName.STROKING_COLOR_RGB;}
public void pdfbox_f2243_1(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSBase base0 = arguments.get(0);    if (!(base0 instanceof COSName)) {        return;    }    COSName name = (COSName) base0;    if (context.getResources().isImageXObject(name)) {                return;    }    PDXObject xobject = context.getResources().getXObject(name);    if (xobject instanceof PDFormXObject) {        PDFormXObject form = (PDFormXObject) xobject;        PDResources formResources = form.getResources();        if (formResources != null && context.getResources().getCOSObject() == formResources.getCOSObject()) {                        return;        }        if (form instanceof PDTransparencyGroup) {            context.showTransparencyGroup((PDTransparencyGroup) form);        } else {            context.showForm(form);        }    }}
public String pdfbox_f2244_0()
{    return OperatorName.DRAW_OBJECT;}
public void pdfbox_f2245_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.size() < 4) {        throw new MissingOperandException(operator, operands);    }    if (!checkArrayTypesClass(operands, COSNumber.class)) {        return;    }    COSNumber x = (COSNumber) operands.get(0);    COSNumber y = (COSNumber) operands.get(1);    COSNumber w = (COSNumber) operands.get(2);    COSNumber h = (COSNumber) operands.get(3);    float x1 = x.floatValue();    float y1 = y.floatValue();        float x2 = w.floatValue() + x1;    float y2 = h.floatValue() + y1;    Point2D p0 = context.transformedPoint(x1, y1);    Point2D p1 = context.transformedPoint(x2, y1);    Point2D p2 = context.transformedPoint(x2, y2);    Point2D p3 = context.transformedPoint(x1, y2);    context.appendRectangle(p0, p1, p2, p3);}
public String pdfbox_f2246_0()
{    return OperatorName.APPEND_RECT;}
public void pdfbox_f2247_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operator.getImageData() == null || operator.getImageData().length == 0) {        return;    }    PDImage image = new PDInlineImage(operator.getImageParameters(), operator.getImageData(), context.getResources());    context.drawImage(image);}
public String pdfbox_f2248_0()
{    return OperatorName.BEGIN_INLINE_IMAGE;}
public void pdfbox_f2249_0(Operator operator, List<COSBase> operands) throws IOException
{    context.clip(GeneralPath.WIND_EVEN_ODD);}
public String pdfbox_f2250_0()
{    return OperatorName.CLIP_EVEN_ODD;}
public void pdfbox_f2251_0(Operator operator, List<COSBase> operands) throws IOException
{    context.clip(GeneralPath.WIND_NON_ZERO);}
public String pdfbox_f2252_0()
{    return OperatorName.CLIP_NON_ZERO;}
public void pdfbox_f2253_0(Operator operator, List<COSBase> arguments) throws IOException
{    context.processOperator(OperatorName.CLOSE_PATH, arguments);    context.processOperator(OperatorName.STROKE_PATH, arguments);}
public String pdfbox_f2254_0()
{    return OperatorName.CLOSE_AND_STROKE;}
public void pdfbox_f2255_0(Operator operator, List<COSBase> operands) throws IOException
{    context.processOperator(OperatorName.CLOSE_PATH, operands);    context.processOperator(OperatorName.FILL_EVEN_ODD_AND_STROKE, operands);}
public String pdfbox_f2256_0()
{    return OperatorName.CLOSE_FILL_EVEN_ODD_AND_STROKE;}
public void pdfbox_f2257_0(Operator operator, List<COSBase> operands) throws IOException
{    context.processOperator(OperatorName.CLOSE_PATH, operands);    context.processOperator(OperatorName.FILL_NON_ZERO_AND_STROKE, operands);}
public String pdfbox_f2258_0()
{    return OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE;}
public void pdfbox_f2259_1(Operator operator, List<COSBase> operands) throws IOException
{    if (context.getCurrentPoint() == null) {                return;    }    context.closePath();}
public String pdfbox_f2260_0()
{    return OperatorName.CLOSE_PATH;}
public void pdfbox_f2261_1(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.size() < 6) {        throw new MissingOperandException(operator, operands);    }    if (!checkArrayTypesClass(operands, COSNumber.class)) {        return;    }    COSNumber x1 = (COSNumber) operands.get(0);    COSNumber y1 = (COSNumber) operands.get(1);    COSNumber x2 = (COSNumber) operands.get(2);    COSNumber y2 = (COSNumber) operands.get(3);    COSNumber x3 = (COSNumber) operands.get(4);    COSNumber y3 = (COSNumber) operands.get(5);    Point2D.Float point1 = context.transformedPoint(x1.floatValue(), y1.floatValue());    Point2D.Float point2 = context.transformedPoint(x2.floatValue(), y2.floatValue());    Point2D.Float point3 = context.transformedPoint(x3.floatValue(), y3.floatValue());    if (context.getCurrentPoint() == null) {                context.moveTo(point3.x, point3.y);    } else {        context.curveTo(point1.x, point1.y, point2.x, point2.y, point3.x, point3.y);    }}
public String pdfbox_f2262_0()
{    return OperatorName.CURVE_TO;}
public void pdfbox_f2263_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.size() < 4) {        throw new MissingOperandException(operator, operands);    }    if (!checkArrayTypesClass(operands, COSNumber.class)) {        return;    }    COSNumber x1 = (COSNumber) operands.get(0);    COSNumber y1 = (COSNumber) operands.get(1);    COSNumber x3 = (COSNumber) operands.get(2);    COSNumber y3 = (COSNumber) operands.get(3);    Point2D.Float point1 = context.transformedPoint(x1.floatValue(), y1.floatValue());    Point2D.Float point3 = context.transformedPoint(x3.floatValue(), y3.floatValue());    context.curveTo(point1.x, point1.y, point3.x, point3.y, point3.x, point3.y);}
public String pdfbox_f2264_0()
{    return OperatorName.CURVE_TO_REPLICATE_FINAL_POINT;}
public void pdfbox_f2265_1(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.size() < 4) {        throw new MissingOperandException(operator, operands);    }    if (!checkArrayTypesClass(operands, COSNumber.class)) {        return;    }    COSNumber x2 = (COSNumber) operands.get(0);    COSNumber y2 = (COSNumber) operands.get(1);    COSNumber x3 = (COSNumber) operands.get(2);    COSNumber y3 = (COSNumber) operands.get(3);    Point2D currentPoint = context.getCurrentPoint();    Point2D.Float point2 = context.transformedPoint(x2.floatValue(), y2.floatValue());    Point2D.Float point3 = context.transformedPoint(x3.floatValue(), y3.floatValue());    if (currentPoint == null) {                context.moveTo(point3.x, point3.y);    } else {        context.curveTo((float) currentPoint.getX(), (float) currentPoint.getY(), point2.x, point2.y, point3.x, point3.y);    }}
public String pdfbox_f2266_0()
{    return OperatorName.CURVE_TO_REPLICATE_INITIAL_POINT;}
public void pdfbox_f2267_1(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.isEmpty()) {        throw new MissingOperandException(operator, operands);    }    COSBase base0 = operands.get(0);    if (!(base0 instanceof COSName)) {        return;    }    COSName objectName = (COSName) base0;    PDXObject xobject = context.getResources().getXObject(objectName);    if (xobject == null) {        throw new MissingResourceException("Missing XObject: " + objectName.getName());    } else if (xobject instanceof PDImageXObject) {        PDImageXObject image = (PDImageXObject) xobject;        context.drawImage(image);    } else if (xobject instanceof PDFormXObject) {        PDFormXObject form = (PDFormXObject) xobject;        PDResources formResources = form.getResources();        if (formResources != null && context.getResources().getCOSObject() == formResources.getCOSObject()) {                                                return;        }        if (form instanceof PDTransparencyGroup) {            context.showTransparencyGroup((PDTransparencyGroup) form);        } else {            context.showForm(form);        }    }}
public String pdfbox_f2268_0()
{    return OperatorName.DRAW_OBJECT;}
public void pdfbox_f2269_0(Operator operator, List<COSBase> operands) throws IOException
{    context.endPath();}
public String pdfbox_f2270_0()
{    return OperatorName.ENDPATH;}
public void pdfbox_f2271_0(Operator operator, List<COSBase> operands) throws IOException
{    context.fillAndStrokePath(GeneralPath.WIND_EVEN_ODD);}
public String pdfbox_f2272_0()
{    return OperatorName.FILL_EVEN_ODD_AND_STROKE;}
public void pdfbox_f2273_0(Operator operator, List<COSBase> operands) throws IOException
{    context.fillPath(GeneralPath.WIND_EVEN_ODD);}
public String pdfbox_f2274_0()
{    return OperatorName.FILL_EVEN_ODD;}
public void pdfbox_f2275_0(Operator operator, List<COSBase> operands) throws IOException
{    context.fillAndStrokePath(GeneralPath.WIND_NON_ZERO);}
public String pdfbox_f2276_0()
{    return OperatorName.FILL_NON_ZERO_AND_STROKE;}
public final void pdfbox_f2277_0(Operator operator, List<COSBase> operands) throws IOException
{    context.fillPath(GeneralPath.WIND_NON_ZERO);}
public String pdfbox_f2278_0()
{    return OperatorName.FILL_NON_ZERO;}
public void pdfbox_f2279_0(PDFStreamEngine context)
{    super.setContext(context);    this.context = (PDFGraphicsStreamEngine) context;}
public String pdfbox_f2280_0()
{    return OperatorName.LEGACY_FILL_NON_ZERO;}
public void pdfbox_f2281_1(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.size() < 2) {        throw new MissingOperandException(operator, operands);    }    COSBase base0 = operands.get(0);    if (!(base0 instanceof COSNumber)) {        return;    }    COSBase base1 = operands.get(1);    if (!(base1 instanceof COSNumber)) {        return;    }        COSNumber x = (COSNumber) base0;    COSNumber y = (COSNumber) base1;    Point2D.Float pos = context.transformedPoint(x.floatValue(), y.floatValue());    if (context.getCurrentPoint() == null) {                context.moveTo(pos.x, pos.y);    } else {        context.lineTo(pos.x, pos.y);    }}
public String pdfbox_f2282_0()
{    return OperatorName.LINE_TO;}
public void pdfbox_f2283_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.size() < 2) {        throw new MissingOperandException(operator, operands);    }    COSBase base0 = operands.get(0);    if (!(base0 instanceof COSNumber)) {        return;    }    COSBase base1 = operands.get(1);    if (!(base1 instanceof COSNumber)) {        return;    }    COSNumber x = (COSNumber) base0;    COSNumber y = (COSNumber) base1;    Point2D.Float pos = context.transformedPoint(x.floatValue(), y.floatValue());    context.moveTo(pos.x, pos.y);}
public String pdfbox_f2284_0()
{    return OperatorName.MOVE_TO;}
public void pdfbox_f2285_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.isEmpty()) {        throw new MissingOperandException(operator, operands);    }    context.shadingFill((COSName) operands.get(0));}
public String pdfbox_f2286_0()
{    return OperatorName.SHADING_FILL;}
public void pdfbox_f2287_0(Operator operator, List<COSBase> operands) throws IOException
{    context.strokePath();}
public String pdfbox_f2288_0()
{    return OperatorName.STROKE_PATH;}
public void pdfbox_f2289_0(Operator operator, List<COSBase> arguments) throws IOException
{    COSName tag = null;    for (COSBase argument : arguments) {        if (argument instanceof COSName) {            tag = (COSName) argument;        }    }    context.beginMarkedContentSequence(tag, null);}
public String pdfbox_f2290_0()
{    return OperatorName.BEGIN_MARKED_CONTENT;}
public void pdfbox_f2291_0(Operator operator, List<COSBase> arguments) throws IOException
{    COSName tag = null;    COSDictionary properties = null;    for (COSBase argument : arguments) {        if (argument instanceof COSName) {            tag = (COSName) argument;        } else if (argument instanceof COSDictionary) {            properties = (COSDictionary) argument;        }    }    context.beginMarkedContentSequence(tag, properties);}
public String pdfbox_f2292_0()
{    return OperatorName.BEGIN_MARKED_CONTENT_SEQ;}
public void pdfbox_f2293_1(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSBase base0 = arguments.get(0);    if (!(base0 instanceof COSName)) {        return;    }    COSName name = (COSName) base0;    PDXObject xobject = context.getResources().getXObject(name);    ((PDFMarkedContentExtractor) context).xobject(xobject);    if (xobject instanceof PDFormXObject) {        PDFormXObject form = (PDFormXObject) xobject;        PDResources formResources = form.getResources();        if (formResources != null && context.getResources().getCOSObject() == formResources.getCOSObject()) {                        return;        }        if (form instanceof PDTransparencyGroup) {            context.showTransparencyGroup((PDTransparencyGroup) form);        } else {            context.showForm(form);        }    }}
public String pdfbox_f2294_0()
{    return OperatorName.DRAW_OBJECT;}
public void pdfbox_f2295_0(Operator operator, List<COSBase> arguments) throws IOException
{    context.endMarkedContentSequence();}
public String pdfbox_f2296_0()
{    return OperatorName.END_MARKED_CONTENT;}
public static Operator pdfbox_f2297_0(String operator)
{    Operator operation;    if (operator.equals(OperatorName.BEGIN_INLINE_IMAGE_DATA) || OperatorName.BEGIN_INLINE_IMAGE.equals(operator)) {                operation = new Operator(operator);    } else {        operation = operators.get(operator);        if (operation == null) {                                    operation = operators.putIfAbsent(operator, new Operator(operator));            if (operation == null) {                operation = operators.get(operator);            }        }    }    return operation;}
public String pdfbox_f2298_0()
{    return theOperator;}
public String pdfbox_f2299_0()
{    return "PDFOperator{" + theOperator + "}";}
public byte[] pdfbox_f2300_0()
{    return this.imageData;}
public void pdfbox_f2301_0(byte[] imageDataArray)
{    imageData = imageDataArray;}
public COSDictionary pdfbox_f2302_0()
{    return imageParameters;}
public void pdfbox_f2303_0(COSDictionary params)
{    imageParameters = params;}
protected final PDFStreamEngine pdfbox_f2304_0()
{    return context;}
public void pdfbox_f2305_0(PDFStreamEngine context)
{    this.context = context;}
public boolean pdfbox_f2306_0(List<COSBase> operands, Class<?> clazz)
{    for (COSBase base : operands) {        if (!clazz.isInstance(base)) {            return false;        }    }    return true;}
public void pdfbox_f2307_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.size() < 6) {        throw new MissingOperandException(operator, arguments);    }    if (!checkArrayTypesClass(arguments, COSNumber.class)) {        return;    }        COSNumber a = (COSNumber) arguments.get(0);    COSNumber b = (COSNumber) arguments.get(1);    COSNumber c = (COSNumber) arguments.get(2);    COSNumber d = (COSNumber) arguments.get(3);    COSNumber e = (COSNumber) arguments.get(4);    COSNumber f = (COSNumber) arguments.get(5);    Matrix matrix = new Matrix(a.floatValue(), b.floatValue(), c.floatValue(), d.floatValue(), e.floatValue(), f.floatValue());    context.getGraphicsState().getCurrentTransformationMatrix().concatenate(matrix);}
public String pdfbox_f2308_0()
{    return OperatorName.CONCAT;}
public void pdfbox_f2309_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (context.getGraphicsStackSize() > 1) {        context.restoreGraphicsState();    } else {                throw new EmptyGraphicsStackException();    }}
public String pdfbox_f2310_0()
{    return OperatorName.RESTORE;}
public void pdfbox_f2311_0(Operator operator, List<COSBase> arguments)
{    context.saveGraphicsState();}
public String pdfbox_f2312_0()
{    return OperatorName.SAVE;}
public void pdfbox_f2313_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.isEmpty()) {        throw new MissingOperandException(operator, operands);    }    if (!checkArrayTypesClass(operands, COSNumber.class)) {        return;    }    COSNumber value = (COSNumber) operands.get(0);    context.getGraphicsState().setFlatness(value.floatValue());}
public String pdfbox_f2314_0()
{    return OperatorName.SET_FLATNESS;}
public void pdfbox_f2315_1(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSBase base0 = arguments.get(0);    if (!(base0 instanceof COSName)) {        return;    }        COSName graphicsName = (COSName) base0;    PDExtendedGraphicsState gs = context.getResources().getExtGState(graphicsName);    if (gs == null) {                return;    }    gs.copyIntoGraphicsState(context.getGraphicsState());}
public String pdfbox_f2316_0()
{    return OperatorName.SET_GRAPHICS_STATE_PARAMS;}
public void pdfbox_f2317_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    int lineCapStyle = ((COSNumber) arguments.get(0)).intValue();    context.getGraphicsState().setLineCap(lineCapStyle);}
public String pdfbox_f2318_0()
{    return OperatorName.SET_LINE_CAPSTYLE;}
public void pdfbox_f2319_1(Operator operator, List<COSBase> arguments) throws MissingOperandException
{    if (arguments.size() < 2) {        throw new MissingOperandException(operator, arguments);    }    COSBase base0 = arguments.get(0);    if (!(base0 instanceof COSArray)) {        return;    }    COSBase base1 = arguments.get(1);    if (!(base1 instanceof COSNumber)) {        return;    }    COSArray dashArray = (COSArray) base0;    int dashPhase = ((COSNumber) base1).intValue();    boolean allZero = true;    for (COSBase base : dashArray) {        if (base instanceof COSNumber) {            COSNumber num = (COSNumber) base;            if (Float.compare(num.floatValue(), 0) != 0) {                allZero = false;                break;            }        } else {                        dashArray = new COSArray();            break;        }    }    if (dashArray.size() > 0 && allZero) {                dashArray = new COSArray();    }    context.setLineDashPattern(dashArray, dashPhase);}
public String pdfbox_f2320_0()
{    return OperatorName.SET_LINE_DASHPATTERN;}
public void pdfbox_f2321_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    int lineJoinStyle = ((COSNumber) arguments.get(0)).intValue();    context.getGraphicsState().setLineJoin(lineJoinStyle);}
public String pdfbox_f2322_0()
{    return OperatorName.SET_LINE_JOINSTYLE;}
public void pdfbox_f2323_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSNumber miterLimit = (COSNumber) arguments.get(0);    context.getGraphicsState().setMiterLimit(miterLimit.floatValue());}
public String pdfbox_f2324_0()
{    return OperatorName.SET_LINE_MITERLIMIT;}
public void pdfbox_f2325_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSNumber width = (COSNumber) arguments.get(0);    context.getGraphicsState().setLineWidth(width.floatValue());}
public String pdfbox_f2326_0()
{    return OperatorName.SET_LINE_WIDTH;}
public void pdfbox_f2327_0(Operator operator, List<COSBase> arguments) throws MissingOperandException
{    if (arguments.size() < 6) {        throw new MissingOperandException(operator, arguments);    }    if (!checkArrayTypesClass(arguments, COSNumber.class)) {        return;    }    COSNumber a = (COSNumber) arguments.get(0);    COSNumber b = (COSNumber) arguments.get(1);    COSNumber c = (COSNumber) arguments.get(2);    COSNumber d = (COSNumber) arguments.get(3);    COSNumber e = (COSNumber) arguments.get(4);    COSNumber f = (COSNumber) arguments.get(5);    Matrix matrix = new Matrix(a.floatValue(), b.floatValue(), c.floatValue(), d.floatValue(), e.floatValue(), f.floatValue());    context.setTextMatrix(matrix);    context.setTextLineMatrix(matrix.clone());}
public String pdfbox_f2328_0()
{    return OperatorName.SET_MATRIX;}
public void pdfbox_f2329_0(Operator operator, List<COSBase> operands) throws IOException
{    if (operands.isEmpty()) {        throw new MissingOperandException(operator, operands);    }    COSBase base = operands.get(0);    if (!(base instanceof COSName)) {        return;    }    context.getGraphicsState().setRenderingIntent(RenderingIntent.fromString(((COSName) base).getName()));}
public String pdfbox_f2330_0()
{    return OperatorName.SET_RENDERINGINTENT;}
public void pdfbox_f2331_0(Operator operator, List<COSBase> arguments) throws IOException
{    context.setTextMatrix(new Matrix());    context.setTextLineMatrix(new Matrix());    context.beginText();}
public String pdfbox_f2332_0()
{    return OperatorName.BEGIN_TEXT;}
public void pdfbox_f2333_0(Operator operator, List<COSBase> arguments) throws IOException
{    context.setTextMatrix(null);    context.setTextLineMatrix(null);    context.endText();}
public String pdfbox_f2334_0()
{    return OperatorName.END_TEXT;}
public void pdfbox_f2335_1(Operator operator, List<COSBase> arguments) throws MissingOperandException
{    if (arguments.size() < 2) {        throw new MissingOperandException(operator, arguments);    }    Matrix textLineMatrix = context.getTextLineMatrix();    if (textLineMatrix == null) {                return;    }    COSBase base0 = arguments.get(0);    COSBase base1 = arguments.get(1);    if (!(base0 instanceof COSNumber)) {        return;    }    if (!(base1 instanceof COSNumber)) {        return;    }    COSNumber x = (COSNumber) base0;    COSNumber y = (COSNumber) base1;    Matrix matrix = new Matrix(1, 0, 0, 1, x.floatValue(), y.floatValue());    textLineMatrix.concatenate(matrix);    context.setTextMatrix(textLineMatrix.clone());}
public String pdfbox_f2336_0()
{    return OperatorName.MOVE_TEXT;}
public void pdfbox_f2337_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.size() < 2) {        throw new MissingOperandException(operator, arguments);    }        COSBase base1 = arguments.get(1);    if (!(base1 instanceof COSNumber)) {        return;    }    COSNumber y = (COSNumber) base1;    List<COSBase> args = new ArrayList<>();    args.add(new COSFloat(-1 * y.floatValue()));    context.processOperator(OperatorName.SET_TEXT_LEADING, args);    context.processOperator(OperatorName.MOVE_TEXT, arguments);}
public String pdfbox_f2338_0()
{    return OperatorName.MOVE_TEXT_SET_LEADING;}
public void pdfbox_f2339_0(Operator operator, List<COSBase> arguments) throws IOException
{        List<COSBase> args = new ArrayList<>();    args.add(new COSFloat(0f));            args.add(new COSFloat(-1 * context.getGraphicsState().getTextState().getLeading()));        context.processOperator(OperatorName.MOVE_TEXT, args);}
public String pdfbox_f2340_0()
{    return OperatorName.NEXT_LINE;}
public void pdfbox_f2341_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }                Object charSpacing = arguments.get(arguments.size() - 1);    if (charSpacing instanceof COSNumber) {        COSNumber characterSpacing = (COSNumber) charSpacing;        context.getGraphicsState().getTextState().setCharacterSpacing(characterSpacing.floatValue());    }}
public String pdfbox_f2342_0()
{    return OperatorName.SET_CHAR_SPACING;}
public void pdfbox_f2343_1(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.size() < 2) {        throw new MissingOperandException(operator, arguments);    }    COSBase base0 = arguments.get(0);    COSBase base1 = arguments.get(1);    if (!(base0 instanceof COSName)) {        return;    }    if (!(base1 instanceof COSNumber)) {        return;    }    COSName fontName = (COSName) base0;    float fontSize = ((COSNumber) base1).floatValue();    context.getGraphicsState().getTextState().setFontSize(fontSize);    PDFont font = context.getResources().getFont(fontName);    if (font == null) {            }    context.getGraphicsState().getTextState().setFont(font);}
public String pdfbox_f2344_0()
{    return OperatorName.SET_FONT_AND_SIZE;}
public void pdfbox_f2345_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSNumber scaling = (COSNumber) arguments.get(0);    context.getGraphicsState().getTextState().setHorizontalScaling(scaling.floatValue());}
public String pdfbox_f2346_0()
{    return OperatorName.SET_TEXT_HORIZONTAL_SCALING;}
public void pdfbox_f2347_0(Operator operator, List<COSBase> arguments)
{    COSNumber leading = (COSNumber) arguments.get(0);    context.getGraphicsState().getTextState().setLeading(leading.floatValue());}
public String pdfbox_f2348_0()
{    return OperatorName.SET_TEXT_LEADING;}
public void pdfbox_f2349_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        throw new MissingOperandException(operator, arguments);    }    COSBase base0 = arguments.get(0);    if (!(base0 instanceof COSNumber)) {        return;    }    COSNumber mode = (COSNumber) base0;    int val = mode.intValue();    if (val < 0 || val >= RenderingMode.values().length) {        return;    }    RenderingMode renderingMode = RenderingMode.fromInt(val);    context.getGraphicsState().getTextState().setRenderingMode(renderingMode);}
public String pdfbox_f2350_0()
{    return OperatorName.SET_TEXT_RENDERINGMODE;}
public void pdfbox_f2351_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        return;    }    COSBase base = arguments.get(0);    if (!(base instanceof COSNumber)) {        return;    }    COSNumber rise = (COSNumber) base;    context.getGraphicsState().getTextState().setRise(rise.floatValue());}
public String pdfbox_f2352_0()
{    return OperatorName.SET_TEXT_RISE;}
public void pdfbox_f2353_0(Operator operator, List<COSBase> arguments)
{    if (arguments.isEmpty()) {        return;    }    COSBase base = arguments.get(0);    if (!(base instanceof COSNumber)) {        return;    }    COSNumber wordSpacing = (COSNumber) base;    context.getGraphicsState().getTextState().setWordSpacing(wordSpacing.floatValue());}
public String pdfbox_f2354_0()
{    return OperatorName.SET_WORD_SPACING;}
public void pdfbox_f2355_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {                return;    }    COSBase base = arguments.get(0);    if (!(base instanceof COSString)) {                return;    }    if (context.getTextMatrix() == null) {                return;    }    COSString string = (COSString) base;    context.showTextString(string.getBytes());}
public String pdfbox_f2356_0()
{    return OperatorName.SHOW_TEXT;}
public void pdfbox_f2357_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.isEmpty()) {        return;    }    COSBase base = arguments.get(0);    if (!(base instanceof COSArray)) {        return;    }    if (context.getTextMatrix() == null) {                return;    }    COSArray array = (COSArray) base;    context.showTextStrings(array);}
public String pdfbox_f2358_0()
{    return OperatorName.SHOW_TEXT_ADJUSTED;}
public void pdfbox_f2359_0(Operator operator, List<COSBase> arguments) throws IOException
{    context.processOperator(OperatorName.NEXT_LINE, null);    context.processOperator(OperatorName.SHOW_TEXT, arguments);}
public String pdfbox_f2360_0()
{    return OperatorName.SHOW_TEXT_LINE;}
public void pdfbox_f2361_0(Operator operator, List<COSBase> arguments) throws IOException
{    if (arguments.size() < 3) {        throw new MissingOperandException(operator, arguments);    }    context.processOperator(OperatorName.SET_WORD_SPACING, arguments.subList(0, 1));    context.processOperator(OperatorName.SET_CHAR_SPACING, arguments.subList(1, 2));    context.processOperator(OperatorName.SHOW_TEXT_LINE, arguments.subList(2, 3));}
public String pdfbox_f2362_0()
{    return OperatorName.SHOW_TEXT_LINE_AND_SPACE;}
protected final PDPage pdfbox_f2363_0()
{    return page;}
public void pdfbox_f2364_0(String operator, OperatorProcessor op)
{    op.setContext(this);    operators.put(operator, op);}
public final void pdfbox_f2365_0(OperatorProcessor op)
{    op.setContext(this);    operators.put(op.getName(), op);}
private void pdfbox_f2366_0(PDPage page)
{    if (page == null) {        throw new IllegalArgumentException("Page cannot be null");    }    currentPage = page;    graphicsStack.clear();    graphicsStack.push(new PDGraphicsState(page.getCropBox()));    textMatrix = null;    textLineMatrix = null;    resources = null;    initialMatrix = page.getMatrix();}
public void pdfbox_f2367_0(PDPage page) throws IOException
{    initPage(page);    if (page.hasContents()) {        isProcessingPage = true;        processStream(page);        isProcessingPage = false;    }}
public void pdfbox_f2368_0(PDTransparencyGroup form) throws IOException
{    processTransparencyGroup(form);}
public void pdfbox_f2369_0(PDFormXObject form) throws IOException
{    if (currentPage == null) {        throw new IllegalStateException("No current page, call " + "#processChildStream(PDContentStream, PDPage) instead");    }    if (form.getCOSObject().getLength() > 0) {        processStream(form);    }}
protected void pdfbox_f2370_0(PDTransparencyGroup group) throws IOException
{    saveGraphicsState();    Matrix softMaskCTM = getGraphicsState().getSoftMask().getInitialTransformationMatrix();    getGraphicsState().setCurrentTransformationMatrix(softMaskCTM);    processTransparencyGroup(group);    restoreGraphicsState();}
protected void pdfbox_f2371_0(PDTransparencyGroup group) throws IOException
{    if (currentPage == null) {        throw new IllegalStateException("No current page, call " + "#processChildStream(PDContentStream, PDPage) instead");    }    PDResources parent = pushResources(group);    Deque<PDGraphicsState> savedStack = saveGraphicsStack();    Matrix parentMatrix = initialMatrix;        initialMatrix = getGraphicsState().getCurrentTransformationMatrix().clone();        getGraphicsState().getCurrentTransformationMatrix().concatenate(group.getMatrix());                getGraphicsState().setBlendMode(BlendMode.NORMAL);    getGraphicsState().setAlphaConstant(1);    getGraphicsState().setNonStrokeAlphaConstant(1);    getGraphicsState().setSoftMask(null);        clipToRect(group.getBBox());    processStreamOperators(group);    initialMatrix = parentMatrix;    restoreGraphicsStack(savedStack);    popResources(parent);}
protected void pdfbox_f2372_0(PDType3CharProc charProc, Matrix textRenderingMatrix) throws IOException
{    if (currentPage == null) {        throw new IllegalStateException("No current page, call " + "#processChildStream(PDContentStream, PDPage) instead");    }    PDResources parent = pushResources(charProc);    Deque<PDGraphicsState> savedStack = saveGraphicsStack();        getGraphicsState().setCurrentTransformationMatrix(textRenderingMatrix);        getGraphicsState().getCurrentTransformationMatrix().concatenate(charProc.getMatrix());            Matrix textMatrixOld = textMatrix;    textMatrix = new Matrix();    Matrix textLineMatrixOld = textLineMatrix;    textLineMatrix = new Matrix();    processStreamOperators(charProc);        textMatrix = textMatrixOld;    textLineMatrix = textLineMatrixOld;    restoreGraphicsStack(savedStack);    popResources(parent);}
protected void pdfbox_f2373_0(PDAnnotation annotation, PDAppearanceStream appearance) throws IOException
{    PDResources parent = pushResources(appearance);    Deque<PDGraphicsState> savedStack = saveGraphicsStack();    PDRectangle bbox = appearance.getBBox();    PDRectangle rect = annotation.getRectangle();    Matrix matrix = appearance.getMatrix();        if (rect != null && rect.getWidth() > 0 && rect.getHeight() > 0 && bbox != null) {                Rectangle2D transformedBox = bbox.transform(matrix).getBounds2D();                        Matrix a = Matrix.getTranslateInstance(rect.getLowerLeftX(), rect.getLowerLeftY());        a.concatenate(Matrix.getScaleInstance((float) (rect.getWidth() / transformedBox.getWidth()), (float) (rect.getHeight() / transformedBox.getHeight())));        a.concatenate(Matrix.getTranslateInstance((float) -transformedBox.getX(), (float) -transformedBox.getY()));                                                Matrix aa = Matrix.concatenate(a, matrix);                getGraphicsState().setCurrentTransformationMatrix(aa);                clipToRect(bbox);                initialMatrix = aa.clone();        processStreamOperators(appearance);    }    restoreGraphicsStack(savedStack);    popResources(parent);}
protected final void pdfbox_f2374_0(PDTilingPattern tilingPattern, PDColor color, PDColorSpace colorSpace) throws IOException
{    processTilingPattern(tilingPattern, color, colorSpace, tilingPattern.getMatrix());}
protected final void pdfbox_f2375_0(PDTilingPattern tilingPattern, PDColor color, PDColorSpace colorSpace, Matrix patternMatrix) throws IOException
{    PDResources parent = pushResources(tilingPattern);    Matrix parentMatrix = initialMatrix;    initialMatrix = Matrix.concatenate(initialMatrix, patternMatrix);        Deque<PDGraphicsState> savedStack = saveGraphicsStack();        Rectangle2D bbox = tilingPattern.getBBox().transform(patternMatrix).getBounds2D();    PDRectangle rect = new PDRectangle((float) bbox.getX(), (float) bbox.getY(), (float) bbox.getWidth(), (float) bbox.getHeight());    graphicsStack.push(new PDGraphicsState(rect));        if (colorSpace != null) {        color = new PDColor(color.getComponents(), colorSpace);        getGraphicsState().setNonStrokingColorSpace(colorSpace);        getGraphicsState().setNonStrokingColor(color);        getGraphicsState().setStrokingColorSpace(colorSpace);        getGraphicsState().setStrokingColor(color);    }        getGraphicsState().getCurrentTransformationMatrix().concatenate(patternMatrix);        clipToRect(tilingPattern.getBBox());    processStreamOperators(tilingPattern);    initialMatrix = parentMatrix;    restoreGraphicsStack(savedStack);    popResources(parent);}
public void pdfbox_f2376_0(PDAnnotation annotation) throws IOException
{    PDAppearanceStream appearanceStream = getAppearance(annotation);    if (appearanceStream != null) {        processAnnotation(annotation, appearanceStream);    }}
public PDAppearanceStream pdfbox_f2377_0(PDAnnotation annotation)
{    return annotation.getNormalAppearanceStream();}
protected void pdfbox_f2378_0(PDContentStream contentStream, PDPage page) throws IOException
{    if (isProcessingPage) {        throw new IllegalStateException("Current page has already been set via " + " #processPage(PDPage) call #processChildStream(PDContentStream) instead");    }    initPage(page);    processStream(contentStream);    currentPage = null;}
private void pdfbox_f2379_0(PDContentStream contentStream) throws IOException
{    PDResources parent = pushResources(contentStream);    Deque<PDGraphicsState> savedStack = saveGraphicsStack();    Matrix parentMatrix = initialMatrix;        getGraphicsState().getCurrentTransformationMatrix().concatenate(contentStream.getMatrix());        initialMatrix = getGraphicsState().getCurrentTransformationMatrix().clone();        PDRectangle bbox = contentStream.getBBox();    clipToRect(bbox);    processStreamOperators(contentStream);    initialMatrix = parentMatrix;    restoreGraphicsStack(savedStack);    popResources(parent);}
private void pdfbox_f2380_0(PDContentStream contentStream) throws IOException
{    List<COSBase> arguments = new ArrayList<>();    try (InputStream is = contentStream.getContents()) {        PDFStreamParser parser = new PDFStreamParser(is);        Object token = parser.parseNextToken();        while (token != null) {            if (token instanceof COSObject) {                arguments.add(((COSObject) token).getObject());            } else if (token instanceof Operator) {                processOperator((Operator) token, arguments);                arguments = new ArrayList<>();            } else {                arguments.add((COSBase) token);            }            token = parser.parseNextToken();        }    }}
private PDResources pdfbox_f2381_0(PDContentStream contentStream)
{        PDResources parentResources = resources;    PDResources streamResources = contentStream.getResources();    if (streamResources != null) {        resources = streamResources;    } else if (resources != null) {            } else {        resources = currentPage.getResources();    }        if (resources == null) {        resources = new PDResources();    }    return parentResources;}
private void pdfbox_f2382_0(PDResources parentResources)
{    resources = parentResources;}
private void pdfbox_f2383_0(PDRectangle rectangle)
{    if (rectangle != null) {        GeneralPath clip = rectangle.transform(getGraphicsState().getCurrentTransformationMatrix());        getGraphicsState().intersectClippingPath(clip);    }}
public void pdfbox_f2386_0(byte[] string) throws IOException
{    showText(string);}
public void pdfbox_f2387_0(COSArray array) throws IOException
{    PDTextState textState = getGraphicsState().getTextState();    float fontSize = textState.getFontSize();    float horizontalScaling = textState.getHorizontalScaling() / 100f;    PDFont font = textState.getFont();    boolean isVertical = false;    if (font != null) {        isVertical = font.isVertical();    }    for (COSBase obj : array) {        if (obj instanceof COSNumber) {            float tj = ((COSNumber) obj).floatValue();                        float tx;            float ty;            if (isVertical) {                tx = 0;                ty = -tj / 1000 * fontSize;            } else {                tx = -tj / 1000 * fontSize * horizontalScaling;                ty = 0;            }            applyTextAdjustment(tx, ty);        } else if (obj instanceof COSString) {            byte[] string = ((COSString) obj).getBytes();            showText(string);        } else {            throw new IOException("Unknown type in array for TJ operation:" + obj);        }    }}
protected void pdfbox_f2388_0(float tx, float ty) throws IOException
{        textMatrix.concatenate(Matrix.getTranslateInstance(tx, ty));}
protected void pdfbox_f2389_1(byte[] string) throws IOException
{    PDGraphicsState state = getGraphicsState();    PDTextState textState = state.getTextState();        PDFont font = textState.getFont();    if (font == null) {                font = PDFontFactory.createDefaultFont();    }    float fontSize = textState.getFontSize();    float horizontalScaling = textState.getHorizontalScaling() / 100f;    float charSpacing = textState.getCharacterSpacing();        Matrix parameters = new Matrix(    fontSize * horizontalScaling,     0,     0,     fontSize, 0,     textState.getRise());        InputStream in = new ByteArrayInputStream(string);    while (in.available() > 0) {                int before = in.available();        int code = font.readCode(in);        int codeLength = before - in.available();        String unicode = font.toUnicode(code);                                float wordSpacing = 0;        if (codeLength == 1 && code == 32) {            wordSpacing += textState.getWordSpacing();        }                Matrix ctm = state.getCurrentTransformationMatrix();        Matrix textRenderingMatrix = parameters.multiply(textMatrix).multiply(ctm);                if (font.isVertical()) {                        Vector v = font.getPositionVector(code);                        textRenderingMatrix.translate(v);        }                Vector w = font.getDisplacement(code);                saveGraphicsState();        Matrix textMatrixOld = textMatrix;        Matrix textLineMatrixOld = textLineMatrix;        showGlyph(textRenderingMatrix, font, code, unicode, w);        textMatrix = textMatrixOld;        textLineMatrix = textLineMatrixOld;        restoreGraphicsState();                float tx;        float ty;        if (font.isVertical()) {            tx = 0;            ty = w.getY() * fontSize + charSpacing + wordSpacing;        } else {            tx = (w.getX() * fontSize + charSpacing + wordSpacing) * horizontalScaling;            ty = 0;        }                textMatrix.concatenate(Matrix.getTranslateInstance(tx, ty));    }}
protected void pdfbox_f2390_0(Matrix textRenderingMatrix, PDFont font, int code, String unicode, Vector displacement) throws IOException
{    if (font instanceof PDType3Font) {        showType3Glyph(textRenderingMatrix, (PDType3Font) font, code, unicode, displacement);    } else {        showFontGlyph(textRenderingMatrix, font, code, unicode, displacement);    }}
protected void pdfbox_f2392_0(Matrix textRenderingMatrix, PDType3Font font, int code, String unicode, Vector displacement) throws IOException
{    PDType3CharProc charProc = font.getCharProc(code);    if (charProc != null) {        processType3Stream(charProc, textRenderingMatrix);    }}
public void pdfbox_f2395_0(String operation, List<COSBase> arguments) throws IOException
{    Operator operator = Operator.getOperator(operation);    processOperator(operator, arguments);}
protected void pdfbox_f2396_0(Operator operator, List<COSBase> operands) throws IOException
{    String name = operator.getName();    OperatorProcessor processor = operators.get(name);    if (processor != null) {        processor.setContext(this);        try {            processor.process(operator, operands);        } catch (IOException e) {            operatorException(operator, operands, e);        }    } else {        unsupportedOperator(operator, operands);    }}
protected void pdfbox_f2398_1(Operator operator, List<COSBase> operands, IOException e) throws IOException
{    if (e instanceof MissingOperandException || e instanceof MissingResourceException || e instanceof MissingImageReaderException) {            } else if (e instanceof EmptyGraphicsStackException) {            } else if (operator.getName().equals("Do")) {                            } else {        throw e;    }}
public void pdfbox_f2399_0()
{    graphicsStack.push(graphicsStack.peek().clone());}
public void pdfbox_f2400_0()
{    graphicsStack.pop();}
protected final Deque<PDGraphicsState> pdfbox_f2401_0()
{    Deque<PDGraphicsState> savedStack = graphicsStack;    graphicsStack = new ArrayDeque<>();    graphicsStack.add(savedStack.peek().clone());    return savedStack;}
protected final void pdfbox_f2402_0(Deque<PDGraphicsState> snapshot)
{    graphicsStack = snapshot;}
public int pdfbox_f2403_0()
{    return graphicsStack.size();}
public PDGraphicsState pdfbox_f2404_0()
{    return graphicsStack.peek();}
public Matrix pdfbox_f2405_0()
{    return textLineMatrix;}
public void pdfbox_f2406_0(Matrix value)
{    textLineMatrix = value;}
public Matrix pdfbox_f2407_0()
{    return textMatrix;}
public void pdfbox_f2408_0(Matrix value)
{    textMatrix = value;}
public void pdfbox_f2409_1(COSArray array, int phase)
{    if (phase < 0) {                phase = 0;    }    PDLineDashPattern lineDash = new PDLineDashPattern(array, phase);    getGraphicsState().setLineDashPattern(lineDash);}
public PDResources pdfbox_f2410_0()
{    return resources;}
public PDPage pdfbox_f2411_0()
{    return currentPage;}
public Matrix pdfbox_f2412_0()
{    return initialMatrix;}
public Point2D.Float pdfbox_f2413_0(float x, float y)
{    float[] position = { x, y };    getGraphicsState().getCurrentTransformationMatrix().createAffineTransform().transform(position, 0, position, 0, 1);    return new Point2D.Float(position[0], position[1]);}
protected float pdfbox_f2414_0(float width)
{    Matrix ctm = getGraphicsState().getCurrentTransformationMatrix();    float x = ctm.getScaleX() + ctm.getShearX();    float y = ctm.getScaleY() + ctm.getShearY();    return width * (float) Math.sqrt((x * x + y * y) * 0.5);}
public void pdfbox_f2415_0(COSBase object)
{    objects.add(object);}
public void pdfbox_f2416_0(COSObjectable object)
{    objects.add(object.getCOSObject());}
public void pdfbox_f2417_0(int i, COSBase object)
{    objects.add(i, object);}
public void pdfbox_f2418_0()
{    objects.clear();}
public void pdfbox_f2419_0(Collection<COSBase> objectsList)
{    objects.removeAll(objectsList);}
public void pdfbox_f2420_0(Collection<COSBase> objectsList)
{    objects.retainAll(objectsList);}
public void pdfbox_f2421_0(Collection<COSBase> objectsList)
{    objects.addAll(objectsList);}
public void pdfbox_f2422_0(COSArray objectList)
{    if (objectList != null) {        objects.addAll(objectList.objects);    }}
public void pdfbox_f2423_0(int i, Collection<COSBase> objectList)
{    objects.addAll(i, objectList);}
public void pdfbox_f2424_0(int index, COSBase object)
{    objects.set(index, object);}
public void pdfbox_f2425_0(int index, int intVal)
{    objects.set(index, COSInteger.get(intVal));}
public void pdfbox_f2426_0(int index, COSObjectable object)
{    COSBase base = null;    if (object != null) {        base = object.getCOSObject();    }    objects.set(index, base);}
public COSBase pdfbox_f2427_0(int index)
{    Object obj = objects.get(index);    if (obj instanceof COSObject) {        obj = ((COSObject) obj).getObject();    }    if (obj instanceof COSNull) {        obj = null;    }    return (COSBase) obj;}
public COSBase pdfbox_f2428_0(int index)
{    return objects.get(index);}
public int pdfbox_f2429_0(int index)
{    return getInt(index, -1);}
public int pdfbox_f2430_0(int index, int defaultValue)
{    int retval = defaultValue;    if (index < size()) {        Object obj = objects.get(index);        if (obj instanceof COSNumber) {            retval = ((COSNumber) obj).intValue();        }    }    return retval;}
public void pdfbox_f2431_0(int index, int value)
{    set(index, COSInteger.get(value));}
public void pdfbox_f2432_0(int index, String name)
{    set(index, COSName.getPDFName(name));}
public String pdfbox_f2433_0(int index)
{    return getName(index, null);}
public String pdfbox_f2434_0(int index, String defaultValue)
{    String retval = defaultValue;    if (index < size()) {        Object obj = objects.get(index);        if (obj instanceof COSName) {            retval = ((COSName) obj).getName();        }    }    return retval;}
public void pdfbox_f2435_0(int index, String string)
{    if (string != null) {        set(index, new COSString(string));    } else {        set(index, null);    }}
public String pdfbox_f2436_0(int index)
{    return getString(index, null);}
public String pdfbox_f2437_0(int index, String defaultValue)
{    String retval = defaultValue;    if (index < size()) {        Object obj = objects.get(index);        if (obj instanceof COSString) {            retval = ((COSString) obj).getString();        }    }    return retval;}
public int pdfbox_f2438_0()
{    return objects.size();}
public COSBase pdfbox_f2439_0(int i)
{    return objects.remove(i);}
public boolean pdfbox_f2440_0(COSBase o)
{    return objects.remove(o);}
public boolean pdfbox_f2441_0(COSBase o)
{    boolean removed = this.remove(o);    if (!removed) {        for (int i = 0; i < this.size(); i++) {            COSBase entry = this.get(i);            if (entry instanceof COSObject) {                COSObject objEntry = (COSObject) entry;                if (objEntry.getObject().equals(o)) {                    return this.remove(entry);                }            }        }    }    return removed;}
public String pdfbox_f2442_0()
{    return "COSArray{" + objects + "}";}
public Iterator<COSBase> pdfbox_f2443_0()
{    return objects.iterator();}
public int pdfbox_f2444_0(COSBase object)
{    int retval = -1;    for (int i = 0; retval < 0 && i < size(); i++) {        if (get(i).equals(object)) {            retval = i;        }    }    return retval;}
public int pdfbox_f2445_0(COSBase object)
{    int retval = -1;    for (int i = 0; retval < 0 && i < this.size(); i++) {        COSBase item = this.get(i);        if (item.equals(object) || item instanceof COSObject && ((COSObject) item).getObject().equals(object)) {            retval = i;            break;        }    }    return retval;}
public void pdfbox_f2446_0(int size)
{    growToSize(size, null);}
public void pdfbox_f2447_0(int size, COSBase object)
{    while (size() < size) {        add(object);    }}
public Object pdfbox_f2448_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromArray(this);}
public boolean pdfbox_f2449_0()
{    return needToBeUpdated;}
public void pdfbox_f2450_0(boolean flag)
{    needToBeUpdated = flag;}
public float[] pdfbox_f2451_0()
{    float[] retval = new float[size()];    for (int i = 0; i < size(); i++) {        COSBase base = getObject(i);        retval[i] = base instanceof COSNumber ? ((COSNumber) base).floatValue() : 0;    }    return retval;}
public void pdfbox_f2452_0(float[] value)
{    this.clear();    for (float aValue : value) {        add(new COSFloat(aValue));    }}
public List<? extends COSBase> pdfbox_f2453_0()
{    List<COSBase> retList = new ArrayList<>(size());    for (int i = 0; i < size(); i++) {        retList.add(get(i));    }    return retList;}
public COSBase pdfbox_f2454_0()
{    return this;}
public boolean pdfbox_f2455_0()
{    return direct;}
public void pdfbox_f2456_0(boolean direct)
{    this.direct = direct;}
public boolean pdfbox_f2457_0()
{    return value;}
public Boolean pdfbox_f2458_0()
{    return value ? Boolean.TRUE : Boolean.FALSE;}
public static COSBoolean pdfbox_f2459_0(boolean value)
{    return value ? TRUE : FALSE;}
public static COSBoolean pdfbox_f2460_0(Boolean value)
{    return getBoolean(value.booleanValue());}
public Object pdfbox_f2461_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromBoolean(this);}
public String pdfbox_f2462_0()
{    return String.valueOf(value);}
public void pdfbox_f2463_0(OutputStream output) throws IOException
{    if (value) {        output.write(TRUE_BYTES);    } else {        output.write(FALSE_BYTES);    }}
public boolean pdfbox_f2464_0(Object value)
{    boolean contains = items.containsValue(value);    if (!contains && value instanceof COSObject) {        contains = items.containsValue(((COSObject) value).getObject());    }    return contains;}
public COSName pdfbox_f2465_0(Object value)
{    for (Map.Entry<COSName, COSBase> entry : items.entrySet()) {        Object nextValue = entry.getValue();        if (nextValue.equals(value) || (nextValue instanceof COSObject && ((COSObject) nextValue).getObject().equals(value))) {            return entry.getKey();        }    }    return null;}
public int pdfbox_f2466_0()
{    return items.size();}
public void pdfbox_f2467_0()
{    items.clear();}
public COSBase pdfbox_f2468_0(String key)
{    return getDictionaryObject(COSName.getPDFName(key));}
public COSBase pdfbox_f2469_0(COSName firstKey, COSName secondKey)
{    COSBase retval = getDictionaryObject(firstKey);    if (retval == null && secondKey != null) {        retval = getDictionaryObject(secondKey);    }    return retval;}
public COSBase pdfbox_f2470_0(COSName key)
{    COSBase retval = items.get(key);    if (retval instanceof COSObject) {        retval = ((COSObject) retval).getObject();    }    if (retval instanceof COSNull) {        retval = null;    }    return retval;}
public void pdfbox_f2471_0(COSName key, COSBase value)
{    if (value == null) {        removeItem(key);    } else {        items.put(key, value);    }}
public void pdfbox_f2472_0(COSName key, COSObjectable value)
{    COSBase base = null;    if (value != null) {        base = value.getCOSObject();    }    setItem(key, base);}
public void pdfbox_f2473_0(String key, COSObjectable value)
{    setItem(COSName.getPDFName(key), value);}
public void pdfbox_f2474_0(String key, boolean value)
{    setItem(COSName.getPDFName(key), COSBoolean.getBoolean(value));}
public void pdfbox_f2475_0(COSName key, boolean value)
{    setItem(key, COSBoolean.getBoolean(value));}
public void pdfbox_f2476_0(String key, COSBase value)
{    setItem(COSName.getPDFName(key), value);}
public void pdfbox_f2477_0(String key, String value)
{    setName(COSName.getPDFName(key), value);}
public void pdfbox_f2478_0(COSName key, String value)
{    COSName name = null;    if (value != null) {        name = COSName.getPDFName(value);    }    setItem(key, name);}
public void pdfbox_f2479_0(String key, Calendar date)
{    setDate(COSName.getPDFName(key), date);}
public void pdfbox_f2480_0(COSName key, Calendar date)
{    setString(key, DateConverter.toString(date));}
public void pdfbox_f2481_0(String embedded, String key, Calendar date)
{    setEmbeddedDate(embedded, COSName.getPDFName(key), date);}
public void pdfbox_f2482_0(String embedded, COSName key, Calendar date)
{    COSDictionary dic = (COSDictionary) getDictionaryObject(embedded);    if (dic == null && date != null) {        dic = new COSDictionary();        setItem(embedded, dic);    }    if (dic != null) {        dic.setDate(key, date);    }}
public void pdfbox_f2483_0(String key, String value)
{    setString(COSName.getPDFName(key), value);}
public void pdfbox_f2484_0(COSName key, String value)
{    COSString name = null;    if (value != null) {        name = new COSString(value);    }    setItem(key, name);}
public void pdfbox_f2485_0(String embedded, String key, String value)
{    setEmbeddedString(embedded, COSName.getPDFName(key), value);}
public void pdfbox_f2486_0(String embedded, COSName key, String value)
{    COSDictionary dic = (COSDictionary) getDictionaryObject(embedded);    if (dic == null && value != null) {        dic = new COSDictionary();        setItem(embedded, dic);    }    if (dic != null) {        dic.setString(key, value);    }}
public void pdfbox_f2487_0(String key, int value)
{    setInt(COSName.getPDFName(key), value);}
public void pdfbox_f2488_0(COSName key, int value)
{    setItem(key, COSInteger.get(value));}
public void pdfbox_f2489_0(String key, long value)
{    setLong(COSName.getPDFName(key), value);}
public void pdfbox_f2490_0(COSName key, long value)
{    COSInteger intVal = COSInteger.get(value);    setItem(key, intVal);}
public void pdfbox_f2491_0(String embeddedDictionary, String key, int value)
{    setEmbeddedInt(embeddedDictionary, COSName.getPDFName(key), value);}
public void pdfbox_f2492_0(String embeddedDictionary, COSName key, int value)
{    COSDictionary embedded = (COSDictionary) getDictionaryObject(embeddedDictionary);    if (embedded == null) {        embedded = new COSDictionary();        setItem(embeddedDictionary, embedded);    }    embedded.setInt(key, value);}
public void pdfbox_f2493_0(String key, float value)
{    setFloat(COSName.getPDFName(key), value);}
public void pdfbox_f2494_0(COSName key, float value)
{    COSFloat fltVal = new COSFloat(value);    setItem(key, fltVal);}
public void pdfbox_f2495_0(COSName field, int bitFlag, boolean value)
{    int currentFlags = getInt(field, 0);    if (value) {        currentFlags = currentFlags | bitFlag;    } else {        currentFlags &= ~bitFlag;    }    setInt(field, currentFlags);}
public COSName pdfbox_f2496_0(COSName key)
{    COSBase name = getDictionaryObject(key);    if (name instanceof COSName) {        return (COSName) name;    }    return null;}
public COSObject pdfbox_f2497_0(COSName key)
{    COSBase object = getItem(key);    if (object instanceof COSObject) {        return (COSObject) object;    }    return null;}
public COSDictionary pdfbox_f2498_0(COSName key)
{    COSBase dictionary = getDictionaryObject(key);    if (dictionary instanceof COSDictionary) {        return (COSDictionary) dictionary;    }    return null;}
public COSStream pdfbox_f2499_0(COSName key)
{    COSBase base = getDictionaryObject(key);    if (base instanceof COSStream) {        return (COSStream) base;    }    return null;}
public COSArray pdfbox_f2500_0(COSName key)
{    COSBase array = getDictionaryObject(key);    if (array instanceof COSArray) {        return (COSArray) array;    }    return null;}
public COSName pdfbox_f2501_0(COSName key, COSName defaultValue)
{    COSBase name = getDictionaryObject(key);    if (name instanceof COSName) {        return (COSName) name;    }    return defaultValue;}
public String pdfbox_f2502_0(String key)
{    return getNameAsString(COSName.getPDFName(key));}
public String pdfbox_f2503_0(COSName key)
{    String retval = null;    COSBase name = getDictionaryObject(key);    if (name instanceof COSName) {        retval = ((COSName) name).getName();    } else if (name instanceof COSString) {        retval = ((COSString) name).getString();    }    return retval;}
public String pdfbox_f2504_0(String key, String defaultValue)
{    return getNameAsString(COSName.getPDFName(key), defaultValue);}
public String pdfbox_f2505_0(COSName key, String defaultValue)
{    String retval = getNameAsString(key);    if (retval == null) {        retval = defaultValue;    }    return retval;}
public String pdfbox_f2506_0(String key)
{    return getString(COSName.getPDFName(key));}
public String pdfbox_f2507_0(COSName key)
{    String retval = null;    COSBase value = getDictionaryObject(key);    if (value instanceof COSString) {        retval = ((COSString) value).getString();    }    return retval;}
public String pdfbox_f2508_0(String key, String defaultValue)
{    return getString(COSName.getPDFName(key), defaultValue);}
public String pdfbox_f2509_0(COSName key, String defaultValue)
{    String retval = getString(key);    if (retval == null) {        retval = defaultValue;    }    return retval;}
public String pdfbox_f2510_0(String embedded, String key)
{    return getEmbeddedString(embedded, COSName.getPDFName(key), null);}
public String pdfbox_f2511_0(String embedded, COSName key)
{    return getEmbeddedString(embedded, key, null);}
public String pdfbox_f2512_0(String embedded, String key, String defaultValue)
{    return getEmbeddedString(embedded, COSName.getPDFName(key), defaultValue);}
public String pdfbox_f2513_0(String embedded, COSName key, String defaultValue)
{    String retval = defaultValue;    COSBase base = getDictionaryObject(embedded);    if (base instanceof COSDictionary) {        retval = ((COSDictionary) base).getString(key, defaultValue);    }    return retval;}
public Calendar pdfbox_f2514_0(String key)
{    return getDate(COSName.getPDFName(key));}
public Calendar pdfbox_f2515_0(COSName key)
{    COSBase base = getDictionaryObject(key);    if (base instanceof COSString) {        return DateConverter.toCalendar((COSString) base);    }    return null;}
public Calendar pdfbox_f2516_0(String key, Calendar defaultValue)
{    return getDate(COSName.getPDFName(key), defaultValue);}
public Calendar pdfbox_f2517_0(COSName key, Calendar defaultValue)
{    Calendar retval = getDate(key);    if (retval == null) {        retval = defaultValue;    }    return retval;}
public Calendar pdfbox_f2518_0(String embedded, String key)
{    return getEmbeddedDate(embedded, COSName.getPDFName(key), null);}
public Calendar pdfbox_f2519_0(String embedded, COSName key)
{    return getEmbeddedDate(embedded, key, null);}
public Calendar pdfbox_f2520_0(String embedded, String key, Calendar defaultValue)
{    return getEmbeddedDate(embedded, COSName.getPDFName(key), defaultValue);}
public Calendar pdfbox_f2521_0(String embedded, COSName key, Calendar defaultValue)
{    Calendar retval = defaultValue;    COSDictionary eDic = (COSDictionary) getDictionaryObject(embedded);    if (eDic != null) {        retval = eDic.getDate(key, defaultValue);    }    return retval;}
public boolean pdfbox_f2522_0(String key, boolean defaultValue)
{    return getBoolean(COSName.getPDFName(key), defaultValue);}
public boolean pdfbox_f2523_0(COSName key, boolean defaultValue)
{    return getBoolean(key, null, defaultValue);}
public boolean pdfbox_f2524_0(COSName firstKey, COSName secondKey, boolean defaultValue)
{    boolean retval = defaultValue;    COSBase bool = getDictionaryObject(firstKey, secondKey);    if (bool instanceof COSBoolean) {        retval = ((COSBoolean) bool).getValue();    }    return retval;}
public int pdfbox_f2525_0(String embeddedDictionary, String key)
{    return getEmbeddedInt(embeddedDictionary, COSName.getPDFName(key));}
public int pdfbox_f2526_0(String embeddedDictionary, COSName key)
{    return getEmbeddedInt(embeddedDictionary, key, -1);}
public int pdfbox_f2527_0(String embeddedDictionary, String key, int defaultValue)
{    return getEmbeddedInt(embeddedDictionary, COSName.getPDFName(key), defaultValue);}
public int pdfbox_f2528_0(String embeddedDictionary, COSName key, int defaultValue)
{    int retval = defaultValue;    COSDictionary embedded = (COSDictionary) getDictionaryObject(embeddedDictionary);    if (embedded != null) {        retval = embedded.getInt(key, defaultValue);    }    return retval;}
public int pdfbox_f2529_0(String key)
{    return getInt(COSName.getPDFName(key), -1);}
public int pdfbox_f2530_0(COSName key)
{    return getInt(key, -1);}
public int pdfbox_f2531_0(String key, int defaultValue)
{    return getInt(COSName.getPDFName(key), defaultValue);}
public int pdfbox_f2532_0(COSName key, int defaultValue)
{    return getInt(key, null, defaultValue);}
public int pdfbox_f2533_0(COSName firstKey, COSName secondKey)
{    return getInt(firstKey, secondKey, -1);}
public int pdfbox_f2534_0(COSName firstKey, COSName secondKey, int defaultValue)
{    int retval = defaultValue;    COSBase obj = getDictionaryObject(firstKey, secondKey);    if (obj instanceof COSNumber) {        retval = ((COSNumber) obj).intValue();    }    return retval;}
public long pdfbox_f2535_0(String key)
{    return getLong(COSName.getPDFName(key), -1L);}
public long pdfbox_f2536_0(COSName key)
{    return getLong(key, -1L);}
public long pdfbox_f2537_0(String key, long defaultValue)
{    return getLong(COSName.getPDFName(key), defaultValue);}
public long pdfbox_f2538_0(COSName key, long defaultValue)
{    long retval = defaultValue;    COSBase obj = getDictionaryObject(key);    if (obj instanceof COSNumber) {        retval = ((COSNumber) obj).longValue();    }    return retval;}
public float pdfbox_f2539_0(String key)
{    return getFloat(COSName.getPDFName(key), -1);}
public float pdfbox_f2540_0(COSName key)
{    return getFloat(key, -1);}
public float pdfbox_f2541_0(String key, float defaultValue)
{    return getFloat(COSName.getPDFName(key), defaultValue);}
public float pdfbox_f2542_0(COSName key, float defaultValue)
{    float retval = defaultValue;    COSBase obj = getDictionaryObject(key);    if (obj instanceof COSNumber) {        retval = ((COSNumber) obj).floatValue();    }    return retval;}
public boolean pdfbox_f2543_0(COSName field, int bitFlag)
{    int ff = getInt(field, 0);    return (ff & bitFlag) == bitFlag;}
public void pdfbox_f2544_0(COSName key)
{    items.remove(key);}
public COSBase pdfbox_f2545_0(COSName key)
{    return items.get(key);}
public COSBase pdfbox_f2546_0(String key)
{    return getItem(COSName.getPDFName(key));}
public COSBase pdfbox_f2547_0(COSName firstKey, COSName secondKey)
{    COSBase retval = getItem(firstKey);    if (retval == null && secondKey != null) {        retval = getItem(secondKey);    }    return retval;}
public Set<COSName> pdfbox_f2548_0()
{    return items.keySet();}
public Set<Map.Entry<COSName, COSBase>> pdfbox_f2549_0()
{    return items.entrySet();}
public Collection<COSBase> pdfbox_f2550_0()
{    return items.values();}
public Object pdfbox_f2551_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromDictionary(this);}
public boolean pdfbox_f2552_0()
{    return needToBeUpdated;}
public void pdfbox_f2553_0(boolean flag)
{    needToBeUpdated = flag;}
public void pdfbox_f2554_0(COSDictionary dic)
{    for (Map.Entry<COSName, COSBase> entry : dic.entrySet()) {        /*             * If we're at a second trailer, we have a linearized pdf file, meaning that the first Size entry represents             * all of the objects so we don't need to grab the second.             */        if (!COSName.SIZE.equals(entry.getKey()) || !items.containsKey(COSName.SIZE)) {            setItem(entry.getKey(), entry.getValue());        }    }}
public boolean pdfbox_f2555_0(COSName name)
{    return this.items.containsKey(name);}
public boolean pdfbox_f2556_0(String name)
{    return containsKey(COSName.getPDFName(name));}
public COSBase pdfbox_f2557_0(String objPath)
{    String[] path = objPath.split(PATH_SEPARATOR);    COSBase retval = this;    for (String pathString : path) {        if (retval instanceof COSArray) {            int idx = Integer.parseInt(pathString.replaceAll("\\[", "").replaceAll("\\]", ""));            retval = ((COSArray) retval).getObject(idx);        } else if (retval instanceof COSDictionary) {            retval = ((COSDictionary) retval).getDictionaryObject(pathString);        }    }    return retval;}
public COSDictionary pdfbox_f2558_0()
{    return new UnmodifiableCOSDictionary(this);}
public String pdfbox_f2559_1()
{    try {        return getDictionaryString(this, new ArrayList<COSBase>());    } catch (IOException e) {                return "COSDictionary{" + e.getMessage() + "}";    }}
private static String pdfbox_f2560_0(COSBase base, List<COSBase> objs) throws IOException
{    if (base == null) {        return "null";    }    if (objs.contains(base)) {                return String.valueOf(base.hashCode());    }    objs.add(base);    if (base instanceof COSDictionary) {        StringBuilder sb = new StringBuilder();        sb.append("COSDictionary{");        for (Map.Entry<COSName, COSBase> x : ((COSDictionary) base).entrySet()) {            sb.append(x.getKey());            sb.append(":");            sb.append(getDictionaryString(x.getValue(), objs));            sb.append(";");        }        sb.append("}");        if (base instanceof COSStream) {            try (InputStream stream = ((COSStream) base).createRawInputStream()) {                byte[] b = IOUtils.toByteArray(stream);                sb.append("COSStream{").append(Arrays.hashCode(b)).append("}");            }        }        return sb.toString();    }    if (base instanceof COSArray) {        StringBuilder sb = new StringBuilder();        sb.append("COSArray{");        for (COSBase x : ((COSArray) base).toList()) {            sb.append(getDictionaryString(x, objs));            sb.append(";");        }        sb.append("}");        return sb.toString();    }    if (base instanceof COSObject) {        COSObject obj = (COSObject) base;        return "COSObject{" + getDictionaryString(obj.getObject(), objs) + "}";    }    return base.toString();}
public COSStream pdfbox_f2561_0()
{    COSStream stream = new COSStream(scratchFile);                streams.add(stream);    return stream;}
public COSStream pdfbox_f2562_0(COSDictionary dictionary)
{    COSStream stream = new COSStream(scratchFile);    for (Map.Entry<COSName, COSBase> entry : dictionary.entrySet()) {        stream.setItem(entry.getKey(), entry.getValue());    }    return stream;}
public COSObject pdfbox_f2563_1(COSName type)
{    for (COSObject object : objectPool.values()) {        COSBase realObject = object.getObject();        if (realObject instanceof COSDictionary) {            try {                COSDictionary dic = (COSDictionary) realObject;                COSBase typeItem = dic.getItem(COSName.TYPE);                if (typeItem instanceof COSName) {                    COSName objectType = (COSName) typeItem;                    if (objectType.equals(type)) {                        return object;                    }                } else if (typeItem != null) {                                    }            } catch (ClassCastException e) {                            }        }    }    return null;}
public List<COSObject> pdfbox_f2564_0(String type)
{    return getObjectsByType(COSName.getPDFName(type));}
public List<COSObject> pdfbox_f2565_1(COSName type)
{    List<COSObject> retval = new ArrayList<>();    for (COSObject object : objectPool.values()) {        COSBase realObject = object.getObject();        if (realObject instanceof COSDictionary) {            try {                COSDictionary dic = (COSDictionary) realObject;                COSBase typeItem = dic.getItem(COSName.TYPE);                if (typeItem instanceof COSName) {                    COSName objectType = (COSName) typeItem;                    if (objectType.equals(type)) {                        retval.add(object);                    }                } else if (typeItem != null) {                                    }            } catch (ClassCastException e) {                            }        }    }    return retval;}
public COSObjectKey pdfbox_f2566_0(COSBase object)
{    for (Map.Entry<COSObjectKey, COSObject> entry : objectPool.entrySet()) {        if (entry.getValue().getObject() == object) {            return entry.getKey();        }    }    return null;}
public void pdfbox_f2567_0()
{    for (COSObject object : objectPool.values()) {        System.out.println(object);    }}
public void pdfbox_f2568_0(float versionValue)
{    version = versionValue;}
public float pdfbox_f2569_0()
{    return version;}
public void pdfbox_f2570_0()
{    isDecrypted = true;}
public boolean pdfbox_f2571_0()
{    return isDecrypted;}
public boolean pdfbox_f2572_0()
{    boolean encrypted = false;    if (trailer != null) {        encrypted = trailer.getDictionaryObject(COSName.ENCRYPT) instanceof COSDictionary;    }    return encrypted;}
public COSDictionary pdfbox_f2573_0()
{    return trailer.getCOSDictionary(COSName.ENCRYPT);}
public void pdfbox_f2574_0(COSDictionary encDictionary)
{    trailer.setItem(COSName.ENCRYPT, encDictionary);}
public COSArray pdfbox_f2575_0()
{    return getTrailer().getCOSArray(COSName.ID);}
public void pdfbox_f2576_0(COSArray id)
{    getTrailer().setItem(COSName.ID, id);}
public List<COSObject> pdfbox_f2577_0()
{    return new ArrayList<>(objectPool.values());}
public COSDictionary pdfbox_f2578_0()
{    return trailer;}
public void pdfbox_f2579_0(COSDictionary newTrailer)
{    trailer = newTrailer;}
public long pdfbox_f2580_0()
{    return highestXRefObjectNumber;}
public void pdfbox_f2581_0(long highestXRefObjectNumber)
{    this.highestXRefObjectNumber = highestXRefObjectNumber;}
public Object pdfbox_f2582_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromDocument(this);}
public void pdfbox_f2583_0() throws IOException
{    if (!closed) {                                                IOException firstException = null;                for (COSObject object : getObjects()) {            COSBase cosObject = object.getObject();            if (cosObject instanceof COSStream) {                firstException = IOUtils.closeAndLogException((COSStream) cosObject, LOG, "COSStream", firstException);            }        }        for (COSStream stream : streams) {            firstException = IOUtils.closeAndLogException(stream, LOG, "COSStream", firstException);        }        if (scratchFile != null) {            firstException = IOUtils.closeAndLogException(scratchFile, LOG, "ScratchFile", firstException);        }        closed = true;                if (firstException != null) {            throw firstException;        }    }}
public boolean pdfbox_f2584_0()
{    return closed;}
protected void pdfbox_f2585_1() throws IOException
{    if (!closed) {        if (warnMissingClose) {                    }        close();    }}
public void pdfbox_f2586_0(boolean warn)
{    this.warnMissingClose = warn;}
public void pdfbox_f2587_0() throws IOException
{    for (COSObject objStream : getObjectsByType(COSName.OBJ_STM)) {        COSStream stream = (COSStream) objStream.getObject();        PDFObjectStreamParser parser = new PDFObjectStreamParser(stream, this);        parser.parse();        for (COSObject next : parser.getObjects()) {            COSObjectKey key = new COSObjectKey(next);            if (objectPool.get(key) == null || objectPool.get(key).getObject() == null ||             (xrefTable.containsKey(key) && xrefTable.get(key) == -objStream.getObjectNumber())) {                COSObject obj = getObjectFromPool(key);                obj.setObject(next.getObject());            }        }    }}
public COSObject pdfbox_f2588_0(COSObjectKey key)
{    COSObject obj = null;    if (key != null) {        obj = objectPool.get(key);    }    if (obj == null) {                obj = new COSObject(null);        if (key != null) {            obj.setObjectNumber(key.getNumber());            obj.setGenerationNumber(key.getGeneration());            objectPool.put(key, obj);        }    }    return obj;}
public COSObject pdfbox_f2589_0(COSObjectKey key)
{    return objectPool.remove(key);}
public void pdfbox_f2590_0(Map<COSObjectKey, Long> xrefTableValues)
{    xrefTable.putAll(xrefTableValues);}
public Map<COSObjectKey, Long> pdfbox_f2591_0()
{    return xrefTable;}
public void pdfbox_f2592_0(long startXrefValue)
{    startXref = startXrefValue;}
public long pdfbox_f2593_0()
{    return startXref;}
public boolean pdfbox_f2594_0()
{    return isXRefStream;}
public void pdfbox_f2595_0(boolean isXRefStreamValue)
{    isXRefStream = isXRefStreamValue;}
private void pdfbox_f2596_0()
{    float floatValue = value.floatValue();    double doubleValue = value.doubleValue();    boolean valueReplaced = false;        if (Float.isInfinite(floatValue)) {        if (Math.abs(doubleValue) > Float.MAX_VALUE) {            floatValue = Float.MAX_VALUE * (Float.compare(floatValue, Float.POSITIVE_INFINITY) == 0 ? 1 : -1);            valueReplaced = true;        }    } else     if (Float.compare(floatValue, 0) == 0 && Double.compare(doubleValue, 0) != 0) {        if (Math.abs(doubleValue) < Float.MIN_NORMAL) {            floatValue = Float.MIN_NORMAL;            floatValue *= doubleValue >= 0 ? 1 : -1;            valueReplaced = true;        }    }    if (valueReplaced) {        value = BigDecimal.valueOf(floatValue);        valueAsString = removeNullDigits(value.toPlainString());    }}
private String pdfbox_f2597_0(String plainStringValue)
{        if (plainStringValue.indexOf('.') > -1 && !plainStringValue.endsWith(".0")) {        while (plainStringValue.endsWith("0") && !plainStringValue.endsWith(".0")) {            plainStringValue = plainStringValue.substring(0, plainStringValue.length() - 1);        }    }    return plainStringValue;}
public float pdfbox_f2598_0()
{    return value.floatValue();}
public double pdfbox_f2599_0()
{    return value.doubleValue();}
public long pdfbox_f2600_0()
{    return value.longValue();}
public int pdfbox_f2601_0()
{    return value.intValue();}
public boolean pdfbox_f2602_0(Object o)
{    return o instanceof COSFloat && Float.floatToIntBits(((COSFloat) o).value.floatValue()) == Float.floatToIntBits(value.floatValue());}
public int pdfbox_f2603_0()
{    return value.hashCode();}
public String pdfbox_f2604_0()
{    return "COSFloat{" + valueAsString + "}";}
public Object pdfbox_f2605_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromFloat(this);}
public void pdfbox_f2606_0(OutputStream output) throws IOException
{    output.write(valueAsString.getBytes("ISO-8859-1"));}
 static COSInputStream pdfbox_f2607_0(List<Filter> filters, COSDictionary parameters, InputStream in, ScratchFile scratchFile) throws IOException
{    return create(filters, parameters, in, scratchFile, DecodeOptions.DEFAULT);}
 static COSInputStream pdfbox_f2608_0(List<Filter> filters, COSDictionary parameters, InputStream in, ScratchFile scratchFile, DecodeOptions options) throws IOException
{    List<DecodeResult> results = new ArrayList<>();    InputStream input = in;    if (filters.isEmpty()) {        input = in;    } else {        Set<Filter> filterSet = new HashSet<>(filters);        if (filterSet.size() != filters.size()) {            throw new IOException("Duplicate");        }                for (int i = 0; i < filters.size(); i++) {            if (scratchFile != null) {                                final RandomAccess buffer = scratchFile.createBuffer();                DecodeResult result = filters.get(i).decode(input, new RandomAccessOutputStream(buffer), parameters, i, options);                results.add(result);                input = new RandomAccessInputStream(buffer) {                    @Override                    public void close() throws IOException {                        buffer.close();                    }                };            } else {                                ByteArrayOutputStream output = new ByteArrayOutputStream();                DecodeResult result = filters.get(i).decode(input, output, parameters, i, options);                results.add(result);                input = new ByteArrayInputStream(output.toByteArray());            }        }    }    return new COSInputStream(input, results);}
public void pdfbox_f2609_0() throws IOException
{    buffer.close();}
public DecodeResult pdfbox_f2610_0()
{    if (decodeResults.isEmpty()) {        return DecodeResult.DEFAULT;    } else {        return decodeResults.get(decodeResults.size() - 1);    }}
public static COSInteger pdfbox_f2611_0(long val)
{    if (LOW <= val && val <= HIGH) {        int index = (int) val - LOW;                if (STATIC[index] == null) {            STATIC[index] = new COSInteger(val);        }        return STATIC[index];    }    return new COSInteger(val);}
public boolean pdfbox_f2612_0(Object o)
{    return o instanceof COSInteger && ((COSInteger) o).intValue() == intValue();}
public int pdfbox_f2613_0()
{        return (int) (value ^ (value >> 32));}
public String pdfbox_f2614_0()
{    return "COSInt{" + value + "}";}
public float pdfbox_f2615_0()
{    return value;}
public double pdfbox_f2616_0()
{    return value;}
public int pdfbox_f2617_0()
{    return (int) value;}
public long pdfbox_f2618_0()
{    return value;}
public Object pdfbox_f2619_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromInt(this);}
public void pdfbox_f2620_0(OutputStream output) throws IOException
{    output.write(String.valueOf(value).getBytes("ISO-8859-1"));}
public static COSName pdfbox_f2621_0(String aName)
{    COSName name = null;    if (aName != null) {                name = commonNameMap.get(aName);        if (name == null) {                        name = nameMap.get(aName);            if (name == null) {                                name = new COSName(aName, false);            }        }    }    return name;}
public String pdfbox_f2622_0()
{    return name;}
public String pdfbox_f2623_0()
{    return "COSName{" + name + "}";}
public boolean pdfbox_f2624_0(Object object)
{    return object instanceof COSName && name.equals(((COSName) object).name);}
public int pdfbox_f2625_0()
{    return hashCode;}
public int pdfbox_f2626_0(COSName other)
{    return name.compareTo(other.name);}
public boolean pdfbox_f2627_0()
{    return name.isEmpty();}
public Object pdfbox_f2628_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromName(this);}
public void pdfbox_f2629_0(OutputStream output) throws IOException
{    output.write('/');    byte[] bytes = getName().getBytes(Charsets.UTF_8);    for (byte b : bytes) {        int current = b & 0xFF;                if (current >= 'A' && current <= 'Z' || current >= 'a' && current <= 'z' || current >= '0' && current <= '9' || current == '+' || current == '-' || current == '_' || current == '@' || current == '*' || current == '$' || current == ';' || current == '.') {            output.write(current);        } else {            output.write('#');            Hex.writeHexByte(b, output);        }    }}
public static synchronized void pdfbox_f2630_0()
{        nameMap.clear();}
public Object pdfbox_f2631_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromNull(this);}
public void pdfbox_f2632_0(OutputStream output) throws IOException
{    output.write(NULL_BYTES);}
public String pdfbox_f2633_0()
{    return "COSNull{}";}
public static COSNumber pdfbox_f2634_0(String number) throws IOException
{    if (number.length() == 1) {        char digit = number.charAt(0);        if ('0' <= digit && digit <= '9') {            return COSInteger.get(digit - '0');        } else if (digit == '-' || digit == '.') {                        return COSInteger.ZERO;        } else {            throw new IOException("Not a number: " + number);        }    } else if (number.indexOf('.') == -1 && (number.toLowerCase().indexOf('e') == -1)) {        try {            if (number.charAt(0) == '+') {                return COSInteger.get(Long.parseLong(number.substring(1)));            }            return COSInteger.get(Long.parseLong(number));        } catch (NumberFormatException e) {                        return new COSFloat(number);        }    } else {        return new COSFloat(number);    }}
public COSBase pdfbox_f2635_0(COSName key)
{    COSBase retval = null;    if (baseObject instanceof COSDictionary) {        retval = ((COSDictionary) baseObject).getDictionaryObject(key);    }    return retval;}
public COSBase pdfbox_f2636_0(COSName key)
{    COSBase retval = null;    if (baseObject instanceof COSDictionary) {        retval = ((COSDictionary) baseObject).getItem(key);    }    return retval;}
public COSBase pdfbox_f2637_0()
{    return baseObject;}
public final void pdfbox_f2638_0(COSBase object)
{    baseObject = object;}
public String pdfbox_f2639_0()
{    return "COSObject{" + Long.toString(objectNumber) + ", " + Integer.toString(generationNumber) + "}";}
public long pdfbox_f2640_0()
{    return objectNumber;}
public void pdfbox_f2641_0(long objectNum)
{    objectNumber = objectNum;}
public int pdfbox_f2642_0()
{    return generationNumber;}
public void pdfbox_f2643_0(int generationNumberValue)
{    generationNumber = generationNumberValue;}
public Object pdfbox_f2644_0(ICOSVisitor visitor) throws IOException
{    return getObject() != null ? getObject().accept(visitor) : COSNull.NULL.accept(visitor);}
public boolean pdfbox_f2645_0()
{    return needToBeUpdated;}
public void pdfbox_f2646_0(boolean flag)
{    needToBeUpdated = flag;}
public boolean pdfbox_f2647_0(Object obj)
{    COSObjectKey objToBeCompared = obj instanceof COSObjectKey ? (COSObjectKey) obj : null;    return objToBeCompared != null && objToBeCompared.getNumber() == getNumber() && objToBeCompared.getGeneration() == getGeneration();}
public int pdfbox_f2648_0()
{    return generation;}
public void pdfbox_f2649_0(int genNumber)
{    generation = genNumber;}
public long pdfbox_f2650_0()
{    return number;}
public int pdfbox_f2651_0()
{    return Long.valueOf(number + generation).hashCode();}
public String pdfbox_f2652_0()
{    return Long.toString(number) + " " + Integer.toString(generation) + " R";}
public int pdfbox_f2653_0(COSObjectKey other)
{    int result = Long.compare(getNumber(), other.getNumber());    if (result == 0) {        return Integer.compare(getGeneration(), other.getGeneration());    }    return result;}
public void pdfbox_f2654_0(byte[] b) throws IOException
{    if (buffer != null) {        buffer.write(b);    } else {        super.write(b);    }}
public void pdfbox_f2655_0(byte[] b, int off, int len) throws IOException
{    if (buffer != null) {        buffer.write(b, off, len);    } else {        super.write(b, off, len);    }}
public void pdfbox_f2656_0(int b) throws IOException
{    if (buffer != null) {        buffer.write(b);    } else {        super.write(b);    }}
public void pdfbox_f2658_0() throws IOException
{    try {        if (buffer != null) {            try {                                for (int i = filters.size() - 1; i >= 0; i--) {                    try (InputStream unfilteredIn = new RandomAccessInputStream(buffer)) {                        if (i == 0) {                            /*                                 * The last filter to run can encode directly to the enclosed output                                 * stream.                                 */                            filters.get(i).encode(unfilteredIn, out, parameters, i);                        } else {                            RandomAccess filteredBuffer = scratchFile.createBuffer();                            try {                                try (OutputStream filteredOut = new RandomAccessOutputStream(filteredBuffer)) {                                    filters.get(i).encode(unfilteredIn, filteredOut, parameters, i);                                }                                RandomAccess tmpSwap = filteredBuffer;                                filteredBuffer = buffer;                                buffer = tmpSwap;                            } finally {                                filteredBuffer.close();                            }                        }                    }                }            } finally {                buffer.close();                buffer = null;            }        }    } finally {        super.close();    }}
private void pdfbox_f2659_0() throws IOException
{    if (randomAccess != null && randomAccess.isClosed()) {        throw new IOException("COSStream has been closed and cannot be read. " + "Perhaps its enclosing PDDocument has been closed?");            }}
public InputStream pdfbox_f2660_0() throws IOException
{    return createRawInputStream();}
private void pdfbox_f2661_1(boolean forInputStream) throws IOException
{    if (randomAccess == null) {        if (forInputStream && LOG.isDebugEnabled()) {                                }        randomAccess = scratchFile.createBuffer();    }}
public InputStream pdfbox_f2662_0() throws IOException
{    checkClosed();    if (isWriting) {        throw new IllegalStateException("Cannot read while there is an open stream writer");    }    ensureRandomAccessExists(true);    return new RandomAccessInputStream(randomAccess);}
public InputStream pdfbox_f2663_0() throws IOException
{    return createInputStream();}
public COSInputStream pdfbox_f2664_0() throws IOException
{    return createInputStream(DecodeOptions.DEFAULT);}
public COSInputStream pdfbox_f2665_0(DecodeOptions options) throws IOException
{    checkClosed();    if (isWriting) {        throw new IllegalStateException("Cannot read while there is an open stream writer");    }    ensureRandomAccessExists(true);    InputStream input = new RandomAccessInputStream(randomAccess);    return COSInputStream.create(getFilterList(), this, input, scratchFile, options);}
public OutputStream pdfbox_f2666_0() throws IOException
{    return createOutputStream();}
public OutputStream pdfbox_f2667_0() throws IOException
{    return createOutputStream(null);}
public OutputStream pdfbox_f2668_0(COSBase filters) throws IOException
{    checkClosed();    if (isWriting) {        throw new IllegalStateException("Cannot have more than one open stream writer.");    }        if (filters != null) {        setItem(COSName.FILTER, filters);    }    IOUtils.closeQuietly(randomAccess);    randomAccess = scratchFile.createBuffer();    OutputStream randomOut = new RandomAccessOutputStream(randomAccess);    OutputStream cosOut = new COSOutputStream(getFilterList(), this, randomOut, scratchFile);    isWriting = true;    return new FilterOutputStream(cosOut) {        @Override        public void write(byte[] b, int off, int len) throws IOException {            this.out.write(b, off, len);        }        @Override        public void close() throws IOException {            super.close();            setInt(COSName.LENGTH, (int) randomAccess.length());            isWriting = false;        }    };}
public void pdfbox_f2669_0(byte[] b, int off, int len) throws IOException
{    this.out.write(b, off, len);}
public void pdfbox_f2670_0() throws IOException
{    super.close();    setInt(COSName.LENGTH, (int) randomAccess.length());    isWriting = false;}
public OutputStream pdfbox_f2671_0() throws IOException
{    return createRawOutputStream();}
public OutputStream pdfbox_f2672_0() throws IOException
{    checkClosed();    if (isWriting) {        throw new IllegalStateException("Cannot have more than one open stream writer.");    }    IOUtils.closeQuietly(randomAccess);    randomAccess = scratchFile.createBuffer();    OutputStream out = new RandomAccessOutputStream(randomAccess);    isWriting = true;    return new FilterOutputStream(out) {        @Override        public void write(byte[] b, int off, int len) throws IOException {            this.out.write(b, off, len);        }        @Override        public void close() throws IOException {            super.close();            setInt(COSName.LENGTH, (int) randomAccess.length());            isWriting = false;        }    };}
public void pdfbox_f2673_0(byte[] b, int off, int len) throws IOException
{    this.out.write(b, off, len);}
public void pdfbox_f2674_0() throws IOException
{    super.close();    setInt(COSName.LENGTH, (int) randomAccess.length());    isWriting = false;}
private List<Filter> pdfbox_f2675_0() throws IOException
{    List<Filter> filterList = new ArrayList<>();    COSBase filters = getFilters();    if (filters instanceof COSName) {        filterList.add(FilterFactory.INSTANCE.getFilter((COSName) filters));    } else if (filters instanceof COSArray) {        COSArray filterArray = (COSArray) filters;        for (int i = 0; i < filterArray.size(); i++) {            COSName filterName = (COSName) filterArray.get(i);            filterList.add(FilterFactory.INSTANCE.getFilter(filterName));        }    }    return filterList;}
public long pdfbox_f2676_0()
{    if (isWriting) {        throw new IllegalStateException("There is an open OutputStream associated with " + "this COSStream. It must be closed before querying" + "length of this COSStream.");    }    return getInt(COSName.LENGTH, 0);}
public COSBase pdfbox_f2677_0()
{    return getDictionaryObject(COSName.FILTER);}
public void pdfbox_f2678_0(COSBase filters) throws IOException
{    setItem(COSName.FILTER, filters);}
public String pdfbox_f2679_0()
{    return toTextString();}
public String pdfbox_f2680_1()
{    ByteArrayOutputStream out = new ByteArrayOutputStream();    InputStream input = null;    try {        input = createInputStream();        IOUtils.copy(input, out);    } catch (IOException e) {                return "";    } finally {        IOUtils.closeQuietly(input);    }    COSString string = new COSString(out.toByteArray());    return string.getString();}
public Object pdfbox_f2681_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromStream(this);}
public void pdfbox_f2682_0() throws IOException
{        if (randomAccess != null) {        randomAccess.close();    }}
public static COSString pdfbox_f2683_1(String hex) throws IOException
{    ByteArrayOutputStream bytes = new ByteArrayOutputStream();    StringBuilder hexBuffer = new StringBuilder(hex.trim());        if (hexBuffer.length() % 2 != 0) {        hexBuffer.append('0');    }    int length = hexBuffer.length();    for (int i = 0; i < length; i += 2) {        try {            bytes.write(Integer.parseInt(hexBuffer.substring(i, i + 2), 16));        } catch (NumberFormatException e) {            if (FORCE_PARSING) {                                                bytes.write('?');            } else {                throw new IOException("Invalid hex string: " + hex, e);            }        }    }    return new COSString(bytes.toByteArray());}
public void pdfbox_f2684_0(byte[] value)
{    bytes = value.clone();}
public void pdfbox_f2685_0(boolean value)
{    this.forceHexForm = value;}
public boolean pdfbox_f2686_0()
{    return forceHexForm;}
public String pdfbox_f2687_0()
{        if (bytes.length >= 2) {        if ((bytes[0] & 0xff) == 0xFE && (bytes[1] & 0xff) == 0xFF) {                        return new String(bytes, 2, bytes.length - 2, Charsets.UTF_16BE);        } else if ((bytes[0] & 0xff) == 0xFF && (bytes[1] & 0xff) == 0xFE) {                        return new String(bytes, 2, bytes.length - 2, Charsets.UTF_16LE);        }    }        return PDFDocEncoding.toString(bytes);}
public String pdfbox_f2688_0()
{        return new String(bytes, Charsets.US_ASCII);}
public byte[] pdfbox_f2689_0()
{    return bytes;}
public String pdfbox_f2690_0()
{    return Hex.getString(bytes);}
public Object pdfbox_f2691_0(ICOSVisitor visitor) throws IOException
{    return visitor.visitFromString(this);}
public boolean pdfbox_f2692_0(Object obj)
{    if (obj instanceof COSString) {        COSString strObj = (COSString) obj;        return getString().equals(strObj.getString()) && forceHexForm == strObj.forceHexForm;    }    return false;}
public int pdfbox_f2693_0()
{    int result = Arrays.hashCode(bytes);    return result + (forceHexForm ? 17 : 0);}
public String pdfbox_f2694_0()
{    return "COSString{" + getString() + "}";}
private static void pdfbox_f2695_0(int code, char unicode)
{    CODE_TO_UNI[code] = unicode;    UNI_TO_CODE.put(unicode, code);}
public static String pdfbox_f2696_0(byte[] bytes)
{    StringBuilder sb = new StringBuilder();    for (byte b : bytes) {        if ((b & 0xff) >= CODE_TO_UNI.length) {            sb.append('?');        } else {            sb.append((char) CODE_TO_UNI[b & 0xff]);        }    }    return sb.toString();}
public static byte[] pdfbox_f2697_0(String text)
{    ByteArrayOutputStream out = new ByteArrayOutputStream();    for (char c : text.toCharArray()) {        Integer code = UNI_TO_CODE.get(c);        if (code == null) {            out.write(0);        } else {            out.write(code);        }    }    return out.toByteArray();}
public static boolean pdfbox_f2698_0(char character)
{    return UNI_TO_CODE.containsKey(character);}
public void pdfbox_f2699_0()
{    throw new UnsupportedOperationException();}
public void pdfbox_f2700_0(COSName key, COSBase value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2701_0(COSName key, COSObjectable value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2702_0(String key, COSObjectable value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2703_0(String key, boolean value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2704_0(COSName key, boolean value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2705_0(String key, COSBase value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2706_0(String key, String value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2707_0(COSName key, String value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2708_0(String key, Calendar date)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2709_0(COSName key, Calendar date)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2710_0(String embedded, String key, Calendar date)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2711_0(String embedded, COSName key, Calendar date)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2712_0(String key, String value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2713_0(COSName key, String value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2714_0(String embedded, String key, String value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2715_0(String embedded, COSName key, String value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2716_0(String key, int value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2717_0(COSName key, int value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2718_0(String key, long value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2719_0(COSName key, long value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2720_0(String embeddedDictionary, String key, int value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2721_0(String embeddedDictionary, COSName key, int value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2722_0(String key, float value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2723_0(COSName key, float value)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2724_0(COSName key)
{    throw new UnsupportedOperationException();}
public void pdfbox_f2725_0(COSDictionary dic)
{    throw new UnsupportedOperationException();}
public DecodeResult pdfbox_f2726_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    try (ASCII85InputStream is = new ASCII85InputStream(encoded)) {        IOUtils.copy(is, decoded);    }    decoded.flush();    return new DecodeResult(parameters);}
protected void pdfbox_f2727_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    try (ASCII85OutputStream os = new ASCII85OutputStream(encoded)) {        IOUtils.copy(input, os);    }    encoded.flush();}
public int pdfbox_f2728_0() throws IOException
{    if (index >= n) {        if (eof) {            return -1;        }        index = 0;        int k;        byte z;        do {            int zz = (byte) in.read();            if (zz == -1) {                eof = true;                return -1;            }            z = (byte) zz;        } while (z == NEWLINE || z == RETURN || z == SPACE);        if (z == TERMINATOR) {            eof = true;            ascii = b = null;            n = 0;            return -1;        } else if (z == Z) {            b[0] = b[1] = b[2] = b[3] = 0;            n = 4;        } else {                        ascii[0] = z;            for (k = 1; k < 5; ++k) {                do {                    int zz = (byte) in.read();                    if (zz == -1) {                        eof = true;                        return -1;                    }                    z = (byte) zz;                } while (z == NEWLINE || z == RETURN || z == SPACE);                ascii[k] = z;                if (z == TERMINATOR) {                                        ascii[k] = (byte) PADDING_U;                    break;                }            }            n = k - 1;            if (n == 0) {                eof = true;                ascii = null;                b = null;                return -1;            }            if (k < 5) {                for (++k; k < 5; ++k) {                                        ascii[k] = (byte) PADDING_U;                }                eof = true;            }                        long t = 0;            for (k = 0; k < 5; ++k) {                z = (byte) (ascii[k] - OFFSET);                if (z < 0 || z > 93) {                    n = 0;                    eof = true;                    ascii = null;                    b = null;                    throw new IOException("Invalid data in Ascii85 stream");                }                t = (t * 85L) + z;            }            for (k = 3; k >= 0; --k) {                b[k] = (byte) (t & 0xFFL);                t >>>= 8;            }        }    }    return b[index++] & 0xFF;}
public int pdfbox_f2729_0(byte[] data, int offset, int len) throws IOException
{    if (eof && index >= n) {        return -1;    }    for (int i = 0; i < len; i++) {        if (index < n) {            data[i + offset] = b[index++];        } else {            int t = read();            if (t == -1) {                return i;            }            data[i + offset] = (byte) t;        }    }    return len;}
public void pdfbox_f2730_0() throws IOException
{    ascii = null;    eof = true;    b = null;    super.close();}
public boolean pdfbox_f2731_0()
{    return false;}
public long pdfbox_f2732_0(long nValue)
{    return 0;}
public int pdfbox_f2733_0()
{    return 0;}
public void pdfbox_f2735_0() throws IOException
{    throw new IOException("Reset is not supported");}
public void pdfbox_f2736_0(char term)
{    if (term < 118 || term > 126 || term == Z) {        throw new IllegalArgumentException("Terminator must be 118-126 excluding z");    }    terminator = term;}
public char pdfbox_f2737_0()
{    return terminator;}
public void pdfbox_f2738_0(int l)
{    if (lineBreak > l) {        lineBreak = l;    }    maxline = l;}
public int pdfbox_f2739_0()
{    return maxline;}
private void pdfbox_f2740_0()
{    long word = ((((indata[0] << 8) | (indata[1] & 0xFF)) << 16) | ((indata[2] & 0xFF) << 8) | (indata[3] & 0xFF)) & 0xFFFFFFFFL;    if (word == 0) {        outdata[0] = (byte) Z;        outdata[1] = 0;        return;    }    long x;    x = word / (85L * 85L * 85L * 85L);    outdata[0] = (byte) (x + OFFSET);    word -= x * 85L * 85L * 85L * 85L;    x = word / (85L * 85L * 85L);    outdata[1] = (byte) (x + OFFSET);    word -= x * 85L * 85L * 85L;    x = word / (85L * 85L);    outdata[2] = (byte) (x + OFFSET);    word -= x * 85L * 85L;    x = word / 85L;    outdata[3] = (byte) (x + OFFSET);    outdata[4] = (byte) ((word % 85L) + OFFSET);}
public void pdfbox_f2741_0(int b) throws IOException
{    flushed = false;    indata[count++] = (byte) b;    if (count < 4) {        return;    }    transformASCII85();    for (int i = 0; i < 5; i++) {        if (outdata[i] == 0) {            break;        }        out.write(outdata[i]);        if (--lineBreak == 0) {            out.write(NEWLINE);            lineBreak = maxline;        }    }    count = 0;}
public void pdfbox_f2742_0() throws IOException
{    if (flushed) {        return;    }    if (count > 0) {        for (int i = count; i < 4; i++) {            indata[i] = 0;        }        transformASCII85();        if (outdata[0] == Z) {            for (            int i = 0;             i < 5;             i++) {                outdata[i] = (byte) OFFSET;            }        }        for (int i = 0; i < count + 1; i++) {            out.write(outdata[i]);            if (--lineBreak == 0) {                out.write(NEWLINE);                lineBreak = maxline;            }        }    }    if (--lineBreak == 0) {        out.write(NEWLINE);    }    out.write(terminator);    out.write('>');    out.write(NEWLINE);    count = 0;    lineBreak = maxline;    flushed = true;    super.flush();}
public void pdfbox_f2743_0() throws IOException
{    try {        flush();        super.close();    } finally {        indata = outdata = null;    }}
public DecodeResult pdfbox_f2744_1(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    int value, firstByte, secondByte;    while ((firstByte = encoded.read()) != -1) {                while (isWhitespace(firstByte)) {            firstByte = encoded.read();        }        if (firstByte == -1 || isEOD(firstByte)) {            break;        }        if (REVERSE_HEX[firstByte] == -1) {                    }        value = REVERSE_HEX[firstByte] * 16;        secondByte = encoded.read();        if (secondByte == -1 || isEOD(secondByte)) {                        decoded.write(value);            break;        }        if (secondByte >= 0) {            if (REVERSE_HEX[secondByte] == -1) {                            }            value += REVERSE_HEX[secondByte];        }        decoded.write(value);    }    decoded.flush();    return new DecodeResult(parameters);}
private boolean pdfbox_f2745_0(int c)
{    return c == 0 || c == 9 || c == 10 || c == 12 || c == 13 || c == 32;}
private boolean pdfbox_f2746_0(int c)
{    return c == '>';}
public void pdfbox_f2747_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    int byteRead;    while ((byteRead = input.read()) != -1) {        Hex.writeHexByte((byte) byteRead, encoded);    }    encoded.flush();}
private void pdfbox_f2748_0() throws IOException
{    if (decodedPos >= decodedLength) {        decodedLength = 0;        try {            decodeRow();        } catch (EOFException e) {                        if (decodedLength != 0) {                throw e;            }                                    decodedLength = -1;        }        decodedPos = 0;    }}
private void pdfbox_f2749_0() throws IOException
{    int index = 0;    boolean white = true;    changesCurrentRowCount = 0;    do {        int completeRun;        if (white) {            completeRun = decodeRun(whiteRunTree);        } else {            completeRun = decodeRun(blackRunTree);        }        if (completeRun == VALUE_EOL) {            continue;        }        index += completeRun;        changesCurrentRow[changesCurrentRowCount++] = index;                white = !white;    } while (index < columns);}
private void pdfbox_f2750_0() throws IOException
{    changesReferenceRowCount = changesCurrentRowCount;    int[] tmp = changesCurrentRow;    changesCurrentRow = changesReferenceRow;    changesReferenceRow = tmp;    boolean white = true;    int index = 0;    changesCurrentRowCount = 0;    mode: while (index < columns) {                Node n = codeTree.root;        while (true) {            n = n.walk(readBit());            if (n == null) {                continue mode;            } else if (n.isLeaf) {                switch(n.value) {                    case VALUE_HMODE:                        int runLength;                        runLength = decodeRun(white ? whiteRunTree : blackRunTree);                        index += runLength;                        changesCurrentRow[changesCurrentRowCount++] = index;                        runLength = decodeRun(white ? blackRunTree : whiteRunTree);                        index += runLength;                        changesCurrentRow[changesCurrentRowCount++] = index;                        break;                    case VALUE_PASSMODE:                        int pChangingElement = getNextChangingElement(index, white) + 1;                        if (pChangingElement >= changesReferenceRowCount) {                            index = columns;                        } else {                            index = changesReferenceRow[pChangingElement];                        }                        break;                    default:                                                int vChangingElement = getNextChangingElement(index, white);                        if (vChangingElement >= changesReferenceRowCount || vChangingElement == -1) {                            index = columns + n.value;                        } else {                            index = changesReferenceRow[vChangingElement] + n.value;                        }                        changesCurrentRow[changesCurrentRowCount] = index;                        changesCurrentRowCount++;                        white = !white;                        break;                }                continue mode;            }        }    }}
private int pdfbox_f2751_0(final int a0, final boolean white)
{    int start = (lastChangingElement & 0xFFFFFFFE) + (white ? 0 : 1);    if (start > 2) {        start -= 2;    }    if (a0 == 0) {        return start;    }    for (int i = start; i < changesReferenceRowCount; i += 2) {        if (a0 < changesReferenceRow[i]) {            lastChangingElement = i;            return i;        }    }    return -1;}
private void pdfbox_f2752_0() throws IOException
{    if (optionByteAligned) {        resetBuffer();    }    decode1D();}
private void pdfbox_f2753_0() throws IOException
{    if (optionByteAligned) {        resetBuffer();    }    eof: while (true) {                Node n = eolOnlyTree.root;        while (true) {            n = n.walk(readBit());            if (n == null) {                continue eof;            }            if (n.isLeaf) {                break eof;            }        }    }    if (!optionG32D || readBit()) {        decode1D();    } else {        decode2D();    }}
private void pdfbox_f2754_0() throws IOException
{    if (optionByteAligned) {        resetBuffer();    }    decode2D();}
private void pdfbox_f2755_0() throws IOException
{    switch(type) {        case TIFFExtension.COMPRESSION_CCITT_MODIFIED_HUFFMAN_RLE:            decodeRowType2();            break;        case TIFFExtension.COMPRESSION_CCITT_T4:            decodeRowType4();            break;        case TIFFExtension.COMPRESSION_CCITT_T6:            decodeRowType6();            break;    }    int index = 0;    boolean white = true;    lastChangingElement = 0;    for (int i = 0; i <= changesCurrentRowCount; i++) {        int nextChange = columns;        if (i != changesCurrentRowCount) {            nextChange = changesCurrentRow[i];        }        if (nextChange > columns) {            nextChange = columns;        }        int byteIndex = index / 8;        while (index % 8 != 0 && (nextChange - index) > 0) {            decodedRow[byteIndex] |= (white ? 0 : 1 << (7 - ((index) % 8)));            index++;        }        if (index % 8 == 0) {            byteIndex = index / 8;            final byte value = (byte) (white ? 0x00 : 0xff);            while ((nextChange - index) > 7) {                decodedRow[byteIndex] = value;                index += 8;                ++byteIndex;            }        }        while ((nextChange - index) > 0) {            if (index % 8 == 0) {                decodedRow[byteIndex] = 0;            }            decodedRow[byteIndex] |= (white ? 0 : 1 << (7 - ((index) % 8)));            index++;        }        white = !white;    }    if (index != columns) {        throw new IOException("Sum of run-lengths does not equal scan line width: " + index + " > " + columns);    }    decodedLength = (index + 7) / 8;}
private int pdfbox_f2756_0(final Tree tree) throws IOException
{    int total = 0;    Node n = tree.root;    while (true) {        boolean bit = readBit();        n = n.walk(bit);        if (n == null) {            throw new IOException("Unknown code in Huffman RLE stream");        }        if (n.isLeaf) {            total += n.value;            if (n.value < 64) {                return total;            } else {                n = tree.root;            }        }    }}
private void pdfbox_f2757_0() throws IOException
{    bufferPos = -1;}
private boolean pdfbox_f2758_0() throws IOException
{    if (bufferPos < 0 || bufferPos > 7) {        buffer = in.read();        if (buffer == -1) {            throw new EOFException("Unexpected end of Huffman RLE stream");        }        bufferPos = 0;    }    boolean isSet;    if (fillOrder == TIFFExtension.FILL_LEFT_TO_RIGHT) {        isSet = ((buffer >> (7 - bufferPos)) & 1) == 1;    } else {        isSet = ((buffer >> (bufferPos)) & 1) == 1;    }    bufferPos++;    if (bufferPos > 7) {        bufferPos = -1;    }    return isSet;}
public int pdfbox_f2759_0() throws IOException
{    if (decodedLength < 0) {        return 0x0;    }    if (decodedPos >= decodedLength) {        fetch();        if (decodedLength < 0) {            return 0x0;        }    }    return decodedRow[decodedPos++] & 0xff;}
public int pdfbox_f2760_0(byte[] b, int off, int len) throws IOException
{    if (decodedLength < 0) {                Arrays.fill(b, off, off + len, (byte) 0x0);        return len;    }    if (decodedPos >= decodedLength) {        fetch();        if (decodedLength < 0) {            Arrays.fill(b, off, off + len, (byte) 0x0);            return len;        }    }    int read = Math.min(decodedLength - decodedPos, len);    System.arraycopy(decodedRow, decodedPos, b, off, read);    decodedPos += read;    return read;}
public long pdfbox_f2761_0(long n) throws IOException
{    if (decodedLength < 0) {        return -1;    }    if (decodedPos >= decodedLength) {        fetch();        if (decodedLength < 0) {            return -1;        }    }    int skipped = (int) Math.min(decodedLength - decodedPos, n);    decodedPos += skipped;    return skipped;}
public boolean pdfbox_f2762_0()
{    return false;}
public synchronized void pdfbox_f2763_0() throws IOException
{    throw new IOException("mark/reset not supported");}
 void pdfbox_f2764_0(final boolean next, final Node node)
{    if (!next) {        left = node;    } else {        right = node;    }}
 Node pdfbox_f2765_0(final boolean next)
{    return next ? right : left;}
public String pdfbox_f2766_0()
{    return "[leaf=" + isLeaf + ", value=" + value + ", canBeFill=" + canBeFill + "]";}
 void pdfbox_f2767_0(final int depth, final int path, final int value) throws IOException
{    Node current = root;    for (int i = 0; i < depth; i++) {        int bitPos = depth - 1 - i;        boolean isSet = ((path >> bitPos) & 1) == 1;        Node next = current.walk(isSet);        if (next == null) {            next = new Node();            if (i == depth - 1) {                next.value = value;                next.isLeaf = true;            }            if (path == 0) {                next.canBeFill = true;            }            current.set(isSet, next);        } else {            if (next.isLeaf) {                throw new IOException("node is leaf, no other following");            }        }        current = next;    }}
 void pdfbox_f2768_0(final int depth, final int path, final Node node) throws IOException
{    Node current = root;    for (int i = 0; i < depth; i++) {        int bitPos = depth - 1 - i;        boolean isSet = ((path >> bitPos) & 1) == 1;        Node next = current.walk(isSet);        if (next == null) {            if (i == depth - 1) {                next = node;            } else {                next = new Node();            }            if (path == 0) {                next.canBeFill = true;            }            current.set(isSet, next);        } else {            if (next.isLeaf) {                throw new IOException("node is leaf, no other following");            }        }        current = next;    }}
public void pdfbox_f2769_0(int b) throws IOException
{    inputBuffer[currentBufferLength] = (byte) b;    currentBufferLength++;    if (currentBufferLength == inputBufferLength) {        encodeRow();        currentBufferLength = 0;    }}
public void pdfbox_f2770_0() throws IOException
{    stream.flush();}
public void pdfbox_f2771_0() throws IOException
{    stream.close();}
private void pdfbox_f2772_0() throws IOException
{    currentRow++;    int[] tmp = changesReferenceRow;    changesReferenceRow = changesCurrentRow;    changesCurrentRow = tmp;    changesReferenceRowLength = changesCurrentRowLength;    changesCurrentRowLength = 0;    int index = 0;    boolean white = true;    while (index < columns) {        int byteIndex = index / 8;        int bit = index % 8;        if ((((inputBuffer[byteIndex] >> (7 - bit)) & 1) == 1) == (white)) {            changesCurrentRow[changesCurrentRowLength] = index;            changesCurrentRowLength++;            white = !white;        }        index++;    }    encodeRowType6();    if (currentRow == rows) {        writeEOL();        writeEOL();        fill();    }}
private void pdfbox_f2773_0() throws IOException
{    encode2D();}
private int[] pdfbox_f2774_0(int pos, boolean white)
{    int[] result = new int[] { columns, columns };    for (int i = 0; i < changesCurrentRowLength; i++) {        if (pos < changesCurrentRow[i] || (pos == 0 && white)) {            result[0] = changesCurrentRow[i];            if ((i + 1) < changesCurrentRowLength) {                result[1] = changesCurrentRow[i + 1];            }            break;        }    }    return result;}
private void pdfbox_f2775_0(int runLength, boolean white) throws IOException
{    int nonterm = runLength / 64;    Code[] codes = white ? WHITE_NONTERMINATING_CODES : BLACK_NONTERMINATING_CODES;    while (nonterm > 0) {        if (nonterm >= codes.length) {            write(codes[codes.length - 1].code, codes[codes.length - 1].length);            nonterm -= codes.length;        } else {            write(codes[nonterm - 1].code, codes[nonterm - 1].length);            nonterm = 0;        }    }    Code c = white ? WHITE_TERMINATING_CODES[runLength % 64] : BLACK_TERMINATING_CODES[runLength % 64];    write(c.code, c.length);}
private void pdfbox_f2776_0() throws IOException
{    boolean white = true;        int index = 0;    while (index < columns) {                int[] nextChanges = getNextChanges(index, white);                int[] nextRefs = getNextRefChanges(index, white);        int difference = nextChanges[0] - nextRefs[0];        if (nextChanges[0] > nextRefs[1]) {                        write(1, 4);            index = nextRefs[1];        } else if (difference > 3 || difference < -3) {                        write(1, 3);            writeRun(nextChanges[0] - index, white);            writeRun(nextChanges[1] - nextChanges[0], !white);            index = nextChanges[1];        } else {                        switch(difference) {                case 0:                    write(1, 1);                    break;                case 1:                    write(3, 3);                    break;                case 2:                    write(3, 6);                    break;                case 3:                    write(3, 7);                    break;                case -1:                    write(2, 3);                    break;                case -2:                    write(2, 6);                    break;                case -3:                    write(2, 7);                    break;            }            white = !white;            index = nextRefs[0] + difference;        }    }}
private int[] pdfbox_f2777_0(int a0, boolean white)
{    int[] result = new int[] { columns, columns };    for (int i = (white ? 0 : 1); i < changesReferenceRowLength; i += 2) {        if (changesReferenceRow[i] > a0 || (a0 == 0 && i == 0)) {            result[0] = changesReferenceRow[i];            if ((i + 1) < changesReferenceRowLength) {                result[1] = changesReferenceRow[i + 1];            }            break;        }    }    return result;}
private void pdfbox_f2778_0(int code, int codeLength) throws IOException
{    for (int i = 0; i < codeLength; i++) {        boolean codeBit = ((code >> (codeLength - i - 1)) & 1) == 1;        if (fillOrder == TIFFExtension.FILL_LEFT_TO_RIGHT) {            outputBuffer |= (codeBit ? 1 << (7 - ((outputBufferBitLength) % 8)) : 0);        } else {            outputBuffer |= (codeBit ? 1 << (((outputBufferBitLength) % 8)) : 0);        }        outputBufferBitLength++;        if (outputBufferBitLength == 8) {            stream.write(outputBuffer);            clearOutputBuffer();        }    }}
private void pdfbox_f2779_0() throws IOException
{    write(1, 12);}
private void pdfbox_f2780_0() throws IOException
{    if (outputBufferBitLength != 0) {        stream.write(outputBuffer);    }    clearOutputBuffer();}
private void pdfbox_f2781_0()
{    outputBuffer = 0;    outputBufferBitLength = 0;}
public DecodeResult pdfbox_f2782_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{        COSDictionary decodeParms = getDecodeParams(parameters, index);        int cols = decodeParms.getInt(COSName.COLUMNS, 1728);    int rows = decodeParms.getInt(COSName.ROWS, 0);    int height = parameters.getInt(COSName.HEIGHT, COSName.H, 0);    if (rows > 0 && height > 0) {                rows = height;    } else {                rows = Math.max(rows, height);    }        int k = decodeParms.getInt(COSName.K, 0);    boolean encodedByteAlign = decodeParms.getBoolean(COSName.ENCODED_BYTE_ALIGN, false);    int arraySize = (cols + 7) / 8 * rows;        byte[] decompressed = new byte[arraySize];    CCITTFaxDecoderStream s;    int type;    long tiffOptions;    if (k == 0) {        tiffOptions = encodedByteAlign ? TIFFExtension.GROUP3OPT_BYTEALIGNED : 0;        type = TIFFExtension.COMPRESSION_CCITT_MODIFIED_HUFFMAN_RLE;    } else {        if (k > 0) {            tiffOptions = encodedByteAlign ? TIFFExtension.GROUP3OPT_BYTEALIGNED : 0;            tiffOptions |= TIFFExtension.GROUP3OPT_2DENCODING;            type = TIFFExtension.COMPRESSION_CCITT_T4;        } else {                        tiffOptions = encodedByteAlign ? TIFFExtension.GROUP4OPT_BYTEALIGNED : 0;            type = TIFFExtension.COMPRESSION_CCITT_T6;        }    }    s = new CCITTFaxDecoderStream(encoded, cols, type, TIFFExtension.FILL_LEFT_TO_RIGHT, tiffOptions);    readFromDecoderStream(s, decompressed);        boolean blackIsOne = decodeParms.getBoolean(COSName.BLACK_IS_1, false);    if (!blackIsOne) {                                        invertBitmap(decompressed);    }    decoded.write(decompressed);    return new DecodeResult(parameters);}
 void pdfbox_f2783_0(CCITTFaxDecoderStream decoderStream, byte[] result) throws IOException
{    int pos = 0;    int read;    while ((read = decoderStream.read(result, pos, result.length - pos)) > -1) {        pos += read;        if (pos >= result.length) {            break;        }    }    decoderStream.close();}
private void pdfbox_f2784_0(byte[] bufferData)
{    for (int i = 0, c = bufferData.length; i < c; i++) {        bufferData[i] = (byte) (~bufferData[i] & 0xFF);    }}
protected void pdfbox_f2785_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    int cols = parameters.getInt(COSName.COLUMNS);    int rows = parameters.getInt(COSName.ROWS);    CCITTFaxEncoderStream ccittFaxEncoderStream = new CCITTFaxEncoderStream(encoded, cols, rows, TIFFExtension.FILL_LEFT_TO_RIGHT);    IOUtils.copy(input, ccittFaxEncoderStream);    input.close();}
public DecodeResult pdfbox_f2786_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    COSName encryptionName = (COSName) parameters.getDictionaryObject(COSName.NAME);    if (encryptionName == null || encryptionName.equals(COSName.IDENTITY)) {                Filter identityFilter = new IdentityFilter();        identityFilter.decode(encoded, decoded, parameters, index);        return new DecodeResult(parameters);    }    throw new IOException("Unsupported crypt filter " + encryptionName.getName());}
protected void pdfbox_f2787_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    COSName encryptionName = (COSName) parameters.getDictionaryObject(COSName.NAME);    if (encryptionName == null || encryptionName.equals(COSName.IDENTITY)) {                Filter identityFilter = new IdentityFilter();        identityFilter.encode(input, encoded, parameters);    } else {        throw new IOException("Unsupported crypt filter " + encryptionName.getName());    }}
public DecodeResult pdfbox_f2788_1(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index, DecodeOptions options) throws IOException
{    ImageReader reader = findImageReader("JPEG", "a suitable JAI I/O image filter is not installed");    try (ImageInputStream iis = ImageIO.createImageInputStream(encoded)) {                if (iis.read() != 0x0A) {            iis.seek(0);        }        reader.setInput(iis);        ImageReadParam irp = reader.getDefaultReadParam();        irp.setSourceSubsampling(options.getSubsamplingX(), options.getSubsamplingY(), options.getSubsamplingOffsetX(), options.getSubsamplingOffsetY());        irp.setSourceRegion(options.getSourceRegion());        options.setFilterSubsampled(true);        String numChannels = getNumChannels(reader);                ImageIO.setUseCache(false);        Raster raster;                if ("3".equals(numChannels) || numChannels.isEmpty()) {            try {                                BufferedImage image = reader.read(0, irp);                raster = image.getRaster();            } catch (IIOException e) {                                                                raster = reader.readRaster(0, irp);            }        } else {                                    raster = reader.readRaster(0, irp);        }                if (raster.getNumBands() == 4) {                        Integer transform;            try {                transform = getAdobeTransform(reader.getImageMetadata(0));            } catch (IIOException | NegativeArraySizeException e) {                                                transform = getAdobeTransformByBruteForce(iis);            }            int colorTransform = transform != null ? transform : 0;                        switch(colorTransform) {                case 0:                                        break;                case 1:                    raster = fromYCbCrtoCMYK(raster);                    break;                case 2:                    raster = fromYCCKtoCMYK(raster);                    break;                default:                    throw new IllegalArgumentException("Unknown colorTransform");            }        } else if (raster.getNumBands() == 3) {                        raster = fromBGRtoRGB(raster);        }        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();        decoded.write(dataBuffer.getData());    } finally {        reader.dispose();    }    return new DecodeResult(parameters);}
public DecodeResult pdfbox_f2789_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    return decode(encoded, decoded, parameters, index, DecodeOptions.DEFAULT);}
private Integer pdfbox_f2790_0(IIOMetadata metadata)
{    Element tree = (Element) metadata.getAsTree("javax_imageio_jpeg_image_1.0");    Element markerSequence = (Element) tree.getElementsByTagName("markerSequence").item(0);    NodeList app14AdobeNodeList = markerSequence.getElementsByTagName("app14Adobe");    if (app14AdobeNodeList != null && app14AdobeNodeList.getLength() > 0) {        Element adobe = (Element) app14AdobeNodeList.item(0);        return Integer.parseInt(adobe.getAttribute("transform"));    }    return 0;}
private int pdfbox_f2791_0(ImageInputStream iis) throws IOException
{    int a = 0;    iis.seek(0);    int by;    while ((by = iis.read()) != -1) {        if (ADOBE.charAt(a) == by) {            ++a;            if (a != ADOBE.length()) {                continue;            }                        a = 0;            long afterAdobePos = iis.getStreamPosition();            iis.seek(iis.getStreamPosition() - 9);            int tag = iis.readUnsignedShort();            if (tag != 0xFFEE) {                iis.seek(afterAdobePos);                continue;            }            int len = iis.readUnsignedShort();            if (len >= POS_TRANSFORM + 1) {                byte[] app14 = new byte[Math.max(len, POS_TRANSFORM + 1)];                if (iis.read(app14) >= POS_TRANSFORM + 1) {                    return app14[POS_TRANSFORM];                }            }        } else {            a = 0;        }    }    return 0;}
private WritableRaster pdfbox_f2792_0(Raster raster)
{    WritableRaster writableRaster = raster.createCompatibleWritableRaster();    int[] value = new int[4];    for (int y = 0, height = raster.getHeight(); y < height; y++) {        for (int x = 0, width = raster.getWidth(); x < width; x++) {            raster.getPixel(x, y, value);                        float Y = value[0];            float Cb = value[1];            float Cr = value[2];            float K = value[3];                        int r = clamp(Y + 1.402f * Cr - 179.456f);            int g = clamp(Y - 0.34414f * Cb - 0.71414f * Cr + 135.45984f);            int b = clamp(Y + 1.772f * Cb - 226.816f);                        int cyan = 255 - r;            int magenta = 255 - g;            int yellow = 255 - b;                        value[0] = cyan;            value[1] = magenta;            value[2] = yellow;            value[3] = (int) K;            writableRaster.setPixel(x, y, value);        }    }    return writableRaster;}
private WritableRaster pdfbox_f2793_0(Raster raster)
{    WritableRaster writableRaster = raster.createCompatibleWritableRaster();    int[] value = new int[4];    for (int y = 0, height = raster.getHeight(); y < height; y++) {        for (int x = 0, width = raster.getWidth(); x < width; x++) {            raster.getPixel(x, y, value);                        float Y = value[0];            float Cb = value[1];            float Cr = value[2];            float K = value[3];                        int r = clamp((1.164f * (Y - 16)) + (1.596f * (Cr - 128)));            int g = clamp((1.164f * (Y - 16)) + (-0.392f * (Cb - 128)) + (-0.813f * (Cr - 128)));            int b = clamp((1.164f * (Y - 16)) + (2.017f * (Cb - 128)));                        int cyan = 255 - r;            int magenta = 255 - g;            int yellow = 255 - b;                        value[0] = cyan;            value[1] = magenta;            value[2] = yellow;            value[3] = (int) K;            writableRaster.setPixel(x, y, value);        }    }    return writableRaster;}
private WritableRaster pdfbox_f2794_0(Raster raster)
{    WritableRaster writableRaster = raster.createCompatibleWritableRaster();    int width = raster.getWidth();    int height = raster.getHeight();    int w3 = width * 3;    int[] tab = new int[w3];        for (int y = 0; y < height; y++) {        raster.getPixels(0, y, width, 1, tab);        for (int off = 0; off < w3; off += 3) {            int tmp = tab[off];            tab[off] = tab[off + 2];            tab[off + 2] = tmp;        }        writableRaster.setPixels(0, y, width, 1, tab);    }    return writableRaster;}
private String pdfbox_f2795_1(ImageReader reader)
{    try {        IIOMetadata imageMetadata = reader.getImageMetadata(0);        if (imageMetadata == null) {            return "";        }        IIOMetadataNode metaTree = (IIOMetadataNode) imageMetadata.getAsTree("javax_imageio_1.0");        Element numChannelsItem = (Element) metaTree.getElementsByTagName("NumChannels").item(0);        if (numChannelsItem == null) {            return "";        }        return numChannelsItem.getAttribute("value");    } catch (IOException | NegativeArraySizeException e) {                return "";    }}
private int pdfbox_f2796_0(float value)
{    return (int) ((value < 0) ? 0 : ((value > 255) ? 255 : value));}
protected void pdfbox_f2797_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    throw new UnsupportedOperationException("DCTFilter encoding not implemented, use the JPEGFactory methods instead");}
public Rectangle pdfbox_f2798_0()
{    return sourceRegion;}
public void pdfbox_f2799_0(Rectangle sourceRegion)
{    this.sourceRegion = sourceRegion;}
public int pdfbox_f2800_0()
{    return subsamplingX;}
public void pdfbox_f2801_0(int ssX)
{    this.subsamplingX = ssX;}
public int pdfbox_f2802_0()
{    return subsamplingY;}
public void pdfbox_f2803_0(int ssY)
{    this.subsamplingY = ssY;}
public int pdfbox_f2804_0()
{    return subsamplingOffsetX;}
public void pdfbox_f2805_0(int ssOffsetX)
{    this.subsamplingOffsetX = ssOffsetX;}
public int pdfbox_f2806_0()
{    return subsamplingOffsetY;}
public void pdfbox_f2807_0(int ssOffsetY)
{    this.subsamplingOffsetY = ssOffsetY;}
public boolean pdfbox_f2808_0()
{    return filterSubsampled;}
 void pdfbox_f2809_0(boolean filterSubsampled)
{    this.filterSubsampled = filterSubsampled;}
public void pdfbox_f2810_0(Rectangle sourceRegion)
{    throw new UnsupportedOperationException("This instance may not be modified.");}
public void pdfbox_f2811_0(int ssX)
{    throw new UnsupportedOperationException("This instance may not be modified.");}
public void pdfbox_f2812_0(int ssY)
{    throw new UnsupportedOperationException("This instance may not be modified.");}
public void pdfbox_f2813_0(int ssOffsetX)
{    throw new UnsupportedOperationException("This instance may not be modified.");}
public void pdfbox_f2814_0(int ssOffsetY)
{    throw new UnsupportedOperationException("This instance may not be modified.");}
public COSDictionary pdfbox_f2816_0()
{    return parameters;}
public PDJPXColorSpace pdfbox_f2817_0()
{    return colorSpace;}
 void pdfbox_f2818_0(PDJPXColorSpace colorSpace)
{    this.colorSpace = colorSpace;}
public DecodeResult pdfbox_f2819_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index, DecodeOptions options) throws IOException
{    return decode(encoded, decoded, parameters, index);}
public final void pdfbox_f2820_0(InputStream input, OutputStream encoded, COSDictionary parameters, int index) throws IOException
{    encode(input, encoded, parameters.asUnmodifiableDictionary());}
protected COSDictionary pdfbox_f2821_1(COSDictionary dictionary, int index)
{    COSBase filter = dictionary.getDictionaryObject(COSName.FILTER, COSName.F);    COSBase obj = dictionary.getDictionaryObject(COSName.DECODE_PARMS, COSName.DP);    if (filter instanceof COSName && obj instanceof COSDictionary) {                return (COSDictionary) obj;    } else if (filter instanceof COSArray && obj instanceof COSArray) {        COSArray array = (COSArray) obj;        if (index < array.size()) {            COSBase objAtIndex = array.getObject(index);            if (objAtIndex instanceof COSDictionary) {                return (COSDictionary) array.getObject(index);            }        }    } else if (obj != null && !(filter instanceof COSArray || obj instanceof COSArray)) {            }    return new COSDictionary();}
protected static ImageReader pdfbox_f2822_0(String formatName, String errorCause) throws MissingImageReaderException
{    Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(formatName);    ImageReader reader = null;    while (readers.hasNext()) {        reader = readers.next();        if (reader != null && reader.canReadRaster()) {            break;        }    }    if (reader == null) {        throw new MissingImageReaderException("Cannot read " + formatName + " image: " + errorCause);    }    return reader;}
public static int pdfbox_f2823_1()
{    int compressionLevel = Deflater.DEFAULT_COMPRESSION;    try {        compressionLevel = Integer.parseInt(System.getProperty(Filter.SYSPROP_DEFLATELEVEL, "-1"));    } catch (NumberFormatException ex) {            }    return Math.max(-1, Math.min(Deflater.BEST_COMPRESSION, compressionLevel));}
public Filter pdfbox_f2824_0(String filterName) throws IOException
{    return getFilter(COSName.getPDFName(filterName));}
public Filter pdfbox_f2825_0(COSName filterName) throws IOException
{    Filter filter = filters.get(filterName);    if (filter == null) {        throw new IOException("Invalid filter: " + filterName);    }    return filter;}
 Collection<Filter> pdfbox_f2826_0()
{    return filters.values();}
public DecodeResult pdfbox_f2827_1(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    final COSDictionary decodeParams = getDecodeParams(parameters, index);    try {        decompress(encoded, Predictor.wrapPredictor(decoded, decodeParams));    } catch (DataFormatException e) {                                throw new IOException(e);    }    return new DecodeResult(parameters);}
private void pdfbox_f2828_1(InputStream in, OutputStream out) throws IOException, DataFormatException
{    byte[] buf = new byte[2048];        in.read(buf, 0, 2);    int read = in.read(buf);    if (read > 0) {                Inflater inflater = new Inflater(true);        inflater.setInput(buf, 0, read);        byte[] res = new byte[1024];        boolean dataWritten = false;        while (true) {            int resRead = 0;            try {                resRead = inflater.inflate(res);            } catch (DataFormatException exception) {                if (dataWritten) {                                                            break;                } else {                                        throw exception;                }            }            if (resRead != 0) {                out.write(res, 0, resRead);                dataWritten = true;                continue;            }            if (inflater.finished() || inflater.needsDictionary() || in.available() == 0) {                break;            }            read = in.read(buf);            inflater.setInput(buf, 0, read);        }        inflater.end();    }    out.flush();}
protected void pdfbox_f2829_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    int compressionLevel = getCompressionLevel();    Deflater deflater = new Deflater(compressionLevel);    try (DeflaterOutputStream out = new DeflaterOutputStream(encoded, deflater)) {        int amountRead;        int mayRead = input.available();        if (mayRead > 0) {            byte[] buffer = new byte[Math.min(mayRead, BUFFER_SIZE)];            while ((amountRead = input.read(buffer, 0, Math.min(mayRead, BUFFER_SIZE))) != -1) {                out.write(buffer, 0, amountRead);            }        }    }    encoded.flush();    deflater.end();}
public DecodeResult pdfbox_f2830_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    IOUtils.copy(encoded, decoded);    decoded.flush();    return new DecodeResult(parameters);}
protected void pdfbox_f2831_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    IOUtils.copy(input, encoded);    encoded.flush();}
private static synchronized void pdfbox_f2832_1()
{    if (!levigoLogged) {                        levigoLogged = true;    }}
public DecodeResult pdfbox_f2833_1(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index, DecodeOptions options) throws IOException
{    ImageReader reader = findImageReader("JBIG2", "jbig2-imageio is not installed");    if (reader.getClass().getName().contains("levigo")) {        logLevigoDonated();    }    int bits = parameters.getInt(COSName.BITS_PER_COMPONENT, 1);    COSDictionary params = getDecodeParams(parameters, index);    ImageReadParam irp = reader.getDefaultReadParam();    irp.setSourceSubsampling(options.getSubsamplingX(), options.getSubsamplingY(), options.getSubsamplingOffsetX(), options.getSubsamplingOffsetY());    irp.setSourceRegion(options.getSourceRegion());    options.setFilterSubsampled(true);    InputStream source = encoded;    if (params != null) {        COSBase globals = params.getDictionaryObject(COSName.JBIG2_GLOBALS);        if (globals instanceof COSStream) {            source = new SequenceInputStream(((COSStream) globals).createInputStream(), encoded);        }    }    try (ImageInputStream iis = ImageIO.createImageInputStream(source)) {        reader.setInput(iis);        BufferedImage image;        try {            image = reader.read(0, irp);        } catch (Exception e) {                        throw new IOException("Could not read JBIG2 image", e);        }                if (image.getColorModel().getPixelSize() != bits) {            if (bits != 1) {                            }            BufferedImage packedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_BINARY);            Graphics graphics = packedImage.getGraphics();            graphics.drawImage(image, 0, 0, null);            graphics.dispose();            image = packedImage;        }        DataBuffer dBuf = image.getData().getDataBuffer();        if (dBuf.getDataType() == DataBuffer.TYPE_BYTE) {            decoded.write(((DataBufferByte) dBuf).getData());        } else {            throw new IOException("Unexpected image buffer type");        }    } finally {        reader.dispose();    }    return new DecodeResult(parameters);}
public DecodeResult pdfbox_f2834_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    return decode(encoded, decoded, parameters, index, DecodeOptions.DEFAULT);}
protected void pdfbox_f2835_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    throw new UnsupportedOperationException("JBIG2 encoding not implemented");}
public DecodeResult pdfbox_f2836_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index, DecodeOptions options) throws IOException
{    DecodeResult result = new DecodeResult(new COSDictionary());    result.getParameters().addAll(parameters);    BufferedImage image = readJPX(encoded, options, result);    Raster raster = image.getRaster();    switch(raster.getDataBuffer().getDataType()) {        case DataBuffer.TYPE_BYTE:            DataBufferByte byteBuffer = (DataBufferByte) raster.getDataBuffer();            decoded.write(byteBuffer.getData());            return result;        case DataBuffer.TYPE_USHORT:            DataBufferUShort wordBuffer = (DataBufferUShort) raster.getDataBuffer();            for (short w : wordBuffer.getData()) {                decoded.write(w >> 8);                decoded.write(w);            }            return result;        case DataBuffer.TYPE_INT:                                    int[] ar = new int[raster.getNumBands()];            for (int y = 0; y < image.getHeight(); ++y) {                for (int x = 0; x < image.getWidth(); ++x) {                    raster.getPixel(x, y, ar);                    for (int i = 0; i < ar.length; ++i) {                        decoded.write(ar[i]);                    }                }            }            return result;        default:            throw new IOException("Data type " + raster.getDataBuffer().getDataType() + " not implemented");    }}
public DecodeResult pdfbox_f2837_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    return decode(encoded, decoded, parameters, index, DecodeOptions.DEFAULT);}
private BufferedImage pdfbox_f2838_0(InputStream input, DecodeOptions options, DecodeResult result) throws IOException
{    ImageReader reader = findImageReader("JPEG2000", "Java Advanced Imaging (JAI) Image I/O Tools are not installed");        try (ImageInputStream iis = new MemoryCacheImageInputStream(input)) {        reader.setInput(iis, true, true);        ImageReadParam irp = reader.getDefaultReadParam();        irp.setSourceRegion(options.getSourceRegion());        irp.setSourceSubsampling(options.getSubsamplingX(), options.getSubsamplingY(), options.getSubsamplingOffsetX(), options.getSubsamplingOffsetY());        options.setFilterSubsampled(true);        BufferedImage image;        try {            image = reader.read(0, irp);        } catch (Exception e) {                        throw new IOException("Could not read JPEG 2000 (JPX) image", e);        }        COSDictionary parameters = result.getParameters();                                        int bpc = image.getColorModel().getPixelSize() / image.getRaster().getNumBands();        parameters.setInt(COSName.BITS_PER_COMPONENT, bpc);                if (!parameters.getBoolean(COSName.IMAGE_MASK, false)) {            parameters.setItem(COSName.DECODE, null);        }                parameters.setInt(COSName.WIDTH, reader.getWidth(0));        parameters.setInt(COSName.HEIGHT, reader.getHeight(0));                if (!parameters.containsKey(COSName.COLORSPACE)) {            if (image.getSampleModel() instanceof MultiPixelPackedSampleModel && image.getColorModel().getPixelSize() == 1 && image.getRaster().getNumBands() == 1 && image.getColorModel() instanceof IndexColorModel) {                                                                                result.setColorSpace(new PDJPXColorSpace(ColorSpace.getInstance(ColorSpace.CS_GRAY)));            } else {                result.setColorSpace(new PDJPXColorSpace(image.getColorModel().getColorSpace()));            }        }        return image;    } finally {        reader.dispose();    }}
protected void pdfbox_f2839_0(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    throw new UnsupportedOperationException("JPX encoding not implemented");}
public DecodeResult pdfbox_f2840_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    COSDictionary decodeParams = getDecodeParams(parameters, index);    int earlyChange = decodeParams.getInt(COSName.EARLY_CHANGE, 1);    if (earlyChange != 0 && earlyChange != 1) {        earlyChange = 1;    }    doLZWDecode(encoded, Predictor.wrapPredictor(decoded, decodeParams), earlyChange);    return new DecodeResult(parameters);}
private void pdfbox_f2841_1(InputStream encoded, OutputStream decoded, int earlyChange) throws IOException
{    List<byte[]> codeTable = new ArrayList<>();    int chunk = 9;    final MemoryCacheImageInputStream in = new MemoryCacheImageInputStream(encoded);    long nextCommand;    long prevCommand = -1;    try {        while ((nextCommand = in.readBits(chunk)) != EOD) {            if (nextCommand == CLEAR_TABLE) {                chunk = 9;                codeTable = createCodeTable();                prevCommand = -1;            } else {                if (nextCommand < codeTable.size()) {                    byte[] data = codeTable.get((int) nextCommand);                    byte firstByte = data[0];                    decoded.write(data);                    if (prevCommand != -1) {                        checkIndexBounds(codeTable, prevCommand, in);                        data = codeTable.get((int) prevCommand);                        byte[] newData = Arrays.copyOf(data, data.length + 1);                        newData[data.length] = firstByte;                        codeTable.add(newData);                    }                } else {                    checkIndexBounds(codeTable, prevCommand, in);                    byte[] data = codeTable.get((int) prevCommand);                    byte[] newData = Arrays.copyOf(data, data.length + 1);                    newData[data.length] = data[0];                    decoded.write(newData);                    codeTable.add(newData);                }                chunk = calculateChunk(codeTable.size(), earlyChange);                prevCommand = nextCommand;            }        }    } catch (EOFException ex) {            }    decoded.flush();}
private void pdfbox_f2842_0(List<byte[]> codeTable, long index, MemoryCacheImageInputStream in) throws IOException
{    if (index < 0) {        throw new IOException("negative array index: " + index + " near offset " + in.getStreamPosition());    }    if (index >= codeTable.size()) {        throw new IOException("array index overflow: " + index + " >= " + codeTable.size() + " near offset " + in.getStreamPosition());    }}
protected void pdfbox_f2843_0(InputStream rawData, OutputStream encoded, COSDictionary parameters) throws IOException
{    List<byte[]> codeTable = createCodeTable();    int chunk = 9;    byte[] inputPattern = null;    try (MemoryCacheImageOutputStream out = new MemoryCacheImageOutputStream(encoded)) {        out.writeBits(CLEAR_TABLE, chunk);        int foundCode = -1;        int r;        while ((r = rawData.read()) != -1) {            byte by = (byte) r;            if (inputPattern == null) {                inputPattern = new byte[] { by };                foundCode = by & 0xff;            } else {                inputPattern = Arrays.copyOf(inputPattern, inputPattern.length + 1);                inputPattern[inputPattern.length - 1] = by;                int newFoundCode = findPatternCode(codeTable, inputPattern);                if (newFoundCode == -1) {                                        chunk = calculateChunk(codeTable.size() - 1, 1);                    out.writeBits(foundCode, chunk);                                        codeTable.add(inputPattern);                    if (codeTable.size() == 4096) {                                                out.writeBits(CLEAR_TABLE, chunk);                        codeTable = createCodeTable();                    }                    inputPattern = new byte[] { by };                    foundCode = by & 0xff;                } else {                    foundCode = newFoundCode;                }            }        }        if (foundCode != -1) {            chunk = calculateChunk(codeTable.size() - 1, 1);            out.writeBits(foundCode, chunk);        }                                                chunk = calculateChunk(codeTable.size(), 1);        out.writeBits(EOD, chunk);                out.writeBits(0, 7);                out.flush();    }}
private int pdfbox_f2844_0(List<byte[]> codeTable, byte[] pattern)
{    int foundCode = -1;    int foundLen = 0;    for (int i = codeTable.size() - 1; i >= 0; --i) {        if (i <= EOD) {                        if (foundCode != -1) {                                return foundCode;            } else if (pattern.length > 1) {                                return -1;            }        }        byte[] tryPattern = codeTable.get(i);        if ((foundCode != -1 || tryPattern.length > foundLen) && Arrays.equals(tryPattern, pattern)) {            foundCode = i;            foundLen = tryPattern.length;        }    }    return foundCode;}
private List<byte[]> pdfbox_f2845_0()
{    List<byte[]> codeTable = new ArrayList<>(4096);    for (int i = 0; i < 256; ++i) {        codeTable.add(new byte[] { (byte) (i & 0xFF) });    }        codeTable.add(null);        codeTable.add(null);    return codeTable;}
private int pdfbox_f2846_0(int tabSize, int earlyChange)
{    if (tabSize >= 2048 - earlyChange) {        return 12;    }    if (tabSize >= 1024 - earlyChange) {        return 11;    }    if (tabSize >= 512 - earlyChange) {        return 10;    }    return 9;}
 static void pdfbox_f2847_0(int predictor, int colors, int bitsPerComponent, int columns, byte[] actline, byte[] lastline)
{    if (predictor == 1) {                return;    }    final int bitsPerPixel = colors * bitsPerComponent;    final int bytesPerPixel = (bitsPerPixel + 7) / 8;    final int rowlength = actline.length;    switch(predictor) {        case 2:                        if (bitsPerComponent == 8) {                                for (int p = bytesPerPixel; p < rowlength; p++) {                    int sub = actline[p] & 0xff;                    int left = actline[p - bytesPerPixel] & 0xff;                    actline[p] = (byte) (sub + left);                }                break;            }            if (bitsPerComponent == 16) {                for (int p = bytesPerPixel; p < rowlength; p += 2) {                    int sub = ((actline[p] & 0xff) << 8) + (actline[p + 1] & 0xff);                    int left = (((actline[p - bytesPerPixel] & 0xff) << 8) + (actline[p - bytesPerPixel + 1] & 0xff));                    actline[p] = (byte) (((sub + left) >> 8) & 0xff);                    actline[p + 1] = (byte) ((sub + left) & 0xff);                }                break;            }            if (bitsPerComponent == 1 && colors == 1) {                                for (int p = 0; p < rowlength; p++) {                    for (int bit = 7; bit >= 0; --bit) {                        int sub = (actline[p] >> bit) & 1;                        if (p == 0 && bit == 7) {                            continue;                        }                        int left;                        if (bit == 7) {                                                        left = actline[p - 1] & 1;                        } else {                                                        left = (actline[p] >> (bit + 1)) & 1;                        }                        if (((sub + left) & 1) == 0) {                                                        actline[p] = (byte) (actline[p] & ~(1 << bit));                        } else {                                                        actline[p] = (byte) (actline[p] | (1 << bit));                        }                    }                }                break;            }                        int elements = columns * colors;            for (int p = colors; p < elements; ++p) {                int bytePosSub = p * bitsPerComponent / 8;                int bitPosSub = 8 - p * bitsPerComponent % 8 - bitsPerComponent;                int bytePosLeft = (p - colors) * bitsPerComponent / 8;                int bitPosLeft = 8 - (p - colors) * bitsPerComponent % 8 - bitsPerComponent;                int sub = getBitSeq(actline[bytePosSub], bitPosSub, bitsPerComponent);                int left = getBitSeq(actline[bytePosLeft], bitPosLeft, bitsPerComponent);                actline[bytePosSub] = (byte) calcSetBitSeq(actline[bytePosSub], bitPosSub, bitsPerComponent, sub + left);            }            break;        case 10:                        break;        case 11:                        for (int p = bytesPerPixel; p < rowlength; p++) {                int sub = actline[p];                int left = actline[p - bytesPerPixel];                actline[p] = (byte) (sub + left);            }            break;        case 12:                        for (int p = 0; p < rowlength; p++) {                int up = actline[p] & 0xff;                int prior = lastline[p] & 0xff;                actline[p] = (byte) ((up + prior) & 0xff);            }            break;        case 13:                        for (int p = 0; p < rowlength; p++) {                int avg = actline[p] & 0xff;                int left = p - bytesPerPixel >= 0 ? actline[p - bytesPerPixel] & 0xff : 0;                int up = lastline[p] & 0xff;                actline[p] = (byte) ((avg + (left + up) / 2) & 0xff);            }            break;        case 14:                        for (int p = 0; p < rowlength; p++) {                int paeth = actline[p] & 0xff;                                int a = p - bytesPerPixel >= 0 ? actline[p - bytesPerPixel] & 0xff : 0;                                int b = lastline[p] & 0xff;                                int c = p - bytesPerPixel >= 0 ? lastline[p - bytesPerPixel] & 0xff : 0;                int value = a + b - c;                int absa = Math.abs(value - a);                int absb = Math.abs(value - b);                int absc = Math.abs(value - c);                if (absa <= absb && absa <= absc) {                    actline[p] = (byte) ((paeth + a) & 0xff);                } else if (absb <= absc) {                    actline[p] = (byte) ((paeth + b) & 0xff);                } else {                    actline[p] = (byte) ((paeth + c) & 0xff);                }            }            break;        default:            break;    }}
 static void pdfbox_f2848_0(int predictor, int colors, int bitsPerComponent, int columns, InputStream in, OutputStream out) throws IOException
{    if (predictor == 1) {                IOUtils.copy(in, out);    } else {                final int rowlength = calculateRowLength(colors, bitsPerComponent, columns);        byte[] actline = new byte[rowlength];        byte[] lastline = new byte[rowlength];        int linepredictor = predictor;        while (in.available() > 0) {                        if (predictor >= 10) {                                                linepredictor = in.read();                if (linepredictor == -1) {                    return;                }                                linepredictor += 10;            }                        int i, offset = 0;            while (offset < rowlength && ((i = in.read(actline, offset, rowlength - offset)) != -1)) {                offset += i;            }            decodePredictorRow(linepredictor, colors, bitsPerComponent, columns, actline, lastline);            System.arraycopy(actline, 0, lastline, 0, rowlength);            out.write(actline);        }    }}
 static int pdfbox_f2849_0(int colors, int bitsPerComponent, int columns)
{    final int bitsPerPixel = colors * bitsPerComponent;    return (columns * bitsPerPixel + 7) / 8;}
 static int pdfbox_f2850_0(int by, int startBit, int bitSize)
{    int mask = ((1 << bitSize) - 1);    return (by >>> startBit) & mask;}
 static int pdfbox_f2851_0(int by, int startBit, int bitSize, int val)
{    int mask = ((1 << bitSize) - 1);    int truncatedVal = val & mask;    mask = ~(mask << startBit);    return (by & mask) | (truncatedVal << startBit);}
 static OutputStream pdfbox_f2852_0(OutputStream out, COSDictionary decodeParams)
{    int predictor = decodeParams.getInt(COSName.PREDICTOR);    if (predictor > 1) {        int colors = Math.min(decodeParams.getInt(COSName.COLORS, 1), 32);        int bitsPerPixel = decodeParams.getInt(COSName.BITS_PER_COMPONENT, 8);        int columns = decodeParams.getInt(COSName.COLUMNS, 1);        return new PredictorOutputStream(out, predictor, colors, bitsPerPixel, columns);    } else {        return out;    }}
public void pdfbox_f2853_0(byte[] bytes) throws IOException
{    write(bytes, 0, bytes.length);}
public void pdfbox_f2854_0(byte[] bytes, int off, int len) throws IOException
{    int currentOffset = off;    int maxOffset = currentOffset + len;    while (currentOffset < maxOffset) {        if (predictorPerRow && currentRowData == 0 && !predictorRead) {                                    predictor = bytes[currentOffset] + 10;            currentOffset++;            predictorRead = true;        } else {            int toRead = Math.min(rowLength - currentRowData, maxOffset - currentOffset);            System.arraycopy(bytes, currentOffset, currentRow, currentRowData, toRead);            currentRowData += toRead;            currentOffset += toRead;                        if (currentRowData == currentRow.length) {                decodeAndWriteRow();            }        }    }}
private void pdfbox_f2855_0() throws IOException
{    decodePredictorRow(predictor, colors, bitsPerComponent, columns, currentRow, lastRow);    out.write(currentRow);    flipRows();}
private void pdfbox_f2856_0()
{    byte[] temp = lastRow;    lastRow = currentRow;    currentRow = temp;    currentRowData = 0;    predictorRead = false;}
public void pdfbox_f2857_0() throws IOException
{        if (currentRowData > 0) {        Arrays.fill(currentRow, currentRowData, rowLength, (byte) 0);        decodeAndWriteRow();    }    super.flush();}
public void pdfbox_f2858_0(int i) throws IOException
{    throw new UnsupportedOperationException("Not supported");}
public DecodeResult pdfbox_f2859_0(InputStream encoded, OutputStream decoded, COSDictionary parameters, int index) throws IOException
{    int dupAmount;    byte[] buffer = new byte[128];    while ((dupAmount = encoded.read()) != -1 && dupAmount != RUN_LENGTH_EOD) {        if (dupAmount <= 127) {            int amountToCopy = dupAmount + 1;            int compressedRead;            while (amountToCopy > 0) {                compressedRead = encoded.read(buffer, 0, amountToCopy);                                if (compressedRead == -1) {                    break;                }                decoded.write(buffer, 0, compressedRead);                amountToCopy -= compressedRead;            }        } else {            int dupByte = encoded.read();                        if (dupByte == -1) {                break;            }            for (int i = 0; i < 257 - dupAmount; i++) {                decoded.write(dupByte);            }        }    }    return new DecodeResult(parameters);}
protected void pdfbox_f2860_1(InputStream input, OutputStream encoded, COSDictionary parameters) throws IOException
{    }
public static byte[] pdfbox_f2861_0(InputStream in) throws IOException
{    ByteArrayOutputStream baout = new ByteArrayOutputStream();    copy(in, baout);    return baout.toByteArray();}
public static long pdfbox_f2862_0(InputStream input, OutputStream output) throws IOException
{    byte[] buffer = new byte[4096];    long count = 0;    int n = 0;    while (-1 != (n = input.read(buffer))) {        output.write(buffer, 0, n);        count += n;    }    return count;}
public static long pdfbox_f2863_0(InputStream in, byte[] buffer) throws IOException
{    int remaining = buffer.length;    while (remaining > 0) {        int bufferWritePos = buffer.length - remaining;        int bytesRead = in.read(buffer, bufferWritePos, remaining);        if (bytesRead < 0) {                        break;        }        remaining -= bytesRead;    }    return buffer.length - remaining;}
public static void pdfbox_f2864_1(Closeable closeable)
{    try {        if (closeable != null) {            closeable.close();        }    } catch (IOException ioe) {                }}
public static IOException pdfbox_f2865_1(Closeable closeable, Log logger, String resourceName, IOException initialException)
{    try {        closeable.close();    } catch (IOException ioe) {                if (initialException == null) {            return ioe;        }    }    return initialException;}
public static MemoryUsageSetting pdfbox_f2866_0()
{    return setupMainMemoryOnly(-1);}
public static MemoryUsageSetting pdfbox_f2867_0(long maxMainMemoryBytes)
{    return new MemoryUsageSetting(true, false, maxMainMemoryBytes, maxMainMemoryBytes);}
public static MemoryUsageSetting pdfbox_f2868_0()
{    return setupTempFileOnly(-1);}
public static MemoryUsageSetting pdfbox_f2869_0(long maxStorageBytes)
{    return new MemoryUsageSetting(false, true, 0, maxStorageBytes);}
public static MemoryUsageSetting pdfbox_f2870_0(long maxMainMemoryBytes)
{    return setupMixed(maxMainMemoryBytes, -1);}
public static MemoryUsageSetting pdfbox_f2871_0(long maxMainMemoryBytes, long maxStorageBytes)
{    return new MemoryUsageSetting(true, true, maxMainMemoryBytes, maxStorageBytes);}
public MemoryUsageSetting pdfbox_f2872_0(int parallelUseCount)
{    long newMaxMainMemoryBytes = maxMainMemoryBytes <= 0 ? maxMainMemoryBytes : maxMainMemoryBytes / parallelUseCount;    long newMaxStorageBytes = maxStorageBytes <= 0 ? maxStorageBytes : maxStorageBytes / parallelUseCount;    MemoryUsageSetting copy = new MemoryUsageSetting(useMainMemory, useTempFile, newMaxMainMemoryBytes, newMaxStorageBytes);    copy.tempDir = tempDir;    return copy;}
public MemoryUsageSetting pdfbox_f2873_0(File tempDir)
{    this.tempDir = tempDir;    return this;}
public boolean pdfbox_f2874_0()
{    return useMainMemory;}
public boolean pdfbox_f2875_0()
{    return useTempFile;}
public boolean pdfbox_f2876_0()
{    return maxMainMemoryBytes >= 0;}
public boolean pdfbox_f2877_0()
{    return maxStorageBytes > 0;}
public long pdfbox_f2878_0()
{    return maxMainMemoryBytes;}
public long pdfbox_f2879_0()
{    return maxStorageBytes;}
public File pdfbox_f2880_0()
{    return tempDir;}
public String pdfbox_f2881_0()
{    return useMainMemory ? (useTempFile ? "Mixed mode with max. of " + maxMainMemoryBytes + " main memory bytes" + (isStorageRestricted() ? " and max. of " + maxStorageBytes + " storage bytes" : " and unrestricted scratch file size") : (isMainMemoryRestricted() ? "Main memory only with max. of " + maxMainMemoryBytes + " bytes" : "Main memory only with no size restriction")) : (isStorageRestricted() ? "Scratch file only with max. of " + maxStorageBytes + " bytes" : "Scratch file only with no size restriction");}
public RandomAccessBuffer pdfbox_f2882_0()
{    RandomAccessBuffer copy = new RandomAccessBuffer(chunkSize);    copy.bufferList = new ArrayList<>(bufferList.size());    for (byte[] buffer : bufferList) {        byte[] newBuffer = new byte[buffer.length];        System.arraycopy(buffer, 0, newBuffer, 0, buffer.length);        copy.bufferList.add(newBuffer);    }    if (currentBuffer != null) {        copy.currentBuffer = copy.bufferList.get(copy.bufferList.size() - 1);    } else {        copy.currentBuffer = null;    }    copy.pointer = pointer;    copy.currentBufferPointer = currentBufferPointer;    copy.size = size;    copy.bufferListIndex = bufferListIndex;    copy.bufferListMaxIndex = bufferListMaxIndex;    return copy;}
public void pdfbox_f2883_0() throws IOException
{    currentBuffer = null;    bufferList.clear();    pointer = 0;    currentBufferPointer = 0;    size = 0;    bufferListIndex = 0;}
public void pdfbox_f2884_0()
{    bufferList.clear();    currentBuffer = new byte[chunkSize];    bufferList.add(currentBuffer);    pointer = 0;    currentBufferPointer = 0;    size = 0;    bufferListIndex = 0;    bufferListMaxIndex = 0;}
public void pdfbox_f2885_0(long position) throws IOException
{    checkClosed();    if (position < 0) {        throw new IOException("Invalid position " + position);    }    pointer = position;    if (pointer < size) {                bufferListIndex = (int) (pointer / chunkSize);        currentBufferPointer = (int) (pointer % chunkSize);        currentBuffer = bufferList.get(bufferListIndex);    } else {                        bufferListIndex = bufferListMaxIndex;        currentBuffer = bufferList.get(bufferListIndex);        currentBufferPointer = (int) (size % chunkSize);    }}
public long pdfbox_f2886_0() throws IOException
{    checkClosed();    return pointer;}
public int pdfbox_f2887_0() throws IOException
{    checkClosed();    if (pointer >= this.size) {        return -1;    }    if (currentBufferPointer >= chunkSize) {        if (bufferListIndex >= bufferListMaxIndex) {            return -1;        } else {            currentBuffer = bufferList.get(++bufferListIndex);            currentBufferPointer = 0;        }    }    pointer++;    return currentBuffer[currentBufferPointer++] & 0xff;}
public int pdfbox_f2888_0(byte[] b, int offset, int length) throws IOException
{    checkClosed();    if (pointer >= size) {        return 0;    }    int bytesRead = readRemainingBytes(b, offset, length);    while (bytesRead < length && available() > 0) {        bytesRead += readRemainingBytes(b, offset + bytesRead, length - bytesRead);        if (currentBufferPointer == chunkSize) {            nextBuffer();        }    }    return bytesRead;}
private int pdfbox_f2889_0(byte[] b, int offset, int length) throws IOException
{    if (pointer >= size) {        return 0;    }    int maxLength = (int) Math.min(length, size - pointer);    int remainingBytes = chunkSize - currentBufferPointer;        if (remainingBytes == 0) {        return 0;    }    if (maxLength >= remainingBytes) {                System.arraycopy(currentBuffer, currentBufferPointer, b, offset, remainingBytes);                currentBufferPointer += remainingBytes;        pointer += remainingBytes;        return remainingBytes;    } else {                System.arraycopy(currentBuffer, currentBufferPointer, b, offset, maxLength);                currentBufferPointer += maxLength;        pointer += maxLength;        return maxLength;    }}
public long pdfbox_f2890_0() throws IOException
{    checkClosed();    return size;}
public void pdfbox_f2891_0(int b) throws IOException
{    checkClosed();        if (currentBufferPointer >= chunkSize) {        if (pointer + chunkSize >= Integer.MAX_VALUE) {            throw new IOException("RandomAccessBuffer overflow");        }        expandBuffer();    }    currentBuffer[currentBufferPointer++] = (byte) b;    pointer++;    if (pointer > this.size) {        this.size = pointer;    }        if (currentBufferPointer >= chunkSize) {        if (pointer + chunkSize >= Integer.MAX_VALUE) {            throw new IOException("RandomAccessBuffer overflow");        }        expandBuffer();    }}
public void pdfbox_f2892_0(byte[] b) throws IOException
{    write(b, 0, b.length);}
public void pdfbox_f2893_0(byte[] b, int offset, int length) throws IOException
{    checkClosed();    long newSize = pointer + length;    int remainingBytes = chunkSize - currentBufferPointer;    if (length >= remainingBytes) {        if (newSize > Integer.MAX_VALUE) {            throw new IOException("RandomAccessBuffer overflow");        }                System.arraycopy(b, offset, currentBuffer, currentBufferPointer, remainingBytes);        int newOffset = offset + remainingBytes;        long remainingBytes2Write = length - remainingBytes;                int numberOfNewArrays = (int) remainingBytes2Write / chunkSize;        for (int i = 0; i < numberOfNewArrays; i++) {            expandBuffer();            System.arraycopy(b, newOffset, currentBuffer, currentBufferPointer, chunkSize);            newOffset += chunkSize;        }                remainingBytes2Write -= numberOfNewArrays * (long) chunkSize;        if (remainingBytes2Write >= 0) {            expandBuffer();            if (remainingBytes2Write > 0) {                System.arraycopy(b, newOffset, currentBuffer, currentBufferPointer, (int) remainingBytes2Write);            }            currentBufferPointer = (int) remainingBytes2Write;        }    } else {        System.arraycopy(b, offset, currentBuffer, currentBufferPointer, length);        currentBufferPointer += length;    }    pointer += length;    if (pointer > this.size) {        this.size = pointer;    }}
private void pdfbox_f2894_0() throws IOException
{    if (bufferListMaxIndex > bufferListIndex) {                nextBuffer();    } else {                currentBuffer = new byte[chunkSize];        bufferList.add(currentBuffer);        currentBufferPointer = 0;        bufferListMaxIndex++;        bufferListIndex++;    }}
private void pdfbox_f2895_0() throws IOException
{    if (bufferListIndex == bufferListMaxIndex) {        throw new IOException("No more chunks available, end of buffer reached");    }    currentBufferPointer = 0;    currentBuffer = bufferList.get(++bufferListIndex);}
private void pdfbox_f2896_0() throws IOException
{    if (currentBuffer == null) {                throw new IOException("RandomAccessBuffer already closed");    }}
public boolean pdfbox_f2897_0()
{    return currentBuffer == null;}
public boolean pdfbox_f2898_0() throws IOException
{    checkClosed();    return pointer >= size;}
public int pdfbox_f2899_0() throws IOException
{    return (int) Math.min(length() - getPosition(), Integer.MAX_VALUE);}
public int pdfbox_f2900_0() throws IOException
{    int result = read();    if (result != -1) {        rewind(1);    }    return result;}
public void pdfbox_f2901_0(int bytes) throws IOException
{    checkClosed();    seek(getPosition() - bytes);}
public byte[] pdfbox_f2902_0(int length) throws IOException
{    byte[] b = new byte[length];    int bytesRead = read(b);    while (bytesRead < length) {        bytesRead += read(b, bytesRead, length - bytesRead);    }    return b;}
public int pdfbox_f2903_0(byte[] b) throws IOException
{    return read(b, 0, b.length);}
protected boolean pdfbox_f2904_0(Map.Entry<Long, byte[]> eldest)
{    final boolean doRemove = size() > maxCachedPages;    if (doRemove) {        lastRemovedCachePage = eldest.getValue();    }    return doRemove;}
private File pdfbox_f2905_0(InputStream input) throws IOException
{    File tmpFile = File.createTempFile(TMP_FILE_PREFIX, ".pdf");    try (FileOutputStream fos = new FileOutputStream(tmpFile)) {        IOUtils.copy(input, fos);        return tmpFile;    } finally {        IOUtils.closeQuietly(input);    }}
private void pdfbox_f2906_0()
{    if (tempFile != null) {        tempFile.delete();    }}
public long pdfbox_f2907_0()
{    return fileOffset;}
public void pdfbox_f2908_0(final long newOffset) throws IOException
{    final long newPageOffset = newOffset & pageOffsetMask;    if (newPageOffset != curPageOffset) {        byte[] newPage = pageCache.get(newPageOffset);        if (newPage == null) {            raFile.seek(newPageOffset);            newPage = readPage();            pageCache.put(newPageOffset, newPage);        }        curPageOffset = newPageOffset;        curPage = newPage;    }    offsetWithinPage = (int) (newOffset - curPageOffset);    fileOffset = newOffset;}
private byte[] pdfbox_f2909_0() throws IOException
{    byte[] page;    if (lastRemovedCachePage != null) {        page = lastRemovedCachePage;        lastRemovedCachePage = null;    } else {        page = new byte[pageSize];    }    int readBytes = 0;    while (readBytes < pageSize) {        int curBytesRead = raFile.read(page, readBytes, pageSize - readBytes);        if (curBytesRead < 0) {                        break;        }        readBytes += curBytesRead;    }    return page;}
public int pdfbox_f2910_0() throws IOException
{    if (fileOffset >= fileLength) {        return -1;    }    if (offsetWithinPage == pageSize) {        seek(fileOffset);    }    fileOffset++;    return curPage[offsetWithinPage++] & 0xff;}
public int pdfbox_f2911_0(byte[] b) throws IOException
{    return read(b, 0, b.length);}
public int pdfbox_f2912_0(byte[] b, int off, int len) throws IOException
{    if (fileOffset >= fileLength) {        return -1;    }    if (offsetWithinPage == pageSize) {        seek(fileOffset);    }    int commonLen = Math.min(pageSize - offsetWithinPage, len);    if ((fileLength - fileOffset) < pageSize) {        commonLen = Math.min(commonLen, (int) (fileLength - fileOffset));    }    System.arraycopy(curPage, offsetWithinPage, b, off, commonLen);    offsetWithinPage += commonLen;    fileOffset += commonLen;    return commonLen;}
public int pdfbox_f2913_0() throws IOException
{    return (int) Math.min(fileLength - fileOffset, Integer.MAX_VALUE);}
public long pdfbox_f2914_0(long n) throws IOException
{        long toSkip = n;    if (fileLength - fileOffset < toSkip) {        toSkip = fileLength - fileOffset;    }    if ((toSkip < pageSize) && ((offsetWithinPage + toSkip) <= pageSize)) {                offsetWithinPage += toSkip;        fileOffset += toSkip;    } else {                seek(fileOffset + toSkip);    }    return toSkip;}
public long pdfbox_f2915_0() throws IOException
{    return fileLength;}
public void pdfbox_f2916_0() throws IOException
{    raFile.close();    deleteTempFile();    pageCache.clear();    isClosed = true;}
public boolean pdfbox_f2917_0()
{    return isClosed;}
public int pdfbox_f2918_0() throws IOException
{    int result = read();    if (result != -1) {        rewind(1);    }    return result;}
public void pdfbox_f2919_0(int bytes) throws IOException
{    seek(getPosition() - bytes);}
public byte[] pdfbox_f2920_0(int length) throws IOException
{    byte[] b = new byte[length];    int bytesRead = read(b);    while (bytesRead < length) {        bytesRead += read(b, bytesRead, length - bytesRead);    }    return b;}
public boolean pdfbox_f2921_0() throws IOException
{    int peek = peek();    return peek == -1;}
public void pdfbox_f2922_0() throws IOException
{    ras.close();    isClosed = true;}
public void pdfbox_f2923_0() throws IOException
{    checkClosed();    ras.seek(0);    ras.setLength(0);}
public void pdfbox_f2924_0(long position) throws IOException
{    checkClosed();    ras.seek(position);}
public long pdfbox_f2925_0() throws IOException
{    checkClosed();    return ras.getFilePointer();}
public int pdfbox_f2926_0() throws IOException
{    checkClosed();    return ras.read();}
public int pdfbox_f2927_0(byte[] b) throws IOException
{    checkClosed();    return ras.read(b);}
public int pdfbox_f2928_0(byte[] b, int offset, int length) throws IOException
{    checkClosed();    return ras.read(b, offset, length);}
public long pdfbox_f2929_0() throws IOException
{    checkClosed();    return ras.length();}
private void pdfbox_f2930_0() throws IOException
{    if (isClosed) {        throw new IOException("RandomAccessFile already closed");    }}
public boolean pdfbox_f2931_0()
{    return isClosed;}
public void pdfbox_f2932_0(byte[] b, int offset, int length) throws IOException
{    checkClosed();    ras.write(b, offset, length);}
public void pdfbox_f2933_0(byte[] b) throws IOException
{    write(b, 0, b.length);}
public void pdfbox_f2934_0(int b) throws IOException
{    checkClosed();    ras.write(b);}
public int pdfbox_f2935_0() throws IOException
{    int result = read();    if (result != -1) {        rewind(1);    }    return result;}
public void pdfbox_f2936_0(int bytes) throws IOException
{    checkClosed();    ras.seek(ras.getFilePointer() - bytes);}
public byte[] pdfbox_f2937_0(int length) throws IOException
{    checkClosed();    byte[] b = new byte[length];    ras.readFully(b);    return b;}
public boolean pdfbox_f2938_0() throws IOException
{    return peek() == -1;}
public int pdfbox_f2939_0() throws IOException
{    checkClosed();    return (int) Math.min(ras.length() - getPosition(), Integer.MAX_VALUE);}
 void pdfbox_f2940_0() throws IOException
{    input.seek(position);}
public int pdfbox_f2941_0() throws IOException
{    restorePosition();    long available = input.length() - input.getPosition();    if (available > Integer.MAX_VALUE) {        return Integer.MAX_VALUE;    }    return (int) available;}
public int pdfbox_f2942_1() throws IOException
{    restorePosition();    if (input.isEOF()) {        return -1;    }    int b = input.read();    if (b != -1) {        position += 1;    } else {                            }    return b;}
public int pdfbox_f2943_1(byte[] b, int off, int len) throws IOException
{    restorePosition();    if (input.isEOF()) {        return -1;    }    int n = input.read(b, off, len);    if (n != -1) {        position += n;    } else {                            }    return n;}
public long pdfbox_f2944_0(long n) throws IOException
{    restorePosition();    input.seek(position + n);    position += n;    return n;}
public void pdfbox_f2945_0(byte[] b, int offset, int length) throws IOException
{    writer.write(b, offset, length);}
public void pdfbox_f2946_0(byte[] b) throws IOException
{    writer.write(b);}
public void pdfbox_f2947_0(int b) throws IOException
{    writer.write(b);}
public static ScratchFile pdfbox_f2948_1()
{    try {        return new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly());    } catch (IOException ioe) {                        return null;    }}
public static ScratchFile pdfbox_f2949_1(long maxMainMemoryBytes)
{    try {        return new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(maxMainMemoryBytes));    } catch (IOException ioe) {                        return null;    }}
 int pdfbox_f2950_0() throws IOException
{    synchronized (freePages) {        int idx = freePages.nextSetBit(0);        if (idx < 0) {            enlarge();            idx = freePages.nextSetBit(0);            if (idx < 0) {                throw new IOException("Maximum allowed scratch file memory exceeded.");            }        }        freePages.clear(idx);        if (idx >= pageCount) {            pageCount = idx + 1;        }        return idx;    }}
private void pdfbox_f2951_1() throws IOException
{    synchronized (ioLock) {        checkClosed();        if (pageCount >= maxPageCount) {            return;        }        if (useScratchFile) {                        if (raf == null) {                file = File.createTempFile("PDFBox", ".tmp", scratchFileDirectory);                try {                    raf = new java.io.RandomAccessFile(file, "rw");                } catch (IOException e) {                    if (!file.delete()) {                                            }                    throw e;                }            }            long fileLen = raf.length();            long expectedFileLen = ((long) pageCount - inMemoryMaxPageCount) * PAGE_SIZE;            if (expectedFileLen != fileLen) {                throw new IOException("Expected scratch file size of " + expectedFileLen + " but found " + fileLen);            }                        if (pageCount + ENLARGE_PAGE_COUNT > pageCount) {                fileLen += ENLARGE_PAGE_COUNT * PAGE_SIZE;                raf.setLength(fileLen);                freePages.set(pageCount, pageCount + ENLARGE_PAGE_COUNT);            }        } else if (!maxMainMemoryIsRestricted) {                        int oldSize = inMemoryPages.length;                        int newSize = (int) Math.min(((long) oldSize) * 2, Integer.MAX_VALUE);            if (newSize > oldSize) {                byte[][] newInMemoryPages = new byte[newSize][];                System.arraycopy(inMemoryPages, 0, newInMemoryPages, 0, oldSize);                inMemoryPages = newInMemoryPages;                freePages.set(oldSize, newSize);            }        }    }}
 int pdfbox_f2952_0()
{    return PAGE_SIZE;}
 byte[] pdfbox_f2953_0(int pageIdx) throws IOException
{    if ((pageIdx < 0) || (pageIdx >= pageCount)) {        checkClosed();        throw new IOException("Page index out of range: " + pageIdx + ". Max value: " + (pageCount - 1));    }        if (pageIdx < inMemoryMaxPageCount) {        byte[] page = inMemoryPages[pageIdx];                if (page == null) {            checkClosed();            throw new IOException("Requested page with index " + pageIdx + " was not written before.");        }        return page;    }    synchronized (ioLock) {        if (raf == null) {            checkClosed();            throw new IOException("Missing scratch file to read page with index " + pageIdx + " from.");        }        byte[] page = new byte[PAGE_SIZE];        raf.seek(((long) pageIdx - inMemoryMaxPageCount) * PAGE_SIZE);        raf.readFully(page);        return page;    }}
 void pdfbox_f2954_0(int pageIdx, byte[] page) throws IOException
{    if ((pageIdx < 0) || (pageIdx >= pageCount)) {        checkClosed();        throw new IOException("Page index out of range: " + pageIdx + ". Max value: " + (pageCount - 1));    }    if (page.length != PAGE_SIZE) {        throw new IOException("Wrong page size to write: " + page.length + ". Expected: " + PAGE_SIZE);    }    if (pageIdx < inMemoryMaxPageCount) {        if (maxMainMemoryIsRestricted) {            inMemoryPages[pageIdx] = page;        } else {                        synchronized (ioLock) {                inMemoryPages[pageIdx] = page;            }        }                checkClosed();    } else {        synchronized (ioLock) {            checkClosed();            raf.seek(((long) pageIdx - inMemoryMaxPageCount) * PAGE_SIZE);            raf.write(page);        }    }}
 void pdfbox_f2955_0() throws IOException
{    if (isClosed) {        throw new IOException("Scratch file already closed");    }}
public RandomAccess pdfbox_f2956_0() throws IOException
{    return new ScratchFileBuffer(this);}
public RandomAccess pdfbox_f2957_0(InputStream input) throws IOException
{    ScratchFileBuffer buf = new ScratchFileBuffer(this);    byte[] byteBuffer = new byte[8192];    int bytesRead;    while ((bytesRead = input.read(byteBuffer)) > -1) {        buf.write(byteBuffer, 0, bytesRead);    }    buf.seek(0);    return buf;}
 void pdfbox_f2958_0(int[] pageIndexes, int off, int count)
{    synchronized (freePages) {        for (int aIdx = off; aIdx < count; aIdx++) {            int pageIdx = pageIndexes[aIdx];            if ((pageIdx >= 0) && (pageIdx < pageCount) && (!freePages.get(pageIdx))) {                freePages.set(pageIdx);                if (pageIdx < inMemoryMaxPageCount) {                                        inMemoryPages[pageIdx] = null;                                }            }        }    }}
public void pdfbox_f2959_0() throws IOException
{    IOException ioexc = null;    synchronized (ioLock) {        if (isClosed) {            return;        }        isClosed = true;        if (raf != null) {            try {                raf.close();            } catch (IOException ioe) {                ioexc = ioe;            }        }        if (file != null) {            if (!file.delete()) {                if (file.exists() && (ioexc == null)) {                    ioexc = new IOException("Error deleting scratch file: " + file.getAbsolutePath());                }            }        }    }    synchronized (freePages) {        freePages.clear();        pageCount = 0;    }    if (ioexc != null) {        throw ioexc;    }}
private void pdfbox_f2960_0() throws IOException
{    if (pageHandler == null) {        throw new IOException("Buffer already closed");    }    pageHandler.checkClosed();}
private void pdfbox_f2961_0() throws IOException
{    if (pageCount + 1 >= pageIndexes.length) {        int newSize = pageIndexes.length * 2;                if (newSize < pageIndexes.length) {            if (pageIndexes.length == Integer.MAX_VALUE) {                throw new IOException("Maximum buffer size reached.");            }            newSize = Integer.MAX_VALUE;        }        int[] newPageIndexes = new int[newSize];        System.arraycopy(pageIndexes, 0, newPageIndexes, 0, pageCount);        pageIndexes = newPageIndexes;    }    int newPageIdx = pageHandler.getNewPage();    pageIndexes[pageCount] = newPageIdx;    currentPagePositionInPageIndexes = pageCount;    currentPageOffset = ((long) pageCount) * pageSize;    pageCount++;    currentPage = new byte[pageSize];    positionInPage = 0;}
public long pdfbox_f2962_0() throws IOException
{    return size;}
private boolean pdfbox_f2963_0(boolean addNewPageIfNeeded) throws IOException
{    if (positionInPage >= pageSize) {                if (currentPageContentChanged) {                        pageHandler.writePage(pageIndexes[currentPagePositionInPageIndexes], currentPage);            currentPageContentChanged = false;        }                if (currentPagePositionInPageIndexes + 1 < pageCount) {                        currentPage = pageHandler.readPage(pageIndexes[++currentPagePositionInPageIndexes]);            currentPageOffset = ((long) currentPagePositionInPageIndexes) * pageSize;            positionInPage = 0;        } else if (addNewPageIfNeeded) {                        addPage();        } else {                        return false;        }    }    return true;}
public void pdfbox_f2964_0(int b) throws IOException
{    checkClosed();    ensureAvailableBytesInPage(true);    currentPage[positionInPage++] = (byte) b;    currentPageContentChanged = true;    if (currentPageOffset + positionInPage > size) {        size = currentPageOffset + positionInPage;    }}
public void pdfbox_f2965_0(byte[] b) throws IOException
{    write(b, 0, b.length);}
public void pdfbox_f2966_0(byte[] b, int off, int len) throws IOException
{    checkClosed();    int remain = len;    int bOff = off;    while (remain > 0) {        ensureAvailableBytesInPage(true);        int bytesToWrite = Math.min(remain, pageSize - positionInPage);        System.arraycopy(b, bOff, currentPage, positionInPage, bytesToWrite);        positionInPage += bytesToWrite;        currentPageContentChanged = true;        bOff += bytesToWrite;        remain -= bytesToWrite;    }    if (currentPageOffset + positionInPage > size) {        size = currentPageOffset + positionInPage;    }}
public final void pdfbox_f2967_0() throws IOException
{    checkClosed();        pageHandler.markPagesAsFree(pageIndexes, 1, pageCount - 1);    pageCount = 1;        if (currentPagePositionInPageIndexes > 0) {        currentPage = pageHandler.readPage(pageIndexes[0]);        currentPagePositionInPageIndexes = 0;        currentPageOffset = 0;    }    positionInPage = 0;    size = 0;    currentPageContentChanged = false;}
public long pdfbox_f2968_0() throws IOException
{    checkClosed();    return currentPageOffset + positionInPage;}
public void pdfbox_f2969_0(long seekToPosition) throws IOException
{    checkClosed();    /*         * for now we won't allow to seek past end of buffer; this can be changed by adding new pages as needed         */    if (seekToPosition > size) {        throw new EOFException();    }    if (seekToPosition < 0) {        throw new IOException("Negative seek offset: " + seekToPosition);    }    if ((seekToPosition >= currentPageOffset) && (seekToPosition <= currentPageOffset + pageSize)) {                positionInPage = (int) (seekToPosition - currentPageOffset);    } else {                if (currentPageContentChanged) {            pageHandler.writePage(pageIndexes[currentPagePositionInPageIndexes], currentPage);            currentPageContentChanged = false;        }        int newPagePosition = (int) (seekToPosition / pageSize);        currentPage = pageHandler.readPage(pageIndexes[newPagePosition]);        currentPagePositionInPageIndexes = newPagePosition;        currentPageOffset = ((long) currentPagePositionInPageIndexes) * pageSize;        positionInPage = (int) (seekToPosition - currentPageOffset);    }}
public boolean pdfbox_f2970_0()
{    return pageHandler == null;}
public int pdfbox_f2971_0() throws IOException
{    int result = read();    if (result != -1) {        rewind(1);    }    return result;}
public void pdfbox_f2972_0(int bytes) throws IOException
{    seek(currentPageOffset + positionInPage - bytes);}
public byte[] pdfbox_f2973_0(int len) throws IOException
{    byte[] b = new byte[len];    int n = 0;    do {        int count = read(b, n, len - n);        if (count < 0) {            throw new EOFException();        }        n += count;    } while (n < len);    return b;}
public boolean pdfbox_f2974_0() throws IOException
{    checkClosed();    return currentPageOffset + positionInPage >= size;}
public int pdfbox_f2975_0() throws IOException
{    checkClosed();    return (int) Math.min(size - (currentPageOffset + positionInPage), Integer.MAX_VALUE);}
public int pdfbox_f2976_0() throws IOException
{    checkClosed();    if (currentPageOffset + positionInPage >= size) {        return -1;    }    if (!ensureAvailableBytesInPage(false)) {                throw new IOException("Unexpectedly no bytes available for read in buffer.");    }    return currentPage[positionInPage++] & 0xff;}
public int pdfbox_f2977_0(byte[] b) throws IOException
{    return read(b, 0, b.length);}
public int pdfbox_f2978_0(byte[] b, int off, int len) throws IOException
{    checkClosed();    if (currentPageOffset + positionInPage >= size) {        return -1;    }    int remain = (int) Math.min(len, size - (currentPageOffset + positionInPage));    int totalBytesRead = 0;    int bOff = off;    while (remain > 0) {        if (!ensureAvailableBytesInPage(false)) {                        throw new IOException("Unexpectedly no bytes available for read in buffer.");        }        int readBytes = Math.min(remain, pageSize - positionInPage);        System.arraycopy(currentPage, positionInPage, b, bOff, readBytes);        positionInPage += readBytes;        totalBytesRead += readBytes;        bOff += readBytes;        remain -= readBytes;    }    return totalBytesRead;}
public void pdfbox_f2979_0() throws IOException
{    if (pageHandler != null) {        pageHandler.markPagesAsFree(pageIndexes, 0, pageCount);        pageHandler = null;        pageIndexes = null;        currentPage = null;        currentPageOffset = 0;        currentPagePositionInPageIndexes = -1;        positionInPage = 0;        size = 0;    }}
protected void pdfbox_f2980_1() throws Throwable
{    try {        if ((pageHandler != null) && LOG.isDebugEnabled()) {                    }        close();    } finally {        super.finalize();    }}
public PDDocument pdfbox_f2981_0()
{    return this.targetDoc;}
public void pdfbox_f2982_0(PDPage page) throws IOException
{    COSStream saveGraphicsStateStream = getDocument().getDocument().createCOSStream();    try (OutputStream saveStream = saveGraphicsStateStream.createOutputStream()) {        saveStream.write("q\n".getBytes("ISO-8859-1"));    }    COSStream restoreGraphicsStateStream = getDocument().getDocument().createCOSStream();    try (OutputStream restoreStream = restoreGraphicsStateStream.createOutputStream()) {        restoreStream.write("Q\n".getBytes("ISO-8859-1"));    }            COSDictionary pageDictionary = page.getCOSObject();    COSBase contents = pageDictionary.getDictionaryObject(COSName.CONTENTS);    if (contents instanceof COSStream) {        COSStream contentsStream = (COSStream) contents;        COSArray array = new COSArray();        array.add(saveGraphicsStateStream);        array.add(contentsStream);        array.add(restoreGraphicsStateStream);        pageDictionary.setItem(COSName.CONTENTS, array);    } else if (contents instanceof COSArray) {        COSArray contentsArray = (COSArray) contents;        contentsArray.add(0, saveGraphicsStateStream);        contentsArray.add(restoreGraphicsStateStream);    } else {        throw new IOException("Contents are unknown type: " + contents.getClass().getName());    }}
public PDFormXObject pdfbox_f2983_0(PDDocument sourceDoc, int pageNumber) throws IOException
{    PDPage page = sourceDoc.getPage(pageNumber);    return importPageAsForm(sourceDoc, page);}
public PDFormXObject pdfbox_f2984_0(PDDocument sourceDoc, PDPage page) throws IOException
{    importOcProperties(sourceDoc);    PDStream newStream = new PDStream(targetDoc, page.getContents(), COSName.FLATE_DECODE);    PDFormXObject form = new PDFormXObject(newStream);        PDResources pageRes = page.getResources();    PDResources formRes = new PDResources();    cloner.cloneMerge(pageRes, formRes);    form.setResources(formRes);        transferDict(page.getCOSObject(), form.getCOSObject(), PAGE_TO_FORM_FILTER, true);    Matrix matrix = form.getMatrix();    AffineTransform at = matrix.createAffineTransform();    PDRectangle mediaBox = page.getMediaBox();    PDRectangle cropBox = page.getCropBox();    PDRectangle viewBox = (cropBox != null ? cropBox : mediaBox);        int rotation = page.getRotation();            at.translate(mediaBox.getLowerLeftX() - viewBox.getLowerLeftX(), mediaBox.getLowerLeftY() - viewBox.getLowerLeftY());    switch(rotation) {        case 90:            at.scale(viewBox.getWidth() / viewBox.getHeight(), viewBox.getHeight() / viewBox.getWidth());            at.translate(0, viewBox.getWidth());            at.rotate(-Math.PI / 2.0);            break;        case 180:            at.translate(viewBox.getWidth(), viewBox.getHeight());            at.rotate(-Math.PI);            break;        case 270:            at.scale(viewBox.getWidth() / viewBox.getHeight(), viewBox.getHeight() / viewBox.getWidth());            at.translate(viewBox.getHeight(), 0);            at.rotate(-Math.PI * 1.5);            break;        default:    }        at.translate(-viewBox.getLowerLeftX(), -viewBox.getLowerLeftY());    if (!at.isIdentity()) {        form.setMatrix(at);    }    BoundingBox bbox = new BoundingBox();    bbox.setLowerLeftX(viewBox.getLowerLeftX());    bbox.setLowerLeftY(viewBox.getLowerLeftY());    bbox.setUpperRightX(viewBox.getUpperRightX());    bbox.setUpperRightY(viewBox.getUpperRightY());    form.setBBox(new PDRectangle(bbox));    return form;}
public PDOptionalContentGroup pdfbox_f2985_1(PDPage targetPage, PDFormXObject form, AffineTransform transform, String layerName) throws IOException
{    PDDocumentCatalog catalog = targetDoc.getDocumentCatalog();    PDOptionalContentProperties ocprops = catalog.getOCProperties();    if (ocprops == null) {        ocprops = new PDOptionalContentProperties();        catalog.setOCProperties(ocprops);    }    if (ocprops.hasGroup(layerName)) {        throw new IllegalArgumentException("Optional group (layer) already exists: " + layerName);    }    PDRectangle cropBox = targetPage.getCropBox();    if ((cropBox.getLowerLeftX() < 0 || cropBox.getLowerLeftY() < 0) && transform.isIdentity()) {                    }    PDOptionalContentGroup layer = new PDOptionalContentGroup(layerName);    ocprops.addGroup(layer);    try (PDPageContentStream contentStream = new PDPageContentStream(targetDoc, targetPage, AppendMode.APPEND, !DEBUG)) {        contentStream.beginMarkedContent(COSName.OC, layer);        contentStream.saveGraphicsState();        contentStream.transform(new Matrix(transform));        contentStream.drawForm(form);        contentStream.restoreGraphicsState();        contentStream.endMarkedContent();    }    return layer;}
private void pdfbox_f2986_0(COSDictionary orgDict, COSDictionary targetDict, Set<String> filter, boolean inclusive) throws IOException
{    for (Map.Entry<COSName, COSBase> entry : orgDict.entrySet()) {        COSName key = entry.getKey();        if (inclusive && !filter.contains(key.getName())) {            continue;        } else if (!inclusive && filter.contains(key.getName())) {            continue;        }        targetDict.setItem(key, cloner.cloneForNewDocument(entry.getValue()));    }}
private void pdfbox_f2987_0(PDDocument srcDoc) throws IOException
{    PDDocumentCatalog srcCatalog = srcDoc.getDocumentCatalog();    PDOptionalContentProperties srcOCProperties = srcCatalog.getOCProperties();    if (srcOCProperties == null) {        return;    }    PDDocumentCatalog dstCatalog = targetDoc.getDocumentCatalog();    PDOptionalContentProperties dstOCProperties = dstCatalog.getOCProperties();    if (dstOCProperties == null) {        dstCatalog.setOCProperties(new PDOptionalContentProperties((COSDictionary) cloner.cloneForNewDocument(srcOCProperties)));    } else {        cloner.cloneMerge(srcOCProperties, dstOCProperties);    }}
public PDDocument pdfbox_f2988_0(Map<Integer, String> specificPageOverlayFile) throws IOException
{    Map<String, PDDocument> loadedDocuments = new HashMap<>();    Map<PDDocument, LayoutPage> layouts = new HashMap<>();    loadPDFs();    for (Map.Entry<Integer, String> e : specificPageOverlayFile.entrySet()) {        PDDocument doc = loadedDocuments.get(e.getValue());        if (doc == null) {            doc = loadPDF(e.getValue());            loadedDocuments.put(e.getValue(), doc);            layouts.put(doc, getLayoutPage(doc));        }        openDocuments.add(doc);        specificPageOverlayPage.put(e.getKey(), layouts.get(doc));    }    processPages(inputPDFDocument);    return inputPDFDocument;}
public PDDocument pdfbox_f2989_0(Map<Integer, PDDocument> specificPageOverlayDocuments) throws IOException
{    loadPDFs();    for (Map.Entry<Integer, PDDocument> e : specificPageOverlayDocuments.entrySet()) {        PDDocument doc = e.getValue();        if (doc != null) {            specificPageOverlayPage.put(e.getKey(), getLayoutPage(doc));        }    }    processPages(inputPDFDocument);    return inputPDFDocument;}
public void pdfbox_f2990_0() throws IOException
{    if (defaultOverlay != null) {        defaultOverlay.close();    }    if (firstPageOverlay != null) {        firstPageOverlay.close();    }    if (lastPageOverlay != null) {        lastPageOverlay.close();    }    if (allPagesOverlay != null) {        allPagesOverlay.close();    }    if (oddPageOverlay != null) {        oddPageOverlay.close();    }    if (evenPageOverlay != null) {        evenPageOverlay.close();    }    for (PDDocument doc : openDocuments) {        doc.close();    }    openDocuments.clear();    specificPageOverlayPage.clear();}
private void pdfbox_f2991_0() throws IOException
{        if (inputFileName != null) {        inputPDFDocument = loadPDF(inputFileName);    }        if (defaultOverlayFilename != null) {        defaultOverlay = loadPDF(defaultOverlayFilename);    }    if (defaultOverlay != null) {        defaultOverlayPage = getLayoutPage(defaultOverlay);    }        if (firstPageOverlayFilename != null) {        firstPageOverlay = loadPDF(firstPageOverlayFilename);    }    if (firstPageOverlay != null) {        firstPageOverlayPage = getLayoutPage(firstPageOverlay);    }        if (lastPageOverlayFilename != null) {        lastPageOverlay = loadPDF(lastPageOverlayFilename);    }    if (lastPageOverlay != null) {        lastPageOverlayPage = getLayoutPage(lastPageOverlay);    }        if (oddPageOverlayFilename != null) {        oddPageOverlay = loadPDF(oddPageOverlayFilename);    }    if (oddPageOverlay != null) {        oddPageOverlayPage = getLayoutPage(oddPageOverlay);    }        if (evenPageOverlayFilename != null) {        evenPageOverlay = loadPDF(evenPageOverlayFilename);    }    if (evenPageOverlay != null) {        evenPageOverlayPage = getLayoutPage(evenPageOverlay);    }        if (allPagesOverlayFilename != null) {        allPagesOverlay = loadPDF(allPagesOverlayFilename);    }    if (allPagesOverlay != null) {        specificPageOverlayPage = getLayoutPages(allPagesOverlay);        useAllOverlayPages = true;        numberOfOverlayPages = specificPageOverlayPage.size();    }}
private PDDocument pdfbox_f2992_0(String pdfName) throws IOException
{    return PDDocument.load(new File(pdfName));}
private LayoutPage pdfbox_f2993_0(PDDocument doc) throws IOException
{    PDPage page = doc.getPage(0);    COSBase contents = page.getCOSObject().getDictionaryObject(COSName.CONTENTS);    PDResources resources = page.getResources();    if (resources == null) {        resources = new PDResources();    }    return new LayoutPage(page.getMediaBox(), createCombinedContentStream(contents), resources.getCOSObject(), page.getRotation());}
private Map<Integer, LayoutPage> pdfbox_f2994_0(PDDocument doc) throws IOException
{    int numberOfPages = doc.getNumberOfPages();    Map<Integer, LayoutPage> layoutPages = new HashMap<>(numberOfPages);    for (int i = 0; i < numberOfPages; i++) {        PDPage page = doc.getPage(i);        COSBase contents = page.getCOSObject().getDictionaryObject(COSName.CONTENTS);        PDResources resources = page.getResources();        if (resources == null) {            resources = new PDResources();        }        layoutPages.put(i, new LayoutPage(page.getMediaBox(), createCombinedContentStream(contents), resources.getCOSObject(), page.getRotation()));    }    return layoutPages;}
private COSStream pdfbox_f2995_0(COSBase contents) throws IOException
{    List<COSStream> contentStreams = createContentStreamList(contents);        COSStream concatStream = inputPDFDocument.getDocument().createCOSStream();    try (OutputStream out = concatStream.createOutputStream(COSName.FLATE_DECODE)) {        for (COSStream contentStream : contentStreams) {            try (InputStream in = contentStream.createInputStream()) {                IOUtils.copy(in, out);                out.flush();            }        }    }    return concatStream;}
private List<COSStream> pdfbox_f2996_0(COSBase contents) throws IOException
{    List<COSStream> contentStreams = new ArrayList<>();    if (contents == null) {        return contentStreams;    } else if (contents instanceof COSStream) {        contentStreams.add((COSStream) contents);    } else if (contents instanceof COSArray) {        for (COSBase item : (COSArray) contents) {            contentStreams.addAll(createContentStreamList(item));        }    } else if (contents instanceof COSObject) {        contentStreams.addAll(createContentStreamList(((COSObject) contents).getObject()));    } else {        throw new IOException("Unknown content type: " + contents.getClass().getName());    }    return contentStreams;}
private void pdfbox_f2997_0(PDDocument document) throws IOException
{    int pageCounter = 0;    for (PDPage page : document.getPages()) {        pageCounter++;        COSDictionary pageDictionary = page.getCOSObject();        COSBase originalContent = pageDictionary.getDictionaryObject(COSName.CONTENTS);        COSArray newContentArray = new COSArray();        LayoutPage layoutPage = getLayoutPage(pageCounter, document.getNumberOfPages());        if (layoutPage == null) {            continue;        }        switch(position) {            case FOREGROUND:                                newContentArray.add(createStream("q\n"));                addOriginalContent(originalContent, newContentArray);                                newContentArray.add(createStream("Q\n"));                                overlayPage(page, layoutPage, newContentArray);                break;            case BACKGROUND:                                overlayPage(page, layoutPage, newContentArray);                addOriginalContent(originalContent, newContentArray);                break;            default:                throw new IOException("Unknown type of position:" + position);        }        pageDictionary.setItem(COSName.CONTENTS, newContentArray);    }}
private void pdfbox_f2998_0(COSBase contents, COSArray contentArray) throws IOException
{    if (contents == null) {        return;    }    if (contents instanceof COSStream) {        contentArray.add(contents);    } else if (contents instanceof COSArray) {        contentArray.addAll((COSArray) contents);    } else {        throw new IOException("Unknown content type: " + contents.getClass().getName());    }}
private void pdfbox_f2999_0(PDPage page, LayoutPage layoutPage, COSArray array) throws IOException
{    PDResources resources = page.getResources();    if (resources == null) {        resources = new PDResources();        page.setResources(resources);    }    COSName xObjectId = createOverlayXObject(page, layoutPage);    array.add(createOverlayStream(page, layoutPage, xObjectId));}
private LayoutPage pdfbox_f3000_0(int pageNumber, int numberOfPages)
{    LayoutPage layoutPage = null;    if (!useAllOverlayPages && specificPageOverlayPage.containsKey(pageNumber)) {        layoutPage = specificPageOverlayPage.get(pageNumber);    } else if ((pageNumber == 1) && (firstPageOverlayPage != null)) {        layoutPage = firstPageOverlayPage;    } else if ((pageNumber == numberOfPages) && (lastPageOverlayPage != null)) {        layoutPage = lastPageOverlayPage;    } else if ((pageNumber % 2 == 1) && (oddPageOverlayPage != null)) {        layoutPage = oddPageOverlayPage;    } else if ((pageNumber % 2 == 0) && (evenPageOverlayPage != null)) {        layoutPage = evenPageOverlayPage;    } else if (defaultOverlayPage != null) {        layoutPage = defaultOverlayPage;    } else if (useAllOverlayPages) {        int usePageNum = (pageNumber - 1) % numberOfOverlayPages;        layoutPage = specificPageOverlayPage.get(usePageNum);    }    return layoutPage;}
private COSName pdfbox_f3001_0(PDPage page, LayoutPage layoutPage)
{    PDFormXObject xobjForm = new PDFormXObject(layoutPage.overlayContentStream);    xobjForm.setResources(new PDResources(layoutPage.overlayResources));    xobjForm.setFormType(1);    xobjForm.setBBox(layoutPage.overlayMediaBox.createRetranslatedRectangle());    AffineTransform at = new AffineTransform();    switch(layoutPage.overlayRotation) {        case 90:            at.translate(0, layoutPage.overlayMediaBox.getWidth());            at.rotate(Math.toRadians(-90));            break;        case 180:            at.translate(layoutPage.overlayMediaBox.getWidth(), layoutPage.overlayMediaBox.getHeight());            at.rotate(Math.toRadians(-180));            break;        case 270:            at.translate(layoutPage.overlayMediaBox.getHeight(), 0);            at.rotate(Math.toRadians(-270));            break;        default:            break;    }    xobjForm.setMatrix(at);    PDResources resources = page.getResources();    return resources.add(xobjForm, "OL");}
private COSStream pdfbox_f3002_0(PDPage page, LayoutPage layoutPage, COSName xObjectId) throws IOException
{        StringBuilder overlayStream = new StringBuilder();    overlayStream.append("q\nq\n");    PDRectangle overlayMediaBox = new PDRectangle(layoutPage.overlayMediaBox.getCOSArray());    if (layoutPage.overlayRotation == 90 || layoutPage.overlayRotation == 270) {        overlayMediaBox.setLowerLeftX(layoutPage.overlayMediaBox.getLowerLeftY());        overlayMediaBox.setLowerLeftY(layoutPage.overlayMediaBox.getLowerLeftX());        overlayMediaBox.setUpperRightX(layoutPage.overlayMediaBox.getUpperRightY());        overlayMediaBox.setUpperRightY(layoutPage.overlayMediaBox.getUpperRightX());    }    AffineTransform at = calculateAffineTransform(page, overlayMediaBox);    double[] flatmatrix = new double[6];    at.getMatrix(flatmatrix);    for (double v : flatmatrix) {        overlayStream.append(float2String((float) v));        overlayStream.append(" ");    }    overlayStream.append(" cm\n");                overlayStream.append(" /");    overlayStream.append(xObjectId.getName());    overlayStream.append(" Do Q\nQ\n");    return createStream(overlayStream.toString());}
protected AffineTransform pdfbox_f3003_0(PDPage page, PDRectangle overlayMediaBox)
{    AffineTransform at = new AffineTransform();    PDRectangle pageMediaBox = page.getMediaBox();    float hShift = (pageMediaBox.getWidth() - overlayMediaBox.getWidth()) / 2.0f;    float vShift = (pageMediaBox.getHeight() - overlayMediaBox.getHeight()) / 2.0f;    at.translate(hShift, vShift);    return at;}
private String pdfbox_f3004_0(float floatValue)
{            BigDecimal value = new BigDecimal(String.valueOf(floatValue));    String stringValue = value.toPlainString();        if (stringValue.indexOf('.') > -1 && !stringValue.endsWith(".0")) {        while (stringValue.endsWith("0") && !stringValue.endsWith(".0")) {            stringValue = stringValue.substring(0, stringValue.length() - 1);        }    }    return stringValue;}
private COSStream pdfbox_f3005_0(String content) throws IOException
{    COSStream stream = inputPDFDocument.getDocument().createCOSStream();    try (OutputStream out = stream.createOutputStream(content.length() > 20 ? COSName.FLATE_DECODE : null)) {        out.write(content.getBytes("ISO-8859-1"));    }    return stream;}
public void pdfbox_f3006_0(Position overlayPosition)
{    position = overlayPosition;}
public void pdfbox_f3007_0(String inputFile)
{    inputFileName = inputFile;}
public void pdfbox_f3008_0(PDDocument inputPDF)
{    inputPDFDocument = inputPDF;}
public String pdfbox_f3009_0()
{    return inputFileName;}
public void pdfbox_f3010_0(String defaultOverlayFile)
{    defaultOverlayFilename = defaultOverlayFile;}
public void pdfbox_f3011_0(PDDocument defaultOverlayPDF)
{    defaultOverlay = defaultOverlayPDF;}
public String pdfbox_f3012_0()
{    return defaultOverlayFilename;}
public void pdfbox_f3013_0(String firstPageOverlayFile)
{    firstPageOverlayFilename = firstPageOverlayFile;}
public void pdfbox_f3014_0(PDDocument firstPageOverlayPDF)
{    firstPageOverlay = firstPageOverlayPDF;}
public void pdfbox_f3015_0(String lastPageOverlayFile)
{    lastPageOverlayFilename = lastPageOverlayFile;}
public void pdfbox_f3016_0(PDDocument lastPageOverlayPDF)
{    lastPageOverlay = lastPageOverlayPDF;}
public void pdfbox_f3017_0(String allPagesOverlayFile)
{    allPagesOverlayFilename = allPagesOverlayFile;}
public void pdfbox_f3018_0(PDDocument allPagesOverlayPDF)
{    allPagesOverlay = allPagesOverlayPDF;}
public void pdfbox_f3019_0(String oddPageOverlayFile)
{    oddPageOverlayFilename = oddPageOverlayFile;}
public void pdfbox_f3020_0(PDDocument oddPageOverlayPDF)
{    oddPageOverlay = oddPageOverlayPDF;}
public void pdfbox_f3021_0(String evenPageOverlayFile)
{    evenPageOverlayFilename = evenPageOverlayFile;}
public void pdfbox_f3022_0(PDDocument evenPageOverlayPDF)
{    evenPageOverlay = evenPageOverlayPDF;}
public PDDocument pdfbox_f3023_0() throws IOException
{    PDDocument extractedDocument = new PDDocument();    extractedDocument.setDocumentInformation(sourceDocument.getDocumentInformation());    extractedDocument.getDocumentCatalog().setViewerPreferences(sourceDocument.getDocumentCatalog().getViewerPreferences());    for (int i = startPage; i <= endPage; i++) {        PDPage page = sourceDocument.getPage(i - 1);        PDPage imported = extractedDocument.importPage(page);        imported.setCropBox(page.getCropBox());        imported.setMediaBox(page.getMediaBox());        imported.setResources(page.getResources());        imported.setRotation(page.getRotation());    }    return extractedDocument;}
public int pdfbox_f3024_0()
{    return startPage;}
public void pdfbox_f3025_0(int startPage)
{    this.startPage = startPage;}
public int pdfbox_f3026_0()
{    return endPage;}
public void pdfbox_f3027_0(int endPage)
{    this.endPage = endPage;}
 PDDocument pdfbox_f3028_0()
{    return this.destination;}
 COSBase pdfbox_f3029_0(Object base) throws IOException
{    if (base == null) {        return null;    }    COSBase retval = clonedVersion.get(base);    if (retval != null) {                return retval;    }    if (base instanceof COSBase && clonedValues.contains(base)) {                return (COSBase) base;    }    if (base instanceof List) {        COSArray array = new COSArray();        List<?> list = (List<?>) base;        for (Object obj : list) {            array.add(cloneForNewDocument(obj));        }        retval = array;    } else if (base instanceof COSObjectable && !(base instanceof COSBase)) {        retval = cloneForNewDocument(((COSObjectable) base).getCOSObject());    } else if (base instanceof COSObject) {        COSObject object = (COSObject) base;        retval = cloneForNewDocument(object.getObject());    } else if (base instanceof COSArray) {        COSArray newArray = new COSArray();        COSArray array = (COSArray) base;        for (int i = 0; i < array.size(); i++) {            newArray.add(cloneForNewDocument(array.get(i)));        }        retval = newArray;    } else if (base instanceof COSStream) {        COSStream originalStream = (COSStream) base;        COSStream stream = destination.getDocument().createCOSStream();        try (OutputStream output = stream.createRawOutputStream();            InputStream input = originalStream.createRawInputStream()) {            IOUtils.copy(input, output);        }        clonedVersion.put(base, stream);        for (Map.Entry<COSName, COSBase> entry : originalStream.entrySet()) {            stream.setItem(entry.getKey(), cloneForNewDocument(entry.getValue()));        }        retval = stream;    } else if (base instanceof COSDictionary) {        COSDictionary dic = (COSDictionary) base;        retval = new COSDictionary();        clonedVersion.put(base, retval);        for (Map.Entry<COSName, COSBase> entry : dic.entrySet()) {            ((COSDictionary) retval).setItem(entry.getKey(), cloneForNewDocument(entry.getValue()));        }    } else {        retval = (COSBase) base;    }    clonedVersion.put(base, retval);    clonedValues.add(retval);    return retval;}
 void pdfbox_f3030_0(final COSObjectable base, COSObjectable target) throws IOException
{    if (base == null) {        return;    }    COSBase retval = clonedVersion.get(base);    if (retval != null) {        return;        }        if (!(base instanceof COSBase)) {        cloneMerge(base.getCOSObject(), target.getCOSObject());    } else if (base instanceof COSObject) {        if (target instanceof COSObject) {            cloneMerge(((COSObject) base).getObject(), ((COSObject) target).getObject());        } else if (target instanceof COSDictionary || target instanceof COSArray) {            cloneMerge(((COSObject) base).getObject(), target);        }    } else if (base instanceof COSArray) {        COSArray array = (COSArray) base;        for (int i = 0; i < array.size(); i++) {            ((COSArray) target).add(cloneForNewDocument(array.get(i)));        }    } else if (base instanceof COSStream) {                COSStream originalStream = (COSStream) base;        COSStream stream = destination.getDocument().createCOSStream();        try (OutputStream output = stream.createOutputStream(originalStream.getFilters())) {            IOUtils.copy(originalStream.createInputStream(), output);        }        clonedVersion.put(base, stream);        for (Map.Entry<COSName, COSBase> entry : originalStream.entrySet()) {            stream.setItem(entry.getKey(), cloneForNewDocument(entry.getValue()));        }        retval = stream;    } else if (base instanceof COSDictionary) {        COSDictionary dic = (COSDictionary) base;        clonedVersion.put(base, retval);        for (Map.Entry<COSName, COSBase> entry : dic.entrySet()) {            COSName key = entry.getKey();            COSBase value = entry.getValue();            if (((COSDictionary) target).getItem(key) != null) {                cloneMerge(value, ((COSDictionary) target).getItem(key));            } else {                ((COSDictionary) target).setItem(key, cloneForNewDocument(value));            }        }    } else {        retval = (COSBase) base;    }    clonedVersion.put(base, retval);    clonedValues.add(retval);}
public AcroFormMergeMode pdfbox_f3031_0()
{    return acroFormMergeMode;}
public void pdfbox_f3032_0(AcroFormMergeMode theAcroFormMergeMode)
{    this.acroFormMergeMode = theAcroFormMergeMode;}
public DocumentMergeMode pdfbox_f3033_0()
{    return documentMergeMode;}
public void pdfbox_f3034_0(DocumentMergeMode theDocumentMergeMode)
{    this.documentMergeMode = theDocumentMergeMode;}
public void pdfbox_f3035_0(DocumentMergeMode theDocumentMergeMode)
{    this.documentMergeMode = theDocumentMergeMode;}
public String pdfbox_f3036_0()
{    return destinationFileName;}
public void pdfbox_f3037_0(String destination)
{    destinationFileName = destination;}
public OutputStream pdfbox_f3038_0()
{    return destinationStream;}
