public boolean metron_f3099_0()
{    return logger.isWarnEnabled();}
public void metron_f3100_1(String msg)
{    }
public void metron_f3101_1(String format, Object arg)
{    }
public void metron_f3102_1(String format, Supplier<Object> arg)
{    if (logger.isWarnEnabled()) {            }}
public void metron_f3103_1(String format, Object... arguments)
{    }
public final void metron_f3104_1(String format, Supplier<Object>... arguments)
{    if (logger.isWarnEnabled()) {            }}
public void metron_f3105_1(String format, Object arg1, Object arg2)
{    }
public void metron_f3106_1(String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isWarnEnabled()) {            }}
public void metron_f3107_1(String msg, Throwable t)
{    }
public boolean metron_f3108_0(Marker marker)
{    return logger.isWarnEnabled(marker);}
public void metron_f3109_1(Marker marker, String msg)
{    }
public void metron_f3110_1(Marker marker, String format, Object arg)
{    }
public void metron_f3111_1(Marker marker, String format, Supplier<Object> arg)
{    if (logger.isWarnEnabled(marker)) {            }}
public void metron_f3112_1(Marker marker, String format, Object arg1, Object arg2)
{    }
public void metron_f3113_1(Marker marker, String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isWarnEnabled(marker)) {            }}
public void metron_f3114_1(Marker marker, String format, Object... arguments)
{    }
public final void metron_f3115_1(Marker marker, String format, Supplier<Object>... arguments)
{    if (logger.isWarnEnabled(marker)) {            }}
public void metron_f3116_1(Marker marker, String msg, Throwable t)
{    }
public boolean metron_f3117_0()
{    return logger.isErrorEnabled();}
public void metron_f3118_1(String msg)
{    }
public void metron_f3119_1(String format, Object arg)
{    }
public void metron_f3120_1(String format, Supplier<Object> arg)
{    if (logger.isErrorEnabled()) {            }}
public void metron_f3121_1(String format, Object arg1, Object arg2)
{    }
public void metron_f3122_1(String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isErrorEnabled()) {            }}
public void metron_f3123_1(String format, Object... arguments)
{    }
public final void metron_f3124_1(String format, Supplier<Object>... arguments)
{    if (logger.isErrorEnabled()) {            }}
public void metron_f3125_1(String msg, Throwable t)
{    }
public boolean metron_f3126_0(Marker marker)
{    return logger.isErrorEnabled(marker);}
public void metron_f3127_1(Marker marker, String msg)
{    }
public void metron_f3128_1(Marker marker, String format, Object arg)
{    }
public void metron_f3129_1(Marker marker, String format, Supplier<Object> arg)
{    if (logger.isErrorEnabled(marker)) {            }}
public void metron_f3130_1(Marker marker, String format, Object arg1, Object arg2)
{    }
public final void metron_f3131_1(Marker marker, String format, Supplier<Object> arg1, Supplier<Object> arg2)
{    if (logger.isErrorEnabled(marker)) {            }}
public void metron_f3132_1(Marker marker, String format, Object... arguments)
{    }
public final void metron_f3133_1(Marker marker, String format, Supplier<Object>... arguments)
{    if (logger.isErrorEnabled(marker)) {            }}
public void metron_f3134_1(Marker marker, String msg, Throwable t)
{    }
public static String metron_f3135_0(JSONObject message)
{    return (String) message.get(Constants.GUID);}
public static String metron_f3136_0(JSONObject message)
{    return (String) message.get(Constants.SENSOR_TYPE);}
public static T metron_f3137_0(String className, T defaultClass)
{    T instance;    if (className == null || className.length() == 0 || className.charAt(0) == '$') {        return defaultClass;    } else {        instance = createInstance(className);    }    return instance;}
public static T metron_f3138_0(String className)
{    T instance;    try {        Class<? extends T> clazz = (Class<? extends T>) Class.forName(className);        instance = createInstance(clazz);    } catch (ClassNotFoundException e) {        throw new IllegalStateException("Unable to instantiate connector: class not found", e);    }    return instance;}
public static T metron_f3139_0(Class<? extends T> clazz)
{    return createInstance(clazz, null, null);}
public static T metron_f3140_0(Class<? extends T> clazz, Class<?>[] parameterTypes, Object[] parameters)
{    T instance;    try {        if (parameterTypes != null) {            instance = clazz.getConstructor(parameterTypes).newInstance(parameters);        } else {            instance = clazz.getConstructor().newInstance();        }    } catch (InstantiationException e) {        throw new IllegalStateException("Unable to instantiate connector.", e);    } catch (IllegalAccessException e) {        throw new IllegalStateException("Unable to instantiate connector: illegal access", e);    } catch (InvocationTargetException e) {        throw new IllegalStateException("Unable to instantiate connector", e);    } catch (NoSuchMethodException e) {        throw new IllegalStateException("Unable to instantiate connector: no such method", e);    }    return instance;}
public static T metron_f3141_0(String className, Class<?>[] parameterTypes, Object[] parameters)
{    T instance;    try {        Class<? extends T> clazz = (Class<? extends T>) Class.forName(className);        instance = createInstance(clazz, parameterTypes, parameters);    } catch (ClassNotFoundException e) {        throw new IllegalStateException("Unable to instantiate connector: class not found", e);    }    return instance;}
public void metron_f3142_0(String reason)
{    throwRuntime(reason, Optional.empty());}
public void metron_f3143_0(String reason, Throwable t)
{    throwRuntime(reason, Optional.of(t));}
public void metron_f3144_0(String reason, Optional<Throwable> t)
{    throw func.apply(Pair.of(reason, t));}
private static String metron_f3145_0(Pair<String, Optional<Throwable>> p)
{    return formatReason(p.getLeft(), p.getRight());}
private static String metron_f3146_0(String reason, Optional<Throwable> t)
{    if (t.isPresent()) {        return format("%s - reason:%s", reason, t.get());    } else {        return format("%s", reason);    }}
protected Kryo metron_f3147_0()
{    Kryo ret = new Kryo();    ret.setReferences(true);    ret.setInstantiatorStrategy(new DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));    ret.register(Arrays.asList("").getClass(), new ArraysAsListSerializer());    ret.register(Collections.EMPTY_LIST.getClass(), new CollectionsEmptyListSerializer());    ret.register(Collections.EMPTY_MAP.getClass(), new CollectionsEmptyMapSerializer());    ret.register(Collections.EMPTY_SET.getClass(), new CollectionsEmptySetSerializer());    ret.register(Collections.singletonList("").getClass(), new CollectionsSingletonListSerializer());    ret.register(Collections.singleton("").getClass(), new CollectionsSingletonSetSerializer());    ret.register(Collections.singletonMap("", "").getClass(), new CollectionsSingletonMapSerializer());    ret.register(GregorianCalendar.class, new GregorianCalendarSerializer());    ret.register(InvocationHandler.class, new JdkProxySerializer());    UnmodifiableCollectionsSerializer.registerSerializers(ret);    SynchronizedCollectionsSerializer.registerSerializers(ret);            ret.register(CGLibProxySerializer.CGLibProxyMarker.class, new CGLibProxySerializer());        ret.register(LocalDate.class, new JodaLocalDateSerializer());    ret.register(LocalDateTime.class, new JodaLocalDateTimeSerializer());        ImmutableListSerializer.registerSerializers(ret);    ImmutableSetSerializer.registerSerializers(ret);    ImmutableMapSerializer.registerSerializers(ret);    ImmutableMultimapSerializer.registerSerializers(ret);    return ret;}
public void metron_f3148_0(final InstantiatorStrategy fallbackStrategy)
{    this.fallbackStrategy = fallbackStrategy;}
public InstantiatorStrategy metron_f3149_0()
{    return fallbackStrategy;}
public ObjectInstantiator metron_f3150_0(final Class type)
{    if (!Util.isAndroid) {                Class enclosingType = type.getEnclosingClass();        boolean isNonStaticMemberClass = enclosingType != null && type.isMemberClass() && !Modifier.isStatic(type.getModifiers());        if (!isNonStaticMemberClass) {            try {                final ConstructorAccess access = ConstructorAccess.get(type);                return new ObjectInstantiator() {                    @Override                    public Object newInstance() {                        try {                            return access.newInstance();                        } catch (Exception ex) {                            throw new KryoException("Error constructing instance of class: " + className(type), ex);                        }                    }                };            } catch (Exception ignored) {            }        }    }        try {        Constructor ctor;        try {            ctor = type.getConstructor((Class[]) null);        } catch (Exception ex) {            ctor = type.getDeclaredConstructor((Class[]) null);            ctor.setAccessible(true);        }        final Constructor constructor = ctor;        return new ObjectInstantiator() {            @Override            public Object newInstance() {                try {                    return constructor.newInstance();                } catch (Exception ex) {                    throw new KryoException("Error constructing instance of class: " + className(type), ex);                }            }        };    } catch (Exception ignored) {    }    if (fallbackStrategy == null) {        if (type.isMemberClass() && !Modifier.isStatic(type.getModifiers()))            throw new KryoException("Class cannot be created (non-static member class): " + className(type));        else            throw new KryoException("Class cannot be created (missing no-arg constructor): " + className(type));    }        return fallbackStrategy.newInstantiatorOf(type);}
public Object metron_f3151_0()
{    try {        return access.newInstance();    } catch (Exception ex) {        throw new KryoException("Error constructing instance of class: " + className(type), ex);    }}
public Object metron_f3152_0()
{    try {        return constructor.newInstance();    } catch (Exception ex) {        throw new KryoException("Error constructing instance of class: " + className(type), ex);    }}
public byte[] metron_f3153_0(Object o)
{    return toBytes(o);}
public T metron_f3154_0(byte[] bytes)
{    return fromBytes(bytes, clazz);}
public static byte[] metron_f3155_1(Object value)
{    try {        ByteArrayOutputStream bos = new ByteArrayOutputStream();        Output output = new Output(bos);        kryo.get().writeClassAndObject(output, value);        output.flush();        bos.flush();        return bos.toByteArray();    } catch (Throwable t) {                throw new IllegalStateException("Unable to serialize " + value + " because " + t.getMessage(), t);    }}
public static T metron_f3156_1(byte[] value, Class<T> clazz)
{    try {        Input input = new Input(new ByteArrayInputStream(value));        return clazz.cast(kryo.get().readClassAndObject(input));    } catch (Throwable t) {                throw t;    }}
public static String metron_f3157_0(String delim, Optional<String>... parts)
{    return Joiner.on(delim).join(Arrays.asList(parts).stream().filter(part -> part.isPresent()).map(part -> part.get()).toArray());}
public static String metron_f3158_0(String val, int numLines)
{    int start = org.apache.commons.lang3.StringUtils.ordinalIndexOf(val, System.lineSeparator(), numLines);    start = start >= 0 ? start : 0;    return val.substring(start);}
public static TimestampConverter metron_f3159_0(String converter)
{    if (converter != null) {        return TimestampConverters.valueOf(converter.toUpperCase()).converter;    } else {        throw new IllegalStateException(converter + " is not a valid timestamp converter: " + Joiner.on(",").join(TimestampConverters.values()));    }}
public long metron_f3160_0(long in)
{    return converter.toNanoseconds(in);}
public MessageId metron_f3161_0()
{    return id;}
public MESSAGE_T metron_f3162_0()
{    return message;}
public boolean metron_f3163_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    BulkMessage<?> that = (BulkMessage<?>) o;    return Objects.equals(id, that.id) && Objects.equals(message, that.message);}
public int metron_f3164_0()
{    return Objects.hash(id, message);}
public void metron_f3165_0(Throwable error, MessageId id)
{    errors.put(error, id);}
public void metron_f3166_0(Throwable error, Iterable<MessageId> ids)
{    if (ids != null) {        errors.putAll(error, ids);    }}
public boolean metron_f3167_0()
{    return !errors.isEmpty();}
public void metron_f3168_0(MessageId success)
{    successes.add(success);}
public void metron_f3169_0(Iterable<MessageId> allSuccesses)
{    if (allSuccesses != null) {        Iterables.addAll(successes, allSuccesses);    }}
public Map<Throwable, Collection<MessageId>> metron_f3170_0()
{    return errors.asMap();}
public List<MessageId> metron_f3171_0()
{    return successes;}
public boolean metron_f3172_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    BulkWriterResponse that = (BulkWriterResponse) o;    if (!errors.equals(that.errors))        return false;    return successes.equals(that.successes);}
public int metron_f3173_0()
{    int result = errors.hashCode();    result = 31 * result + successes.hashCode();    return result;}
public String metron_f3174_0()
{    return "BulkWriterResponse{" + "errors=" + errors + ", successes=" + successes + '}';}
public String metron_f3175_0()
{    return id;}
public boolean metron_f3176_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    MessageId messageId = (MessageId) o;    return Objects.equals(id, messageId.id);}
public int metron_f3177_0()
{    return Objects.hash(id);}
public String metron_f3178_0()
{    return "MessageId{" + "id='" + id + '\'' + '}';}
public void metron_f3179_1(CuratorFramework client, String path, byte[] data) throws IOException
{    if (data.length != 0) {        String name = path.substring(path.lastIndexOf("/") + 1);        if (path.startsWith(getType().getZookeeperRoot())) {                        update(name, data);            reloadCallback(name, getType());        } else if (ConfigurationType.GLOBAL.getZookeeperRoot().equals(path)) {                        getConfigurations().updateGlobalConfig(data);            reloadCallback(name, ConfigurationType.GLOBAL);        }    }}
public void metron_f3180_1(CuratorFramework client, String path, byte[] data) throws IOException
{    String name = path.substring(path.lastIndexOf("/") + 1);    if (path.startsWith(getType().getZookeeperRoot())) {                delete(name);        reloadCallback(name, getType());    } else if (ConfigurationType.GLOBAL.getZookeeperRoot().equals(path)) {                getConfigurations().deleteGlobalConfig();        reloadCallback(name, ConfigurationType.GLOBAL);    }}
protected void metron_f3181_0(String name, ConfigurationType type)
{    reloadable.reloadCallback(name, type);}
protected T metron_f3182_0()
{    return configSupplier.get();}
public Class<EnrichmentConfigurations> metron_f3183_0()
{    return EnrichmentConfigurations.class;}
public void metron_f3184_1(CuratorFramework client)
{    try {        ConfigurationsUtils.updateEnrichmentConfigsFromZookeeper(getConfigurations(), client);    } catch (KeeperException.NoNodeException nne) {            } catch (Exception e) {            }}
public EnrichmentConfigurations metron_f3185_0()
{    return new EnrichmentConfigurations();}
public ConfigurationType metron_f3186_0()
{    return ConfigurationType.ENRICHMENT;}
public void metron_f3187_0(String name)
{    getConfigurations().delete(name);}
public void metron_f3188_0(String name, byte[] data) throws IOException
{    getConfigurations().updateSensorEnrichmentConfig(name, data);}
public Class<IndexingConfigurations> metron_f3189_0()
{    return IndexingConfigurations.class;}
public void metron_f3190_1(CuratorFramework client)
{    try {        ConfigurationsUtils.updateSensorIndexingConfigsFromZookeeper(getConfigurations(), client);    } catch (KeeperException.NoNodeException nne) {            } catch (Exception e) {            }}
public IndexingConfigurations metron_f3191_0()
{    return new IndexingConfigurations();}
public ConfigurationType metron_f3192_0()
{    return ConfigurationType.INDEXING;}
public void metron_f3193_0(String name)
{    getConfigurations().delete(name);}
public void metron_f3194_0(String name, byte[] data) throws IOException
{    getConfigurations().updateSensorIndexingConfig(name, data);}
public Class<ParserConfigurations> metron_f3195_0()
{    return ParserConfigurations.class;}
public void metron_f3196_1(CuratorFramework client)
{    try {        ConfigurationsUtils.updateParserConfigsFromZookeeper(getConfigurations(), client);    } catch (KeeperException.NoNodeException nne) {            } catch (Exception e) {            }}
public ParserConfigurations metron_f3197_0()
{    return new ParserConfigurations();}
public ConfigurationType metron_f3198_0()
{    return ConfigurationType.PARSER;}
public void metron_f3199_0(String name)
{    getConfigurations().delete(name);}
public void metron_f3200_0(String name, byte[] data) throws IOException
{    getConfigurations().updateSensorParserConfig(name, data);}
public Class<ProfilerConfigurations> metron_f3201_0()
{    return ProfilerConfigurations.class;}
private ProfilerConfig metron_f3202_0(CuratorFramework client) throws Exception
{    byte[] raw = client.getData().forPath(PROFILER.getZookeeperRoot());    return JSONUtils.INSTANCE.load(new ByteArrayInputStream(raw), ProfilerConfig.class);}
public void metron_f3203_1(CuratorFramework client)
{    try {        ConfigurationsUtils.updateConfigsFromZookeeper(getConfigurations(), client);    } catch (KeeperException.NoNodeException nne) {            } catch (Exception e) {            }    try {        ProfilerConfig config = readFromZookeeper(client);        if (config != null) {            getConfigurations().updateProfilerConfig(config);        }    } catch (KeeperException.NoNodeException nne) {            } catch (Exception e) {            }}
public ProfilerConfigurations metron_f3204_0()
{    return new ProfilerConfigurations();}
public ConfigurationType metron_f3205_0()
{    return ConfigurationType.PROFILER;}
public void metron_f3206_0(String name)
{    getConfigurations().delete();}
public void metron_f3207_0(String name, byte[] data) throws IOException
{    getConfigurations().updateProfilerConfig(data);}
public ConfigurationsUpdater<? extends Configurations> metron_f3208_0(Map<Class<? extends Configurations>, Configurations> configs, Reloadable reloadCallback)
{    return updaterSupplier.create(configs, reloadCallback);}
private static Supplier<T> metron_f3209_0(Class<T> clazz, Map<Class<? extends Configurations>, Configurations> configs)
{    return () -> clazz.cast(configs.get(clazz));}
public void metron_f3210_0()
{    initializeCache(client);}
public void metron_f3211_0()
{    Lock writeLock = lock.writeLock();    try {        writeLock.lock();        if (cache != null) {            cache.close();        }    } finally {        writeLock.unlock();    }}
public void metron_f3212_0()
{    Lock writeLock = lock.writeLock();    try {        writeLock.lock();        close();        initializeCache(client);    } finally {        writeLock.unlock();    }}
private void metron_f3213_1(CuratorFramework client)
{    Lock writeLock = lock.writeLock();    try {        writeLock.lock();        SimpleEventListener listener = new SimpleEventListener.Builder().with(Iterables.transform(updaters, u -> u::update), TreeCacheEvent.Type.NODE_ADDED, TreeCacheEvent.Type.NODE_UPDATED).with(Iterables.transform(updaters, u -> u::delete), TreeCacheEvent.Type.NODE_REMOVED).build();        cache = new ZKCache.Builder().withClient(client).withListener(listener).withRoot(Constants.ZOOKEEPER_TOPOLOGY_ROOT).build();        for (ConfigurationsUpdater<? extends Configurations> updater : updaters) {            updater.forceUpdate(client);        }        cache.start();    } catch (Exception e) {                throw new IllegalStateException("Unable to initialize zookeeper cache: " + e.getMessage(), e);    } finally {        writeLock.unlock();    }}
public T metron_f3214_0(Class<T> configClass)
{    Lock readLock = lock.readLock();    try {        readLock.lock();        return configClass.cast(configs.get(configClass));    } finally {        readLock.unlock();    }}
public void metron_f3215_0()
{    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.MAX.aggregate(ImmutableList.of(1, 5, -1, 7), new HashMap<>()), 1e-7);    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.MAX.aggregate(ImmutableList.of(1, 5, -1, -2), new HashMap<>()), 1e-7);    Assert.assertEquals(7d, Aggregators.MAX.aggregate(ImmutableList.of(1, 5, -1, 7, 0), ImmutableMap.of(Aggregators.NEGATIVE_VALUES_TRUMP_CONF, "false")), 1e-7);}
public void metron_f3216_0()
{    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.MIN.aggregate(ImmutableList.of(1, 5, -1, 7, 0), new HashMap<>()), 1e-7);    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.MIN.aggregate(ImmutableList.of(1, 5, -1, -2, 0), new HashMap<>()), 1e-7);    Assert.assertEquals(-1d, Aggregators.MIN.aggregate(ImmutableList.of(1, 5, -1, 7, 0), ImmutableMap.of(Aggregators.NEGATIVE_VALUES_TRUMP_CONF, "false")), 1e-7);}
public void metron_f3217_0()
{    Assert.assertEquals(1, Aggregators.MIN.aggregate(ImmutableList.of(1, 5, 7), ImmutableMap.of(Aggregators.NEGATIVE_VALUES_TRUMP_CONF, "false")), 1e-7);}
public void metron_f3218_0()
{    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.MEAN.aggregate(ImmutableList.of(1, 5, -1, 7, 0), new HashMap<>()), 1e-7);    Assert.assertEquals(12.0 / 5.0, Aggregators.MEAN.aggregate(ImmutableList.of(1, 5, -1, 7, 0), ImmutableMap.of(Aggregators.NEGATIVE_VALUES_TRUMP_CONF, "false")), 1e-7);}
public void metron_f3219_0()
{    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.POSITIVE_MEAN.aggregate(ImmutableList.of(1, 5, -1, 7, 0), new HashMap<>()), 1e-7);    Assert.assertEquals(13.0 / 3.0, Aggregators.POSITIVE_MEAN.aggregate(ImmutableList.of(1, 5, -1, 7, 0), ImmutableMap.of(Aggregators.NEGATIVE_VALUES_TRUMP_CONF, "false")), 1e-7);}
public void metron_f3220_0()
{    Assert.assertEquals(Double.NEGATIVE_INFINITY, Aggregators.SUM.aggregate(ImmutableList.of(1, 5, -1, 7), new HashMap<>()), 1e-7);    Assert.assertEquals(1 + 5 + -1 + 7, Aggregators.SUM.aggregate(ImmutableList.of(1, 5, -1, 7), ImmutableMap.of(Aggregators.NEGATIVE_VALUES_TRUMP_CONF, "false")), 1e-7);}
private void metron_f3221_0(File rootDir) throws IOException
{    if (rootDir.isDirectory()) {        try {            Files.delete(Paths.get(rootDir.toURI()));        } catch (DirectoryNotEmptyException dne) {            for (File f : rootDir.listFiles()) {                cleanDir(f);            }            rootDir.delete();        }    } else {        rootDir.delete();    }}
public void metron_f3222_0() throws Exception
{    testZkServer = new TestingServer(true);    zookeeperUrl = testZkServer.getConnectString();    client = ConfigurationsUtils.getClient(zookeeperUrl);    client.start();    File sensorDir = new File(new File(TestConstants.SAMPLE_CONFIG_PATH), ENRICHMENT.getDirectory());    sensors.addAll(Collections2.transform(Arrays.asList(sensorDir.list()), s -> Iterables.getFirst(Splitter.on('.').split(s), "null")));    tmpDir = TestUtils.createTempDir(this.getClass().getName());    configDir = TestUtils.createDir(tmpDir, "config");    parsersDir = TestUtils.createDir(configDir, "parsers");    enrichmentsDir = TestUtils.createDir(configDir, "enrichments");    indexingDir = TestUtils.createDir(configDir, "indexing");    pushAllConfigs();}
private void metron_f3223_0() throws Exception
{    pushAllConfigs(TestConstants.SAMPLE_CONFIG_PATH);}
private void metron_f3224_0(String inputDir) throws Exception
{    String[] args = new String[] { "-z", zookeeperUrl, "--mode", "PUSH", "--input_dir", inputDir };    ConfigurationManager manager = new ConfigurationManager();    manager.run(ConfigurationManager.ConfigurationOptions.parse(new PosixParser(), args));}
private void metron_f3225_0(boolean force) throws Exception
{    String[] args = null;    if (force) {        args = new String[] { "-z", zookeeperUrl, "--mode", "PULL", "--output_dir", outDir, "--force" };    } else {        args = new String[] { "-z", zookeeperUrl, "--mode", "PULL", "--output_dir", outDir };    }    ConfigurationManager manager = new ConfigurationManager();    manager.run(ConfigurationManager.ConfigurationOptions.parse(new PosixParser(), args));}
private void metron_f3226_0(File configDir) throws IOException
{    File globalConfigFile = new File(configDir, "global.json");    Assert.assertTrue("Global config does not exist", globalConfigFile.exists());    validateConfig("global", GLOBAL, new String(Files.readAllBytes(Paths.get(globalConfigFile.toURI())), StandardCharsets.UTF_8));    for (String sensor : sensors) {        File sensorFile = new File(configDir, ENRICHMENT.getDirectory() + "/" + sensor + ".json");        Assert.assertTrue(sensor + " config does not exist", sensorFile.exists());        validateConfig(sensor, ENRICHMENT, new String(Files.readAllBytes(Paths.get(sensorFile.toURI())), StandardCharsets.UTF_8));    }}
public void metron_f3227_0() throws Exception
{    cleanDir(new File(outDir));    pullConfigs(false);    validateConfigsOnDisk(new File(outDir));    try {                pullConfigs(false);        fail("Should have failed to pull configs in a directory structure that already exists.");    } catch (IllegalStateException t) {                validateConfigsOnDisk(new File(outDir));    }    pullConfigs(true);    validateConfigsOnDisk(new File(outDir));}
private void metron_f3228_0(String name, ConfigurationType type, String data)
{    try {        type.deserialize(data);    } catch (Exception e) {        fail("Unable to load config " + name + ": " + data);    }}
public void metron_f3229_0() throws Exception
{        pushAllConfigs();        final Set<String> sensorsInZookeeper = new HashSet<>();    final BooleanWritable foundGlobal = new BooleanWritable(false);    ConfigurationsUtils.visitConfigs(client, new ConfigurationsUtils.ConfigurationVisitor() {        @Override        public void visit(ConfigurationType configurationType, String name, String data) {            Assert.assertTrue(data.length() > 0);            validateConfig(name, configurationType, data);            if (configurationType == GLOBAL) {                validateConfig(name, configurationType, data);                foundGlobal.set(true);            } else {                sensorsInZookeeper.add(name);            }        }    });    Assert.assertEquals(true, foundGlobal.get());    Assert.assertEquals(sensorsInZookeeper, sensors);}
public void metron_f3230_0(ConfigurationType configurationType, String name, String data)
{    Assert.assertTrue(data.length() > 0);    validateConfig(name, configurationType, data);    if (configurationType == GLOBAL) {        validateConfig(name, configurationType, data);        foundGlobal.set(true);    } else {        sensorsInZookeeper.add(name);    }}
public void metron_f3231_0() throws Exception
{        File globalConfigFile = new File(configDir, "global.json");    TestUtils.write(globalConfigFile, badGlobalConfig);        File squidConfigFile = new File(parsersDir, "squid.json");    TestUtils.write(squidConfigFile, badParserConfig);    pushAllConfigs(configDir.getAbsolutePath());}
public void metron_f3232_0() throws Exception
{        File configFile = new File(configDir, "global.json");    TestUtils.write(configFile, globalConfig);        pushConfigs(GLOBAL, configDir);        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(globalConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(GLOBAL), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3233_0() throws Exception
{        File configFile = new File(configDir, "global.json");    TestUtils.write(configFile, badGlobalConfig);        pushConfigs(GLOBAL, configDir);}
private void metron_f3234_0(ConfigurationType type, File configPath) throws Exception
{    pushConfigs(type, configPath, Optional.empty());}
private void metron_f3235_0(ConfigurationType type, File configPath, Optional<String> configName) throws Exception
{    String[] args = new String[] { "-z", zookeeperUrl, "--mode", "PUSH", "--config_type", type.toString(), "--input_dir", configPath.getAbsolutePath() };    if (configName.isPresent()) {        args = ArrayUtils.addAll(args, "--config_name", configName.get());    }    ConfigurationManager manager = new ConfigurationManager();    manager.run(ConfigurationManager.ConfigurationOptions.parse(new PosixParser(), args));}
private String metron_f3236_0(ConfigurationType type) throws Exception
{    return dumpConfigs(type, Optional.empty());}
private String metron_f3237_0(ConfigurationType type, Optional<String> configName) throws Exception
{    String[] args = new String[] { "-z", zookeeperUrl, "--mode", "DUMP", "--config_type", type.toString() };    if (configName.isPresent()) {        args = ArrayUtils.addAll(args, "--config_name", configName.get());    }    ConfigurationManager manager = new ConfigurationManager();    return redirectSystemOut(args, (a) -> {        manager.run(ConfigurationManager.ConfigurationOptions.parse(new PosixParser(), a));    });}
private String metron_f3238_0(final String[] args, RedirectCallback callback) throws Exception
{    PrintStream os = System.out;    try (OutputStream baos = new ByteArrayOutputStream();        PrintStream ps = new PrintStream(baos, false, StandardCharsets.UTF_8.name())) {        System.setOut(ps);        callback.call(args);        System.out.flush();        System.setOut(os);        return baos.toString();    } finally {        System.setOut(os);    }}
public void metron_f3239_0() throws Exception
{        File configFile = new File(parsersDir, "myparser.json");    TestUtils.write(configFile, squidParserConfig);        pushConfigs(PARSER, configDir, Optional.of("myparser"));        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(squidParserConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(PARSER, Optional.of("myparser")), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3240_0() throws Exception
{        File configFile = new File(parsersDir, "badparser.json");    TestUtils.write(configFile, badParserConfig);        pushConfigs(PARSER, configDir, Optional.of("badparser"));}
public void metron_f3241_0() throws Exception
{        File configFile = new File(enrichmentsDir, "myenrichment.json");    TestUtils.write(configFile, someEnrichmentConfig);        pushConfigs(ENRICHMENT, configDir, Optional.of("myenrichment"));        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(someEnrichmentConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(ENRICHMENT, Optional.of("myenrichment")), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3242_0() throws Exception
{        File configFile = new File(enrichmentsDir, "badenrichment.json");    TestUtils.write(configFile, badEnrichmentConfig);        pushConfigs(ENRICHMENT, configDir, Optional.of("badenrichment"));}
public void metron_f3243_0() throws Exception
{        File configFile = new File(indexingDir, "myindex.json");    TestUtils.write(configFile, someIndexingConfig);        pushConfigs(INDEXING, configDir, Optional.of("myindex"));        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(someIndexingConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(INDEXING, Optional.of("myindex")), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3244_0() throws Exception
{        File configFile = new File(indexingDir, "myindex.json");    TestUtils.write(configFile, badIndexingConfig);        pushConfigs(INDEXING, configDir, Optional.of("myindex"));}
public void metron_f3245_0() throws Exception
{        File configFile = new File(configDir, "profiler.json");    TestUtils.write(configFile, someProfilerConfig);        Optional<String> configName = Optional.empty();    pushConfigs(PROFILER, configDir, configName);        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(someProfilerConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(PROFILER, configName), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3246_0() throws Exception
{        File configFile = new File(configDir, "profiler.json");    TestUtils.write(configFile, badProfilerConfig);        Optional<String> configName = Optional.empty();    pushConfigs(PROFILER, configDir, configName);}
public void metron_f3247_0() throws Exception
{        File patchFile = new File(tmpDir, "global-config-patch.json");    TestUtils.write(patchFile, somePatchConfig);        File configFile = new File(configDir, "global.json");    TestUtils.write(configFile, globalConfig);    pushConfigs(GLOBAL, configDir, Optional.of("global"));        patchConfigs(GLOBAL, Optional.of(patchFile), Optional.of("global"), Optional.empty(), Optional.empty(), Optional.empty());        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(expectedSomeConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(GLOBAL, Optional.of("global")), 1));    Assert.assertThat(actual, equalTo(expected));}
private void metron_f3248_0(ConfigurationType type, Optional<File> patchPath, Optional<String> configName, Optional<PatchMode> patchMode, Optional<String> key, Optional<String> value) throws Exception
{    String[] args = new String[] { "-z", zookeeperUrl, "--mode", "PATCH", "--config_type", type.toString() };    if (configName.isPresent()) {        args = ArrayUtils.addAll(args, "--config_name", configName.get());    }    if (patchPath.isPresent()) {        args = ArrayUtils.addAll(args, "--patch_file", patchPath.get().getAbsolutePath());    } else if (patchMode.isPresent()) {        args = ArrayUtils.addAll(args, "--patch_mode", patchMode.get().toString(), "--patch_key", key.get(), "--patch_value", value.get());    }    ConfigurationManager manager = new ConfigurationManager();    manager.run(ConfigurationManager.ConfigurationOptions.parse(new PosixParser(), args));}
public void metron_f3249_0() throws Exception
{        File patchFile = new File(tmpDir, "parser-patch.json");    TestUtils.write(patchFile, someParserPatch);        File configFile = new File(parsersDir, "myparser.json");    TestUtils.write(configFile, squidParserConfig);    pushConfigs(PARSER, configDir, Optional.of("myparser"));        patchConfigs(PARSER, Optional.of(patchFile), Optional.of("myparser"), Optional.empty(), Optional.empty(), Optional.empty());        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(expectedPatchedParser);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(PARSER, Optional.of("myparser")), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3250_0() throws Exception
{        File configFile = new File(parsersDir, "myparser.json");    TestUtils.write(configFile, squidParserConfig);    pushConfigs(PARSER, configDir, Optional.of("myparser"));        patchConfigs(PARSER, Optional.empty(), Optional.of("myparser"), Optional.of(ADD), Optional.of("/parserConfig/timestampField"), Optional.of("\"\"heyjoe\"\""));        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(expectedPatchedParser);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(PARSER, Optional.of("myparser")), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3251_0() throws Exception
{        File patchFile = new File(tmpDir, "parser-patch.json");    TestUtils.write(patchFile, badParserPatch);        File configFile = new File(parsersDir, "myparser.json");    TestUtils.write(configFile, squidParserConfig);    pushConfigs(PARSER, configDir, Optional.of("myparser"));        patchConfigs(PARSER, Optional.of(patchFile), Optional.of("myparser"), Optional.empty(), Optional.empty(), Optional.empty());}
public void metron_f3252_0() throws Exception
{        File configFile = new File(configDir, "global.json");    TestUtils.write(configFile, globalConfig);    pushConfigs(GLOBAL, configDir, Optional.of("global"));        patchConfigs(GLOBAL, Optional.empty(), Optional.of("global"), Optional.of(ADD), Optional.of("/foo"), Optional.of("{ \"bar\" : { \"baz\" : [ \"bazval1\", \"bazval2\" ] } }"));        byte[] expected = JSONUtils.INSTANCE.toJSONPretty(expectedComplexConfig);    byte[] actual = JSONUtils.INSTANCE.toJSONPretty(stripLines(dumpConfigs(GLOBAL, Optional.of("global")), 1));    Assert.assertThat(actual, equalTo(expected));}
public void metron_f3253_0() throws Exception
{        File patchFile = new File(tmpDir, "patch.json");    TestUtils.write(patchFile, badProfilerPatch);        File configFile = new File(configDir, "profiler.json");    TestUtils.write(configFile, someProfilerConfig);        pushConfigs(PROFILER, configDir, Optional.empty());        patchConfigs(PROFILER, Optional.of(patchFile), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty());}
public void metron_f3254_0() throws IOException
{    client.close();    testZkServer.close();    testZkServer.stop();}
public void metron_f3256_0()
{    ConfigOption option = newOption("foo");    Map<String, Object> config = new HashMap<>();    option.put(config, 25L);    assertThat(option.get(config, Long.class), equalTo(25L));    assertThat(option.get(mapWith("foo", 25L), Long.class), equalTo(25L));}
public void metron_f3257_0()
{    ConfigOption option = newOption("foo");    Map<String, Object> config = new HashMap<>();    option.put(config, "25");    BiFunction<String, Object, Long> transform = (s, o) -> o == null ? null : new Long(o.toString());    assertThat(option.get(config, transform, Long.class), equalTo(25L));    assertThat(option.get(mapWith("foo", "25"), transform, Long.class), equalTo(25L));}
public void metron_f3258_0()
{    ConfigOption option = newOption("foo");    Map<String, Object> config = new HashMap<>();    option.put(config, null);    BiFunction<String, Object, Long> transform = (s, o) -> o == null ? null : new Long(o.toString());    assertThat(option.getOrDefault(config, transform, Long.class, 25L), equalTo(25L));    assertThat(option.getOrDefault(mapWith("foo", null), transform, Long.class, 25L), equalTo(25L));}
public void metron_f3259_0()
{    ConfigOption option = newOption("foo");    Map<String, Object> config = new HashMap<>();    option.put(config, null);    assertThat(option.getOrDefault(config, Long.class, 0L), equalTo(0L));    assertThat(option.getOrDefault(mapWith("foo", null), Long.class, 0L), equalTo(0L));}
public void metron_f3260_0()
{    ConfigOption option = newOption("foo");    Map<String, Object> config = new HashMap<>();    option.put(config, (Object) 25L);    assertThat(option.getTransformed(config, Long.class), equalTo(25L));    assertThat(option.getTransformed(mapWith("foo", (Object) 25L), Long.class), equalTo(25L));}
public void metron_f3261_0()
{    ConfigOption option = newOption("foo");    Map<String, Object> config = new HashMap<>();    option.put(config, null);    assertThat(option.getTransformedOrDefault(config, Long.class, 25L), equalTo(25L));    assertThat(option.getTransformedOrDefault(mapWith("foo", null), Long.class, 25L), equalTo(25L));}
private Map<K, V> metron_f3262_0(K key, V val)
{    Map<K, V> map = new HashMap<>();    map.put(key, val);    return map;}
private ConfigOption metron_f3263_0(final String key)
{    return new ConfigOption() {        @Override        public String getKey() {            return key;        }    };}
public String metron_f3264_0()
{    return key;}
public void metron_f3265_0() throws IOException
{    EqualsVerifier.forClass(Configurations.class).suppress(Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS).usingGetClass().verify();    Configurations configurations = new Configurations();    try {        configurations.updateGlobalConfig((byte[]) null);        Assert.fail("Updating a config with null should throw an IllegalStateException");    } catch (IllegalStateException e) {    }    Assert.assertTrue(configurations.toString() != null && configurations.toString().length() > 0);}
public void metron_f3266_0() throws Exception
{    testZkServer = new TestingServer(true);    zookeeperUrl = testZkServer.getConnectString();    client = ConfigurationsUtils.getClient(zookeeperUrl);    client.start();    expectedGlobalConfig = ConfigurationsUtils.readGlobalConfigFromFile(TestConstants.SAMPLE_CONFIG_PATH);    expectedSensorParserConfigMap = ConfigurationsUtils.readSensorParserConfigsFromFile(TestConstants.PARSER_CONFIGS_PATH);    expectedSensorEnrichmentConfigMap = ConfigurationsUtils.readSensorEnrichmentConfigsFromFile(TestConstants.ENRICHMENTS_CONFIGS_PATH);}
public void metron_f3267_0() throws Exception
{    Assert.assertTrue(expectedGlobalConfig.length > 0);    ConfigurationsUtils.writeGlobalConfigToZookeeper(expectedGlobalConfig, zookeeperUrl);    byte[] actualGlobalConfigBytes = ConfigurationsUtils.readGlobalConfigBytesFromZookeeper(client);    Assert.assertTrue(Arrays.equals(expectedGlobalConfig, actualGlobalConfigBytes));    Assert.assertTrue(expectedSensorParserConfigMap.size() > 0);    String testSensorType = "yaf";    byte[] expectedSensorParserConfigBytes = expectedSensorParserConfigMap.get(testSensorType);    ConfigurationsUtils.writeSensorParserConfigToZookeeper(testSensorType, expectedSensorParserConfigBytes, zookeeperUrl);    byte[] actualSensorParserConfigBytes = ConfigurationsUtils.readSensorParserConfigBytesFromZookeeper(testSensorType, client);    Assert.assertTrue(Arrays.equals(expectedSensorParserConfigBytes, actualSensorParserConfigBytes));    Assert.assertTrue(expectedSensorEnrichmentConfigMap.size() > 0);    byte[] expectedSensorEnrichmentConfigBytes = expectedSensorEnrichmentConfigMap.get(testSensorType);    ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(testSensorType, expectedSensorEnrichmentConfigBytes, zookeeperUrl);    byte[] actualSensorEnrichmentConfigBytes = ConfigurationsUtils.readSensorEnrichmentConfigBytesFromZookeeper(testSensorType, client);    Assert.assertTrue(Arrays.equals(expectedSensorEnrichmentConfigBytes, actualSensorEnrichmentConfigBytes));    String name = "testConfig";    Map<String, Object> testConfig = new HashMap<>();    testConfig.put("stringField", "value");    testConfig.put("intField", 1);    testConfig.put("doubleField", 1.1);    ConfigurationsUtils.writeConfigToZookeeper(name, testConfig, zookeeperUrl);    byte[] readConfigBytes = ConfigurationsUtils.readConfigBytesFromZookeeper(name, client);    Assert.assertTrue(Arrays.equals(JSONUtils.INSTANCE.toJSONPretty(testConfig), readConfigBytes));}
public void metron_f3268_0() throws Exception
{        ConfigurationType type = ConfigurationType.GLOBAL;    ConfigurationsUtils.writeConfigToZookeeper(type, JSONUtils.INSTANCE.toJSONPretty(someParserConfig), zookeeperUrl);        byte[] actual = ConfigurationsUtils.readConfigBytesFromZookeeper(type, zookeeperUrl);    assertThat(actual, equalTo(JSONUtils.INSTANCE.toJSONPretty(someParserConfig)));}
public void metron_f3269_0() throws Exception
{        ConfigurationType type = ConfigurationType.PARSER;    String parserName = "a-happy-metron-parser";    byte[] config = JSONUtils.INSTANCE.toJSONPretty(someParserConfig);    ConfigurationsUtils.writeConfigToZookeeper(type, Optional.of(parserName), config, zookeeperUrl);        byte[] actual = ConfigurationsUtils.readConfigBytesFromZookeeper(type, Optional.of(parserName), zookeeperUrl);    assertThat(actual, equalTo(JSONUtils.INSTANCE.toJSONPretty(someParserConfig)));}
public void metron_f3270_0() throws Exception
{        final ConfigurationType type = ConfigurationType.GLOBAL;    byte[] config = JSONUtils.INSTANCE.toJSONPretty(someGlobalConfig);    ConfigurationsUtils.writeConfigToZookeeper(type, config, zookeeperUrl);        byte[] patch = JSONUtils.INSTANCE.toJSONPretty(patchGlobalConfig);    ConfigurationsUtils.applyConfigPatchToZookeeper(type, patch, zookeeperUrl);        byte[] actual = ConfigurationsUtils.readConfigBytesFromZookeeper(type, zookeeperUrl);    byte[] expected = JSONUtils.INSTANCE.toJSONPretty(modifiedGlobalConfig);    assertThat(actual, equalTo(expected));}
public void metron_f3271_0() throws Exception
{        final ConfigurationType type = ConfigurationType.PARSER;    final String parserName = "patched-metron-parser";    byte[] config = JSONUtils.INSTANCE.toJSONPretty(someParserConfig);    ConfigurationsUtils.writeConfigToZookeeper(type, Optional.of(parserName), config, zookeeperUrl);        byte[] patch = JSONUtils.INSTANCE.toJSONPretty(patchParserConfig);    ConfigurationsUtils.applyConfigPatchToZookeeper(type, Optional.of(parserName), patch, zookeeperUrl);        byte[] actual = ConfigurationsUtils.readConfigBytesFromZookeeper(type, Optional.of(parserName), zookeeperUrl);    byte[] expected = JSONUtils.INSTANCE.toJSONPretty(modifiedParserConfig);    assertThat(actual, equalTo(expected));}
public void metron_f3272_0() throws IOException
{    client.close();    testZkServer.close();    testZkServer.stop();}
public void metron_f3273_0() throws Exception
{    Configuration configuration = new Configuration(Paths.get("./src/test/resources/config/"));    configuration.update();    checkResult(configuration);}
public void metron_f3274_0() throws Exception
{    CuratorFramework curatorFramework = mock(CuratorFramework.class);    ExistsBuilder existsBuilder = mock(ExistsBuilder.class);    GetDataBuilder getDataBuilder = mock(GetDataBuilder.class);    GetChildrenBuilder getChildrenBuilder = mock(GetChildrenBuilder.class);    when(getDataBuilder.forPath(ConfigurationType.GLOBAL.getZookeeperRoot())).thenReturn(mockGlobalData());    when(curatorFramework.checkExists()).thenReturn(existsBuilder);    when(curatorFramework.getData()).thenReturn(getDataBuilder);    when(curatorFramework.getChildren()).thenReturn(getChildrenBuilder);    when(getChildrenBuilder.forPath(anyString())).thenReturn(Collections.<String>emptyList());    Configuration configuration = new Configuration(Paths.get("foo"));    configuration.curatorFramework = curatorFramework;    configuration.update();    checkResult(configuration);}
private byte[] metron_f3275_0()
{    JSONObject global = new JSONObject();    global.put(TEST_PROPERTY, TEST_VALUE);    return global.toString().getBytes(StandardCharsets.UTF_8);}
private void metron_f3276_0(Configuration configuration)
{    assertEquals("File contains 1 entry: ", 1, configuration.getGlobalConfig().size());    String testValue = configuration.getGlobalConfig().get(TEST_PROPERTY).toString();    assertEquals(TEST_PROPERTY + " should be \"" + TEST_VALUE + "\"", TEST_VALUE, testValue);}
public void metron_f3277_0() throws Exception
{        SensorEnrichmentConfig enrichment = (SensorEnrichmentConfig) ENRICHMENT.deserialize(triageRuleWithNumericScore);    ThreatTriageConfig threatTriage = enrichment.getThreatIntel().getTriageConfig();    assertNotNull(threatTriage);    List<RiskLevelRule> rules = threatTriage.getRiskLevelRules();    assertEquals(1, rules.size());    RiskLevelRule rule = rules.get(0);    assertEquals("Rule Name", rule.getName());    assertEquals("Rule Comment", rule.getComment());    assertEquals("ip_src_addr == '10.0.2.3'", rule.getRule());    assertEquals("'Rule Reason'", rule.getReason());    assertEquals("10", rule.getScoreExpression());}
public void metron_f3278_0() throws Exception
{        SensorEnrichmentConfig enrichment = (SensorEnrichmentConfig) ENRICHMENT.deserialize(triageRuleWithScoreExpression);    ThreatTriageConfig threatTriage = enrichment.getThreatIntel().getTriageConfig();    assertNotNull(threatTriage);    List<RiskLevelRule> rules = threatTriage.getRiskLevelRules();    assertEquals(1, rules.size());    RiskLevelRule rule = rules.get(0);    assertEquals("Rule Name", rule.getName());    assertEquals("Rule Comment", rule.getComment());    assertEquals("'Rule Reason'", rule.getReason());    assertEquals("ip_src_addr == '10.0.2.3'", rule.getRule());    assertEquals("10 + 10", rule.getScoreExpression());}
public void metron_f3279_0() throws Exception
{    EnrichmentConfig config = JSONUtils.INSTANCE.load(sourceConfigStr, EnrichmentConfig.class);    Assert.assertTrue(config.getFieldMap().get("stellar") instanceof Map);    Assert.assertTrue(config.getEnrichmentConfigs().get("stellar") instanceof ConfigHandler);    Assert.assertEquals(Configs.STELLAR, ((ConfigHandler) config.getEnrichmentConfigs().get("stellar")).getType());}
public void metron_f3280_0()
{    configurations = new IndexingConfigurations();}
public void metron_f3281_0() throws Exception
{        assertFalse(configurations.isSetDocumentId("sensor", "writer"));}
public void metron_f3282_0() throws Exception
{        configurations.updateGlobalConfig(globalConfig.getBytes(StandardCharsets.UTF_8));    assertTrue(configurations.isSetDocumentId("sensor", "writer"));    assertTrue(configurations.isSetDocumentId("anySensor", "writer"));}
public void metron_f3283_0() throws Exception
{        configurations.updateGlobalConfig(new HashMap<>());    configurations.updateSensorIndexingConfig("sensor", sensorConfig.getBytes(StandardCharsets.UTF_8));    assertTrue(configurations.isSetDocumentId("sensor", "writer"));    assertFalse(configurations.isSetDocumentId("anySensor", "writer"));}
public void metron_f3284_0() throws IOException
{    ParserConfigurations parserConfigs = new ParserConfigurations();    parserConfigs.updateSensorParserConfig("test-sensor", parserConfig.getBytes(StandardCharsets.UTF_8));    SensorParserConfig actualSensorConfig = parserConfigs.getSensorParserConfig("test-sensor");    assertThat(actualSensorConfig.getParserClassName(), equalTo("parser-class"));    assertThat(actualSensorConfig.getFilterClassName(), equalTo("filter-class"));    assertThat(actualSensorConfig.getSensorTopic(), equalTo("sensor-topic"));    assertThat(actualSensorConfig.getOutputTopic(), equalTo("output-topic"));    assertThat(actualSensorConfig.getErrorTopic(), equalTo("error-topic"));    assertThat(actualSensorConfig.getWriterClassName(), equalTo("writer-class"));    assertThat(actualSensorConfig.getErrorWriterClassName(), equalTo("error-writer-class"));    assertThat(actualSensorConfig.getReadMetadata(), equalTo(true));    assertThat(actualSensorConfig.getMergeMetadata(), equalTo(true));    assertThat(actualSensorConfig.getNumWorkers(), equalTo(40));    assertThat(actualSensorConfig.getNumAckers(), equalTo(40));    assertThat(actualSensorConfig.getSpoutParallelism(), equalTo(40));    assertThat(actualSensorConfig.getSpoutNumTasks(), equalTo(40));    assertThat(actualSensorConfig.getParserParallelism(), equalTo(40));    assertThat(actualSensorConfig.getParserNumTasks(), equalTo(40));    assertThat(actualSensorConfig.getErrorWriterParallelism(), equalTo(40));    assertThat(actualSensorConfig.getErrorWriterNumTasks(), equalTo(40));    assertThat(actualSensorConfig.getSecurityProtocol(), equalTo("security-protocol"));    assertThat(actualSensorConfig.getSpoutConfig(), not(new HashMap<>()));    assertThat(actualSensorConfig.getSpoutConfig().get("foo"), equalTo("bar"));    assertThat(actualSensorConfig.getStormConfig(), not(new HashMap<>()));    assertThat(actualSensorConfig.getStormConfig().get("storm"), equalTo("config"));    assertThat(actualSensorConfig.getCacheConfig(), not(new HashMap<>()));    assertThat(actualSensorConfig.getCacheConfig().get("stellar.cache.maxSize"), equalTo(20000));    assertThat(actualSensorConfig.getParserConfig(), not(new HashMap<>()));    assertThat(actualSensorConfig.getParserConfig().get("parser"), equalTo("config"));    assertThat(actualSensorConfig.getFieldTransformations(), not(new ArrayList<>()));    assertThat(actualSensorConfig.getFieldTransformations().get(0), not(nullValue()));    assertThat(((FieldTransformer) actualSensorConfig.getFieldTransformations().get(0)).getInput().size(), equalTo(1));    assertThat(((FieldTransformer) actualSensorConfig.getFieldTransformations().get(0)).getInput().get(0), equalTo("input-field"));    assertThat(((FieldTransformer) actualSensorConfig.getFieldTransformations().get(0)).getTransformation(), equalTo("REMOVE"));}
public void metron_f3285_0() throws IOException
{    ProfileConfig profile = ProfileConfig.fromJSON(onlyIfDefault);    assertEquals("true", profile.getOnlyif());}
public void metron_f3286_0() throws Exception
{        ProfileConfig expected = ProfileConfig.fromJSON(onlyIfDefault);        String asJson = expected.toJSON();        ProfileConfig actual = ProfileConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3287_0() throws IOException
{    ProfileConfig.fromJSON(nameMissing);}
public void metron_f3288_0() throws IOException
{    ProfileConfig.fromJSON(foreachMissing);}
public void metron_f3289_0() throws IOException
{    ProfileConfig.fromJSON(resultMissing);}
public void metron_f3290_0() throws IOException
{    ProfileConfig.fromJSON(resultMissingProfileExpression);}
public void metron_f3291_0() throws IOException
{    ProfileConfig profile = ProfileConfig.fromJSON(resultWithExpression);    assertEquals("2 + 2", profile.getResult().getProfileExpressions().getExpression());        assertEquals(0, profile.getResult().getTriageExpressions().getExpressions().size());}
public void metron_f3292_0() throws Exception
{        ProfileConfig expected = ProfileConfig.fromJSON(resultWithExpression);        String asJson = expected.toJSON();        ProfileConfig actual = ProfileConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3293_0() throws IOException
{    ProfileConfig profile = ProfileConfig.fromJSON(resultWithProfileOnly);    assertEquals("2 + 2", profile.getResult().getProfileExpressions().getExpression());        assertEquals(0, profile.getResult().getTriageExpressions().getExpressions().size());}
public void metron_f3294_0() throws Exception
{        ProfileConfig expected = ProfileConfig.fromJSON(resultWithProfileOnly);        String asJson = expected.toJSON();        ProfileConfig actual = ProfileConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3295_0() throws IOException
{    ProfileConfig profile = ProfileConfig.fromJSON(resultWithTriage);    assertEquals("4 + 4", profile.getResult().getTriageExpressions().getExpression("eight"));    assertEquals("8 + 8", profile.getResult().getTriageExpressions().getExpression("sixteen"));}
public void metron_f3296_0() throws Exception
{        ProfileConfig expected = ProfileConfig.fromJSON(resultWithTriage);        String asJson = expected.toJSON();        ProfileConfig actual = ProfileConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3297_0() throws IOException
{    ProfilerConfig conf = ProfilerConfig.fromJSON(profile);    assertFalse(conf.getTimestampField().isPresent());    assertEquals(1, conf.getProfiles().size());}
public void metron_f3298_0() throws IOException
{    ProfilerConfig conf = ProfilerConfig.fromJSON(noTimestampField);    assertFalse(conf.getTimestampField().isPresent());}
public void metron_f3299_0() throws IOException
{    ProfilerConfig conf = ProfilerConfig.fromJSON(timestampField);    assertTrue(conf.getTimestampField().isPresent());}
public void metron_f3300_0() throws IOException
{    ProfilerConfig conf = ProfilerConfig.fromJSON(twoProfiles);    assertEquals(2, conf.getProfiles().size());    assertFalse(conf.getTimestampField().isPresent());}
public void metron_f3301_0() throws Exception
{        ProfilerConfig expected = ProfilerConfig.fromJSON(profile);        String asJson = expected.toJSON();        ProfilerConfig actual = ProfilerConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3302_0() throws Exception
{        ProfilerConfig expected = ProfilerConfig.fromJSON(profileWithTriageExpression);        String asJson = expected.toJSON();        ProfilerConfig actual = ProfilerConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3303_0() throws Exception
{        ProfilerConfig expected = ProfilerConfig.fromJSON(twoProfiles);        String asJson = expected.toJSON();        ProfilerConfig actual = ProfilerConfig.fromJSON(asJson);    assertEquals(expected, actual);}
public void metron_f3304_0() throws Exception
{        ProfilerConfig expected = ProfilerConfig.fromJSON(profilesToSerialize);    assertNotNull(expected);    Kryo kryo = new Kryo();        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();    Output output = new Output(byteStream);    kryo.writeObject(output, expected);        byte[] bits = output.toBytes();    assertNotNull(bits);        Input input = new Input(new ByteArrayInputStream(bits));    ProfilerConfig actual = kryo.readObject(input, ProfilerConfig.class);        assertNotNull(actual);    assertEquals(expected, actual);}
public void metron_f3305_0() throws Exception
{        ProfilerConfig expected = ProfilerConfig.fromJSON(profilesToSerialize);        ByteArrayOutputStream bytes = new ByteArrayOutputStream();    ObjectOutputStream out = new ObjectOutputStream(bytes);    out.writeObject(expected);        byte[] raw = bytes.toByteArray();    assertTrue(raw.length > 0);        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(raw));    Object actual = in.readObject();        assertEquals(expected, actual);}
public void metron_f3306_0() throws IOException
{    EqualsVerifier.forClass(SensorEnrichmentConfig.class).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify();    Map<String, byte[]> testSensorConfigMap = ConfigurationsUtils.readSensorEnrichmentConfigsFromFile(TestConstants.ENRICHMENTS_CONFIGS_PATH);    byte[] sensorConfigBytes = testSensorConfigMap.get("yaf");    SensorEnrichmentConfig sensorEnrichmentConfig = SensorEnrichmentConfig.fromBytes(sensorConfigBytes);    Assert.assertNotNull(sensorEnrichmentConfig);    Assert.assertTrue(sensorEnrichmentConfig.toString() != null && sensorEnrichmentConfig.toString().length() > 0);}
public void metron_f3307_0() throws IOException
{    for (File enrichmentConfig : new File(new File(TestConstants.ENRICHMENTS_CONFIGS_PATH), "enrichments").listFiles()) {        SensorEnrichmentConfig config = null;        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(enrichmentConfig), StandardCharsets.UTF_8))) {            String parserStr = IOUtils.toString(br);            config = SensorEnrichmentConfig.fromBytes(parserStr.getBytes(StandardCharsets.UTF_8));        }        SensorEnrichmentConfig config2 = SensorEnrichmentConfig.fromBytes(config.toJSON().getBytes(StandardCharsets.UTF_8));        Assert.assertEquals(config2, config);    }}
public void metron_f3308_0() throws Exception
{    SensorEnrichmentConfig broSc = (SensorEnrichmentConfig) ConfigurationType.ENRICHMENT.deserialize(sourceConfigStr);    SensorEnrichmentUpdateConfig threatIntelConfig = JSONUtils.INSTANCE.load(threatIntelConfigStr, SensorEnrichmentUpdateConfig.class);    final Map<String, SensorEnrichmentConfig> finalEnrichmentConfig = new HashMap<>();    SensorEnrichmentUpdateConfig.SourceConfigHandler scHandler = new SensorEnrichmentUpdateConfig.SourceConfigHandler() {        @Override        public SensorEnrichmentConfig readConfig(String sensor) throws Exception {            if (sensor.equals("bro")) {                return JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);            } else {                throw new IllegalStateException("Tried to retrieve an unexpected sensor: " + sensor);            }        }        @Override        public void persistConfig(String sensor, SensorEnrichmentConfig config) throws Exception {            finalEnrichmentConfig.put(sensor, config);        }    };    SensorEnrichmentUpdateConfig.updateSensorConfigs(scHandler, threatIntelConfig.getSensorToFieldList());    Assert.assertNotNull(finalEnrichmentConfig.get("bro"));    Assert.assertNotSame(finalEnrichmentConfig.get("bro"), broSc);    Assert.assertEquals(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) finalEnrichmentConfig.get("bro").getThreatIntel().getFieldMap().get(Constants.SIMPLE_HBASE_THREAT_INTEL)).size(), 2);    Assert.assertEquals(1, finalEnrichmentConfig.get("bro").getThreatIntel().getTriageConfig().getRiskLevelRules().size());    Assert.assertTrue(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) finalEnrichmentConfig.get("bro").getThreatIntel().getFieldMap().get(Constants.SIMPLE_HBASE_THREAT_INTEL)).contains("ip_src_addr"));    Assert.assertTrue(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) finalEnrichmentConfig.get("bro").getThreatIntel().getFieldMap().get(Constants.SIMPLE_HBASE_THREAT_INTEL)).contains("ip_dst_addr"));    Assert.assertEquals(finalEnrichmentConfig.get("bro").toJSON(), finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().keySet().size(), 2);    Assert.assertEquals(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) (finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr"))).size(), 2);    Assert.assertTrue(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) (finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr"))).contains("playful"));    Assert.assertTrue(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) (finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr"))).contains("malicious_ip"));    Assert.assertEquals(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) (finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr"))).size(), 2);    Assert.assertTrue(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) (finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr"))).contains("playful"));    Assert.assertTrue(finalEnrichmentConfig.get("bro").toJSON(), ((List<String>) (finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr"))).contains("malicious_ip"));}
public SensorEnrichmentConfig metron_f3309_0(String sensor) throws Exception
{    if (sensor.equals("bro")) {        return JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    } else {        throw new IllegalStateException("Tried to retrieve an unexpected sensor: " + sensor);    }}
public void metron_f3310_0(String sensor, SensorEnrichmentConfig config) throws Exception
{    finalEnrichmentConfig.put(sensor, config);}
public void metron_f3311_0() throws Exception
{    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    SensorEnrichmentUpdateConfig config = JSONUtils.INSTANCE.load(enrichmentConfigStr, SensorEnrichmentUpdateConfig.class);    final Map<String, SensorEnrichmentConfig> outputScs = new HashMap<>();    SensorEnrichmentUpdateConfig.SourceConfigHandler scHandler = new SensorEnrichmentUpdateConfig.SourceConfigHandler() {        @Override        public SensorEnrichmentConfig readConfig(String sensor) throws Exception {            if (sensor.equals("bro")) {                return JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);            } else {                throw new IllegalStateException("Tried to retrieve an unexpected sensor: " + sensor);            }        }        @Override        public void persistConfig(String sensor, SensorEnrichmentConfig config) throws Exception {            outputScs.put(sensor, config);        }    };    SensorEnrichmentUpdateConfig.updateSensorConfigs(scHandler, config.getSensorToFieldList());    Assert.assertNotNull(outputScs.get("bro"));    Assert.assertNotSame(outputScs.get("bro"), broSc);    Assert.assertEquals(outputScs.get("bro").toJSON(), ((List<String>) outputScs.get("bro").getEnrichment().getFieldMap().get(Constants.SIMPLE_HBASE_ENRICHMENT)).size(), 2);    Assert.assertTrue(outputScs.get("bro").toJSON(), ((List<String>) outputScs.get("bro").getEnrichment().getFieldMap().get(Constants.SIMPLE_HBASE_ENRICHMENT)).contains("ip_src_addr"));    Assert.assertTrue(outputScs.get("bro").toJSON(), ((List<String>) outputScs.get("bro").getEnrichment().getFieldMap().get(Constants.SIMPLE_HBASE_ENRICHMENT)).contains("ip_dst_addr"));    Assert.assertEquals(outputScs.get("bro").toJSON(), outputScs.get("bro").getEnrichment().getFieldToTypeMap().keySet().size(), 2);    Assert.assertEquals(outputScs.get("bro").toJSON(), ((List<String>) (outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_src_addr"))).size(), 1);    Assert.assertEquals(outputScs.get("bro").toJSON(), ((List<String>) (outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_src_addr"))).get(0), "playful");    Assert.assertEquals(outputScs.get("bro").toJSON(), ((List<String>) (outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_dst_addr"))).size(), 1);    Assert.assertEquals(outputScs.get("bro").toJSON(), ((List<String>) (outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_dst_addr"))).get(0), "playful");}
public SensorEnrichmentConfig metron_f3312_0(String sensor) throws Exception
{    if (sensor.equals("bro")) {        return JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);    } else {        throw new IllegalStateException("Tried to retrieve an unexpected sensor: " + sensor);    }}
public void metron_f3313_0(String sensor, SensorEnrichmentConfig config) throws Exception
{    outputScs.put(sensor, config);}
public void metron_f3314_0() throws IOException
{    for (File parserConfig : new File(new File(TestConstants.PARSER_CONFIGS_PATH), "parsers").listFiles()) {        SensorParserConfig config = null;        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(parserConfig), StandardCharsets.UTF_8))) {            String parserStr = IOUtils.toString(br);            config = SensorParserConfig.fromBytes(parserStr.getBytes(StandardCharsets.UTF_8));        }        SensorParserConfig config2 = SensorParserConfig.fromBytes(config.toJSON().getBytes(StandardCharsets.UTF_8));        Assert.assertEquals(config2, config);    }}
public void metron_f3315_0() throws IOException
{    JSONObject message = new JSONObject(ImmutableMap.of("domain_without_subdomains", "yahoo.com"));    EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(conf, EnrichmentConfig.class);    Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));    ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");    List<JSONObject> splits = Configs.STELLAR.splitByFields(message, null, x -> null, handler);    Assert.assertEquals(1, splits.size());    Map<String, Object> split = (Map<String, Object>) (splits.get(0)).get("");    Assert.assertEquals("yahoo.com", split.get("domain_without_subdomains"));    Assert.assertTrue(split.containsKey("dga_result"));    Assert.assertTrue(split.containsKey("dga_model_endpoint"));    Assert.assertTrue(split.containsKey("dga_result_map"));}
public void metron_f3316_0() throws IOException
{    JSONObject message = getMessage();    for (String c : DEFAULT_CONFIGS) {        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        List<JSONObject> splits = Configs.STELLAR.splitByFields(message, null, x -> null, handler);        Assert.assertEquals(1, splits.size());        Map<String, Object> split = (Map<String, Object>) splits.get(0).get("");        Assert.assertEquals(3, split.size());        Assert.assertEquals("stellar_test", split.get("source.type"));        Assert.assertEquals("foo", split.get("string"));        Assert.assertNull(split.get("stmt1"));    }}
public void metron_f3317_0() throws IOException
{    for (String c : DEFAULT_CONFIGS) {        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        List<String> subgroups = Configs.STELLAR.getSubgroups(handler);        Assert.assertEquals("", subgroups.get(0));        Assert.assertEquals(1, subgroups.size());    }}
public void metron_f3318_0() throws IOException
{    JSONObject message = getMessage();    for (String c : GROUPED_CONFIGS) {        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        List<JSONObject> splits = Configs.STELLAR.splitByFields(message, null, x -> null, handler);        Assert.assertEquals(2, splits.size());        {            Map<String, Object> split = (Map<String, Object>) splits.get(0).get("group1");            Assert.assertEquals(2, split.size());            Assert.assertEquals("stellar_test", split.get("source.type"));            Assert.assertNull(split.get("stmt1"));        }        {            Map<String, Object> split = (Map<String, Object>) splits.get(1).get("group2");            Assert.assertEquals(1, split.size());            Assert.assertEquals("foo", split.get("string"));        }    }}
public void metron_f3319_0() throws IOException
{    for (String c : GROUPED_CONFIGS) {        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        List<String> subgroups = Configs.STELLAR.getSubgroups(handler);        Assert.assertEquals("group1", subgroups.get(0));        Assert.assertEquals("group2", subgroups.get(1));        Assert.assertEquals(2, subgroups.size());    }}
public void metron_f3320_0() throws IOException
{    JSONObject message = getMessage();    for (String c : Iterables.concat(MIXED_CONFIGS, ImmutableList.of(tempVarStellarConfig_list))) {        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        List<JSONObject> splits = Configs.STELLAR.splitByFields(message, null, x -> null, handler);        Assert.assertEquals(3, splits.size());        {            Map<String, Object> split = (Map<String, Object>) splits.get(0).get("group1");            Assert.assertEquals(2, split.size());            Assert.assertEquals("stellar_test", split.get("source.type"));            Assert.assertNull(split.get("stmt1"));        }        {            Map<String, Object> split = (Map<String, Object>) splits.get(1).get("group2");            Assert.assertEquals(1, split.size());            Assert.assertEquals("foo", split.get("string"));        }        {            Map<String, Object> split = (Map<String, Object>) splits.get(2).get("");            Assert.assertEquals(1, split.size());            Assert.assertEquals("stellar_test", split.get("source.type"));        }    }}
public void metron_f3321_0() throws IOException
{    for (String c : MIXED_CONFIGS) {        EnrichmentConfig enrichmentConfig = JSONUtils.INSTANCE.load(c, EnrichmentConfig.class);        Assert.assertNotNull(enrichmentConfig.getEnrichmentConfigs().get("stellar"));        ConfigHandler handler = enrichmentConfig.getEnrichmentConfigs().get("stellar");        List<String> subgroups = Configs.STELLAR.getSubgroups(handler);        Assert.assertEquals("group1", subgroups.get(0));        Assert.assertEquals("group2", subgroups.get(1));        Assert.assertEquals("", subgroups.get(2));        Assert.assertEquals(3, subgroups.size());    }}
public static JSONObject metron_f3322_0() throws IOException
{    Map<String, Object> ret = JSONUtils.INSTANCE.load(message, JSONUtils.MAP_SUPPLIER);    return new JSONObject(ret);}
public void metron_f3323_0()
{    MockitoAnnotations.initMocks(this);}
public void metron_f3324_0()
{    assertThat(PARSERS.createWriterConfig(writer, new ParserConfigurations()), instanceOf(ParserWriterConfiguration.class));    assertThat(ENRICHMENT.createWriterConfig(writer, new EnrichmentConfigurations()), instanceOf(EnrichmentWriterConfiguration.class));    assertThat(INDEXING.createWriterConfig(writer, new IndexingConfigurations()), instanceOf(IndexingWriterConfiguration.class));    assertThat(PROFILER.createWriterConfig(writer, new ProfilerConfigurations()), instanceOf(ProfilerWriterConfiguration.class));}
public void metron_f3325_0()
{    assertThat(PARSERS.createUpdater(reloadable, ParserConfigurations::new), instanceOf(ParserUpdater.class));    assertThat(ENRICHMENT.createUpdater(reloadable, EnrichmentConfigurations::new), instanceOf(EnrichmentUpdater.class));    assertThat(INDEXING.createUpdater(reloadable, IndexingConfigurations::new), instanceOf(IndexingUpdater.class));    assertThat(PROFILER.createUpdater(reloadable, ProfilerConfigurations::new), instanceOf(ProfilerUpdater.class));}
public void metron_f3326_0() throws IOException
{    EnrichmentConfigurations configs = new EnrichmentConfigurations();    configs.updateGlobalConfig(globalJson.getBytes(StandardCharsets.UTF_8));    EnrichmentWriterConfiguration writerConfig = new EnrichmentWriterConfiguration(configs);    assertThat("batch timeout should match global config setting", writerConfig.getBatchTimeout(null), equalTo(555));    assertThat("list should have single batch timeout matching global config setting", writerConfig.getAllConfiguredTimeouts(), equalTo(asList(555)));    assertThat("batch size should match global config setting", writerConfig.getBatchSize(null), equalTo(12345));}
public void metron_f3327_0()
{    IndexingWriterConfiguration config = new IndexingWriterConfiguration("hdfs", new IndexingConfigurations());    Assert.assertEquals(1, config.getBatchSize("foo"));}
public void metron_f3328_0()
{    IndexingWriterConfiguration config = new IndexingWriterConfiguration("hdfs", new IndexingConfigurations());    Assert.assertEquals(0, config.getBatchTimeout("foo"));}
public void metron_f3329_0() throws FileNotFoundException, IOException
{        IndexingWriterConfiguration config = new IndexingWriterConfiguration("hdfs", new IndexingConfigurations());    Assert.assertEquals(0, config.getAllConfiguredTimeouts().size());        IndexingConfigurations iconfigs = new IndexingConfigurations();    iconfigs.updateSensorIndexingConfig(sensorType, new FileInputStream(sampleSensorIndexingConfigPath));    config = new IndexingWriterConfiguration("elasticsearch", iconfigs);    Assert.assertEquals(1, config.getAllConfiguredTimeouts().size());    Assert.assertEquals(7, (long) config.getAllConfiguredTimeouts().get(0));}
public void metron_f3330_0()
{    IndexingWriterConfiguration config = new IndexingWriterConfiguration("hdfs", new IndexingConfigurations());    Assert.assertEquals("foo", config.getIndex("foo"));}
public void metron_f3331_0()
{    ParserWriterConfiguration config = new ParserWriterConfiguration(new ParserConfigurations());    Assert.assertEquals(1, config.getBatchSize("foo"));}
public void metron_f3332_0()
{    ParserWriterConfiguration config = new ParserWriterConfiguration(new ParserConfigurations());    Assert.assertEquals("foo", config.getIndex("foo"));}
public void metron_f3333_0() throws IOException
{    ParserConfigurations parserConfigurations = new ParserConfigurations();    final String sensorName = "some-sensor";    parserConfigurations.updateSensorParserConfig("some-sensor", configJson.getBytes(StandardCharsets.UTF_8));    ParserWriterConfiguration writerConfiguration = new ParserWriterConfiguration(parserConfigurations);    assertThat("batch size should match", writerConfiguration.getBatchSize(sensorName), equalTo(5));    assertThat("batch timeout should match", writerConfiguration.getBatchTimeout(sensorName), equalTo(10000));    assertThat("index should match", writerConfiguration.getIndex(sensorName), equalTo("modified-index"));    assertThat("enabled should match", writerConfiguration.isEnabled(sensorName), equalTo(false));}
public void metron_f3334_0() throws IOException
{    ProfilerConfigurations configs = new ProfilerConfigurations();    configs.updateGlobalConfig(globalJson.getBytes(StandardCharsets.UTF_8));    ProfilerWriterConfiguration writerConfig = new ProfilerWriterConfiguration(configs);    assertThat("batch timeout should match global config setting", writerConfig.getBatchTimeout(null), equalTo(555));    assertThat("list should have single batch timeout matching global config setting", writerConfig.getAllConfiguredTimeouts(), equalTo(asList(555)));    assertThat("batch size should match global config setting", writerConfig.getBatchSize(null), equalTo(12345));}
public void metron_f3335_0()
{    message1.put("value", "message1");    message2.put("value", "message2");}
public void metron_f3336_0()
{    MetronError error = new MetronError().withMessage("test message").withErrorType(Constants.ErrorType.PARSER_ERROR).withSensorType(Collections.singleton("sensorType"));    JSONObject errorJSON = error.getJSONObject();    assertEquals("test message", errorJSON.get(Constants.ErrorFields.MESSAGE.getName()));    assertEquals(Constants.ErrorType.PARSER_ERROR.getType(), errorJSON.get(Constants.ErrorFields.ERROR_TYPE.getName()));    assertEquals("error", errorJSON.get(Constants.SENSOR_TYPE));    assertEquals("sensorType", errorJSON.get(Constants.ErrorFields.FAILED_SENSOR_TYPE.getName()));    String hostName = null;    try {        hostName = InetAddress.getLocalHost().getHostName();    } catch (UnknownHostException uhe) {        }    if (!StringUtils.isEmpty(hostName)) {        assertTrue(((String) errorJSON.get(Constants.ErrorFields.HOSTNAME.getName())).length() > 0);        assertEquals(hostName, (String) errorJSON.get(Constants.ErrorFields.HOSTNAME.getName()));    }    assertTrue(((long) errorJSON.get(Constants.ErrorFields.TIMESTAMP.getName())) > 0);}
public void metron_f3337_0()
{    Throwable e = new Exception("test exception");    MetronError error = new MetronError().withThrowable(e);    JSONObject errorJSON = error.getJSONObject();    assertEquals("java.lang.Exception: test exception", errorJSON.get(Constants.ErrorFields.EXCEPTION.getName()));    assertTrue(((String) errorJSON.get(Constants.ErrorFields.STACK.getName())).startsWith("java.lang.Exception: test exception"));    assertEquals(e.getMessage(), errorJSON.get(Constants.ErrorFields.MESSAGE.getName()));}
public void metron_f3338_0()
{    JSONObject message1 = new JSONObject();    JSONObject message2 = new JSONObject();    message1.put("value", "message1");    message2.put("value", "message2");    MetronError error = new MetronError().withRawMessages(Arrays.asList(message1, message2));    JSONObject errorJSON = error.getJSONObject();    assertEquals("{\"value\":\"message1\"}", errorJSON.get(Constants.ErrorFields.RAW_MESSAGE.getName() + "_0"));    assertEquals("{\"value\":\"message2\"}", errorJSON.get(Constants.ErrorFields.RAW_MESSAGE.getName() + "_1"));    error = new MetronError().addRawMessage("raw message".getBytes(StandardCharsets.UTF_8));    errorJSON = error.getJSONObject();    assertEquals("raw message", errorJSON.get(Constants.ErrorFields.RAW_MESSAGE.getName()));            assertEquals("3b02cb29676bc448c69da1ec5eef7c89f4d6dc6a5a7ce0296ea25b207eea36be", errorJSON.get(Constants.ErrorFields.ERROR_HASH.getName()));    error = new MetronError().addRawMessage(message1);    errorJSON = error.getJSONObject();    assertEquals("{\"value\":\"message1\"}", errorJSON.get(Constants.ErrorFields.RAW_MESSAGE.getName()));    assertEquals("e8aaf87c8494d345aac2d612ffd94fcf0b98c975fe6c4b991e2f8280a3a0bd10", errorJSON.get(Constants.ErrorFields.ERROR_HASH.getName()));}
public void metron_f3339_0()
{    JSONObject message = new JSONObject();    message.put("field1", "value1");    message.put("field2", "value2");    MetronError error = new MetronError().addRawMessage(message).withErrorFields(Sets.newHashSet("field1", "field2"));    JSONObject errorJSON = error.getJSONObject();    assertEquals(Sets.newHashSet("field1", "field2"), Sets.newHashSet(((String) errorJSON.get(Constants.ErrorFields.ERROR_FIELDS.getName())).split(",")));    assertEquals("04a2629c39e098c3944be85f35c75876598f2b44b8e5e3f52c59fa1ac182817c", errorJSON.get(Constants.ErrorFields.ERROR_HASH.getName()));}
public void metron_f3340_0()
{        Map<String, Object> metadata = new HashMap<>();    metadata.put("metron.metadata.topic", "bro");    metadata.put("metron.metadata.partition", 0);    metadata.put("metron.metadata.offset", 123);    JSONObject message = new JSONObject();    message.put("field1", "value1");    message.put("field2", "value2");    MetronError error = new MetronError().addRawMessage(message).withMetadata(metadata);        JSONObject errorMessage = error.getJSONObject();    assertEquals("bro", errorMessage.get("metron.metadata.topic"));    assertEquals(0, errorMessage.get("metron.metadata.partition"));    assertEquals(123, errorMessage.get("metron.metadata.offset"));}
public void metron_f3341_0()
{        Map<String, Object> metadata = new HashMap<>();    JSONObject message = new JSONObject();    message.put("field1", "value1");    message.put("field2", "value2");    MetronError error = new MetronError().addRawMessage(message).withMetadata(metadata);        JSONObject errorMessage = error.getJSONObject();    assertFalse(errorMessage.containsKey("metron.metadata.topic"));    assertFalse(errorMessage.containsKey("metron.metadata.partition"));    assertFalse(errorMessage.containsKey("metron.metadata.offset"));}
public void metron_f3342_0() throws Exception
{    String actual = new DeDotFieldNameConverter().convert("testfield.with.colons");    assertEquals("testfield:with:colons", actual);}
public void metron_f3343_0() throws Exception
{    String actual = new DeDotFieldNameConverter().convert("test-field-no-colons");    assertEquals("test-field-no-colons", actual);}
private WriterConfiguration metron_f3344_0(String writer, String sensor, String json) throws Exception
{    IndexingConfigurations indexingConfig = new IndexingConfigurations();    indexingConfig.updateSensorIndexingConfig(sensor, json.getBytes(StandardCharsets.UTF_8));    return new IndexingWriterConfiguration(writer, indexingConfig);}
public void metron_f3345_0() throws Exception
{    final String writer = "elasticsearch";    final String sensor = "bro";    WriterConfiguration config = createConfig(writer, sensor, jsonWithDedot);        FieldNameConverter converter = FieldNameConverters.create(sensor, config);    assertEquals(FieldNameConverters.DEDOT, converter);}
public void metron_f3346_0() throws Exception
{    final String writer = "elasticsearch";    final String sensor = "bro";    WriterConfiguration config = createConfig(writer, sensor, jsonWithNoop);        FieldNameConverter converter = FieldNameConverters.create(sensor, config);    assertEquals(FieldNameConverters.NOOP, converter);}
public void metron_f3347_0() throws Exception
{    final String writer = "elasticsearch";    final String sensor = "bro";    WriterConfiguration config = createConfig(writer, sensor, jsonWithNoConverter);        FieldNameConverter converter = FieldNameConverters.create(sensor, config);    assertEquals(FieldNameConverters.DEDOT, converter);}
public void metron_f3348_0() throws Exception
{    final String writer = "elasticsearch";    final String sensor = "bro";        WriterConfiguration config = createConfig(writer, sensor, jsonWithNoConverter);    assertEquals(FieldNameConverters.DEDOT, FieldNameConverters.create(sensor, config));        WriterConfiguration newConfig = createConfig(writer, sensor, jsonWithNoop);    assertEquals(FieldNameConverters.NOOP, FieldNameConverters.create(sensor, newConfig));}
public void metron_f3349_0() throws Exception
{    final String writer = "elasticsearch";    final String sensor = "bro";    WriterConfiguration config = createConfig(writer, sensor, jsonWithInvalidConverter);        FieldNameConverter converter = FieldNameConverters.create(sensor, config);    assertEquals(FieldNameConverters.DEDOT, converter);}
public void metron_f3350_0() throws Exception
{    final String writer = "elasticsearch";    final String sensor = "bro";    WriterConfiguration config = createConfig(writer, sensor, jsonWithInvalidConverter);        FieldNameConverter converter = FieldNameConverters.create(sensor, config);    assertEquals(FieldNameConverters.DEDOT, converter);}
public Map<String, Object> metron_f3351_0(Map<String, Object> input, List<String> outputField, LinkedHashMap<String, Object> fieldMappingConfig, Context context, Map<String, Object>... sensorConfig)
{    return ImmutableMap.of(outputField.get(0), Joiner.on(fieldMappingConfig.get("delim").toString()).join(input.entrySet()));}
public void metron_f3352_0() throws IOException
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(config));    Assert.assertEquals(1, c.getFieldTransformations().size());    Assert.assertEquals(IPProtocolTransformation.class, c.getFieldTransformations().get(0).getFieldTransformation().getClass());    Assert.assertEquals(ImmutableList.of("protocol"), c.getFieldTransformations().get(0).getInput());}
public void metron_f3353_0() throws IOException
{    SensorParserConfig.fromBytes(Bytes.toBytes(badConfigMissingMapping));}
public void metron_f3354_0() throws IOException
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(complexConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    Assert.assertNotNull(handler);    Assert.assertEquals(ImmutableMap.of("output", "field1=value1,field2=value2"), handler.transform(new JSONObject(ImmutableMap.of("field1", "value1", "field2", "value2")), Context.EMPTY_CONTEXT(), c.getParserConfig()));}
public void metron_f3355_0() throws IOException
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(config));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    Assert.assertNotNull(handler);    Assert.assertEquals(ImmutableMap.of("protocol", "TCP"), handler.transform(new JSONObject(ImmutableMap.of("protocol", 6)), Context.EMPTY_CONTEXT(), c.getParserConfig()));}
private String metron_f3356_0(String in, String config) throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(config));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("in_field", in);                        put("dummy_field", "dummy");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    return (String) input.get("out_field");}
public void metron_f3357_0() throws Exception
{    Assert.assertEquals("option_1", transform("foo", routeSingleInSingleOut));    Assert.assertNull(transform("bar", routeSingleInSingleOut));}
public void metron_f3358_0() throws Exception
{    Assert.assertEquals("option_2", transform("I am mortron", routeSingleInSingleOut));    Assert.assertEquals("option_2", transform("metron is for smelling", routeSingleInSingleOut));}
public void metron_f3359_0() throws Exception
{    Assert.assertEquals("option_1", transform("metron is for foorensic cybersecurity", routeSingleInSingleOut));}
public void metron_f3360_0() throws Exception
{    Assert.assertNull(transform("metron", routeMissingInput));}
public void metron_f3361_0() throws Exception
{    Assert.assertNull(transform("metron", routeMissingOutput));}
public void metron_f3362_0() throws Exception
{    Assert.assertEquals("option_1", transform("foo", routeMultiOutput));    Assert.assertNull(transform("bar", routeMultiOutput));}
public void metron_f3363_0() throws Exception
{    Assert.assertEquals("option_2", transform("metron", routeBadRegex));}
public void metron_f3364_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(removeUnconditionalConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("field1", "foo");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertFalse(input.containsKey("field1"));}
public void metron_f3365_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(removeConditionalConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    {        JSONObject input = new JSONObject(new HashMap<String, Object>() {            {                put("field1", "foo");            }        });        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());                Assert.assertTrue(input.containsKey("field1"));        Assert.assertFalse(input.containsKey("field2"));    }    {        JSONObject input = new JSONObject(new HashMap<String, Object>() {            {                put("field1", "foo");                put("field2", "bar");            }        });        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());                Assert.assertTrue(input.containsKey("field1"));        Assert.assertTrue(input.containsKey("field2"));    }    {        JSONObject input = new JSONObject(new HashMap<String, Object>() {            {                put("field1", "bar");                put("field2", "foo");            }        });                handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());        Assert.assertFalse(input.containsKey("field1"));        Assert.assertTrue(input.containsKey("field2"));    }}
public void metron_f3366_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(smoketestConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            for (int i = 1; i <= 10; ++i) {                put("old_field" + i, "f" + i);            }        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertEquals("f1", input.get("new_field1"));    Assert.assertEquals("f2", input.get("new_field2"));    for (int i = 3; i <= 10; ++i) {        Assert.assertEquals("f" + i, input.get("old_field" + i));    }    Assert.assertFalse(input.containsKey("old_field1"));    Assert.assertFalse(input.containsKey("old_field2"));    Assert.assertEquals(10, input.size());}
public void metron_f3367_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(renameMissingField));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            for (int i = 2; i <= 10; ++i) {                put("old_field" + i, "f" + i);            }        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertFalse(input.containsKey("new_field1"));    for (int i = 2; i <= 10; ++i) {        Assert.assertEquals("f" + i, input.get("old_field" + i));    }    Assert.assertEquals(9, input.size());}
public void metron_f3368_0() throws Exception
{    SensorParserConfig sensorConfig = SensorParserConfig.fromBytes(Bytes.toBytes(selectSingleFieldConfig));    FieldTransformer handler = Iterables.getFirst(sensorConfig.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("field1", "foo");            put("field2", "bar");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertTrue(input.containsKey("field1"));    Assert.assertFalse(input.containsKey("field2"));    Assert.assertEquals(1, input.size());}
public void metron_f3369_0() throws Exception
{    SensorParserConfig sensorConfig = SensorParserConfig.fromBytes(Bytes.toBytes(selectMultiFieldConfig));    FieldTransformer handler = Iterables.getFirst(sensorConfig.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("field1", "foo");            put("field2", "bar");            put("field3", "bar2");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertTrue(input.containsKey("field1"));    Assert.assertTrue(input.containsKey("field2"));    Assert.assertFalse(input.containsKey("field3"));    Assert.assertEquals(2, input.size());}
public void metron_f3370_0() throws Exception
{    SensorParserConfig sensorConfig = SensorParserConfig.fromBytes(Bytes.toBytes(selectSingleFieldConfig));    FieldTransformer handler = Iterables.getFirst(sensorConfig.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("timestamp", 12345);            put("original_string", "foo,bar");            put("source.type", "test");            put("field1", "foo");            put("field2", "bar");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertTrue(input.containsKey("timestamp"));    Assert.assertTrue(input.containsKey("original_string"));    Assert.assertTrue(input.containsKey("source.type"));    Assert.assertTrue(input.containsKey("field1"));    Assert.assertFalse(input.containsKey("field2"));    Assert.assertEquals(4, input.size());}
public static Collection<Object[]> metron_f3371_0()
{    return Arrays.asList(new Object[][] { { CachingStellarProcessor.createCache(ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, 10)) }, { CachingStellarProcessor.createCache(ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, 1)) }, { CachingStellarProcessor.createCache(ImmutableMap.of(CachingStellarProcessor.MAX_CACHE_SIZE_PARAM, 0)) }, { null } });}
public void metron_f3372_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(configAll));    JSONObject input = new JSONObject();    input.put("source.type", "test");    for (FieldTransformer handler : c.getFieldTransformations()) {        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    }    Assert.assertEquals(2, input.size());    Assert.assertTrue(input.containsKey("new_field"));    Assert.assertEquals("test", input.get("new_field"));}
public void metron_f3373_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(configRename));    {        JSONObject input = new JSONObject();        input.put("old_field", "val");        input.put("old_field2", "val2");        for (FieldTransformer handler : c.getFieldTransformations()) {            handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());        }        Assert.assertEquals(2, input.size());        Assert.assertTrue(input.containsKey("new_field"));        Assert.assertEquals("val", input.get("new_field"));        Assert.assertEquals("val2", input.get("new_field2"));        Assert.assertTrue(!input.containsKey("old_field"));        Assert.assertTrue(!input.containsKey("old_field2"));    }    {        JSONObject input = new JSONObject();        input.put("old_field", "val");        for (FieldTransformer handler : c.getFieldTransformations()) {            handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());        }        Assert.assertEquals(1, input.size());        Assert.assertTrue(input.containsKey("new_field"));        Assert.assertEquals("val", input.get("new_field"));    }}
public void metron_f3374_0() throws Exception
{    /*    Despite the domain being weird, URL_TO_HOST should allow it to pass through.    However, because it does NOT form a proper domain (no TLD), DOMAIN_REMOVE_SUBDOMAINS returns    null indicating that the input is semantically incorrect.     */    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(configNumericDomain));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject();    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertTrue(input.containsKey("full_hostname"));    Assert.assertEquals("1234567890123456789012345678901234567890123456789012345678901234567890", input.get("full_hostname"));    Assert.assertFalse(input.containsKey("domain_without_subdomains"));}
public void metron_f3375_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(badConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject();    try {        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    } catch (IllegalStateException ex) {        Assert.assertTrue(ex.getMessage().contains("URL_TO_HOST"));        Assert.assertTrue(ex.getMessage().contains("123"));        throw ex;    }}
public void metron_f3376_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(intermediateValuesConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    int expected = 3;    Assert.assertEquals(expected, input.get("final_value"));    Assert.assertFalse(input.containsKey("value1"));    Assert.assertFalse(input.containsKey("value2"));}
public void metron_f3377_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(stellarConfigEspecial));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("timestamp", "2016-01-05 17:02:30");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    long expected = 1452013350000L;    Assert.assertEquals(expected, input.get("utc_timestamp"));    Assert.assertTrue(input.containsKey("timestamp"));    Assert.assertTrue(input.containsKey("newStellarField"));}
public void metron_f3378_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(stellarConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    JSONObject input = new JSONObject(new HashMap<String, Object>() {        {            put("timestamp", "2016-01-05 17:02:30");        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    long expected = 1452013350000L;    Assert.assertEquals(expected, input.get("utc_timestamp"));    Assert.assertTrue(input.containsKey("timestamp"));}
public void metron_f3379_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(stellarConfig));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);        JSONObject input = new JSONObject(new HashMap<String, Object>() {        {        }    });    handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());    Assert.assertFalse(input.containsKey("utc_timestamp"));    Assert.assertTrue(input.isEmpty());}
public void metron_f3380_0() throws Exception
{    SensorParserConfig c = SensorParserConfig.fromBytes(Bytes.toBytes(stellarConfig_multi));    FieldTransformer handler = Iterables.getFirst(c.getFieldTransformations(), null);    {                JSONObject input = new JSONObject(new HashMap<String, Object>() {            {                put("timestamp", "2016-01-05 17:02:30");                put("url", "https://caseystella.com/blog");                                put("dc", "portland");            }        });        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT());        long expected = 1452013350000L;        Assert.assertEquals(expected, input.get("utc_timestamp"));        Assert.assertEquals("caseystella.com", input.get("url_host"));        Assert.assertEquals("https", input.get("url_protocol"));        Assert.assertTrue(input.containsKey("timestamp"));        Assert.assertTrue(input.containsKey("url"));    }    {                JSONObject input = new JSONObject(new HashMap<String, Object>() {            {                put("timestamp", "2016-01-05 17:02:30");                put("url", "https://caseystella.com/blog");                put("dc", "london");            }        });        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT(), c.getParserConfig());        long expected = 1452013350000L;        Assert.assertEquals(expected, input.get("utc_timestamp"));        Assert.assertEquals("caseystella.com", input.get("url_host"));        Assert.assertEquals("https", input.get("url_protocol"));        Assert.assertTrue(input.containsKey("timestamp"));        Assert.assertTrue(input.containsKey("url"));    }        {        JSONObject input = new JSONObject(new HashMap<String, Object>() {            {                put("timestamp", "2016-01-05 17:02:30");                put("url", "https://caseystella.com/blog");            }        });        handler.transformAndUpdate(input, Context.EMPTY_CONTEXT(), c.getParserConfig());        long expected = 1452013350000L;        Assert.assertEquals(expected, input.get("utc_timestamp"));        Assert.assertEquals("caseystella.com", input.get("url_host"));        Assert.assertEquals("https", input.get("url_protocol"));        Assert.assertTrue(input.containsKey("timestamp"));        Assert.assertTrue(input.containsKey("url"));    }}
public Configurations metron_f3381_0(String config) throws IOException
{    Configurations configurations = new Configurations();    configurations.updateGlobalConfig(Bytes.toBytes(config));    return configurations;}
public FieldValidator metron_f3382_0(Configurations configurations) throws IOException
{    return configurations.getFieldValidations().get(0);}
public boolean metron_f3383_0(String config, Map<String, Object> input) throws IOException
{    Configurations configurations = getConfiguration(config);    FieldValidator validator = getValidator(configurations);    return validator.isValid(new JSONObject(input), configurations.getGlobalConfig(), Context.EMPTY_CONTEXT());}
public void metron_f3384_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "caseystella.com")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "caseystella.com")));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "www.hotmail.co.uk")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "www.hotmail.co.uk")));}
public void metron_f3385_0() throws IOException
{    Assert.assertFalse(runPredicate("IS_DOMAIN()", Collections.emptyMap()));    Assert.assertFalse(runPredicate("IS_DOMAIN('')", Collections.emptyMap()));}
public void metron_f3386_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "foo")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "caseystella.turtle")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "caseystella.turtle")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.7f)));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 2.7f)));}
public void metron_f3387_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "www.gmail.com", "field2", "www.hotmail.com")));    Assert.assertTrue(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "www.gmail.com", "field2", "www.hotmail.com")));}
public void metron_f3388_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field2", "hotmail.edu")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field2", "hotmail.edu")));    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", "", "field2", "gmail.com")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "", "field2", "gmail.com")));}
public void metron_f3389_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "me@caseystella.com")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "me@caseystella.com")));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "me@www.hotmail.co.uk")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "me@www.hotmail.co.uk")));}
public void metron_f3390_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "me@foo")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "me@foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "caseystella.turtle")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "caseystella.turtle")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "caseystella.com")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "caseystella.com")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.7f)));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 2.7f)));}
public void metron_f3391_0() throws IOException
{    Assert.assertFalse(runPredicate("IS_EMAIL()", Collections.emptyMap()));    Assert.assertFalse(runPredicate("IS_EMAIL('')", Collections.emptyMap()));}
public void metron_f3392_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "me@www.gmail.com", "field2", "me@www.hotmail.com")));    Assert.assertTrue(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "me@www.gmail.com", "field2", "me@www.hotmail.com")));}
public void metron_f3393_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field2", "me@hotmail.edu")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field2", "me@hotmail.edu")));    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", "", "field2", "me@gmail.com")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "", "field2", "me@gmail.com")));}
public void metron_f3394_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "127.0.0.1")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "127.0.0.1")));}
public void metron_f3395_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "2014/05/01")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "2014/05/01")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.3f)));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 2.3f)));}
public void metron_f3396_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "192.168.0.1", "field2", "127.0.0.2")));    Assert.assertTrue(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "192.168.0.1", "field2", "127.0.0.2")));}
public void metron_f3397_0() throws IOException
{    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", 1, "field2", "192.168.1")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", 1, "field2", "192.168.1")));}
public void metron_f3398_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFieldsMultipleTypes, ImmutableMap.of("field1", "192.168.0.1", "field2", "127.0.0.2")));    Assert.assertTrue(runPredicate(validWithMultipleFieldsMultipleTypes_MQL, ImmutableMap.of("field1", "192.168.0.1", "field2", "127.0.0.2")));}
public void metron_f3399_0() throws IOException
{    Assert.assertFalse(execute(validWithMultipleFieldsMultipleTypes, ImmutableMap.of("field1", 1, "field2", "192.168.1")));    Assert.assertFalse(runPredicate(validWithMultipleFieldsMultipleTypes_MQL, ImmutableMap.of("field1", 1, "field2", "192.168.1")));}
public void metron_f3400_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "http://caseystella.com/foo")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "http://caseystella.com/foo")));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "https://www.hotmail.co.uk")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "https://www.hotmail.co.uk")));}
public void metron_f3401_0() throws IOException
{    Assert.assertFalse(runPredicate("IS_URL()", Collections.emptyMap()));    Assert.assertFalse(runPredicate("IS_URL('')", Collections.emptyMap()));}
public void metron_f3402_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "foo")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "http://caseystella.turtle")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "http://caseystella.turtle")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.7f)));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 2.7f)));}
public void metron_f3403_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "ftp://www.gmail.com", "field2", "http://www.hotmail.com")));    Assert.assertTrue(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "ftp://www.gmail.com", "field2", "http://www.hotmail.com")));}
public void metron_f3404_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field2", "http://hotmail.edu")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field2", "http://hotmail.edu")));    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", "", "field2", "http://gmail.com")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "", "field2", "http://gmail.com")));}
public void metron_f3405_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "2014-05-01")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "2014-05-01")));}
public void metron_f3406_0() throws IOException
{    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 2.3f)));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "2014/05/01")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "2014/05/01")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.3f)));        Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "2014-25-01")));        Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "2014-05-32")));}
public void metron_f3407_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "2014-06-01", "field2", "2014-06-02")));    Assert.assertTrue(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "2014-06-01", "field2", "2014-06-02")));}
public void metron_f3408_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field2", "2014-06-02")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field2", "2014-06-02")));    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", 1, "field2", "2014-06-02")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", 1, "field2", "2014-06-02")));    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field3", "2014-06-02")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field3", "2014-06-02")));}
public void metron_f3409_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", 1)));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 1)));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "1")));    Assert.assertTrue(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "1")));}
public void metron_f3410_0() throws IOException
{    Assert.assertFalse(runPredicate("IS_INTEGER()", Collections.emptyMap()));    Assert.assertFalse(runPredicate("IS_INTEGER('')", Collections.emptyMap()));}
public void metron_f3411_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "foo")));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", "foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.3f)));    Assert.assertFalse(runPredicate(validWithSingleField_MQL, ImmutableMap.of("field1", 2.3f)));}
public void metron_f3412_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", 1, "field2", "2")));    Assert.assertTrue(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", 1, "field2", "2")));}
public void metron_f3413_0() throws IOException
{    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field2", "foo")));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field2", "foo")));    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", "", "field2", 1)));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", "", "field2", 1)));    Assert.assertFalse(execute(validWithMultipleFields, ImmutableMap.of("field1", " ", "field2", 2)));    Assert.assertFalse(runPredicate(validWithMultipleFields_MQL, ImmutableMap.of("field1", " ", "field2", 2)));}
public void metron_f3414_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "foo")));}
public void metron_f3415_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field2", "foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", " ")));}
public void metron_f3416_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "foo", "field2", "bar")));}
public void metron_f3417_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field2", "foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "", "field2", "bar")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", " ", "field2", "bar")));}
public void metron_f3418_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "foo")));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "fop")));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field1", "fo")));}
public void metron_f3419_0() throws IOException
{    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", "flo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 2.3f)));}
public void metron_f3420_0() throws IOException
{    Assert.assertTrue(execute(validWithMultipleFields, ImmutableMap.of("field1", "fooo", "field2", "foll")));}
public void metron_f3421_0() throws IOException
{    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field2", "foo")));    Assert.assertFalse(execute(validWithSingleField, ImmutableMap.of("field1", 1, "field2", "foo")));    Assert.assertTrue(execute(validWithSingleField, ImmutableMap.of("field3", "foo")));}
public void metron_f3422_0() throws IOException
{    Assert.assertTrue(execute(validQueryConfig, ImmutableMap.of("field1", "foo")));}
public void metron_f3423_0() throws IOException
{    Assert.assertTrue(execute(validQueryConfig_map, ImmutableMap.of("dc", "la")));}
public void metron_f3424_0() throws IOException
{    Assert.assertFalse(execute(validQueryConfig_map, ImmutableMap.of("dc", "nyc")));    Assert.assertFalse(execute(validQueryConfig_map, ImmutableMap.of("foo", "nyc")));}
public void metron_f3425_0() throws IOException
{    Assert.assertFalse(execute(validQueryConfig, ImmutableMap.of("field2", "foo")));}
public void metron_f3426_0() throws IOException
{    getConfiguration(invalidQueryConfig1);}
public void metron_f3427_0() throws IOException
{    getConfiguration(invalidQueryConfig2);}
public void metron_f3428_0() throws IOException
{    {        Configurations configurations = getConfiguration(validValidationConfigWithStringInput);        Assert.assertNotNull(configurations.getFieldValidations());        Assert.assertEquals(1, configurations.getFieldValidations().size());        Assert.assertEquals(ImmutableList.of("field1"), configurations.getFieldValidations().get(0).getInput());    }    {        Configurations configurations = getConfiguration(validValidationConfigWithListInput);        Assert.assertNotNull(configurations.getFieldValidations());        Assert.assertEquals(1, configurations.getFieldValidations().size());        Assert.assertEquals(ImmutableList.of("field1", "field2"), configurations.getFieldValidations().get(0).getInput());    }}
public void metron_f3429_0() throws IOException
{    getConfiguration(invalidValidationConfig);}
public void metron_f3430_0()
{    MockitoAnnotations.initMocks(this);    configSupplier = () -> ImmutableMap.of("performance.logging.percent.records", thresholdPercent);    when(thresholdCalc.isPast(thresholdPercent)).thenReturn(false).thenReturn(false).thenReturn(true);    when(logger.isDebugEnabled()).thenReturn(true);    when(timing.exists("t1")).thenReturn(true);    perfLogger = new PerformanceLogger(configSupplier, logger, thresholdCalc, timing);}
public void metron_f3431_0() throws Exception
{    when(timing.getElapsed("t1")).thenReturn(111L).thenReturn(222L).thenReturn(333L);    perfLogger.mark("t1");    perfLogger.log("t1");    perfLogger.log("t1");    perfLogger.log("t1");    verify(timing).mark("t1");    verify(logger, times(1)).debug(anyString(), anyObject(), eq(111L), eq(""));}
public void metron_f3432_0() throws Exception
{    when(timing.getElapsed("t1")).thenReturn(111L).thenReturn(222L).thenReturn(333L);    perfLogger.mark("t1");    perfLogger.log("t1", "my message");    perfLogger.log("t1", "my message");    perfLogger.log("t1", "my message");    verify(timing).mark("t1");    verify(logger, times(1)).debug(anyString(), anyObject(), eq(111L), eq("my message"));}
public void metron_f3433_0() throws Exception
{    when(thresholdCalc.isPast(thresholdPercent)).thenReturn(true);    when(timing.getElapsed("t1")).thenReturn(111L);    when(timing.getElapsed("t2")).thenReturn(222L);    when(timing.getElapsed("t3")).thenReturn(333L);    when(timing.exists("t1")).thenReturn(true);    when(timing.exists("t2")).thenReturn(false);    when(timing.exists("t3")).thenReturn(false);    perfLogger.mark("t1");    perfLogger.log("t1", "my message");    perfLogger.log("t2", "my message");    perfLogger.log("t3", "my message");    verify(timing).mark("t1");    verify(timing, never()).mark("t2");    verify(timing, never()).mark("t3");    verify(logger).debug(anyString(), anyObject(), eq(111L), eq("my message"));    verify(logger).debug(anyString(), eq("WARNING - MARK NOT SET"), eq(222L), eq("my message"));    verify(logger).debug(anyString(), eq("WARNING - MARK NOT SET"), eq(333L), eq("my message"));}
public void metron_f3434_0() throws Exception
{    when(thresholdCalc.isPast(thresholdPercent)).thenReturn(true);    when(timing.getElapsed("t1")).thenReturn(111L);    when(timing.getElapsed("t2")).thenReturn(222L);    perfLogger.mark("t1");    perfLogger.mark("t2");    perfLogger.log("t2", "my message 2");    perfLogger.log("t1", "my message 1");    verify(timing).mark("t1");    verify(timing).mark("t2");    verify(logger).debug(anyString(), anyObject(), eq(111L), eq("my message 1"));    verify(logger).debug(anyString(), anyObject(), eq(222L), eq("my message 2"));}
public void metron_f3435_0() throws Exception
{    configSupplier = () -> new HashMap<>();    when(thresholdCalc.isPast(1)).thenReturn(false).thenReturn(false).thenReturn(true);    when(timing.getElapsed("t1")).thenReturn(111L).thenReturn(222L).thenReturn(333L);    perfLogger.mark("t1");    perfLogger.log("t1", "my message");    perfLogger.log("t1", "my message");    perfLogger.log("t1", "my message");    verify(timing).mark("t1");    verify(logger, times(1)).debug(anyString(), anyObject(), eq(111L), eq("my message"));}
public void metron_f3436_0() throws Exception
{    when(logger.isDebugEnabled()).thenReturn(false);    when(timing.getElapsed("t1")).thenReturn(111L).thenReturn(222L).thenReturn(333L);    perfLogger.mark("t1");    perfLogger.log("t1", "my message");    perfLogger.log("t1", "my message");    perfLogger.log("t1", "my message");    verify(timing).mark("t1");    verify(logger, times(0)).debug(anyString(), anyObject(), eq(111L), eq("my message"));}
public void metron_f3437_0() throws Exception
{    when(thresholdCalc.isPast(thresholdPercent)).thenReturn(true);    when(timing.getElapsed("t1")).thenReturn(111L).thenReturn(222L).thenReturn(333L).thenReturn(444L);    perfLogger.mark("t1");    perfLogger.log("t1", "my {} message", "1");    perfLogger.log("t1", "my {} message {}", "1", "2");    perfLogger.log("t1", "my {} message {} {}", "1", "2", "3");    perfLogger.log("t1", "my {} message {} {} {}", "1", "2", "3", "4");    verify(timing).mark("t1");    verify(logger, times(1)).debug(anyString(), anyObject(), eq(111L), eq("my 1 message"));    verify(logger, times(1)).debug(anyString(), anyObject(), eq(222L), eq("my 1 message 2"));    verify(logger, times(1)).debug(anyString(), anyObject(), eq(333L), eq("my 1 message 2 3"));    verify(logger, times(1)).debug(anyString(), anyObject(), eq(444L), eq("my 1 message 2 3 4"));}
public void metron_f3438_0()
{    when(logger.isDebugEnabled()).thenReturn(true);    assertThat(perfLogger.isDebugEnabled(), equalTo(true));}
public void metron_f3439_0()
{    timing = new Timing();}
public void metron_f3440_0() throws InterruptedException
{    timing.mark("mark1");    long tlast = 0;    for (int i = 0; i < 10; i++) {        tlast = timing.getElapsed("mark1");        Thread.sleep(10);        assertThat(timing.getElapsed("mark1") > tlast, equalTo(true));    }}
public void metron_f3441_0() throws InterruptedException
{    timing.mark("mark1");    timing.mark("mark2");    long tlast1 = 0;    long tlast2 = 0;    for (int i = 0; i < 10; i++) {        tlast1 = timing.getElapsed("mark1");        tlast2 = timing.getElapsed("mark2");        Thread.sleep(10);        assertThat(timing.getElapsed("mark1") > tlast1, equalTo(true));        assertThat(timing.getElapsed("mark2") > tlast2, equalTo(true));    }}
public void metron_f3442_0() throws InterruptedException
{    timing.mark("mark1");    long tlast1 = 0;    for (int i = 0; i < 10; i++) {        tlast1 = timing.getElapsed("mark1");        Thread.sleep(10);        assertThat(timing.getElapsed("mark1") > tlast1, equalTo(true));        assertThat(timing.getElapsed("mark2"), equalTo(0L));    }}
public void metron_f3443_0() throws InterruptedException
{    timing.mark("mark1");    long tlast1 = 0;    for (int i = 0; i < 5; i++) {        Thread.sleep(10);        tlast1 = timing.getElapsed("mark1");        timing.mark("mark1");        assertThat(timing.getElapsed("mark1") < tlast1, equalTo(true));    }}
public void metron_f3444_0()
{    timing.mark("mark1");    assertThat(timing.exists("mark1"), equalTo(true));    assertThat(timing.exists("mark2"), equalTo(false));    assertThat(timing.exists("mark3"), equalTo(false));}
public void metron_f3445_0() throws Exception
{    Clock clock = new Clock();    long t1 = clock.currentTimeMillis();    Thread.sleep(50);    long t2 = clock.currentTimeMillis();    Thread.sleep(50);    long t3 = clock.currentTimeMillis();    assertThat("t3 should be greater", t3 > t2, equalTo(true));    assertThat("t2 should be greater", t2 > t1, equalTo(true));}
public void metron_f3446_0() throws Exception
{    Clock clock = Mockito.spy(Clock.class);    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));    Date date = sdf.parse("20160615183527162+0000");    Mockito.when(clock.currentTimeMillis()).thenReturn(date.getTime());    assertThat("time not right", clock.currentTimeFormatted("yyyyMMddHHmmssSSSZ"), equalTo("20160615183527162+0000"));}
public static void metron_f3447_0() throws Exception
{    for (Map.Entry<String, EnumMap<TyposquattingStrategies, Set<String>>> kv : expected.entrySet()) {        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/typosquat/" + kv.getKey() + ".csv"), StandardCharsets.UTF_8))) {            for (String line = null; (line = br.readLine()) != null; ) {                if (line.startsWith("#")) {                    continue;                }                Iterable<String> tokens = Splitter.on(",").split(line);                String name = Iterables.get(tokens, 0);                String domain = Iterables.get(tokens, 1);                domain = domain.replaceAll(".com", "");                EnumMap<TyposquattingStrategies, Set<String>> expectedValues = kv.getValue();                if (typesToSkip.contains(name)) {                    continue;                }                TyposquattingStrategies strategy = TyposquattingStrategies.byName(name);                Assert.assertNotNull("Couldn't find " + name, strategy);                Set<String> s = expectedValues.get(strategy);                if (s == null) {                    s = new HashSet<>();                    expectedValues.put(strategy, s);                }                s.add(domain);            }        }    }}
public static Collection<Object[]> metron_f3448_0()
{    List<Object[]> ret = new ArrayList<>();    for (TyposquattingStrategies strategy : TyposquattingStrategies.values()) {        ret.add(new Object[] { strategy });    }    return ret;}
public void metron_f3449_0(String domain, TyposquattingStrategies strategy)
{    Set<String> expectedValues = expected.get(domain).get(strategy);    Set<String> actualValues = strategy.generateCandidates(domain);    Assert.assertFalse(actualValues.contains(domain));    {        Sets.SetView<String> vals = Sets.difference(expectedValues, actualValues);        String diff = Joiner.on(",").join(vals);        Assert.assertTrue(strategy.name() + ": Found values expected but not generated: " + diff, vals.isEmpty());    }}
public void metron_f3450_0()
{    for (String domain : expected.keySet()) {        assertExpected(domain, strategy);    }}
public void metron_f3451_0()
{    for (String domain : expected.keySet()) {        Set<String> expectedAll = TyposquattingStrategies.generateAllCandidates(domain);        Set<String> generatedAll = (Set<String>) StellarProcessorUtils.run("DOMAIN_TYPOSQUAT(domain)", ImmutableMap.of("domain", domain));        Assert.assertTrue(Sets.symmetricDifference(expectedAll, generatedAll).isEmpty());    }}
public void metron_f3452_0() throws IOException
{    tempDir = TestUtils.createTempDir(this.getClass().getName());    textFile = new File(tempDir, "test-text-file.txt");    TestUtils.write(textFile, SAMPLE_TEXT);}
public void metron_f3453_0() throws IOException
{    File gzipFile = new File(tempDir, "test-gz-compression-file.gz");    CompressionStrategies.GZIP.compress(textFile, gzipFile);    assertThat(CompressionStrategies.GZIP.test(gzipFile), equalTo(true));}
public void metron_f3454_0() throws IOException
{    File gzipFile = new File(tempDir, "test-gz-decompress.gz");    CompressionStrategies.GZIP.compress(textFile, gzipFile);    assertThat("gzipped file should exist", gzipFile.exists(), equalTo(true));    File unzippedText = new File(tempDir, "test-gz-decompressed.txt");    CompressionStrategies.GZIP.decompress(gzipFile, unzippedText);    assertThat("decompressed file should exist", unzippedText.exists(), equalTo(true));    String actual = TestUtils.read(unzippedText);    assertThat("decompressed text should match", actual, equalTo(SAMPLE_TEXT));}
public static void metron_f3455_0() throws IOException
{    if (dataFile.exists()) {        dataFile.delete();    }    Files.write(dataFile.toPath(), data.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    dataFile.deleteOnExit();}
public static BufferedReader metron_f3456_0()
{    try {        return new BufferedReader(new InputStreamReader(new FileInputStream(dataFile), StandardCharsets.UTF_8));    } catch (FileNotFoundException e) {        throw new IllegalStateException(e.getMessage(), e);    }}
private static void metron_f3457_0(Map<String, Integer> count)
{    Assert.assertEquals(5, count.size());    Assert.assertEquals(3, (int) count.get("foo"));    Assert.assertEquals(2, (int) count.get("bar"));    Assert.assertEquals(1, (int) count.get("and"));    Assert.assertEquals(1, (int) count.get("the"));}
public void metron_f3458_0() throws FileNotFoundException
{    try (Stream<String> stream = ReaderSpliterator.lineStream(getReader(), 2)) {        Map<String, Integer> count = stream.parallel().map(s -> s.trim()).collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));        validateMapCount(count);    }}
public void metron_f3459_0() throws FileNotFoundException
{    try (Stream<String> stream = ReaderSpliterator.lineStream(getReader(), 100)) {        Map<String, Integer> count = stream.parallel().map(s -> s.trim()).collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));        validateMapCount(count);    }}
public void metron_f3460_0() throws FileNotFoundException
{    try (Stream<String> stream = ReaderSpliterator.lineStream(getReader(), 100)) {        Map<String, Integer> count = stream.map(s -> s.trim()).collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));        validateMapCount(count);    }}
private int metron_f3461_0(final ReaderSpliterator spliterator) throws ExecutionException, InterruptedException
{    final AtomicInteger numSplits = new AtomicInteger(0);        Spliterator<String> delegatingSpliterator = spy(spliterator);    doAnswer(invocationOnMock -> {        Spliterator<String> ret = spliterator.trySplit();        if (ret != null) {            numSplits.incrementAndGet();        }        return ret;    }).when(delegatingSpliterator).trySplit();    Stream<String> stream = StreamSupport.stream(delegatingSpliterator, true);        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();    forkJoinPool.submit(() -> {        Map<String, Integer> threads = stream.parallel().map(s -> Thread.currentThread().getName()).collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));        Assert.assertTrue(threads.size() > 0);    }).get();    return numSplits.get();}
public void metron_f3462_0() throws ExecutionException, InterruptedException, IOException
{        try (BufferedReader reader = getReader()) {        Assert.assertEquals(9, getNumberOfBatches(new ReaderSpliterator(reader, 1)));    }}
public void metron_f3463_0() throws ExecutionException, InterruptedException, IOException
{        try (BufferedReader reader = getReader()) {        Assert.assertEquals(5, getNumberOfBatches(new ReaderSpliterator(reader, 2)));    }}
public void metron_f3464_0() throws ExecutionException, InterruptedException, IOException
{        try (BufferedReader reader = getReader()) {        Assert.assertEquals(1, getNumberOfBatches(new ReaderSpliterator(reader, 10)));    }}
public void metron_f3465_0()
{    JSONObject message = new JSONObject();    message.put("field1", "value1");    message.put("field2", "value2");    message.put("field3", "value3");    Collection<String> fields = Arrays.asList("field2", "field3");    assertEquals("6eab1c2c827387803ce457c76552f0511858fc1f9505c7dc620e198c0d1f4d02", HashUtils.getMessageHash(message, fields));}
public void metron_f3466_0()
{    JSONObject message = new JSONObject();    message.put("field1", "value1");    message.put("field2", "value2");    message.put("field3", "value3");    assertEquals("a76cdafc5aa49180c0b22c78d4415c505f9997c54847cec6c623f4cacf6a2811", HashUtils.getMessageHash(message));}
public void metron_f3467_0()
{    assertEquals("ab530a13e45914982b79f9b7e3fba994cfd1f3fb22f71cea1afbf02b460c6d1d", HashUtils.getMessageHash("message".getBytes(UTF_8)));}
public void metron_f3468_0() throws Exception
{    String outText = "small brown bike and casket lottery";    String outFile = tempDir.getRoot().getAbsolutePath() + "/outfile.txt";    Configuration config = new Configuration();    config.set("fs.default.name", "file:///");    HDFSUtils.write(config, outText.getBytes(StandardCharsets.UTF_8), outFile);    String actual = TestUtils.read(new File(outFile));    assertThat("Text should match", actual, equalTo(outText));}
public void metron_f3469_0() throws Exception
{    String outText = "small brown bike and casket lottery";    String outFile = tempDir.getRoot().getAbsolutePath() + "/outfile.txt";    Configuration config = new Configuration();    HDFSUtils.write(config, outText.getBytes(StandardCharsets.UTF_8), "file:///" + outFile);    String actual = TestUtils.read(new File(outFile));    assertThat("Text should match", actual, equalTo(outText));}
public static void metron_f3470_0() throws Exception
{    tmpDir = UnitTestHelper.createTempDir(new File("target/jsonutilstest"));    configFile = UnitTestHelper.write(new File(tmpDir, "config.json"), config);}
public void metron_f3471_0() throws Exception
{    Map<String, Object> expected = new HashMap<String, Object>() {        {            put("a", "hello");            put("b", "world");        }    };    Map<String, Object> actual = JSONUtils.INSTANCE.load(configFile, JSONUtils.MAP_SUPPLIER);    assertThat("config not equal", actual, equalTo(expected));}
public void metron_f3472_0() throws Exception
{    Map<String, Object> expected = new HashMap<String, Object>() {        {            put("a", "hello");            put("b", "world");        }    };    Map<String, Object> actual = JSONUtils.INSTANCE.load(configFile, Map.class);    assertThat("config not equal", actual, equalTo(expected));}
public void metron_f3473_0() throws Exception
{    TestConfig expected = new TestConfig().setA("hello").setB("world");    TestConfig actual = JSONUtils.INSTANCE.load(configFile, TestConfig.class);    assertThat("a not equal", actual.getA(), equalTo(expected.getA()));    assertThat("b not equal", actual.getB(), equalTo(expected.getB()));}
public String metron_f3474_0()
{    return a;}
public TestConfig metron_f3475_0(String a)
{    this.a = a;    return this;}
public String metron_f3476_0()
{    return b;}
public TestConfig metron_f3477_0(String b)
{    this.b = b;    return this;}
public void metron_f3478_0() throws IOException
{    String actual = new String(JSONUtils.INSTANCE.applyPatch(patchJson, sourceJson), StandardCharsets.UTF_8);    assertThat(JSONUtils.INSTANCE.load(actual, JSONUtils.MAP_SUPPLIER), equalTo(JSONUtils.INSTANCE.load(expectedJson, JSONUtils.MAP_SUPPLIER)));}
public void metron_f3479_0() throws IOException
{    String actual = new String(JSONUtils.INSTANCE.applyPatch(patchComplexJson, complexJson), StandardCharsets.UTF_8);    assertThat(JSONUtils.INSTANCE.load(actual, JSONUtils.MAP_SUPPLIER), equalTo(JSONUtils.INSTANCE.load(expectedComplexJson, JSONUtils.MAP_SUPPLIER)));}
public void metron_f3480_0() throws Exception
{    ArrayList<String> brokerIds = new ArrayList<>();    brokerIds.add("1");    when(client.getChildren()).thenReturn(childrenBuilder);    when(childrenBuilder.forPath("/brokers/ids")).thenReturn(brokerIds);    when(client.getData()).thenReturn(dataBuilder);    when(dataBuilder.forPath("/brokers/ids/1")).thenReturn(brokerWithHostPort.getBytes(StandardCharsets.UTF_8));    ArrayList<String> expected = new ArrayList<>();    expected.add("192.168.1.148:9092");    assertEquals(expected, (KafkaUtils.INSTANCE.getBrokersFromZookeeper(client)));}
public void metron_f3481_0() throws Exception
{    ArrayList<String> brokerIds = new ArrayList<>();    brokerIds.add("1");    when(client.getChildren()).thenReturn(childrenBuilder);    when(childrenBuilder.forPath("/brokers/ids")).thenReturn(brokerIds);    when(client.getData()).thenReturn(dataBuilder);    when(dataBuilder.forPath("/brokers/ids/1")).thenReturn(brokerWithEndpoints.getBytes(StandardCharsets.UTF_8));    ArrayList<String> expected = new ArrayList<>();    expected.add("host1:9092");    expected.add("host1:9093");    expected.add("host1:9094");    expected.add("host1:9095");    assertEquals(expected, (KafkaUtils.INSTANCE.getBrokersFromZookeeper(client)));}
public void metron_f3482_0() throws Exception
{    ArrayList<String> brokerIds = new ArrayList<>();    brokerIds.add("1");    when(client.getChildren()).thenReturn(childrenBuilder);    when(childrenBuilder.forPath("/brokers/ids")).thenReturn(brokerIds);    when(client.getData()).thenReturn(dataBuilder);    when(dataBuilder.forPath("/brokers/ids/1")).thenReturn(brokerWithHostPortAndEndpoints.getBytes(StandardCharsets.UTF_8));    ArrayList<String> expected = new ArrayList<>();    expected.add("192.168.1.148:9092");    assertEquals(expected, (KafkaUtils.INSTANCE.getBrokersFromZookeeper(client)));}
public static Collection<Object[]> metron_f3483_0()
{    List<Object[]> ret = new ArrayList<>();    for (String scheme : schemes) {        for (String hostname : hostnames) {            for (String port : ports) {                port = port != null ? (":" + port) : "";                String expected = hostname + port;                ret.add(new Object[] { scheme + "://" + expected, expected });            }        }    }    return ret;}
public void metron_f3484_0() throws URISyntaxException
{    assertEquals(expected, KafkaUtils.INSTANCE.fromEndpoint(endpoint).get(0));}
public String metron_f3485_0()
{    return null;}
public boolean metron_f3487_0(Marker reference)
{    return false;}
public boolean metron_f3488_0()
{    return false;}
public boolean metron_f3489_0()
{    return false;}
public Iterator<Marker> metron_f3490_0()
{    return null;}
public boolean metron_f3491_0(Marker other)
{    return false;}
public boolean metron_f3492_0(String name)
{    return false;}
private List<UUID> metron_f3493_0(int numGuids)
{    return IntStream.range(0, numGuids).mapToObj(x -> UUID.randomUUID()).collect(Collectors.toList());}
private LazyLogger metron_f3494_0()
{    final Logger loggerMock = mock(Logger.class);    return LazyLoggerFactory.getLogger(loggerMock);}
private LazyLogger metron_f3495_0()
{    final LazyLogger lazyLogger = getDisabledLogger();    Mockito.when(lazyLogger.getLogger().isTraceEnabled()).thenReturn(true);    Mockito.when(lazyLogger.getLogger().isTraceEnabled(any(Marker.class))).thenReturn(true);    return lazyLogger;}
private LazyLogger metron_f3496_0()
{    final LazyLogger lazyLogger = getDisabledLogger();    Mockito.when(lazyLogger.getLogger().isDebugEnabled()).thenReturn(true);    Mockito.when(lazyLogger.getLogger().isDebugEnabled(any(Marker.class))).thenReturn(true);    return lazyLogger;}
private LazyLogger metron_f3497_0()
{    final LazyLogger lazyLogger = getDisabledLogger();    Mockito.when(lazyLogger.getLogger().isInfoEnabled()).thenReturn(true);    Mockito.when(lazyLogger.getLogger().isInfoEnabled(any(Marker.class))).thenReturn(true);    return lazyLogger;}
private LazyLogger metron_f3498_0()
{    final LazyLogger lazyLogger = getDisabledLogger();    Mockito.when(lazyLogger.getLogger().isWarnEnabled()).thenReturn(true);    Mockito.when(lazyLogger.getLogger().isWarnEnabled(any(Marker.class))).thenReturn(true);    return lazyLogger;}
private LazyLogger metron_f3499_0()
{    final LazyLogger lazyLogger = getDisabledLogger();    Mockito.when(lazyLogger.getLogger().isErrorEnabled()).thenReturn(true);    Mockito.when(lazyLogger.getLogger().isErrorEnabled(any(Marker.class))).thenReturn(true);    return lazyLogger;}
private Supplier<Object> metron_f3500_0()
{    return mock(Supplier.class);}
public void metron_f3501_0()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getTraceEnabledLogger();    logger.isTraceEnabled();    Mockito.verify(logger.getLogger()).isTraceEnabled();    logger.isTraceEnabled(marker);    Mockito.verify(logger.getLogger()).isTraceEnabled(marker);    logger.trace(logString0);    Mockito.verify(logger.getLogger()).trace(logString0);    logger.trace(logString0, exception);    Mockito.verify(logger.getLogger()).trace(logString0, exception);    logger.trace(logString1, guids.get(0));    Mockito.verify(logger.getLogger()).trace(logString1, guids.get(0));    logger.trace(marker, logString0);    Mockito.verify(logger.getLogger()).trace(marker, logString0);    logger.trace(marker, logString0, exception);    Mockito.verify(logger.getLogger()).trace(marker, logString0, exception);    logger.trace(marker, logString1, guids.get(0));    Mockito.verify(logger.getLogger()).trace(marker, logString1, guids.get(0));}
public void metron_f3502_0()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getTraceEnabledLogger();    logger.trace(logString1, () -> guids.get(0));    Mockito.verify(logger.getLogger()).trace(logString1, guids.get(0));    logger.trace(marker, logString1, () -> guids.get(0));    Mockito.verify(logger.getLogger()).trace(marker, logString1, guids.get(0));}
public void metron_f3503_0()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();    logger.trace(logString1, supplier);    Mockito.verify(supplier, never()).get();    logger.trace(marker, logString1, supplier);    Mockito.verify(supplier, never()).get();}
public void metron_f3504_0()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getTraceEnabledLogger();    logger.trace(logString2, guids.get(0), guids.get(1));    Mockito.verify(logger.getLogger()).trace(logString2, guids.get(0), guids.get(1));    logger.trace(marker, logString2, guids.get(0), guids.get(1));    Mockito.verify(logger.getLogger()).trace(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3505_0()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getTraceEnabledLogger();    logger.trace(logString2, () -> guids.get(0), () -> guids.get(1));    Mockito.verify(logger.getLogger()).trace(logString2, guids.get(0), guids.get(1));    logger.trace(marker, logString2, () -> guids.get(0), () -> guids.get(1));    Mockito.verify(logger.getLogger()).trace(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3506_0()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();    logger.trace(logString2, supplier, supplier);    Mockito.verify(supplier, never()).get();    logger.trace(marker, logString2, supplier, supplier);    Mockito.verify(supplier, never()).get();}
public void metron_f3507_0()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getTraceEnabledLogger();    logger.trace(logString3, guids.get(0), guids.get(1), guids.get(2));    Mockito.verify(logger.getLogger()).trace(logString3, guids.get(0), guids.get(1), guids.get(2));    logger.trace(marker, logString3, guids.get(0), guids.get(1), guids.get(2));    Mockito.verify(logger.getLogger()).trace(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3508_0()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getTraceEnabledLogger();    logger.trace(logString3, () -> guids.get(0), () -> guids.get(1), () -> guids.get(2));    Mockito.verify(logger.getLogger()).trace(logString3, guids.get(0), guids.get(1), guids.get(2));    logger.trace(marker, logString3, () -> guids.get(0), () -> guids.get(1), () -> guids.get(2));    Mockito.verify(logger.getLogger()).trace(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3509_0()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();    logger.trace(logString3, supplier, supplier, supplier);    Mockito.verify(supplier, never()).get();    logger.trace(marker, logString3, supplier, supplier, supplier);    Mockito.verify(supplier, never()).get();}
public void metron_f3510_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getDebugEnabledLogger();    logger.isDebugEnabled();    Mockito.verify(logger.getLogger()).isDebugEnabled();    logger.isDebugEnabled(marker);    Mockito.verify(logger.getLogger()).isDebugEnabled(marker);        Mockito.verify(logger.getLogger()).debug(logString0);        Mockito.verify(logger.getLogger()).debug(logString0, exception);        Mockito.verify(logger.getLogger()).debug(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).debug(marker, logString0);        Mockito.verify(logger.getLogger()).debug(marker, logString0, exception);        Mockito.verify(logger.getLogger()).debug(marker, logString1, guids.get(0));}
public void metron_f3511_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getDebugEnabledLogger();        Mockito.verify(logger.getLogger()).debug(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).debug(marker, logString1, guids.get(0));}
public void metron_f3512_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3513_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getDebugEnabledLogger();        Mockito.verify(logger.getLogger()).debug(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).debug(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3514_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getDebugEnabledLogger();        Mockito.verify(logger.getLogger()).debug(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).debug(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3515_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3516_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getDebugEnabledLogger();        Mockito.verify(logger.getLogger()).debug(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).debug(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3517_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getDebugEnabledLogger();        Mockito.verify(logger.getLogger()).debug(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).debug(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3518_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3519_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getInfoEnabledLogger();        Mockito.verify(logger.getLogger()).info(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).info(marker, logString1, guids.get(0));}
public void metron_f3520_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getInfoEnabledLogger();    logger.isInfoEnabled();    Mockito.verify(logger.getLogger()).isInfoEnabled();    logger.isInfoEnabled(marker);    Mockito.verify(logger.getLogger()).isInfoEnabled(marker);        Mockito.verify(logger.getLogger()).info(logString0);        Mockito.verify(logger.getLogger()).info(logString0, exception);        Mockito.verify(logger.getLogger()).info(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).info(marker, logString0);        Mockito.verify(logger.getLogger()).info(marker, logString0, exception);        Mockito.verify(logger.getLogger()).info(marker, logString1, guids.get(0));}
public void metron_f3521_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3522_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getInfoEnabledLogger();        Mockito.verify(logger.getLogger()).info(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).info(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3523_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getInfoEnabledLogger();        Mockito.verify(logger.getLogger()).info(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).info(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3524_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3525_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getInfoEnabledLogger();        Mockito.verify(logger.getLogger()).info(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).info(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3526_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getInfoEnabledLogger();        Mockito.verify(logger.getLogger()).info(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).info(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3527_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3528_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getWarnEnabledLogger();        Mockito.verify(logger.getLogger()).warn(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).warn(marker, logString1, guids.get(0));}
public void metron_f3529_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getWarnEnabledLogger();    logger.isWarnEnabled();    Mockito.verify(logger.getLogger()).isWarnEnabled();    logger.isWarnEnabled(marker);    Mockito.verify(logger.getLogger()).isWarnEnabled(marker);        Mockito.verify(logger.getLogger()).warn(logString0);        Mockito.verify(logger.getLogger()).warn(logString0, exception);        Mockito.verify(logger.getLogger()).warn(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).warn(marker, logString0);        Mockito.verify(logger.getLogger()).warn(marker, logString0, exception);        Mockito.verify(logger.getLogger()).warn(marker, logString1, guids.get(0));}
public void metron_f3530_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3531_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getWarnEnabledLogger();        Mockito.verify(logger.getLogger()).warn(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).warn(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3532_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getWarnEnabledLogger();        Mockito.verify(logger.getLogger()).warn(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).warn(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3533_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3534_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getWarnEnabledLogger();        Mockito.verify(logger.getLogger()).warn(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).warn(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3535_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getWarnEnabledLogger();        Mockito.verify(logger.getLogger()).warn(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).warn(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3536_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3537_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getErrorEnabledLogger();        Mockito.verify(logger.getLogger()).error(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).error(marker, logString1, guids.get(0));}
public void metron_f3538_1()
{    final List<UUID> guids = getGuids(1);    final LazyLogger logger = getErrorEnabledLogger();    logger.isErrorEnabled();    Mockito.verify(logger.getLogger()).isErrorEnabled();    logger.isErrorEnabled(marker);    Mockito.verify(logger.getLogger()).isErrorEnabled(marker);        Mockito.verify(logger.getLogger()).error(logString0);        Mockito.verify(logger.getLogger()).error(logString0, exception);        Mockito.verify(logger.getLogger()).error(logString1, guids.get(0));        Mockito.verify(logger.getLogger()).error(marker, logString0);        Mockito.verify(logger.getLogger()).error(marker, logString0, exception);        Mockito.verify(logger.getLogger()).error(marker, logString1, guids.get(0));}
public void metron_f3539_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3540_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getErrorEnabledLogger();        Mockito.verify(logger.getLogger()).error(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).error(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3541_1()
{    final List<UUID> guids = getGuids(2);    final LazyLogger logger = getErrorEnabledLogger();        Mockito.verify(logger.getLogger()).error(logString2, guids.get(0), guids.get(1));        Mockito.verify(logger.getLogger()).error(marker, logString2, guids.get(0), guids.get(1));}
public void metron_f3542_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3543_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getErrorEnabledLogger();        Mockito.verify(logger.getLogger()).error(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).error(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3544_1()
{    final List<UUID> guids = getGuids(3);    final LazyLogger logger = getErrorEnabledLogger();        Mockito.verify(logger.getLogger()).error(logString3, guids.get(0), guids.get(1), guids.get(2));        Mockito.verify(logger.getLogger()).error(marker, logString3, guids.get(0), guids.get(1), guids.get(2));}
public void metron_f3545_1()
{    final Supplier<Object> supplier = getMockedSupplier();    final LazyLogger logger = getDisabledLogger();        Mockito.verify(supplier, never()).get();        Mockito.verify(supplier, never()).get();}
public void metron_f3546_0()
{    Map<String, Object> smallMap = new HashMap<>();    for (int i = 0; i < 10; i++) {        smallMap.put("key" + i, RandomStringUtils.randomAlphabetic(10));    }    Map<String, Object> largeMap = new HashMap<>();    for (int i = 0; i < 500; i++) {        largeMap.put("key" + i, RandomStringUtils.randomAlphabetic(1000));    }    JSONObject largeObject = new JSONObject(largeMap);    JSONObject smallObject = new JSONObject(smallMap);    int reps = 1000;    StatisticalSummary summary = runTrial(reps, () -> {        LOG.trace("Writing message {} to path: {}", smallObject.toJSONString(), PATH);    });    printSummary(String.format("Small object %s times", reps), summary);    summary = runTrial(reps, () -> {        LOG.trace("Writing message {} to path: {}", () -> smallObject.toJSONString(), () -> PATH);    });    printSummary(String.format("Small object %s times using lazy logging", reps), summary);    summary = runTrial(reps, () -> {        LOG.trace("Writing message {} to path: {}", largeObject.toJSONString(), PATH);    });    printSummary(String.format("Large object %s times", reps), summary);    summary = runTrial(reps, () -> {        LOG.trace("Writing message {} to path: {}", () -> largeObject.toJSONString(), () -> PATH);    });    printSummary(String.format("Large object %s times using lazy logging", reps), summary);    summary = runTrial(reps, () -> {        LOG.trace("Writing message {} to path: {}", "hello", PATH);    });    printSummary(String.format("Simple string %s times", reps), summary);    summary = runTrial(reps, () -> {        LOG.trace("Writing message {} to path: {}", () -> "hello", () -> PATH);    });    printSummary(String.format("Simple string %s times using lazy logging", reps), summary);}
private StatisticalSummary metron_f3547_0(int reps, Operation operation)
{    DescriptiveStatistics stats = new DescriptiveStatistics();    long trialTime = timeOperation(() -> {        for (int i = 0; i < reps; i++) {            long time = timeOperation(operation);            stats.addValue(time / NANO_TO_MILLIS);        }    });    System.out.println("Total trial time (ms): " + (trialTime / NANO_TO_MILLIS));    return stats;}
private long metron_f3548_0(Operation o)
{    final long start = System.nanoTime();    o.run();    final long finish = System.nanoTime();    return finish - start;}
private void metron_f3549_0(String desc, StatisticalSummary summary)
{    final String border = "===============================";    System.out.println(border);    System.out.println(desc);    System.out.println(summary.toString());    System.out.println(border);}
public void metron_f3550_0() throws Exception
{    exception.expect(IllegalArgumentException.class);    exception.expectMessage("illegal arg happened");    exception.expectCause(nullValue(Throwable.class));    RuntimeErrors.ILLEGAL_ARG.throwRuntime("illegal arg happened");}
public void metron_f3551_0() throws Exception
{    exception.expect(IllegalArgumentException.class);    exception.expectMessage("illegal arg happened");    exception.expectCause(instanceOf(IOException.class));    RuntimeErrors.ILLEGAL_ARG.throwRuntime("illegal arg happened", new IOException("bad io"));}
public void metron_f3552_0() throws Exception
{    exception.expect(IllegalStateException.class);    exception.expectMessage("illegal state happened");    exception.expectCause(nullValue(Throwable.class));    RuntimeErrors.ILLEGAL_STATE.throwRuntime("illegal state happened");}
public void metron_f3553_0() throws Exception
{    exception.expect(IllegalStateException.class);    exception.expectMessage("illegal state happened");    exception.expectCause(instanceOf(IOException.class));    RuntimeErrors.ILLEGAL_STATE.throwRuntime("illegal state happened", new IOException("bad io"));}
public void metron_f3554_0()
{    final int expected = 2;    byte[] raw = SerDeUtils.toBytes(expected);    int actual = SerDeUtils.fromBytes(raw, Integer.class);    assertEquals(expected, actual);}
public void metron_f3555_0()
{    final double expected = 2.0;    byte[] raw = SerDeUtils.toBytes(expected);    {        double actual = SerDeUtils.fromBytes(raw, Double.class);        assertEquals(expected, actual, 0.01);    }    {        double actual = (double) SerDeUtils.fromBytes(raw, Object.class);        assertEquals(expected, actual, 0.01);    }}
public void metron_f3556_0()
{    final short expected = 2;    byte[] raw = SerDeUtils.toBytes(expected);    {        short actual = SerDeUtils.fromBytes(raw, Short.class);        assertEquals(expected, actual);    }    {        short actual = (short) SerDeUtils.fromBytes(raw, Object.class);        assertEquals(expected, actual);    }}
public void metron_f3557_0()
{    final long expected = 2L;    byte[] raw = SerDeUtils.toBytes(expected);    {        long actual = SerDeUtils.fromBytes(raw, Long.class);        assertEquals(expected, actual);    }    {        long actual = (Long) SerDeUtils.fromBytes(raw, Object.class);        assertEquals(expected, actual);    }}
public void metron_f3558_0()
{    final Float expected = 2.2F;    byte[] raw = SerDeUtils.toBytes(expected);    {        float actual = SerDeUtils.fromBytes(raw, Float.class);        assertEquals(expected, actual, 0.01);    }    {        float actual = (float) SerDeUtils.fromBytes(raw, Object.class);        assertEquals(expected, actual, 0.01);    }}
public void metron_f3559_0()
{    final Map<String, Object> expected = new HashMap<>();    expected.put("foo", "bar");    expected.put("bar", 1.0);    ;    byte[] raw = SerDeUtils.toBytes(expected);    Object actual = SerDeUtils.fromBytes(raw, Object.class);    assertEquals(expected, actual);}
public void metron_f3560_0()
{    final List<String> expected = new ArrayList<String>();    expected.add("foo");    expected.add("bar");    byte[] raw = SerDeUtils.toBytes(expected);    Object actual = SerDeUtils.fromBytes(raw, Object.class);    assertEquals(expected, actual);}
public void metron_f3561_0()
{    final BloomFilter<Object> expected = new BloomFilter<>(new BloomFilter.DefaultSerializer<>(), 10000, 0.01);    expected.add("foo");    expected.add("bar");    byte[] raw = SerDeUtils.toBytes(expected);    BloomFilter<Object> actual = (BloomFilter) SerDeUtils.fromBytes(raw, Object.class);    Assert.assertTrue(actual.mightContain("foo"));    Assert.assertFalse(actual.mightContain("timothy"));    assertEquals(expected, actual);}
public List<String> metron_f3562_0()
{    return list;}
public void metron_f3563_0(List<String> list)
{    this.list = list;}
public String metron_f3564_0()
{    return string;}
public void metron_f3565_0(String string)
{    this.string = string;}
public Double metron_f3566_0()
{    return d;}
public void metron_f3567_0(Double d)
{    this.d = d;}
public Map<String, String> metron_f3568_0()
{    return map;}
public void metron_f3569_0(Map<String, String> map)
{    this.map = map;}
public boolean metron_f3570_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ArbitraryPojo that = (ArbitraryPojo) o;    if (getList() != null ? !getList().equals(that.getList()) : that.getList() != null)        return false;    if (getString() != null ? !getString().equals(that.getString()) : that.getString() != null)        return false;    if (getD() != null ? !getD().equals(that.getD()) : that.getD() != null)        return false;    if (getMap() != null ? !getMap().equals(that.getMap()) : that.getMap() != null)        return false;    return immutableList != null ? immutableList.equals(that.immutableList) : that.immutableList == null;}
public int metron_f3571_0()
{    int result = getList() != null ? getList().hashCode() : 0;    result = 31 * result + (getString() != null ? getString().hashCode() : 0);    result = 31 * result + (getD() != null ? getD().hashCode() : 0);    result = 31 * result + (getMap() != null ? getMap().hashCode() : 0);    result = 31 * result + (immutableList != null ? immutableList.hashCode() : 0);    return result;}
public void metron_f3572_0()
{    final ArbitraryPojo expected = new ArbitraryPojo();    byte[] raw = SerDeUtils.toBytes(expected);    Object actual = SerDeUtils.fromBytes(raw, Object.class);    assertEquals(expected, actual);}
public void metron_f3573_0() throws Exception
{    zkComponent = new ZKServerComponent();    zkComponent.start();    client = ConfigurationsUtils.getClient(zkComponent.getConnectionString());    client.start();    cache = new ZKConfigurationsCache(client);    cache.start();    {                byte[] config = IOUtils.toByteArray(new FileInputStream(new File(TestConstants.PARSER_CONFIGS_PATH + "/parsers/bro.json")));        ConfigurationsUtils.writeSensorParserConfigToZookeeper("bro", config, client);    }    {                byte[] config = IOUtils.toByteArray(new FileInputStream(new File(TestConstants.SAMPLE_CONFIG_PATH + "/indexing/test.json")));        ConfigurationsUtils.writeSensorIndexingConfigToZookeeper("test", config, client);    }    {                byte[] config = IOUtils.toByteArray(new FileInputStream(new File(TestConstants.SAMPLE_CONFIG_PATH + "/enrichments/test.json")));        ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper("test", config, client);    }    {                byte[] config = IOUtils.toByteArray(new FileInputStream(new File(TestConstants.SAMPLE_CONFIG_PATH + "/enrichments/test.json")));        ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper("test", config, client);    }    {                byte[] config = IOUtils.toByteArray(new FileInputStream(new File("src/test/resources/profiler/profiler.json")));        ConfigurationsUtils.writeProfilerConfigToZookeeper(config, client);    }    {                byte[] config = IOUtils.toByteArray(new FileInputStream(new File(TestConstants.SAMPLE_CONFIG_PATH + "/global.json")));        ConfigurationsUtils.writeGlobalConfigToZookeeper(config, client);    }}
public void metron_f3574_0() throws Exception
{    if (cache != null) {        cache.close();    }    if (client != null) {        client.close();    }    if (zkComponent != null) {        zkComponent.stop();    }}
public void metron_f3575_0() throws Exception
{    client.delete().forPath(ConfigurationType.GLOBAL.getZookeeperRoot());    client.delete().forPath(ConfigurationType.INDEXING.getZookeeperRoot() + "/test");    client.delete().forPath(ConfigurationType.ENRICHMENT.getZookeeperRoot() + "/test");    client.delete().forPath(ConfigurationType.PARSER.getZookeeperRoot() + "/bro");    client.delete().forPath(ConfigurationType.PROFILER.getZookeeperRoot());        {        IndexingConfigurations config = cache.get(IndexingConfigurations.class);        assertEventually(() -> Assert.assertNull(config.getGlobalConfig(false)));    }        {        IndexingConfigurations config = cache.get(IndexingConfigurations.class);        assertEventually(() -> Assert.assertNull(config.getSensorIndexingConfig("test", false)));        assertEventually(() -> Assert.assertNull(config.getGlobalConfig(false)));    }        {        EnrichmentConfigurations config = cache.get(EnrichmentConfigurations.class);        assertEventually(() -> Assert.assertNull(config.getSensorEnrichmentConfig("test")));        assertEventually(() -> Assert.assertNull(config.getGlobalConfig(false)));    }        {        ParserConfigurations config = cache.get(ParserConfigurations.class);        assertEventually(() -> Assert.assertNull(config.getSensorParserConfig("bro")));        assertEventually(() -> Assert.assertNull(config.getGlobalConfig(false)));    }        {        ProfilerConfigurations config = cache.get(ProfilerConfigurations.class);        assertEventually(() -> Assert.assertNull(config.getProfilerConfig()));        assertEventually(() -> Assert.assertNull(config.getGlobalConfig(false)));    }}
public void metron_f3576_0() throws Exception
{    ConfigurationsUtils.writeSensorIndexingConfigToZookeeper("test", testIndexingConfig.getBytes(StandardCharsets.UTF_8), client);    ConfigurationsUtils.writeGlobalConfigToZookeeper(globalConfig.getBytes(StandardCharsets.UTF_8), client);    ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper("test", testEnrichmentConfig.getBytes(StandardCharsets.UTF_8), client);    ConfigurationsUtils.writeSensorParserConfigToZookeeper("bro", testParserConfig.getBytes(StandardCharsets.UTF_8), client);    ConfigurationsUtils.writeProfilerConfigToZookeeper(profilerConfig.getBytes(StandardCharsets.UTF_8), client);        {        Map<String, Object> expectedConfig = JSONUtils.INSTANCE.load(testIndexingConfig, JSONUtils.MAP_SUPPLIER);        IndexingConfigurations config = cache.get(IndexingConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getSensorIndexingConfig("test")));    }        {        SensorEnrichmentConfig expectedConfig = JSONUtils.INSTANCE.load(testEnrichmentConfig, SensorEnrichmentConfig.class);        Map<String, Object> expectedGlobalConfig = JSONUtils.INSTANCE.load(globalConfig, JSONUtils.MAP_SUPPLIER);        EnrichmentConfigurations config = cache.get(EnrichmentConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getSensorEnrichmentConfig("test")));        assertEventually(() -> Assert.assertEquals(expectedGlobalConfig, config.getGlobalConfig()));    }        {        SensorParserConfig expectedConfig = JSONUtils.INSTANCE.load(testParserConfig, SensorParserConfig.class);        ParserConfigurations config = cache.get(ParserConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getSensorParserConfig("bro")));    }        {        ProfilerConfig expectedConfig = JSONUtils.INSTANCE.load(profilerConfig, ProfilerConfig.class);        ProfilerConfigurations config = cache.get(ProfilerConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getProfilerConfig()));    }}
public void metron_f3577_0() throws Exception
{    File globalConfigFile = new File(TestConstants.SAMPLE_CONFIG_PATH + "/global.json");    Map<String, Object> expectedGlobalConfig = JSONUtils.INSTANCE.load(globalConfigFile, JSONUtils.MAP_SUPPLIER);        {        File inFile = new File(TestConstants.SAMPLE_CONFIG_PATH + "/indexing/test.json");        Map<String, Object> expectedConfig = JSONUtils.INSTANCE.load(inFile, JSONUtils.MAP_SUPPLIER);        IndexingConfigurations config = cache.get(IndexingConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getSensorIndexingConfig("test")));        assertEventually(() -> Assert.assertEquals(expectedGlobalConfig, config.getGlobalConfig()));        assertEventually(() -> Assert.assertNull(config.getSensorIndexingConfig("notthere", false)));    }        {        File inFile = new File(TestConstants.SAMPLE_CONFIG_PATH + "/enrichments/test.json");        SensorEnrichmentConfig expectedConfig = JSONUtils.INSTANCE.load(inFile, SensorEnrichmentConfig.class);        EnrichmentConfigurations config = cache.get(EnrichmentConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getSensorEnrichmentConfig("test")));        assertEventually(() -> Assert.assertEquals(expectedGlobalConfig, config.getGlobalConfig()));        assertEventually(() -> Assert.assertNull(config.getSensorEnrichmentConfig("notthere")));    }        {        File inFile = new File(TestConstants.PARSER_CONFIGS_PATH + "/parsers/bro.json");        SensorParserConfig expectedConfig = JSONUtils.INSTANCE.load(inFile, SensorParserConfig.class);        ParserConfigurations config = cache.get(ParserConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getSensorParserConfig("bro")));        assertEventually(() -> Assert.assertEquals(expectedGlobalConfig, config.getGlobalConfig()));        assertEventually(() -> Assert.assertNull(config.getSensorParserConfig("notthere")));    }        {        File inFile = new File("src/test/resources/profiler/profiler.json");        ProfilerConfig expectedConfig = JSONUtils.INSTANCE.load(inFile, ProfilerConfig.class);        ProfilerConfigurations config = cache.get(ProfilerConfigurations.class);        assertEventually(() -> Assert.assertEquals(expectedConfig, config.getProfilerConfig()));        assertEventually(() -> Assert.assertEquals(expectedGlobalConfig, config.getGlobalConfig()));    }}
public ConfigUploadComponent metron_f3578_0(String connectionString)
{    this.connectionString = connectionString;    return this;}
public ConfigUploadComponent metron_f3579_0(Properties topologyProperties)
{    this.topologyProperties = topologyProperties;    return this;}
public ConfigUploadComponent metron_f3580_0(String globalConfigPath)
{    this.globalConfigPath = globalConfigPath;    return this;}
public ConfigUploadComponent metron_f3581_0(String parserConfigsPath)
{    this.parserConfigsPath = parserConfigsPath;    return this;}
public ConfigUploadComponent metron_f3582_0(String enrichmentConfigsPath)
{    this.enrichmentConfigsPath = enrichmentConfigsPath;    return this;}
public ConfigUploadComponent metron_f3583_0(String indexingConfigsPath)
{    this.indexingConfigsPath = indexingConfigsPath;    return this;}
public ConfigUploadComponent metron_f3584_0(String profilerConfigsPath)
{    this.profilerConfigPath = profilerConfigsPath;    return this;}
public ConfigUploadComponent metron_f3585_0(String name, SensorParserConfig config)
{    parserSensorConfigs.put(name, config);    return this;}
public ConfigUploadComponent metron_f3586_0(String globalConfig)
{    this.globalConfig = Optional.ofNullable(globalConfig);    return this;}
public ConfigUploadComponent metron_f3587_0(Consumer<ConfigUploadComponent> f)
{    this.postStartCallback = Optional.ofNullable(f);    return this;}
public Properties metron_f3588_0()
{    return topologyProperties;}
public String metron_f3589_0()
{    return globalConfigPath;}
public String metron_f3590_0()
{    return parserConfigsPath;}
public String metron_f3591_0()
{    return enrichmentConfigsPath;}
public String metron_f3592_0()
{    return indexingConfigsPath;}
public String metron_f3593_0()
{    return profilerConfigPath;}
public Optional<Consumer<ConfigUploadComponent>> metron_f3594_0()
{    return postStartCallback;}
public Optional<String> metron_f3595_0()
{    return globalConfig;}
public Map<String, SensorParserConfig> metron_f3596_0()
{    return parserSensorConfigs;}
public void metron_f3597_0() throws UnableToStartException
{    update();}
public void metron_f3598_0() throws UnableToStartException
{    try {        final String zookeeperUrl = connectionString == null ? topologyProperties.getProperty(ZKServerComponent.ZOOKEEPER_PROPERTY) : connectionString;        if (globalConfigPath != null || parserConfigsPath != null || enrichmentConfigsPath != null || indexingConfigsPath != null || profilerConfigPath != null) {            uploadConfigsToZookeeper(globalConfigPath, parserConfigsPath, enrichmentConfigsPath, indexingConfigsPath, profilerConfigPath, zookeeperUrl);        }        for (Map.Entry<String, SensorParserConfig> kv : parserSensorConfigs.entrySet()) {            writeSensorParserConfigToZookeeper(kv.getKey(), kv.getValue(), zookeeperUrl);        }        if (globalConfig.isPresent()) {            writeGlobalConfigToZookeeper(globalConfig.get().getBytes(StandardCharsets.UTF_8), zookeeperUrl);        }        if (postStartCallback.isPresent()) {            postStartCallback.get().accept(this);        }    } catch (Exception e) {        throw new UnableToStartException(e.getMessage(), e);    }}
public SensorParserConfig metron_f3599_0(String sensorType)
{    SensorParserConfig sensorParserConfig = new SensorParserConfig();    CuratorFramework client = getClient(topologyProperties.getProperty(ZKServerComponent.ZOOKEEPER_PROPERTY));    client.start();    try {        sensorParserConfig = readSensorParserConfigFromZookeeper(sensorType, client);    } catch (Exception e) {        e.printStackTrace();    } finally {        client.close();    }    return sensorParserConfig;}
public void metron_f3601_0(CuratorFramework client)
{    this.client = client;}
public void metron_f3602_0(ZKCache cache)
{    this.cache = cache;}
public CONFIG_T metron_f3604_0()
{    return configurations;}
protected ConfigurationStrategy<CONFIG_T> metron_f3605_0()
{    return ConfigurationsStrategies.valueOf(configurationStrategy);}
protected ConfigurationsUpdater<CONFIG_T> metron_f3606_0()
{    return getConfigurationStrategy().createUpdater(this, this::getConfigurations);}
public void metron_f3607_0(Map stormConf, TopologyContext context, OutputCollector collector)
{    prepCache();}
protected void metron_f3608_1()
{    try {        if (client == null) {            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);            client = CuratorFrameworkFactory.newClient(zookeeperUrl, retryPolicy);        }        client.start();                                ConfigurationsUtils.setupStellarStatically(client);        if (cache == null) {            ConfigurationsUpdater<CONFIG_T> updater = createUpdater();            SimpleEventListener listener = new SimpleEventListener.Builder().with(updater::update, TreeCacheEvent.Type.NODE_ADDED, TreeCacheEvent.Type.NODE_UPDATED).with(updater::delete, TreeCacheEvent.Type.NODE_REMOVED).build();            cache = new ZKCache.Builder().withClient(client).withListener(listener).withRoot(Constants.ZOOKEEPER_TOPOLOGY_ROOT).build();            updater.forceUpdate(client);            cache.start();        }    } catch (Exception e) {                throw new RuntimeException(e);    }}
public void metron_f3609_0()
{    cache.close();    client.close();}
public void metron_f3610_1()
{            super.cleanup();    try {        StellarFunctions.close();    } catch (IOException e) {            }}
protected SensorParserConfig metron_f3611_0(String sensorType)
{    return getConfigurations().getSensorParserConfig(sensorType);}
public void metron_f3612_1()
{            super.cleanup();    try {        StellarFunctions.close();    } catch (IOException e) {            }}
protected ProfilerConfig metron_f3613_0()
{    return getConfigurations().getProfilerConfig();}
public byte[] metron_f3614_0(Tuple tuple)
{    return tuple.getBinary(position);}
public JSONObject metron_f3615_0(Tuple tuple)
{    return (JSONObject) ((JSONObject) tuple.getValueByField(fieldValue)).clone();}
public JSONObject metron_f3616_0(Tuple tuple)
{    return (JSONObject) tuple.getValueByField(messageFieldName);}
protected JSONParser metron_f3617_0()
{    return new JSONParser();}
public JSONObject metron_f3618_0(Tuple tuple)
{    String s = null;    try {        s = new String(tuple.getBinary(position), Charsets.UTF_8);        return (JSONObject) parser.get().parse(s);    } catch (Exception e) {        throw new IllegalStateException("Unable to parse " + s + " due to " + e.getMessage(), e);    }}
public MessageGetStrategy metron_f3619_0(String arg)
{    return messageGetStrategyFunction.apply(arg);}
public MessageGetStrategy metron_f3620_0()
{    return messageGetStrategy;}
public RawMessage metron_f3621_0(RawMessageStrategy strategy, Tuple t, byte[] rawMessage, boolean readMetadata, Map<String, Object> config)
{    Map<String, Object> metadata = new HashMap<>();    if (readMetadata) {        String prefix = MetadataUtil.INSTANCE.getMetadataPrefix(config);        metadata = extractMetadata(prefix, t);    }    return strategy.get(metadata, rawMessage, readMetadata, config);}
public Map<String, Object> metron_f3622_1(String prefix, Tuple t)
{    Map<String, Object> metadata = new HashMap<>();    if (t == null) {        return metadata;    }    Fields tupleFields = t.getFields();    if (tupleFields == null) {        return metadata;    }    for (int i = 2; i < tupleFields.size(); ++i) {        String envMetadataFieldName = tupleFields.get(i);        Object envMetadataFieldValue = t.getValue(i);        if (!StringUtils.isEmpty(envMetadataFieldName) && envMetadataFieldValue != null) {            metadata.put(MetadataUtil.INSTANCE.prefixKey(prefix, envMetadataFieldName), envMetadataFieldValue);        }    }    byte[] keyObj = t.getBinary(KEY_INDEX);    String keyStr = null;    try {        keyStr = keyObj == null ? null : new String(keyObj, StandardCharsets.UTF_8);        if (!StringUtils.isEmpty(keyStr)) {            Map<String, Object> rawMetadata = JSONUtils.INSTANCE.load(keyStr, JSONUtils.MAP_SUPPLIER);            for (Map.Entry<String, Object> kv : rawMetadata.entrySet()) {                metadata.put(MetadataUtil.INSTANCE.prefixKey(prefix, kv.getKey()), kv.getValue());            }        }    } catch (IOException e) {        String reason = "Unable to parse metadata; expected JSON Map: " + (keyStr == null ? "NON-STRING!" : keyStr);                throw new IllegalStateException(reason, e);    }    return metadata;}
public Object metron_f3623_0(Tuple tuple)
{    return tuple.getValueByField(fieldValue);}
public static void metron_f3624_0(OutputCollector collector, MetronError error)
{    collector.emit(Constants.ERROR_STREAM, new Values(error.getJSONObject()));    Optional<Throwable> throwable = error.getThrowable();    if (throwable.isPresent()) {        collector.reportError(throwable.get());    }}
protected void metron_f3625_0(final String expectedConfigUpdate)
{    waitForConfigUpdate(new HashSet<String>() {        {            add(expectedConfigUpdate);        }    });}
protected void metron_f3626_0(Set<String> expectedConfigUpdates)
{    int count = 0;    while (!configsUpdated.equals(expectedConfigUpdates)) {        if (count++ > 5) {            Assert.fail("ConfiguredBolt was not updated in time");            return;        }        try {            Thread.sleep(500);        } catch (InterruptedException e) {            e.printStackTrace();        }    }}
public void metron_f3629_0(String name, ConfigurationType type)
{    configsUpdated.add(name);}
public void metron_f3630_0() throws Exception
{    TestingServer testZkServer = new TestingServer(true);    this.zookeeperUrl = testZkServer.getConnectString();    byte[] globalConfig = ConfigurationsUtils.readGlobalConfigFromFile(sampleConfigPath);    ConfigurationsUtils.writeGlobalConfigToZookeeper(globalConfig, zookeeperUrl);    enrichmentConfigurationTypes.add(ConfigurationType.GLOBAL.getTypeName());    Map<String, byte[]> sensorEnrichmentConfigs = ConfigurationsUtils.readSensorEnrichmentConfigsFromFile(enrichmentsConfigPath);    for (String sensorType : sensorEnrichmentConfigs.keySet()) {        ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(sensorType, sensorEnrichmentConfigs.get(sensorType), zookeeperUrl);        enrichmentConfigurationTypes.add(sensorType);    }    Map<String, byte[]> sensorParserConfigs = ConfigurationsUtils.readSensorParserConfigsFromFile(parserConfigsPath);    for (String sensorType : sensorParserConfigs.keySet()) {        ConfigurationsUtils.writeSensorParserConfigToZookeeper(sensorType, sensorParserConfigs.get(sensorType), zookeeperUrl);    }}
public void metron_f3631_0() throws Exception
{    EnrichmentConfigurations sampleConfigurations = new EnrichmentConfigurations();    UnitTestHelper.setLog4jLevel(ConfiguredBolt.class, Level.FATAL);    try {        StandAloneConfiguredEnrichmentBolt configuredBolt = new StandAloneConfiguredEnrichmentBolt(null);        configuredBolt.prepare(new HashMap(), topologyContext, outputCollector);        Assert.fail("A valid zookeeper url must be supplied");    } catch (RuntimeException e) {    }    UnitTestHelper.setLog4jLevel(ConfiguredBolt.class, Level.ERROR);    configsUpdated = new HashSet<>();    sampleConfigurations.updateGlobalConfig(ConfigurationsUtils.readGlobalConfigFromFile(sampleConfigPath));    Map<String, byte[]> sensorEnrichmentConfigs = ConfigurationsUtils.readSensorEnrichmentConfigsFromFile(enrichmentsConfigPath);    for (String sensorType : sensorEnrichmentConfigs.keySet()) {        sampleConfigurations.updateSensorEnrichmentConfig(sensorType, sensorEnrichmentConfigs.get(sensorType));    }    StandAloneConfiguredEnrichmentBolt configuredBolt = new StandAloneConfiguredEnrichmentBolt(zookeeperUrl);    configuredBolt.prepare(new HashMap(), topologyContext, outputCollector);    waitForConfigUpdate(enrichmentConfigurationTypes);    Assert.assertEquals(sampleConfigurations, configuredBolt.getConfigurations());    configsUpdated = new HashSet<>();    Map<String, Object> sampleGlobalConfig = sampleConfigurations.getGlobalConfig();    sampleGlobalConfig.put("newGlobalField", "newGlobalValue");    ConfigurationsUtils.writeGlobalConfigToZookeeper(sampleGlobalConfig, zookeeperUrl);    waitForConfigUpdate(ConfigurationType.GLOBAL.getTypeName());    Assert.assertEquals("Add global config field", sampleConfigurations.getGlobalConfig(), configuredBolt.getConfigurations().getGlobalConfig());    configsUpdated = new HashSet<>();    sampleGlobalConfig.remove("newGlobalField");    ConfigurationsUtils.writeGlobalConfigToZookeeper(sampleGlobalConfig, zookeeperUrl);    waitForConfigUpdate(ConfigurationType.GLOBAL.getTypeName());    Assert.assertEquals("Remove global config field", sampleConfigurations, configuredBolt.getConfigurations());    configsUpdated = new HashSet<>();    String sensorType = "testSensorConfig";    SensorEnrichmentConfig testSensorConfig = new SensorEnrichmentConfig();    Map<String, Object> enrichmentFieldMap = new HashMap<>();    enrichmentFieldMap.put("enrichmentTest", new ArrayList<String>() {        {            add("enrichmentField");        }    });    testSensorConfig.getEnrichment().setFieldMap(enrichmentFieldMap);    Map<String, Object> threatIntelFieldMap = new HashMap<>();    threatIntelFieldMap.put("threatIntelTest", new ArrayList<String>() {        {            add("threatIntelField");        }    });    testSensorConfig.getThreatIntel().setFieldMap(threatIntelFieldMap);    sampleConfigurations.updateSensorEnrichmentConfig(sensorType, testSensorConfig);    ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(sensorType, testSensorConfig, zookeeperUrl);    waitForConfigUpdate(sensorType);    Assert.assertEquals("Add new sensor config", sampleConfigurations, configuredBolt.getConfigurations());    configuredBolt.cleanup();}
public void metron_f3634_0(String name, ConfigurationType type)
{    configsUpdated.add(name);}
public void metron_f3635_0() throws Exception
{    TestingServer testZkServer = new TestingServer(true);    this.zookeeperUrl = testZkServer.getConnectString();    byte[] globalConfig = ConfigurationsUtils.readGlobalConfigFromFile("../" + TestConstants.SAMPLE_CONFIG_PATH);    ConfigurationsUtils.writeGlobalConfigToZookeeper(globalConfig, zookeeperUrl);    parserConfigurationTypes.add(ConfigurationType.GLOBAL.getTypeName());    Map<String, byte[]> sensorEnrichmentConfigs = ConfigurationsUtils.readSensorEnrichmentConfigsFromFile("../" + TestConstants.ENRICHMENTS_CONFIGS_PATH);    for (String sensorType : sensorEnrichmentConfigs.keySet()) {        ConfigurationsUtils.writeSensorEnrichmentConfigToZookeeper(sensorType, sensorEnrichmentConfigs.get(sensorType), zookeeperUrl);    }    Map<String, byte[]> sensorParserConfigs = ConfigurationsUtils.readSensorParserConfigsFromFile("../" + TestConstants.PARSER_CONFIGS_PATH);    for (String sensorType : sensorParserConfigs.keySet()) {        ConfigurationsUtils.writeSensorParserConfigToZookeeper(sensorType, sensorParserConfigs.get(sensorType), zookeeperUrl);        parserConfigurationTypes.add(sensorType);    }}
public void metron_f3636_0() throws Exception
{    ParserConfigurations sampleConfigurations = new ParserConfigurations();    UnitTestHelper.setLog4jLevel(ConfiguredBolt.class, Level.FATAL);    try {        StandAloneConfiguredParserBolt configuredBolt = new StandAloneConfiguredParserBolt(null);        configuredBolt.prepare(new HashMap(), topologyContext, outputCollector);        Assert.fail("A valid zookeeper url must be supplied");    } catch (RuntimeException e) {    }    UnitTestHelper.setLog4jLevel(ConfiguredBolt.class, Level.ERROR);    configsUpdated = new HashSet<>();    sampleConfigurations.updateGlobalConfig(ConfigurationsUtils.readGlobalConfigFromFile("../" + TestConstants.SAMPLE_CONFIG_PATH));    Map<String, byte[]> sensorParserConfigs = ConfigurationsUtils.readSensorParserConfigsFromFile("../" + TestConstants.PARSER_CONFIGS_PATH);    for (String sensorType : sensorParserConfigs.keySet()) {        sampleConfigurations.updateSensorParserConfig(sensorType, sensorParserConfigs.get(sensorType));    }    StandAloneConfiguredParserBolt configuredBolt = new StandAloneConfiguredParserBolt(zookeeperUrl);    configuredBolt.prepare(new HashMap(), topologyContext, outputCollector);    waitForConfigUpdate(parserConfigurationTypes);    Assert.assertEquals(sampleConfigurations, configuredBolt.getConfigurations());    configsUpdated = new HashSet<>();    Map<String, Object> sampleGlobalConfig = sampleConfigurations.getGlobalConfig();    sampleGlobalConfig.put("newGlobalField", "newGlobalValue");    ConfigurationsUtils.writeGlobalConfigToZookeeper(sampleGlobalConfig, zookeeperUrl);    waitForConfigUpdate(ConfigurationType.GLOBAL.getTypeName());    Assert.assertEquals("Add global config field", sampleConfigurations.getGlobalConfig(), configuredBolt.getConfigurations().getGlobalConfig());    configsUpdated = new HashSet<>();    sampleGlobalConfig.remove("newGlobalField");    ConfigurationsUtils.writeGlobalConfigToZookeeper(sampleGlobalConfig, zookeeperUrl);    waitForConfigUpdate(ConfigurationType.GLOBAL.getTypeName());    Assert.assertEquals("Remove global config field", sampleConfigurations, configuredBolt.getConfigurations());    configsUpdated = new HashSet<>();    String sensorType = "testSensorConfig";    SensorParserConfig testSensorConfig = new SensorParserConfig();    testSensorConfig.setParserClassName("className");    testSensorConfig.setSensorTopic("sensorTopic");    testSensorConfig.setParserConfig(new HashMap<String, Object>() {        {            put("configName", "configObject");        }    });    sampleConfigurations.updateSensorParserConfig(sensorType, testSensorConfig);    ConfigurationsUtils.writeSensorParserConfigToZookeeper(sensorType, testSensorConfig, zookeeperUrl);    waitForConfigUpdate(sensorType);    ParserConfigurations configuredBoltConfigs = configuredBolt.getConfigurations();    if (!sampleConfigurations.equals(configuredBoltConfigs)) {                if (sampleConfigurations.getFieldValidations().size() != configuredBoltConfigs.getFieldValidations().size()) {            System.out.println("Field validations don't line up");        }        for (int i = 0; i < sampleConfigurations.getFieldValidations().size(); ++i) {            FieldValidator l = sampleConfigurations.getFieldValidations().get(i);            FieldValidator r = configuredBoltConfigs.getFieldValidations().get(i);            if (!l.equals(r)) {                System.out.println(l + " != " + r);            }        }        if (sampleConfigurations.getConfigurations().size() != configuredBoltConfigs.getConfigurations().size()) {            System.out.println("Configs don't line up");        }        for (Map.Entry<String, Object> kv : sampleConfigurations.getConfigurations().entrySet()) {            Object l = kv.getValue();            Object r = configuredBoltConfigs.getConfigurations().get(kv.getKey());            if (!l.equals(r)) {                System.out.println(kv.getKey() + " config does not line up: ");                System.out.println(l);                System.out.println(r);            }        }        Assert.assertEquals("Add new sensor config", sampleConfigurations, configuredBoltConfigs);    }    Assert.assertEquals("Add new sensor config", sampleConfigurations, configuredBoltConfigs);    configuredBolt.cleanup();}
public void metron_f3637_0()
{    Tuple tuple = mock(Tuple.class);    when(tuple.getBinary(1)).thenReturn("bytes".getBytes(UTF_8));    MessageGetStrategy messageGetStrategy = MessageGetters.BYTES_FROM_POSITION.get("1");    assertEquals("bytes", new String((byte[]) messageGetStrategy.get(tuple), UTF_8));}
public void metron_f3638_0()
{    Tuple tuple = mock(Tuple.class);    when(tuple.getBinary(1)).thenReturn("{\"field\":\"value\"}".getBytes(UTF_8));    JSONObject expected = new JSONObject();    expected.put("field", "value");    MessageGetStrategy messageGetStrategy = MessageGetters.JSON_FROM_POSITION.get("1");    assertEquals(expected, messageGetStrategy.get(tuple));}
public void metron_f3639_0()
{    exception.expect(IllegalStateException.class);    Tuple tuple = mock(Tuple.class);    when(tuple.getBinary(1)).thenReturn("{\"field\":".getBytes(UTF_8));    MessageGetStrategy messageGetStrategy = MessageGetters.JSON_FROM_POSITION.get("1");    messageGetStrategy.get(tuple);}
public void metron_f3640_0()
{    JSONObject actual = new JSONObject();    actual.put("field", "value");    Tuple tuple = mock(Tuple.class);    when(tuple.getValueByField("tuple_field")).thenReturn(actual);    JSONObject expected = new JSONObject();    expected.put("field", "value");    MessageGetStrategy messageGetStrategy = MessageGetters.JSON_FROM_FIELD.get("tuple_field");    assertEquals(expected, messageGetStrategy.get(tuple));}
public void metron_f3641_0()
{    Object actual = "object";    Tuple tuple = mock(Tuple.class);    when(tuple.getValueByField("tuple_field")).thenReturn(actual);    Object expected = "object";    MessageGetStrategy messageGetStrategy = MessageGetters.OBJECT_FROM_FIELD.get("tuple_field");    assertEquals(expected, messageGetStrategy.get(tuple));}
public void metron_f3642_0()
{    Tuple tuple = mock(Tuple.class);    when(tuple.getBinary(0)).thenReturn("bytes".getBytes(UTF_8));    MessageGetStrategy messageGetStrategy = MessageGetters.DEFAULT_BYTES_FROM_POSITION.get();    assertEquals("bytes", new String((byte[]) messageGetStrategy.get(tuple), UTF_8));}
public void metron_f3643_0()
{    Tuple tuple = mock(Tuple.class);    when(tuple.getBinary(0)).thenReturn("{\"field\":\"value\"}".getBytes(UTF_8));    JSONObject expected = new JSONObject();    expected.put("field", "value");    MessageGetStrategy messageGetStrategy = MessageGetters.DEFAULT_JSON_FROM_POSITION.get();    assertEquals(expected, messageGetStrategy.get(tuple));}
public void metron_f3644_0()
{    JSONObject actual = new JSONObject();    actual.put("field", "value");    Tuple tuple = mock(Tuple.class);    when(tuple.getValueByField("message")).thenReturn(actual);    JSONObject expected = new JSONObject();    expected.put("field", "value");    MessageGetStrategy messageGetStrategy = MessageGetters.DEFAULT_JSON_FROM_FIELD.get();    assertEquals(expected, messageGetStrategy.get(tuple));}
public void metron_f3645_0()
{    Object actual = "object";    Tuple tuple = mock(Tuple.class);    when(tuple.getValueByField("message")).thenReturn(actual);    Object expected = "object";    MessageGetStrategy messageGetStrategy = MessageGetters.DEFAULT_OBJECT_FROM_FIELD.get();    assertEquals(expected, messageGetStrategy.get(tuple));}
private static Tuple metron_f3646_0(Map<String, Object> kafkaFields, String metadata) throws Exception
{    List<Map.Entry<String, Object>> fields = new ArrayList<>();    for (Map.Entry<String, Object> kv : kafkaFields.entrySet()) {        fields.add(kv);    }    Tuple t = mock(Tuple.class);    Fields f = mock(Fields.class);    when(f.size()).thenReturn(fields.size() + 2);    for (int i = 0; i < fields.size(); ++i) {        when(f.get(eq(i + 2))).thenReturn(fields.get(i).getKey());        when(t.getValue(eq(i + 2))).thenReturn(fields.get(i).getValue());    }    when(t.getFields()).thenReturn(f);    when(t.getBinary(eq(RawMessageUtil.KEY_INDEX))).thenReturn(metadata.getBytes(StandardCharsets.UTF_8));    return t;}
private void metron_f3647_0(RawMessage m, boolean isEmpty)
{    if (!isEmpty) {        Assert.assertEquals("kafka_meta_1_val", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + ".kafka_meta_1"));        Assert.assertEquals("kafka_meta_2_val", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + ".kafka_meta_2"));    } else {        Assert.assertFalse(m.getMetadata().containsKey(MetadataUtil.METADATA_PREFIX + ".kafka_meta_1"));        Assert.assertFalse(m.getMetadata().containsKey(MetadataUtil.METADATA_PREFIX + ".kafka_meta_2"));    }}
private void metron_f3648_0(RawMessage m, boolean isEmpty)
{    if (!isEmpty) {        Assert.assertEquals("app_meta_1_val", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + ".app_meta_1"));        Assert.assertEquals("app_meta_2_val", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + ".app_meta_2"));    } else {        Assert.assertFalse(m.getMetadata().containsKey(MetadataUtil.METADATA_PREFIX + ".app_meta_1"));        Assert.assertFalse(m.getMetadata().containsKey(MetadataUtil.METADATA_PREFIX + ".app_meta_2"));    }}
public void metron_f3649_0() throws Exception
{    Tuple t = createTuple(kafkaMetadata, appMetadata);    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), true, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        checkKafkaMetadata(m, false);        checkAppMetadata(m, false);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), false, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3650_0() throws Exception
{    Tuple t = createTuple(kafkaMetadata, "{}");    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), true, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        checkKafkaMetadata(m, false);        checkAppMetadata(m, true);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), false, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3651_0() throws Exception
{    Tuple t = createTuple(new HashMap<>(), appMetadata);    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), true, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        checkKafkaMetadata(m, true);        checkAppMetadata(m, false);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), false, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3652_0() throws Exception
{    Tuple t = createTuple(new HashMap<>(), "{}");    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), true, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        checkKafkaMetadata(m, true);        checkAppMetadata(m, true);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.DEFAULT, t, "raw_message".getBytes(StandardCharsets.UTF_8), false, new HashMap<>());        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
private void metron_f3653_0(RawMessage m)
{    Assert.assertEquals("real_original_string", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + "." + Constants.Fields.ORIGINAL.getName()));    Assert.assertEquals("enveloped_metadata_val_1", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + ".enveloped_metadata_field_1"));    Assert.assertEquals("enveloped_metadata_val_2", m.getMetadata().get(MetadataUtil.METADATA_PREFIX + ".enveloped_metadata_field_2"));}
private void metron_f3654_0(RawMessage m)
{    JSONObject message = new JSONObject(envelopedMessage);    RawMessageStrategies.ENVELOPE.mergeMetadata(message, m.getMetadata(), true, new HashMap<String, Object>() {    });    if (m.getMetadata().containsKey(MetadataUtil.METADATA_PREFIX + "." + Constants.Fields.ORIGINAL.getName())) {        Assert.assertEquals(m.getMetadata().get(MetadataUtil.METADATA_PREFIX + "." + Constants.Fields.ORIGINAL.getName()), message.get(Constants.Fields.ORIGINAL.getName()));    }    Assert.assertEquals("message_val1", message.get("message_field1"));}
public void metron_f3655_0() throws Exception
{    Tuple t = createTuple(kafkaMetadata, appMetadata);    Map<String, Object> config = ImmutableMap.of(EnvelopedRawMessageStrategy.MESSAGE_FIELD_CONFIG, "data");    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), true, config);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkEnvelopeMetadata(m);        checkMergedData(m);        checkKafkaMetadata(m, false);        checkAppMetadata(m, false);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), false, config);        checkMergedData(m);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertFalse(m.getMetadata().containsKey("data"));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3656_0() throws Exception
{    Tuple t = createTuple(kafkaMetadata, "{}");    Map<String, Object> config = ImmutableMap.of(EnvelopedRawMessageStrategy.MESSAGE_FIELD_CONFIG, "data");    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), true, config);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkMergedData(m);        checkEnvelopeMetadata(m);        checkKafkaMetadata(m, false);        checkAppMetadata(m, true);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), false, config);        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkMergedData(m);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3657_0() throws Exception
{    Tuple t = createTuple(new HashMap<>(), appMetadata);    Map<String, Object> config = ImmutableMap.of(EnvelopedRawMessageStrategy.MESSAGE_FIELD_CONFIG, "data");    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), true, config);        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkMergedData(m);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        checkEnvelopeMetadata(m);        checkKafkaMetadata(m, true);        checkAppMetadata(m, false);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), false, config);        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkMergedData(m);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3658_0() throws Exception
{    Tuple t = createTuple(new HashMap<>(), "{}");    Map<String, Object> config = ImmutableMap.of(EnvelopedRawMessageStrategy.MESSAGE_FIELD_CONFIG, "data");    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), true, config);        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkMergedData(m);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        checkEnvelopeMetadata(m);        checkKafkaMetadata(m, true);        checkAppMetadata(m, true);    }    {        RawMessage m = RawMessageUtil.INSTANCE.getRawMessage(RawMessageStrategies.ENVELOPE, t, envelopedData.getBytes(StandardCharsets.UTF_8), false, config);        Assert.assertFalse(m.getMetadata().containsKey("data"));        checkMergedData(m);        Assert.assertEquals("raw_message", new String(m.getMessage(), StandardCharsets.UTF_8));        Assert.assertTrue(m.getMetadata().isEmpty());    }}
public void metron_f3659_0() throws Exception
{    Throwable e = new Exception("error");    MetronError error = new MetronError().withMessage("error message").withThrowable(e);    OutputCollector collector = mock(OutputCollector.class);    StormErrorUtils.handleError(collector, error);    verify(collector, times(1)).emit(eq(Constants.ERROR_STREAM), argThat(new MetronErrorJSONMatcher(error.getJSONObject())));    verify(collector, times(1)).reportError(any());}
protected Date metron_f3660_0(Date date)
{    Calendar calendar = Calendar.getInstance();    calendar.setTime(date);    calendar.set(Calendar.HOUR_OF_DAY, 0);    calendar.set(Calendar.MINUTE, 0);    calendar.set(Calendar.SECOND, 0);    calendar.set(Calendar.MILLISECOND, 0);    return calendar.getTime();}
public static void metron_f3661_1(String... argv) throws IOException, java.text.ParseException, ClassNotFoundException, InterruptedException
{    /**     * Example     * start=$(date -d '30 days ago' +%m/%d/%Y)     * yarn jar Metron-DataLoads-0.1BETA.jar org.apache.metron.dataloads.bulk.HDFSDataPruner -f hdfs://ec2-52-36-25-217.us-west-2.compute.amazonaws.com:8020 -g '/apps/metron/enrichment/indexed/bro_doc/*enrichment-*' -s $(date -d '30 days ago' +%m/%d/%Y) -n 1;     * echo ${start}     */    Options options = new Options();    Options help = new Options();    {        Option o = new Option("h", "help", false, "This screen");        o.setRequired(false);        help.addOption(o);    }    {        Option o = new Option("s", "start-date", true, "Starting Date (MM/DD/YYYY)");        o.setArgName("START_DATE");        o.setRequired(true);        options.addOption(o);    }    {        Option o = new Option("f", "filesystem", true, "Filesystem uri - e.g. hdfs://host:8020 or file:///");        o.setArgName("FILESYSTEM");        o.setRequired(true);        options.addOption(o);    }    {        Option o = new Option("n", "numdays", true, "Number of days back to purge");        o.setArgName("NUMDAYS");        o.setRequired(true);        options.addOption(o);    }    {        Option o = new Option("g", "glob-string", true, "Glob filemask for files to delete - e.g. /apps/metron/enrichment/bro_doc/file-*");        o.setArgName("GLOBSTRING");        o.setRequired(true);        options.addOption(o);    }    try {        CommandLineParser parser = new PosixParser();        CommandLine cmd = null;        try {            cmd = parser.parse(help, argv, true);            if (cmd.getOptions().length > 0) {                final HelpFormatter usageFormatter = new HelpFormatter();                usageFormatter.printHelp("HDFSDataPruner", null, options, null, true);                System.exit(0);            }            cmd = parser.parse(options, argv);        } catch (ParseException pe) {            final HelpFormatter usageFormatter = new HelpFormatter();            usageFormatter.printHelp("HDFSDataPruner", null, options, null, true);            System.exit(-1);        }        String start = cmd.getOptionValue("s");        Date startDate = new SimpleDateFormat("MM/dd/yyyy").parse(start);        String fileSystemUri = cmd.getOptionValue("f");        Integer numDays = Integer.parseInt(cmd.getOptionValue("n"));        String globString = cmd.getOptionValue("g");                DataPruner pruner = new HDFSDataPruner(startDate, numDays, fileSystemUri, globString);            } catch (Exception e) {        e.printStackTrace();        System.exit(-1);    }}
public Long metron_f3662_1() throws IOException
{    long filesPruned = 0L;    FileStatus[] filesToDelete = fileSystem.globStatus(globPath, new HDFSDataPruner.DateFileFilter(this));    for (FileStatus fileStatus : filesToDelete) {                fileSystem.delete(fileStatus.getPath(), false);        filesPruned++;    }    return filesPruned;}
public boolean metron_f3663_1(Path path)
{    try {                if (pruner.fileSystem.isDirectory(path)) {            return false;        }    } catch (IOException e) {                if (failOnError) {            throw new RuntimeException(e);        }        return false;    }    try {        FileStatus file = pruner.fileSystem.getFileStatus(path);        long fileModificationTime = file.getModificationTime();        boolean accept = false;        if (fileModificationTime >= pruner.firstTimeMillis && fileModificationTime < pruner.lastTimeMillis) {            accept = true;        }        return accept;    } catch (IOException e) {                if (failOnError) {            throw new RuntimeException(e);        }        return false;    }}
public boolean metron_f3664_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f3665_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
private static long metron_f3666_0(CommandLine cli) throws java.text.ParseException
{    Date d = getFormat(cli).parse(BulkLoadOptions.AS_OF_TIME.get(cli));    return d.getTime();}
private static DateFormat metron_f3667_0(CommandLine cli)
{    DateFormat format = new SimpleDateFormat();    if (BulkLoadOptions.AS_OF_TIME_FORMAT.has(cli)) {        format = new SimpleDateFormat(BulkLoadOptions.AS_OF_TIME_FORMAT.get(cli));    }    return format;}
public static CommandLine metron_f3668_0(CommandLineParser parser, String[] args)
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (BulkLoadOptions.HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        System.exit(-1);        return null;    }}
public static void metron_f3669_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("LeastRecentlyUsedPruner", getOptions());}
public static Options metron_f3670_0()
{    Options ret = new Options();    for (BulkLoadOptions o : BulkLoadOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public Option metron_f3671_0(@Nullable String s)
{    return new Option(s, "help", false, "Generate Help screen");}
public Option metron_f3672_0(@Nullable String s)
{    Option o = new Option(s, "table", true, "HBase table to prune");    o.setRequired(true);    o.setArgName("HBASE_TABLE");    return o;}
public Option metron_f3673_0(@Nullable String s)
{    Option o = new Option(s, "column_family", true, "Column family of the HBase table to prune");    o.setRequired(false);    o.setArgName("CF_NAME");    return o;}
public Option metron_f3674_0(@Nullable String s)
{    Option o = new Option(s, "as_of", true, "The earliest access tracker you want to use.");    o.setArgName("datetime");    o.setRequired(true);    return o;}
public Option metron_f3675_0(@Nullable String s)
{    String defaultFormat = new SimpleDateFormat().toLocalizedPattern();    Option o = new Option(s, "as_of_format", true, "The format of the as_of time (only used in conjunction with the as_of option) (Default is: " + defaultFormat + ")");    o.setArgName("format");    o.setRequired(false);    return o;}
public Option metron_f3676_0(@Nullable String s)
{    Option o = new Option(s, "access_table", true, "HBase table containing the access trackers.");    o.setRequired(true);    o.setArgName("HBASE_TABLE");    return o;}
public Option metron_f3677_0(@Nullable String s)
{    Option o = new Option(s, "access_column_family", true, "Column family of the HBase table containing the access trackers");    o.setRequired(true);    o.setArgName("CF_NAME");    return o;}
public static void metron_f3678_0(Job job, String sourceTable, String cf) throws IOException
{    Scan scan = new Scan();    if (cf != null) {        scan.addFamily(Bytes.toBytes(cf));    }        scan.setCaching(500);        scan.setCacheBlocks(false);        TableMapReduceUtil.initTableMapperJob(    sourceTable,     scan,     PrunerMapper.class,     null,     null, job);    TableMapReduceUtil.initTableReducerJob(    sourceTable,     null, job);}
public static Job metron_f3679_0(Configuration conf, String table, String cf, String accessTrackerTable, String accessTrackerColumnFamily, Long ts) throws IOException
{    Job job = new Job(conf);    job.setJobName("LeastRecentlyUsedPruner: Pruning " + table + ":" + cf + " since " + new SimpleDateFormat().format(new Date(ts)));    System.out.println("Configuring " + job.getJobName());    job.setJarByClass(LeastRecentlyUsedPruner.class);    job.getConfiguration().setLong(PrunerMapper.TIMESTAMP_CONF, ts);    job.getConfiguration().set(PrunerMapper.ACCESS_TRACKER_NAME_CONF, table);    job.getConfiguration().set(PrunerMapper.ACCESS_TRACKER_CF_CONF, accessTrackerColumnFamily);    job.getConfiguration().set(PrunerMapper.ACCESS_TRACKER_TABLE_CONF, accessTrackerTable);    setupHBaseJob(job, table, cf);    job.setNumReduceTasks(0);    return job;}
public static void metron_f3680_0(String... argv) throws IOException, java.text.ParseException, ClassNotFoundException, InterruptedException
{    Configuration conf = HBaseConfiguration.create();    String[] otherArgs = new GenericOptionsParser(conf, argv).getRemainingArgs();    CommandLine cli = BulkLoadOptions.parse(new PosixParser(), otherArgs);    Long ts = BulkLoadOptions.getTimestamp(cli);    String table = BulkLoadOptions.TABLE.get(cli);    String cf = BulkLoadOptions.COLUMN_FAMILY.get(cli);    String accessTrackerTable = BulkLoadOptions.ACCESS_TABLE.get(cli);    String accessTrackerCF = BulkLoadOptions.ACCESS_COLUMN_FAMILY.get(cli);    Job job = createJob(conf, table, cf, accessTrackerTable, accessTrackerCF, ts);    System.exit(job.waitForCompletion(true) ? 0 : 1);}
public int metron_f3681_0()
{    return typeColumnIndex;}
public String metron_f3682_0()
{    return type;}
public int metron_f3683_0()
{    return indicatorColumn;}
public LookupConverter metron_f3684_0()
{    return converter;}
public Iterable<LookupKV> metron_f3685_0(String line) throws IOException
{    if (ignore(line)) {        return Collections.emptyList();    }    String[] tokens = parser.parseLine(line);    LookupKey key = converter.toKey(getType(tokens), tokens[indicatorColumn]);    Map<String, Object> values = new HashMap<>();    for (Map.Entry<String, Integer> kv : columnMap.entrySet()) {        values.put(kv.getKey(), tokens[kv.getValue()]);    }    return Arrays.asList(new LookupKV(key, converter.toValue(values)));}
private String metron_f3686_0(String[] tokens)
{    if (type == null) {        return tokens[typeColumnIndex];    } else {        return type;    }}
public void metron_f3687_0(Map<String, Object> config)
{    super.initialize(config);    if (config.containsKey(INDICATOR_COLUMN_KEY)) {        indicatorColumn = columnMap.get(config.get(INDICATOR_COLUMN_KEY).toString());    }    if (config.containsKey(TYPE_KEY)) {        type = config.get(TYPE_KEY).toString();    } else if (config.containsKey(TYPE_COLUMN_KEY)) {        typeColumnIndex = columnMap.get(config.get(TYPE_COLUMN_KEY).toString());    }    if (config.containsKey(LOOKUP_CONVERTER)) {        converter = LookupConverters.getConverter((String) config.get(LOOKUP_CONVERTER));    }}
public LookupConverter metron_f3688_0()
{    return converter;}
public static LookupConverter metron_f3689_0(String name)
{    try {        return LookupConverters.valueOf(name).getConverter();    } catch (Throwable t) {        try {            return (LookupConverter) Class.forName(name).getConstructor().newInstance();        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {            throw new IllegalStateException("Unable to parse " + name, e);        }    }}
public LookupKey metron_f3690_0(String type, String indicator)
{    return new EnrichmentKey(type, indicator);}
public LookupValue metron_f3691_0(Map<String, Object> metadata)
{    return new EnrichmentValue(metadata);}
 Set<ExtractorCapabilities> metron_f3692_0()
{    return EnumSet.noneOf(ExtractorCapabilities.class);}
public Iterable<LookupKV> metron_f3693_0(String line) throws IOException
{    return decoratedExtractor.extract(line);}
public void metron_f3694_0(Map<String, Object> config)
{    decoratedExtractor.initialize(config);}
public Extractor metron_f3695_0()
{    return decoratedExtractor;}
public Map<String, Object> metron_f3696_0()
{    return config;}
public void metron_f3697_0(Map<String, Object> config)
{    this.config = config;}
public InputFormatHandler metron_f3698_0()
{    return inputFormat;}
public void metron_f3699_0(String handler)
{    try {        this.inputFormat = Formats.create(handler);    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {        throw new IllegalStateException("Unable to create an inputformathandler", e);    }}
public Extractor metron_f3700_0()
{    return extractor;}
public void metron_f3701_0(String extractor)
{    try {        this.extractor = Extractors.create(extractor);    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {        throw new IllegalStateException("Unable to create an extractor", e);    }}
public static synchronized ExtractorHandler metron_f3702_0(InputStream is) throws IOException
{    ExtractorHandler ret = _mapper.readValue(is, ExtractorHandler.class);    ret.getExtractor().initialize(ret.getConfig());    return ret;}
public static synchronized ExtractorHandler metron_f3703_0(String s, Charset c) throws IOException
{    return load(new ByteArrayInputStream(s.getBytes(c)));}
public static synchronized ExtractorHandler metron_f3704_0(String s) throws IOException
{    return load(s, Charset.defaultCharset());}
public Extractor metron_f3705_0()
{    return _creator.create();}
public static Extractor metron_f3706_0(String extractorName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
{    try {        ExtractorCreator ec = Extractors.valueOf(extractorName);        return new TransformFilterExtractorDecorator(ec.create());    } catch (IllegalArgumentException iae) {        Extractor ex = (Extractor) Class.forName(extractorName).getConstructor().newInstance();        return new TransformFilterExtractorDecorator(ex);    }}
public Extractor metron_f3707_0()
{    return new CSVExtractor();}
public Extractor metron_f3708_0()
{    return new StixExtractor();}
public void metron_f3709_0(Job job, List<Path> path, Map<String, Object> config) throws IOException
{    _handler.set(job, path, config);}
public static InputFormatHandler metron_f3710_0(String handlerName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
{    try {        InputFormatHandler ec = Formats.valueOf(handlerName)._handler;        return ec;    } catch (IllegalArgumentException iae) {        InputFormatHandler ex = (InputFormatHandler) Class.forName(handlerName).getConstructor().newInstance();        return ex;    }}
 void metron_f3711_0(Job job, Path input, Map<String, Object> config) throws IOException
{    set(job, ImmutableList.of(input), config);}
public void metron_f3712_0(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException
{    this.fileSplit = (FileSplit) split;    this.conf = context.getConfiguration();}
public boolean metron_f3713_0() throws IOException, InterruptedException
{    if (!processed) {        byte[] contents = new byte[(int) fileSplit.getLength()];        Path file = fileSplit.getPath();        FileSystem fs = file.getFileSystem(conf);        FSDataInputStream in = null;        try {            in = fs.open(file);            IOUtils.readFully(in, contents, 0, contents.length);            value.set(contents, 0, contents.length);        } finally {            IOUtils.closeStream(in);        }        processed = true;        return true;    }    return false;}
public NullWritable metron_f3714_0() throws IOException, InterruptedException
{    return NullWritable.get();}
public Text metron_f3715_0() throws IOException, InterruptedException
{    return value;}
public float metron_f3716_0() throws IOException
{    return processed ? 1.0f : 0.0f;}
protected boolean metron_f3718_0(JobContext context, Path file)
{    return false;}
public RecordReader<NullWritable, Text> metron_f3719_0(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException
{    WholeFileRecordReader reader = new WholeFileRecordReader();    reader.initialize(split, context);    return reader;}
public void metron_f3720_0(Job job, List<Path> inputs, Map<String, Object> config) throws IOException
{    for (Path input : inputs) {        WholeFileInputFormat.addInputPath(job, input);    }    job.setInputFormatClass(WholeFileInputFormat.class);}
public Iterable<LookupKV> metron_f3721_1(String line) throws IOException
{    STIXPackage stixPackage = STIXPackage.fromXMLString(line.replaceAll("\"Equal\"", "\"Equals\""));    List<LookupKV> ret = new ArrayList<>();    for (Observable o : getObservables(stixPackage)) {        ObjectType obj = o.getObject();        if (obj != null) {            ObjectPropertiesType props = obj.getProperties();            if (props != null) {                ObjectTypeHandler handler = ObjectTypeHandlers.getHandlerByInstance(props);                if (handler != null) {                    if (LOG.isDebugEnabled()) {                                            }                    Iterable<LookupKV> extractions = handler.extract(props, config);                    for (LookupKV extraction : extractions) {                        ret.add(extraction);                    }                } else if (LOG.isDebugEnabled()) {                                    }            }        }    }    return ret;}
public List<Observable> metron_f3722_0(STIXPackage stixPackage)
{    List<Observable> ret = new ArrayList<>();    Observables observables = stixPackage.getObservables();    if (observables != null) {        for (Observable o : observables.getObservables()) {            ret.add(o);        }    }    if (stixPackage.getIndicators() != null) {        if (stixPackage.getIndicators().getIndicators() != null) {            List<IndicatorBaseType> indicators = stixPackage.getIndicators().getIndicators();            int indicatorCount = indicators.size();            for (int i = 0; i < indicatorCount; i++) {                Indicator indicator = (Indicator) indicators.get(i);                if (indicator.getObservable() != null) {                    ret.add(indicator.getObservable());                }            }        }    }    return ret;}
public void metron_f3723_0(Map<String, Object> config)
{    this.config = config;}
public static Iterable<String> metron_f3724_0(StringObjectPropertyType value)
{    final ConditionTypeEnum condition = value.getCondition() == null ? ConditionTypeEnum.EQUALS : value.getCondition();    final ConditionApplicationEnum applyCondition = value.getApplyCondition();    List<String> tokens = new ArrayList<>();    if (condition == ConditionTypeEnum.EQUALS && applyCondition == ConditionApplicationEnum.ANY) {        String delim = value.getDelimiter();        String line = value.getValue().toString();        if (delim != null) {            for (String token : Splitter.on(delim).split(line)) {                tokens.add(token);            }        } else {            tokens.add(line);        }    }    return tokens;}
public static void metron_f3725_0(String[] args) throws IOException
{    File file = new File("/tmp/sample.xml");    /*if (args.length > 0) {            file = new File(args[0]);        } else {            try {                URL url = XML2Object.class.getClass().getResource(                        "/org/mitre/stix/examples/sample.xml");                file = new File(url.toURI());            } catch (URISyntaxException e) {                throw new RuntimeException(e);            }        }*/    String line = FileUtils.readFileToString(file);    StixExtractor extractor = new StixExtractor();    for (LookupKV results : extractor.extract(line)) {        System.out.println(results);    }}
public Class<T> metron_f3726_0()
{    return objectPropertiesType;}
public String metron_f3727_0()
{    return getTypeClass().getSimpleName().toLowerCase();}
public Iterable<LookupKV> metron_f3728_0(final Address type, Map<String, Object> config) throws IOException
{    List<LookupKV> ret = new ArrayList<>();    final CategoryTypeEnum category = type.getCategory();    if (!SUPPORTED_CATEGORIES.contains(category)) {        return ret;    }    String typeStr = getType();    if (config != null) {        if (config.containsKey(SPECIFIC_CATEGORY_CONFIG)) {            List<CategoryTypeEnum> categories = new ArrayList<>();            for (String c : Splitter.on(",").split(config.get(SPECIFIC_CATEGORY_CONFIG).toString())) {                categories.add(CategoryTypeEnum.valueOf(c));            }            EnumSet<CategoryTypeEnum> specificCategories = EnumSet.copyOf(categories);            if (!specificCategories.contains(category)) {                return ret;            }        }        if (config.containsKey(TYPE_CONFIG)) {            typeStr = config.get(TYPE_CONFIG).toString();        }    }    StringObjectPropertyType value = type.getAddressValue();    for (String token : StixExtractor.split(value)) {        final String indicatorType = typeStr + ":" + category;        LookupKV results = new LookupKV(new EnrichmentKey(indicatorType, token), new EnrichmentValue(new HashMap<String, Object>() {            {                put("source-type", "STIX");                put("indicator-type", indicatorType);                put("source", type.toXMLString());            }        }));        ret.add(results);    }    return ret;}
public List<String> metron_f3729_0()
{    String typeStr = getType();    List<String> ret = new ArrayList<>();    for (CategoryTypeEnum e : SUPPORTED_CATEGORIES) {        ret.add(typeStr + ":" + e);    }    return ret;}
public Iterable<LookupKV> metron_f3730_0(final DomainName type, Map<String, Object> config) throws IOException
{    List<LookupKV> ret = new ArrayList<>();    String typeStr = getType();    if (config != null) {        Object o = config.get(TYPE_CONFIG);        if (o != null) {            typeStr = o.toString();        }    }    final DomainNameTypeEnum domainType = type.getType();    if (domainType == null || SUPPORTED_TYPES.contains(domainType)) {        StringObjectPropertyType value = type.getValue();        for (String token : StixExtractor.split(value)) {            final String indicatorType = typeStr + ":" + DomainNameTypeEnum.FQDN;            LookupKV results = new LookupKV(new EnrichmentKey(indicatorType, token), new EnrichmentValue(new HashMap<String, Object>() {                {                    put("source-type", "STIX");                    put("indicator-type", indicatorType);                    put("source", type.toXMLString());                }            }));            ret.add(results);        }    }    return ret;}
public List<String> metron_f3731_0()
{    String typeStr = getType();    List<String> ret = new ArrayList<>();    for (DomainNameTypeEnum e : SUPPORTED_TYPES) {        ret.add(typeStr + ":" + e);    }    return ret;}
public Iterable<LookupKV> metron_f3732_0(final Hostname type, Map<String, Object> config) throws IOException
{    StringObjectPropertyType value = type.getHostnameValue();    String typeStr = getType();    if (config != null) {        Object o = config.get(TYPE_CONFIG);        if (o != null) {            typeStr = o.toString();        }    }    List<LookupKV> ret = new ArrayList<>();    for (String token : StixExtractor.split(value)) {        final String indicatorType = typeStr;        LookupKV results = new LookupKV(new EnrichmentKey(indicatorType, token), new EnrichmentValue(new HashMap<String, Object>() {            {                put("source-type", "STIX");                put("indicator-type", indicatorType);                put("source", type.toXMLString());            }        }));        ret.add(results);    }    return ret;}
public List<String> metron_f3733_0()
{    return ImmutableList.of(getType());}
 ObjectTypeHandler metron_f3734_0()
{    return _handler;}
public static ObjectTypeHandler metron_f3735_0(ObjectPropertiesType inst)
{    for (ObjectTypeHandlers h : values()) {        if (inst.getClass().equals(h.getHandler().getTypeClass())) {            return h.getHandler();        }    }    return null;}
public Iterable<LookupKV> metron_f3736_0(URIObjectType type, Map<String, Object> config) throws IOException
{    List<LookupKV> ret = new ArrayList<>();    if (type != null) {        AnyURIObjectPropertyType val = type.getValue();        if (val != null) {            Object v = val.getValue();            if (v != null) {                final String indicatorType = getType();                LookupKV results = new LookupKV(new EnrichmentKey(indicatorType, v.toString()), new EnrichmentValue(new HashMap<String, Object>() {                    {                        put("source-type", "STIX");                        put("uri", v.toString());                        put("indicator-type", indicatorType);                        put("source", type.toXMLString());                    }                }));                ret.add(results);            }        }    }    return ret;}
public List<String> metron_f3737_0()
{    return ImmutableList.of(getType());}
public String metron_f3738_0()
{    return key;}
public boolean metron_f3739_0(Map<String, Object> config)
{    return config == null ? false : config.containsKey(key);}
public void metron_f3740_0(Map<String, Object> config)
{    super.initialize(config);    if (VALUE_TRANSFORM.existsIn(config)) {        this.valueTransforms = getTransforms(config, VALUE_TRANSFORM.toString());    }    if (INDICATOR_TRANSFORM.existsIn(config)) {        this.indicatorTransforms = getTransforms(config, INDICATOR_TRANSFORM.toString());    }    if (VALUE_FILTER.existsIn(config)) {        this.valueFilter = getFilter(config, VALUE_FILTER.toString());    }    if (INDICATOR_FILTER.existsIn(config)) {        this.indicatorFilter = getFilter(config, INDICATOR_FILTER.toString());    }    if (STATE_UPDATE.existsIn(config)) {        capabilities.add(ExtractorCapabilities.STATEFUL);        this.stateUpdate = getTransforms(config, STATE_UPDATE.toString());    }    if (STATE_INIT.existsIn(config)) {        capabilities.add(ExtractorCapabilities.STATEFUL);    }    if (STATE_MERGE.existsIn(config)) {        capabilities.add(ExtractorCapabilities.MERGEABLE);        this.stateMerge = getFilter(config, STATE_MERGE.toString());    }    String zkClientUrl = "";    if (ZK_QUORUM.existsIn(config)) {        zkClientUrl = ConversionUtils.convert(config.get(ZK_QUORUM.toString()), String.class);    }    zkClient = setupClient(zkClient, zkClientUrl);    this.globalConfig = getGlobalConfig(zkClient);    this.stellarContext = createContext(zkClient);    StellarFunctions.initialize(stellarContext);    this.transformProcessor = new StellarProcessor();    this.filterProcessor = new StellarPredicateProcessor();}
public Object metron_f3741_0(Map<String, Object> config)
{    if (STATE_INIT.existsIn(config)) {        MapVariableResolver resolver = new MapVariableResolver(globalConfig);        return transformProcessor.parse(config.get(STATE_INIT.toString()).toString(), resolver, StellarFunctions.FUNCTION_RESOLVER(), stellarContext);    }    return null;}
public Object metron_f3742_0(List<? extends Object> states)
{    return transformProcessor.parse(stateMerge, new MapVariableResolver(new HashMap<String, Object>() {        {            put(STATES_KEY, states);        }    }, globalConfig), StellarFunctions.FUNCTION_RESOLVER(), stellarContext);}
private String metron_f3743_0(Map<String, Object> config, String valueFilter)
{    return (String) config.get(valueFilter);}
private Map<String, String> metron_f3744_0(Map<String, Object> config, String type)
{        @SuppressWarnings("unchecked")    Map<Object, Object> transformsConfig = (Map) config.get(type);    Map<String, String> transforms = new LinkedHashMap<>();    for (Map.Entry<Object, Object> e : transformsConfig.entrySet()) {        transforms.put((String) e.getKey(), (String) e.getValue());    }    return transforms;}
private Optional<CuratorFramework> metron_f3745_1(Optional<CuratorFramework> zkClient, String zookeeperUrl)
{        if (!zkClient.isPresent()) {        if (StringUtils.isNotBlank(zookeeperUrl)) {            CuratorFramework client = ConfigurationsUtils.getClient(zookeeperUrl);            client.start();            return Optional.of(client);        } else {                        return Optional.empty();        }    } else {        return zkClient;    }}
private Map<String, Object> metron_f3746_1(Optional<CuratorFramework> zkClient)
{    if (zkClient.isPresent()) {        try {            return JSONUtils.INSTANCE.load(new ByteArrayInputStream(ConfigurationsUtils.readGlobalConfigBytesFromZookeeper(zkClient.get())), JSONUtils.MAP_SUPPLIER);        } catch (Exception e) {                    }    }    return new LinkedHashMap<>();}
private Context metron_f3747_0(Optional<CuratorFramework> zkClient)
{    Context.Builder builder = new Context.Builder();    if (zkClient.isPresent()) {        builder.with(Context.Capabilities.ZOOKEEPER_CLIENT, zkClient::get);    }    builder.with(Context.Capabilities.GLOBAL_CONFIG, () -> globalConfig);    builder.with(Context.Capabilities.STELLAR_CONFIG, () -> globalConfig);    return builder.build();}
public Set<ExtractorCapabilities> metron_f3748_0()
{    return capabilities;}
public Iterable<LookupKV> metron_f3749_0(String line) throws IOException
{    return extract(line, new AtomicReference<>(null));}
public Iterable<LookupKV> metron_f3750_0(String line, AtomicReference<Object> state) throws IOException
{    List<LookupKV> lkvs = new ArrayList<>();    for (LookupKV lkv : super.extract(line)) {        if (updateLookupKV(lkv, state)) {            lkvs.add(lkv);        }    }    return lkvs;}
private boolean metron_f3751_0(LookupKV lkv, AtomicReference<Object> state)
{    Map<String, Object> ret = lkv.getValue().getMetadata();    Map<String, Object> ind = new LinkedHashMap<>();    String indicator = lkv.getKey().getIndicator();        ind.put(INDICATOR.toString(), indicator);    Map<String, Object> stateMap = new LinkedHashMap<>();    stateMap.put(STATE_KEY, state.get());    MapVariableResolver resolver = new MapVariableResolver(ret, ind, globalConfig, stateMap);    transform(valueTransforms, ret, resolver);    transform(indicatorTransforms, ind, resolver);        Object updatedIndicator = ind.get(INDICATOR.toString());    if (updatedIndicator != null || getCapabilities().contains(ExtractorCapabilities.STATEFUL)) {        if (!(updatedIndicator instanceof String)) {            throw new UnsupportedOperationException("Indicator transform must return String type");        }        lkv.getKey().setIndicator((String) updatedIndicator);        boolean update = filter(indicatorFilter, resolver) && filter(valueFilter, resolver);        if (update && !stateUpdate.isEmpty()) {            transform(stateUpdate, stateMap, resolver);            state.set(stateMap.get(STATE_KEY));        }        return update;    } else {        return false;    }}
private void metron_f3752_0(Map<String, String> transforms, Map<String, Object> variableMap, MapVariableResolver variableResolver)
{    for (Map.Entry<String, String> entry : transforms.entrySet()) {        Object o = transformProcessor.parse(entry.getValue(), variableResolver, StellarFunctions.FUNCTION_RESOLVER(), stellarContext);        if (o == null) {            variableMap.remove(entry.getKey());        } else {            variableMap.put(entry.getKey(), o);        }    }}
private Boolean metron_f3753_0(String filterPredicate, MapVariableResolver variableResolver)
{    if (StringUtils.isEmpty(filterPredicate)) {        return true;    }    return filterProcessor.parse(filterPredicate, variableResolver, StellarFunctions.FUNCTION_RESOLVER(), stellarContext);}
protected void metron_f3754_0(Optional<CuratorFramework> zkClient)
{    this.zkClient = zkClient;}
public void metron_f3755_0(Context context) throws IOException, InterruptedException
{    initialize(context.getConfiguration());}
public void metron_f3756_0(Object key, Text value, Context context) throws IOException, InterruptedException
{    for (LookupKV results : extractor.extract(value.toString())) {        if (results != null) {            Put put = converter.toPut(columnFamily, results.getKey(), results.getValue());            write(new ImmutableBytesWritable(results.getKey().toBytes()), put, context);        }    }}
protected void metron_f3757_0(Configuration configuration) throws IOException
{    String configStr = configuration.get(CONFIG_KEY);    extractor = ExtractorHandler.load(configStr).getExtractor();    columnFamily = configuration.get(COLUMN_FAMILY_KEY);    try {        converter = (HbaseConverter) Class.forName(configuration.get(CONVERTER_KEY)).getConstructor().newInstance();    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {        throw new IllegalStateException("Unable to create converter object: " + configuration.get(CONVERTER_KEY), e);    }}
protected void metron_f3758_0(ImmutableBytesWritable key, Put value, Context context) throws IOException, InterruptedException
{    context.write(key, value);}
public void metron_f3759_0(Context context) throws IOException
{    String atTable = context.getConfiguration().get(ACCESS_TRACKER_TABLE_CONF);    String atCF = context.getConfiguration().get(ACCESS_TRACKER_CF_CONF);    String atName = context.getConfiguration().get(ACCESS_TRACKER_NAME_CONF);    Table table = new HTableProvider().getTable(context.getConfiguration(), atTable);    long timestamp = context.getConfiguration().getLong(TIMESTAMP_CONF, -1);    if (timestamp < 0) {        throw new IllegalStateException("Must specify a timestamp that is positive.");    }    try {        tracker = AccessTrackerUtil.INSTANCE.loadAll(AccessTrackerUtil.INSTANCE.loadAll(table, atCF, atName, timestamp));    } catch (Throwable e) {        throw new IllegalStateException("Unable to load the accesstrackers from the directory", e);    }}
public void metron_f3760_0(ImmutableBytesWritable key, Result value, Context context) throws IOException, InterruptedException
{    if (tracker == null || key == null) {        throw new RuntimeException("Tracker = " + tracker + " key = " + key);    }    if (!tracker.hasSeen(toLookupKey(key.get()))) {        Delete d = new Delete(key.get());        context.write(key, d);    }}
protected LookupKey metron_f3761_0(final byte[] bytes)
{    return new LookupKey() {        @Override        public byte[] toBytes() {            return bytes;        }        @Override        public void fromBytes(byte[] in) {        }        @Override        public String getIndicator() {            return null;        }        @Override        public void setIndicator(String indicator) {        }    };}
public byte[] metron_f3762_0()
{    return bytes;}
public String metron_f3764_0()
{    return null;}
public String metron_f3766_0()
{    return "h";}
public Option metron_f3767_0(@Nullable String input)
{    return new Option(getShortCode(), "help", false, "Generate Help screen");}
public String metron_f3768_0()
{    return "q";}
public Option metron_f3769_0(@Nullable String input)
{    return new Option(getShortCode(), "quiet", false, "Do not update progress");}
public Optional<Object> metron_f3770_0(OPT_T option, CommandLine cli)
{    return Optional.of(option.has(cli));}
public String metron_f3771_0()
{    return "m";}
public Option metron_f3772_0(@Nullable String input)
{    Option o = new Option(getShortCode(), "import_mode", true, "The Import mode to use: " + Joiner.on(",").join(importModes) + ".  Default: " + defaultMode);    o.setArgName("MODE");    o.setRequired(false);    return o;}
public Optional<Object> metron_f3773_0(OPT_T option, CommandLine cli)
{    String mode = option.get(cli);    return resolver.apply(mode);}
public Option metron_f3774_0(@Nullable String s)
{    Option o = new Option(s, "extractor_config", true, "JSON Document describing the extractor for this input data source");    o.setArgName("JSON_FILE");    o.setRequired(true);    return o;}
public Optional<Object> metron_f3775_0(OPT_T option, CommandLine cli)
{    try {        return Optional.ofNullable(FileUtils.readFileToString(new File(option.get(cli).trim())));    } catch (IOException e) {        throw new IllegalStateException("Unable to retrieve extractor config from " + option.get(cli) + ": " + e.getMessage(), e);    }}
public String metron_f3776_0()
{    return "e";}
public Option metron_f3777_0(@Nullable String s)
{    Option o = new Option(s, "log4j", true, "The log4j properties file to load");    o.setArgName("FILE");    o.setRequired(false);    return o;}
public String metron_f3778_0()
{    return "l";}
public Option metron_f3779_0(@Nullable String s)
{    Option o = new Option(s, "threads", true, "The number of threads to use when extracting data.  The default is the number of cores of your machine.");    o.setArgName("NUM_THREADS");    o.setRequired(false);    return o;}
public Optional<Object> metron_f3780_0(OPT_T option, CommandLine cli)
{    int numThreads = Runtime.getRuntime().availableProcessors();    if (option.has(cli)) {        numThreads = ConversionUtils.convert(option.get(cli), Integer.class);    }    return Optional.of(numThreads);}
public String metron_f3781_0()
{    return "p";}
public Option metron_f3782_0(@Nullable String s)
{    Option o = new Option(s, "batchSize", true, "The batch size to use for HBase puts");    o.setArgName("SIZE");    o.setRequired(false);    return o;}
public Optional<Object> metron_f3783_0(OPT_T option, CommandLine cli)
{    int batchSize = 128;    if (option.has(cli)) {        batchSize = ConversionUtils.convert(option.get(cli), Integer.class);    }    return Optional.of(batchSize);}
public String metron_f3784_0()
{    return "b";}
public Option metron_f3785_0(@Nullable String s)
{    Option o = new Option(s, "input", true, "The CSV File to load");    o.setArgName("FILE");    o.setRequired(true);    return o;}
public Optional<Object> metron_f3786_0(OPT_T option, CommandLine cli)
{    List<String> inputs = new ArrayList<>();    for (String input : Splitter.on(",").split(Optional.ofNullable(option.get(cli)).orElse(""))) {        inputs.add(input.trim());    }    return Optional.of(inputs);}
public String metron_f3787_0()
{    return "i";}
public String metron_f3788_0()
{    return cf;}
public Table metron_f3789_0()
{    return table;}
public Extractor metron_f3790_0()
{    return extractor;}
public HbaseConverter metron_f3791_0()
{    return converter;}
public FileSystem metron_f3792_0()
{    return fs;}
public void metron_f3793_0(final EnumMap<OPTIONS_T, Optional<Object>> config, final ExtractorHandler handler, final Configuration hadoopConfig) throws IOException, InvalidWriterOutput
{    validateState(config, handler);    ThreadLocal<STATE_T> state = createState(config, hadoopConfig, handler);    boolean quiet = isQuiet(config);    boolean lineByLine = !handler.getInputFormat().getClass().equals(WholeFileFormat.class);    List<String> inputs = getInputs(config);    FileSystem fs = FileSystem.get(hadoopConfig);    if (!lineByLine) {        extractWholeFiles(inputs, fs, state, quiet);    } else {        int batchSize = batchSize(config);        int numThreads = numThreads(config, handler);        extractLineByLine(inputs, fs, state, batchSize, numThreads, quiet);    }    if (!quiet) {        System.out.println();    }}
protected Location metron_f3794_0(String input, FileSystem fs)
{    return LocationStrategy.getLocation(input, fs);}
public void metron_f3795_0(List<String> inputs, FileSystem fs, ThreadLocal<STATE_T> state, int batchSize, int numThreads, boolean quiet) throws IOException
{    inputs.stream().map(input -> resolveLocation(input, fs)).forEach(loc -> {        final Progress progress = new Progress();        if (!quiet) {            System.out.println("\nProcessing " + loc.toString());        }        try (Stream<String> stream = ReaderSpliterator.lineStream(loc.openReader(), batchSize)) {            ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);            forkJoinPool.submit(() -> stream.parallel().forEach(input -> {                try {                    extract(state.get(), input);                    if (!quiet) {                        progress.update();                    }                } catch (IOException e) {                    throw new IllegalStateException("Unable to continue: " + e.getMessage(), e);                }            })).get();        } catch (Exception e) {            throw new IllegalStateException(e.getMessage(), e);        }    });}
public void metron_f3796_0(List<String> inputs, FileSystem fs, ThreadLocal<STATE_T> state, boolean quiet) throws IOException
{    final Progress progress = new Progress();    final List<Location> locations = getLocationsRecursive(inputs, fs);    locations.parallelStream().forEach(loc -> {        try (BufferedReader br = loc.openReader()) {            String s = br.lines().collect(Collectors.joining());            extract(state.get(), s);            if (!quiet) {                progress.update();            }        } catch (IOException e) {            throw new IllegalStateException("Unable to read " + loc + ": " + e.getMessage(), e);        }    });}
protected List<Location> metron_f3797_0(List<String> inputs, FileSystem fs) throws IOException
{    final List<Location> locations = new ArrayList<>();    Location.fileVisitor(inputs, loc -> locations.add(loc), fs);    return locations;}
public synchronized void metron_f3798_0()
{    int currentCount = count++;    System.out.print("\rProcessed " + currentCount + " - " + anim.charAt(currentCount % anim.length()));}
protected void metron_f3799_0(EnumMap<OPTIONS_T, Optional<Object>> config, OPTIONS_T option)
{    if (!config.containsKey(option)) {        throw new IllegalStateException("Expected " + option.getOption().getOpt() + " to be set");    }}
public Importer metron_f3800_0()
{    return importer;}
public static Optional<ImportStrategy> metron_f3801_0(String strategyName)
{    if (strategyName == null) {        return Optional.empty();    }    for (ImportStrategy strategy : values()) {        if (strategy.name().equalsIgnoreCase(strategyName.trim())) {            return Optional.of(strategy);        }    }    return Optional.empty();}
protected List<String> metron_f3802_0(EnumMap<LoadOptions, Optional<Object>> config)
{    return (List<String>) config.get(LoadOptions.INPUT).get();}
protected boolean metron_f3803_0(EnumMap<LoadOptions, Optional<Object>> config)
{    return (boolean) config.get(LoadOptions.QUIET).get();}
protected int metron_f3804_0(EnumMap<LoadOptions, Optional<Object>> config)
{    return (int) config.get(LoadOptions.BATCH_SIZE).get();}
protected int metron_f3805_0(EnumMap<LoadOptions, Optional<Object>> config, ExtractorHandler handler)
{    return (int) config.get(LoadOptions.NUM_THREADS).get();}
protected void metron_f3806_0(EnumMap<LoadOptions, Optional<Object>> config, ExtractorHandler handler)
{    assertOption(config, LoadOptions.HBASE_CF);    assertOption(config, LoadOptions.HBASE_TABLE);}
protected ThreadLocal<HBaseExtractorState> metron_f3807_0(EnumMap<LoadOptions, Optional<Object>> config, Configuration hadoopConfig, final ExtractorHandler handler)
{    ThreadLocal<HBaseExtractorState> state = new ThreadLocal<HBaseExtractorState>() {        @Override        protected HBaseExtractorState initialValue() {            try {                String cf = (String) config.get(LoadOptions.HBASE_CF).get();                Table table = provider.retrieve().getTable(hadoopConfig, (String) config.get(LoadOptions.HBASE_TABLE).get());                return new HBaseExtractorState(table, cf, handler.getExtractor(), new EnrichmentConverter(), hadoopConfig);            } catch (IOException e1) {                throw new IllegalStateException("Unable to get table: " + e1);            }        }    };    return state;}
protected HBaseExtractorState metron_f3808_0()
{    try {        String cf = (String) config.get(LoadOptions.HBASE_CF).get();        Table table = provider.retrieve().getTable(hadoopConfig, (String) config.get(LoadOptions.HBASE_TABLE).get());        return new HBaseExtractorState(table, cf, handler.getExtractor(), new EnrichmentConverter(), hadoopConfig);    } catch (IOException e1) {        throw new IllegalStateException("Unable to get table: " + e1);    }}
protected void metron_f3809_0(HBaseExtractorState state, String line) throws IOException
{    HBaseExtractorState es = state;    es.getTable().put(toPut(line, es.getExtractor(), state.getCf(), es.getConverter()));}
public List<Put> metron_f3810_0(String line, Extractor extractor, String cf, HbaseConverter converter) throws IOException
{    List<Put> ret = new ArrayList<>();    Iterable<LookupKV> kvs = extractor.extract(line);    for (LookupKV kv : kvs) {        Put put = converter.toPut(cf, kv.getKey(), kv.getValue());        ret.add(put);    }    return ret;}
public AtomicReference<Object> metron_f3811_0()
{    return state;}
public StatefulExtractor metron_f3812_0()
{    return extractor;}
protected boolean metron_f3813_0(EnumMap<SummarizeOptions, Optional<Object>> config)
{    return (boolean) config.getOrDefault(SummarizeOptions.QUIET, Optional.of(false)).get();}
protected int metron_f3814_0(EnumMap<SummarizeOptions, Optional<Object>> config)
{    return (int) config.getOrDefault(SummarizeOptions.BATCH_SIZE, Optional.of(1)).get();}
protected int metron_f3815_0(EnumMap<SummarizeOptions, Optional<Object>> config, ExtractorHandler handler)
{    if (handler.getExtractor().getCapabilities().contains(ExtractorCapabilities.MERGEABLE)) {        return (int) config.get(SummarizeOptions.NUM_THREADS).get();    } else {                return 1;    }}
protected void metron_f3816_0(EnumMap<SummarizeOptions, Optional<Object>> config, ExtractorHandler handler)
{    if (!(handler.getExtractor() instanceof StatefulExtractor)) {        throw new IllegalStateException("Extractor must be a stateful extractor and " + handler.getExtractor().getClass().getName() + " is not.");    }    assertOption(config, SummarizeOptions.OUTPUT);    if (!handler.getExtractor().getCapabilities().contains(ExtractorCapabilities.STATEFUL)) {        throw new IllegalStateException("Unable to operate on a non-stateful extractor.  " + "If you have not specified \"stateUpdate\" in your Extractor config, there is nothing to do here and nothing will be written.");    }}
protected ThreadLocal<SummarizationState> metron_f3817_0(EnumMap<SummarizeOptions, Optional<Object>> config, Configuration hadoopConfig, ExtractorHandler handler)
{    final StatefulExtractor extractor = (StatefulExtractor) handler.getExtractor();    return ThreadLocal.withInitial(() -> {        Object initState = extractor.initializeState(handler.getConfig());        SummarizationState ret = new SummarizationState(extractor, initState);        stateList.add(ret);        return ret;    });}
protected void metron_f3818_0(SummarizationState state, String line) throws IOException
{    state.getExtractor().extract(line, state.getState());}
public void metron_f3819_0(EnumMap<SummarizeOptions, Optional<Object>> config, ExtractorHandler handler, Configuration hadoopConfig) throws IOException, InvalidWriterOutput
{    Writer writer = (Writer) config.get(SummarizeOptions.OUTPUT_MODE).get();    Optional<String> fileName = Optional.ofNullable((String) config.get(SummarizeOptions.OUTPUT).orElse(null));    writer.validate(fileName, hadoopConfig);    super.importData(config, handler, hadoopConfig);    StatefulExtractor extractor = (StatefulExtractor) handler.getExtractor();    Object finalState = null;    if (stateList.size() == 1) {        finalState = stateList.get(0).getState().get();    } else if (stateList.size() > 1) {        List<Object> states = new ArrayList<>();        for (SummarizationState s : stateList) {            states.add(s.getState().get());        }        finalState = extractor.mergeStates(states);    }    writer.write(finalState, fileName, hadoopConfig);}
protected List<String> metron_f3820_0(EnumMap<SummarizeOptions, Optional<Object>> config)
{    Object o = config.get(SummarizeOptions.INPUT).get();    if (o == null) {        return new ArrayList<>();    }    if (o instanceof String) {        return ImmutableList.of((String) o);    }    return (List<String>) config.get(SummarizeOptions.INPUT).get();}
public void metron_f3821_1(EnumMap<LoadOptions, Optional<Object>> config, ExtractorHandler handler, Configuration hadoopConfig) throws IOException
{    String table = (String) config.get(LoadOptions.HBASE_TABLE).get();    String cf = (String) config.get(LoadOptions.HBASE_CF).get();    String extractorConfigContents = (String) config.get(LoadOptions.EXTRACTOR_CONFIG).get();    Job job = Job.getInstance(hadoopConfig);    List<String> inputs = (List<String>) config.get(LoadOptions.INPUT).get();    job.setJobName("MapReduceImporter: " + inputs.stream().collect(Collectors.joining(",")) + " => " + table + ":" + cf);        job.setJarByClass(MapReduceImporter.class);    job.setMapperClass(org.apache.metron.dataloads.hbase.mr.BulkLoadMapper.class);    job.setOutputFormatClass(TableOutputFormat.class);    job.getConfiguration().set(TableOutputFormat.OUTPUT_TABLE, table);    job.getConfiguration().set(BulkLoadMapper.COLUMN_FAMILY_KEY, cf);    job.getConfiguration().set(BulkLoadMapper.CONFIG_KEY, extractorConfigContents);    job.getConfiguration().set(BulkLoadMapper.CONVERTER_KEY, EnrichmentConverter.class.getName());    job.setOutputKeyClass(ImmutableBytesWritable.class);    job.setOutputValueClass(Put.class);    job.setNumReduceTasks(0);    List<Path> paths = inputs.stream().map(p -> new Path(p)).collect(Collectors.toList());    handler.getInputFormat().set(job, paths, handler.getConfig());    TableMapReduceUtil.initCredentials(job);    try {        job.waitForCompletion(true);    } catch (Exception e) {        throw new IllegalStateException("Unable to complete job: " + e.getMessage(), e);    }}
public Importer metron_f3822_0()
{    return importer;}
public static Optional<Summarizers> metron_f3823_0(String strategyName)
{    if (strategyName == null) {        return Optional.empty();    }    for (Summarizers strategy : values()) {        if (strategy.name().equalsIgnoreCase(strategyName.trim())) {            return Optional.of(strategy);        }    }    return Optional.empty();}
public OptionHandler<LoadOptions> metron_f3824_0()
{    return handler;}
public Option metron_f3825_0()
{    return option;}
public boolean metron_f3826_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f3827_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public static CommandLine metron_f3828_0(CommandLineParser parser, String[] args)
{    return OptionHandler.parse("SimpleEnrichmentFlatFileLoader", parser, args, values(), HELP);}
public static EnumMap<LoadOptions, Optional<Object>> metron_f3829_0(CommandLine cli)
{    return OptionHandler.createConfig(cli, values(), LoadOptions.class);}
public Option metron_f3830_0(@Nullable String s)
{    Option o = new Option(s, "hbase_table", true, "HBase table to ingest the data into.");    o.setArgName("TABLE");    o.setRequired(true);    return o;}
public Optional<Object> metron_f3831_0(LoadOptions option, CommandLine cli)
{    return Optional.ofNullable(option.get(cli).trim());}
public String metron_f3832_0()
{    return "t";}
public Option metron_f3833_0(@Nullable String s)
{    Option o = new Option(s, "hbase_cf", true, "HBase column family to ingest the data into.");    o.setArgName("CF");    o.setRequired(true);    return o;}
public Optional<Object> metron_f3834_0(LoadOptions option, CommandLine cli)
{    return Optional.ofNullable(option.get(cli).trim());}
public String metron_f3835_0()
{    return "c";}
public String metron_f3836_0()
{    return "n";}
public Option metron_f3837_0(@Nullable String s)
{    Option o = new Option(s, "enrichment_config", true, "JSON Document describing the enrichment configuration details." + "  This is used to associate an enrichment type with a field type in zookeeper.");    o.setArgName("JSON_FILE");    o.setRequired(false);    return o;}
public Optional<List<String>> metron_f3838_0(String loc)
{    List<String> children = new ArrayList<>();    for (File f : new File(loc).listFiles()) {        children.add(f.getPath());    }    return Optional.of(children);}
public boolean metron_f3839_0(String loc) throws IOException
{    return new File(loc).exists();}
public boolean metron_f3840_0(String loc) throws IOException
{    return new File(loc).isDirectory();}
public InputStream metron_f3841_0(String loc) throws IOException
{    return new FileInputStream(loc);}
public boolean metron_f3842_0(String loc)
{    return new File(loc).exists();}
public Optional<List<String>> metron_f3843_0(String loc) throws IOException
{    List<String> children = new ArrayList<>();    for (FileStatus f : fs.listStatus(new Path(loc))) {        children.add(f.getPath().toString());    }    return Optional.of(children);}
public boolean metron_f3844_0(String loc) throws IOException
{    return fs.exists(new Path(loc));}
public boolean metron_f3845_0(String loc) throws IOException
{    return fs.isDirectory(new Path(loc));}
public InputStream metron_f3846_0(String loc) throws IOException
{    return fs.open(new Path(loc));}
public boolean metron_f3847_0(String loc)
{    try {        return loc.startsWith("hdfs://") && exists(loc);    } catch (IOException e) {        return false;    }}
public void metron_f3848_0(FileSystem state)
{    this.fs = state;}
public RawLocation<?> metron_f3849_0()
{    return rawLocation;}
public Optional<List<Location>> metron_f3850_0() throws IOException
{    if (exists() && isDirectory()) {        List<Location> children = new ArrayList<>();        for (String child : rawLocation.list(loc).orElse(new ArrayList<>())) {            children.add(new Location(child, rawLocation));        }        return Optional.of(children);    } else {        return Optional.empty();    }}
public boolean metron_f3851_0() throws IOException
{    return rawLocation.exists(loc);}
public boolean metron_f3852_0() throws IOException
{    return rawLocation.isDirectory(loc);}
public BufferedReader metron_f3853_0() throws IOException
{    return rawLocation.openReader(loc);}
public String metron_f3854_0()
{    return loc;}
public static void metron_f3855_0(List<String> inputs, final Consumer<Location> importConsumer, final FileSystem fs) throws IOException
{    Stack<Location> stack = new Stack<>();    for (String input : inputs) {        Location loc = LocationStrategy.getLocation(input, fs);        if (loc.exists()) {            stack.add(loc);        }    }    while (!stack.empty()) {        Location loc = stack.pop();        if (loc.isDirectory()) {            for (Location child : loc.getChildren().orElse(Collections.emptyList())) {                stack.push(child);            }        } else {            importConsumer.accept(loc);        }    }}
public static Optional<RawLocation<?>> metron_f3856_0(String loc, FileSystem fs)
{    for (LocationStrategy strategy : values()) {        RawLocation<?> location = strategy.locationCreator.apply(fs);        if (location.match(loc)) {            return Optional.of(location);        }    }    return Optional.empty();}
public static Location metron_f3857_0(String loc, FileSystem fs)
{    Optional<RawLocation<?>> rawLoc = getRawLocation(loc, fs);    if (rawLoc.isPresent()) {        return new Location(loc, rawLoc.get());    } else {        throw new IllegalStateException("Unsupported type: " + loc);    }}
 BufferedReader metron_f3859_0(String loc) throws IOException
{    InputStream is = openInputStream(loc);    if (loc.endsWith(".gz")) {        return new BufferedReader(new InputStreamReader(new GZIPInputStream(is), StandardCharsets.UTF_8));    } else if (loc.endsWith(".zip")) {        ZipInputStream zis = new ZipInputStream(is);        ZipEntry entry = zis.getNextEntry();        if (entry != null) {            return new BufferedReader(new InputStreamReader(zis, StandardCharsets.UTF_8));        } else {            return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(new byte[] {}), StandardCharsets.UTF_8));        }    } else {        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));    }}
public Optional<List<String>> metron_f3860_0(String loc) throws IOException
{    return Optional.of(Collections.emptyList());}
public boolean metron_f3861_0(String loc) throws IOException
{    return true;}
public boolean metron_f3862_0(String loc) throws IOException
{    return false;}
public InputStream metron_f3863_0(String loc) throws IOException
{    return new URL(loc).openConnection().getInputStream();}
public boolean metron_f3864_0(String loc)
{    try {        new URL(loc);        return true;    } catch (MalformedURLException e) {        return false;    }}
public static void metron_f3865_0(String... argv) throws Exception
{    Configuration hadoopConfig = HBaseConfiguration.create();    String[] otherArgs = new GenericOptionsParser(hadoopConfig, argv).getRemainingArgs();    main(hadoopConfig, otherArgs);}
public static void metron_f3866_0(Configuration hadoopConfig, String[] argv) throws Exception
{    CommandLine cli = LoadOptions.parse(new PosixParser(), argv);    EnumMap<LoadOptions, Optional<Object>> config = LoadOptions.createConfig(cli);    if (LoadOptions.LOG4J_PROPERTIES.has(cli)) {        PropertyConfigurator.configure(LoadOptions.LOG4J_PROPERTIES.get(cli));    }    ExtractorHandler handler = ExtractorHandler.load(FileUtils.readFileToString(new File(LoadOptions.EXTRACTOR_CONFIG.get(cli).trim())));    ImportStrategy strategy = (ImportStrategy) config.get(LoadOptions.IMPORT_MODE).get();    strategy.getImporter().importData(config, handler, hadoopConfig);    SensorEnrichmentUpdateConfig sensorEnrichmentUpdateConfig = null;    if (LoadOptions.ENRICHMENT_CONFIG.has(cli)) {        sensorEnrichmentUpdateConfig = JSONUtils.INSTANCE.load(new File(LoadOptions.ENRICHMENT_CONFIG.get(cli)), SensorEnrichmentUpdateConfig.class);    }    if (sensorEnrichmentUpdateConfig != null) {        sensorEnrichmentUpdateConfig.updateSensorConfigs();    }}
public static void metron_f3867_0(String... argv) throws Exception
{    Configuration hadoopConfig = HBaseConfiguration.create();    String[] otherArgs = new GenericOptionsParser(hadoopConfig, argv).getRemainingArgs();    main(hadoopConfig, otherArgs);}
public static void metron_f3868_0(Configuration hadoopConfig, String[] argv) throws Exception
{    CommandLine cli = SummarizeOptions.parse(new PosixParser(), argv);    EnumMap<SummarizeOptions, Optional<Object>> config = SummarizeOptions.createConfig(cli);    if (SummarizeOptions.LOG4J_PROPERTIES.has(cli)) {        PropertyConfigurator.configure(SummarizeOptions.LOG4J_PROPERTIES.get(cli));    }    ExtractorHandler handler = ExtractorHandler.load(FileUtils.readFileToString(new File(SummarizeOptions.EXTRACTOR_CONFIG.get(cli).trim())));    Summarizers strategy = (Summarizers) config.get(SummarizeOptions.IMPORT_MODE).get();    strategy.getSummarizer().importData(config, handler, hadoopConfig);}
public OptionHandler<SummarizeOptions> metron_f3869_0()
{    return handler;}
public Option metron_f3870_0()
{    return option;}
public boolean metron_f3871_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f3872_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public static CommandLine metron_f3873_0(CommandLineParser parser, String[] args)
{    return OptionHandler.parse("SimpleFlatFileSummarizer", parser, args, values(), HELP);}
public static EnumMap<SummarizeOptions, Optional<Object>> metron_f3874_0(CommandLine cli)
{    return OptionHandler.createConfig(cli, values(), SummarizeOptions.class);}
public Option metron_f3875_0(@Nullable String s)
{    Option o = new Option(s, "output_mode", true, "The output mode to use: " + Joiner.on(",").join(Writers.values()) + ".  Default: " + Writers.LOCAL);    o.setArgName("MODE");    o.setRequired(false);    return o;}
public Optional<Object> metron_f3876_0(SummarizeOptions option, CommandLine cli)
{    String mode = option.get(cli);    return Optional.of(Writers.getStrategy(mode).orElse(Writers.LOCAL));}
public String metron_f3877_0()
{    return "om";}
public Option metron_f3878_0(@Nullable String s)
{    Option o = new Option(s, "output", true, "The output file to write");    o.setArgName("FILE");    o.setRequired(false);    return o;}
public Optional<Object> metron_f3879_0(SummarizeOptions option, CommandLine cli)
{    return Optional.ofNullable(option.get(cli));}
public String metron_f3880_0()
{    return "o";}
public void metron_f3882_0(Object obj, Optional<String> output, Configuration hadoopConfig) throws IOException
{    System.out.println(obj);}
public void metron_f3883_0(byte[] obj, Optional<String> output, Configuration hadoopConfig) throws IOException
{    System.out.println(SerDeUtils.fromBytes(obj, Object.class));}
public void metron_f3884_0(Optional<String> fileNameOptional, Configuration hadoopConfig) throws InvalidWriterOutput
{    if (!fileNameOptional.isPresent()) {        throw new InvalidWriterOutput("Filename is not present.");    }    String fileName = fileNameOptional.get();    if (StringUtils.isEmpty(fileName) || fileName.trim().equals(".") || fileName.trim().equals("..") || fileName.trim().endsWith("/")) {        throw new InvalidWriterOutput("Filename is empty or otherwise invalid.");    }}
public void metron_f3885_0(byte[] obj, Optional<String> output, Configuration hadoopConfig) throws IOException
{    FileSystem fs = FileSystem.get(hadoopConfig);    try (FSDataOutputStream stream = fs.create(new Path(output.get()))) {        IOUtils.write(obj, stream);        stream.flush();    }}
public void metron_f3886_0(Optional<String> fileNameOptional, Configuration hadoopConfig) throws InvalidWriterOutput
{    if (!fileNameOptional.isPresent()) {        throw new InvalidWriterOutput("Filename is not present.");    }    String fileName = fileNameOptional.get();    if (StringUtils.isEmpty(fileName) || fileName.trim().equals(".") || fileName.trim().equals("..") || fileName.trim().endsWith("/")) {        throw new InvalidWriterOutput("Filename is empty or otherwise invalid.");    }}
public void metron_f3887_0(byte[] obj, Optional<String> output, Configuration hadoopConfig) throws IOException
{    File outFile = new File(output.get());    if (!outFile.getParentFile().exists()) {        outFile.getParentFile().mkdirs();    }    try (FileOutputStream fs = new FileOutputStream(outFile)) {        IOUtils.write(obj, fs);        fs.flush();    }}
 void metron_f3888_0(Object obj, Optional<String> output, Configuration hadoopConfig) throws IOException
{    if (obj != null) {        write(SerDeUtils.toBytes(obj), output, hadoopConfig);    }}
public static Optional<Writers> metron_f3889_0(String strategyName)
{    if (strategyName == null) {        return Optional.empty();    }    for (Writers strategy : values()) {        if (strategy.name().equalsIgnoreCase(strategyName.trim())) {            return Optional.of(strategy);        }    }    return Optional.empty();}
public void metron_f3890_0(Optional<String> output, Configuration hadoopConf) throws InvalidWriterOutput
{    writer.validate(output, hadoopConf);}
public void metron_f3891_0(byte[] obj, Optional<String> output, Configuration hadoopConf) throws IOException
{    writer.write(obj, output, hadoopConf);}
public boolean metron_f3892_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f3893_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public String metron_f3894_0(CommandLine cli, String defaultValue)
{    return cli.getOptionValue(shortCode, defaultValue);}
public static CommandLine metron_f3895_0(CommandLineParser parser, String[] args)
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        System.exit(-1);        return null;    }}
public static void metron_f3896_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("MaxmindDbEnrichmentLoader", getOptions());}
public static Options metron_f3897_0()
{    Options ret = new Options();    for (MaxmindDbEnrichmentLoader.GeoEnrichmentOptions o : MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public Option metron_f3898_0(@Nullable String s)
{    return new Option(s, "help", false, "Generate Help screen");}
public Option metron_f3899_0(@Nullable String s)
{    Option o = new Option(s, "asn_url", true, "GeoIP URL - " + ASN_URL_DEFAULT);    o.setArgName("ASN_URL");    o.setRequired(false);    return o;}
public Option metron_f3900_0(@Nullable String s)
{    Option o = new Option(s, "geo_url", true, "GeoIP URL - defaults to " + GEO_CITY_URL_DEFAULT);    o.setArgName("GEO_URL");    o.setRequired(false);    return o;}
public Option metron_f3901_0(@Nullable String s)
{    Option o = new Option(s, "remote_dir", true, "HDFS directory to land formatted GeoLite2 City file - defaults to /apps/metron/geo/<epoch millis>/");    o.setArgName("REMOTE_DIR");    o.setRequired(false);    return o;}
public Option metron_f3902_0(@Nullable String s)
{    Option o = new Option(s, "remote_asn_dir", true, "HDFS directory to land formatted GeoLite2 ASN file - defaults to /apps/metron/asn/<epoch millis>/");    o.setArgName("REMOTE_DIR");    o.setRequired(false);    return o;}
public Option metron_f3903_0(@Nullable String s)
{    Option o = new Option(s, "retries", true, "Number of GeoLite2 database download retries, after an initial failure.");    o.setArgName("RETRIES");    o.setRequired(false);    return o;}
public Option metron_f3904_0(@Nullable String s)
{    Option o = new Option(s, "tmp_dir", true, "Directory for landing the temporary GeoLite2 data - defaults to /tmp");    o.setArgName("TMP_DIR");    o.setRequired(false);    return o;}
public Option metron_f3905_0(@Nullable String s)
{    Option o = new Option(s, "zk_quorum", true, "Zookeeper Quorum URL (zk1:port,zk2:port,...)");    o.setArgName("ZK_QUORUM");    o.setRequired(true);    return o;}
protected void metron_f3906_0(CommandLine cli) throws IOException
{        System.out.println("Retrieving GeoLite2 archive");    String geo_url = GeoEnrichmentOptions.GEO_URL.get(cli, GEO_CITY_URL_DEFAULT);    String asn_url = GeoEnrichmentOptions.ASN_URL.get(cli, ASN_URL_DEFAULT);        String tmpDir = GeoEnrichmentOptions.TMP_DIR.get(cli, "/tmp") + "/";    int numRetries = Integer.parseInt(GeoEnrichmentOptions.RETRIES.get(cli, DEFAULT_RETRIES));    File localGeoFile = null;    File localAsnFile = null;    try {        localGeoFile = downloadGeoFile(geo_url, tmpDir, numRetries);        localAsnFile = downloadGeoFile(asn_url, tmpDir, numRetries);    } catch (IllegalStateException ies) {        System.err.println("Failed to download geo db file. Aborting");        System.exit(5);    }        localGeoFile.deleteOnExit();    localAsnFile.deleteOnExit();    System.out.println("GeoIP files downloaded successfully");        String zookeeper = GeoEnrichmentOptions.ZK_QUORUM.get(cli);    long millis = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();    String hdfsGeoLoc = GeoEnrichmentOptions.REMOTE_GEO_DIR.get(cli, "/apps/metron/geo/" + millis);    System.out.println("Putting GeoLite City file into HDFS at: " + hdfsGeoLoc);        Path srcPath = new Path(localGeoFile.getAbsolutePath());    Path dstPath = new Path(hdfsGeoLoc);    putDbFile(srcPath, dstPath);    pushConfig(srcPath, dstPath, GeoLiteCityDatabase.GEO_HDFS_FILE, zookeeper);        String hdfsAsnLoc = GeoEnrichmentOptions.REMOTE_ASN_DIR.get(cli, "/apps/metron/asn/" + millis);    System.out.println("Putting ASN file into HDFS at: " + hdfsAsnLoc);        srcPath = new Path(localAsnFile.getAbsolutePath());    dstPath = new Path(hdfsAsnLoc);    putDbFile(srcPath, dstPath);    pushConfig(srcPath, dstPath, GeoLiteAsnDatabase.ASN_HDFS_FILE, zookeeper);    System.out.println("GeoLite2 file placement complete");    System.out.println("Successfully created and updated new GeoLite information");}
protected File metron_f3907_0(String urlStr, String tmpDir, int numRetries)
{    File localFile = null;    int attempts = 0;    boolean valid = false;    while (!valid && attempts <= numRetries) {        try {            URL url = new URL(urlStr);            localFile = new File(tmpDir + new File(url.getPath()).getName());            System.out.println("Downloading " + url.toString() + " to " + localFile.getAbsolutePath());            if (localFile.exists() && !localFile.delete()) {                System.err.println("File already exists locally and can't be deleted.  Please delete before continuing");                System.exit(3);            }            FileUtils.copyURLToFile(url, localFile, 5000, 10000);            if (!CompressionStrategies.GZIP.test(localFile)) {                throw new IOException("Invalid Gzip file");            } else {                valid = true;            }        } catch (MalformedURLException e) {            System.err.println("Malformed URL - aborting: " + e);            e.printStackTrace();            System.exit(4);        } catch (IOException e) {            System.err.println("Warning: Unable to copy remote GeoIP database to local file, attempt " + attempts + ": " + e);            e.printStackTrace();        }        attempts++;    }    if (!valid) {        System.err.println("Unable to copy remote GeoIP database to local file after " + attempts + " attempts");        throw new IllegalStateException("Unable to download geo enrichment database.");    }    return localFile;}
protected void metron_f3908_0(Path srcPath, Path dstPath, String configName, String zookeeper)
{    System.out.println("Beginning update of global configs");    try (CuratorFramework client = ConfigurationsUtils.getClient(zookeeper)) {        client.start();                        Map<String, Object> global = JSONUtils.INSTANCE.load(new ByteArrayInputStream(ConfigurationsUtils.readGlobalConfigBytesFromZookeeper(client)), JSONUtils.MAP_SUPPLIER);                global.put(configName, dstPath.toString() + "/" + srcPath.getName());        ConfigurationsUtils.writeGlobalConfigToZookeeper(global, client);    } catch (Exception e) {        System.err.println("Unable to load new GeoLite2 config for " + configName + " into HDFS: " + e);        e.printStackTrace();        System.exit(2);    }    System.out.println("Finished update of global configs");}
protected void metron_f3909_0(Path src, Path dst) throws IOException
{    Configuration conf = new Configuration();    FileSystem fileSystem = FileSystem.get(conf);    System.out.println("Putting: " + src + " onto HDFS at: " + dst);    fileSystem.mkdirs(dst);    fileSystem.copyFromLocalFile(true, true, src, dst);    System.out.println("Done putting GeoLite file into HDFS");}
public static void metron_f3910_0(String... argv) throws IOException
{    String[] otherArgs = new GenericOptionsParser(argv).getRemainingArgs();    CommandLine cli = GeoEnrichmentOptions.parse(new PosixParser(), otherArgs);    MaxmindDbEnrichmentLoader loader = new MaxmindDbEnrichmentLoader();    loader.loadGeoLiteDatabase(cli);}
public String metron_f3911_0()
{    return tableName;}
public String metron_f3912_0()
{    return columnFamily;}
public boolean metron_f3913_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    TableInfo tableInfo = (TableInfo) o;    if (getTableName() != null ? !getTableName().equals(tableInfo.getTableName()) : tableInfo.getTableName() != null)        return false;    return getColumnFamily() != null ? getColumnFamily().equals(tableInfo.getColumnFamily()) : tableInfo.getColumnFamily() == null;}
public int metron_f3914_0()
{    int result = getTableName() != null ? getTableName().hashCode() : 0;    result = 31 * result + (getColumnFamily() != null ? getColumnFamily().hashCode() : 0);    return result;}
public String metron_f3915_0()
{    return "TableInfo{" + "tableName='" + tableName + '\'' + ", columnFamily='" + columnFamily + '\'' + '}';}
public TaxiiConnectionConfig metron_f3916_0(List<String> indicatorTypes)
{    allowedIndicatorTypes = new HashSet(indicatorTypes);    return this;}
public TaxiiConnectionConfig metron_f3917_0(String table)
{    this.table = table;    return this;}
public TaxiiConnectionConfig metron_f3918_0(String cf)
{    this.columnFamily = cf;    return this;}
public TaxiiConnectionConfig metron_f3919_0(Date time)
{    this.beginTime = time;    return this;}
public TaxiiConnectionConfig metron_f3920_0(String subId)
{    this.subscriptionId = subId;    return this;}
public TaxiiConnectionConfig metron_f3921_0(String collection)
{    this.collection = collection;    return this;}
public TaxiiConnectionConfig metron_f3922_0(int port)
{    this.port = port;    return this;}
public TaxiiConnectionConfig metron_f3923_0(URL endpoint)
{    this.endpoint = endpoint;    return this;}
public TaxiiConnectionConfig metron_f3924_0(URL proxy)
{    this.proxy = proxy;    return this;}
public TaxiiConnectionConfig metron_f3925_0(String username)
{    this.username = username;    return this;}
public TaxiiConnectionConfig metron_f3926_0(String password)
{    this.password = password;    return this;}
public TaxiiConnectionConfig metron_f3927_0(ConnectionType type)
{    this.type = type;    return this;}
public void metron_f3928_0(String endpoint) throws MalformedURLException
{    this.endpoint = new URL(endpoint);}
public void metron_f3929_0(int port)
{    this.port = port;}
public void metron_f3930_0(String proxy) throws MalformedURLException
{    this.proxy = new URL(proxy);}
public void metron_f3931_0(String username)
{    this.username = username;}
public void metron_f3932_0(String password)
{    this.password = password;}
public void metron_f3933_0(ConnectionType type)
{    this.type = type;}
public void metron_f3934_0(String collection)
{    this.collection = collection;}
public void metron_f3935_0(String subscriptionId)
{    this.subscriptionId = subscriptionId;}
public void metron_f3936_0(String beginTime) throws ParseException
{    SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);    this.beginTime = sdf.parse(beginTime);}
public String metron_f3937_0()
{    return table;}
public void metron_f3938_0(String table)
{    this.table = table;}
public String metron_f3939_0()
{    return columnFamily;}
public void metron_f3940_0(String columnFamily)
{    this.columnFamily = columnFamily;}
public Date metron_f3941_0()
{    return beginTime;}
public int metron_f3942_0()
{    return port;}
public URL metron_f3943_0()
{    return endpoint;}
public URL metron_f3944_0()
{    return proxy;}
public String metron_f3945_0()
{    return username;}
public String metron_f3946_0()
{    return password;}
public ConnectionType metron_f3947_0()
{    return type;}
public String metron_f3948_0()
{    return collection;}
public String metron_f3949_0()
{    return subscriptionId;}
public void metron_f3950_0(List<String> allowedIndicatorTypes)
{    withAllowedIndicatorTypes(allowedIndicatorTypes);}
public Set<String> metron_f3951_0()
{    return allowedIndicatorTypes;}
public static synchronized TaxiiConnectionConfig metron_f3952_0(InputStream is) throws IOException
{    TaxiiConnectionConfig ret = _mapper.readValue(is, TaxiiConnectionConfig.class);    return ret;}
public static synchronized TaxiiConnectionConfig metron_f3953_0(String s, Charset c) throws IOException
{    return load(new ByteArrayInputStream(s.getBytes(c)));}
public static synchronized TaxiiConnectionConfig metron_f3954_0(String s) throws IOException
{    return load(s, Charset.defaultCharset());}
public String metron_f3955_0()
{    return "TaxiiConnectionConfig{" + "endpoint=" + endpoint + ", port=" + port + ", proxy=" + proxy + ", username='" + username + '\'' + ", password=" + (password == null ? "null" : "'******'") + ", type=" + type + ", allowedIndicatorTypes=" + Joiner.on(',').join(allowedIndicatorTypes) + ", collection='" + collection + '\'' + ", subscriptionId='" + subscriptionId + '\'' + ", beginTime=" + beginTime + ", table=" + table + ":" + columnFamily + '}';}
protected TaxiiXmlFactory metron_f3956_0()
{    return new TaxiiXmlFactory();}
protected ObjectFactory metron_f3957_0()
{    return new ObjectFactory();}
protected synchronized Table metron_f3958_0(String table) throws IOException
{    Table ret = connectionCache.get(table);    if (ret == null) {        ret = createHTable(table);        connectionCache.put(table, ret);    }    return ret;}
protected synchronized Table metron_f3959_0(String tableInfo) throws IOException
{    return new HTableProvider().getTable(config, tableInfo);}
public void metron_f3960_1()
{    if (inProgress) {        return;    }    Date ts = new Date();        try {        inProgress = true;                String sessionID = MessageHelper.generateMessageId();        PollRequest request = messageFactory.get().createPollRequest().withMessageId(sessionID).withCollectionName(collection);        if (subscriptionId != null) {            request = request.withSubscriptionID(subscriptionId);        } else {            request = request.withPollParameters(messageFactory.get().createPollParametersType());        }        if (beginTime != null) {            Calendar gc = GregorianCalendar.getInstance();            gc.setTime(beginTime);            XMLGregorianCalendar gTime = null;            try {                gTime = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) gc).normalize();            } catch (DatatypeConfigurationException e) {                RuntimeErrors.ILLEGAL_STATE.throwRuntime("Unable to set the begin time due to", e);            }            gTime.setFractionalSecond(null);                        request.setExclusiveBeginTimestamp(gTime);        }        try {            PollResponse response = call(request, PollResponse.class);                        int numProcessed = 0;            long avgTimeMS = 0;            long timeStartedBlock = System.currentTimeMillis();            for (ContentBlock block : response.getContentBlocks()) {                AnyMixedContentType content = block.getContent();                for (Object o : content.getContent()) {                    numProcessed++;                    long timeS = System.currentTimeMillis();                    String xml = null;                    if (o instanceof Element) {                        Element element = (Element) o;                        xml = getStringFromDocument(element.getOwnerDocument());                        if (LOG.isDebugEnabled() && Math.random() < 0.01) {                                                    }                        for (LookupKV<EnrichmentKey, EnrichmentValue> kv : extractor.extract(xml)) {                            if (allowedIndicatorTypes.isEmpty() || allowedIndicatorTypes.contains(kv.getKey().type)) {                                kv.getValue().getMetadata().put("source_type", "taxii");                                kv.getValue().getMetadata().put("taxii_url", endpoint.toString());                                kv.getValue().getMetadata().put("taxii_collection", collection);                                Put p = converter.toPut(columnFamily, kv.getKey(), kv.getValue());                                Table table = getTable(hbaseTable);                                table.put(p);                                                            }                        }                    }                    avgTimeMS += System.currentTimeMillis() - timeS;                }                if ((numProcessed + 1) % 100 == 0) {                                        timeStartedBlock = System.currentTimeMillis();                    avgTimeMS = 0;                    numProcessed = 0;                }            }        } catch (Exception e) {                        throw new RuntimeException("Unable to make request", e);        }    } finally {        inProgress = false;        beginTime = ts;    }}
public String metron_f3961_0(Document doc)
{    try {        DOMSource domSource = new DOMSource(doc);        StringWriter writer = new StringWriter();        StreamResult result = new StreamResult(writer);        TransformerFactory tf = TransformerFactory.newInstance();        tf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);        Transformer transformer = tf.newTransformer();        transformer.transform(domSource, result);        return writer.toString();    } catch (TransformerException ex) {        ex.printStackTrace();        return null;    }}
private RESPONSE_T metron_f3962_0(Object request, Class<RESPONSE_T> responseClazz) throws Exception
{    HttpClient taxiiClient = buildClient(proxy, username, password);    return call(taxiiClient, endpoint.toURI(), request, context, responseClazz);}
private void metron_f3963_1(TaxiiConnectionConfig config) throws Exception
{        if (context == null) {        context = createContext(config.getEndpoint(), config.getUsername(), config.getPassword(), config.getPort());    }    URL endpoint = config.getEndpoint();    if (config.getType() == ConnectionType.DISCOVER) {                endpoint = discoverPollingClient(config.getProxy(), endpoint, config.getUsername(), config.getPassword(), context, collection).pollEndpoint;        this.endpoint = endpoint;            }}
private static HttpClientContext metron_f3965_0(URL endpoint, String username, String password, int port)
{    HttpClientContext context = null;    HttpHost target = new HttpHost(endpoint.getHost(), port, endpoint.getProtocol());    if (username != null && password != null) {        CredentialsProvider credsProvider = new BasicCredentialsProvider();        credsProvider.setCredentials(new AuthScope(target.getHostName(), target.getPort()), new UsernamePasswordCredentials(username, password));                AuthCache authCache = new BasicAuthCache();        authCache.put(target, new BasicScheme());                context = HttpClientContext.create();        context.setCredentialsProvider(credsProvider);        context.setAuthCache(authCache);    } else {        context = null;    }    return context;}
public static RESPONSE_T metron_f3966_1(HttpClient taxiiClient, URI endpoint, REQUEST_T request, HttpClientContext context, Class<RESPONSE_T> responseClazz) throws JAXBException, IOException
{    Object responseObj = taxiiClient.callTaxiiService(endpoint, request, context);        try {        return responseClazz.cast(responseObj);    } catch (ClassCastException cce) {        TaxiiXml taxiiXml = xmlFactory.get().createTaxiiXml();        String resp = taxiiXml.marshalToString(responseObj, true);        String msg = "Didn't return the response we expected: " + responseObj.getClass() + " \n" + resp;                throw new RuntimeException(msg, cce);    }}
private static HttpClient metron_f3967_0(URL proxy, String username, String password) throws Exception
{        HttpClient client = new HttpClient();        HttpClientBuilder builder = HttpClientBuilder.create().useSystemProperties();        if (proxy != null) {        HttpHost proxyHost = new HttpHost(proxy.getHost(), proxy.getPort(), proxy.getProtocol());        builder.setProxy(proxyHost);    }        if (username != null ^ password != null) {        throw new Exception("'username' and 'password' arguments are required to appear together.");    }        SSLContextBuilder ssbldr = new SSLContextBuilder();    ssbldr.loadTrustMaterial(null, new TrustSelfSignedStrategy());    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ssbldr.build(), SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);    Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", new PlainConnectionSocketFactory()).register("https", sslsf).build();    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);        cm.setMaxTotal(20);        System.setProperty("jsse.enableSNIExtension", "false");    CloseableHttpClient httpClient = builder.setSSLSocketFactory(sslsf).setConnectionManager(cm).build();    client.setHttpclient(httpClient);    return client;}
public boolean metron_f3968_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f3969_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public static CommandLine metron_f3970_0(CommandLineParser parser, String[] args)
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (TaxiiOptions.HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        System.exit(-1);        return null;    }}
public static void metron_f3971_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("TaxiiLoader", getOptions());}
public static Options metron_f3972_0()
{    Options ret = new Options();    for (TaxiiOptions o : TaxiiOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public Option metron_f3973_0(@Nullable String s)
{    return new Option(s, "help", false, "Generate Help screen");}
public Option metron_f3974_0(@Nullable String s)
{    Option o = new Option(s, "extractor_config", true, "JSON Document describing the extractor for this input data source");    o.setArgName("JSON_FILE");    o.setRequired(true);    return o;}
public Option metron_f3975_0(@Nullable String s)
{    Option o = new Option(s, "taxii_connection_config", true, "The JSON config file to configure the connection");    o.setArgName("config_file");    o.setRequired(true);    return o;}
public Option metron_f3976_0(@Nullable String s)
{    Option o = new Option(s, "time_between_polls", true, "The time between polls (in ms)");    o.setArgName("MS");    o.setRequired(false);    return o;}
public Option metron_f3977_0(@Nullable String s)
{    Option o = new Option(s, "begin_time", true, "Start time to poll the Taxii server (all data from that point will be gathered in the first pull).");    o.setArgName(DATE_FORMAT.toPattern());    o.setRequired(false);    return o;}
public Option metron_f3978_0(@Nullable String s)
{    Option o = new Option(s, "log4j", true, "The log4j properties file to load");    o.setArgName("FILE");    o.setRequired(false);    return o;}
public Option metron_f3979_0(@Nullable String s)
{    Option o = new Option(s, "enrichment_config", true, "JSON Document describing the enrichment configuration details." + "  This is used to associate an enrichment type with a field type in zookeeper.");    o.setArgName("JSON_FILE");    o.setRequired(false);    return o;}
public static boolean metron_f3980_0(Extractor e)
{    if (e instanceof StixExtractor || (e instanceof ExtractorDecorator && ((ExtractorDecorator) e).getUnderlyingExtractor() instanceof StixExtractor)) {        return true;    } else {        return false;    }}
public static void metron_f3981_0(String... argv) throws Exception
{    Configuration conf = HBaseConfiguration.create();    String zkQuorum = conf.get(HConstants.ZOOKEEPER_QUORUM);    String[] otherArgs = new GenericOptionsParser(conf, argv).getRemainingArgs();    CommandLine cli = TaxiiOptions.parse(new PosixParser(), otherArgs);    if (TaxiiOptions.LOG4J_PROPERTIES.has(cli)) {        PropertyConfigurator.configure(TaxiiOptions.LOG4J_PROPERTIES.get(cli));    }    ExtractorHandler handler = ExtractorHandler.load(FileUtils.readFileToString(new File(TaxiiOptions.EXTRACTOR_CONFIG.get(cli))));    Extractor e = handler.getExtractor();    SensorEnrichmentUpdateConfig sensorEnrichmentUpdateConfig = null;    if (TaxiiOptions.ENRICHMENT_CONFIG.has(cli)) {        sensorEnrichmentUpdateConfig = JSONUtils.INSTANCE.load(new File(TaxiiOptions.ENRICHMENT_CONFIG.get(cli)), SensorEnrichmentUpdateConfig.class);        sensorEnrichmentUpdateConfig.updateSensorConfigs();    }    Timer timer = new Timer();    if (isStixExtractor(e)) {        Extractor extractor = e;        TaxiiConnectionConfig connectionConfig = TaxiiConnectionConfig.load(FileUtils.readFileToString(new File(TaxiiOptions.CONNECTION_CONFIG.get(cli))));        if (TaxiiOptions.BEGIN_TIME.has(cli)) {            Date d = DATE_FORMAT.parse(TaxiiOptions.BEGIN_TIME.get(cli));            connectionConfig.withBeginTime(d);        }        long timeBetween = DEFAULT_TIME_BETWEEN_POLLS;        if (TaxiiOptions.TIME_BETWEEN_POLLS.has(cli)) {            timeBetween = Long.parseLong(TaxiiOptions.TIME_BETWEEN_POLLS.get(cli));        }        timer.scheduleAtFixedRate(new TaxiiHandler(connectionConfig, extractor, conf), 0, timeBetween);    } else {        throw new IllegalStateException("Extractor must be a STIX Extractor");    }}
public static void metron_f3982_0() throws Exception
{    if (dataPath.isDirectory()) {        dataPath.delete();    }    if (!dataPath.mkdirs()) {        throw new RuntimeException("Couldn't create dataPath at: " + dataPath.getAbsolutePath());    }    dataPath.deleteOnExit();}
public void metron_f3983_0() throws Exception
{    Calendar today = Calendar.getInstance();    today.clear(Calendar.HOUR);    today.clear(Calendar.MINUTE);    today.clear(Calendar.SECOND);    todaysDate = today.getTime();    yesterday.setTime(todaysDate.getTime() - TimeUnit.DAYS.toMillis(1));}
public void metron_f3984_0() throws Exception
{    HDFSDataPruner pruner = new HDFSDataPruner(todaysDate, 30, "file:///", dataPath.getAbsolutePath() + "/file-*");}
public void metron_f3985_0() throws Exception
{    createTestFiles();    HDFSDataPruner pruner = new HDFSDataPruner(yesterday, 30, "file:///", dataPath.getAbsolutePath() + "/file-*");    Long prunedCount = pruner.prune();    assertTrue("Should have pruned 45 files- pruned: " + prunedCount, 45 == prunedCount);    File[] filesLeft = dataPath.listFiles();    File[] filesList = new File[filesLeft.length];    for (int i = 0; i < 5; i++) {        filesList[i] = new File(dataPath.getPath() + "//file-" + String.format("%02d", i));    }    Arrays.sort(filesLeft);    assertArrayEquals("First four files should have been left behind", filesLeft, filesList);}
public void metron_f3986_0() throws Exception
{    FileSystem testFS = mock(FileSystem.class);    when(testFS.isDirectory(any())).thenThrow(new IOException("Test Exception"));    HDFSDataPruner pruner = new HDFSDataPruner(yesterday, 30, "file:///", dataPath.getAbsolutePath() + "/file-*");    pruner.fileSystem = testFS;    HDFSDataPruner.DateFileFilter filter = new HDFSDataPruner.DateFileFilter(pruner, true);    UnitTestHelper.setLog4jLevel(HDFSDataPruner.class, Level.FATAL);    try {        filter.accept(new Path("foo"));        Assert.fail("Expected Runtime exception, but did not receive one.");    } catch (RuntimeException e) {    }    UnitTestHelper.setLog4jLevel(HDFSDataPruner.class, Level.ERROR);}
public void metron_f3987_0() throws Exception
{    FileSystem testFS = mock(FileSystem.class);    when(testFS.isDirectory(any())).thenReturn(true);    HDFSDataPruner pruner = new HDFSDataPruner(yesterday, 30, "file:///", dataPath.getAbsolutePath() + "/file-*");    pruner.fileSystem = testFS;    HDFSDataPruner.DateFileFilter filter = new HDFSDataPruner.DateFileFilter(pruner, false);    assertFalse("Should ignore directories", filter.accept(new Path("/tmp")));}
public void metron_f3988_0() throws Exception
{    FileSystem testFS = mock(FileSystem.class);    when(testFS.isDirectory(any())).thenReturn(false);    when(testFS.getFileStatus(any())).thenThrow(new IOException("Test Exception"));    HDFSDataPruner pruner = new HDFSDataPruner(yesterday, 30, "file:///", dataPath.getAbsolutePath() + "/file-*");    pruner.fileSystem = testFS;    HDFSDataPruner.DateFileFilter filter = new HDFSDataPruner.DateFileFilter(pruner, true);    UnitTestHelper.setLog4jLevel(HDFSDataPruner.class, Level.FATAL);    try {        filter.accept(new Path("foo"));        Assert.fail("Expected Runtime exception, but did not receive one.");    } catch (RuntimeException e) {    }    UnitTestHelper.setLog4jLevel(HDFSDataPruner.class, Level.ERROR);}
private void metron_f3989_0() throws IOException
{        for (int i = 0; i < 50; i++) {        File file = new File(dataPath.getAbsolutePath() + "//file-" + String.format("%02d", i));        file.createNewFile();        file.deleteOnExit();    }        for (int i = 5; i < 25; i++) {        File file = new File(dataPath.getAbsolutePath() + "//file-" + String.format("%02d", i));        file.setLastModified(todaysDate.getTime() - TimeUnit.DAYS.toMillis(1));        file.deleteOnExit();    }        for (int i = 25; i < 40; i++) {        File file = new File(dataPath.getAbsolutePath() + "//file-" + String.format("%02d", i));        file.setLastModified(todaysDate.getTime() - TimeUnit.DAYS.toMillis(10));        file.deleteOnExit();    }        for (int i = 40; i < 50; i++) {        File file = new File(dataPath.getAbsolutePath() + "//file-" + String.format("%02d", i));        file.setLastModified(todaysDate.getTime() - TimeUnit.DAYS.toMillis(20));        file.deleteOnExit();    }}
public void metron_f3990_0() throws Exception
{    CSVExtractor ex = new CSVExtractor();    ExtractorHandler handler = ExtractorHandler.load(testCSVConfig);    ex.initialize(handler.getConfig());    Assert.assertEquals(0, (int) ex.getColumnMap().get("host"));    Assert.assertEquals(2, (int) ex.getColumnMap().get("meta"));    Assert.assertEquals(0, ex.getTypeColumnIndex());    Assert.assertEquals(0, ex.getIndicatorColumn());    Assert.assertEquals("threat", ex.getType());    Assert.assertEquals(',', ex.getParser().getSeparator());}
public void metron_f3991_0() throws Exception
{    ExtractorHandler handler = ExtractorHandler.load(testCSVConfig);    validate(handler);}
public void metron_f3992_0(ExtractorHandler handler) throws IOException
{    {        LookupKV results = Iterables.getFirst(handler.getExtractor().extract("google.com,1.0,foo"), null);        EnrichmentKey key = (EnrichmentKey) results.getKey();        EnrichmentValue value = (EnrichmentValue) results.getValue();        Assert.assertEquals("google.com", key.indicator);        Assert.assertEquals("threat", key.type);        Assert.assertEquals("google.com", value.getMetadata().get("host"));        Assert.assertEquals("foo", value.getMetadata().get("meta"));        Assert.assertEquals(2, value.getMetadata().size());    }    {        Iterable<LookupKV> results = handler.getExtractor().extract("#google.com,1.0,foo");        Assert.assertEquals(0, Iterables.size(results));    }    {        Iterable<LookupKV> results = handler.getExtractor().extract("");        Assert.assertEquals(0, Iterables.size(results));    }    {        Iterable<LookupKV> results = handler.getExtractor().extract(" ");        Assert.assertEquals(0, Iterables.size(results));    }    {        Iterable<LookupKV> results = handler.getExtractor().extract(null);        Assert.assertEquals(0, Iterables.size(results));    }}
public void metron_f3993_0()
{    MockitoAnnotations.initMocks(this);}
public void metron_f3994_0()
{    ExtractorDecorator decorator = new ExtractorDecorator(extractor);    Assert.assertThat(decorator.decoratedExtractor, notNullValue());}
public void metron_f3995_0() throws IOException
{    ExtractorDecorator decorator = new ExtractorDecorator(extractor);    decorator.initialize(new HashMap());    decorator.extract("line");    verify(extractor).initialize(isA(Map.class));    verify(extractor).extract("line");}
public Iterable<LookupKV> metron_f3996_0(String line) throws IOException
{    EnrichmentKey key = new EnrichmentKey();    key.indicator = "dummy";    key.type = "type";    Map<String, Object> value = new HashMap<>();    value.put("indicator", "dummy");    return Arrays.asList(new LookupKV(key, new EnrichmentValue(value)));}
public void metron_f3998_0() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException, NoSuchMethodException, InvocationTargetException
{    Extractor extractor = Extractors.create(DummyExtractor.class.getName());    LookupKV results = Iterables.getFirst(extractor.extract(null), null);    EnrichmentKey key = (EnrichmentKey) results.getKey();    EnrichmentValue value = (EnrichmentValue) results.getValue();    Assert.assertEquals("dummy", key.indicator);    Assert.assertEquals("type", key.type);    Assert.assertEquals("dummy", value.getMetadata().get("indicator"));}
public void metron_f3999_0() throws Exception
{    /**     *         config:     *         {     *            "config" : {}     *            ,"extractor" : "org.apache.metron.dataloads.extractor.ExtractorTest$DummyExtractor"     *         }     */    String config = "{\n" + "            \"config\" : {}\n" + "            ,\"extractor\" : \"org.apache.metron.dataloads.extractor.ExtractorTest$DummyExtractor\"\n" + "         }";    ExtractorHandler handler = ExtractorHandler.load(config);    LookupKV results = Iterables.getFirst(handler.getExtractor().extract(null), null);    EnrichmentKey key = (EnrichmentKey) results.getKey();    EnrichmentValue value = (EnrichmentValue) results.getValue();    Assert.assertEquals("dummy", key.indicator);    Assert.assertEquals("type", key.type);    Assert.assertEquals("dummy", value.getMetadata().get("indicator"));}
public void metron_f4000_0() throws IOException
{    stixDoc = Joiner.on("\n").join(IOUtils.readLines(new InputStreamReader(new FileInputStream(new File("src/test/resources/stix_example.xml")), StandardCharsets.UTF_8)));    stixDocWithoutCondition = Joiner.on("\n").join(IOUtils.readLines(new InputStreamReader(new FileInputStream(new File("src/test/resources/stix_example_wo_conditions.xml")), StandardCharsets.UTF_8)));}
public void metron_f4001_0() throws Exception
{    testStixAddresses(stixDoc);}
public void metron_f4002_0() throws Exception
{    testStixAddresses(stixDocWithoutCondition);}
public void metron_f4003_0(final String stixDoc) throws Exception
{    Thread t1 = new Thread(() -> {        try {            ExtractorHandler handler = ExtractorHandler.load(stixConfigOnlyIPV4);            Extractor extractor = handler.getExtractor();            Iterable<LookupKV> results = extractor.extract(stixDoc);            Assert.assertEquals(3, Iterables.size(results));            Assert.assertEquals("10.0.0.0", ((EnrichmentKey) (Iterables.get(results, 0).getKey())).indicator);            Assert.assertEquals("10.0.0.1", ((EnrichmentKey) (Iterables.get(results, 1).getKey())).indicator);            Assert.assertEquals("10.0.0.2", ((EnrichmentKey) (Iterables.get(results, 2).getKey())).indicator);        } catch (Exception ex) {            throw new RuntimeException(ex.getMessage(), ex);        }    });    Thread t2 = new Thread(() -> {        try {            ExtractorHandler handler = ExtractorHandler.load(stixConfig);            Extractor extractor = handler.getExtractor();            Iterable<LookupKV> results = extractor.extract(stixDoc);            Assert.assertEquals(3, Iterables.size(results));            Assert.assertEquals("10.0.0.0", ((EnrichmentKey) (Iterables.get(results, 0).getKey())).indicator);            Assert.assertEquals("10.0.0.1", ((EnrichmentKey) (Iterables.get(results, 1).getKey())).indicator);            Assert.assertEquals("10.0.0.2", ((EnrichmentKey) (Iterables.get(results, 2).getKey())).indicator);        } catch (Exception ex) {            throw new RuntimeException(ex.getMessage(), ex);        }    });    Thread t3 = new Thread(() -> {        try {            ExtractorHandler handler = ExtractorHandler.load(stixConfigOnlyIPV6);            Extractor extractor = handler.getExtractor();            Iterable<LookupKV> results = extractor.extract(stixDoc);            Assert.assertEquals(0, Iterables.size(results));        } catch (Exception ex) {            throw new RuntimeException(ex.getMessage(), ex);        }    });    t1.run();    t2.run();    t3.run();    t1.join();    t2.join();    t3.join();}
public void metron_f4004_0() throws Exception
{    StixExtractor extractor = new StixExtractor();    extractor.initialize(new HashMap<>());    Iterable<LookupKV> kvs = extractor.extract(uriHandlerObject);    Assert.assertEquals(1, Iterables.size(kvs));    LookupKV kv = Iterables.getFirst(kvs, null);    EnrichmentKey key = (EnrichmentKey) kv.getKey();    Assert.assertEquals("http://www.kotimi.com/alpha/gtex/", key.getIndicator());    Assert.assertEquals("uriobjecttype", key.type);}
public void metron_f4005_0() throws Exception
{    MockitoAnnotations.initMocks(this);    config1 = new ObjectMapper().readValue(config1Contents, LinkedHashMap.class);    decorator = new TransformFilterExtractorDecorator(extractor);    decorator.setZkClient(Optional.of(zkClient));    decorator.initialize(config1);}
public void metron_f4006_0() throws IOException
{    final String indicatorVal = "val2";    EnrichmentKey lookupKey = new EnrichmentKey("testenrichment", indicatorVal);    EnrichmentValue lookupValue = new EnrichmentValue(new HashMap<String, Object>() {        {            put("foo", "val1");            put("bar", indicatorVal);            put("baz", "val3");        }    });    LookupKV lkv = new LookupKV<>(lookupKey, lookupValue);    List<LookupKV> extractedLkvs = new ArrayList<>();    extractedLkvs.add(lkv);    Mockito.when(extractor.extract("val1,val2,val3")).thenReturn(extractedLkvs);    Iterable<LookupKV> extracted = decorator.extract("val1,val2,val3");    EnrichmentKey expectedLookupKey = new EnrichmentKey("testenrichment", "VAL2");    EnrichmentValue expectedLookupValue = new EnrichmentValue(new HashMap<String, Object>() {        {            put("foo", "VAL1");            put("bar", "val2");            put("baz", "val3");            put("newvar", "VAL1");            put("lowernewvar", "val1");        }    });    LookupKV expectedLkv = new LookupKV<>(expectedLookupKey, expectedLookupValue);    List<LookupKV> expectedLkvs = new ArrayList<>();    expectedLkvs.add(expectedLkv);    Assert.assertThat(extracted, CoreMatchers.equalTo(expectedLkvs));}
public void metron_f4007_0() throws Exception
{    final String indicatorVal = "val2";    EnrichmentKey lookupKey = new EnrichmentKey("testenrichment", indicatorVal);    EnrichmentValue lookupValue = new EnrichmentValue(new HashMap<String, Object>() {        {            put("foo", "val1");            put("bar", indicatorVal);            put("baz", "");        }    });    LookupKV lkv = new LookupKV<>(lookupKey, lookupValue);    List<LookupKV> extractedLkvs = new ArrayList<>();    extractedLkvs.add(lkv);    Mockito.when(extractor.extract("val1,val2,")).thenReturn(extractedLkvs);    Iterable<LookupKV> extracted = decorator.extract("val1,val2,");    Assert.assertThat(extracted, CoreMatchers.equalTo(new ArrayList<>()));}
public void metron_f4008_0() throws Exception
{    EnrichmentKey lookupKey = new EnrichmentKey("testenrichment", "");    EnrichmentValue lookupValue = new EnrichmentValue(new HashMap<String, Object>() {        {            put("foo", "val1");            put("bar", "");            put("baz", "val3");        }    });    LookupKV lkv = new LookupKV<>(lookupKey, lookupValue);    List<LookupKV> extractedLkvs = new ArrayList<>();    extractedLkvs.add(lkv);    Mockito.when(extractor.extract("val1,,val3")).thenReturn(extractedLkvs);    Iterable<LookupKV> extracted = decorator.extract("val1,,val3");    Assert.assertThat(extracted, CoreMatchers.equalTo(new ArrayList<>()));}
public void metron_f4009_0() throws Exception
{    final int badValue = 5;    exception.expect(ClassCastException.class);    config1.put(TransformFilterExtractorDecorator.ExtractorOptions.VALUE_TRANSFORM.toString(), badValue);    decorator = new TransformFilterExtractorDecorator(extractor);    decorator.setZkClient(Optional.of(zkClient));    decorator.initialize(config1);}
public void metron_f4010_0() throws Exception
{    final int badValue = 5;    exception.expect(ClassCastException.class);    config1.put(TransformFilterExtractorDecorator.ExtractorOptions.VALUE_FILTER.toString(), badValue);    decorator = new TransformFilterExtractorDecorator(extractor);    decorator.setZkClient(Optional.of(zkClient));    decorator.initialize(config1);}
public void metron_f4011_0() throws Exception
{    final int badValue = 5;    exception.expect(ClassCastException.class);    config1.put(TransformFilterExtractorDecorator.ExtractorOptions.INDICATOR_TRANSFORM.toString(), badValue);    decorator = new TransformFilterExtractorDecorator(extractor);    decorator.setZkClient(Optional.of(zkClient));    decorator.initialize(config1);}
public void metron_f4012_0() throws Exception
{    final int badValue = 5;    exception.expect(ClassCastException.class);    config1.put(TransformFilterExtractorDecorator.ExtractorOptions.INDICATOR_FILTER.toString(), badValue);    decorator = new TransformFilterExtractorDecorator(extractor);    decorator.setZkClient(Optional.of(zkClient));    decorator.initialize(config1);}
public void metron_f4013_0()
{    byte[] raw = key.toBytes();    Assert.assertArrayEquals(raw, keyBytes);}
public void metron_f4014_0()
{    byte[] serialized = key.toBytes();    EnrichmentKey deserialized = new EnrichmentKey();    deserialized.fromBytes(serialized);    Assert.assertEquals(key, deserialized);}
public void metron_f4015_0() throws IOException
{    HbaseConverter<EnrichmentKey, EnrichmentValue> converter = new EnrichmentConverter();    Put put = converter.toPut("cf", key, value);    LookupKV<EnrichmentKey, EnrichmentValue> converted = converter.fromPut(put, "cf");    Assert.assertEquals(results, converted);}
public void metron_f4016_0() throws IOException
{    HbaseConverter<EnrichmentKey, EnrichmentValue> converter = new EnrichmentConverter();    Result r = converter.toResult("cf", key, value);    LookupKV<EnrichmentKey, EnrichmentValue> converted = converter.fromResult(r, "cf");    Assert.assertEquals(results, converted);}
public void metron_f4017_0() throws Exception
{    HbaseConverter<EnrichmentKey, EnrichmentValue> converter = new EnrichmentConverter();    Get get = converter.toGet("cf", key);    Assert.assertArrayEquals(key.toBytes(), get.getRow());}
public void metron_f4018_0() throws IOException, InterruptedException
{    final Map<ImmutableBytesWritable, Put> puts = new HashMap<>();    BulkLoadMapper mapper = new BulkLoadMapper() {        @Override        protected void write(ImmutableBytesWritable key, Put value, Context context) throws IOException, InterruptedException {            puts.put(key, value);        }    };    mapper.initialize(new Configuration() {        {            set(BulkLoadMapper.COLUMN_FAMILY_KEY, "cf");            set(BulkLoadMapper.CONFIG_KEY, extractorConfig);            set(BulkLoadMapper.LAST_SEEN_KEY, "0");            set(BulkLoadMapper.CONVERTER_KEY, EnrichmentConverter.class.getName());        }    });    {        mapper.map(null, new Text("#google.com,1,foo"), null);        Assert.assertTrue(puts.size() == 0);    }    {        mapper.map(null, new Text("google.com,1,foo"), null);        Assert.assertTrue(puts.size() == 1);        EnrichmentKey expectedKey = new EnrichmentKey() {            {                indicator = "google.com";                type = "threat";            }        };        EnrichmentConverter converter = new EnrichmentConverter();        Put put = puts.get(new ImmutableBytesWritable(expectedKey.toBytes()));        Assert.assertNotNull(puts);        LookupKV<EnrichmentKey, EnrichmentValue> results = converter.fromPut(put, "cf");        Assert.assertEquals(results.getKey().indicator, "google.com");        Assert.assertEquals(results.getValue().getMetadata().size(), 2);        Assert.assertEquals(results.getValue().getMetadata().get("meta"), "foo");        Assert.assertEquals(results.getValue().getMetadata().get("host"), "google.com");    }}
protected void metron_f4019_0(ImmutableBytesWritable key, Put value, Context context) throws IOException, InterruptedException
{    puts.put(key, value);}
public Map.Entry<HBaseTestingUtility, Configuration> metron_f4020_0(boolean startMRCluster) throws Exception
{    return create(startMRCluster, null);}
public Map.Entry<HBaseTestingUtility, Configuration> metron_f4021_0(boolean startMRCluster, Configuration extraConfig) throws Exception
{    Configuration config = HBaseConfiguration.create();    config.set("hbase.master.hostname", "localhost");    config.set("hbase.regionserver.hostname", "localhost");    if (null != extraConfig) {        for (Entry<String, String> entry : extraConfig) {            config.set(entry.getKey(), entry.getValue());        }    }    HBaseTestingUtility testUtil = new HBaseTestingUtility(config);    testUtil.startMiniCluster(1);    if (startMRCluster) {        testUtil.startMiniMapReduceCluster();    }    return new AbstractMap.SimpleEntry<>(testUtil, config);}
public void metron_f4022_0(String contents, Path filename, FileSystem fs) throws IOException
{    FSDataOutputStream os = fs.create(filename, true);    PrintWriter pw = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));    pw.print(contents);    pw.flush();    os.close();}
public String metron_f4023_0(FileSystem fs, Path filename) throws IOException
{    FSDataInputStream in = fs.open(filename);    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));    List<String> contents = new ArrayList<>();    for (String line = null; (line = br.readLine()) != null; ) {        contents.add(line);    }    return Joiner.on('\n').join(contents);}
public void metron_f4024_0(HBaseTestingUtility testUtil) throws Exception
{    testUtil.shutdownMiniMapReduceCluster();    testUtil.shutdownMiniCluster();    testUtil.cleanupTestDir();}
public static void metron_f4025_0() throws Exception
{    UnitTestHelper.setJavaLoggingLevel(Level.SEVERE);    Map.Entry<HBaseTestingUtility, Configuration> kv = HBaseUtil.INSTANCE.create(true);    config = kv.getValue();    testUtil = kv.getKey();    testTable = testUtil.createTable(Bytes.toBytes(tableName), Bytes.toBytes(cf));    atTable = testUtil.createTable(Bytes.toBytes(atTableName), Bytes.toBytes(atCF));}
public static void metron_f4026_0() throws Exception
{    HBaseUtil.INSTANCE.teardown(testUtil);}
public List<LookupKey> metron_f4027_0(int start, int end)
{    List<LookupKey> keys = new ArrayList<>();    for (int i = start; i < end; ++i) {        keys.add(new EnrichmentKey("type", "key-" + i));    }    return keys;}
public void metron_f4028_0() throws Exception
{    Configuration conf = HBaseConfiguration.create();    String[] argv = { "-a 04/14/2016 12:00:00", "-f cf", "-t malicious_domains", "-u access_trackers", "-v georgia", "-z cf" };    String[] otherArgs = new GenericOptionsParser(conf, argv).getRemainingArgs();    CommandLine cli = LeastRecentlyUsedPruner.BulkLoadOptions.parse(new PosixParser(), otherArgs);    Assert.assertEquals(cf, LeastRecentlyUsedPruner.BulkLoadOptions.COLUMN_FAMILY.get(cli).trim());    Assert.assertEquals(tableName, LeastRecentlyUsedPruner.BulkLoadOptions.TABLE.get(cli).trim());    Assert.assertEquals(atTableName, LeastRecentlyUsedPruner.BulkLoadOptions.ACCESS_TABLE.get(cli).trim());    Assert.assertEquals(atCF, LeastRecentlyUsedPruner.BulkLoadOptions.ACCESS_COLUMN_FAMILY.get(cli).trim());    Assert.assertEquals(beginTime, LeastRecentlyUsedPruner.BulkLoadOptions.AS_OF_TIME.get(cli).trim());    Assert.assertEquals(timeFormat, LeastRecentlyUsedPruner.BulkLoadOptions.AS_OF_TIME_FORMAT.get(cli).trim());}
public void metron_f4029_0() throws Exception
{    long ts = System.currentTimeMillis();    BloomAccessTracker bat = new BloomAccessTracker("tracker1", 100, 0.03);    PersistentAccessTracker pat = new PersistentAccessTracker(tableName, "0", atTable, atCF, bat, 0L);    EnrichmentLookup lookup = new EnrichmentLookup(testTable, cf, pat);    List<LookupKey> goodKeysHalf = getKeys(0, 5);    List<LookupKey> goodKeysOtherHalf = getKeys(5, 10);    Iterable<LookupKey> goodKeys = Iterables.concat(goodKeysHalf, goodKeysOtherHalf);    List<LookupKey> badKey = getKeys(10, 11);    EnrichmentConverter converter = new EnrichmentConverter();    for (LookupKey k : goodKeysHalf) {        testTable.put(converter.toPut(cf, (EnrichmentKey) k, new EnrichmentValue(new HashMap<String, Object>() {            {                put("k", "dummy");            }        })));        Assert.assertTrue(lookup.exists((EnrichmentKey) k, new EnrichmentLookup.HBaseContext(testTable, cf), true));    }    pat.persist(true);    for (LookupKey k : goodKeysOtherHalf) {        testTable.put(converter.toPut(cf, (EnrichmentKey) k, new EnrichmentValue(new HashMap<String, Object>() {            {                put("k", "dummy");            }        })));        Assert.assertTrue(lookup.exists((EnrichmentKey) k, new EnrichmentLookup.HBaseContext(testTable, cf), true));    }    testUtil.flush();    Assert.assertFalse(lookup.getAccessTracker().hasSeen(goodKeysHalf.get(0)));    for (LookupKey k : goodKeysOtherHalf) {        Assert.assertTrue(lookup.getAccessTracker().hasSeen(k));    }    pat.persist(true);    {        testTable.put(converter.toPut(cf, (EnrichmentKey) badKey.get(0), new EnrichmentValue(new HashMap<String, Object>() {            {                put("k", "dummy");            }        })));    }    testUtil.flush();    Assert.assertFalse(lookup.getAccessTracker().hasSeen(badKey.get(0)));    Job job = LeastRecentlyUsedPruner.createJob(config, tableName, cf, atTableName, atCF, ts);    Assert.assertTrue(job.waitForCompletion(true));    for (LookupKey k : goodKeys) {        Assert.assertTrue(lookup.exists((EnrichmentKey) k, new EnrichmentLookup.HBaseContext(testTable, cf), true));    }    for (LookupKey k : badKey) {        Assert.assertFalse(lookup.exists((EnrichmentKey) k, new EnrichmentLookup.HBaseContext(testTable, cf), true));    }}
public static void metron_f4030_0() throws Exception
{    UnitTestHelper.setJavaLoggingLevel(Level.SEVERE);    Map.Entry<HBaseTestingUtility, Configuration> kv = HBaseUtil.INSTANCE.create(true);    config = kv.getValue();    testUtil = kv.getKey();    testTable = testUtil.createTable(Bytes.toBytes(tableName), Bytes.toBytes(cf));    zookeeperUrl = getZookeeperUrl(config.get("hbase.zookeeper.quorum"), testUtil.getZkCluster().getClientPort());    setupGlobalConfig(zookeeperUrl);    for (Result r : testTable.getScanner(Bytes.toBytes(cf))) {        Delete d = new Delete(r.getRow());        testTable.delete(d);    }    if (lineByLineExtractorConfigFile.exists()) {        lineByLineExtractorConfigFile.delete();    }    Files.write(lineByLineExtractorConfigFile.toPath(), lineByLineExtractorConfig.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    if (wholeFileExtractorConfigFile.exists()) {        wholeFileExtractorConfigFile.delete();    }    Files.write(wholeFileExtractorConfigFile.toPath(), wholeFileExtractorConfig.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    if (stellarExtractorConfigFile.exists()) {        stellarExtractorConfigFile.delete();    }    Files.write(stellarExtractorConfigFile.toPath(), stellarExtractorConfig.replace("%ZK_QUORUM%", zookeeperUrl).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    if (customLineByLineExtractorConfigFile.exists()) {        customLineByLineExtractorConfigFile.delete();    }    Files.write(customLineByLineExtractorConfigFile.toPath(), customLineByLineExtractorConfig.replace("%EXTRACTOR_CLASS%", CSVExtractor.class.getName()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    if (file1.exists()) {        file1.delete();    }    Files.write(file1.toPath(), "google1.com,1,foo2\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    if (file2.exists()) {        file2.delete();    }    Files.write(file2.toPath(), "google2.com,2,foo2\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING);    if (multilineFile.exists()) {        multilineFile.delete();    }    if (multilineGzFile.exists()) {        multilineGzFile.delete();    }    if (multilineGzFile.exists()) {        multilineZipFile.delete();    }    PrintWriter[] pws = new PrintWriter[] {};    try {        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(multilineZipFile));        ZipEntry entry = new ZipEntry("file");        zos.putNextEntry(entry);                pws = new PrintWriter[] { new PrintWriter(multilineFile, StandardCharsets.UTF_8.name()), new PrintWriter(new OutputStreamWriter(zos, StandardCharsets.UTF_8)), new PrintWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(multilineGzFile)), StandardCharsets.UTF_8)) };        for (int i = 0; i < NUM_LINES; ++i) {            for (PrintWriter pw : pws) {                pw.println("google" + i + ".com," + i + ",foo" + i);            }        }    } finally {        for (PrintWriter pw : pws) {            pw.close();        }    }}
private static String metron_f4031_0(String host, int port)
{    return host + ":" + port;}
private static void metron_f4032_0(String zookeeperUrl) throws Exception
{    client = ConfigurationsUtils.getClient(zookeeperUrl);    client.start();    ConfigurationsUtils.writeGlobalConfigToZookeeper(globalConfig.getBytes(StandardCharsets.UTF_8), zookeeperUrl);}
public static void metron_f4033_0() throws Exception
{    HBaseUtil.INSTANCE.teardown(testUtil);    file1.delete();    file2.delete();    multilineFile.delete();    multilineGzFile.delete();    multilineZipFile.delete();    lineByLineExtractorConfigFile.delete();    wholeFileExtractorConfigFile.delete();    stellarExtractorConfigFile.delete();    customLineByLineExtractorConfigFile.delete();}
public void metron_f4034_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e extractor.json", "-n enrichment_config.json", "-l log4j", "-i input.csv", "-p 2", "-b 128", "-q" };    String[] otherArgs = new GenericOptionsParser(config, argv).getRemainingArgs();    CommandLine cli = LoadOptions.parse(new PosixParser(), otherArgs);    Assert.assertEquals(extractorJson, LoadOptions.EXTRACTOR_CONFIG.get(cli).trim());    Assert.assertEquals(cf, LoadOptions.HBASE_CF.get(cli).trim());    Assert.assertEquals(tableName, LoadOptions.HBASE_TABLE.get(cli).trim());    Assert.assertEquals(enrichmentJson, LoadOptions.ENRICHMENT_CONFIG.get(cli).trim());    Assert.assertEquals(csvFile, LoadOptions.INPUT.get(cli).trim());    Assert.assertEquals(log4jProperty, LoadOptions.LOG4J_PROPERTIES.get(cli).trim());    Assert.assertEquals("2", LoadOptions.NUM_THREADS.get(cli).trim());    Assert.assertEquals("128", LoadOptions.BATCH_SIZE.get(cli).trim());}
public void metron_f4035_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + lineByLineExtractorConfigFile.getPath(), "-i " + multilineFile.getPath(), "-p 2", "-b 128", "-q" };    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(NUM_LINES, results.size());    Assert.assertTrue(results.get(0).getKey().indicator.startsWith("google"));    Assert.assertEquals(results.get(0).getKey().type, "enrichment");    Assert.assertEquals(results.get(0).getValue().getMetadata().size(), 2);    Assert.assertTrue(results.get(0).getValue().getMetadata().get("meta").toString().startsWith("foo"));    Assert.assertTrue(results.get(0).getValue().getMetadata().get("host").toString().startsWith("google"));}
public void metron_f4036_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + lineByLineExtractorConfigFile.getPath(), "-i " + multilineGzFile.getPath(), "-p 2", "-b 128", "-q" };    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(NUM_LINES, results.size());    Assert.assertTrue(results.get(0).getKey().indicator.startsWith("google"));    Assert.assertEquals(results.get(0).getKey().type, "enrichment");    Assert.assertEquals(results.get(0).getValue().getMetadata().size(), 2);    Assert.assertTrue(results.get(0).getValue().getMetadata().get("meta").toString().startsWith("foo"));    Assert.assertTrue(results.get(0).getValue().getMetadata().get("host").toString().startsWith("google"));}
public void metron_f4037_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + lineByLineExtractorConfigFile.getPath(), "-i " + multilineZipFile.getPath(), "-p 2", "-b 128", "-q" };    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(NUM_LINES, results.size());    Assert.assertTrue(results.get(0).getKey().indicator.startsWith("google"));    Assert.assertEquals(results.get(0).getKey().type, "enrichment");    Assert.assertEquals(results.get(0).getValue().getMetadata().size(), 2);    Assert.assertTrue(results.get(0).getValue().getMetadata().get("meta").toString().startsWith("foo"));    Assert.assertTrue(results.get(0).getValue().getMetadata().get("host").toString().startsWith("google"));}
public void metron_f4038_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + wholeFileExtractorConfigFile.getPath(), "-i " + file1.getPath() + "," + file2.getPath(), "-p 2", "-b 128", "-q" };    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(2, results.size());    Assert.assertTrue(results.get(0).getKey().indicator.startsWith("google"));    Assert.assertEquals(results.get(0).getKey().type, "enrichment");    Assert.assertEquals(results.get(0).getValue().getMetadata().size(), 2);    Assert.assertTrue(results.get(0).getValue().getMetadata().get("meta").toString().startsWith("foo"));    Assert.assertTrue(results.get(0).getValue().getMetadata().get("host").toString().startsWith("google"));}
public void metron_f4039_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + lineByLineExtractorConfigFile.getPath(), "-i " + multilineFile.getName(), "-m MR", "-p 2", "-b 128", "-q" };    FileSystem fs = FileSystem.get(config);    HBaseUtil.INSTANCE.writeFile(new String(Files.readAllBytes(multilineFile.toPath()), StandardCharsets.UTF_8), new Path(multilineFile.getName()), fs);    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(NUM_LINES, results.size());    Assert.assertTrue(results.get(0).getKey().indicator.startsWith("google"));    Assert.assertEquals(results.get(0).getKey().type, "enrichment");    Assert.assertEquals(results.get(0).getValue().getMetadata().size(), 2);    Assert.assertTrue(results.get(0).getValue().getMetadata().get("meta").toString().startsWith("foo"));    Assert.assertTrue(results.get(0).getValue().getMetadata().get("host").toString().startsWith("google"));}
public void metron_f4040_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + stellarExtractorConfigFile.getPath(), "-i " + multilineFile.getPath(), "-p 2", "-b 128", "-q" };    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(NUM_LINES, results.size());    Assert.assertThat(results.get(0).getKey().getIndicator(), startsWith("GOOGLE"));    Assert.assertThat(results.get(0).getKey().type, equalTo("enrichment"));    Assert.assertThat(results.get(0).getValue().getMetadata().size(), equalTo(3));    Assert.assertThat(results.get(0).getValue().getMetadata().get("meta").toString(), startsWith("foo"));    Assert.assertThat(results.get(0).getValue().getMetadata().get("empty").toString(), startsWith("valfromglobalconfig"));    Assert.assertThat(results.get(0).getValue().getMetadata().get("host").toString(), startsWith("GOOGLE"));}
public void metron_f4041_0() throws Exception
{    String[] argv = { "-c cf", "-t enrichment", "-e " + customLineByLineExtractorConfigFile.getPath(), "-i " + multilineFile.getPath(), "-p 2", "-b 128", "-q" };    SimpleEnrichmentFlatFileLoader.main(config, argv);    EnrichmentConverter converter = new EnrichmentConverter();    ResultScanner scanner = testTable.getScanner(Bytes.toBytes(cf));    List<LookupKV<EnrichmentKey, EnrichmentValue>> results = new ArrayList<>();    for (Result r : scanner) {        results.add(converter.fromResult(r, cf));        testTable.delete(new Delete(r.getRow()));    }    Assert.assertEquals(NUM_LINES, results.size());    Assert.assertThat(results.get(0).getKey().getIndicator(), startsWith("GOOGLE"));    Assert.assertThat(results.get(0).getKey().type, equalTo("enrichment"));    Assert.assertThat(results.get(0).getValue().getMetadata().size(), equalTo(2));    Assert.assertThat(results.get(0).getValue().getMetadata().get("meta").toString(), startsWith("foo"));    Assert.assertThat(results.get(0).getValue().getMetadata().get("host").toString(), startsWith("GOOGLE"));}
public static String metron_f4042_0()
{    List<String> tmp = new ArrayList<>();    int i = 1;    for (String d : domains) {        tmp.add(i + "," + d);    }    return Joiner.on("\n").join(tmp);}
public void metron_f4043_0() throws Exception
{    String[] argv = { "-e extractor.json", "-o out.ser", "-l log4j", "-i input.csv", "-p 2", "-b 128", "-q" };    Configuration config = new Configuration();    String[] otherArgs = new GenericOptionsParser(config, argv).getRemainingArgs();    CommandLine cli = SummarizeOptions.parse(new PosixParser(), otherArgs);    Assert.assertEquals("extractor.json", SummarizeOptions.EXTRACTOR_CONFIG.get(cli).trim());    Assert.assertEquals("input.csv", SummarizeOptions.INPUT.get(cli).trim());    Assert.assertEquals("log4j", SummarizeOptions.LOG4J_PROPERTIES.get(cli).trim());    Assert.assertEquals("2", SummarizeOptions.NUM_THREADS.get(cli).trim());    Assert.assertEquals("128", SummarizeOptions.BATCH_SIZE.get(cli).trim());}
public Optional<List<String>> metron_f4044_0(String loc) throws IOException
{    if (loc.equals(".")) {        ArrayList<String> ret = new ArrayList<>(inMemoryData.keySet());        return Optional.of(ret);    }    return Optional.empty();}
public boolean metron_f4045_0(String loc)
{    return loc.equals(".") ? true : inMemoryData.containsKey(loc);}
public boolean metron_f4046_0(String loc) throws IOException
{    return loc.equals(".") ? true : false;}
public InputStream metron_f4047_0(String loc) throws IOException
{    return new ByteArrayInputStream(inMemoryData.get(loc).getBytes(StandardCharsets.UTF_8));}
public boolean metron_f4048_0(String loc)
{    return exists(loc);}
protected List<Location> metron_f4049_0(List<String> inputs, FileSystem fs) throws IOException
{    Set<Location> ret = new HashSet<>();    for (String input : inputs) {        if (input.equals(".")) {            for (String s : mockData.keySet()) {                ret.add(resolveLocation(s, fs));            }        } else {            ret.add(resolveLocation(input, fs));        }    }    return new ArrayList<>(ret);}
protected Location metron_f4050_0(String input, FileSystem fs)
{    return new Location(input, new InMemoryLocation(mockData));}
public void metron_f4052_0(Object obj, Optional<String> output, Configuration hadoopConfig) throws IOException
{    ref.set(obj);}
public void metron_f4054_0() throws IOException, InvalidWriterOutput
{    testLineByLine(5);    testLineByLine(1);}
public void metron_f4055_0(final int numThreads) throws IOException, InvalidWriterOutput
{    ExtractorHandler handler = ExtractorHandler.load(stellarExtractorConfigLineByLine);    LocalSummarizer summarizer = new MockSummarizer(ImmutableMap.of("input.csv", generateData()));    final AtomicReference<Object> finalObj = new AtomicReference<>(null);    EnumMap<SummarizeOptions, Optional<Object>> options = new EnumMap<SummarizeOptions, Optional<Object>>(SummarizeOptions.class) {        {            put(SummarizeOptions.INPUT, Optional.of("input.csv"));            put(SummarizeOptions.BATCH_SIZE, Optional.of(5));            put(SummarizeOptions.QUIET, Optional.of(true));            put(SummarizeOptions.OUTPUT_MODE, Optional.of(new PeekingWriter(finalObj)));            put(SummarizeOptions.OUTPUT, Optional.of("out"));            put(SummarizeOptions.NUM_THREADS, Optional.of(numThreads));        }    };    summarizer.importData(options, handler, new Configuration());    String expr = "MAP_GET(DOMAIN_REMOVE_TLD(domain), s) > 0";    for (String domain : domains) {        Boolean b = (Boolean) StellarProcessorUtils.run(expr, ImmutableMap.of("s", finalObj.get(), "domain", domain));        Assert.assertTrue("Can't find " + domain, b);    }}
public void metron_f4056_0() throws Exception
{    testWholeFile(5);    testWholeFile(1);}
public void metron_f4057_0(final int numThreads) throws IOException, InvalidWriterOutput
{    ExtractorHandler handler = ExtractorHandler.load(stellarExtractorConfigWholeFile);    LocalSummarizer summarizer = new MockSummarizer(new HashMap<String, String>() {        {            for (String domain : domains) {                put(domain, "1," + domain);            }        }    });    final AtomicReference<Object> finalObj = new AtomicReference<>(null);    EnumMap<SummarizeOptions, Optional<Object>> options = new EnumMap<SummarizeOptions, Optional<Object>>(SummarizeOptions.class) {        {            put(SummarizeOptions.INPUT, Optional.of("."));            put(SummarizeOptions.BATCH_SIZE, Optional.of(5));            put(SummarizeOptions.QUIET, Optional.of(true));            put(SummarizeOptions.OUTPUT_MODE, Optional.of(new PeekingWriter(finalObj)));            put(SummarizeOptions.OUTPUT, Optional.of("out"));            put(SummarizeOptions.NUM_THREADS, Optional.of(numThreads));        }    };    summarizer.importData(options, handler, new Configuration());    String expr = "MAP_GET(DOMAIN_REMOVE_TLD(domain), s) > 0";    for (String domain : domains) {        Boolean b = (Boolean) StellarProcessorUtils.run(expr, ImmutableMap.of("s", finalObj.get(), "domain", domain));        Assert.assertTrue("Can't find " + domain, b);    }}
public void metron_f4059_0() throws Exception
{    testFolder.create();    remoteDir = testFolder.newFolder("remoteDir");    tmpDir = testFolder.newFolder("tmpDir");}
public void metron_f4060_0() throws Exception
{    String[] argv = { "-g testGeoUrl", "-a testAsnUrl", "-r /test/remoteDirGeo", "-ra", "/test/remoteDirAsn", "-t /test/tmpDir", "-z test:2181" };    String[] otherArgs = new GenericOptionsParser(argv).getRemainingArgs();    CommandLine cli = MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.parse(new PosixParser(), otherArgs);    Assert.assertEquals("testGeoUrl", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.GEO_URL.get(cli).trim());    Assert.assertEquals("testAsnUrl", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.ASN_URL.get(cli).trim());    Assert.assertEquals("/test/remoteDirGeo", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.REMOTE_GEO_DIR.get(cli).trim());    Assert.assertEquals("/test/remoteDirAsn", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.REMOTE_ASN_DIR.get(cli).trim());    Assert.assertEquals("/test/tmpDir", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.TMP_DIR.get(cli).trim());    Assert.assertEquals("test:2181", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.ZK_QUORUM.get(cli).trim());}
public void metron_f4061_0() throws Exception
{    String[] argv = { "--geo_url", "testGeoUrl", "--remote_dir", "/test/remoteDir", "-ra", "/test/remoteDir", "--tmp_dir", "/test/tmpDir", "--zk_quorum", "test:2181" };    String[] otherArgs = new GenericOptionsParser(argv).getRemainingArgs();    CommandLine cli = MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.parse(new PosixParser(), otherArgs);    Assert.assertEquals("testGeoUrl", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.GEO_URL.get(cli).trim());    Assert.assertEquals("/test/remoteDir", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.REMOTE_GEO_DIR.get(cli).trim());    Assert.assertEquals("/test/tmpDir", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.TMP_DIR.get(cli).trim());    Assert.assertEquals("test:2181", MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.ZK_QUORUM.get(cli).trim());}
public void metron_f4062_0() throws Exception
{    File dbPlainTextFile = new File(remoteDir.getAbsolutePath() + "/MaxmindDbEnrichmentLoaderTest.mmdb");    TestUtils.write(dbPlainTextFile, "hello world");    File dbFile = new File(remoteDir.getAbsolutePath() + "/MaxmindDbEnrichmentLoaderTest.mmdb.gz");    CompressionStrategies.GZIP.compress(dbPlainTextFile, dbFile);    String[] argv = { "--geo_url", "file://" + dbFile.getAbsolutePath(), "--remote_dir", remoteDir.getAbsolutePath(), "--remote_asn_dir", remoteDir.getAbsolutePath(), "--tmp_dir", tmpDir.getAbsolutePath(), "--zk_quorum", "test:2181" };    String[] otherArgs = new GenericOptionsParser(argv).getRemainingArgs();    CommandLine cli = MaxmindDbEnrichmentLoader.GeoEnrichmentOptions.parse(new PosixParser(), otherArgs);    MaxmindDbEnrichmentLoader loader = new MockMaxmindDbEnrichmentLoader();    loader.loadGeoLiteDatabase(cli);    Configuration config = new Configuration();    FileSystem fs = FileSystem.get(config);    assertTrue(fs.exists(new Path(remoteDir + "/" + dbFile.getName())));}
public void metron_f4063_0() throws Exception
{    File dbFile = new File(remoteDir.getAbsolutePath() + "/MaxmindDbEnrichmentLoaderTest.mmdb");    dbFile.createNewFile();    String geoUrl = "file://" + dbFile.getAbsolutePath();    int numRetries = 2;    exception.expect(IllegalStateException.class);    exception.expectMessage("Unable to download geo enrichment database.");    MaxmindDbEnrichmentLoader loader = new MockMaxmindDbEnrichmentLoader();    loader.downloadGeoFile(geoUrl, tmpDir.getAbsolutePath(), numRetries);}
public Response metron_f4064_0()
{    return Response.ok(discoveryMsg, MediaType.APPLICATION_XML_TYPE).header("x-taxii-content-type", "urn:taxii.mitre.org:message:xml:1.1").build();}
public Response metron_f4065_0()
{    return Response.ok(pollMsg).type(MediaType.APPLICATION_XML_TYPE).header("x-taxii-content-type", "urn:taxii.mitre.org:message:xml:1.1").build();}
public Set<Class<?>> metron_f4066_0()
{    return classes;}
public static void metron_f4067_0(int port) throws IOException
{        URI uri = UriBuilder.fromUri("http://localhost/").port(port).build();    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig(), HttpHandler.class);    server.createContext(uri.getPath(), handler);    discoveryMsg = discoveryMsg.replaceAll("PORT", "" + uri.getPort());    server.start();}
public static void metron_f4068_0()
{    if (server != null) {        server.stop(0);    }}
public static void metron_f4069_0() throws IOException
{    MockTaxiiService.start(8282);}
public static void metron_f4070_0()
{    MockTaxiiService.shutdown();    MockHBaseTableProvider.clear();}
public void metron_f4071_0() throws Exception
{    Configuration conf = HBaseConfiguration.create();    String[] argv = { "-c connection.json", "-e extractor.json", "-n enrichment_config.json", "-l log4j", "-p 10", "-b 04/14/2016 12:00:00" };    String[] otherArgs = new GenericOptionsParser(conf, argv).getRemainingArgs();    CommandLine cli = TaxiiLoader.TaxiiOptions.parse(new PosixParser(), otherArgs);    Assert.assertEquals(extractorJson, TaxiiLoader.TaxiiOptions.EXTRACTOR_CONFIG.get(cli).trim());    Assert.assertEquals(connectionConfig, TaxiiLoader.TaxiiOptions.CONNECTION_CONFIG.get(cli).trim());    Assert.assertEquals(beginTime, TaxiiLoader.TaxiiOptions.BEGIN_TIME.get(cli).trim());    Assert.assertEquals(enrichmentJson, TaxiiLoader.TaxiiOptions.ENRICHMENT_CONFIG.get(cli).trim());    Assert.assertEquals(timeInteval, TaxiiLoader.TaxiiOptions.TIME_BETWEEN_POLLS.get(cli).trim());    Assert.assertEquals(log4jProperty, TaxiiLoader.TaxiiOptions.LOG4J_PROPERTIES.get(cli).trim());}
public void metron_f4072_0() throws Exception
{    final MockHBaseTableProvider provider = new MockHBaseTableProvider();    final Configuration config = HBaseConfiguration.create();    Extractor extractor = new TransformFilterExtractorDecorator(new StixExtractor());    TaxiiHandler handler = new TaxiiHandler(TaxiiConnectionConfig.load(taxiiConnectionConfig), extractor, config) {        @Override        protected synchronized Table createHTable(String tableInfo) throws IOException {            return provider.addToCache("threat_intel", "cf");        }    };        handler.run();    Set<String> maliciousDomains;    {        MockHTable table = (MockHTable) provider.getTable(config, "threat_intel");        maliciousDomains = getIndicators("domainname:FQDN", table.getPutLog(), "cf");    }    Assert.assertTrue(maliciousDomains.contains("www.office-112.com"));    Assert.assertEquals(numStringsMatch(MockTaxiiService.pollMsg, "DomainNameObj:Value condition=\"Equals\""), maliciousDomains.size());    Set<String> maliciousAddresses;    {        MockHTable table = (MockHTable) provider.getTable(config, "threat_intel");        maliciousAddresses = getIndicators("address:IPV_4_ADDR", table.getPutLog(), "cf");    }    Assert.assertTrue(maliciousAddresses.contains("94.102.53.142"));    Assert.assertEquals(numStringsMatch(MockTaxiiService.pollMsg, "AddressObj:Address_Value condition=\"Equal\""), maliciousAddresses.size());    MockHBaseTableProvider.clear();        handler.run();}
protected synchronized Table metron_f4073_0(String tableInfo) throws IOException
{    return provider.addToCache("threat_intel", "cf");}
private static int metron_f4074_0(String xmlBundle, String text)
{    int cnt = 0;    for (String line : Splitter.on("\n").split(xmlBundle)) {        if (line.contains(text)) {            cnt++;        }    }    return cnt;}
private static Set<String> metron_f4075_0(String indicatorType, Iterable<Put> puts, String cf) throws IOException
{    EnrichmentConverter converter = new EnrichmentConverter();    Set<String> ret = new HashSet<>();    for (Put p : puts) {        LookupKV<EnrichmentKey, EnrichmentValue> kv = converter.fromPut(p, cf);        if (kv.getKey().type.equals(indicatorType)) {            ret.add(kv.getKey().indicator);        }    }    return ret;}
public void metron_f4076_0(WriteSuccess<D> success)
{    this.successes.add(success);}
public void metron_f4077_0(D success)
{    add(new WriteSuccess<D>(success));}
public void metron_f4078_0(List<D> successes)
{    for (D success : successes) {        addSuccess(success);    }}
public List<WriteSuccess<D>> metron_f4079_0()
{    return successes;}
public void metron_f4080_0(WriteFailure<D> failure)
{    this.failures.add(failure);}
public void metron_f4081_0(D document, Throwable cause, String message)
{    add(new WriteFailure(document, cause, message));}
public List<WriteFailure<D>> metron_f4082_0()
{    return failures;}
public int metron_f4085_0()
{    return documents.size();}
public ElasticsearchBulkDocumentWriter<D> metron_f4086_0(WriteRequest.RefreshPolicy refreshPolicy)
{    this.refreshPolicy = refreshPolicy;    return this;}
private void metron_f4088_0(BulkResponse bulkResponse, List<Indexable> documents, BulkDocumentWriterResults<D> results)
{    if (bulkResponse.hasFailures()) {                for (BulkItemResponse response : bulkResponse) {            if (response.isFailed()) {                                D failed = getDocument(response.getItemId());                Exception cause = response.getFailure().getCause();                String message = response.getFailureMessage();                results.addFailure(failed, cause, message);            } else {                                D success = getDocument(response.getItemId());                success.setDocumentID(response.getResponse().getId());                results.addSuccess(success);            }        }    } else {                for (Indexable success : documents) {            results.addSuccess(success.document);        }    }}
private D metron_f4089_0(int index)
{    return documents.get(index).document;}
public static void metron_f4090_0(String[] args)
{    if (args.length != 2) {        throw new RuntimeException("Expects 'input' and 'output' file arguments.");    }    final String inPath = args[0];    final String outPath = args[1];    try {        new ElasticsearchImportExport().bulkify(Paths.get(inPath), Paths.get(outPath));    } catch (IOException e) {        e.printStackTrace();        System.exit(1);    }    System.exit(0);}
public void metron_f4091_0(Path input, Path output) throws IOException
{    List<String> outRecs = new ArrayList<String>();    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input.toFile()), StandardCharsets.UTF_8))) {        String line;        while ((line = br.readLine()) != null) {            Map<String, Object> inDoc = JSONUtils.INSTANCE.load(line, JSONUtils.MAP_SUPPLIER);            Object id = inDoc.get("_id");            Object type = inDoc.get("_type");            String createRaw = String.format("{ \"create\" : { \"_id\": \"%s\", \"_type\": \"%s\" } }", id, type);            String outData = JSONUtils.INSTANCE.toJSON(inDoc.get("_source"), false);            outRecs.add(createRaw);            outRecs.add(outData);        }    }    try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output.toFile()), StandardCharsets.UTF_8))) {        for (String line : outRecs) {            br.write(line);            br.write(System.lineSeparator());        }    }}
public D metron_f4092_0()
{    return document;}
public Throwable metron_f4093_0()
{    return cause;}
public String metron_f4094_0()
{    return message;}
public D metron_f4095_0()
{    return document;}
public RestClient metron_f4096_0()
{    return lowLevelClient;}
public RestHighLevelClient metron_f4097_0()
{    return highLevelClient;}
public void metron_f4098_0() throws IOException
{    if (lowLevelClient != null) {        lowLevelClient.close();    }}
public void metron_f4099_0(String index, String mappingType, String mapping) throws IOException
{    HttpEntity entity = new StringEntity(mapping);    Response response = lowLevelClient.performRequest("PUT", "/" + index + "/_mapping/" + mappingType, Collections.emptyMap(), entity);    if (response.getStatusLine().getStatusCode() != 200) {        String responseStr = IOUtils.toString(response.getEntity().getContent());        throw new IllegalStateException("Got a " + response.getStatusLine().getStatusCode() + " due to " + responseStr);    }}
public String[] metron_f4100_0() throws IOException
{    Response response = lowLevelClient.performRequest("GET", "/_cat/indices");    if (response.getStatusLine().getStatusCode() == 200) {        String responseStr = IOUtils.toString(response.getEntity().getContent());        List<String> indices = new ArrayList<>();        for (String line : Splitter.on("\n").split(responseStr)) {            Iterable<String> splits = Splitter.on(" ").split(line.replaceAll("\\s+", " ").trim());            if (Iterables.size(splits) > 3) {                String index = Iterables.get(splits, 2, "");                if (!StringUtils.isEmpty(index)) {                    indices.add(index.trim());                }            }        }        String[] ret = new String[indices.size()];        ret = indices.toArray(ret);        return ret;    }    return null;}
public Map<String, FieldMapping> metron_f4101_0(String[] indices) throws IOException
{    Map<String, FieldMapping> ret = new HashMap<>();    String indicesCsv = Joiner.on(",").join(indices);    Response response = lowLevelClient.performRequest("GET", "/" + indicesCsv + "/_mapping");    if (response.getStatusLine().getStatusCode() == 200) {        String responseStr = IOUtils.toString(response.getEntity().getContent());        Map<String, Object> indexToMapping = JSONUtils.INSTANCE.load(responseStr, JSONUtils.MAP_SUPPLIER);        for (Map.Entry<String, Object> index2Mapping : indexToMapping.entrySet()) {            String index = index2Mapping.getKey();            Map<String, Object> mappings = getInnerMap((Map<String, Object>) index2Mapping.getValue(), "mappings");            if (mappings.size() > 0) {                Map.Entry<String, Object> docMap = Iterables.getFirst(mappings.entrySet(), null);                if (docMap != null) {                    Map<String, Object> fieldPropertiesMap = getInnerMap((Map<String, Object>) docMap.getValue(), "properties");                    if (fieldPropertiesMap != null) {                        FieldMapping mapping = new FieldMapping();                        for (Map.Entry<String, Object> field2PropsKV : fieldPropertiesMap.entrySet()) {                            if (field2PropsKV.getValue() != null) {                                FieldProperties props = new FieldProperties((Map<String, Object>) field2PropsKV.getValue());                                mapping.put(field2PropsKV.getKey(), props);                            }                        }                        ret.put(index, mapping);                    }                }            }        }    }    return ret;}
private Map<String, Object> metron_f4102_0(Map<String, Object> outerMap, String... keys)
{    Map<String, Object> ret = outerMap;    if (keys.length == 0) {        return outerMap;    }    for (String key : keys) {        ret = (Map<String, Object>) ret.get(key);        if (ret == null) {            return ret;        }    }    return ret;}
public static ElasticsearchClient metron_f4103_0(Map<String, Object> globalConfig)
{    ElasticsearchClientConfig esClientConfig = new ElasticsearchClientConfig(getEsSettings(globalConfig));    HttpHost[] httpHosts = getHttpHosts(globalConfig, esClientConfig.getConnectionScheme());    RestClientBuilder builder = RestClient.builder(httpHosts);    builder.setRequestConfigCallback(reqConfigBuilder -> {                        reqConfigBuilder.setConnectTimeout(esClientConfig.getConnectTimeoutMillis());        reqConfigBuilder.setSocketTimeout(esClientConfig.getSocketTimeoutMillis());        return reqConfigBuilder;    });    builder.setMaxRetryTimeoutMillis(esClientConfig.getMaxRetryTimeoutMillis());    builder.setHttpClientConfigCallback(clientBuilder -> {        clientBuilder.setDefaultIOReactorConfig(getIOReactorConfig(esClientConfig));        clientBuilder.setDefaultCredentialsProvider(getCredentialsProvider(esClientConfig));        clientBuilder.setSSLContext(getSSLContext(esClientConfig));        return clientBuilder;    });    RestClient lowLevelClient = builder.build();    RestHighLevelClient client = new RestHighLevelClient(lowLevelClient);    return new ElasticsearchClient(lowLevelClient, client);}
private static Map<String, Object> metron_f4104_0(Map<String, Object> globalConfig)
{    return (Map<String, Object>) globalConfig.getOrDefault(ES_SETTINGS_KEY, new HashMap<>());}
private static HttpHost[] metron_f4105_0(Map<String, Object> globalConfiguration, String scheme)
{    List<HostnamePort> hps = ElasticsearchUtils.getIps(globalConfiguration);    HttpHost[] httpHosts = new HttpHost[hps.size()];    int i = 0;    for (HostnamePort hp : hps) {        httpHosts[i++] = new HttpHost(hp.hostname, hp.port, scheme);    }    return httpHosts;}
private static IOReactorConfig metron_f4106_1(ElasticsearchClientConfig esClientConfig)
{    if (esClientConfig.getNumClientConnectionThreads().isPresent()) {        Integer numThreads = esClientConfig.getNumClientConnectionThreads().get();                return IOReactorConfig.custom().setIoThreadCount(numThreads).build();    } else {        return IOReactorConfig.DEFAULT;    }}
private static CredentialsProvider metron_f4107_1(ElasticsearchClientConfig esClientConfig)
{    Optional<Entry<String, String>> credentials = esClientConfig.getCredentials();    if (credentials.isPresent()) {                final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();        UsernamePasswordCredentials upcredentials = new UsernamePasswordCredentials(credentials.get().getKey(), credentials.get().getValue());        credentialsProvider.setCredentials(AuthScope.ANY, upcredentials);        return credentialsProvider;    } else {                return null;    }}
private static SSLContext metron_f4108_1(ElasticsearchClientConfig esClientConfig)
{    if (esClientConfig.isSSLEnabled()) {                if (!esClientConfig.getKeyStorePath().isPresent()) {            throw new IllegalStateException("KeyStore path must be provided for SSL connection.");        }        Optional<String> optKeyStorePass = esClientConfig.getKeyStorePassword();        char[] keyStorePass = optKeyStorePass.map(String::toCharArray).orElse(null);        KeyStore trustStore = getStore(esClientConfig.getKeyStoreType(), esClientConfig.getKeyStorePath().get(), keyStorePass);        try {            SSLContextBuilder sslBuilder = SSLContexts.custom().loadTrustMaterial(trustStore, null);            return sslBuilder.build();        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {            throw new IllegalStateException("Unable to load truststore.", e);        }    }    return null;}
private static KeyStore metron_f4109_0(String type, Path path, char[] pass)
{    KeyStore store;    try {        store = KeyStore.getInstance(type);    } catch (KeyStoreException e) {        throw new IllegalStateException("Unable to get keystore type '" + type + "'", e);    }    try (InputStream is = Files.newInputStream(path)) {        store.load(is, pass);    } catch (IOException | NoSuchAlgorithmException | CertificateException e) {        throw new IllegalStateException("Unable to load keystore from path '" + path + "'", e);    }    return store;}
public Integer metron_f4110_0()
{    return ElasticsearchClientOptions.CONNECTION_TIMEOUT_MILLIS.getOrDefault(this, Integer.class, ONE_SECONDS_IN_MILLIS);}
public Integer metron_f4111_0()
{    return ElasticsearchClientOptions.SOCKET_TIMEOUT_MILLIS.getOrDefault(this, Integer.class, THIRTY_SECONDS_IN_MILLIS);}
public Integer metron_f4112_0()
{    return ElasticsearchClientOptions.MAX_RETRY_TIMEOUT_MILLIS.getOrDefault(this, Integer.class, THIRTY_SECONDS_IN_MILLIS);}
public Optional<Map.Entry<String, String>> metron_f4113_0()
{    if (ElasticsearchClientOptions.XPACK_PASSWORD_FILE.containsOption(this)) {        if (!ElasticsearchClientOptions.XPACK_USERNAME.containsOption(this) || StringUtils.isEmpty(ElasticsearchClientOptions.XPACK_USERNAME.get(this, String.class))) {            throw new IllegalArgumentException("X-pack username is required when password supplied and cannot be empty");        }        String user = ElasticsearchClientOptions.XPACK_USERNAME.get(this, String.class);        String password = getPasswordFromFile(ElasticsearchClientOptions.XPACK_PASSWORD_FILE.get(this, String.class));        if (user != null && password != null) {            return Optional.of(new AbstractMap.SimpleImmutableEntry<String, String>(user, password));        }    }    return Optional.empty();}
private static String metron_f4114_0(String hdfsPath)
{    List<String> lines = readLines(hdfsPath);    if (lines.size() == 0) {        throw new IllegalArgumentException(format("No password found in file '%s'", hdfsPath));    }    return lines.get(0);}
private static List<String> metron_f4115_0(String hdfsPath)
{    try {        return HDFSUtils.readFile(hdfsPath);    } catch (IOException e) {        throw new IllegalStateException(format("Unable to read XPack password file from HDFS location '%s'", hdfsPath), e);    }}
public boolean metron_f4116_0()
{    return ElasticsearchClientOptions.SSL_ENABLED.getOrDefault(this, Boolean.class, false);}
public String metron_f4117_0()
{    return isSSLEnabled() ? "https" : "http";}
public Optional<Integer> metron_f4118_0()
{    if (ElasticsearchClientOptions.NUM_CLIENT_CONNECTION_THREADS.containsOption(this)) {        return Optional.of(ElasticsearchClientOptions.NUM_CLIENT_CONNECTION_THREADS.get(this, Integer.class));    }    return Optional.empty();}
public String metron_f4119_0()
{    if (ElasticsearchClientOptions.KEYSTORE_TYPE.containsOption(this) && StringUtils.isNotEmpty(ElasticsearchClientOptions.KEYSTORE_TYPE.get(this, String.class))) {        return ElasticsearchClientOptions.KEYSTORE_TYPE.get(this, String.class);    }    return DEFAULT_KEYSTORE_TYPE;}
public Optional<String> metron_f4120_0()
{    if (ElasticsearchClientOptions.KEYSTORE_PASSWORD_FILE.containsOption(this)) {        String password = getPasswordFromFile(ElasticsearchClientOptions.KEYSTORE_PASSWORD_FILE.get(this, String.class));        if (StringUtils.isNotEmpty(password)) {            return Optional.of(password);        }    }    return Optional.empty();}
