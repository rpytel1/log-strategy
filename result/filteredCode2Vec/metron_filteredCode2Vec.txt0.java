public String metron_f0_0()
{    return url;}
public void metron_f1_0(String url)
{    this.url = url;}
public Map<String, String> metron_f2_0()
{    return functions;}
public void metron_f3_0(Map<String, String> functions)
{    this.functions = functions;}
public String metron_f4_0()
{    return "Endpoint{" + "url='" + url + '\'' + ", functions=" + functions + '}';}
public boolean metron_f5_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Endpoint endpoint = (Endpoint) o;    if (getUrl() != null ? !getUrl().equals(endpoint.getUrl()) : endpoint.getUrl() != null)        return false;    return getFunctions() != null ? getFunctions().equals(endpoint.getFunctions()) : endpoint.getFunctions() == null;}
public int metron_f6_0()
{    int result = getUrl() != null ? getUrl().hashCode() : 0;    result = 31 * result + (getFunctions() != null ? getFunctions().hashCode() : 0);    return result;}
public String metron_f7_0()
{    return serviceRoot;}
public void metron_f8_0(String serviceRoot)
{    this.serviceRoot = serviceRoot;}
public QueueHandler metron_f9_0()
{    return queue;}
public void metron_f10_0(QueueHandler queue)
{    this.queue = queue;}
public Map<String, Object> metron_f11_0()
{    return queueConfig;}
public void metron_f12_0(Map<String, Object> queueConfig)
{    this.queueConfig = queueConfig;}
public Queue<ModelRequest> metron_f13_0(Map<String, Object> additionalConfig)
{    Map<String, Object> configs = new HashMap<>(getQueueConfig());    configs.putAll(additionalConfig);    return getQueue().create(configs);}
public String metron_f14_0()
{    return name;}
public void metron_f15_0(String name)
{    this.name = name;}
public String metron_f16_0()
{    return version;}
public void metron_f17_0(String version)
{    this.version = version;}
public boolean metron_f18_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Model model = (Model) o;    if (getName() != null ? !getName().equals(model.getName()) : model.getName() != null)        return false;    return getVersion() != null ? getVersion().equals(model.getVersion()) : model.getVersion() == null;}
public int metron_f19_0()
{    int result = getName() != null ? getName().hashCode() : 0;    result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);    return result;}
public String metron_f20_0()
{    return containerId;}
public Endpoint metron_f21_0()
{    return endpoint;}
public void metron_f22_0(Endpoint endpoint)
{    this.endpoint = endpoint;}
public String metron_f23_0()
{    return name + ":" + version + " @ " + endpoint.getUrl() + " serving:\n\t" + Joiner.on("\n\t").join(getEndpoint().getFunctions().entrySet());}
public void metron_f24_0(String containerId)
{    this.containerId = containerId;}
public String metron_f25_0()
{    return name;}
public void metron_f26_0(String name)
{    this.name = name;}
public String metron_f27_0()
{    return version;}
public void metron_f28_0(String version)
{    this.version = version;}
public boolean metron_f29_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ModelEndpoint that = (ModelEndpoint) o;    if (getEndpoint() != null ? !getEndpoint().equals(that.getEndpoint()) : that.getEndpoint() != null)        return false;    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)        return false;    if (getVersion() != null ? !getVersion().equals(that.getVersion()) : that.getVersion() != null)        return false;    return getContainerId() != null ? getContainerId().equals(that.getContainerId()) : that.getContainerId() == null;}
public int metron_f30_0()
{    int result = getEndpoint() != null ? getEndpoint().hashCode() : 0;    result = 31 * result + (getName() != null ? getName().hashCode() : 0);    result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);    result = 31 * result + (getContainerId() != null ? getContainerId().hashCode() : 0);    return result;}
public String metron_f31_0()
{    return path;}
public void metron_f32_0(String path)
{    this.path = path;}
public Action metron_f33_0()
{    return action;}
public void metron_f34_0(Action action)
{    this.action = action;}
public String metron_f35_0()
{    return name;}
public void metron_f36_0(String name)
{    this.name = name;}
public String metron_f37_0()
{    return version;}
public void metron_f38_0(String version)
{    this.version = version;}
public int metron_f39_0()
{    return numInstances;}
public void metron_f40_0(int numInstances)
{    this.numInstances = numInstances;}
public int metron_f41_0()
{    return memory;}
public void metron_f42_0(int memory)
{    this.memory = memory;}
public void metron_f43_1()
{    rwLock.readLock().lock();    ServiceInstance<ModelEndpoint> ep = null;    try {        for (Map.Entry<String, ServiceInstance<ModelEndpoint>> kv : containerToEndpoint.entrySet()) {            ep = kv.getValue();            serviceDiscovery.unregisterService(ep);        }    } catch (Exception e) {            } finally {        rwLock.readLock().unlock();    }}
public ServiceDiscovery<ModelEndpoint> metron_f44_0()
{    return serviceDiscovery;}
private void metron_f45_1()
{    Map<Model, List<ModelEndpoint>> state = new HashMap<>();    Map<String, String> modelToVersion = new HashMap<>();    Map<String, ServiceInstance<ModelEndpoint>> containerToEndpoint = new HashMap<>();    try {        for (String name : serviceDiscovery.queryForNames()) {            for (ServiceInstance<ModelEndpoint> endpoint : serviceDiscovery.queryForInstances(name)) {                ModelEndpoint ep = endpoint.getPayload();                if (LOG.isDebugEnabled()) {                                    }                                String currentVersion = modelToVersion.getOrDefault(ep.getName(), ep.getVersion());                                                                currentVersion = currentVersion.compareTo(ep.getVersion()) < 0 ? ep.getVersion() : currentVersion;                modelToVersion.put(ep.getName(), currentVersion);                containerToEndpoint.put(ep.getContainerId(), endpoint);                Model model = new Model(ep.getName(), ep.getVersion());                List<ModelEndpoint> endpoints = state.get(model);                if (endpoints == null) {                    endpoints = new ArrayList<>();                    state.put(model, endpoints);                }                endpoints.add(ep);            }        }        rwLock.writeLock().lock();        try {            this.modelToCurrentVersion = modelToVersion;            this.state = state;            this.containerToEndpoint = containerToEndpoint;            if (LOG.isDebugEnabled()) {                            }        } finally {            rwLock.writeLock().unlock();        }    } catch (Exception e) {            } finally {    }}
public void metron_f46_1()
{    try {        serviceDiscovery.start();        cache.start();        updateState();    } catch (Exception e) {                throw new IllegalStateException("Unable to start", e);    }}
public void metron_f47_1(String containerIdRaw)
{    rwLock.readLock().lock();    try {        String containerId = containerIdRaw;                                ServiceInstance<ModelEndpoint> ep = containerToEndpoint.get(containerId);        if (ep != null) {            serviceDiscovery.unregisterService(ep);        } else {                        throw new IllegalStateException("Unable.");        }    } catch (Exception e) {            } finally {        rwLock.readLock().unlock();    }}
public List<ModelEndpoint> metron_f48_0(Model model)
{    rwLock.readLock().lock();    try {        return state.getOrDefault(model, new ArrayList<>());    } finally {        rwLock.readLock().unlock();    }}
public void metron_f49_0(ModelEndpoint endpoint)
{    blacklist(toUrl(endpoint.getEndpoint().getUrl()));}
public void metron_f50_0(URL url)
{    rwLock.writeLock().lock();    try {        blacklist.put(url, true);    } finally {        rwLock.writeLock().unlock();    }}
public ModelEndpoint metron_f51_0(String modelName)
{    String version = null;    rwLock.readLock().lock();    try {        version = modelToCurrentVersion.get(modelName);    } finally {        rwLock.readLock().unlock();    }    if (version == null) {        throw new IllegalStateException("Unable to find version for " + modelName);    }    return getEndpoint(modelName, version);}
private static URL metron_f52_0(String url)
{    try {        return new URL(url);    } catch (MalformedURLException e) {        throw new IllegalStateException("Endpoint does not refer to an actual URL");    }}
public ModelEndpoint metron_f53_0(String modelName, String modelVersion)
{    return getEndpoint(new Model(modelName, modelVersion));}
public ModelEndpoint metron_f54_0(Model model)
{    rwLock.readLock().lock();    try {        List<ModelEndpoint> endpoints = state.get(model);        ModelEndpoint ret = null;        if (endpoints != null) {            for (int j = 0; j < 10; ++j) {                int i = ThreadLocalRandom.current().nextInt(endpoints.size());                ret = endpoints.get(i);                try {                    if (blacklist.asMap().containsKey(toUrl(ret.getEndpoint().getUrl()))) {                        continue;                    } else {                        return ret;                    }                } catch (IllegalStateException ise) {                /*             If an exception happens on an attempt then we move on.             Frankly this is an excess of caution since we parse the             URLs in the Runner before they go into zookeeper, so they are valid.             */                }            }        }        return ret;    } finally {        rwLock.readLock().unlock();    }}
public Map<Model, List<ModelEndpoint>> metron_f55_0(Model model)
{    Map<Model, List<ModelEndpoint>> ret = new HashMap<>();    rwLock.readLock().lock();    try {        Query query = new Query(model);        for (Map.Entry<Model, List<ModelEndpoint>> kv : state.entrySet()) {            if (query.match(kv.getKey())) {                ret.put(kv.getKey(), kv.getValue());            }        }        return ret;    } finally {        rwLock.readLock().unlock();    }}
public void metron_f56_0()
{    if (cache != null) {        CloseableUtils.closeQuietly(cache);    }    if (serviceDiscovery != null) {        CloseableUtils.closeQuietly(serviceDiscovery);    }}
public boolean metron_f57_0(Model m)
{    boolean isNameMatch = ((model.getName() != null && model.getName().equals(m.getName())) || model.getName() == null);    if (!isNameMatch) {        return false;    }    boolean isVersionMatch = (model.getVersion() != null && model.getVersion().equals(m.getVersion())) || model.getVersion() == null;    if (!isVersionMatch) {        return false;    }    return true;}
public boolean metron_f58_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ModelCacheKey that = (ModelCacheKey) o;    if (name != null ? !name.equals(that.name) : that.name != null)        return false;    if (version != null ? !version.equals(that.version) : that.version != null)        return false;    if (method != null ? !method.equals(that.method) : that.method != null)        return false;    return args != null ? args.equals(that.args) : that.args == null;}
public int metron_f59_0()
{    int result = name != null ? name.hashCode() : 0;    result = 31 * result + (version != null ? version.hashCode() : 0);    result = 31 * result + (method != null ? method.hashCode() : 0);    result = 31 * result + (args != null ? args.hashCode() : 0);    return result;}
public Object metron_f60_1(List<Object> args, Context context) throws ParseException
{    if (args.size() < 2) {        throw new ParseException("Unable to execute model_apply. " + "Expected arguments: endpoint_map:map, " + " [endpoint method:string], model_args:map");    }    if (!isInitialized) {        return null;    }    int i = 0;    if (args.size() == 0) {        return null;    }    Object endpointObj = args.get(i++);    Map endpoint = null;    String modelName;    String modelVersion;    String modelUrl;    if (endpointObj instanceof Map) {        endpoint = (Map) endpointObj;        modelName = endpoint.get("name") + "";        modelVersion = endpoint.get("version") + "";        modelUrl = endpoint.get("url") + "";    } else {        return null;    }    String modelFunction = "apply";    Map<String, String> modelArgs = new HashMap<>();    if (args.get(i) instanceof String) {        String func = (String) args.get(i);        if (endpoint.containsKey("endpoint:" + func)) {            modelFunction = "" + endpoint.get("endpoint:" + func);        } else {            modelFunction = func;        }        i++;    }    if (args.get(i) instanceof Map) {        if (endpoint.containsKey("endpoint:apply")) {            modelFunction = "" + endpoint.get("endpoint:apply");        }        modelArgs = (Map) args.get(i);    }    if (modelName == null || modelVersion == null || modelFunction == null) {        return null;    }    ModelCacheKey cacheKey = new ModelCacheKey(modelName, modelVersion, modelFunction, modelArgs);    Map<String, Object> ret = resultCache.getIfPresent(cacheKey);    if (ret != null) {        return ret;    } else {        String url = modelUrl;        if (url.endsWith("/")) {            url = url.substring(0, url.length() - 1);        }        if (modelFunction.startsWith("/")) {            modelFunction = modelFunction.substring(1);        }        try {            URL u = new URL(url + "/" + modelFunction);            String results = RESTUtil.INSTANCE.getRESTJSONResults(u, modelArgs);            ret = JSONUtils.INSTANCE.load(results, JSONUtils.MAP_SUPPLIER);            resultCache.put(cacheKey, ret);            return ret;        } catch (Exception e) {                        if (discoverer != null) {                try {                    URL u = new URL(modelUrl);                    discoverer.blacklist(u);                } catch (MalformedURLException e1) {                }            }        }    }    return null;}
public synchronized void metron_f61_1(Context context)
{    try {        Optional<ServiceDiscoverer> discovererOpt = (Optional) (context.getCapability(Context.Capabilities.SERVICE_DISCOVERER));        if (discovererOpt.isPresent()) {            discoverer = discovererOpt.get();        } else {            Optional<Object> clientOptional = context.getCapability(Context.Capabilities.ZOOKEEPER_CLIENT);            CuratorFramework client = null;            if (clientOptional.isPresent() && clientOptional.get() instanceof CuratorFramework) {                client = (CuratorFramework) clientOptional.get();            } else {                throw new IllegalStateException("Unable to initialize function: Cannot find zookeeper client.");            }            discoverer = createDiscoverer(client);        }    } catch (Exception ex) {            } finally {                isInitialized = true;    }}
public boolean metron_f62_0()
{    return isInitialized;}
private static ServiceDiscoverer metron_f63_0(CuratorFramework client) throws Exception
{    MaaSConfig config = ConfigUtil.INSTANCE.read(client, "/metron/maas/config", new MaaSConfig(), MaaSConfig.class);    ServiceDiscoverer discoverer = new ServiceDiscoverer(client, config.getServiceRoot());    discoverer.start();    return discoverer;}
public Object metron_f64_1(List<Object> args, Context context) throws ParseException
{    if (!isValidState) {                return null;    }    String modelName = null;    String modelVersion = null;    if (args.size() >= 1) {        modelName = args.get(0).toString();    }    if (args.size() >= 2) {        modelVersion = args.get(1).toString();    }    if (modelName == null) {        return null;    }    try {        ModelEndpoint ep = null;        if (modelVersion == null) {            ep = discoverer.getEndpoint(modelName);        } else {            ep = discoverer.getEndpoint(modelName, modelVersion);        }        return ep == null ? null : endpointToMap(ep.getName(), ep.getVersion(), ep.getEndpoint());    } catch (Exception ex) {                return null;    }}
public static Map<String, String> metron_f65_0(String name, String version, Endpoint ep)
{    Map<String, String> ret = new HashMap<>();    ret.put("url", ep.getUrl());    ret.put("name", name);    ret.put("version", version);    for (Map.Entry<String, String> kv : ep.getFunctions().entrySet()) {        ret.put("endpoint:" + kv.getKey(), kv.getValue());    }    return ret;}
public synchronized void metron_f66_1(Context context)
{    try {        Optional<Object> clientOptional = context.getCapability(Context.Capabilities.ZOOKEEPER_CLIENT);        CuratorFramework client = null;        if (clientOptional.isPresent() && clientOptional.get() instanceof CuratorFramework) {            client = (CuratorFramework) clientOptional.get();        } else {            throw new IllegalStateException("Unable to initialize function: Cannot find zookeeper client.");        }        try {            discoverer = createDiscoverer(client);            context.addCapability(Context.Capabilities.SERVICE_DISCOVERER, () -> discoverer);            isValidState = true;        } catch (Exception e) {                        throw new IllegalStateException("Unable to initialize MAAS_GET_ENDPOINT", e);        }    } finally {        isInitialized = true;    }}
public boolean metron_f67_0()
{    return isInitialized;}
public Queue<ModelRequest> metron_f68_0(Map<String, Object> config)
{    return queueCreator.apply(config);}
public ModelRequest metron_f69_0()
{    try {        byte[] payload = queue.take();        return ConfigUtil.INSTANCE.read(payload, ModelRequest.class);    } catch (Exception e) {        throw new IllegalStateException("Unable to dequeue: " + e.getMessage(), e);    }}
public void metron_f70_0(ModelRequest request)
{    try {        byte[] payload = ConfigUtil.INSTANCE.toBytes(request);        queue.offer(payload);    } catch (Exception e) {        throw new IllegalStateException("Unable to enqueue: " + e.getMessage(), e);    }}
public void metron_f71_0(Map<String, Object> config)
{    String path = (String) config.get(ZK_PATH);    if (path == null) {        throw new IllegalStateException("You must specify " + ZK_PATH + " for a zk queue");    }    CuratorFramework client = (CuratorFramework) config.get(ZK_CLIENT);    queue = new SimpleDistributedQueue(client, path);}
protected ObjectMapper metron_f72_0()
{    return new ObjectMapper();}
public T metron_f73_0(CuratorFramework client, String root, T def, Class<T> clazz) throws Exception
{    try {        byte[] data = client.getData().forPath(root);        return read(data, clazz);    } catch (KeeperException.NoNodeException nne) {        return def;    }}
public T metron_f74_0(byte[] data, Class<T> clazz) throws Exception
{    return _mapper.get().readValue(data, clazz);}
public byte[] metron_f75_0(Object o) throws IOException
{    return _mapper.get().writeValueAsBytes(o);}
protected HttpClient metron_f76_0()
{        return new DefaultHttpClient();}
public String metron_f77_0(URL endpointUrl, Map<String, String> getArgs) throws IOException, URISyntaxException
{    String encodedParams = encodeParams(getArgs);    HttpGet get = new HttpGet(appendToUrl(endpointUrl, encodedParams).toURI());    get.addHeader("accept", "application/json");    HttpResponse response = CLIENT.get().execute(get);    if (response.getStatusLine().getStatusCode() != 200) {        throw new IllegalStateException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());    }    return new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));}
public URL metron_f78_0(URL endpointUrl, String params) throws MalformedURLException
{    return new URL(endpointUrl.toString() + "?" + params);}
public String metron_f79_0(Map<String, String> params)
{    Iterable<NameValuePair> nvp = Iterables.transform(params.entrySet(), kv -> new BasicNameValuePair(kv.getKey(), kv.getValue()));    return URLEncodedUtils.format(nvp, Charset.defaultCharset());}
public void metron_f80_0() throws Exception
{    testZkServer = new TestingServer(true);    zookeeperUrl = testZkServer.getConnectString();    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);    client = CuratorFrameworkFactory.newClient(zookeeperUrl, retryPolicy);    client.start();    discoverer = new ServiceDiscoverer(client, "/maas/discover");    discoverer.start();}
private ServiceInstance<ModelEndpoint> metron_f81_0(ModelEndpoint ep) throws Exception
{    URL url = new URL(ep.getEndpoint().getUrl());    ServiceInstanceBuilder<ModelEndpoint> builder = ServiceInstance.<ModelEndpoint>builder().address(url.getHost()).id(ep.getContainerId()).name(ep.getName()).port(url.getPort()).registrationTimeUTC(System.currentTimeMillis()).serviceType(ServiceType.STATIC).payload(ep);    return builder.build();}
private void metron_f82_0(ModelEndpoint ep) throws Exception
{    discoverer.getServiceDiscovery().registerService(createInstance(ep));}
private void metron_f83_0(String name, String version, AtomicInteger containerId) throws Exception
{    ModelEndpoint ep = new ModelEndpoint();    ep.setName(name);    ep.setVersion(version);    ep.setContainerId(containerId.incrementAndGet() + "");    ep.setEndpoint(new Endpoint() {        {            setUrl("http://localhost:9080/ep1");        }    });    registerService(ep);}
public void metron_f84_0() throws Exception
{        AtomicInteger containerId = new AtomicInteger(0);    registerService("casey", "3.14159", containerId);    registerService("casey", "3.14159", containerId);    registerService("casey", "3.14159", containerId);    registerService("casey", "3.1416", containerId);        Thread.sleep(2000);    Assert.assertEquals(3, discoverer.getEndpoints(new Model("casey", "3.14159")).size());    Assert.assertEquals(1, discoverer.getEndpoints(new Model("casey", "3.1416")).size());    Assert.assertEquals(0, discoverer.getEndpoints(new Model("casey", "3.17")).size());    discoverer.unregisterByContainer("1");    Thread.sleep(2000);    Assert.assertEquals(2, discoverer.getEndpoints(new Model("casey", "3.14159")).size());    Assert.assertEquals(1, discoverer.getEndpoints(new Model("casey", "3.1416")).size());    Assert.assertEquals(0, discoverer.getEndpoints(new Model("casey", "3.17")).size());    Assert.assertEquals(2, discoverer.listEndpoints(new Model("casey", null)).keySet().size());    Assert.assertEquals(1, discoverer.listEndpoints(new Model("casey", "3.1416")).keySet().size());    Assert.assertEquals(1, discoverer.listEndpoints(new Model("casey", "3.1416")).get(new Model("casey", "3.1416")).size());    Assert.assertEquals("4", discoverer.listEndpoints(new Model("casey", "3.1416")).get(new Model("casey", "3.1416")).get(0).getContainerId());    Assert.assertEquals(0, discoverer.listEndpoints(new Model("casey", "3.17")).keySet().size());    Assert.assertEquals(0, discoverer.listEndpoints(new Model("dummy", null)).keySet().size());}
public void metron_f85_0() throws Exception
{    if (discoverer != null) {        CloseableUtils.closeQuietly(discoverer);    }    if (client != null) {        CloseableUtils.closeQuietly(client);    }    if (testZkServer != null) {        CloseableUtils.closeQuietly(testZkServer);    }}
public boolean metron_f86_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f87_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public String metron_f88_0(CommandLine cli, String def)
{    return has(cli) ? cli.getOptionValue(shortCode) : def;}
public Map.Entry<AMOptions, String> metron_f89_0(String value)
{    if (option.hasArg()) {        return new AbstractMap.SimpleEntry<>(this, value);    }    return new AbstractMap.SimpleEntry<>(this, null);}
public static String metron_f90_0(Map.Entry<AMOptions, String>... arg)
{    return Joiner.on(" ").join(Iterables.transform(Arrays.asList(arg), a -> "-" + a.getKey().shortCode + (a.getValue() == null ? "" : (" " + a.getValue()))));}
public static CommandLine metron_f91_0(CommandLineParser parser, String[] args) throws ParseException
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        throw e;    }}
public static void metron_f92_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("MaaSApplicationMaster", getOptions());}
public static Options metron_f93_0()
{    Options ret = new Options();    for (AMOptions o : AMOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public static void metron_f94_1(String[] args)
{    boolean result = false;    try {        ApplicationMaster appMaster = new ApplicationMaster();                boolean doRun = appMaster.init(args);        if (!doRun) {            System.exit(0);        }        appMaster.run();        result = appMaster.finish();    } catch (Throwable t) {                LogManager.shutdown();        ExitUtil.terminate(1, t);    }    if (result) {                System.exit(0);    } else {                System.exit(2);    }}
public boolean metron_f95_1(String[] args) throws ParseException, IOException
{    CommandLine cliParser = AMOptions.parse(new GnuParser(), args);        if (fileExist(log4jPath)) {        try {            Log4jPropertyHelper.updateLog4jConfiguration(ApplicationMaster.class, log4jPath);        } catch (Exception e) {                    }    }    if (AMOptions.HELP.has(cliParser)) {        AMOptions.printHelp();        return false;    }    zkQuorum = AMOptions.ZK_QUORUM.get(cliParser);    zkRoot = AMOptions.ZK_ROOT.get(cliParser);    appJarPath = new Path(AMOptions.APP_JAR_PATH.get(cliParser));    Map<String, String> envs = System.getenv();    if (!envs.containsKey(Environment.CONTAINER_ID.name())) {        if (AMOptions.APP_ATTEMPT_ID.has(cliParser)) {            String appIdStr = AMOptions.APP_ATTEMPT_ID.get(cliParser, "");            appAttemptID = ConverterUtils.toApplicationAttemptId(appIdStr);        } else {            throw new IllegalArgumentException("Application Attempt Id not set in the environment");        }    } else {        ContainerId containerId = ConverterUtils.toContainerId(envs.get(Environment.CONTAINER_ID.name()));        appAttemptID = containerId.getApplicationAttemptId();    }    if (!envs.containsKey(ApplicationConstants.APP_SUBMIT_TIME_ENV)) {        throw new RuntimeException(ApplicationConstants.APP_SUBMIT_TIME_ENV + " not set in the environment");    }    if (!envs.containsKey(Environment.NM_HOST.name())) {        throw new RuntimeException(Environment.NM_HOST.name() + " not set in the environment");    }    if (!envs.containsKey(Environment.NM_HTTP_PORT.name())) {        throw new RuntimeException(Environment.NM_HTTP_PORT + " not set in the environment");    }    if (!envs.containsKey(Environment.NM_PORT.name())) {        throw new RuntimeException(Environment.NM_PORT.name() + " not set in the environment");    }        if (cliParser.hasOption("shell_env")) {        String[] shellEnvs = cliParser.getOptionValues("shell_env");        for (String env : shellEnvs) {            env = env.trim();            int index = env.indexOf('=');            if (index == -1) {                shellEnv.put(env, "");                continue;            }            String key = env.substring(0, index);            String val = "";            if (index < (env.length() - 1)) {                val = env.substring(index + 1);            }            shellEnv.put(key, val);        }    }    if (envs.containsKey(Constants.TIMELINEDOMAIN)) {        domainId = envs.get(Constants.TIMELINEDOMAIN);    }    return true;}
public void metron_f96_1() throws YarnException, IOException, InterruptedException
{                Credentials credentials = UserGroupInformation.getCurrentUser().getCredentials();    allTokens = YarnUtils.INSTANCE.tokensFromCredentials(credentials);        appSubmitterUgi = YarnUtils.INSTANCE.createUserGroup(credentials);    startTimelineClient(conf);    if (timelineClient != null) {        YarnUtils.INSTANCE.publishApplicationAttemptEvent(timelineClient, appAttemptID.toString(), ContainerEvents.APP_ATTEMPT_START, domainId, appSubmitterUgi);    }    int minSize = getMinContainerMemoryIncrement(conf);    listener = new ContainerRequestListener(timelineClient, appSubmitterUgi, domainId, minSize);    amRMClient = AMRMClientAsync.createAMRMClientAsync(1000, listener);    amRMClient.init(conf);    amRMClient.start();    nmClientAsync = new NMClientAsyncImpl(listener);    nmClientAsync.init(conf);    nmClientAsync.start();                                appMasterHostname = NetUtils.getHostname();    RegisterApplicationMasterResponse response = amRMClient.registerApplicationMaster(appMasterHostname, appMasterRpcPort, appMasterTrackingUrl);            int maxMem = response.getMaximumResourceCapability().getMemory();        int maxVCores = response.getMaximumResourceCapability().getVirtualCores();        maasHandler = new MaaSHandler(zkQuorum, zkRoot);    try {        maasHandler.start();        maasHandler.getDiscoverer().resetState();        listener.initialize(amRMClient, nmClientAsync, maasHandler.getDiscoverer());    } catch (Exception e) {        throw new IllegalStateException("Unable to find zookeeper", e);    }    EnumMap<Resources, Integer> maxResources = Resources.toResourceMap(Resources.MEMORY.of(maxMem), Resources.V_CORE.of(maxVCores));    requestQueue = maasHandler.getConfig().createQueue(ImmutableMap.of(ZKQueue.ZK_CLIENT, maasHandler.getClient()));        while (true) {        ModelRequest request = requestQueue.dequeue();        if (request == null) {                        continue;        }                EnumMap<Resources, Integer> resourceRequest = Resources.toResourceMap(Resources.MEMORY.of(request.getMemory()), Resources.V_CORE.of(1));        EnumMap<Resources, Integer> resources = Resources.getRealisticResourceRequest(maxResources, Resources.toResource(resourceRequest));        Resource resource = Resources.toResource(resources);        Path appMasterJar = getAppMasterJar();        if (request.getAction() == Action.ADD) {            listener.requestContainers(request.getNumInstances(), resource);            for (int i = 0; i < request.getNumInstances(); ++i) {                Container container = listener.getContainers(resource).take();                                executor.execute(new LaunchContainer(conf, zkQuorum, zkRoot, nmClientAsync, request, container, allTokens, appMasterJar));                listener.getContainerState().registerRequest(container, request);            }        } else if (request.getAction() == Action.REMOVE) {            listener.removeContainers(request.getNumInstances(), request);        }    }}
private Path metron_f97_0()
{    return appJarPath;}
private int metron_f98_0(Configuration conf)
{    String incrementStr = conf.get("yarn.scheduler.increment-allocation-mb");    if (incrementStr == null || incrementStr.length() == 0) {        incrementStr = conf.get("yarn.scheduler.minimum-allocation-mb");    }    return Integer.parseInt(incrementStr);}
 void metron_f99_1(final Configuration conf) throws YarnException, IOException, InterruptedException
{    try {        appSubmitterUgi.doAs(new PrivilegedExceptionAction<Void>() {            @Override            public Void run() throws Exception {                if (conf.getBoolean(YarnConfiguration.TIMELINE_SERVICE_ENABLED, YarnConfiguration.DEFAULT_TIMELINE_SERVICE_ENABLED)) {                                        timelineClient = TimelineClient.createTimelineClient();                    timelineClient.init(conf);                    timelineClient.start();                } else {                    timelineClient = null;                                    }                return null;            }        });    } catch (UndeclaredThrowableException e) {        throw new YarnException(e.getCause());    }}
public Void metron_f100_1() throws Exception
{    if (conf.getBoolean(YarnConfiguration.TIMELINE_SERVICE_ENABLED, YarnConfiguration.DEFAULT_TIMELINE_SERVICE_ENABLED)) {                timelineClient = TimelineClient.createTimelineClient();        timelineClient.init(conf);        timelineClient.start();    } else {        timelineClient = null;            }    return null;}
protected boolean metron_f101_0()
{    return true;}
private boolean metron_f102_0(String filePath)
{    return new File(filePath).exists();}
public void metron_f103_0(AMRMClientAsync<AMRMClient.ContainerRequest> amRMClient, NMClientAsync nmClient, ServiceDiscoverer serviceDiscoverer)
{    this.nmClient = nmClient;    this.amRMClient = amRMClient;    this.serviceDiscoverer = serviceDiscoverer;}
public void metron_f104_0(int number, ModelRequest request)
{    int i = 0;    for (Container c : state.getList(request)) {        if (i < number) {            amRMClient.releaseAssignedContainer(c.getId());            nmClient.stopContainerAsync(c.getId(), c.getNodeId());        } else {            break;        }        i++;    }}
public ContainerTracker metron_f105_0()
{    return state;}
private void metron_f106_0(ContainerId id)
{    containers.remove(id);    state.removeContainer(id);}
public void metron_f107_0(int number, Resource characteristic)
{    Priority pri = Priority.newInstance(0);    state.getQueue(characteristic);    AMRMClient.ContainerRequest request = new AMRMClient.ContainerRequest(characteristic, null, null, pri, true);    for (int i = 0; i < number; ++i) {        amRMClient.addContainerRequest(request);    }}
public void metron_f108_1(List<ContainerStatus> completedContainers)
{        for (ContainerStatus containerStatus : completedContainers) {                removeContainer(containerStatus.getContainerId());                serviceDiscoverer.unregisterByContainer(containerStatus.getContainerId() + "");                assert (containerStatus.getState() == ContainerState.COMPLETE);                int exitStatus = containerStatus.getExitStatus();        if (0 != exitStatus) {                        if (ContainerExitStatus.ABORTED != exitStatus) {                                    } else {                                                            }        } else {                                            }        if (timelineClient != null) {            YarnUtils.INSTANCE.publishContainerEndEvent(timelineClient, containerStatus, domainId, appSubmitterUgi);        }    }}
public BlockingQueue<Container> metron_f109_0(Resource resource)
{    return state.getQueue(resource);}
public void metron_f110_1(List<Container> allocatedContainers)
{        for (Container allocatedContainer : allocatedContainers) {        containers.put(allocatedContainer.getId(), allocatedContainer);        state.registerContainer(allocatedContainer.getResource(), allocatedContainer);            }}
public float metron_f113_0()
{        float progress = 0;    return progress;}
public void metron_f114_1(Throwable e)
{    }
public void metron_f115_1(ContainerId containerId)
{    if (LOG.isDebugEnabled()) {            }    if (containerId == null) {                throw new IllegalStateException("onContainerStopped returned null container ID!");    }    serviceDiscoverer.unregisterByContainer(containerId.getContainerId() + "");    removeContainer(containerId);}
public void metron_f116_1(ContainerId containerId, ContainerStatus containerStatus)
{    if (LOG.isDebugEnabled()) {            }}
public void metron_f117_1(ContainerId containerId, Map<String, ByteBuffer> allServiceResponse)
{    if (LOG.isDebugEnabled()) {            }    Container container = containers.get(containerId);    if (container != null) {        nmClient.getContainerStatusAsync(containerId, container.getNodeId());    }    if (timelineClient != null && container != null) {        YarnUtils.INSTANCE.publishContainerStartEvent(timelineClient, container, domainId, appSubmitterUgi);    }}
public void metron_f118_1(ContainerId containerId, Throwable t)
{        serviceDiscoverer.unregisterByContainer(containerId.getContainerId() + "");    removeContainer(containerId);}
public void metron_f119_1(ContainerId containerId, Throwable t)
{    }
public void metron_f120_1(ContainerId containerId, Throwable t)
{        serviceDiscoverer.unregisterByContainer(containerId.getContainerId() + "");    removeContainer(containerId);}
public void metron_f121_1()
{            Map<String, LocalResource> localResources = new HashMap<>();        for (File f : new File(".").listFiles()) {            }        String modelScript = localizeResources(localResources, new Path(request.getPath()), appJarLocation);    for (Map.Entry<String, LocalResource> entry : localResources.entrySet()) {            }                        Map<String, String> env = new HashMap<>();                            StringBuffer classPathEnv = new StringBuffer("$CLASSPATH:./*:");        classPathEnv.append(System.getProperty("java.class.path"));        env.put("CLASSPATH", classPathEnv.toString());        String command = ApplicationConstants.Environment.JAVA_HOME.$$() + "/bin/java " + Runner.class.getName() + " " + RunnerOptions.toArgs(RunnerOptions.CONTAINER_ID.of(container.getId().getContainerId() + ""), RunnerOptions.ZK_QUORUM.of(zkQuorum), RunnerOptions.ZK_ROOT.of(zkRoot), RunnerOptions.SCRIPT.of(modelScript), RunnerOptions.NAME.of(request.getName()), RunnerOptions.HOSTNAME.of(containerHostname()), RunnerOptions.VERSION.of(request.getVersion())) + " 1>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stdout" + " 2>" + ApplicationConstants.LOG_DIR_EXPANSION_VAR + "/stderr";    List<String> commands = new ArrayList<String>();        commands.add(command);                                    ContainerLaunchContext ctx = ContainerLaunchContext.newInstance(localResources, env, commands, null, allTokens.duplicate(), null);        nmClientAsync.startContainerAsync(container, ctx);}
private Map.Entry<String, LocalResource> metron_f122_0(FileStatus status)
{    URL url = ConverterUtils.getYarnUrlFromURI(status.getPath().toUri());    LocalResource resource = LocalResource.newInstance(url, LocalResourceType.FILE, LocalResourceVisibility.APPLICATION, status.getLen(), status.getModificationTime());    String name = status.getPath().getName();    return new AbstractMap.SimpleEntry<>(name, resource);}
public String metron_f123_1(Map<String, LocalResource> resources, Path scriptLocation, Path appJarLocation)
{    try {                        FileSystem fs = scriptLocation.getFileSystem(conf);        String script = null;        Map.Entry<String, LocalResource> kv = localizeResource(fs.getFileStatus(appJarLocation));        resources.put(kv.getKey(), kv.getValue());        for (RemoteIterator<LocatedFileStatus> it = fs.listFiles(scriptLocation, true); it.hasNext(); ) {            LocatedFileStatus status = it.next();            kv = localizeResource(status);            String name = kv.getKey();            if (name.endsWith(".sh")) {                script = name;            }                        resources.put(name, kv.getValue());        }        return script;    } catch (Exception e) {                return null;    }}
private String metron_f124_1()
{    String nodeHost = null;    try {        boolean hasProtocol = container.getNodeHttpAddress().startsWith("http");        java.net.URL nodehttpAddress = new java.net.URL((hasProtocol ? "" : "http://") + container.getNodeHttpAddress());        nodeHost = nodehttpAddress.getHost();    } catch (MalformedURLException e) {                throw new IllegalStateException("Unable to parse " + container.getNodeHttpAddress() + " into a URL");    }    return nodeHost;}
public static void metron_f125_1(String[] args)
{    boolean result = false;    try {        Client client = new Client();                try {            boolean doRun = client.init(args);            if (!doRun) {                System.exit(0);            }        } catch (IllegalArgumentException e) {            System.err.println(e.getLocalizedMessage());            System.exit(-1);        }        result = client.run();    } catch (Throwable t) {                System.exit(1);    }    if (result) {                System.exit(0);    }        System.exit(2);}
public boolean metron_f126_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f127_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public String metron_f128_0(CommandLine cli, String def)
{    return has(cli) ? cli.getOptionValue(shortCode) : def;}
public Map.Entry<ClientOptions, String> metron_f129_0(String value)
{    if (option.hasArg()) {        return new AbstractMap.SimpleEntry<>(this, value);    }    return new AbstractMap.SimpleEntry<>(this, null);}
public static String metron_f130_0(Map.Entry<ClientOptions, String>... arg)
{    return Joiner.on(" ").join(Iterables.transform(Arrays.asList(arg), a -> "-" + a.getKey().shortCode + (a.getValue() == null ? "" : (" " + a.getValue()))));}
public static CommandLine metron_f131_0(CommandLineParser parser, String[] args) throws ParseException
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        throw e;    }}
public static void metron_f132_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("MaaSClient", getOptions());}
public static Options metron_f133_0()
{    Options ret = new Options();    for (ClientOptions o : ClientOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public static String metron_f134_0(Class klass) throws URISyntaxException
{    return klass.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();}
public boolean metron_f135_1(String[] args) throws ParseException
{    CommandLine cli = ClientOptions.parse(new PosixParser(), args);    if (LOG4J_PROPERTIES.has(cli)) {        String log4jPath = LOG4J_PROPERTIES.get(cli);        try {            Log4jPropertyHelper.updateLog4jConfiguration(Client.class, log4jPath);        } catch (Exception e) {                    }    }    keepContainers = false;    zkQuorum = ZK_QUORUM.get(cli);    zkRoot = ZK_ROOT.get(cli, "/metron/maas/config");    appName = "MaaS";    amPriority = 0;    amQueue = QUEUE.get(cli, "default");    amMemory = Integer.parseInt(MASTER_MEMORY.get(cli, "10"));    amVCores = Integer.parseInt(MASTER_VCORE.get(cli, "1"));    if (amMemory < 0) {        throw new IllegalArgumentException("Invalid memory specified for application master, exiting." + " Specified memory=" + amMemory);    }    if (amVCores < 0) {        throw new IllegalArgumentException("Invalid virtual cores specified for application master, exiting." + " Specified virtual cores=" + amVCores);    }    if (!JAR.has(cli)) {        try {            appMasterJar = getJar(ApplicationMaster.class);        } catch (URISyntaxException e) {            throw new IllegalArgumentException("No jar file specified for application master: " + e.getMessage(), e);        }    } else {        appMasterJar = JAR.get(cli);    }    if (SHELL_ENV.has(cli)) {        String[] envs = cli.getOptionValues(SHELL_ENV.option.getOpt());        for (String env : envs) {            env = env.trim();            int index = env.indexOf('=');            if (index == -1) {                shellEnv.put(env, "");                continue;            }            String key = env.substring(0, index);            String val = "";            if (index < (env.length() - 1)) {                val = env.substring(index + 1);            }            shellEnv.put(key, val);        }    }    nodeLabelExpression = NODE_LABEL_EXPRESSION.get(cli, null);    clientTimeout = Integer.parseInt(TIMEOUT.get(cli, "600000"));    attemptFailuresValidityInterval = -1;    log4jPropFile = LOG4J_PROPERTIES.get(cli, "");        if (DOMAIN.has(cli)) {        domainId = DOMAIN.get(cli);        toCreateDomain = CREATE.has(cli);        if (VIEW_ACLS.has(cli)) {            viewACLs = VIEW_ACLS.get(cli);        }        if (MODIFY_ACLS.has(cli)) {            modifyACLs = MODIFY_ACLS.get(cli);        }    }    return true;}
private boolean metron_f137_1(ApplicationId appId) throws YarnException, IOException
{    while (true) {                try {            Thread.sleep(1000);        } catch (InterruptedException e) {                    }                ApplicationReport report = yarnClient.getApplicationReport(appId);                YarnApplicationState state = report.getYarnApplicationState();        FinalApplicationStatus dsStatus = report.getFinalApplicationStatus();        if (YarnApplicationState.RUNNING == state) {                        return true;        }        if (YarnApplicationState.FINISHED == state) {            if (FinalApplicationStatus.SUCCEEDED == dsStatus) {                                return true;            } else {                                return false;            }        } else if (YarnApplicationState.KILLED == state || YarnApplicationState.FAILED == state) {                        return false;        }        if (System.currentTimeMillis() > (clientStartTime + clientTimeout)) {                        forceKillApplication(appId);            return false;        }    }}
private void metron_f138_0(ApplicationId appId) throws YarnException, IOException
{                        yarnClient.killApplication(appId);}
private void metron_f139_0(FileSystem fs, String appId) throws IOException
{    for (Path p : ImmutableList.of(new Path(fs.getHomeDirectory(), appName), new Path(fs.getHomeDirectory(), appName + "/" + appId))) {        if (!fs.exists(p)) {            fs.mkdirs(p);            fs.setPermission(p, new FsPermission((short) 0755));        }    }}
private Path metron_f140_0(FileSystem fs, String fileSrcPath, String fileDstPath, String appId, Map<String, LocalResource> localResources, String resources) throws IOException
{    String suffix = appName + "/" + appId + "/" + fileDstPath;    Path dst = new Path(fs.getHomeDirectory(), suffix);    if (fileSrcPath == null) {        FSDataOutputStream ostream = null;        try {            ostream = FileSystem.create(fs, dst, new FsPermission((short) 0710));            ostream.writeUTF(resources);        } finally {            IOUtils.closeQuietly(ostream);        }    } else {        fs.copyFromLocalFile(new Path(fileSrcPath), dst);    }    fs.setPermission(dst, new FsPermission((short) 0755));    FileStatus scFileStatus = fs.getFileStatus(dst);    LocalResource scRsrc = LocalResource.newInstance(ConverterUtils.getYarnUrlFromURI(dst.toUri()), LocalResourceType.FILE, LocalResourceVisibility.APPLICATION, scFileStatus.getLen(), scFileStatus.getModificationTime());    localResources.put(fileDstPath, scRsrc);    return dst;}
private void metron_f141_1()
{    TimelineClient timelineClient = null;    if (conf.getBoolean(YarnConfiguration.TIMELINE_SERVICE_ENABLED, YarnConfiguration.DEFAULT_TIMELINE_SERVICE_ENABLED)) {        timelineClient = TimelineClient.createTimelineClient();        timelineClient.init(conf);        timelineClient.start();    } else {                return;    }    try {        TimelineDomain domain = new TimelineDomain();        domain.setId(domainId);        domain.setReaders(viewACLs != null && viewACLs.length() > 0 ? viewACLs : " ");        domain.setWriters(modifyACLs != null && modifyACLs.length() > 0 ? modifyACLs : " ");        timelineClient.putDomain(domain);            } catch (Exception e) {            } finally {        timelineClient.stop();    }}
public int metron_f142_0(int size)
{    return (int) (minimumContainerSize * Math.ceil(1.0 * size / minimumContainerSize));}
public BlockingQueue<Container> metron_f143_0(Resource resource)
{    synchronized (acceptedContainersByResource) {        int key = getAdjustedSize(resource.getMemory());        BlockingQueue<Container> queue = acceptedContainersByResource.get(key);        if (queue == null) {            queue = new LinkedBlockingDeque<>();            acceptedContainersByResource.put(key, queue);        }        return queue;    }}
public void metron_f144_0(ContainerId container)
{    synchronized (acceptedContainersByResource) {        for (Map.Entry<Model, List<Container>> kv : launchedContainers.entrySet()) {            for (Iterator<Container> it = kv.getValue().iterator(); it.hasNext(); ) {                Container c = it.next();                if (c.getId().equals(container)) {                    it.remove();                }            }        }    }}
public List<Container> metron_f145_0(ModelRequest request)
{    synchronized (acceptedContainersByResource) {        List<Container> containers = launchedContainers.get(new Model(request.getName(), request.getVersion()));        if (containers == null) {            containers = new ArrayList<>();            launchedContainers.put(new Model(request.getName(), request.getVersion()), containers);        }        return containers;    }}
public void metron_f146_0(Resource resource, Container container)
{    synchronized (acceptedContainersByResource) {        BlockingQueue<Container> queue = getQueue(resource);        queue.add(container);    }}
public void metron_f147_0(Container container, ModelRequest request)
{    synchronized (acceptedContainersByResource) {        getList(request).add(container);    }}
public static void metron_f148_0(Class<?> targetClass, String log4jPath) throws Exception
{    Properties customProperties = new Properties();    FileInputStream fs = null;    InputStream is = null;    try {        fs = new FileInputStream(log4jPath);        is = targetClass.getResourceAsStream("/log4j.properties");        customProperties.load(fs);        Properties originalProperties = new Properties();        originalProperties.load(is);        for (Entry<Object, Object> entry : customProperties.entrySet()) {            originalProperties.setProperty(entry.getKey().toString(), entry.getValue().toString());        }        LogManager.resetConfiguration();        PropertyConfigurator.configure(originalProperties);    } finally {        IOUtils.closeQuietly(is);        IOUtils.closeQuietly(fs);    }}
public MaaSConfig metron_f149_0()
{    return config;}
public CuratorFramework metron_f150_0()
{    return client;}
public void metron_f151_0() throws Exception
{    if (client == null) {        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);        client = CuratorFrameworkFactory.newClient(zkQuorum, retryPolicy);        client.start();    }    config = ConfigUtil.INSTANCE.read(client, root, new MaaSConfig(), MaaSConfig.class);    cache = new NodeCache(client, root);    cache.getListenable().addListener(() -> {        byte[] data = cache.getCurrentData().getData();        Lock wLock = lock.writeLock();        wLock.lock();        try {            config = _mapper.readValue(data, MaaSConfig.class);        } finally {            wLock.unlock();        }    });    discoverer = new ServiceDiscoverer(client, config.getServiceRoot());    discoverer.start();}
public ServiceDiscoverer metron_f152_0()
{    return discoverer;}
public Map.Entry<RunnerOptions, String> metron_f153_0(String value)
{    if (option.hasArg()) {        return new AbstractMap.SimpleEntry<>(this, value);    }    return new AbstractMap.SimpleEntry<>(this, null);}
public static String metron_f154_0(Map.Entry<RunnerOptions, String>... arg)
{    return Joiner.on(" ").join(Iterables.transform(Arrays.asList(arg), a -> "-" + a.getKey().shortCode + (a.getValue() == null ? "" : (" " + a.getValue()))));}
public boolean metron_f155_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f156_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public String metron_f157_0(CommandLine cli, String def)
{    return has(cli) ? cli.getOptionValue(shortCode) : def;}
public static CommandLine metron_f158_0(CommandLineParser parser, String[] args) throws ParseException
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        throw e;    }}
public static void metron_f159_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("MaaSRunner", getOptions());}
public static Options metron_f160_0()
{    Options ret = new Options();    for (RunnerOptions o : RunnerOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public static void metron_f161_1(String... argv) throws Exception
{    CommandLine cli = RunnerOptions.parse(new PosixParser(), argv);    String zkQuorum = RunnerOptions.ZK_QUORUM.get(cli);    String zkRoot = RunnerOptions.ZK_ROOT.get(cli);    String script = RunnerOptions.SCRIPT.get(cli);    String name = RunnerOptions.NAME.get(cli);    String version = RunnerOptions.VERSION.get(cli);    String containerId = RunnerOptions.CONTAINER_ID.get(cli);    String hostname = RunnerOptions.HOSTNAME.get(cli);    CuratorFramework client = null;            for (File f : new File(".").listFiles()) {            }    try {        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);        client = CuratorFrameworkFactory.newClient(zkQuorum, retryPolicy);        client.start();        MaaSConfig config = ConfigUtil.INSTANCE.read(client, zkRoot, new MaaSConfig(), MaaSConfig.class);        JsonInstanceSerializer<ModelEndpoint> serializer = new JsonInstanceSerializer<>(ModelEndpoint.class);        try {            serviceDiscovery = ServiceDiscoveryBuilder.builder(ModelEndpoint.class).client(client).basePath(config.getServiceRoot()).serializer(serializer).build();        } finally {        }                serviceDiscovery.start();        File cwd = new File(script).getParentFile();        File scriptFile = new File(cwd, script);        if (scriptFile.exists() && !scriptFile.canExecute()) {            scriptFile.setExecutable(true);        }        final String cmd = scriptFile.getAbsolutePath();        try {            p = new ProcessBuilder(cmd).directory(cwd).start();        } catch (Exception e) {                                    throw new IllegalStateException(e.getMessage(), e);        }        try {                        Endpoint ep = readEndpoint(cwd);            URL endpointUrl = correctLocalUrl(hostname, ep.getUrl());            ep.setUrl(endpointUrl.toString());                        ModelEndpoint endpoint = new ModelEndpoint();            {                endpoint.setName(name);                endpoint.setContainerId(containerId);                endpoint.setEndpoint(ep);                endpoint.setVersion(version);            }            ;            ServiceInstanceBuilder<ModelEndpoint> builder = ServiceInstance.<ModelEndpoint>builder().address(endpointUrl.getHost()).id(containerId).name(name).port(endpointUrl.getPort()).registrationTimeUTC(System.currentTimeMillis()).serviceType(ServiceType.STATIC).payload(endpoint);            final ServiceInstance<ModelEndpoint> instance = builder.build();            try {                                serviceDiscovery.registerService(instance);                            } catch (Throwable t) {                            }            Runtime.getRuntime().addShutdownHook(new Thread() {                @Override                public void run() {                                        if (p != null) {                                                p.destroyForcibly();                    }                }            });        } finally {            if (p.waitFor() != 0) {                String stderr = Joiner.on("\n").join(IOUtils.readLines(p.getErrorStream()));                String stdout = Joiner.on("\n").join(IOUtils.readLines(p.getInputStream()));                throw new IllegalStateException("Unable to execute " + script + ".  Stderr is: " + stderr + "\nStdout is: " + stdout);            }        }    } finally {        if (serviceDiscovery != null) {            CloseableUtils.closeQuietly(serviceDiscovery);        }        if (client != null) {            CloseableUtils.closeQuietly(client);        }    }}
public void metron_f162_1()
{        if (p != null) {                p.destroyForcibly();    }}
private static URL metron_f163_1(String hostname, String tmpUrl) throws MalformedURLException
{    URL tmp = new URL(tmpUrl);    if (hostname != null && hostname.length() > 0 && localAddresses.contains(tmp.getHost())) {        URL endpointUrl = null;        try {            endpointUrl = new URL(tmp.getProtocol(), hostname, tmp.getPort(), tmp.getFile());        } catch (MalformedURLException e) {                        return tmp;        }        return endpointUrl;    }    return tmp;}
private static Endpoint metron_f164_1(File cwd) throws Exception
{    String content = "";    File f = new File(cwd, Constants.ENDPOINT_DAT);    for (int i = 0; i < NUM_ATTEMPTS; i++) {        if (f.exists()) {            try {                content = Files.toString(f, Charsets.US_ASCII);            } catch (IOException ioe) {            }            if (content != null && content.length() > 0) {                try {                    Endpoint ep = ConfigUtil.INSTANCE.read(content.getBytes(StandardCharsets.UTF_8), Endpoint.class);                    return ep;                } catch (Exception ex) {                                    }            }        }        Thread.sleep(SLEEP_AMT);    }    throw new IllegalStateException("Unable to start process within the allotted time (10 minutes)");}
public static EnumMap<Resources, Integer> metron_f165_0(EnumMap<Resources, Integer> requestedResources, Resource resource)
{    EnumMap<Resources, Integer> ret = new EnumMap<>(Resources.class);    for (Resources r : values()) {        Integer request = requestedResources.get(r);        int resourceAmt = r.callback.apply(resource);        if (request == null || request < 0) {            ret.put(r, resourceAmt);        } else {            ret.put(r, Math.min(resourceAmt, request));        }    }    return ret;}
public Map.Entry<Resources, Integer> metron_f166_0(int n)
{    return new AbstractMap.SimpleEntry<>(this, n);}
public static EnumMap<Resources, Integer> metron_f167_0(Map.Entry<Resources, Integer>... entry)
{    EnumMap<Resources, Integer> ret = new EnumMap<>(Resources.class);    for (Map.Entry<Resources, Integer> kv : entry) {        ret.put(kv.getKey(), kv.getValue());    }    return ret;}
public static Resource metron_f168_0(EnumMap<Resources, Integer> resourceMap)
{    return Resource.newInstance(resourceMap.get(Resources.MEMORY), resourceMap.get(Resources.V_CORE));}
public UserGroupInformation metron_f169_0(Credentials credentials) throws IOException
{    credentials = credentials == null ? UserGroupInformation.getCurrentUser().getCredentials() : credentials;    String appSubmitterUserName = System.getenv(ApplicationConstants.Environment.USER.name());    UserGroupInformation appSubmitterUgi = UserGroupInformation.createRemoteUser(appSubmitterUserName);    appSubmitterUgi.addCredentials(credentials);    return appSubmitterUgi;}
public ByteBuffer metron_f170_1(Credentials credentials) throws IOException
{            credentials = credentials == null ? UserGroupInformation.getCurrentUser().getCredentials() : credentials;    DataOutputBuffer dob = new DataOutputBuffer();    credentials.writeTokenStorageToStream(dob);        Iterator<Token<?>> iter = credentials.getAllTokens().iterator();        while (iter.hasNext()) {        Token<?> token = iter.next();                if (token.getKind().equals(AMRMTokenIdentifier.KIND_NAME)) {            iter.remove();        }    }    return ByteBuffer.wrap(dob.getData(), 0, dob.getLength());}
public void metron_f171_1(final TimelineClient timelineClient, ContainerStatus container, String domainId, UserGroupInformation ugi)
{    final TimelineEntity entity = new TimelineEntity();    entity.setEntityId(container.getContainerId().toString());    entity.setEntityType(ApplicationMaster.DSEntity.DS_CONTAINER.toString());    entity.setDomainId(domainId);    entity.addPrimaryFilter("user", ugi.getShortUserName());    TimelineEvent event = new TimelineEvent();    event.setTimestamp(System.currentTimeMillis());    event.setEventType(ContainerEvents.CONTAINER_END.toString());    event.addEventInfo("State", container.getState().name());    event.addEventInfo("Exit Status", container.getExitStatus());    entity.addEvent(event);    try {        timelineClient.putEntities(entity);    } catch (YarnException | IOException e) {            }}
public void metron_f172_1(final TimelineClient timelineClient, String appAttemptId, ContainerEvents appEvent, String domainId, UserGroupInformation ugi)
{    final TimelineEntity entity = new TimelineEntity();    entity.setEntityId(appAttemptId);    entity.setEntityType(ApplicationMaster.DSEntity.DS_APP_ATTEMPT.toString());    entity.setDomainId(domainId);    entity.addPrimaryFilter("user", ugi.getShortUserName());    TimelineEvent event = new TimelineEvent();    event.setEventType(appEvent.toString());    event.setTimestamp(System.currentTimeMillis());    entity.addEvent(event);    try {        timelineClient.putEntities(entity);    } catch (YarnException | IOException e) {            }}
public void metron_f173_1(final TimelineClient timelineClient, Container container, String domainId, UserGroupInformation ugi)
{    final TimelineEntity entity = new TimelineEntity();    entity.setEntityId("" + container.getId());    entity.setEntityType(ApplicationMaster.DSEntity.DS_CONTAINER.toString());    entity.setDomainId(domainId);    entity.addPrimaryFilter("user", ugi.getShortUserName());    TimelineEvent event = new TimelineEvent();    event.setTimestamp(System.currentTimeMillis());    event.setEventType(ContainerEvents.CONTAINER_START.toString());    event.addEventInfo("Node", container.getNodeId().toString());    event.addEventInfo("Resources", container.getResource().toString());    entity.addEvent(event);    try {        ugi.doAs(new PrivilegedExceptionAction<TimelinePutResponse>() {            @Override            public TimelinePutResponse run() throws Exception {                return timelineClient.putEntities(entity);            }        });    } catch (Exception e) {            }}
public TimelinePutResponse metron_f174_0() throws Exception
{    return timelineClient.putEntities(entity);}
public boolean metron_f175_0(CommandLine cli)
{    return cli.hasOption(shortCode);}
public String metron_f176_0(CommandLine cli)
{    return cli.getOptionValue(shortCode);}
public String metron_f177_0(CommandLine cli, String def)
{    return has(cli) ? cli.getOptionValue(shortCode) : def;}
public Map.Entry<ModelSubmissionOptions, String> metron_f178_0(String value)
{    if (option.hasArg()) {        return new AbstractMap.SimpleEntry<>(this, value);    }    return new AbstractMap.SimpleEntry<>(this, null);}
public static String metron_f179_0(Map.Entry<ModelSubmissionOptions, String>... arg)
{    return Joiner.on(" ").join(Iterables.transform(Arrays.asList(arg), a -> "-" + a.getKey().option.getOpt() + (a.getValue() == null ? "" : (" " + a.getValue()))));}
public static CommandLine metron_f180_0(CommandLineParser parser, String[] args) throws ParseException
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("Unable to parse args: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        throw e;    }}
public static void metron_f181_0()
{    HelpFormatter formatter = new HelpFormatter();    formatter.printHelp("ModelSubmission", getOptions());}
public static Options metron_f182_0()
{    Options ret = new Options();    for (ModelSubmissionOptions o : ModelSubmissionOptions.values()) {        ret.addOption(o.option);    }    return ret;}
public void metron_f183_0(FileSystem fs, String... argv) throws Exception
{    CommandLine cli = ModelSubmissionOptions.parse(new PosixParser(), argv);    if (ModelSubmissionOptions.LOG4J_PROPERTIES.has(cli)) {        Log4jPropertyHelper.updateLog4jConfiguration(ModelSubmission.class, ModelSubmissionOptions.LOG4J_PROPERTIES.get(cli));    }    ModelRequest request = null;    CuratorFramework client = null;    try {        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);        client = CuratorFrameworkFactory.newClient(ModelSubmissionOptions.ZK_QUORUM.get(cli), retryPolicy);        client.start();        MaaSConfig config = ConfigUtil.INSTANCE.read(client, ModelSubmissionOptions.ZK_ROOT.get(cli, "/metron/maas/config"), new MaaSConfig(), MaaSConfig.class);        String mode = ModelSubmissionOptions.MODE.get(cli);        if (mode.equalsIgnoreCase("ADD")) {            request = new ModelRequest() {                {                    setName(ModelSubmissionOptions.NAME.get(cli));                    setAction(Action.ADD);                    setVersion(ModelSubmissionOptions.VERSION.get(cli));                    setNumInstances(Integer.parseInt(ModelSubmissionOptions.NUM_INSTANCES.get(cli)));                    setMemory(Integer.parseInt(ModelSubmissionOptions.MEMORY.get(cli)));                    setPath(ModelSubmissionOptions.HDFS_MODEL_PATH.get(cli));                }            };        } else if (mode.equalsIgnoreCase("REMOVE")) {            request = new ModelRequest() {                {                    setName(ModelSubmissionOptions.NAME.get(cli));                    setAction(Action.REMOVE);                    setNumInstances(Integer.parseInt(ModelSubmissionOptions.NUM_INSTANCES.get(cli)));                    setVersion(ModelSubmissionOptions.VERSION.get(cli));                }            };        } else if (mode.equalsIgnoreCase("LIST")) {            String name = ModelSubmissionOptions.NAME.get(cli, null);            String version = ModelSubmissionOptions.VERSION.get(cli, null);            ServiceDiscoverer serviceDiscoverer = new ServiceDiscoverer(client, config.getServiceRoot());            Model model = new Model(name, version);            Map<Model, List<ModelEndpoint>> endpoints = serviceDiscoverer.listEndpoints(model);            for (Map.Entry<Model, List<ModelEndpoint>> kv : endpoints.entrySet()) {                String modelTitle = "Model " + kv.getKey().getName() + " @ " + kv.getKey().getVersion();                System.out.println(modelTitle);                for (ModelEndpoint endpoint : kv.getValue()) {                    System.out.println(endpoint);                }            }        }        if (ModelSubmissionOptions.LOCAL_MODEL_PATH.has(cli)) {            File localDir = new File(ModelSubmissionOptions.LOCAL_MODEL_PATH.get(cli));            Path hdfsPath = new Path(ModelSubmissionOptions.HDFS_MODEL_PATH.get(cli));            updateHDFS(fs, localDir, hdfsPath);        }        Queue<ModelRequest> queue = config.createQueue(ImmutableMap.of(ZKQueue.ZK_CLIENT, client));        queue.enqueue(request);    } finally {        if (client != null) {            client.close();        }    }}
public static void metron_f184_0(String... argv) throws Exception
{    FileSystem fs = FileSystem.get(new Configuration());    ModelSubmission submission = new ModelSubmission();    submission.execute(fs, argv);}
public static void metron_f185_0(FileSystem fs, File localDir, Path hdfsPath) throws IOException
{    if (localDir.exists() && localDir.isDirectory()) {        if (!fs.exists(hdfsPath)) {            fs.mkdirs(hdfsPath);        }        for (File f : localDir.listFiles()) {            if (f.getName().equals(Constants.ENDPOINT_DAT)) {                                continue;            }            Path p = new Path(hdfsPath, f.getName());            FSDataOutputStream out = fs.create(p);            BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));            IOUtils.copy(in, out);            IOUtils.closeQuietly(in);            IOUtils.closeQuietly(out);        }    }}
public static void metron_f186_1() throws Exception
{    UnitTestHelper.setJavaLoggingLevel(Level.SEVERE);        zkServerComponent = new ZKServerComponent();    yarnComponent = new YarnComponent().withApplicationMasterClass(ApplicationMaster.class).withTestName(MaasIntegrationTest.class.getSimpleName());    runner = new ComponentRunner.Builder().withComponent("yarn", yarnComponent).withComponent("zk", zkServerComponent).withMillisecondsBetweenAttempts(15000).withNumRetries(10).build();    runner.start();    String zookeeperUrl = zkServerComponent.getConnectionString();    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);    client = CuratorFrameworkFactory.newClient(zookeeperUrl, retryPolicy);    client.start();}
public static void metron_f187_0()
{    if (client != null) {        client.close();    }    runner.stop();}
public void metron_f188_0()
{    runner.reset();}
public void metron_f189_0() throws Exception
{    testDSShell(true);}
public void metron_f190_0() throws Exception
{    testDSShell(false);}
public void metron_f191_1(boolean haveDomain) throws Exception
{    MaaSConfig config = new MaaSConfig() {        {            setServiceRoot("/maas/service");            setQueueConfig(new HashMap<String, Object>() {                {                    put(ZKQueue.ZK_PATH, "/maas/queue");                }            });        }    };    String configRoot = "/maas/config";    byte[] configData = ConfigUtil.INSTANCE.toBytes(config);    try {        client.setData().forPath(configRoot, configData);    } catch (KeeperException.NoNodeException e) {        client.create().creatingParentsIfNeeded().forPath(configRoot, configData);    }    String[] args = { "--jar", yarnComponent.getAppMasterJar(), "--zk_quorum", zkServerComponent.getConnectionString(), "--zk_root", configRoot, "--master_memory", "512", "--master_vcores", "2" };    if (haveDomain) {        String[] domainArgs = { "--domain", "TEST_DOMAIN", "--view_acls", "reader_user reader_group", "--modify_acls", "writer_user writer_group", "--create" };        List<String> argsList = new ArrayList<String>(Arrays.asList(args));        argsList.addAll(Arrays.asList(domainArgs));        args = argsList.toArray(new String[argsList.size()]);    }    YarnConfiguration conf = yarnComponent.getConfig();        final Client client = new Client(new Configuration(conf));    boolean initSuccess = client.init(args);    Assert.assertTrue(initSuccess);        final AtomicBoolean result = new AtomicBoolean(false);    Thread t = new Thread() {        @Override        public void run() {            try {                result.set(client.run());            } catch (Exception e) {                throw new RuntimeException(e);            }        }    };    t.start();    YarnClient yarnClient = YarnClient.createYarnClient();    yarnClient.init(new Configuration(conf));    yarnClient.start();    String hostName = NetUtils.getHostname();    boolean verified = false;    String errorMessage = "";    while (!verified) {        List<ApplicationReport> apps = yarnClient.getApplications();        if (apps.size() == 0) {            Thread.sleep(10);            continue;        }        ApplicationReport appReport = apps.get(0);        if (appReport.getHost().equals("N/A")) {            Thread.sleep(10);            continue;        }        errorMessage = "Expected host name to start with '" + hostName + "', was '" + appReport.getHost() + "'. Expected rpc port to be '-1', was '" + appReport.getRpcPort() + "'.";        if (checkHostname(appReport.getHost()) && appReport.getRpcPort() == -1) {            verified = true;        }        if (appReport.getYarnApplicationState() == YarnApplicationState.FINISHED) {            break;        }    }    Assert.assertTrue(errorMessage, verified);    FileSystem fs = FileSystem.get(conf);    try {        new ModelSubmission().execute(FileSystem.get(conf), new String[] { "--name", "dummy", "--version", "1.0", "--zk_quorum", zkServerComponent.getConnectionString(), "--zk_root", configRoot, "--local_model_path", "src/test/resources/maas", "--hdfs_model_path", new Path(fs.getHomeDirectory(), "maas/dummy").toString(), "--num_instances", "1", "--memory", "100", "--mode", "ADD", "--log4j", "src/test/resources/log4j.properties" });        ServiceDiscoverer discoverer = new ServiceDiscoverer(this.client, config.getServiceRoot());        discoverer.start();        {            boolean passed = false;            for (int i = 0; i < 100; ++i) {                try {                    List<ModelEndpoint> endpoints = discoverer.getEndpoints(new Model("dummy", "1.0"));                    if (endpoints != null && endpoints.size() == 1) {                        LOG.trace("Found endpoints: " + endpoints.get(0));                        String output = makeRESTcall(new URL(endpoints.get(0).getEndpoint().getUrl() + "/echo/casey"));                        if (output.contains("casey")) {                            passed = true;                            break;                        }                    }                } catch (Exception e) {                }                Thread.sleep(2000);            }            Assert.assertTrue(passed);        }        {            List<ModelEndpoint> endpoints = discoverer.getEndpoints(new Model("dummy", "1.0"));            Assert.assertNotNull(endpoints);            Assert.assertEquals(1, endpoints.size());        }        new ModelSubmission().execute(FileSystem.get(conf), new String[] { "--name", "dummy", "--version", "1.0", "--zk_quorum", zkServerComponent.getConnectionString(), "--zk_root", configRoot, "--num_instances", "1", "--mode", "REMOVE" });        {            boolean passed = false;            for (int i = 0; i < 100; ++i) {                try {                    List<ModelEndpoint> endpoints = discoverer.getEndpoints(new Model("dummy", "1.0"));                                        if (endpoints == null || endpoints.size() == 0) {                        passed = true;                        break;                    }                } catch (Exception e) {                }                Thread.sleep(2000);            }            Assert.assertTrue(passed);        }    } finally {        cleanup();    }}
public void metron_f192_0()
{    try {        result.set(client.run());    } catch (Exception e) {        throw new RuntimeException(e);    }}
private void metron_f193_0()
{    try {        LOG.trace("Cleaning up...");        String line;        Process p = Runtime.getRuntime().exec("ps -e");        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));        while ((line = input.readLine()) != null) {            if (line.contains("dummy_rest.sh")) {                String pid = Iterables.get(Splitter.on(" ").split(line.replaceAll("\\s+", " ").trim()), 0);                LOG.trace("Killing " + pid + " from " + line);                Runtime.getRuntime().exec("kill -9 " + pid);            }        }        input.close();    } catch (Exception err) {        err.printStackTrace();    }}
private String metron_f194_0(URL url) throws IOException
{    HttpURLConnection conn = null;        try {        conn = (HttpURLConnection) url.openConnection();        conn.setRequestMethod("GET");        if (conn.getResponseCode() != 200) {            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());        }        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()), StandardCharsets.UTF_8));        String output = "";        String line;        while ((line = br.readLine()) != null) {            output += line + "\n";        }        return output;    } finally {        if (conn != null) {            conn.disconnect();        }    }}
private boolean metron_f195_0(String appHostname) throws Exception
{    String hostname = NetUtils.getHostname();    if (hostname.equals(appHostname)) {        return true;    }    Assert.assertTrue("Unknown format for hostname " + appHostname, appHostname.contains("/"));    Assert.assertTrue("Unknown format for hostname " + hostname, hostname.contains("/"));    String[] appHostnameParts = appHostname.split("/");    String[] hostnameParts = hostname.split("/");    return (compareFQDNs(appHostnameParts[0], hostnameParts[0]) && checkIPs(hostnameParts[0], hostnameParts[1], appHostnameParts[1]));}
private boolean metron_f196_0(String appHostname, String hostname) throws Exception
{    if (appHostname.equals(hostname)) {        return true;    }    String appFQDN = InetAddress.getByName(appHostname).getCanonicalHostName();    String localFQDN = InetAddress.getByName(hostname).getCanonicalHostName();    return appFQDN.equals(localFQDN);}
private boolean metron_f197_0(String hostname, String localIP, String appIP) throws Exception
{    if (localIP.equals(appIP)) {        return true;    }    boolean appIPCheck = false;    boolean localIPCheck = false;    InetAddress[] addresses = InetAddress.getAllByName(hostname);    for (InetAddress ia : addresses) {        if (ia.getHostAddress().equals(appIP)) {            appIPCheck = true;            continue;        }        if (ia.getHostAddress().equals(localIP)) {            localIPCheck = true;        }    }    return (appIPCheck && localIPCheck);}
private int metron_f198_0(int containerNum, List<String> expectedContent, boolean count, String expectedWord)
{    File logFolder = new File(yarnComponent.getYARNCluster().getNodeManager(0).getConfig().get(YarnConfiguration.NM_LOG_DIRS, YarnConfiguration.DEFAULT_NM_LOG_DIRS));    File[] listOfFiles = logFolder.listFiles();    int currentContainerLogFileIndex = -1;    for (int i = listOfFiles.length - 1; i >= 0; i--) {        if (listOfFiles[i].listFiles().length == containerNum + 1) {            currentContainerLogFileIndex = i;            break;        }    }    Assert.assertTrue(currentContainerLogFileIndex != -1);    File[] containerFiles = listOfFiles[currentContainerLogFileIndex].listFiles();    int numOfWords = 0;    for (int i = 0; i < containerFiles.length; i++) {        for (File output : containerFiles[i].listFiles()) {            if (output.getName().trim().contains("stdout")) {                BufferedReader br = null;                List<String> stdOutContent = new ArrayList<String>();                try {                    String sCurrentLine;                    br = new BufferedReader(new InputStreamReader(new FileInputStream(output), StandardCharsets.UTF_8));                    int numOfline = 0;                    while ((sCurrentLine = br.readLine()) != null) {                        if (count) {                            if (sCurrentLine.contains(expectedWord)) {                                numOfWords++;                            }                        } else if (output.getName().trim().equals("stdout")) {                            if (!Shell.WINDOWS) {                                Assert.assertEquals("The current is" + sCurrentLine, expectedContent.get(numOfline), sCurrentLine.trim());                                numOfline++;                            } else {                                stdOutContent.add(sCurrentLine.trim());                            }                        }                    }                    /* By executing bat script using cmd /c,             * it will output all contents from bat script first             * It is hard for us to do check line by line             * Simply check whether output from bat file contains             * all the expected messages             */                    if (Shell.WINDOWS && !count && output.getName().trim().equals("stdout")) {                        Assert.assertTrue(stdOutContent.containsAll(expectedContent));                    }                } catch (IOException e) {                    e.printStackTrace();                } finally {                    try {                        if (br != null)                            br.close();                    } catch (IOException ex) {                        ex.printStackTrace();                    }                }            }        }    }    return numOfWords;}
public Response metron_f199_0(@QueryParam("host") String host) throws JsonProcessingException
{    Boolean b = isMalicious.get(host);    boolean isMalicious = b != null && b;    Map<String, Boolean> ret = new HashMap<String, Boolean>();    ret.put("is_malicious", isMalicious);    String resp = JSONUtils.INSTANCE.toJSON(ret, true);    return Response.ok(resp, MediaType.APPLICATION_JSON_TYPE).build();}
public Set<Class<?>> metron_f200_0()
{    return classes;}
public static void metron_f201_0(int port) throws IOException
{        URI uri = UriBuilder.fromUri("http://localhost/").port(port).build();    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig(), HttpHandler.class);    server.createContext(uri.getPath(), handler);    server.start();}
public static void metron_f202_0()
{    if (server != null) {        server.stop(0);    }}
public static void metron_f203_0() throws Exception
{    UnitTestHelper.setJavaLoggingLevel(WebApplicationImpl.class, Level.WARNING);    MockDGAModel.start(8282);    testZkServer = new TestingServer(true);    zookeeperUrl = testZkServer.getConnectString();    RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);    client = CuratorFrameworkFactory.newClient(zookeeperUrl, retryPolicy);    client.start();    context = new Context.Builder().with(Context.Capabilities.ZOOKEEPER_CLIENT, () -> client).build();    MaaSConfig config = ConfigUtil.INSTANCE.read(client, "/metron/maas/config", new MaaSConfig(), MaaSConfig.class);    discoverer = new ServiceDiscoverer(client, config.getServiceRoot());    discoverer.start();    endpointUrl = new URL("http://localhost:8282");    ModelEndpoint endpoint = new ModelEndpoint();    {        endpoint.setName("dga");        endpoint.setContainerId("0");        Endpoint ep = new Endpoint();        ep.setUrl(endpointUrl.toString());        endpoint.setEndpoint(ep);        endpoint.setVersion("1.0");    }    ;    ServiceInstanceBuilder<ModelEndpoint> builder = ServiceInstance.<ModelEndpoint>builder().address(endpointUrl.getHost()).id("0").name("dga").port(endpointUrl.getPort()).registrationTimeUTC(System.currentTimeMillis()).serviceType(ServiceType.STATIC).payload(endpoint);    final ServiceInstance<ModelEndpoint> instance = builder.build();    discoverer.getServiceDiscovery().registerService(instance);        for (int i = 0; i < 10; ++i) {        try {            Object o = discoverer.getEndpoint("dga");            if (o != null) {                break;            }        } catch (Exception e) {        }        Thread.sleep(1000);    }}
public void metron_f204_0() throws Exception
{    String stellar = "MAAS_GET_ENDPOINT('dga')";    Object result = run(stellar, new HashMap<>(), context);    Assert.assertTrue(result instanceof Map);    Map<String, String> resMap = (Map<String, String>) result;    Assert.assertEquals(resMap.get("url"), "http://localhost:8282");    Assert.assertEquals(resMap.get("name"), "dga");    Assert.assertEquals(resMap.get("version"), "1.0");    Assert.assertEquals(resMap.get("endpoint:apply"), "apply");}
public void metron_f205_0() throws Exception
{    String stellar = "MAAS_GET_ENDPOINT('dga', '1.0')";    Object result = run(stellar, new HashMap<>(), context);    Assert.assertTrue(result instanceof Map);    Map<String, String> resMap = (Map<String, String>) result;    Assert.assertEquals(resMap.get("url"), "http://localhost:8282");    Assert.assertEquals(resMap.get("name"), "dga");    Assert.assertEquals(resMap.get("version"), "1.0");    Assert.assertEquals(resMap.get("endpoint:apply"), "apply");}
public void metron_f206_0() throws Exception
{    String stellar = "MAAS_GET_ENDPOINT('dga', '2.0')";    Object result = run(stellar, new HashMap<>(), context);    Assert.assertNull(result);}
public void metron_f207_0() throws Exception
{    {        String stellar = "MAP_GET('is_malicious', MAAS_MODEL_APPLY(MAAS_GET_ENDPOINT('dga'), {'host': host}))";        Object result = run(stellar, ImmutableMap.of("host", "badguy.com"), context);        Assert.assertTrue((Boolean) result);    }    {        String stellar = "MAP_GET('is_malicious', MAAS_MODEL_APPLY(MAAS_GET_ENDPOINT('dga'), {'host': host}))";        Object result = run(stellar, ImmutableMap.of("host", "youtube.com"), context);        Assert.assertFalse((Boolean) result);    }    {        String stellar = "MAP_GET('is_malicious', MAAS_MODEL_APPLY(MAAS_GET_ENDPOINT('dga'), 'apply', {'host': host}))";        Object result = run(stellar, ImmutableMap.of("host", "youtube.com"), context);        Assert.assertFalse((Boolean) result);    }}
public void metron_f208_0()
{    {        String stellar = "MAP_GET('is_malicious', MAAS_MODEL_APPLY(MAAS_GET_ENDPOINT('dga', '2.0'), {'host': host}))";        Object result = run(stellar, ImmutableMap.of("host", "youtube.com"), context);        Assert.assertNull(result);    }}
public static void metron_f209_0()
{    MockDGAModel.shutdown();    if (discoverer != null) {        CloseableUtils.closeQuietly(discoverer);    }    if (client != null) {        CloseableUtils.closeQuietly(client);    }    if (testZkServer != null) {        CloseableUtils.closeQuietly(testZkServer);    }}
public List<ProfileMeasurement> metron_f210_0(Class<T> clazz, String profile, String entity, List<Object> groups, long start, long end, Optional<T> defaultValue)
{    List<ProfilePeriod> periods = ProfilePeriod.visitPeriods(start, end, periodDurationMillis, TimeUnit.MILLISECONDS, Optional.empty(), period -> period);    return fetch(clazz, profile, entity, groups, periods, defaultValue);}
public List<ProfileMeasurement> metron_f211_0(Class<T> clazz, String profile, String entity, List<Object> groups, Iterable<ProfilePeriod> periods, Optional<T> defaultValue)
{        List<ProfileMeasurement> toFetch = new ArrayList<>();    for (ProfilePeriod period : periods) {        toFetch.add(new ProfileMeasurement().withProfileName(profile).withEntity(entity).withPeriod(period).withGroups(groups));    }        return doFetch(toFetch, clazz, defaultValue);}
private List<ProfileMeasurement> metron_f212_0(List<ProfileMeasurement> measurements, Class<T> clazz, Optional<T> defaultValue)
{    List<ProfileMeasurement> values = new ArrayList<>();        byte[] columnFamily = Bytes.toBytes(columnBuilder.getColumnFamily());    byte[] columnQualifier = columnBuilder.getColumnQualifier("value");    List<Get> gets = new ArrayList<>();    for (ProfileMeasurement measurement : measurements) {        byte[] rowKey = rowKeyBuilder.rowKey(measurement);        Get get = new Get(rowKey).addColumn(columnFamily, columnQualifier);        gets.add(get);    }        try {        Result[] results = tableProvider.getTable(hbaseConfig, tableName).get(gets);        for (int i = 0; i < results.length; ++i) {            Result result = results[i];            ProfileMeasurement measurement = measurements.get(i);            boolean exists = result.containsColumn(columnFamily, columnQualifier);            if (exists) {                                byte[] value = result.getValue(columnFamily, columnQualifier);                measurement.withProfileValue(SerDeUtils.fromBytes(value, clazz));                values.add(measurement);            } else if (defaultValue.isPresent()) {                                measurement.withProfileValue(defaultValue.get());                values.add(measurement);            } else {                        }        }    } catch (IOException e) {        throw new RuntimeException(e);    }    return values;}
public void metron_f213_0(TableProvider tableProvider)
{    this.tableProvider = tableProvider;}
public void metron_f214_0(RowKeyBuilder rowKeyBuilder)
{    this.rowKeyBuilder = rowKeyBuilder;}
public void metron_f215_0(ColumnBuilder columnBuilder)
{    this.columnBuilder = columnBuilder;}
public Object metron_f216_0(List<Object> args, Context context) throws ParseException
{    Optional<Map> configOverridesMap = Optional.empty();    long durationAgo = Util.getArg(0, Long.class, args);    String unitsName = Util.getArg(1, String.class, args);    TimeUnit units = TimeUnit.valueOf(unitsName);    if (args.size() > 2) {        Map rawMap = Util.getArg(2, Map.class, args);        configOverridesMap = rawMap == null || rawMap.isEmpty() ? Optional.empty() : Optional.of(rawMap);    }    Map<String, Object> effectiveConfigs = Util.getEffectiveConfig(context, configOverridesMap.orElse(null));    Long tickDuration = ProfilerClientConfig.PROFILER_PERIOD.get(effectiveConfigs, Long.class);    TimeUnit tickUnit = TimeUnit.valueOf(ProfilerClientConfig.PROFILER_PERIOD_UNITS.get(effectiveConfigs, String.class));    long end = System.currentTimeMillis();    long start = end - units.toMillis(durationAgo);    return ProfilePeriod.visitPeriods(start, end, tickDuration, tickUnit, Optional.empty(), period -> period);}
public boolean metron_f218_0()
{    return true;}
public boolean metron_f220_0()
{    return true;}
public Object metron_f221_0(List<Object> args, Context context) throws ParseException
{    String profile = getArg(0, String.class, args);    String entity = getArg(1, String.class, args);    Optional<List<ProfilePeriod>> periods = Optional.ofNullable(getArg(2, List.class, args));        @SuppressWarnings("unchecked")    List<Object> groups = null;    Map configOverridesMap = null;    if (args.size() < 4) {                groups = new ArrayList<>(0);    } else if (args.get(3) instanceof List) {                groups = getArg(3, List.class, args);        if (args.size() >= 5) {            configOverridesMap = getArg(4, Map.class, args);            if (configOverridesMap.isEmpty())                configOverridesMap = null;        }    } else {                        groups = getGroupsArg(3, args);    }    Map<String, Object> effectiveConfig = getEffectiveConfig(context, configOverridesMap);    Object defaultValue = null;        if (client == null || !cachedConfigMap.equals(effectiveConfig)) {        RowKeyBuilder rowKeyBuilder = getRowKeyBuilder(effectiveConfig);        ColumnBuilder columnBuilder = getColumnBuilder(effectiveConfig);        long periodDuration = getPeriodDurationInMillis(effectiveConfig);        String tableName = PROFILER_HBASE_TABLE.get(effectiveConfig, String.class);        Configuration hbaseConfig = HBaseConfiguration.create();        client = new HBaseProfilerClient(getTableProvider(effectiveConfig), rowKeyBuilder, columnBuilder, periodDuration, tableName, hbaseConfig);        cachedConfigMap = effectiveConfig;    }    if (cachedConfigMap != null) {        defaultValue = ProfilerClientConfig.PROFILER_DEFAULT_VALUE.get(cachedConfigMap);    }    List<ProfileMeasurement> measurements = client.fetch(Object.class, profile, entity, groups, periods.orElse(new ArrayList<>(0)), Optional.ofNullable(defaultValue));        List<Object> values = new ArrayList<>();    for (ProfileMeasurement m : measurements) {        values.add(m.getProfileValue());    }    return values;}
private List<Object> metron_f222_0(int startIndex, List<Object> args)
{    List<Object> groups = new ArrayList<>();    for (int i = startIndex; i < args.size(); i++) {        String group = getArg(i, String.class, args);        groups.add(group);    }    return groups;}
private ColumnBuilder metron_f223_0(Map<String, Object> global)
{    ColumnBuilder columnBuilder;    String columnFamily = PROFILER_COLUMN_FAMILY.get(global, String.class);    columnBuilder = new ValueOnlyColumnBuilder(columnFamily);    return columnBuilder;}
private RowKeyBuilder metron_f224_1(Map<String, Object> global)
{        long duration = PROFILER_PERIOD.get(global, Long.class);            String configuredUnits = PROFILER_PERIOD_UNITS.get(global, String.class);    TimeUnit units = TimeUnit.valueOf(configuredUnits);            Integer saltDivisor = PROFILER_SALT_DIVISOR.get(global, Integer.class);        return new SaltyRowKeyBuilder(saltDivisor, duration, units);}
private TableProvider metron_f225_0(Map<String, Object> global)
{    String clazzName = PROFILER_HBASE_TABLE_PROVIDER.get(global, String.class);    TableProvider provider;    try {        @SuppressWarnings("unchecked")        Class<? extends TableProvider> clazz = (Class<? extends TableProvider>) Class.forName(clazzName);        provider = clazz.getConstructor().newInstance();    } catch (Exception e) {        provider = new HTableProvider();    }    return provider;}
private boolean metron_f226_0(Range<Long> interval, long ts)
{    return interval.contains(ts) || interval.getMaximum() == ts;}
public boolean metron_f227_0(T x)
{    long ts = timestampTransformer.apply(x);    int pos = Collections.binarySearch(intervals, Range.is(ts), INTERVAL_COMPARATOR);    if (pos < 0) {        pos = -pos - 1;    }    Optional<Range<Long>> right = pos >= 0 && pos < intervals.size() ? Optional.of(intervals.get(pos)) : Optional.empty();    Optional<Range<Long>> left = pos - 1 >= 0 && pos - 1 < intervals.size() ? Optional.of(intervals.get(pos - 1)) : Optional.empty();    return (right.isPresent() ? containsInclusive(right.get(), ts) : false) || (left.isPresent() ? containsInclusive(left.get(), ts) : false);}
public String metron_f228_0()
{    return key;}
public Object metron_f229_0()
{    return getDefault(valueType);}
public T metron_f230_0(Class<T> clazz)
{    return defaultValue == null ? null : ConversionUtils.convert(defaultValue, clazz);}
public Object metron_f231_0(Map<String, Object> profilerConfig)
{    return getOrDefault(profilerConfig, defaultValue);}
public Object metron_f232_0(Map<String, Object> profilerConfig, Object defaultValue)
{    return getOrDefault(profilerConfig, defaultValue, valueType);}
public T metron_f233_0(Map<String, Object> profilerConfig, Class<T> clazz)
{    return getOrDefault(profilerConfig, defaultValue, clazz);}
public T metron_f234_0(Map<String, Object> profilerConfig, Object defaultValue, Class<T> clazz)
{    Object o = profilerConfig.getOrDefault(key, defaultValue);    return o == null ? null : ConversionUtils.convert(o, clazz);}
public String metron_f235_0()
{    return key;}
public static void metron_f236_0(Context context, Context.Capabilities[] required) throws IllegalStateException
{        String missing = Stream.of(required).filter(c -> !context.getCapability(c).isPresent()).map(c -> c.toString()).collect(Collectors.joining(", "));    if (StringUtils.isNotBlank(missing) || context == null) {        throw new IllegalStateException("missing required context: " + missing);    }}
public static Map<String, Object> metron_f237_0(Context context, Map configOverridesMap) throws ParseException
{        final Context.Capabilities[] required = { GLOBAL_CONFIG };    validateCapabilities(context, required);    @SuppressWarnings("unchecked")    Map<String, Object> global = (Map<String, Object>) context.getCapability(GLOBAL_CONFIG).get();    Map<String, Object> result = new HashMap<>(6);        for (ProfilerClientConfig k : ProfilerClientConfig.values()) {        Object globalValue = global.containsKey(k.key) ? ConversionUtils.convert(global.get(k.key), k.valueType) : null;        Object overrideValue = configOverridesMap == null ? null : k.getOrDefault(configOverridesMap, null);        Object defaultValue = k.defaultValue;        if (overrideValue != null) {            result.put(k.key, overrideValue);        } else if (globalValue != null) {            result.put(k.key, globalValue);        } else if (defaultValue != null) {            result.put(k.key, defaultValue);        }    }    return result;}
public static T metron_f238_0(int index, Class<T> clazz, List<Object> args)
{    if (index >= args.size()) {        throw new IllegalArgumentException(format("expected at least %d argument(s), found %d", index + 1, args.size()));    }    return ConversionUtils.convert(args.get(index), clazz);}
public static long metron_f239_1(Map<String, Object> global)
{    long duration = PROFILER_PERIOD.get(global, Long.class);        String configuredUnits = PROFILER_PERIOD_UNITS.get(global, String.class);    TimeUnit units = TimeUnit.valueOf(configuredUnits);        return units.toMillis(duration);}
public boolean metron_f241_0()
{    return true;}
public Object metron_f242_0(List<Object> args, Context context) throws ParseException
{        String profile = getArg(0, String.class, args);    String entity = getArg(1, String.class, args);    List<ProfilePeriod> periods = getArg(2, List.class, args);        List<Object> groups = new ArrayList<>();    if (args.size() >= 4) {        groups = getArg(3, List.class, args);    }        Map<String, Object> globals = (Map<String, Object>) context.getCapability(GLOBAL_CONFIG).orElse(Collections.emptyMap());        if (client == null) {        RowKeyBuilder rowKeyBuilder = getRowKeyBuilder(globals);        ColumnBuilder columnBuilder = getColumnBuilder(globals);        TableProvider provider = getTableProvider(globals);        long periodDuration = getPeriodDurationInMillis(globals);        client = new HBaseProfilerClient(provider, rowKeyBuilder, columnBuilder, periodDuration, getTableName(globals), HBaseConfiguration.create());    }        Optional<Object> defaultValue = Optional.empty();    if (globals != null) {        defaultValue = Optional.ofNullable(PROFILER_DEFAULT_VALUE.get(globals));    }    List<ProfileMeasurement> measurements = client.fetch(Object.class, profile, entity, groups, periods, defaultValue);        List<Object> results = new ArrayList<>();    for (ProfileMeasurement measurement : measurements) {        results.add(render(measurement));    }    return results;}
private Map<String, Object> metron_f243_0(ProfileMeasurement measurement)
{    Map<String, Object> view = new HashMap<>();    view.put(PROFILE_KEY, measurement.getProfileName());    view.put(ENTITY_KEY, measurement.getEntity());    view.put(PERIOD_KEY, measurement.getPeriod().getPeriod());    view.put(PERIOD_START_KEY, measurement.getPeriod().getStartTimeMillis());    view.put(PERIOD_END_KEY, measurement.getPeriod().getEndTimeMillis());    view.put(VALUE_KEY, measurement.getProfileValue());    view.put(GROUPS_KEY, measurement.getGroups());    return view;}
private ColumnBuilder metron_f244_0(Map<String, Object> global)
{    String columnFamily = PROFILER_COLUMN_FAMILY.get(global, String.class);    return new ValueOnlyColumnBuilder(columnFamily);}
private RowKeyBuilder metron_f245_0(Map<String, Object> global)
{    Integer saltDivisor = PROFILER_SALT_DIVISOR.get(global, Integer.class);    return new SaltyRowKeyBuilder(saltDivisor, getPeriodDurationInMillis(global), TimeUnit.MILLISECONDS);}
private String metron_f246_0(Map<String, Object> global)
{    return PROFILER_HBASE_TABLE.get(global, String.class);}
private TableProvider metron_f247_0(Map<String, Object> global)
{    String clazzName = PROFILER_HBASE_TABLE_PROVIDER.get(global, String.class);    TableProvider provider;    try {        @SuppressWarnings("unchecked")        Class<? extends TableProvider> clazz = (Class<? extends TableProvider>) Class.forName(clazzName);        provider = clazz.getConstructor().newInstance();    } catch (Exception e) {        provider = new HTableProvider();    }    return provider;}
public Object metron_f248_0(List<Object> args, Context context) throws ParseException
{    Optional<Map> configOverridesMap = Optional.empty();    long now = System.currentTimeMillis();    String windowSelector = Util.getArg(0, String.class, args);    if (args.size() > 1) {        Optional<Object> arg2 = Optional.ofNullable(args.get(1));        Optional<Object> mapArg = args.size() > 2 ? Optional.ofNullable(args.get(2)) : Optional.empty();        if (!mapArg.isPresent() && arg2.isPresent() && arg2.get() instanceof Map) {            mapArg = arg2;        }        if (arg2.isPresent() && arg2.get() instanceof Number) {            now = ConversionUtils.convert(arg2.get(), Long.class);        }        if (mapArg.isPresent()) {            Map rawMap = ConversionUtils.convert(mapArg.get(), Map.class);            configOverridesMap = rawMap == null || rawMap.isEmpty() ? Optional.empty() : Optional.of(rawMap);        }    }    Map<String, Object> effectiveConfigs = Util.getEffectiveConfig(context, configOverridesMap.orElse(null));    Long tickDuration = ProfilerClientConfig.PROFILER_PERIOD.get(effectiveConfigs, Long.class);    TimeUnit tickUnit = TimeUnit.valueOf(ProfilerClientConfig.PROFILER_PERIOD_UNITS.get(effectiveConfigs, String.class));    Window w = null;    try {        w = windowCache.get(windowSelector, (selector) -> WindowProcessor.process(selector));    } catch (ParseException e) {        throw new IllegalStateException("Unable to process " + windowSelector + ": " + e.getMessage(), e);    }    long end = w.getEndMillis(now);    long start = w.getStartMillis(now);    IntervalPredicate<ProfilePeriod> intervalSelector = new IntervalPredicate<>(period -> period.getStartTimeMillis(), w.toIntervals(now), ProfilePeriod.class);    return ProfilePeriod.visitPeriods(start, end, tickDuration, tickUnit, Optional.of(intervalSelector), period -> period);}
public void metron_f249_0(Context context)
{    windowCache = Caffeine.newBuilder().maximumSize(200).expireAfterAccess(10, TimeUnit.MINUTES).build();}
public boolean metron_f250_0()
{    return windowCache != null;}
public String[] metron_f291_0()
{    return tokenNames;}
public Vocabulary metron_f292_0()
{    return VOCABULARY;}
public String metron_f293_0()
{    return "Window.g4";}
public String[] metron_f294_0()
{    return ruleNames;}
public String metron_f295_0()
{    return _serializedATN;}
public String[] metron_f296_0()
{    return modeNames;}
public ATN metron_f297_0()
{    return _ATN;}
public String[] metron_f298_0()
{    return tokenNames;}
public Vocabulary metron_f299_0()
{    return VOCABULARY;}
public String metron_f300_0()
{    return "Window.g4";}
public String[] metron_f301_0()
{    return ruleNames;}
public String metron_f302_0()
{    return _serializedATN;}
public ATN metron_f303_0()
{    return _ATN;}
public Window_expressionContext metron_f304_0()
{    return getRuleContext(Window_expressionContext.class, 0);}
public TerminalNode metron_f305_0()
{    return getToken(WindowParser.EOF, 0);}
public int metron_f306_0()
{    return RULE_window;}
public void metron_f307_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterWindow(this);}
public void metron_f308_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitWindow(this);}
public final WindowContext metron_f309_0() throws RecognitionException
{    WindowContext _localctx = new WindowContext(_ctx, getState());    enterRule(_localctx, 0, RULE_window);    try {        enterOuterAlt(_localctx, 1);        {            setState(30);            window_expression();            setState(31);            match(EOF);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f310_0()
{    return RULE_window_expression;}
public void metron_f311_0(Window_expressionContext ctx)
{    super.copyFrom(ctx);}
public Window_widthContext metron_f312_0()
{    return getRuleContext(Window_widthContext.class, 0);}
public Skip_distanceContext metron_f313_0()
{    return getRuleContext(Skip_distanceContext.class, 0);}
public DurationContext metron_f314_0()
{    return getRuleContext(DurationContext.class, 0);}
public Including_specifierContext metron_f315_0()
{    return getRuleContext(Including_specifierContext.class, 0);}
public Excluding_specifierContext metron_f316_0()
{    return getRuleContext(Excluding_specifierContext.class, 0);}
public void metron_f317_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterRepeatingWindow(this);}
public void metron_f318_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitRepeatingWindow(this);}
public DurationContext metron_f319_0()
{    return getRuleContext(DurationContext.class, 0);}
public void metron_f320_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterDenseWindow(this);}
public void metron_f321_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitDenseWindow(this);}
public Window_widthContext metron_f322_0()
{    return getRuleContext(Window_widthContext.class, 0);}
public Including_specifierContext metron_f323_0()
{    return getRuleContext(Including_specifierContext.class, 0);}
public Excluding_specifierContext metron_f324_0()
{    return getRuleContext(Excluding_specifierContext.class, 0);}
public void metron_f325_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterNonRepeatingWindow(this);}
public void metron_f326_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitNonRepeatingWindow(this);}
public final Window_expressionContext metron_f327_0() throws RecognitionException
{    Window_expressionContext _localctx = new Window_expressionContext(_ctx, getState());    enterRule(_localctx, 2, RULE_window_expression);    int _la;    try {        setState(50);        switch(getInterpreter().adaptivePredict(_input, 4, _ctx)) {            case 1:                _localctx = new NonRepeatingWindowContext(_localctx);                enterOuterAlt(_localctx, 1);                {                    setState(33);                    window_width();                    setState(35);                    _la = _input.LA(1);                    if (_la == INCLUDE) {                        {                            setState(34);                            including_specifier();                        }                    }                    setState(38);                    _la = _input.LA(1);                    if (_la == EXCLUDE) {                        {                            setState(37);                            excluding_specifier();                        }                    }                }                break;            case 2:                _localctx = new RepeatingWindowContext(_localctx);                enterOuterAlt(_localctx, 2);                {                    setState(40);                    window_width();                    setState(41);                    skip_distance();                    setState(42);                    duration();                    setState(44);                    _la = _input.LA(1);                    if (_la == INCLUDE) {                        {                            setState(43);                            including_specifier();                        }                    }                    setState(47);                    _la = _input.LA(1);                    if (_la == EXCLUDE) {                        {                            setState(46);                            excluding_specifier();                        }                    }                }                break;            case 3:                _localctx = new DenseWindowContext(_localctx);                enterOuterAlt(_localctx, 3);                {                    setState(49);                    duration();                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f328_0()
{    return getToken(WindowParser.EXCLUDE, 0);}
public Specifier_listContext metron_f329_0()
{    return getRuleContext(Specifier_listContext.class, 0);}
public int metron_f330_0()
{    return RULE_excluding_specifier;}
public void metron_f331_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterExcluding_specifier(this);}
public void metron_f332_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitExcluding_specifier(this);}
public final Excluding_specifierContext metron_f333_0() throws RecognitionException
{    Excluding_specifierContext _localctx = new Excluding_specifierContext(_ctx, getState());    enterRule(_localctx, 4, RULE_excluding_specifier);    try {        enterOuterAlt(_localctx, 1);        {            setState(52);            match(EXCLUDE);            setState(53);            specifier_list(0);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f334_0()
{    return getToken(WindowParser.INCLUDE, 0);}
public Specifier_listContext metron_f335_0()
{    return getRuleContext(Specifier_listContext.class, 0);}
public int metron_f336_0()
{    return RULE_including_specifier;}
public void metron_f337_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterIncluding_specifier(this);}
public void metron_f338_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitIncluding_specifier(this);}
public final Including_specifierContext metron_f339_0() throws RecognitionException
{    Including_specifierContext _localctx = new Including_specifierContext(_ctx, getState());    enterRule(_localctx, 6, RULE_including_specifier);    try {        enterOuterAlt(_localctx, 1);        {            setState(55);            match(INCLUDE);            setState(56);            specifier_list(0);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public Day_specifierContext metron_f340_0()
{    return getRuleContext(Day_specifierContext.class, 0);}
public Specifier_arg_listContext metron_f341_0()
{    return getRuleContext(Specifier_arg_listContext.class, 0);}
public int metron_f342_0()
{    return RULE_specifier;}
public void metron_f343_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterSpecifier(this);}
public void metron_f344_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitSpecifier(this);}
public final SpecifierContext metron_f345_0() throws RecognitionException
{    SpecifierContext _localctx = new SpecifierContext(_ctx, getState());    enterRule(_localctx, 8, RULE_specifier);    try {        setState(62);        switch(getInterpreter().adaptivePredict(_input, 5, _ctx)) {            case 1:                enterOuterAlt(_localctx, 1);                {                    setState(58);                    day_specifier();                }                break;            case 2:                enterOuterAlt(_localctx, 2);                {                    setState(59);                    day_specifier();                    setState(60);                    specifier_arg_list();                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public IdentifierContext metron_f346_0()
{    return getRuleContext(IdentifierContext.class, 0);}
public Specifier_arg_listContext metron_f347_0()
{    return getRuleContext(Specifier_arg_listContext.class, 0);}
public int metron_f348_0()
{    return RULE_specifier_arg_list;}
public void metron_f349_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterSpecifier_arg_list(this);}
public void metron_f350_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitSpecifier_arg_list(this);}
public final Specifier_arg_listContext metron_f351_0() throws RecognitionException
{    Specifier_arg_listContext _localctx = new Specifier_arg_listContext(_ctx, getState());    enterRule(_localctx, 10, RULE_specifier_arg_list);    try {        setState(68);        switch(getInterpreter().adaptivePredict(_input, 6, _ctx)) {            case 1:                enterOuterAlt(_localctx, 1);                {                    setState(64);                    identifier();                }                break;            case 2:                enterOuterAlt(_localctx, 2);                {                    setState(65);                    identifier();                    setState(66);                    specifier_arg_list();                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f352_0()
{    return getToken(WindowParser.DAY_SPECIFIER, 0);}
public int metron_f353_0()
{    return RULE_day_specifier;}
public void metron_f354_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterDay_specifier(this);}
public void metron_f355_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitDay_specifier(this);}
public final Day_specifierContext metron_f356_0() throws RecognitionException
{    Day_specifierContext _localctx = new Day_specifierContext(_ctx, getState());    enterRule(_localctx, 12, RULE_day_specifier);    try {        enterOuterAlt(_localctx, 1);        {            setState(70);            match(DAY_SPECIFIER);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public TerminalNode metron_f357_0()
{    return getToken(WindowParser.NUMBER, 0);}
public TerminalNode metron_f358_0()
{    return getToken(WindowParser.IDENTIFIER, 0);}
public int metron_f359_0()
{    return RULE_identifier;}
public void metron_f360_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterIdentifier(this);}
public void metron_f361_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitIdentifier(this);}
public final IdentifierContext metron_f362_0() throws RecognitionException
{    IdentifierContext _localctx = new IdentifierContext(_ctx, getState());    enterRule(_localctx, 14, RULE_identifier);    int _la;    try {        enterOuterAlt(_localctx, 1);        {            setState(72);            _la = _input.LA(1);            if (!(_la == NUMBER || _la == IDENTIFIER)) {                _errHandler.recoverInline(this);            } else {                consume();            }        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public SpecifierContext metron_f363_0()
{    return getRuleContext(SpecifierContext.class, 0);}
public Specifier_listContext metron_f364_0()
{    return getRuleContext(Specifier_listContext.class, 0);}
public TerminalNode metron_f365_0()
{    return getToken(WindowParser.COMMA, 0);}
public int metron_f366_0()
{    return RULE_specifier_list;}
public void metron_f367_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterSpecifier_list(this);}
public void metron_f368_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitSpecifier_list(this);}
public final Specifier_listContext metron_f369_0() throws RecognitionException
{    return specifier_list(0);}
private Specifier_listContext metron_f370_0(int _p) throws RecognitionException
{    ParserRuleContext _parentctx = _ctx;    int _parentState = getState();    Specifier_listContext _localctx = new Specifier_listContext(_ctx, _parentState);    Specifier_listContext _prevctx = _localctx;    int _startState = 16;    enterRecursionRule(_localctx, 16, RULE_specifier_list, _p);    try {        int _alt;        enterOuterAlt(_localctx, 1);        {            {                setState(75);                specifier();            }            _ctx.stop = _input.LT(-1);            setState(82);            _errHandler.sync(this);            _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {                if (_alt == 1) {                    if (_parseListeners != null)                        triggerExitRuleEvent();                    _prevctx = _localctx;                    {                        {                            _localctx = new Specifier_listContext(_parentctx, _parentState);                            pushNewRecursionContext(_localctx, _startState, RULE_specifier_list);                            setState(77);                            if (!(precpred(_ctx, 1)))                                throw new FailedPredicateException(this, "precpred(_ctx, 1)");                            setState(78);                            match(COMMA);                            setState(79);                            specifier();                        }                    }                }                setState(84);                _errHandler.sync(this);                _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);            }        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        unrollRecursionContexts(_parentctx);    }    return _localctx;}
public int metron_f371_0()
{    return RULE_duration;}
public void metron_f372_0(DurationContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f373_0()
{    return getToken(WindowParser.FROM, 0);}
public List<Time_intervalContext> metron_f374_0()
{    return getRuleContexts(Time_intervalContext.class);}
public Time_intervalContext metron_f375_0(int i)
{    return getRuleContext(Time_intervalContext.class, i);}
public TerminalNode metron_f376_0()
{    return getToken(WindowParser.TO, 0);}
public List<TerminalNode> metron_f377_0()
{    return getTokens(WindowParser.AGO);}
public TerminalNode metron_f378_0(int i)
{    return getToken(WindowParser.AGO, i);}
public void metron_f379_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterFromToDuration(this);}
public void metron_f380_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitFromToDuration(this);}
public TerminalNode metron_f381_0()
{    return getToken(WindowParser.FROM, 0);}
public Time_intervalContext metron_f382_0()
{    return getRuleContext(Time_intervalContext.class, 0);}
public TerminalNode metron_f383_0()
{    return getToken(WindowParser.AGO, 0);}
public void metron_f384_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterFromDuration(this);}
public void metron_f385_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitFromDuration(this);}
public final DurationContext metron_f386_0() throws RecognitionException
{    DurationContext _localctx = new DurationContext(_ctx, getState());    enterRule(_localctx, 18, RULE_duration);    int _la;    try {        setState(100);        switch(getInterpreter().adaptivePredict(_input, 11, _ctx)) {            case 1:                _localctx = new FromToDurationContext(_localctx);                enterOuterAlt(_localctx, 1);                {                    setState(85);                    match(FROM);                    setState(86);                    time_interval();                    setState(88);                    _la = _input.LA(1);                    if (_la == AGO) {                        {                            setState(87);                            match(AGO);                        }                    }                    setState(90);                    match(TO);                    setState(91);                    time_interval();                    setState(93);                    _la = _input.LA(1);                    if (_la == AGO) {                        {                            setState(92);                            match(AGO);                        }                    }                }                break;            case 2:                _localctx = new FromDurationContext(_localctx);                enterOuterAlt(_localctx, 2);                {                    setState(95);                    match(FROM);                    setState(96);                    time_interval();                    setState(98);                    _la = _input.LA(1);                    if (_la == AGO) {                        {                            setState(97);                            match(AGO);                        }                    }                }                break;        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f387_0()
{    return RULE_skip_distance;}
public void metron_f388_0(Skip_distanceContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f389_0()
{    return getToken(WindowParser.EVERY, 0);}
public Time_intervalContext metron_f390_0()
{    return getRuleContext(Time_intervalContext.class, 0);}
public void metron_f391_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterSkipDistance(this);}
public void metron_f392_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitSkipDistance(this);}
public final Skip_distanceContext metron_f393_0() throws RecognitionException
{    Skip_distanceContext _localctx = new Skip_distanceContext(_ctx, getState());    enterRule(_localctx, 20, RULE_skip_distance);    try {        _localctx = new SkipDistanceContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(102);            match(EVERY);            setState(103);            time_interval();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f394_0()
{    return RULE_window_width;}
public void metron_f395_0(Window_widthContext ctx)
{    super.copyFrom(ctx);}
public Time_intervalContext metron_f396_0()
{    return getRuleContext(Time_intervalContext.class, 0);}
public TerminalNode metron_f397_0()
{    return getToken(WindowParser.WINDOW, 0);}
public void metron_f398_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterWindowWidth(this);}
public void metron_f399_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitWindowWidth(this);}
public final Window_widthContext metron_f400_0() throws RecognitionException
{    Window_widthContext _localctx = new Window_widthContext(_ctx, getState());    enterRule(_localctx, 22, RULE_window_width);    int _la;    try {        _localctx = new WindowWidthContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(105);            time_interval();            setState(107);            _la = _input.LA(1);            if (_la == WINDOW) {                {                    setState(106);                    match(WINDOW);                }            }        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f401_0()
{    return RULE_time_interval;}
public void metron_f402_0(Time_intervalContext ctx)
{    super.copyFrom(ctx);}
public Time_amountContext metron_f403_0()
{    return getRuleContext(Time_amountContext.class, 0);}
public Time_unitContext metron_f404_0()
{    return getRuleContext(Time_unitContext.class, 0);}
public void metron_f405_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterTimeInterval(this);}
public void metron_f406_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitTimeInterval(this);}
public final Time_intervalContext metron_f407_0() throws RecognitionException
{    Time_intervalContext _localctx = new Time_intervalContext(_ctx, getState());    enterRule(_localctx, 24, RULE_time_interval);    try {        _localctx = new TimeIntervalContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(109);            time_amount();            setState(110);            time_unit();        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f408_0()
{    return RULE_time_amount;}
public void metron_f409_0(Time_amountContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f410_0()
{    return getToken(WindowParser.NUMBER, 0);}
public void metron_f411_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterTimeAmount(this);}
public void metron_f412_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitTimeAmount(this);}
public final Time_amountContext metron_f413_0() throws RecognitionException
{    Time_amountContext _localctx = new Time_amountContext(_ctx, getState());    enterRule(_localctx, 26, RULE_time_amount);    try {        _localctx = new TimeAmountContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(112);            match(NUMBER);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public int metron_f414_0()
{    return RULE_time_unit;}
public void metron_f415_0(Time_unitContext ctx)
{    super.copyFrom(ctx);}
public TerminalNode metron_f416_0()
{    return getToken(WindowParser.TIME_UNIT, 0);}
public void metron_f417_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).enterTimeUnit(this);}
public void metron_f418_0(ParseTreeListener listener)
{    if (listener instanceof WindowListener)        ((WindowListener) listener).exitTimeUnit(this);}
public final Time_unitContext metron_f419_0() throws RecognitionException
{    Time_unitContext _localctx = new Time_unitContext(_ctx, getState());    enterRule(_localctx, 28, RULE_time_unit);    try {        _localctx = new TimeUnitContext(_localctx);        enterOuterAlt(_localctx, 1);        {            setState(114);            match(TIME_UNIT);        }    } catch (RecognitionException re) {        _localctx.exception = re;        _errHandler.reportError(this, re);        _errHandler.recover(this, re);    } finally {        exitRule();    }    return _localctx;}
public boolean metron_f420_0(RuleContext _localctx, int ruleIndex, int predIndex)
{    switch(ruleIndex) {        case 8:            return specifier_list_sempred((Specifier_listContext) _localctx, predIndex);    }    return true;}
private boolean metron_f421_0(Specifier_listContext _localctx, int predIndex)
{    switch(predIndex) {        case 0:            return precpred(_ctx, 1);    }    return true;}
protected SimpleDateFormat metron_f422_0()
{    return new SimpleDateFormat("yyyy/MM/dd");}
public boolean metron_f423_0(Long ts)
{    return DateUtils.isSameDay(new Date(ts), date);}
private static Calendar metron_f424_0(Long ts)
{    Calendar c = Calendar.getInstance();    c.setTime(new Date(ts));    return c;}
public static int metron_f425_0(Long ts)
{    return toCalendar(ts).get(Calendar.DAY_OF_WEEK);}
public static Predicate<Long> metron_f426_0(int dayOfWeek)
{    return ts -> getDayOfWeek(ts) == dayOfWeek;}
public static Predicate<Long> metron_f427_0(String name, List<String> arg)
{    return DayPredicates.valueOf(name).predicateCreator.apply(arg);}
private static Optional<HolidayCalendar> metron_f428_0(String code)
{    for (HolidayCalendar cal : HolidayCalendar.values()) {        if (cal.getId().equalsIgnoreCase(code) || cal.name().equalsIgnoreCase(code)) {            return Optional.of(cal);        }    }    return Optional.empty();}
public boolean metron_f429_0(Long ts)
{    Calendar c = Calendar.getInstance();    c.setTime(new Date(ts));    return manager.isHoliday(c, args);}
public long metron_f430_0(long now)
{    return startMillis.apply(now);}
 void metron_f431_0(Function<Long, Long> startMillis)
{    this.startMillis = startMillis;}
public long metron_f432_0(long now)
{    return endMillis.apply(now);}
 void metron_f433_0(Function<Long, Long> endMillis)
{    this.endMillis = endMillis;}
public Iterable<Predicate<Long>> metron_f434_0(long now)
{    return includes.stream().map(include -> include.apply(now)).collect(Collectors.toList());}
 void metron_f435_0(List<Function<Long, Predicate<Long>>> includes)
{    this.includes = includes;}
public Iterable<Predicate<Long>> metron_f436_0(long now)
{    return excludes.stream().map(exclude -> exclude.apply(now)).collect(Collectors.toList());}
 void metron_f437_0(List<Function<Long, Predicate<Long>>> excludes)
{    this.excludes = excludes;}
public Optional<Long> metron_f438_0()
{    return binWidth;}
 void metron_f439_0(long binWidth)
{    this.binWidth = Optional.of(binWidth);}
public Optional<Long> metron_f440_0()
{    return skipDistance;}
 void metron_f441_0(long skipDistance)
{    this.skipDistance = Optional.of(skipDistance);}
public List<Range<Long>> metron_f442_0(long now)
{    List<Range<Long>> intervals = new ArrayList<>();    long startMillis = getStartMillis(now);    long endMillis = getEndMillis(now);    Iterable<Predicate<Long>> includes = getIncludes(now);    Iterable<Predicate<Long>> excludes = getExcludes(now);        long skipDistance = getSkipDistance().orElse(Long.MAX_VALUE);        Optional<Long> binWidthOpt = getBinWidth();    long binWidth = binWidthOpt.isPresent() ? binWidthOpt.get() : endMillis - startMillis;    for (long left = startMillis; left >= 0 && left + binWidth <= endMillis; left += skipDistance) {        Range<Long> interval = Range.between(left, left + binWidth);        boolean include = includes.iterator().hasNext() ? false : true;        for (Predicate<Long> inclusionPredicate : includes) {            include |= inclusionPredicate.test(left);        }        if (include) {            for (Predicate<Long> exclusionPredicate : excludes) {                include &= !exclusionPredicate.test(left);            }        }        if (include) {            intervals.add(interval);        }    }    return intervals;}
public Window metron_f443_0()
{    return window;}
private void metron_f444_0()
{    stack.push(LIST_MARKER);}
private List<Function<Long, Predicate<Long>>> metron_f445_0()
{    LinkedList<Function<Long, Predicate<Long>>> predicates = new LinkedList<>();    while (true) {        Token<?> token = stack.pop();        if (token == LIST_MARKER) {            break;        } else {            predicates.addFirst((Function<Long, Predicate<Long>>) token.getValue());        }    }    return predicates;}
public void metron_f446_0(WindowParser.IdentifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    stack.push(new Token<>(ctx.getText().substring(1), String.class));}
public void metron_f447_0(WindowParser.SpecifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    stack.push(SPECIFIER_MARKER);}
public void metron_f448_0(WindowParser.SpecifierContext ctx)
{    LinkedList<String> args = new LinkedList<>();    while (true) {        Token<?> token = stack.pop();        if (token == SPECIFIER_MARKER) {            break;        } else {            args.addFirst((String) token.getValue());        }    }    String specifier = args.removeFirst();    List<String> arg = args.size() > 0 ? args : new ArrayList<>();    Function<Long, Predicate<Long>> predicate = null;    try {        if (specifier.equals("THIS DAY OF THE WEEK") || specifier.equals("THIS DAY OF WEEK")) {            predicate = now -> DayPredicates.dayOfWeekPredicate(DayPredicates.getDayOfWeek(now));        } else {            final Predicate<Long> dayOfWeekPredicate = DayPredicates.create(specifier, arg);            predicate = now -> dayOfWeekPredicate;        }        stack.push(new Token<>(predicate, Function.class));    } catch (Throwable t) {        throwable = t;    }}
public void metron_f449_0(WindowParser.Day_specifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    String specifier = ctx.getText().toUpperCase();    if (specifier.length() == 0 && ctx.exception != null) {        IllegalStateException ise = new IllegalStateException("Invalid day specifier: " + ctx.getStart().getText(), ctx.exception);        throwable = ise;        throw ise;    }    if (specifier.endsWith("S")) {        specifier = specifier.substring(0, specifier.length() - 1);    }    stack.push(new Token<>(specifier, String.class));}
public void metron_f450_0(WindowParser.Excluding_specifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    enterList();}
public void metron_f451_0(WindowParser.Excluding_specifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    window.setExcludes(getPredicates());}
public void metron_f452_0(WindowParser.Including_specifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    enterList();}
public void metron_f453_0(WindowParser.Including_specifierContext ctx)
{    if (checkForException(ctx)) {        return;    }    window.setIncludes(getPredicates());}
private void metron_f454_0(long from, long to)
{    window.setEndMillis(now -> now - Math.min(to, from));    window.setStartMillis(now -> now - Math.max(from, to));}
public void metron_f455_0(org.apache.metron.profiler.client.window.generated.WindowParser.FromToDurationContext ctx)
{    if (checkForException(ctx)) {        return;    }    Token<?> toInterval = stack.pop();    Token<?> fromInterval = stack.pop();    Long to = (Long) toInterval.getValue();    Long from = (Long) fromInterval.getValue();    setFromTo(from, to);}
public void metron_f456_0(org.apache.metron.profiler.client.window.generated.WindowParser.FromDurationContext ctx)
{    if (checkForException(ctx)) {        return;    }    Token<?> timeInterval = stack.pop();    Long from = (Long) timeInterval.getValue();    setFromTo(from, 0);}
public void metron_f457_0(org.apache.metron.profiler.client.window.generated.WindowParser.SkipDistanceContext ctx)
{    if (checkForException(ctx)) {        return;    }    Token<?> timeInterval = stack.pop();    Long width = (Long) timeInterval.getValue();    window.setSkipDistance(width);}
public void metron_f458_0(org.apache.metron.profiler.client.window.generated.WindowParser.WindowWidthContext ctx)
{    if (checkForException(ctx)) {        return;    }    Token<?> timeInterval = stack.pop();    Long width = (Long) timeInterval.getValue();    window.setBinWidth(width);    window.setStartMillis(now -> now - width);    window.setEndMillis(now -> now);}
public void metron_f459_0(org.apache.metron.profiler.client.window.generated.WindowParser.TimeIntervalContext ctx)
{    if (checkForException(ctx)) {        return;    }    Token<?> timeUnit = stack.pop();    Token<?> timeDuration = stack.pop();    long duration = ConversionUtils.convert(timeDuration.getValue(), Long.class);    TimeUnit unit = (TimeUnit) timeUnit.getValue();    stack.push(new Token<>(unit.toMillis(duration), Long.class));}
public void metron_f460_0(org.apache.metron.profiler.client.window.generated.WindowParser.TimeAmountContext ctx)
{    if (checkForException(ctx)) {        return;    }    if (ctx.getText().length() == 0) {        throwable = new IllegalStateException("Unable to process empty string.");        return;    }    long duration = Long.parseLong(ctx.getText());    stack.push(new Token<>(duration, Long.class));}
public void metron_f461_0(org.apache.metron.profiler.client.window.generated.WindowParser.TimeUnitContext ctx)
{    checkForException(ctx);    switch(normalizeTimeUnit(ctx.getText())) {        case "DAY":            stack.push(new Token<>(TimeUnit.DAYS, TimeUnit.class));            break;        case "HOUR":            stack.push(new Token<>(TimeUnit.HOURS, TimeUnit.class));            break;        case "MINUTE":            stack.push(new Token<>(TimeUnit.MINUTES, TimeUnit.class));            break;        case "SECOND":            stack.push(new Token<>(TimeUnit.SECONDS, TimeUnit.class));            break;        default:            throw new IllegalStateException("Unsupported time unit: " + ctx.getText() + ".  Supported units are limited to: day, hour, minute, second " + "with any pluralization or capitalization.");    }}
private boolean metron_f462_0(ParserRuleContext ctx)
{    if (throwable != null) {        return true;    } else if (ctx.exception != null) {        return true;    }    return false;}
private static String metron_f463_0(String s)
{    String ret = s.toUpperCase().replaceAll("[^A-Z]", "");    if (ret.endsWith("S")) {        return ret.substring(0, ret.length() - 1);    }    return ret;}
private static TokenStream metron_f464_0(String statement)
{    if (statement == null || isEmpty(statement.trim())) {        return null;    }    statement = statement.trim();    ANTLRInputStream input = new ANTLRInputStream(statement);    WindowLexer lexer = new WindowLexer(input);    lexer.removeErrorListeners();    lexer.addErrorListener(new ErrorListener());    TokenStream tokens = new CommonTokenStream(lexer);    return tokens;}
private static WindowParser metron_f465_0(TokenStream tokens, Optional<WindowProcessor> windowProcessor)
{    WindowParser parser = new WindowParser(tokens);    if (windowProcessor.isPresent()) {        parser.addParseListener(windowProcessor.get());    }    parser.removeErrorListeners();    parser.addErrorListener(new ErrorListener());    return parser;}
public static Window metron_f466_0(String statement) throws ParseException
{    TokenStream tokens = createTokenStream(statement);    if (tokens == null) {        return null;    }    WindowProcessor treeBuilder = new WindowProcessor();    WindowParser parser = createParser(tokens, Optional.of(treeBuilder));    parser.window();    if (treeBuilder.throwable != null) {        throw new ParseException(treeBuilder.throwable.getMessage(), treeBuilder.throwable);    }    return treeBuilder.getWindow();}
public static String metron_f467_0(String statement)
{    TokenStream tokens = createTokenStream(statement);    if (tokens == null) {        return null;    }    WindowParser parser = createParser(tokens, Optional.empty());    ParseTree tree = parser.window();    return GrammarUtils.toSyntaxTree(tree);}
public void metron_f468_0() throws Exception
{    provider = new MockHBaseTableProvider();    executor = new DefaultStellarStatefulExecutor();    MockHBaseTableProvider.addToCache(tableName, columnFamily);        long periodDurationMillis = periodUnits.toMillis(periodDuration);    RowKeyBuilder rowKeyBuilder = new SaltyRowKeyBuilder();    ColumnBuilder columnBuilder = new ValueOnlyColumnBuilder(columnFamily);    profileWriter = new ProfileWriter(rowKeyBuilder, columnBuilder, provider, periodDurationMillis, tableName, null);    client = new HBaseProfilerClient(provider, rowKeyBuilder, columnBuilder, periodDurationMillis, tableName, null);}
public void metron_f469_0() throws Exception
{    ((MockHTable) provider.getTable(null, tableName)).clear();}
public void metron_f470_0() throws Exception
{    final String profile = "profile1";    final String entity = "entity1";    final int expectedValue = 2302;    final int hours = 2;    final int count = hours * periodsPerHour + 1;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);        ProfileMeasurement prototype = new ProfileMeasurement().withProfileName(profile).withEntity(entity).withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(prototype, count, Arrays.asList("weekdays"), val -> expectedValue);    profileWriter.write(prototype, count, Arrays.asList("weekends"), val -> 0);    long end = System.currentTimeMillis();    long start = end - TimeUnit.HOURS.toMillis(2);    {                List<Object> groups = Arrays.asList("weekdays");        List<ProfileMeasurement> results = client.fetch(Integer.class, profile, entity, groups, start, end, Optional.empty());        assertEquals(count, results.size());        results.forEach(actual -> {            assertEquals(profile, actual.getProfileName());            assertEquals(entity, actual.getEntity());            assertEquals(groups, actual.getGroups());            assertEquals(expectedValue, actual.getProfileValue());        });    }    {                List<Object> groups = Arrays.asList("weekends");        List<ProfileMeasurement> results = client.fetch(Integer.class, profile, entity, groups, start, end, Optional.empty());        assertEquals(count, results.size());        results.forEach(actual -> {            assertEquals(profile, actual.getProfileName());            assertEquals(entity, actual.getEntity());            assertEquals(groups, actual.getGroups());            assertEquals(0, actual.getProfileValue());        });    }}
public void metron_f471_0() throws Exception
{    final String profile = "profile1";    final String entity = "entity1";    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final int count = hours * periodsPerHour;    final long endTime = System.currentTimeMillis();    final long startTime = endTime - TimeUnit.HOURS.toMillis(hours);        ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, Arrays.asList("weekdays"), val -> expectedValue);    profileWriter.write(m, count, Arrays.asList("weekends"), val -> 0);    List<Object> weekdays = Arrays.asList("weekdays");    List<ProfileMeasurement> results = client.fetch(Integer.class, profile, entity, weekdays, startTime, endTime, Optional.empty());        assertEquals(count, results.size());    results.forEach(actual -> assertEquals(weekdays, actual.getGroups()));}
public void metron_f472_0()
{    final String profile = "profile1";    final String entity = "entity1";    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final int count = hours * periodsPerHour;    final long endTime = System.currentTimeMillis();    final long startTime = endTime - TimeUnit.HOURS.toMillis(hours);        ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, Arrays.asList("weekdays"), val -> expectedValue);    profileWriter.write(m, count, Arrays.asList("weekends"), val -> 0);        List<Object> groups = Arrays.asList("does-not-exist");    List<ProfileMeasurement> results = client.fetch(Integer.class, profile, entity, groups, startTime, endTime, Optional.empty());    assertEquals(0, results.size());}
public void metron_f473_0() throws Exception
{    final String profile = "profile1";    final String entity = "entity1";    final int hours = 2;    int numberToWrite = hours * periodsPerHour;    final List<Object> group = Arrays.asList("weekends");    final long measurementTime = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1);        ProfileMeasurement prototype = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(measurementTime, periodDuration, periodUnits);    profileWriter.write(prototype, numberToWrite, group, val -> 1000);        final long endFetchAt = System.currentTimeMillis();    final long startFetchAt = endFetchAt - TimeUnit.MILLISECONDS.toMillis(30);    List<ProfileMeasurement> results = client.fetch(Integer.class, profile, entity, group, startFetchAt, endFetchAt, Optional.empty());    assertEquals(0, results.size());}
public void metron_f474_0(ProfileMeasurement prototype, int count, List<Object> group, Function<Object, Object> valueGenerator)
{    ProfileMeasurement m = prototype;    ProfilePeriod period = m.getPeriod();    for (int i = 0; i < count; i++) {                Object nextValue = valueGenerator.apply(m.getProfileValue());                m = new ProfileMeasurement().withProfileName(prototype.getProfileName()).withEntity(prototype.getEntity()).withPeriod(period).withGroups(group).withProfileValue(nextValue);        write(m);                period = m.getPeriod().next();    }}
private void metron_f475_0(ProfileMeasurement m)
{    byte[] rowKey = rowKeyBuilder.rowKey(m);    ColumnList cols = columnBuilder.columns(m);    hbaseClient.addMutation(rowKey, cols, Durability.SKIP_WAL);    hbaseClient.mutate();}
public static void metron_f476_0(String[] args) throws Exception
{    RowKeyBuilder rowKeyBuilder = new SaltyRowKeyBuilder();    ColumnBuilder columnBuilder = new ValueOnlyColumnBuilder();    Configuration config = HBaseConfiguration.create();    config.set("hbase.master.hostname", "node1");    config.set("hbase.regionserver.hostname", "node1");    config.set("hbase.zookeeper.quorum", "node1");    HTableProvider provider = new HTableProvider();    String tableName = "profiler";    long periodDurationMillis = TimeUnit.MINUTES.toMillis(15);    long when = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(2);    ProfileMeasurement measure = new ProfileMeasurement().withProfileName("profile1").withEntity("192.168.66.121").withPeriod(when, periodDurationMillis, TimeUnit.MILLISECONDS);    ProfileWriter writer = new ProfileWriter(rowKeyBuilder, columnBuilder, provider, periodDurationMillis, tableName, config);    writer.write(measure, 2 * 24 * 4, Collections.emptyList(), val -> new Random().nextInt(10));}
private T metron_f477_0(String expression, Class<T> clazz)
{    return executor.execute(expression, state, clazz);}
public void metron_f478_0()
{    state = new HashMap<>();    final Table table = MockHBaseTableProvider.addToCache(tableName, columnFamily);        long periodDurationMillis = TimeUnit.MINUTES.toMillis(15);    RowKeyBuilder rowKeyBuilder = new SaltyRowKeyBuilder();    ColumnBuilder columnBuilder = new ValueOnlyColumnBuilder(columnFamily);    profileWriter = new ProfileWriter(rowKeyBuilder, columnBuilder, new MockHBaseTableProvider(), periodDurationMillis, tableName, null);        Map<String, Object> global = new HashMap<String, Object>() {        {            put(PROFILER_HBASE_TABLE.getKey(), tableName);            put(PROFILER_COLUMN_FAMILY.getKey(), columnFamily);            put(PROFILER_HBASE_TABLE_PROVIDER.getKey(), MockHBaseTableProvider.class.getName());            put(PROFILER_PERIOD.getKey(), Long.toString(periodDuration));            put(PROFILER_PERIOD_UNITS.getKey(), periodUnits.toString());            put(PROFILER_SALT_DIVISOR.getKey(), Integer.toString(saltDivisor));        }    };        executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(GetProfile.class).withClass(FixedLookback.class), new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> global).build());}
private Context metron_f479_0()
{    state = new HashMap<>();        Map<String, Object> global = new HashMap<String, Object>() {        {            put(PROFILER_HBASE_TABLE.getKey(), tableName);            put(PROFILER_COLUMN_FAMILY.getKey(), columnFamily);            put(PROFILER_HBASE_TABLE_PROVIDER.getKey(), MockHBaseTableProvider.class.getName());            put(PROFILER_PERIOD.getKey(), Long.toString(periodDuration2));            put(PROFILER_PERIOD_UNITS.getKey(), periodUnits2.toString());            put(PROFILER_SALT_DIVISOR.getKey(), Integer.toString(saltDivisor2));        }    };        Context context2 = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> global).build();        executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(GetProfile.class).withClass(FixedLookback.class), context2);        return context2;}
public void metron_f480_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Collections.emptyList();        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'))";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(count, result.size());    result.forEach(actual -> Assert.assertEquals(expectedValue, actual.intValue()));}
public void metron_f481_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Arrays.asList("weekends");        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        state.put("groups", group);        String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), ['weekends'])";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(count, result.size());        expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), 'weekends')";    result = run(expr, List.class);        Assert.assertEquals(count, result.size());    result.forEach(actual -> Assert.assertEquals(expectedValue, actual.intValue()));}
public void metron_f482_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Arrays.asList("weekdays", "tuesday");        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        state.put("groups", group);        String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), ['weekdays', 'tuesday'])";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(count, result.size());        expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), 'weekdays', 'tuesday')";    result = run(expr, List.class);        Assert.assertEquals(count, result.size());    result.forEach(actual -> Assert.assertEquals(expectedValue, actual.intValue()));}
public void metron_f483_0()
{    Context empty = Context.EMPTY_CONTEXT();        executor.setContext(empty);        SingletonFunctionResolver.getInstance().initialize(empty);        String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(1000, 'SECONDS'), groups)";    run(expr, List.class);}
public void metron_f484_0()
{    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Collections.emptyList();        ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, 1, group, val -> expectedValue);        state.put("groups", group);        String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'SECONDS'))";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(0, result.size());}
public void metron_f485_0()
{    String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'))";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(0, result.size());            testOverride("{'profiler.default.value' : 0}", 0);    testOverride("{'profiler.default.value' : 'metron'}", "metron");    testOverride("{'profiler.default.value' : []}", new ArrayList<>());}
private void metron_f486_0(String overrides, Object defaultVal)
{    String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), [], " + overrides + ")";    List<Object> result = run(expr, List.class);            Assert.assertTrue(result.size() == 16 || result.size() == 17);    result.forEach(actual -> Assert.assertEquals(defaultVal, actual));}
public void metron_f487_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Collections.emptyList();        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        Context context2 = setup2();        @SuppressWarnings("unchecked")    Map<String, Object> global = (Map<String, Object>) context2.getCapability(Context.Capabilities.GLOBAL_CONFIG).get();    Assert.assertEquals(PROFILER_PERIOD.get(global), periodDuration2);    Assert.assertNotEquals(periodDuration, periodDuration2);                String expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'))";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(0, result.size());            String overrides = "{'profiler.client.period.duration' : '" + periodDuration + "', " + "'profiler.client.period.duration.units' : '" + periodUnits.toString() + "', " + "'profiler.client.salt.divisor' : " + saltDivisor + " }";    expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS', " + overrides + "), [], " + overrides + ")";    result = run(expr, List.class);        Assert.assertEquals(count, result.size());    result.forEach(actual -> Assert.assertEquals(expectedValue, actual.intValue()));}
public void metron_f488_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Arrays.asList("weekends");        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        state.put("groups", group);        Context context2 = setup2();        @SuppressWarnings("unchecked")    Map<String, Object> global = (Map<String, Object>) context2.getCapability(Context.Capabilities.GLOBAL_CONFIG).get();    Assert.assertEquals(global.get(PROFILER_PERIOD.getKey()), Long.toString(periodDuration2));    Assert.assertNotEquals(periodDuration, periodDuration2);            String overrides = "{'profiler.client.period.duration' : '" + periodDuration + "', " + "'profiler.client.period.duration.units' : '" + periodUnits.toString() + "', " + "'profiler.client.salt.divisor' : " + saltDivisor + " }";    String expr = "PROFILE_GET('profile1', 'entity1'" + ", PROFILE_FIXED(4, 'HOURS', " + overrides + "), ['weekends'], " + overrides + ")";    @SuppressWarnings("unchecked")    List<Integer> result = run(expr, List.class);        Assert.assertEquals(count, result.size());                expr = "PROFILE_GET('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), ['weekends'])";    result = run(expr, List.class);        Assert.assertEquals(0, result.size());}
public void metron_f489_0()
{    List<Range<Long>> intervals = new ArrayList<Range<Long>>() {        {            add(Range.between(0L, 10L));            add(Range.between(20L, 30L));            add(Range.between(40L, 50L));        }    };    IntervalPredicate<Long> predicate = new IntervalPredicate.Identity(intervals);    Assert.assertTrue(predicate.test(0L));    Assert.assertTrue(predicate.test(10L));    Assert.assertTrue(predicate.test(5L));    Assert.assertFalse(predicate.test(51L));    Assert.assertFalse(predicate.test(15L));}
public void metron_f490_0()
{    List<Range<Long>> intervals = new ArrayList<Range<Long>>() {        {            add(Range.between(0L, 10L));            add(Range.between(5L, 30L));            add(Range.between(40L, 50L));        }    };    IntervalPredicate<Long> predicate = new IntervalPredicate.Identity(intervals);    Assert.assertTrue(predicate.test(0L));    Assert.assertTrue(predicate.test(5L));    Assert.assertTrue(predicate.test(30L));    Assert.assertTrue(predicate.test(10L));    Assert.assertFalse(predicate.test(51L));    Assert.assertTrue(predicate.test(15L));    Assert.assertFalse(predicate.test(31L));    Assert.assertTrue(predicate.test(45L));}
public void metron_f491_0()
{    List<Range<Long>> intervals = new ArrayList<Range<Long>>() {        {            add(Range.between(0L, 10L));        }    };    IntervalPredicate<Long> predicate = new IntervalPredicate.Identity(intervals);    Assert.assertTrue(predicate.test(0L));    Assert.assertTrue(predicate.test(5L));    Assert.assertTrue(predicate.test(10L));    Assert.assertFalse(predicate.test(51L));    Assert.assertFalse(predicate.test(15L));}
public void metron_f492_0()
{    List<Range<Long>> intervals = new ArrayList<Range<Long>>() {        {            add(Range.between(10L, 10L));        }    };    IntervalPredicate<Long> predicate = new IntervalPredicate.Identity(intervals);    Assert.assertFalse(predicate.test(0L));    Assert.assertFalse(predicate.test(5L));    Assert.assertTrue(predicate.test(10L));    Assert.assertFalse(predicate.test(11L));}
private T metron_f493_0(String expression, Class<T> clazz)
{    return executor.execute(expression, state, clazz);}
public void metron_f494_0()
{    state = new HashMap<>();    final Table table = MockHBaseTableProvider.addToCache(tableName, columnFamily);    TableProvider provider = new MockHBaseTableProvider();        long periodDurationMillis = TimeUnit.MINUTES.toMillis(15);    RowKeyBuilder rowKeyBuilder = new SaltyRowKeyBuilder();    ColumnBuilder columnBuilder = new ValueOnlyColumnBuilder(columnFamily);    profileWriter = new ProfileWriter(rowKeyBuilder, columnBuilder, provider, periodDurationMillis, tableName, null);        globals = new HashMap<String, Object>() {        {            put(PROFILER_HBASE_TABLE.getKey(), tableName);            put(PROFILER_COLUMN_FAMILY.getKey(), columnFamily);            put(PROFILER_HBASE_TABLE_PROVIDER.getKey(), MockHBaseTableProvider.class.getName());            put(PROFILER_PERIOD.getKey(), Long.toString(periodDuration));            put(PROFILER_PERIOD_UNITS.getKey(), periodUnits.toString());            put(PROFILER_SALT_DIVISOR.getKey(), Integer.toString(saltDivisor));        }    };        executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(VerboseProfile.class).withClass(FixedLookback.class), new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> globals).build());}
public void metron_f495_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Collections.emptyList();        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        List<Map<String, Object>> results;    results = run("PROFILE_VERBOSE('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'))", List.class);    Assert.assertEquals(count, results.size());    for (Map<String, Object> actual : results) {        Assert.assertEquals("profile1", actual.get(PROFILE_KEY));        Assert.assertEquals("entity1", actual.get(ENTITY_KEY));        Assert.assertNotNull(actual.get(PERIOD_KEY));        Assert.assertNotNull(actual.get(PERIOD_START_KEY));        Assert.assertNotNull(actual.get(PERIOD_END_KEY));        Assert.assertNotNull(actual.get(GROUPS_KEY));        Assert.assertEquals(expectedValue, actual.get(VALUE_KEY));    }}
public void metron_f496_0()
{    final int periodsPerHour = 4;    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Arrays.asList("weekends");        final int count = hours * periodsPerHour;    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, count, group, val -> expectedValue);        state.put("groups", group);        List<Map<String, Object>> results;    results = run("PROFILE_VERBOSE('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'), groups)", List.class);    Assert.assertEquals(count, results.size());    for (Map<String, Object> actual : results) {        Assert.assertEquals("profile1", actual.get(PROFILE_KEY));        Assert.assertEquals("entity1", actual.get(ENTITY_KEY));        Assert.assertNotNull(actual.get(PERIOD_KEY));        Assert.assertNotNull(actual.get(PERIOD_START_KEY));        Assert.assertNotNull(actual.get(PERIOD_END_KEY));        Assert.assertNotNull(actual.get(GROUPS_KEY));        Assert.assertEquals(expectedValue, actual.get(VALUE_KEY));    }}
public void metron_f497_0()
{    final int expectedValue = 2302;    final int hours = 2;    final long startTime = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(hours);    final List<Object> group = Collections.emptyList();        ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile1").withEntity("entity1").withPeriod(startTime, periodDuration, periodUnits);    profileWriter.write(m, 1, group, val -> expectedValue);        List<Map<String, Object>> result;    result = run("PROFILE_VERBOSE('profile1', 'entity1', PROFILE_FIXED(4, 'SECONDS'))", List.class);    Assert.assertEquals(0, result.size());}
public void metron_f498_0()
{        String defaultVal = "this is the default value";    globals.put("profiler.default.value", defaultVal);        String expr = "PROFILE_VERBOSE('profile1', 'entity1', PROFILE_FIXED(4, 'HOURS'))";    List<Map<String, Object>> results = run(expr, List.class);        Assert.assertTrue(results.size() == 16 || results.size() == 17);    for (Map<String, Object> actual : results) {        Assert.assertEquals("profile1", actual.get(PROFILE_KEY));        Assert.assertEquals("entity1", actual.get(ENTITY_KEY));        Assert.assertNotNull(actual.get(PERIOD_KEY));        Assert.assertNotNull(actual.get(PERIOD_START_KEY));        Assert.assertNotNull(actual.get(PERIOD_END_KEY));        Assert.assertNotNull(actual.get(GROUPS_KEY));                Assert.assertEquals(defaultVal, actual.get(VALUE_KEY));    }}
public static void metron_f499_0()
{    resolver = new SimpleFunctionResolver().withClass(GetProfile.class).withClass(FixedLookback.class).withClass(WindowLookback.class);    context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> new HashMap<>()).build();}
public void metron_f500_0() throws Exception
{                long durationMs = 60000;    Map<String, Object> config = new HashMap<>();    config.put(ProfilerClientConfig.PROFILER_PERIOD.getKey(), 1);    State state = test("1 hour", new Date(), Optional.of(config), Assertions.NOT_EMPTY, Assertions.CONTIGUOUS);    Assert.assertEquals(TimeUnit.HOURS.toMillis(1) / durationMs, state.periods.size());}
public void metron_f501_0()
{    String stellarStatement = "PROFILE_WINDOW('1 hour')";    Map<String, Object> variables = new HashMap<>();    StellarProcessor stellar = new StellarProcessor();    List<ProfilePeriod> periods = (List<ProfilePeriod>) stellar.parse(stellarStatement, new DefaultVariableResolver(k -> variables.get(k), k -> variables.containsKey(k)), resolver, context);    Assert.assertEquals(TimeUnit.HOURS.toMillis(1) / getDurationMs(), periods.size());}
public void metron_f502_0() throws Exception
{    State state = test("1 hour", Assertions.NOT_EMPTY, Assertions.CONTIGUOUS);    Assert.assertEquals(TimeUnit.HOURS.toMillis(1) / getDurationMs(), state.periods.size());}
public void metron_f503_0() throws Exception
{    State state = test("from 2 hours ago to 30 minutes ago", Assertions.NOT_EMPTY, Assertions.CONTIGUOUS, Assertions.INTERVALS_CONTAIN_ALL_PERIODS);    Assert.assertEquals(TimeUnit.MINUTES.toMillis(90) / getDurationMs(), state.periods.size());}
public void metron_f504_0() throws Exception
{    State state = test("30 minute window every 1 hour from 2 hours ago to 30 minutes ago", Assertions.NOT_EMPTY, Assertions.DISCONTIGUOUS, Assertions.INTERVALS_CONTAIN_ALL_PERIODS);    Assert.assertEquals(TimeUnit.MINUTES.toMillis(60) / getDurationMs(), state.periods.size());}
public void metron_f505_0() throws Exception
{    test("30 minute window every 24 hours from 7 days ago including saturdays excluding weekends", Assertions.EMPTY);}
public void metron_f506_0() throws Exception
{    test("30 minute idow every 24 hours from 7 days ago including saturdays excluding weekends", Assertions.EMPTY);}
 long metron_f507_0()
{    int duration = ProfilerClientConfig.PROFILER_PERIOD.getDefault(Integer.class);    TimeUnit unit = TimeUnit.valueOf(ProfilerClientConfig.PROFILER_PERIOD_UNITS.getDefault(String.class));    return unit.toMillis(duration);}
public State metron_f508_0(String windowSelector, Assertions... assertions)
{    return test(windowSelector, new Date(), Optional.empty(), assertions);}
public State metron_f509_0(String windowSelector, Date now, Optional<Map<String, Object>> config, Assertions... assertions)
{    List<Range<Long>> windowIntervals = WindowProcessor.process(windowSelector).toIntervals(now.getTime());    String stellarStatement = "PROFILE_WINDOW('" + windowSelector + "', now" + (config.isPresent() ? ", config" : "") + ")";    Map<String, Object> variables = new HashMap<>();    variables.put("now", now.getTime());    if (config.isPresent()) {        variables.put("config", config.get());    }    StellarProcessor stellar = new StellarProcessor();    List<ProfilePeriod> periods = (List<ProfilePeriod>) stellar.parse(stellarStatement, new DefaultVariableResolver(k -> variables.get(k), k -> variables.containsKey(k)), resolver, context);    State state = new State(windowIntervals, periods);    for (Assertions assertion : assertions) {        Assert.assertTrue(assertion.name(), assertion.test(state));    }    return state;}
public boolean metron_f510_0(State s)
{    return predicate.test(s);}
public void metron_f511_0()
{    for (String text : new String[] { "1 hour", "1 hour(s)", "1 hours" }) {        Window w = WindowProcessor.process(text);        Date now = new Date();        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(1, intervals.size());        Assert.assertEquals(now.getTime(), (long) intervals.get(0).getMaximum());        Assert.assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(1), (long) intervals.get(0).getMinimum());    }}
public void metron_f512_0()
{    for (String text : new String[] { "from 2 hours ago to 30 minutes ago", "starting from 2 hours until 30 minutes", "starting from 2 hours ago until 30 minutes ago", "starting from 30 minutes ago until 2 hours ago", "from 30 minutes ago to 2 hours ago " }) {        Window w = WindowProcessor.process(text);        /*    A dense window starting 2 hour ago and continuing until 30 minutes ago     */        Date now = new Date();        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(1, intervals.size());        assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(2), intervals.get(0).getMinimum());        assertEquals(now.getTime() - TimeUnit.MINUTES.toMillis(30), intervals.get(0).getMaximum());    }}
public void metron_f513_0()
{    for (String text : new String[] { "30 minute window every 1 hour from 2 hours ago to 30 minutes ago", "30 minute window every 1 hour starting from 2 hours ago to 30 minutes ago", "30 minute window every 1 hour starting from 2 hours ago until 30 minutes ago", "30 minute window for every 1 hour starting from 2 hours ago until 30 minutes ago" }) {        Window w = WindowProcessor.process(text);        /*    A window size of 30 minutes    Starting 2 hour ago and continuing until 30 minutes ago    window 1: ( now - 2 hour, now - 2 hour + 30 minutes)    window 2: (now - 1 hour, now - 1 hour + 30 minutes)     */        Date now = new Date();        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(2, intervals.size());        assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(2), intervals.get(0).getMinimum());        assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(2) + TimeUnit.MINUTES.toMillis(30), intervals.get(0).getMaximum());        assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(1), intervals.get(1).getMinimum());        assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(1) + TimeUnit.MINUTES.toMillis(30), intervals.get(1).getMaximum());    }}
public void metron_f514_0()
{    Window w = WindowProcessor.process("30 minute window every 1 hour from 3 hours ago");    /*    A window size of 30 minutes    Starting 3 hours ago and continuing until now    window 1: ( now - 3 hour, now - 3 hour + 30 minutes)    window 2: ( now - 2 hour, now - 2 hour + 30 minutes)    window 3: ( now - 1 hour, now - 1 hour + 30 minutes)     */    Date now = new Date();    List<Range<Long>> intervals = w.toIntervals(now.getTime());    Assert.assertEquals(3, intervals.size());    assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(3), intervals.get(0).getMinimum());    assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(3) + TimeUnit.MINUTES.toMillis(30), intervals.get(0).getMaximum());    assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(2), intervals.get(1).getMinimum());    assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(2) + TimeUnit.MINUTES.toMillis(30), intervals.get(1).getMaximum());    assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(1), intervals.get(2).getMinimum());    assertEquals(now.getTime() - TimeUnit.HOURS.toMillis(1) + TimeUnit.MINUTES.toMillis(30), intervals.get(2).getMaximum());}
public void metron_f515_0()
{    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago including tuesdays");        /*    A window size of 30 minutes    Starting 14 days ago  and continuing until now    Gotta be 2 tuesdays in 14 days.     */        Date now = new Date();                now.setHours(6);        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(2, intervals.size());    }    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago including this day of the week");        /*    A window size of 30 minutes    Starting 14 days ago  and continuing until now    Gotta be 2 days with the same dow in 14 days.     */        Date now = new Date();                now.setHours(6);        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(2, intervals.size());    }    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago");        /*    A window size of 30 minutes    Starting 14 days ago  and continuing until now    Gotta be 14 intervals in 14 days.     */        Date now = new Date();        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(14, intervals.size());    }}
public void metron_f516_0() throws ParseException
{    Window w = WindowProcessor.process("30 minute window every 24 hours from 7 days ago including saturdays excluding weekends");    Date now = new Date();        now.setHours(6);    List<Range<Long>> intervals = w.toIntervals(now.getTime());    Assert.assertEquals(0, intervals.size());}
public void metron_f517_0() throws ParseException
{    Window w = WindowProcessor.process("30 minute window every 24 hours from 7 days ago excluding weekends");    Date now = new Date();        now.setHours(6);    List<Range<Long>> intervals = w.toIntervals(now.getTime());    Assert.assertEquals(5, intervals.size());}
public void metron_f518_0() throws ParseException
{    Window w = WindowProcessor.process("30 minute window every 24 hours from 7 days ago including holidays:us excluding weekends");    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");    Date now = sdf.parse("2017/12/26 12:00");    List<Range<Long>> intervals = w.toIntervals(now.getTime());    Assert.assertEquals(1, intervals.size());}
public void metron_f519_0() throws ParseException
{    {        Window w = WindowProcessor.process("1 hour window every 24 hours starting from 56 days ago");        Date now = new Date();        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(56, intervals.size());    }    {        Window w = WindowProcessor.process("1 hour window every 24 hours starting from 56 days ago including this day of the week");        Date now = new Date();                now.setHours(6);        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(8, intervals.size());    }}
public void metron_f520_0() throws ParseException
{    Window w = WindowProcessor.process("30 minute window every 24 hours from 7 days ago excluding weekdays");    Date now = new Date();        now.setHours(6);    List<Range<Long>> intervals = w.toIntervals(now.getTime());    Assert.assertEquals(2, intervals.size());}
public void metron_f521_0() throws ParseException
{    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago excluding holidays:us");        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");        Date now = sdf.parse("2017/12/26 12:00");        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(13, intervals.size());    }    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago excluding holidays:us:nyc");        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");        Date now = sdf.parse("2017/12/26 12:00");        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(13, intervals.size());    }    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago excluding holidays:us");        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");        Date now = sdf.parse("2017/08/26 12:00");        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(14, intervals.size());    }}
public void metron_f522_0() throws ParseException
{    for (String text : new String[] { "30 minute window every 24 hours from 14 days ago including date:20171225:yyyyMMdd", "30 minute window every 24 hours from 14 days ago including date:2017-12-25:yyyy-MM-dd", "30 minute window every 24 hours from 14 days ago including date:2017/12/25" }) {        Window w = WindowProcessor.process(text);        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");        Date now = sdf.parse("2017/12/26 12:00");        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(1, intervals.size());        Date includedDate = new Date(intervals.get(0).getMinimum());        SimpleDateFormat equalityFormat = new SimpleDateFormat("yyyyMMdd");        Assert.assertEquals("20171225", equalityFormat.format(includedDate));    }    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago excluding date:2017/12/25");        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");        Date now = sdf.parse("2017/12/26 12:00");        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(13, intervals.size());    }    {        Window w = WindowProcessor.process("30 minute window every 24 hours from 14 days ago including date:2017/12/25, date:2017/12/24");        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");        Date now = sdf.parse("2017/12/26 12:00");        List<Range<Long>> intervals = w.toIntervals(now.getTime());        Assert.assertEquals(2, intervals.size());        {            Date includedDate = new Date(intervals.get(0).getMinimum());            SimpleDateFormat equalityFormat = new SimpleDateFormat("yyyyMMdd");            Assert.assertEquals("20171224", equalityFormat.format(includedDate));        }        {            Date includedDate = new Date(intervals.get(1).getMinimum());            SimpleDateFormat equalityFormat = new SimpleDateFormat("yyyyMMdd");            Assert.assertEquals("20171225", equalityFormat.format(includedDate));        }    }}
public void metron_f523_0() throws ParseException
{    WindowProcessor.process("30 minute window every 24 hours from 14 days ago excluding hoolidays:us");}
public void metron_f524_0() throws ParseException
{    WindowProcessor.process("30 minute window every 24 months from 14 days ago");}
public void metron_f525_0() throws ParseException
{    WindowProcessor.process("30 minuete window every 24 hours from 14 days ago");}
public void metron_f526_0() throws ParseException
{    WindowProcessor.process("30p minute window every 24 hours from 14 days ago");}
public void metron_f527_0() throws ParseException
{    WindowProcessor.process("30 minute window every 14 hours from 14 days ago including date");}
private static void metron_f528_0(long expected, long actual)
{    long diff = expected - actual;    long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);    String message = expected + " - " + actual + " = " + diffInMinutes + " minutes off.";    Assert.assertEquals(message, expected, actual);}
public Clock metron_f529_0(ProfilerConfig config)
{    Clock clock;    boolean isEventTime = config.getTimestampField().isPresent();    if (isEventTime) {                String timestampField = config.getTimestampField().get();        clock = new EventTimeClock(timestampField);    } else {                clock = new WallClock();    }    return clock;}
public Optional<Long> metron_f530_1(JSONObject message)
{    Long result;    if (message != null && message.containsKey(timestampField)) {                Object timestamp = message.get(timestampField);        result = ConversionUtils.convert(timestamp, Long.class);    } else {                        result = null;    }    return Optional.ofNullable(result);}
public Clock metron_f531_0(ProfilerConfig config)
{    Clock clock;    boolean isEventTime = config.getTimestampField().isPresent();    if (isEventTime) {        String timestampField = config.getTimestampField().get();        clock = new EventTimeClock(timestampField);    } else {        throw new IllegalStateException("Expected profiler to use event time.");    }    return clock;}
public void metron_f532_0(long epochMillis)
{    this.epochMillis = epochMillis;}
public Optional<Long> metron_f533_0(JSONObject message)
{    return Optional.of(this.epochMillis);}
public Clock metron_f534_0(ProfilerConfig config)
{    return new FixedClock(timestamp);}
public Optional<Long> metron_f535_0(JSONObject message)
{        return Optional.of(System.currentTimeMillis());}
public void metron_f536_1(MessageRoute route, Context context)
{    try {        ProfileBuilder builder = getBuilder(route, context);        builder.apply(route.getMessage(), route.getTimestamp());    } catch (ExecutionException e) {                throw new RuntimeException(e);    }}
public List<ProfileMeasurement> metron_f537_1()
{            cacheMaintenance();    List<ProfileMeasurement> measurements = flushCache(activeCache);    return measurements;}
public List<ProfileMeasurement> metron_f538_1()
{            cacheMaintenance();        List<ProfileMeasurement> measurements = flushCache(expiredCache);        expiredCache.invalidateAll();    return measurements;}
private void metron_f539_1()
{    activeCache.cleanUp();        expiredCache.cleanUp();    }
private List<ProfileMeasurement> metron_f540_0(Cache<Integer, ProfileBuilder> cache)
{    List<ProfileMeasurement> measurements = new ArrayList<>();    for (ProfileBuilder profileBuilder : cache.asMap().values()) {                if (profileBuilder.isInitialized()) {                        Optional<ProfileMeasurement> measurement = profileBuilder.flush();            measurement.ifPresent(m -> measurements.add(m));        }    }    return measurements;}
public ProfileBuilder metron_f541_0(MessageRoute route, Context context) throws ExecutionException
{    ProfileConfig profile = route.getProfileDefinition();    String entity = route.getEntity();    Function<Integer, ProfileBuilder> profileCreator = (k) -> new DefaultProfileBuilder.Builder().withDefinition(profile).withEntity(entity).withPeriodDurationMillis(periodDurationMillis).withContext(context).build();    return activeCache.get(cacheKey(profile, entity), profileCreator);}
private int metron_f542_0(ProfileConfig profile, String entity)
{    return new HashCodeBuilder(17, 37).append(profile).append(entity).hashCode();}
public DefaultMessageDistributor metron_f543_0(long periodDurationMillis)
{    this.periodDurationMillis = periodDurationMillis;    return this;}
public DefaultMessageDistributor metron_f544_0(int duration, TimeUnit units)
{    return withPeriodDurationMillis(units.toMillis(duration));}
public List<MessageRoute> metron_f549_0(JSONObject message, ProfilerConfig config, Context context)
{    List<MessageRoute> routes = new ArrayList<>();        for (ProfileConfig profile : config.getProfiles()) {        Clock clock = clockFactory.createClock(config);        Optional<MessageRoute> route = routeToProfile(message, profile, clock);        route.ifPresent(routes::add);    }    return routes;}
private Optional<MessageRoute> metron_f550_1(JSONObject message, ProfileConfig profile, Clock clock)
{    Optional<MessageRoute> route = Optional.empty();        @SuppressWarnings("unchecked")    final Map<String, Object> state = (Map<String, Object>) message;    try {                if (executor.execute(profile.getOnlyif(), state, Boolean.class)) {                        Optional<Long> timestamp = clock.currentTimeMillis(message);            if (timestamp.isPresent()) {                                String entity = executor.execute(profile.getForeach(), state, String.class);                route = Optional.of(new MessageRoute(profile, entity, message, timestamp.get()));            }        }    } catch (Throwable e) {                String msg = format("error while executing profile; profile='%s', error='%s'", profile.getProfile(), e.getMessage());            }    return route;}
public void metron_f551_0(StellarStatefulExecutor executor)
{    this.executor = executor;}
public void metron_f552_0(ClockFactory clockFactory)
{    this.clockFactory = clockFactory;}
public Optional<ProfileMeasurement> metron_f554_1()
{    Optional<ProfileMeasurement> result;    ProfilePeriod period = ProfilePeriod.fromTimestamp(maxTimestamp, periodDurationMillis, TimeUnit.MILLISECONDS);    try {                String profileExpression = definition.getResult().getProfileExpressions().getExpression();        Object profileValue = execute(profileExpression, "result/profile");                Map<String, Object> triageValues = definition.getResult().getTriageExpressions().getExpressions().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> execute(e.getValue(), "result/triage")));                Map<String, Object> state = new HashMap<>();        state.put("profile", profileName);        state.put("entity", entity);        state.put("start", period.getStartTimeMillis());        state.put("end", period.getEndTimeMillis());        state.put("duration", period.getDurationMillis());        state.put("result", profileValue);                List<Object> groups = execute(definition.getGroupBy(), state, "groupBy");        result = Optional.of(new ProfileMeasurement().withProfileName(profileName).withEntity(entity).withGroups(groups).withPeriod(period).withProfileValue(profileValue).withTriageValues(triageValues).withDefinition(definition));    } catch (Throwable e) {                        result = Optional.empty();    }        isInitialized = false;    return result;}
public Object metron_f555_0(String variable)
{    return executor.getState().get(variable);}
public boolean metron_f556_0()
{    return isInitialized;}
public ProfileConfig metron_f557_0()
{    return definition;}
private Object metron_f558_0(String expression, Map<String, Object> transientState, String expressionType)
{    Object result = null;    List<Object> allResults = execute(Collections.singletonList(expression), transientState, expressionType);    if (allResults.size() > 0) {        result = allResults.get(0);    }    return result;}
private Object metron_f559_0(String expression, String expressionType)
{    return execute(expression, Collections.emptyMap(), expressionType);}
private void metron_f560_1(Map<String, String> expressions, Map<String, Object> transientState, String expressionType)
{        for (Map.Entry<String, String> entry : MapUtils.emptyIfNull(expressions).entrySet()) {        String var = entry.getKey();        String expr = entry.getValue();        try {                        executor.assign(var, expr, transientState);        } catch (Throwable e) {                        Set<String> variablesInScope = new HashSet<>();            variablesInScope.addAll(transientState.keySet());            variablesInScope.addAll(executor.getState().keySet());            String msg = format("Bad '%s' expression: error='%s', expr='%s', profile='%s', entity='%s', variables-available='%s'", expressionType, e.getMessage(), expr, profileName, entity, variablesInScope);                        throw new ParseException(msg, e);        }    }}
private List<Object> metron_f561_1(List<String> expressions, Map<String, Object> transientState, String expressionType)
{    List<Object> results = new ArrayList<>();    for (String expr : ListUtils.emptyIfNull(expressions)) {        try {                        Object result = executor.execute(expr, transientState, Object.class);            results.add(result);        } catch (Throwable e) {                        Set<String> variablesInScope = new HashSet<>();            variablesInScope.addAll(transientState.keySet());            variablesInScope.addAll(executor.getState().keySet());            String msg = format("Bad '%s' expression: error='%s', expr='%s', profile='%s', entity='%s', variables-available='%s'", expressionType, e.getMessage(), expr, profileName, entity, variablesInScope);                        throw new ParseException(msg, e);        }    }    return results;}
public String metron_f562_0()
{    return entity;}
public Builder metron_f563_0(Context context)
{    this.context = context;    return this;}
public Builder metron_f564_0(ProfileConfig definition)
{    this.definition = definition;    return this;}
public Builder metron_f565_0(String entity)
{    this.entity = entity;    return this;}
public Builder metron_f566_0(long duration, TimeUnit units)
{    this.periodDurationMillis = units.toMillis(duration);    return this;}
public Builder metron_f567_0(long millis)
{    this.periodDurationMillis = millis;    return this;}
public ProfileBuilder metron_f568_0()
{    if (definition == null) {        throw new IllegalArgumentException("missing profiler definition; got null");    }    if (StringUtils.isEmpty(entity)) {        throw new IllegalArgumentException(format("missing entity name; got '%s'", entity));    }    if (periodDurationMillis == null) {        throw new IllegalArgumentException("missing period duration");    }    return new DefaultProfileBuilder(definition, entity, periodDurationMillis, context);}
public List<byte[]> metron_f569_0(String profile, String entity, List<Object> groups, long start, long end)
{        long max = Math.max(start, end);    start = Math.min(start, end);    end = max;        return ProfilePeriod.visitPeriods(start, end, periodDurationMillis, TimeUnit.MILLISECONDS, Optional.empty(), period -> rowKey(profile, entity, period, groups));}
public List<byte[]> metron_f570_0(String profile, String entity, List<Object> groups, Iterable<ProfilePeriod> periods)
{    List<byte[]> ret = new ArrayList<>();    for (ProfilePeriod period : periods) {        ret.add(rowKey(profile, entity, period, groups));    }    return ret;}
public byte[] metron_f571_0(ProfileMeasurement m)
{    return rowKey(m.getProfileName(), m.getEntity(), m.getPeriod(), m.getGroups());}
public byte[] metron_f572_0(String profile, String entity, ProfilePeriod period, List<Object> groups)
{    return rowKey(profile, entity, period.getPeriod(), groups);}
public byte[] metron_f573_0(String profile, String entity, long period, List<Object> groups)
{        byte[] salt = getSalt(period, saltDivisor);    byte[] prefixKey = prefixKey(profile, entity);    byte[] groupKey = groupKey(groups);    byte[] timeKey = timeKey(period);    int capacity = salt.length + prefixKey.length + groupKey.length + timeKey.length;    return ByteBuffer.allocate(capacity).put(salt).put(prefixKey).put(groupKey).put(timeKey).array();}
private static byte[] metron_f574_0(String profile, String entity)
{    byte[] profileBytes = Bytes.toBytes(profile);    byte[] entityBytes = Bytes.toBytes(entity);    return ByteBuffer.allocate(profileBytes.length + entityBytes.length).put(profileBytes).put(entityBytes).array();}
private static byte[] metron_f575_0(List<Object> groups)
{    StringBuilder builder = new StringBuilder();    groups.forEach(g -> builder.append(g));    return Bytes.toBytes(builder.toString());}
private static byte[] metron_f576_0(ProfilePeriod period)
{    return timeKey(period.getPeriod());}
private static byte[] metron_f577_0(long period)
{    return Bytes.toBytes(period);}
public static byte[] metron_f578_0(ProfilePeriod period, int saltDivisor)
{    return getSalt(period.getPeriod(), saltDivisor);}
public static byte[] metron_f579_0(long period, int saltDivisor)
{    try {                MessageDigest digest = MessageDigest.getInstance("MD5");        byte[] hash = digest.digest(timeKey(period));        int salt = Bytes.toShort(hash) % saltDivisor;        return Bytes.toBytes(salt);    } catch (NoSuchAlgorithmException e) {        throw new RuntimeException(e);    }}
public void metron_f580_0(long duration, TimeUnit units)
{    periodDurationMillis = units.toMillis(duration);}
public void metron_f581_0(int saltDivisor)
{    this.saltDivisor = saltDivisor;}
public ColumnList metron_f582_0(ProfileMeasurement measurement)
{    ColumnList cols = new ColumnList();    cols.addColumn(columnFamilyBytes, getColumnQualifier("value"), SerDeUtils.toBytes(measurement.getProfileValue()));    return cols;}
public String metron_f583_0()
{    return this.columnFamily;}
public void metron_f584_0(String columnFamily)
{    this.columnFamily = columnFamily;    this.columnFamilyBytes = Bytes.toBytes(columnFamily);}
public byte[] metron_f585_0(String fieldName)
{    if ("value".equals(fieldName)) {        return Bytes.toBytes("value");    }    throw new IllegalArgumentException(("unexpected field name: " + fieldName));}
public String metron_f586_0()
{    return entity;}
public void metron_f587_0(String entity)
{    this.entity = entity;}
public ProfileConfig metron_f588_0()
{    return profileDefinition;}
public void metron_f589_0(ProfileConfig profileDefinition)
{    this.profileDefinition = profileDefinition;}
public JSONObject metron_f590_0()
{    return message;}
public void metron_f591_0(JSONObject message)
{    this.message = message;}
public void metron_f592_0(Map message)
{    this.message = new JSONObject(message);}
public Long metron_f593_0()
{    return timestamp;}
public void metron_f594_0(Long timestamp)
{    this.timestamp = timestamp;}
public boolean metron_f595_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    MessageRoute that = (MessageRoute) o;    return new EqualsBuilder().append(profileDefinition, that.profileDefinition).append(entity, that.entity).append(message, that.message).append(timestamp, that.timestamp).isEquals();}
public int metron_f596_0()
{    return new HashCodeBuilder(17, 37).append(profileDefinition).append(entity).append(message).append(timestamp).toHashCode();}
public ProfileMeasurement metron_f597_0(String profileName)
{    this.profileName = profileName;    return this;}
public ProfileMeasurement metron_f598_0(String entity)
{    this.entity = entity;    return this;}
public ProfileMeasurement metron_f599_0(List<Object> groups)
{    this.groups = groups;    return this;}
public ProfileMeasurement metron_f600_0(long whenMillis, long periodDuration, TimeUnit periodUnits)
{    this.withPeriod(ProfilePeriod.fromTimestamp(whenMillis, periodDuration, periodUnits));    return this;}
public ProfileMeasurement metron_f601_0(ProfilePeriod period)
{    this.period = period;    return this;}
public ProfileMeasurement metron_f602_0(ProfileConfig definition)
{    this.definition = definition;    return this;}
public ProfileMeasurement metron_f603_0(Object profileValue)
{    this.profileValue = profileValue;    return this;}
public ProfileMeasurement metron_f604_0(Map<String, Object> triageValues)
{    this.triageValues = triageValues;    return this;}
public String metron_f605_0()
{    return profileName;}
public void metron_f606_0(String profileName)
{    this.profileName = profileName;}
public String metron_f607_0()
{    return entity;}
public void metron_f608_0(String entity)
{    this.entity = entity;}
public List<Object> metron_f609_0()
{    return groups;}
public void metron_f610_0(List<Object> groups)
{    this.groups = groups;}
public ProfilePeriod metron_f611_0()
{    return period;}
public void metron_f612_0(ProfilePeriod period)
{    this.period = period;}
public ProfileConfig metron_f613_0()
{    return definition;}
public void metron_f614_0(ProfileConfig definition)
{    this.definition = definition;}
public Object metron_f615_0()
{    return profileValue;}
public void metron_f616_0(Object profileValue)
{    this.profileValue = profileValue;}
public Map<String, Object> metron_f617_0()
{    return triageValues;}
public void metron_f618_0(Map<String, Object> triageValues)
{    this.triageValues = triageValues;}
public boolean metron_f619_0(Object o)
{    if (this == o) {        return true;    }    if (o == null || getClass() != o.getClass()) {        return false;    }    ProfileMeasurement that = (ProfileMeasurement) o;    return new EqualsBuilder().append(profileName, that.profileName).append(entity, that.entity).append(groups, that.groups).append(period, that.period).append(definition, that.definition).append(profileValue, that.profileValue).append(triageValues, that.triageValues).isEquals();}
public int metron_f620_0()
{    return new HashCodeBuilder(17, 37).append(profileName).append(entity).append(groups).append(period).append(definition).append(profileValue).append(triageValues).toHashCode();}
public static ProfilePeriod metron_f621_0(long epochMillis, long duration, TimeUnit units)
{    if (duration <= 0) {        throw new IllegalArgumentException(format("period duration must be > 0; got '%d %s'", duration, units));    }    long durationMillis = units.toMillis(duration);    long periodId = epochMillis / durationMillis;    return new ProfilePeriod(periodId, duration, units);}
public static ProfilePeriod metron_f622_0(long periodId, long duration, TimeUnit units)
{    if (periodId < 0) {        throw new IllegalArgumentException(format("period id must be >= 0; got '%d'", periodId));    }    return new ProfilePeriod(periodId, duration, units);}
public long metron_f623_0()
{    return period * durationMillis;}
public long metron_f624_0()
{    return getStartTimeMillis() + getDurationMillis();}
public ProfilePeriod metron_f625_0()
{    return fromPeriodId(period + 1, durationMillis, TimeUnit.MILLISECONDS);}
public long metron_f626_0()
{    return period;}
public long metron_f627_0()
{    return durationMillis;}
public boolean metron_f628_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    ProfilePeriod that = (ProfilePeriod) o;    if (period != that.period)        return false;    return durationMillis == that.durationMillis;}
public int metron_f629_0()
{    int result = (int) (period ^ (period >>> 32));    result = 31 * result + (int) (durationMillis ^ (durationMillis >>> 32));    return result;}
public String metron_f630_0()
{    return "ProfilePeriod{" + "period=" + period + ", durationMillis=" + durationMillis + ", startTime=" + Instant.ofEpochMilli(getStartTimeMillis()).toString() + ", endTime=" + Instant.ofEpochMilli(getEndTimeMillis()).toString() + '}';}
public static List<T> metron_f631_0(long startEpochMillis, long endEpochMillis, long duration, TimeUnit units, Optional<Predicate<ProfilePeriod>> inclusionPredicate, Function<ProfilePeriod, T> transformation)
{    ProfilePeriod period = ProfilePeriod.fromTimestamp(startEpochMillis, duration, units);    List<T> ret = new ArrayList<>();    while (period.getStartTimeMillis() <= endEpochMillis) {        if (!inclusionPredicate.isPresent() || inclusionPredicate.get().test(period)) {            ret.add(transformation.apply(period));        }        period = period.next();    }    return ret;}
public void metron_f632_0()
{    clockFactory = new DefaultClockFactory();}
public void metron_f633_0()
{        ProfilerConfig config = new ProfilerConfig();    config.setTimestampField(Optional.of("timestamp"));        Clock clock = clockFactory.createClock(config);    assertTrue(clock instanceof EventTimeClock);}
public void metron_f634_0()
{        ProfilerConfig config = new ProfilerConfig();        Clock clock = clockFactory.createClock(config);    assertTrue(clock instanceof WallClock);}
public JSONObject metron_f635_0()
{    return new JSONObject();}
public void metron_f636_0()
{    JSONObject message = createMessage();        final Long timestamp = System.currentTimeMillis();    message.put(timestampField, timestamp);        EventTimeClock clock = new EventTimeClock(timestampField);    Optional<Long> result = clock.currentTimeMillis(message);        assertTrue(result.isPresent());    assertEquals(timestamp, result.get());}
public void metron_f637_0()
{    JSONObject message = createMessage();        final Long timestamp = System.currentTimeMillis();    message.put(timestampField, timestamp.toString());        EventTimeClock clock = new EventTimeClock(timestampField);    Optional<Long> result = clock.currentTimeMillis(message);        assertTrue(result.isPresent());    assertEquals(timestamp, result.get());}
public void metron_f638_0()
{        JSONObject message = createMessage();        EventTimeClock clock = new EventTimeClock(timestampField);    Optional<Long> result = clock.currentTimeMillis(message);        assertFalse(result.isPresent());}
public void metron_f639_0()
{        JSONObject message = createMessage();    message.put(timestampField, "invalid-timestamp-value");        EventTimeClock clock = new EventTimeClock(timestampField);    Optional<Long> result = clock.currentTimeMillis(message);        assertFalse(result.isPresent());}
public void metron_f640_0()
{    clockFactory = new EventTimeOnlyClockFactory();}
public void metron_f641_0()
{        ProfilerConfig config = new ProfilerConfig();    config.setTimestampField(Optional.of("timestamp"));        Clock clock = clockFactory.createClock(config);    assertTrue(clock instanceof EventTimeClock);}
public void metron_f642_0()
{        ProfilerConfig config = new ProfilerConfig();    clockFactory.createClock(config);    fail("Expected exception");}
public JSONObject metron_f643_0()
{    return new JSONObject();}
public void metron_f644_0()
{    JSONObject message = createMessage();    long before = System.currentTimeMillis();        WallClock clock = new WallClock();    Optional<Long> result = clock.currentTimeMillis(message);        long after = System.currentTimeMillis();    assertTrue(result.isPresent());    assertTrue(result.get() >= before);    assertTrue(result.get() <= after);}
public void metron_f645_0() throws Exception
{    context = Context.EMPTY_CONTEXT();    JSONParser parser = new JSONParser();    messageOne = (JSONObject) parser.parse(inputOne);    messageTwo = (JSONObject) parser.parse(inputTwo);    distributor = new DefaultMessageDistributor(periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes, Ticker.systemTicker());}
private ProfileConfig metron_f646_0(String json) throws IOException
{    return JSONUtils.INSTANCE.load(json, ProfileConfig.class);}
public void metron_f647_0() throws Exception
{        long timestamp = 100;    ProfileConfig definition = createDefinition(profileOne);    String entity = (String) messageOne.get("ip_src_addr");    MessageRoute route = new MessageRoute(definition, entity, messageOne, timestamp);        distributor.distribute(route, context);    List<ProfileMeasurement> measurements = distributor.flush();        assertEquals(1, measurements.size());    ProfileMeasurement m = measurements.get(0);    assertEquals(definition.getProfile(), m.getProfileName());    assertEquals(entity, m.getEntity());}
public void metron_f648_0() throws Exception
{        long timestamp = 100;    String entity = (String) messageOne.get("ip_src_addr");        MessageRoute routeOne = new MessageRoute(createDefinition(profileOne), entity, messageOne, timestamp);    distributor.distribute(routeOne, context);        MessageRoute routeTwo = new MessageRoute(createDefinition(profileTwo), entity, messageOne, timestamp);    distributor.distribute(routeTwo, context);        List<ProfileMeasurement> measurements = distributor.flush();    assertEquals(2, measurements.size());}
public void metron_f649_0() throws Exception
{        long timestamp = 100;        String entityOne = (String) messageOne.get("ip_src_addr");    MessageRoute routeOne = new MessageRoute(createDefinition(profileOne), entityOne, messageOne, timestamp);    distributor.distribute(routeOne, context);        String entityTwo = (String) messageTwo.get("ip_src_addr");    MessageRoute routeTwo = new MessageRoute(createDefinition(profileTwo), entityTwo, messageTwo, timestamp);    distributor.distribute(routeTwo, context);        List<ProfileMeasurement> measurements = distributor.flush();    assertEquals(2, measurements.size());}
public void metron_f650_0() throws Exception
{        FixedTicker ticker = new FixedTicker();        ProfileConfig definition = createDefinition(profileOne);    String entity = (String) messageOne.get("ip_src_addr");    MessageRoute route = new MessageRoute(definition, entity, messageOne, ticker.read());    distributor = new DefaultMessageDistributor(periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes, ticker);        distributor.distribute(route, context);        ticker.advanceTime(profileTimeToLiveMillis - 1000, MILLISECONDS);        assertEquals(0, distributor.flushExpired().size());    assertEquals(1, distributor.flush().size());}
public void metron_f651_0() throws Exception
{        FixedTicker ticker = new FixedTicker();        ProfileConfig definition = createDefinition(profileOne);    String entity = (String) messageOne.get("ip_src_addr");    MessageRoute route = new MessageRoute(definition, entity, messageOne, ticker.read());    distributor = new DefaultMessageDistributor(periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes, ticker);        distributor.distribute(route, context);        ticker.advanceTime(profileTimeToLiveMillis + 1000, MILLISECONDS);        assertEquals(1, distributor.flushExpired().size());    assertEquals(0, distributor.flush().size());}
public void metron_f652_0() throws Exception
{        FixedTicker ticker = new FixedTicker();        ProfileConfig definition = createDefinition(profileOne);    String entity = (String) messageOne.get("ip_src_addr");    MessageRoute route = new MessageRoute(definition, entity, messageOne, ticker.read());    distributor = new DefaultMessageDistributor(periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes, ticker);        distributor.distribute(route, context);        ticker.advanceTime(2, HOURS);        assertEquals(0, distributor.flush().size());        ticker.advanceTime(2, HOURS);        assertEquals(0, distributor.flushExpired().size());}
public FixedTicker metron_f653_0(long timestampNanos)
{    this.timestampNanos = timestampNanos;    return this;}
public FixedTicker metron_f654_0(long time, TimeUnit units)
{    this.timestampNanos += units.toNanos(time);    return this;}
public long metron_f655_0()
{    return this.timestampNanos;}
private ProfilerConfig metron_f656_0(String json) throws IOException
{    return JSONUtils.INSTANCE.load(json, ProfilerConfig.class);}
public void metron_f657_0() throws Exception
{    this.router = new DefaultMessageRouter(Context.EMPTY_CONTEXT());    this.context = Context.EMPTY_CONTEXT();    JSONParser parser = new JSONParser();    this.messageOne = (JSONObject) parser.parse(inputOne);    this.messageTwo = (JSONObject) parser.parse(inputTwo);    this.messageWithTimestamp = (JSONObject) parser.parse(inputWithTimestamp);}
public void metron_f658_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(oneProfile), context);    assertEquals(1, routes.size());    MessageRoute route1 = routes.get(0);    assertEquals(messageOne.get("ip_src_addr"), route1.getEntity());    assertEquals("profile-one", route1.getProfileDefinition().getProfile());}
public void metron_f659_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(noProfiles), context);    assertEquals(0, routes.size());}
public void metron_f660_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(twoProfiles), context);    assertEquals(2, routes.size());    {        MessageRoute route1 = routes.get(0);        assertEquals(messageOne.get("ip_src_addr"), route1.getEntity());        assertEquals("profile-one", route1.getProfileDefinition().getProfile());    }    {        MessageRoute route2 = routes.get(1);        assertEquals(messageOne.get("ip_src_addr"), route2.getEntity());        assertEquals("profile-two", route2.getProfileDefinition().getProfile());    }}
public void metron_f661_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(exclusiveProfile), context);    assertEquals(0, routes.size());}
public void metron_f662_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(badForeach), context);    assertEquals(0, routes.size());}
public void metron_f663_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(badForeach), context);    assertEquals(0, routes.size());}
public void metron_f664_0() throws Exception
{    List<MessageRoute> routes = router.route(messageOne, createConfig(goodAndBad), context);    assertEquals(1, routes.size());    MessageRoute route1 = routes.get(0);    assertEquals("good-profile", route1.getProfileDefinition().getProfile());    assertEquals(messageOne.get("ip_src_addr"), route1.getEntity());}
public void metron_f665_0() throws Exception
{    List<MessageRoute> routes = router.route(messageWithTimestamp, createConfig(profileWithEventTime), context);    ;    assertEquals(1, routes.size());    MessageRoute route1 = routes.get(0);    assertEquals("profile-one", route1.getProfileDefinition().getProfile());    assertEquals(messageWithTimestamp.get("ip_src_addr"), route1.getEntity());    assertEquals(messageWithTimestamp.get("timestamp"), route1.getTimestamp());}
public void metron_f666_0() throws Exception
{        List<MessageRoute> routes = router.route(messageOne, createConfig(profileWithEventTime), context);    assertEquals(0, routes.size());}
public void metron_f667_0() throws Exception
{    message = (JSONObject) new JSONParser().parse(input);}
public void metron_f668_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testInitProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(100 + 200, (int) convert(m.get().getProfileValue(), Integer.class));}
public void metron_f669_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testInitProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(0, (int) convert(m.get().getProfileValue(), Integer.class));}
public void metron_f670_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testUpdateProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        int count = 10;    for (int i = 0; i < count; i++) {                builder.apply(message, timestamp);                timestamp += 5;    }    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(count * 1 + count * 2, (int) convert(m.get().getProfileValue(), Integer.class));}
public void metron_f671_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testResultProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(100, (int) convert(m.get().getProfileValue(), Integer.class));}
public void metron_f672_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testResultProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();    {                builder.apply(message, timestamp);        Optional<ProfileMeasurement> m = builder.flush();        assertTrue(m.isPresent());                ProfilePeriod expected = ProfilePeriod.fromTimestamp(timestamp, 10, TimeUnit.MINUTES);        assertEquals(expected, m.get().getPeriod());    }    {                timestamp += TimeUnit.MINUTES.toMillis(10);                builder.apply(message, timestamp);        Optional<ProfileMeasurement> m = builder.flush();        assertTrue(m.isPresent());                ProfilePeriod expected = ProfilePeriod.fromTimestamp(timestamp, 10, TimeUnit.MINUTES);        assertEquals(expected, m.get().getPeriod());    }}
public void metron_f673_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testGroupByProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(2, m.get().getGroups().size());    assertEquals(100, m.get().getGroups().get(0));    assertEquals(200, m.get().getGroups().get(1));}
public void metron_f674_0() throws Exception
{        long timestamp = 1503081070340L;    ProfilePeriod period = ProfilePeriod.fromTimestamp(timestamp, 10, TimeUnit.MINUTES);    definition = JSONUtils.INSTANCE.load(testStateAvailableToGroupBy, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(6, m.get().getGroups().size());    assertEquals("invalid profile", "test-profile", m.get().getGroups().get(0));    assertEquals("invalid entity", "10.0.0.1", m.get().getGroups().get(1));    assertEquals("invalid start", period.getStartTimeMillis(), m.get().getGroups().get(2));    assertEquals("invalid end", period.getEndTimeMillis(), m.get().getGroups().get(3));    assertEquals("invalid duration", period.getDurationMillis(), m.get().getGroups().get(4));    assertEquals("invalid result", 100, m.get().getGroups().get(5));}
public void metron_f675_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testFlushProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        int count = 10;    for (int i = 0; i < count; i++) {                builder.apply(message, timestamp);                timestamp += 5;    }    builder.flush();        timestamp += TimeUnit.MINUTES.toMillis(20);        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();        assertTrue(m.isPresent());    assertEquals(33, m.get().getProfileValue());}
public void metron_f676_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testFlushProfileWithNaiveInit, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        int count = 10;    for (int i = 0; i < count; i++) {                builder.apply(message, timestamp);                timestamp += 5;    }    builder.flush();        timestamp += TimeUnit.MINUTES.toMillis(20);        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(3, m.get().getProfileValue());}
public void metron_f677_0() throws Exception
{        long timestamp = 100;    final String entity = "10.0.0.1";    definition = JSONUtils.INSTANCE.load(testFlushProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity(entity).withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(entity, m.get().getEntity());}
public void metron_f678_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testResultWithProfileExpression, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(100, m.get().getProfileValue());}
public void metron_f679_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(testResultWithTriageExpression, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());        assertEquals(0, m.get().getTriageValues().get("zero"));    assertEquals(100, m.get().getTriageValues().get("hundred"));    assertEquals(100, m.get().getProfileValue());}
public void metron_f680_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(badInitProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    assertFalse(builder.flush().isPresent());}
public void metron_f681_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(badSimpleResultProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    assertFalse(builder.flush().isPresent());}
public void metron_f682_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(badGroupByProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    assertFalse(builder.flush().isPresent());}
public void metron_f683_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(badResultProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    assertFalse(builder.flush().isPresent());}
public void metron_f684_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(badResultTriage, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);    assertFalse(builder.flush().isPresent());}
public void metron_f685_0() throws Exception
{        long timestamp = 100;    definition = JSONUtils.INSTANCE.load(badUpdateProfile, ProfileConfig.class);    builder = new DefaultProfileBuilder.Builder().withDefinition(definition).withEntity("10.0.0.1").withPeriodDuration(10, TimeUnit.MINUTES).withContext(Context.EMPTY_CONTEXT()).build();        builder.apply(message, timestamp);        Optional<ProfileMeasurement> m = builder.flush();    assertTrue(m.isPresent());    assertEquals(0, m.get().getProfileValue());}
public void metron_f686_0() throws Exception
{        measurement = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(AUG2016, periodDuration, periodUnits);    rowKeyBuilder = new SaltyRowKeyBuilder(saltDivisor, periodDuration, periodUnits);}
public void metron_f687_0() throws Exception
{        measurement.withGroups(Arrays.asList("group1"));        ByteBuffer buffer = ByteBuffer.allocate(100).put(SaltyRowKeyBuilder.getSalt(measurement.getPeriod(), saltDivisor)).put(measurement.getProfileName().getBytes(StandardCharsets.UTF_8)).put(measurement.getEntity().getBytes(StandardCharsets.UTF_8)).put("group1".getBytes(StandardCharsets.UTF_8)).putLong(1635701L);    buffer.flip();    final byte[] expected = new byte[buffer.limit()];    buffer.get(expected, 0, buffer.limit());        byte[] actual = rowKeyBuilder.rowKey(measurement);    Assert.assertTrue(Arrays.equals(expected, actual));}
public void metron_f688_0() throws Exception
{        measurement.withGroups(Arrays.asList("group1", "group2"));        ByteBuffer buffer = ByteBuffer.allocate(100).put(SaltyRowKeyBuilder.getSalt(measurement.getPeriod(), saltDivisor)).put(measurement.getProfileName().getBytes(StandardCharsets.UTF_8)).put(measurement.getEntity().getBytes(StandardCharsets.UTF_8)).put("group1".getBytes(StandardCharsets.UTF_8)).put("group2".getBytes(StandardCharsets.UTF_8)).putLong(1635701L);    buffer.flip();    final byte[] expected = new byte[buffer.limit()];    buffer.get(expected, 0, buffer.limit());        byte[] actual = rowKeyBuilder.rowKey(measurement);    Assert.assertTrue(Arrays.equals(expected, actual));}
public void metron_f689_0() throws Exception
{        measurement.withGroups(Arrays.asList(200));        ByteBuffer buffer = ByteBuffer.allocate(100).put(SaltyRowKeyBuilder.getSalt(measurement.getPeriod(), saltDivisor)).put(measurement.getProfileName().getBytes(StandardCharsets.UTF_8)).put(measurement.getEntity().getBytes(StandardCharsets.UTF_8)).put("200".getBytes(StandardCharsets.UTF_8)).putLong(1635701L);    buffer.flip();    final byte[] expected = new byte[buffer.limit()];    buffer.get(expected, 0, buffer.limit());        byte[] actual = rowKeyBuilder.rowKey(measurement);    Assert.assertTrue(Arrays.equals(expected, actual));}
public void metron_f690_0() throws Exception
{        measurement.withGroups(Arrays.asList(200, "group1"));        ByteBuffer buffer = ByteBuffer.allocate(100).put(SaltyRowKeyBuilder.getSalt(measurement.getPeriod(), saltDivisor)).put(measurement.getProfileName().getBytes(StandardCharsets.UTF_8)).put(measurement.getEntity().getBytes(StandardCharsets.UTF_8)).put("200".getBytes(StandardCharsets.UTF_8)).put("group1".getBytes(StandardCharsets.UTF_8)).putLong(1635701L);    buffer.flip();    final byte[] expected = new byte[buffer.limit()];    buffer.get(expected, 0, buffer.limit());        byte[] actual = rowKeyBuilder.rowKey(measurement);    Assert.assertTrue(Arrays.equals(expected, actual));}
public void metron_f691_0() throws Exception
{        measurement.withGroups(Collections.emptyList());        ByteBuffer buffer = ByteBuffer.allocate(100).put(SaltyRowKeyBuilder.getSalt(measurement.getPeriod(), saltDivisor)).put(measurement.getProfileName().getBytes(StandardCharsets.UTF_8)).put(measurement.getEntity().getBytes(StandardCharsets.UTF_8)).putLong(1635701L);    buffer.flip();    final byte[] expected = new byte[buffer.limit()];    buffer.get(expected, 0, buffer.limit());        byte[] actual = rowKeyBuilder.rowKey(measurement);    Assert.assertTrue(Arrays.equals(expected, actual));}
public void metron_f692_0() throws Exception
{    int hoursAgo = 1;        List<Object> groups = Collections.emptyList();    rowKeyBuilder = new SaltyRowKeyBuilder(saltDivisor, periodDuration, periodUnits);        long now = System.currentTimeMillis();    long oldest = now - TimeUnit.HOURS.toMillis(hoursAgo);    ProfileMeasurement m = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(oldest, periodDuration, periodUnits).withProfileValue(22);        List<byte[]> expectedKeys = new ArrayList<>();    for (int i = 0; i < (hoursAgo * 4) + 1; i++) {                byte[] rk = rowKeyBuilder.rowKey(m);        expectedKeys.add(rk);                ProfilePeriod next = m.getPeriod().next();        m = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(next.getStartTimeMillis(), periodDuration, periodUnits);    }        List<byte[]> actualKeys = rowKeyBuilder.rowKeys(measurement.getProfileName(), measurement.getEntity(), groups, oldest, now);        for (int i = 0; i < actualKeys.size(); i++) {        byte[] actual = actualKeys.get(i);        byte[] expected = expectedKeys.get(i);        assertThat(actual, equalTo(expected));    }}
private void metron_f693_0(byte[] bytes)
{    StringBuilder sb = new StringBuilder(bytes.length * 2);    Formatter formatter = new Formatter(sb);    for (byte b : bytes) {        formatter.format("%02x ", b);    }    System.out.println(sb.toString());}
public void metron_f694_0() throws Exception
{    definition = ProfileConfig.fromJSON(profile);    measurement = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withDefinition(definition).withPeriod(System.currentTimeMillis(), 10, TimeUnit.MINUTES).withProfileValue(22).withTriageValues(Collections.singletonMap("max", 200));}
public void metron_f695_0() throws Exception
{    assertNotNull(measurement);    Kryo kryo = new Kryo();        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();    Output output = new Output(byteStream);    kryo.writeObject(output, measurement);        byte[] bits = output.toBytes();    assertNotNull(bits);        Input input = new Input(new ByteArrayInputStream(bits));    ProfileMeasurement actual = kryo.readObject(input, ProfileMeasurement.class);        assertNotNull(actual);    assertEquals(measurement, actual);}
public void metron_f696_0() throws Exception
{    assertNotNull(measurement);        ByteArrayOutputStream bytes = new ByteArrayOutputStream();    ObjectOutputStream out = new ObjectOutputStream(bytes);    out.writeObject(measurement);        byte[] raw = bytes.toByteArray();    assertTrue(raw.length > 0);        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(raw));    Object actual = in.readObject();        assertEquals(measurement, actual);}
public void metron_f697_0()
{    long duration = 1;    TimeUnit units = TimeUnit.HOURS;    ProfilePeriod period = ProfilePeriod.fromTimestamp(0, duration, units);    assertEquals(0, period.getPeriod());    assertEquals(0, period.getStartTimeMillis());    assertEquals(units.toMillis(duration), period.getDurationMillis());}
public void metron_f698_0()
{    long duration = 1;    TimeUnit units = TimeUnit.MINUTES;    ProfilePeriod period = ProfilePeriod.fromTimestamp(AUG2016, duration, units);    assertEquals(24535527, period.getPeriod());        assertEquals(1472131620000L, period.getStartTimeMillis());    assertEquals(units.toMillis(duration), period.getDurationMillis());}
public void metron_f699_0()
{    long duration = 15;    TimeUnit units = TimeUnit.MINUTES;    ProfilePeriod period = ProfilePeriod.fromTimestamp(AUG2016, duration, units);    assertEquals(1635701, period.getPeriod());        assertEquals(1472130900000L, period.getStartTimeMillis());    assertEquals(units.toMillis(duration), period.getDurationMillis());}
public void metron_f700_0()
{    long duration = 1;    TimeUnit units = TimeUnit.HOURS;    ProfilePeriod period = ProfilePeriod.fromTimestamp(AUG2016, duration, units);    assertEquals(408925, period.getPeriod());        assertEquals(1472130000000L, period.getStartTimeMillis());    assertEquals(units.toMillis(duration), period.getDurationMillis());}
public void metron_f701_0()
{    long duration = 2;    TimeUnit units = TimeUnit.HOURS;    ProfilePeriod period = ProfilePeriod.fromTimestamp(AUG2016, duration, units);    assertEquals(204462, period.getPeriod());        assertEquals(1472126400000L, period.getStartTimeMillis());    assertEquals(units.toMillis(duration), period.getDurationMillis());}
public void metron_f702_0()
{    long duration = 8;    TimeUnit units = TimeUnit.HOURS;    ProfilePeriod period = ProfilePeriod.fromTimestamp(AUG2016, duration, units);    assertEquals(51115, period.getPeriod());        assertEquals(1472112000000L, period.getStartTimeMillis());    assertEquals(units.toMillis(duration), period.getDurationMillis());}
public void metron_f703_0()
{    long duration = 15;    TimeUnit units = TimeUnit.MINUTES;    ProfilePeriod previous = ProfilePeriod.fromTimestamp(AUG2016, duration, units);    IntStream.range(0, 100).forEach(i -> {        ProfilePeriod next = previous.next();        assertEquals(previous.getPeriod() + 1, next.getPeriod());        assertEquals(previous.getStartTimeMillis() + previous.getDurationMillis(), next.getStartTimeMillis());        assertEquals(previous.getDurationMillis(), next.getDurationMillis());    });}
public void metron_f704_0()
{    long duration = 0;    TimeUnit units = TimeUnit.HOURS;    ProfilePeriod.fromTimestamp(0, duration, units);}
public void metron_f705_0() throws Exception
{    ProfilePeriod expected = ProfilePeriod.fromTimestamp(AUG2016, 1, TimeUnit.HOURS);    Kryo kryo = new Kryo();        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();    Output output = new Output(byteStream);    kryo.writeObject(output, expected);        byte[] bits = output.toBytes();    assertNotNull(bits);        Input input = new Input(new ByteArrayInputStream(bits));    ProfilePeriod actual = kryo.readObject(input, ProfilePeriod.class);        assertNotNull(actual);    assertEquals(expected, actual);}
public void metron_f706_0() throws Exception
{    ProfilePeriod expected = ProfilePeriod.fromTimestamp(AUG2016, 1, TimeUnit.HOURS);        ByteArrayOutputStream bytes = new ByteArrayOutputStream();    ObjectOutputStream out = new ObjectOutputStream(bytes);    out.writeObject(expected);        byte[] raw = bytes.toByteArray();    assertTrue(raw.length > 0);        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(raw));    Object actual = in.readObject();        assertEquals(expected, actual);}
public void metron_f707_0()
{    ProfilePeriod expected = ProfilePeriod.fromTimestamp(AUG2016, 1, TimeUnit.HOURS);        long periodId = expected.getPeriod();    long duration = expected.getDurationMillis();    ProfilePeriod actual = ProfilePeriod.fromPeriodId(periodId, duration, TimeUnit.MILLISECONDS);    assertEquals(expected, actual);}
public void metron_f708_0()
{    ProfilePeriod.fromPeriodId(-1, 1, TimeUnit.HOURS);}
public void metron_f709_0()
{    assertEquals(ProfilePeriod.fromTimestamp(0, 1, TimeUnit.HOURS), ProfilePeriod.fromPeriodId(0, 1, TimeUnit.HOURS));}
public boolean metron_f711_0()
{    return true;}
public Object metron_f712_0(List<Object> args, Context context)
{    @SuppressWarnings("unchecked")    Map<String, Object> global = (Map<String, Object>) context.getCapability(GLOBAL_CONFIG, false).orElse(Collections.emptyMap());        long duration = PROFILER_PERIOD.getOrDefault(global, PROFILER_PERIOD.getDefault(), Long.class);    String configuredUnits = PROFILER_PERIOD_UNITS.getOrDefault(global, PROFILER_PERIOD_UNITS.getDefault(), String.class);    long periodDurationMillis = TimeUnit.valueOf(configuredUnits).toMillis(duration);        String arg0 = Util.getArg(0, String.class, args);    ProfilerConfig profilerConfig;    try {        profilerConfig = JSONUtils.INSTANCE.load(arg0, ProfilerConfig.class);    } catch (IOException e) {        throw new IllegalArgumentException("Invalid profiler configuration", e);    }        long profileTimeToLiveMillis = Long.MAX_VALUE;    long maxNumberOfRoutes = Long.MAX_VALUE;    return new StandAloneProfiler(profilerConfig, periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes, context);}
public void metron_f713_0(Context context)
{    parser = new JSONParser();}
public boolean metron_f714_0()
{    return parser != null;}
public Object metron_f715_0(List<Object> args, Context context) throws ParseException
{        Object arg0 = Util.getArg(0, Object.class, args);    List<JSONObject> messages = getMessages(arg0);        StandAloneProfiler profiler = Util.getArg(1, StandAloneProfiler.class, args);    for (JSONObject message : messages) {        profiler.apply(message);    }    return profiler;}
private List<JSONObject> metron_f716_0(Object arg)
{    List<JSONObject> messages;    if (arg instanceof String) {        messages = getMessagesFromString((String) arg);    } else if (arg instanceof Iterable) {        messages = getMessagesFromIterable((Iterable<String>) arg);    } else if (arg instanceof JSONObject) {        messages = Collections.singletonList((JSONObject) arg);    } else {        throw new IllegalArgumentException(format("invalid message: found '%s', expected String, List, or JSONObject", ClassUtils.getShortClassName(arg, "null")));    }    return messages;}
private List<JSONObject> metron_f717_0(Iterable<String> strings)
{    List<JSONObject> messages = new ArrayList<>();        for (String str : strings) {        messages.addAll(getMessagesFromString(str));    }    return messages;}
private List<JSONObject> metron_f718_0(String arg0)
{    List<JSONObject> messages = new ArrayList<>();    try {        Object parsedArg0 = parser.parse(arg0);        if (parsedArg0 instanceof JSONObject) {                        messages.add((JSONObject) parsedArg0);        } else if (parsedArg0 instanceof JSONArray) {                        JSONArray jsonArray = (JSONArray) parsedArg0;            for (Object item : jsonArray) {                messages.addAll(getMessages(item));            }        } else {            throw new IllegalArgumentException(format("invalid message: found '%s', expected JSONObject or JSONArray", ClassUtils.getShortClassName(parsedArg0, "null")));        }    } catch (org.json.simple.parser.ParseException e) {        throw new IllegalArgumentException(format("invalid message: '%s'", e.getMessage()), e);    }    return messages;}
public boolean metron_f720_0()
{    return true;}
public Object metron_f721_0(List<Object> args, Context context) throws ParseException
{        StandAloneProfiler profiler = Util.getArg(0, StandAloneProfiler.class, args);    if (profiler == null) {        throw new IllegalArgumentException(format("expected the profiler returned by PROFILER_INIT, found null"));    }        List<Map<String, Object>> measurements = new ArrayList<>();    for (ProfileMeasurement m : profiler.flush()) {                Map<String, Object> period = new HashMap<>();        period.put("period", m.getPeriod().getPeriod());        period.put("start", m.getPeriod().getStartTimeMillis());        period.put("duration", m.getPeriod().getDurationMillis());        period.put("end", m.getPeriod().getEndTimeMillis());                Map<String, Object> measurement = new HashMap<>();        measurement.put("profile", m.getProfileName());        measurement.put("entity", m.getEntity());        measurement.put("value", m.getProfileValue());        measurement.put("groups", m.getGroups());        measurement.put("period", period);        measurements.add(measurement);    }    return measurements;}
public void metron_f722_0(JSONObject message)
{        List<MessageRoute> routes = router.route(message, config, context);    for (MessageRoute route : routes) {        distributor.distribute(route, context);    }    routeCount += routes.size();    messageCount += 1;}
public List<ProfileMeasurement> metron_f723_0()
{    return distributor.flush();}
public ProfilerConfig metron_f724_0()
{    return config;}
public int metron_f725_0()
{    return (config == null) ? 0 : config.getProfiles().size();}
public int metron_f726_0()
{    return messageCount;}
public int metron_f727_0()
{    return routeCount;}
public String metron_f728_0()
{    return "Profiler{" + getProfileCount() + " profile(s), " + getMessageCount() + " messages(s), " + getRouteCount() + " route(s)" + '}';}
private T metron_f729_0(String expression, Class<T> clazz)
{    return executor.execute(expression, state, clazz);}
public void metron_f730_0()
{    state = new HashMap<>();        Map<String, Object> global = new HashMap<String, Object>() {        {            put(PROFILER_PERIOD.getKey(), Long.toString(periodDuration));            put(PROFILER_PERIOD_UNITS.getKey(), periodUnits.toString());        }    };        executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(ProfilerFunctions.ProfilerInit.class).withClass(ProfilerFunctions.ProfilerApply.class).withClass(ProfilerFunctions.ProfilerFlush.class), new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> global).build());}
public void metron_f731_0()
{    state.put("config", "{ \"profiles\" : [] }");    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    assertNotNull(profiler);    assertEquals(0, profiler.getProfileCount());    assertEquals(0, profiler.getMessageCount());    assertEquals(0, profiler.getRouteCount());}
public void metron_f732_0()
{    state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    assertNotNull(profiler);    assertEquals(1, profiler.getProfileCount());    assertEquals(0, profiler.getMessageCount());    assertEquals(0, profiler.getRouteCount());}
public void metron_f733_0()
{    run("PROFILER_INIT()", StandAloneProfiler.class);}
public void metron_f734_0()
{    run("PROFILER_INIT({ \"invalid\": 2 })", StandAloneProfiler.class);}
public void metron_f735_0()
{    state.put("config", helloWorldProfilerDef);    String expression = "PROFILER_INIT(config)";        StellarStatefulExecutor executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(ProfilerFunctions.ProfilerInit.class).withClass(ProfilerFunctions.ProfilerApply.class).withClass(ProfilerFunctions.ProfilerFlush.class), Context.EMPTY_CONTEXT());    StandAloneProfiler profiler = executor.execute(expression, state, StandAloneProfiler.class);    assertNotNull(profiler);    assertEquals(1, profiler.getProfileCount());    assertEquals(0, profiler.getMessageCount());    assertEquals(0, profiler.getRouteCount());}
public void metron_f736_0()
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        state.put("message", message);    StandAloneProfiler result = run("PROFILER_APPLY(message, profiler)", StandAloneProfiler.class);        assertSame(profiler, result);    assertEquals(1, profiler.getProfileCount());    assertEquals(1, profiler.getMessageCount());    assertEquals(1, profiler.getRouteCount());}
public void metron_f737_0() throws Exception
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        JSONParser parser = new JSONParser();    JSONObject jsonObject = (JSONObject) parser.parse(message);    state.put("jsonObj", jsonObject);    StandAloneProfiler result = run("PROFILER_APPLY(jsonObj, profiler)", StandAloneProfiler.class);        assertSame(profiler, result);    assertEquals(1, profiler.getProfileCount());    assertEquals(1, profiler.getMessageCount());    assertEquals(1, profiler.getRouteCount());}
public void metron_f738_0()
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        state.put("messages", messages);    StandAloneProfiler result = run("PROFILER_APPLY(messages, profiler)", StandAloneProfiler.class);        assertSame(profiler, result);    assertEquals(1, profiler.getProfileCount());    assertEquals(3, profiler.getMessageCount());    assertEquals(3, profiler.getRouteCount());}
public void metron_f739_0()
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        state.put("msg", message);    StandAloneProfiler result = run("PROFILER_APPLY([msg, msg, msg], profiler)", StandAloneProfiler.class);        assertSame(profiler, result);    assertEquals(1, profiler.getProfileCount());    assertEquals(3, profiler.getMessageCount());    assertEquals(3, profiler.getRouteCount());}
public void metron_f740_0()
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        state.put("messages", "[ ]");    StandAloneProfiler result = run("PROFILER_APPLY(messages, profiler)", StandAloneProfiler.class);        assertSame(profiler, result);    assertEquals(1, profiler.getProfileCount());    assertEquals(0, profiler.getMessageCount());    assertEquals(0, profiler.getRouteCount());}
public void metron_f741_0()
{    run("PROFILER_APPLY()", StandAloneProfiler.class);}
public void metron_f742_0()
{    run("PROFILER_APPLY(undefined)", StandAloneProfiler.class);}
public void metron_f743_0()
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        run("PROFILER_APPLY(messages, profiler)", StandAloneProfiler.class);}
public void metron_f744_0()
{        state.put("config", helloWorldProfilerDef);    StandAloneProfiler profiler = run("PROFILER_INIT(config)", StandAloneProfiler.class);    state.put("profiler", profiler);        state.put("message", message);    run("PROFILER_APPLY(message, profiler)", StandAloneProfiler.class);        List<Map<String, Object>> measurements = run("PROFILER_FLUSH(profiler)", List.class);        assertNotNull(measurements);    assertEquals(1, measurements.size());    Map<String, Object> measurement = measurements.get(0);    assertEquals("hello-world", measurement.get("profile"));    assertEquals("10.0.0.1", measurement.get("entity"));    assertEquals(1, measurement.get("value"));    assertEquals(Collections.emptyList(), measurement.get("groups"));}
public void metron_f745_0()
{    run("PROFILER_FLUSH()", StandAloneProfiler.class);}
public void metron_f746_0()
{    run("PROFILER_FLUSH(undefined)", StandAloneProfiler.class);}
public void metron_f747_0() throws Exception
{        JSONParser parser = new JSONParser();    message = (JSONObject) parser.parse(messageJson);}
public void metron_f748_0() throws Exception
{    StandAloneProfiler profiler = createProfiler(oneProfile);    profiler.apply(message);    profiler.apply(message);    profiler.apply(message);    List<ProfileMeasurement> measurements = profiler.flush();    assertEquals(1, measurements.size());        ProfileMeasurement m = measurements.get(0);    assertEquals("profile1", m.getProfileName());    assertEquals(3, m.getProfileValue());}
public void metron_f749_0() throws Exception
{    StandAloneProfiler profiler = createProfiler(twoProfiles);    profiler.apply(message);    profiler.apply(message);    profiler.apply(message);    List<ProfileMeasurement> measurements = profiler.flush();    assertEquals(2, measurements.size());        List<String> expected = Arrays.asList(new String[] { "profile1", "profile2" });    {        ProfileMeasurement m = measurements.get(0);        assertTrue(expected.contains(m.getProfileName()));        assertEquals("result", m.getProfileValue());    }    {        ProfileMeasurement m = measurements.get(1);        assertTrue(expected.contains(m.getProfileName()));        assertEquals("result", m.getProfileValue());    }}
public void metron_f750_0() throws Exception
{    {        StandAloneProfiler profiler = createProfiler(noProfiles);        profiler.apply(message);        assertEquals(1, profiler.getMessageCount());        assertEquals(0, profiler.getRouteCount());        profiler.apply(message);        assertEquals(2, profiler.getMessageCount());        assertEquals(0, profiler.getRouteCount());        profiler.apply(message);        assertEquals(3, profiler.getMessageCount());        assertEquals(0, profiler.getRouteCount());    }    {        StandAloneProfiler profiler = createProfiler(oneProfile);        profiler.apply(message);        assertEquals(1, profiler.getMessageCount());        assertEquals(1, profiler.getRouteCount());        profiler.apply(message);        assertEquals(2, profiler.getMessageCount());        assertEquals(2, profiler.getRouteCount());        profiler.apply(message);        assertEquals(3, profiler.getMessageCount());        assertEquals(3, profiler.getRouteCount());    }    {        StandAloneProfiler profiler = createProfiler(twoProfiles);        profiler.apply(message);        assertEquals(1, profiler.getMessageCount());        assertEquals(2, profiler.getRouteCount());        profiler.apply(message);        assertEquals(2, profiler.getMessageCount());        assertEquals(4, profiler.getRouteCount());        profiler.apply(message);        assertEquals(3, profiler.getMessageCount());        assertEquals(6, profiler.getRouteCount());    }}
public void metron_f751_0() throws Exception
{    {        StandAloneProfiler profiler = createProfiler(noProfiles);        assertEquals(0, profiler.getProfileCount());    }    {        StandAloneProfiler profiler = createProfiler(oneProfile);        assertEquals(1, profiler.getProfileCount());    }    {        StandAloneProfiler profiler = createProfiler(twoProfiles);        assertEquals(2, profiler.getProfileCount());    }}
private ProfilerConfig metron_f752_0(String configAsJSON) throws Exception
{    InputStream in = new ByteArrayInputStream(configAsJSON.getBytes(StandardCharsets.UTF_8));    return JSONUtils.INSTANCE.load(in, ProfilerConfig.class);}
private StandAloneProfiler metron_f753_0(String profileJson) throws Exception
{        long profileTimeToLiveMillis = Long.MAX_VALUE;    long maxNumberOfRoutes = Long.MAX_VALUE;    ProfilerConfig config = toProfilerConfig(profileJson);    return new StandAloneProfiler(config, periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes, context);}
public long metron_f754_1(SparkSession spark, Properties profilerProps, Properties globalProperties, Properties readerProps, ProfilerConfig profiles)
{        Map<String, String> globals = Maps.fromProperties(globalProperties);        TelemetryReader reader = TelemetryReaders.create(TELEMETRY_INPUT_READER.get(profilerProps, String.class));    Dataset<String> telemetry = reader.read(spark, profilerProps, readerProps);            Dataset<MessageRoute> routes = telemetry.flatMap(messageRouterFunction(profilerProps, profiles, globals), Encoders.bean(MessageRoute.class));            Dataset<ProfileMeasurementAdapter> measurements = routes.groupByKey(new GroupByPeriodFunction(profilerProps), Encoders.STRING()).mapGroups(new ProfileBuilderFunction(profilerProps, globals), Encoders.bean(ProfileMeasurementAdapter.class));            long count = measurements.mapPartitions(new HBaseWriterFunction(profilerProps), Encoders.INT()).agg(sum("value")).head().getLong(0);        return count;}
private MessageRouterFunction metron_f755_0(Properties profilerProps, ProfilerConfig profiles, Map<String, String> globals)
{    MessageRouterFunction routerFunction = new MessageRouterFunction(profiles, globals);        Optional<Long> beginAt = timestampParser.parse(TELEMETRY_INPUT_BEGIN.get(profilerProps, String.class));    beginAt.ifPresent(begin -> routerFunction.withBegin(begin));        Optional<Long> endAt = timestampParser.parse(TELEMETRY_INPUT_END.get(profilerProps, String.class));    endAt.ifPresent(end -> routerFunction.withEnd(end));    return routerFunction;}
public String metron_f756_0()
{    return key;}
public Object metron_f757_0()
{    return getDefault(valueType);}
public T metron_f758_0(Class<T> clazz)
{    return defaultValue == null ? null : ConversionUtils.convert(defaultValue, clazz);}
public Object metron_f759_0(Map<String, String> config)
{    return getOrDefault(config, defaultValue);}
public Object metron_f760_0(Properties properties)
{    return getOrDefault(properties, defaultValue);}
public T metron_f761_0(Map<String, String> config, Class<T> clazz)
{    return getOrDefault(config, defaultValue, clazz);}
public T metron_f762_0(Properties properties, Class<T> clazz)
{    return getOrDefault(properties, defaultValue, clazz);}
private Object metron_f763_0(Map<String, String> config, Object defaultValue)
{    return getOrDefault(config, defaultValue, valueType);}
private Object metron_f764_0(Properties properties, Object defaultValue)
{    return getOrDefault(properties, defaultValue, valueType);}
private T metron_f765_0(Map<String, String> config, Object defaultValue, Class<T> clazz)
{    Object value = config.getOrDefault(key, defaultValue.toString());    return value == null ? null : ConversionUtils.convert(value, clazz);}
private T metron_f766_0(Properties properties, Object defaultValue, Class<T> clazz)
{    Object value = properties.getOrDefault(key, defaultValue);    return value == null ? null : ConversionUtils.convert(value, clazz);}
public String metron_f767_0()
{    return key;}
public static void metron_f768_1(String[] args) throws IOException, org.apache.commons.cli.ParseException, Exception
{        CommandLine commandLine = parseCommandLine(args);        profiles = Preconditions.checkNotNull(handleProfileDefinitions(commandLine), "An error occurred while reading profile data");    profilerProps = handleProfilerProperties(commandLine);    globals = handleGlobals(commandLine);    readerProps = handleReaderProperties(commandLine);        if (!profiles.getTimestampField().isPresent()) {        throw new IllegalArgumentException("The Batch Profiler must use event time. The 'timestampField' must be defined in the profile definitions file or via the --timestampField argument.");    }        if (profiles.getProfiles().size() == 0) {        throw new IllegalArgumentException("No profile definitions found.");    }    SparkSession spark = SparkSession.builder().config(new SparkConf()).getOrCreate();    BatchProfiler profiler = new BatchProfiler();    long count = profiler.run(spark, profilerProps, globals, readerProps, profiles);    }
private static ProfilerConfig metron_f769_1(CommandLine commandLine) throws MissingOptionException, IOException
{    final String PROFILE_LOCATION_ERROR = "A single profile location (--profiles or --zookeeper) must be specified";    ProfilerConfig profiles;    if ((!PROFILE_ZK.has(commandLine)) && (!PROFILE_DEFN_FILE.has(commandLine))) {        throw new MissingOptionException(PROFILE_LOCATION_ERROR);    }    if (PROFILE_ZK.has(commandLine) && PROFILE_DEFN_FILE.has(commandLine)) {        throw new IllegalArgumentException(PROFILE_LOCATION_ERROR);    }    if (PROFILE_ZK.has(commandLine)) {        profiles = handleProfileDefinitionsZK(commandLine);    } else {        profiles = handleProfileDefinitionsFile(commandLine);    }        if (PROFILE_TIMESTAMP_FLD.has(commandLine)) {        final String timestampField = PROFILE_TIMESTAMP_FLD.get(commandLine);        Preconditions.checkArgument(!Strings.isNullOrEmpty(timestampField), "timestampField must be not be empty if specified");        profiles.setTimestampField(timestampField);    }        return profiles;}
private static CuratorFramework metron_f770_1(final String zkQuorum)
{        final CuratorFramework zkClient = ZKCache.createClient(zkQuorum, Optional.empty());    zkClient.start();        return zkClient;}
private static Properties metron_f771_1(CommandLine commandLine) throws IOException
{    Properties globals = new Properties();    if (GLOBALS_FILE.has(commandLine)) {        String globalsPath = GLOBALS_FILE.get(commandLine);                globals.load(new FileInputStream(globalsPath));            }    return globals;}
private static Properties metron_f772_1(CommandLine commandLine) throws IOException
{    Properties config = new Properties();    if (PROFILER_PROPS_FILE.has(commandLine)) {        String propertiesPath = PROFILER_PROPS_FILE.get(commandLine);                config.load(new FileInputStream(propertiesPath));            }    return config;}
private static Properties metron_f773_1(CommandLine commandLine) throws IOException
{    Properties config = new Properties();    if (READER_PROPS_FILE.has(commandLine)) {        String readerPropsPath = READER_PROPS_FILE.get(commandLine);                config.load(new FileInputStream(readerPropsPath));            }    return config;}
private static ProfilerConfig metron_f774_1(CommandLine commandLine) throws IOException
{    ProfilerConfig profiles;    if (PROFILE_DEFN_FILE.has(commandLine)) {        String profilePath = PROFILE_DEFN_FILE.get(commandLine);                String contents = IOUtils.toString(new FileInputStream(profilePath));        profiles = ProfilerConfig.fromJSON(contents);            } else {        throw new IllegalArgumentException("No profile(s) defined");    }    return profiles;}
private static ProfilerConfig metron_f775_0(final CommandLine commandLine) throws IOException
{    Preconditions.checkArgument(PROFILE_ZK.has(commandLine));    ProfilerConfig profiles;    final String zkQuorum = PROFILE_ZK.get(commandLine);    try (final CuratorFramework zkClient = createZKClient(zkQuorum)) {        profiles = readProfileFromZK(zkClient);    }    return profiles;}
 static ProfilerConfig metron_f776_1(CuratorFramework zkClient) throws IOException
{    ProfilerConfig profiles;    try {                profiles = ConfigurationsUtils.readProfilerConfigFromZookeeper(zkClient);            } catch (Exception ex) {        throw new IOException(String.format("Error reading configuration from Zookeeper client %s", zkClient.toString()), ex);    }    return profiles;}
private static CommandLine metron_f777_0(String[] args) throws ParseException
{    CommandLineParser parser = new PosixParser();    return parse(parser, args);}
public static Properties metron_f778_0()
{    return globals;}
public static Properties metron_f779_0()
{    return profilerProps;}
public static ProfilerConfig metron_f780_0()
{    return profiles;}
public static Properties metron_f781_0()
{    return readerProps;}
public boolean metron_f782_0(CommandLine cli)
{    return cli.hasOption(option.getOpt());}
public String metron_f783_0(CommandLine cli)
{    return cli.getOptionValue(option.getOpt());}
public String metron_f784_0(CommandLine cli, String defaultValue)
{    return has(cli) ? cli.getOptionValue(option.getOpt()) : defaultValue;}
public static CommandLine metron_f785_0(CommandLineParser parser, String[] args) throws ParseException
{    try {        CommandLine cli = parser.parse(getOptions(), args);        if (HELP.has(cli)) {            printHelp();            System.exit(0);        }        return cli;    } catch (ParseException e) {        System.err.println("invalid arguments: " + Joiner.on(' ').join(args));        e.printStackTrace(System.err);        printHelp();        throw e;    }}
public static void metron_f786_0()
{    HelpFormatter formatter = new HelpFormatter();    String header = "options:";    String footer = "";    String cmd = String.format("spark-submit --class %s --properties-file [spark.properties] [jar] [options]", BatchProfilerCLI.class.getCanonicalName());    formatter.printHelp(cmd, header, getOptions(), footer);}
public static Options metron_f787_0()
{    Options allOptions = new Options();    for (BatchProfilerCLIOptions o : BatchProfilerCLIOptions.values()) {        allOptions.addOption(o.option);    }    return allOptions;}
public String metron_f788_0(MessageRoute route)
{    ProfilePeriod period = ProfilePeriod.fromTimestamp(route.getTimestamp(), periodDuration, periodDurationUnits);    return new StringBuilder().append(route.getProfileDefinition().getProfile()).append(SEPARATOR).append(route.getEntity()).append(SEPARATOR).append(period.getPeriod()).toString();}
public static String metron_f789_0(String groupKey)
{    String[] pieces = groupKey.split(SEPARATOR);    if (pieces.length == 3) {        return pieces[0];    } else {        return "unknown";    }}
public static String metron_f790_0(String groupKey)
{    String[] pieces = groupKey.split(SEPARATOR);    if (pieces.length == 3) {        return pieces[1];    } else {        return "unknown";    }}
public static String metron_f791_0(String groupKey)
{    String[] pieces = groupKey.split(SEPARATOR);    if (pieces.length == 3) {        return pieces[2];    } else {        return "unknown";    }}
public Iterator<Integer> metron_f792_1(Iterator<ProfileMeasurementAdapter> iterator) throws Exception
{    int count = 0;            List<ProfileMeasurementAdapter> measurements = IteratorUtils.toList(iterator);    if (measurements.size() > 0) {                Configuration config = HBaseConfiguration.create();        try (HBaseClient client = new HBaseClient(tableProvider, config, tableName)) {            for (ProfileMeasurementAdapter adapter : measurements) {                ProfileMeasurement m = adapter.toProfileMeasurement();                client.addMutation(rowKeyBuilder.rowKey(m), columnBuilder.columns(m), durability);            }            count = client.mutate();        } catch (IOException e) {                        throw new RuntimeException(e);        }    }        return IteratorUtils.singletonIterator(count);}
public HBaseWriterFunction metron_f793_0(String providerImpl)
{    this.tableProvider = createTableProvider(providerImpl);    return this;}
private static TableProvider metron_f794_0(String providerImpl)
{    LOG.trace("Creating table provider; className={}", providerImpl);        if (StringUtils.isEmpty(providerImpl) || providerImpl.charAt(0) == '$') {        return new HTableProvider();    }        try {        Class<? extends TableProvider> clazz = (Class<? extends TableProvider>) Class.forName(providerImpl);        return clazz.getConstructor().newInstance();    } catch (InstantiationException | IllegalAccessException | IllegalStateException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {        throw new IllegalStateException("Unable to instantiate connector", e);    }}
public Iterator<MessageRoute> metron_f795_0(String jsonMessage) throws Exception
{    List<MessageRoute> routes = Collections.emptyList();    JSONParser parser = new JSONParser();    Context context = TaskUtils.getContext(globals);    MessageRouter router = new DefaultMessageRouter(context);        Optional<JSONObject> message = toMessage(jsonMessage, parser);    if (message.isPresent()) {                Optional<Long> timestampOpt = clock.currentTimeMillis(message.get());        if (timestampOpt.isPresent()) {                        Long timestamp = timestampOpt.get();            if (timestamp >= begin && timestamp <= end) {                routes = router.route(message.get(), profilerConfig, context);                LOG.trace("Found {} route(s) for a message", routes.size());            } else {                LOG.trace("Ignoring message; timestamp={} not in [{},{}]", () -> timestamp, () -> prettyPrint(begin), () -> prettyPrint(end));            }        } else {            LOG.trace("No timestamp in message. Message will be ignored.");        }    } else {        LOG.trace("Unable to parse message. Message will be ignored");    }    return routes.iterator();}
public MessageRouterFunction metron_f796_0(Long begin)
{    this.begin = begin;    return this;}
public MessageRouterFunction metron_f797_0(Long end)
{    this.end = end;    return this;}
public MessageRouterFunction metron_f798_0(ClockFactory clockFactory)
{    this.clock = clockFactory.createClock(profilerConfig);    return this;}
private static String metron_f800_0(Long value)
{    String result;    if (value == Long.MIN_VALUE) {        result = "MIN";    } else if (value == Long.MAX_VALUE) {        result = "MAX";    } else {        result = value.toString();    }    return result;}
private static Stream<T> metron_f802_0(Iterator<T> iterator)
{    Iterable<T> iterable = () -> iterator;    return StreamSupport.stream(iterable.spliterator(), false);}
public static Context metron_f803_0(Map<String, String> globals)
{    Context context = new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> globals).with(Context.Capabilities.STELLAR_CONFIG, () -> globals).build();    StellarFunctions.initialize(context);    return context;}
public ProfileMeasurement metron_f804_0()
{    ProfilePeriod period = ProfilePeriod.fromPeriodId(periodId, durationMillis, TimeUnit.MILLISECONDS);    ProfileMeasurement measurement = new ProfileMeasurement().withProfileName(profileName).withEntity(entity).withPeriod(period).withProfileValue(SerDeUtils.fromBytes(profileValue, Object.class));    return measurement;}
public String metron_f805_0()
{    return profileName;}
public void metron_f806_0(String profileName)
{    this.profileName = profileName;}
public String metron_f807_0()
{    return entity;}
public void metron_f808_0(String entity)
{    this.entity = entity;}
public Long metron_f809_0()
{    return periodId;}
public void metron_f810_0(Long periodId)
{    this.periodId = periodId;}
public Long metron_f811_0()
{    return durationMillis;}
public void metron_f812_0(Long durationMillis)
{    this.durationMillis = durationMillis;}
public byte[] metron_f813_0()
{    return profileValue;}
public void metron_f814_0(byte[] profileValue)
{    this.profileValue = profileValue;}
public void metron_f815_0(Object profileValue)
{    this.profileValue = SerDeUtils.toBytes(profileValue);}
public static TelemetryReader metron_f817_1(String propertyValue)
{        TelemetryReader reader = null;    try {        String key = StringUtils.upperCase(propertyValue);        TelemetryReaders strategy = TelemetryReaders.valueOf(key);        reader = strategy.supplier.get();    } catch (IllegalArgumentException e) {                throw e;    }    return reader;}
public Dataset<String> metron_f818_0(SparkSession spark, Properties profilerProps, Properties readerProps)
{    return supplier.get().read(spark, profilerProps, readerProps);}
public Optional<Long> metron_f820_0(String inputString)
{    Optional<Long> epochMilli = Optional.empty();        if (StringUtils.isNotBlank(inputString)) {        epochMilli = Optional.of(new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_INSTANT).toFormatter().parse(inputString, Instant::from).toEpochMilli());    }    return epochMilli;}
public static void metron_f821_0()
{    SparkConf conf = new SparkConf().setMaster("local").setAppName("BatchProfilerIntegrationTest").set("spark.sql.shuffle.partitions", "8");    spark = SparkSession.builder().config(conf).getOrCreate();}
public static void metron_f822_0()
{    if (spark != null) {        spark.close();    }}
public void metron_f823_0()
{    readerProperties = new Properties();    profilerProperties = new Properties();        String tableName = HBASE_TABLE_NAME.get(profilerProperties, String.class);    String columnFamily = HBASE_COLUMN_FAMILY.get(profilerProperties, String.class);    profilerProperties.put(HBASE_TABLE_PROVIDER.getKey(), MockHBaseTableProvider.class.getName());        MockHBaseTableProvider.addToCache(tableName, columnFamily);        Map<String, Object> global = new HashMap<String, Object>() {        {            put(PROFILER_HBASE_TABLE.getKey(), tableName);            put(PROFILER_COLUMN_FAMILY.getKey(), columnFamily);            put(PROFILER_HBASE_TABLE_PROVIDER.getKey(), MockHBaseTableProvider.class.getName());        }    };        executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(GetProfile.class).withClass(FixedLookback.class).withClass(WindowLookback.class), new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> global).build());}
public void metron_f824_0() throws Exception
{        profilerProperties.put(TELEMETRY_INPUT_READER.getKey(), JSON.toString());    profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), "src/test/resources/telemetry.json");    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(profileJson));    validateProfiles();}
public void metron_f825_0() throws Exception
{        String pathToORC = tempFolder.getRoot().getAbsolutePath();    spark.read().format("json").load("src/test/resources/telemetry.json").write().mode("overwrite").format("org.apache.spark.sql.execution.datasources.orc").save(pathToORC);        profilerProperties.put(TELEMETRY_INPUT_READER.getKey(), ORC.toString());    profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), pathToORC);    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(profileJson));    validateProfiles();}
public void metron_f826_0() throws Exception
{        String inputPath = tempFolder.getRoot().getAbsolutePath();    spark.read().format("json").load("src/test/resources/telemetry.json").write().mode("overwrite").format("parquet").save(inputPath);        profilerProperties.put(TELEMETRY_INPUT_READER.getKey(), PARQUET.toString());    profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), inputPath);    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(profileJson));    validateProfiles();}
public void metron_f827_0() throws Exception
{        String pathToCSV = tempFolder.getRoot().getAbsolutePath();    spark.read().format("text").load("src/test/resources/telemetry.json").as(Encoders.STRING()).write().mode("overwrite").option("header", "true").format("csv").save(pathToCSV);            profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), pathToCSV);    profilerProperties.put(TELEMETRY_INPUT_READER.getKey(), "text");    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "csv");        readerProperties.put("header", "true");    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(profileJson));    validateProfiles();}
public void metron_f828_0() throws Exception
{        profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), "src/test/resources/telemetry.json");    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "text");        profilerProperties.put(TELEMETRY_INPUT_BEGIN.getKey(), "");    profilerProperties.put(TELEMETRY_INPUT_END.getKey(), "2018-07-07T15:51:48Z");    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(profileJson));        assign("maxTimestamp", "1530978728982L");        assign("window", "PROFILE_WINDOW('from 5 hours ago', maxTimestamp)");    assertTrue(execute("[12] == PROFILE_GET('count-by-ip', '192.168.66.1', window)", Boolean.class));    assertTrue(execute("[28] == PROFILE_GET('count-by-ip', '192.168.138.158', window)", Boolean.class));    assertTrue(execute("[40] == PROFILE_GET('total-count', 'total', window)", Boolean.class));}
public void metron_f829_0() throws Exception
{        profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), "src/test/resources/telemetry.json");    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "text");        profilerProperties.put(TELEMETRY_INPUT_BEGIN.getKey(), "2018-07-07T15:51:48Z");    profilerProperties.put(TELEMETRY_INPUT_END.getKey(), "");    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(profileJson));        assign("maxTimestamp", "1530978728982L");        assign("window", "PROFILE_WINDOW('from 5 hours ago', maxTimestamp)");    assertTrue(execute("[14] == PROFILE_GET('count-by-ip', '192.168.66.1', window)", Boolean.class));    assertTrue(execute("[46] == PROFILE_GET('count-by-ip', '192.168.138.158', window)", Boolean.class));    assertTrue(execute("[60] == PROFILE_GET('total-count', 'total', window)", Boolean.class));}
public void metron_f830_0() throws Exception
{    profilerProperties.put(TELEMETRY_INPUT_READER.getKey(), JSON.toString());    profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), "src/test/resources/telemetry.json");        BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(invalidProfileJson));}
public void metron_f831_0() throws Exception
{    profilerProperties.put(TELEMETRY_INPUT_READER.getKey(), JSON.toString());    profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), "src/test/resources/telemetry.json");    BatchProfiler profiler = new BatchProfiler();    profiler.run(spark, profilerProperties, getGlobals(), readerProperties, fromJSON(statsProfileJson));        validateProfiles();}
private void metron_f832_0()
{        assign("maxTimestamp", "1530978728982L");        assign("window", "PROFILE_WINDOW('from 5 hours ago', maxTimestamp)");        assertTrue(execute("[26] == PROFILE_GET('count-by-ip', '192.168.66.1', window)", Boolean.class));        assertTrue(execute("[74] == PROFILE_GET('count-by-ip', '192.168.138.158', window)", Boolean.class));        assertTrue(execute("[100] == PROFILE_GET('total-count', 'total', window)", Boolean.class));}
private Properties metron_f833_0()
{    return new Properties();}
private void metron_f834_0(String var, String expression)
{    executor.assign(var, expression, Collections.emptyMap());}
private T metron_f835_1(String expression, Class<T> clazz)
{    T results = executor.execute(expression, Collections.emptyMap(), clazz);        return results;}
public void metron_f836_0() throws Exception
{    String[] args = new String[] { "--profiles", "src/test/resources/profiles-no-timestamp-field.json" };    BatchProfilerCLI.main(args);}
public void metron_f837_0() throws Exception
{    String[] args = new String[] {};    BatchProfilerCLI.main(args);}
public void metron_f838_0() throws Exception
{    String[] args = new String[] { "--profiles", "src/test/resources/profiles-no-timestamp-field.json", "--zookeeper", "node1:2181" };    BatchProfilerCLI.main(args);}
public void metron_f839_0() throws Exception
{    String[] args = new String[] { "--timestampfield" };    BatchProfilerCLI.main(args);}
public void metron_f840_0() throws Exception
{    String[] args = new String[] { "--profiles", "src/test/resources/profiles-empty.json" };    BatchProfilerCLI.main(args);}
public void metron_f841_0() throws Exception
{    final byte[] profileExpectedByte = profile.getBytes(StandardCharsets.UTF_8);    final ProfilerConfig expectedProfileConfig = ProfilerConfig.fromBytes(profileExpectedByte);    TestZKServer.runWithZK((zkServer, zkClient) -> {                ConfigurationsUtils.writeProfilerConfigToZookeeper(profileExpectedByte, zkClient);                final ProfilerConfig profiles = BatchProfilerCLI.readProfileFromZK(zkClient);                Assert.assertEquals("Profile read from zookeeper has changes", expectedProfileConfig, profiles);    });}
public void metron_f842_0() throws Exception
{    final byte[] profileExpectedByte = profile.getBytes(StandardCharsets.UTF_8);    final ProfilerConfig expectedProfileConfig = ProfilerConfig.fromBytes(profileExpectedByte);    expectedProfileConfig.setTimestampField("foobar");    TestZKServer.runWithZK((zkServer, zkClient) -> {                ConfigurationsUtils.writeProfilerConfigToZookeeper(profileExpectedByte, zkClient);                final ProfilerConfig profiles = BatchProfilerCLI.readProfileFromZK(zkClient);                Assert.assertNotEquals("Profile zookeeper integration test fails to detect change", expectedProfileConfig, profiles);    });}
public void metron_f843_0() throws Exception
{    final ProfileConfig profile = ProfileConfig.fromJSON(profileJSON);    final Long timestamp = System.currentTimeMillis();    final String entity = "192.168.1.1";    final JSONObject message = new JSONObject();    final String periodId = new Long(ProfilePeriod.fromTimestamp(timestamp, 15, TimeUnit.MINUTES).getPeriod()).toString();    MessageRoute route = new MessageRoute(profile, entity, message, timestamp);    String groupKey = new GroupByPeriodFunction(new Properties()).call(route);        Assert.assertEquals("my-profile-name", GroupByPeriodFunction.profileFromKey(groupKey));    Assert.assertEquals(entity, GroupByPeriodFunction.entityFromKey(groupKey));    Assert.assertEquals(periodId, GroupByPeriodFunction.periodFromKey(groupKey));}
public void metron_f844_0()
{    profilerProperties = getProfilerProperties();        String tableName = HBASE_TABLE_NAME.get(profilerProperties, String.class);    String columnFamily = HBASE_COLUMN_FAMILY.get(profilerProperties, String.class);    MockHBaseTableProvider.addToCache(tableName, columnFamily);}
public void metron_f845_0() throws Exception
{    JSONObject message = getMessage();    String entity = (String) message.get("ip_src_addr");    long timestamp = (Long) message.get("timestamp");    ProfileConfig profile = getProfile();        List<ProfileMeasurementAdapter> measurements = createMeasurements(1, entity, timestamp, profile);        HBaseWriterFunction function = new HBaseWriterFunction(profilerProperties);    function.withTableProviderImpl(MockHBaseTableProvider.class.getName());        Iterator<Integer> results = function.call(measurements.iterator());        List<Integer> counts = IteratorUtils.toList(results);    Assert.assertEquals(1, counts.size());    Assert.assertEquals(1, counts.get(0).intValue());}
public void metron_f846_0() throws Exception
{    JSONObject message = getMessage();    String entity = (String) message.get("ip_src_addr");    long timestamp = (Long) message.get("timestamp");    ProfileConfig profile = getProfile();        List<ProfileMeasurementAdapter> measurements = createMeasurements(10, entity, timestamp, profile);        HBaseWriterFunction function = new HBaseWriterFunction(profilerProperties);    function.withTableProviderImpl(MockHBaseTableProvider.class.getName());        Iterator<Integer> results = function.call(measurements.iterator());        List<Integer> counts = IteratorUtils.toList(results);    Assert.assertEquals(1, counts.size());    Assert.assertEquals(10, counts.get(0).intValue());}
public void metron_f847_0() throws Exception
{        List<ProfileMeasurementAdapter> measurements = new ArrayList<>();        HBaseWriterFunction function = new HBaseWriterFunction(profilerProperties);    function.withTableProviderImpl(MockHBaseTableProvider.class.getName());        Iterator<Integer> results = function.call(measurements.iterator());        List<Integer> counts = IteratorUtils.toList(results);    Assert.assertEquals(1, counts.size());    Assert.assertEquals(0, counts.get(0).intValue());}
private List<ProfileMeasurementAdapter> metron_f848_0(int count, String entity, long timestamp, ProfileConfig profile)
{    List<ProfileMeasurementAdapter> measurements = new ArrayList<>();    for (int i = 0; i < count; i++) {        ProfileMeasurement measurement = new ProfileMeasurement().withProfileName(profile.getProfile()).withEntity(entity).withPeriod(timestamp, 15, TimeUnit.MINUTES);                measurements.add(new ProfileMeasurementAdapter(measurement));    }    return measurements;}
private JSONObject metron_f849_0()
{    JSONObject message = new JSONObject();    message.put("ip_src_addr", "192.168.1.1");    message.put("status", "red");    message.put("timestamp", System.currentTimeMillis());    return message;}
private Properties metron_f850_0()
{    return new Properties();}
private ProfileConfig metron_f851_0()
{    return new ProfileConfig().withProfile("profile1").withForeach("ip_src_addr").withUpdate("count", "count + 1").withResult("count");}
public void metron_f852_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals());    Iterator<MessageRoute> iter = function.call(goodMessage);    List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(1, routes.size());    Assert.assertEquals("profile1", routes.get(0).getProfileDefinition().getProfile());}
public void metron_f853_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profileWithSystemTime(), getGlobals());    Iterator<MessageRoute> iter = function.call(goodMessage);    Assert.fail("Exception expected as system time is not supported.");}
public void metron_f854_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals());    Iterator<MessageRoute> iter = function.call(badMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(0, routes.size());}
public void metron_f855_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(twoProfiles(), getGlobals());    Iterator<MessageRoute> iter = function.call(goodMessage);    List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(2, routes.size());    Assert.assertEquals("profile1", routes.get(0).getProfileDefinition().getProfile());    Assert.assertEquals("profile2", routes.get(1).getProfileDefinition().getProfile());}
public void metron_f856_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals());    Iterator<MessageRoute> iter = function.call(messageNoTimestamp);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(0, routes.size());}
public void metron_f857_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals()).withBegin(messageTimestamp + 1000);    Iterator<MessageRoute> iter = function.call(goodMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(0, routes.size());}
public void metron_f858_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals()).withBegin(messageTimestamp - 1000);    Iterator<MessageRoute> iter = function.call(goodMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(1, routes.size());}
public void metron_f859_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals()).withEnd(messageTimestamp - 1000);    Iterator<MessageRoute> iter = function.call(goodMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(0, routes.size());}
public void metron_f860_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals()).withEnd(messageTimestamp + 1000);    Iterator<MessageRoute> iter = function.call(goodMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(1, routes.size());}
public void metron_f861_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals()).withBegin(messageTimestamp + 1000).withEnd(messageTimestamp + 2000);    Iterator<MessageRoute> iter = function.call(goodMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(0, routes.size());}
public void metron_f862_0() throws Exception
{    MessageRouterFunction function = new MessageRouterFunction(profile(), getGlobals()).withBegin(messageTimestamp - 1000).withEnd(messageTimestamp + 1000);    Iterator<MessageRoute> iter = function.call(goodMessage);        List<MessageRoute> routes = Lists.newArrayList(iter);    Assert.assertEquals(1, routes.size());}
private ProfilerConfig metron_f863_0()
{    ProfileConfig profile = new ProfileConfig().withProfile("profile1").withForeach("ip_src_addr").withUpdate("count", "count + 1").withResult("count");    return new ProfilerConfig().withProfile(profile).withTimestampField(Optional.of("timestamp"));}
private ProfilerConfig metron_f864_0()
{    ProfileConfig profile1 = new ProfileConfig().withProfile("profile1").withForeach("ip_src_addr").withUpdate("count", "count + 1").withResult("count");    ProfileConfig profile2 = new ProfileConfig().withProfile("profile2").withForeach("ip_src_addr").withUpdate("count", "count + 1").withResult("count");    return new ProfilerConfig().withProfile(profile1).withProfile(profile2).withTimestampField(Optional.of("timestamp"));}
private ProfilerConfig metron_f865_0()
{    ProfileConfig profile = new ProfileConfig().withProfile("profile1").withForeach("ip_src_addr").withUpdate("count", "count + 1").withResult("count");    return new ProfilerConfig().withProfile(profile);}
private Map<String, String> metron_f866_0()
{    return Collections.emptyMap();}
public void metron_f867_0() throws Exception
{        JSONObject message = getMessage();    String entity = "192.168.1.1";    long timestamp = (Long) message.get("timestamp");    ProfileConfig profile = ProfileConfig.fromJSON(profileJSON);        MessageRoute route = new MessageRoute(profile, entity, message, timestamp);    List<MessageRoute> routes = new ArrayList();    routes.add(route);    routes.add(route);    routes.add(route);    Properties profilerProperties = getProfilerProperties();        int periodDuration = PERIOD_DURATION.get(profilerProperties, Integer.class);    TimeUnit periodDurationUnits = TimeUnit.valueOf(PERIOD_DURATION_UNITS.get(profilerProperties, String.class));    ProfilePeriod expectedPeriod = ProfilePeriod.fromTimestamp(timestamp, periodDuration, periodDurationUnits);        ProfileBuilderFunction function = new ProfileBuilderFunction(profilerProperties, getGlobals());    ProfileMeasurementAdapter measurement = function.call("profile1-192.168.1.1-0", routes.iterator());        Assert.assertEquals(entity, measurement.getEntity());    Assert.assertEquals(profile.getProfile(), measurement.getProfileName());    Assert.assertEquals(routes.size(), measurement.toProfileMeasurement().getProfileValue());    Assert.assertEquals(expectedPeriod.getPeriod(), (long) measurement.getPeriodId());}
public void metron_f868_0() throws Exception
{        JSONObject message = getMessage();    String entity = "192.168.1.1";    long timestamp = (Long) message.get("timestamp");    ProfileConfig profile = ProfileConfig.fromJSON(invalidProfileJson);        MessageRoute route = new MessageRoute(profile, entity, message, timestamp);    List<MessageRoute> routes = new ArrayList();    routes.add(route);    routes.add(route);    routes.add(route);    Properties profilerProperties = getProfilerProperties();        ProfileBuilderFunction function = new ProfileBuilderFunction(profilerProperties, getGlobals());    ProfileMeasurementAdapter measurement = function.call("profile1-192.168.1.1-0", routes.iterator());}
private JSONObject metron_f869_0()
{    JSONObject message = new JSONObject();    message.put("ip_src_addr", "192.168.1.1");    message.put("status", "red");    message.put("timestamp", System.currentTimeMillis());    return message;}
private Properties metron_f870_0()
{    return new Properties();}
private Map<String, String> metron_f871_0()
{    return Collections.emptyMap();}
public static void metron_f872_0()
{    SparkConf conf = new SparkConf().setMaster("local").setAppName("BatchProfilerIntegrationTest").set("spark.sql.shuffle.partitions", "8");    spark = SparkSession.builder().config(conf).getOrCreate();}
public static void metron_f873_0()
{    if (spark != null) {        spark.close();    }}
public void metron_f874_0()
{    readerProperties = new Properties();    profilerProperties = new Properties();}
public void metron_f875_0()
{        String inputPath = tempFolder.getRoot().getAbsolutePath();    spark.read().format("json").load("src/test/resources/telemetry.json").write().mode("overwrite").format("parquet").save(inputPath);        profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), inputPath);    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "parquet");        readerProperties.put("header", "true");        Dataset<String> telemetry = TelemetryReaders.COLUMNAR.read(spark, profilerProperties, readerProperties);    Assert.assertEquals(100, telemetry.filter(new IsValidJSON()).count());}
public void metron_f876_0()
{        String pathToORC = tempFolder.getRoot().getAbsolutePath();    spark.read().format("json").load("src/test/resources/telemetry.json").write().mode("overwrite").format("org.apache.spark.sql.execution.datasources.orc").save(pathToORC);        profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), pathToORC);    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "org.apache.spark.sql.execution.datasources.orc");        Dataset<String> telemetry = TelemetryReaders.COLUMNAR.read(spark, profilerProperties, readerProperties);    Assert.assertEquals(100, telemetry.filter(new IsValidJSON()).count());}
public boolean metron_f877_0(String text) throws Exception
{    JSONParser parser = new JSONParser();    JSONObject json = (JSONObject) parser.parse(text);        return json.keySet().size() >= 32;}
public void metron_f878_0()
{    String key = JSON.toString();    Assert.assertTrue(TelemetryReaders.create(key) instanceof TextEncodedTelemetryReader);}
public void metron_f879_0()
{    String key = JSON.toString().toLowerCase();    Assert.assertTrue(TelemetryReaders.create(key) instanceof TextEncodedTelemetryReader);}
public void metron_f880_0()
{    String key = ORC.toString();    Assert.assertTrue(TelemetryReaders.create(key) instanceof ColumnEncodedTelemetryReader);}
public void metron_f881_0()
{    String key = ORC.toString().toLowerCase();    Assert.assertTrue(TelemetryReaders.create(key) instanceof ColumnEncodedTelemetryReader);}
public void metron_f882_0()
{    String key = PARQUET.toString();    Assert.assertTrue(TelemetryReaders.create(key) instanceof ColumnEncodedTelemetryReader);}
public void metron_f883_0()
{    String key = PARQUET.toString().toLowerCase();    Assert.assertTrue(TelemetryReaders.create(key) instanceof ColumnEncodedTelemetryReader);}
public void metron_f884_0()
{    String key = TEXT.toString();    Assert.assertTrue(TelemetryReaders.create(key) instanceof TextEncodedTelemetryReader);}
public void metron_f885_0()
{    String key = COLUMNAR.toString();    Assert.assertTrue(TelemetryReaders.create(key) instanceof ColumnEncodedTelemetryReader);}
public void metron_f886_0()
{    TelemetryReaders.create("invalid");    Assert.fail("exception expected");}
public static void metron_f887_0()
{    SparkConf conf = new SparkConf().setMaster("local").setAppName("BatchProfilerIntegrationTest").set("spark.sql.shuffle.partitions", "8");    spark = SparkSession.builder().config(conf).getOrCreate();}
public static void metron_f888_0()
{    if (spark != null) {        spark.close();    }}
public void metron_f889_0()
{    readerProperties = new Properties();    profilerProperties = new Properties();}
public void metron_f890_0()
{        String pathToCSV = tempFolder.getRoot().getAbsolutePath();    spark.read().format("text").load("src/test/resources/telemetry.json").as(Encoders.STRING()).write().mode("overwrite").option("header", "true").format("csv").save(pathToCSV);        profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), pathToCSV);    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "csv");        readerProperties.put("header", "true");        Dataset<String> telemetry = TelemetryReaders.TEXT.read(spark, profilerProperties, readerProperties);    Assert.assertEquals(100, telemetry.filter(new IsValidJSON()).count());}
public void metron_f891_0()
{        profilerProperties.put(TELEMETRY_INPUT_PATH.getKey(), "src/test/resources/telemetry.json");    profilerProperties.put(TELEMETRY_INPUT_FORMAT.getKey(), "text");        readerProperties.put("header", "true");        Dataset<String> telemetry = TelemetryReaders.TEXT.read(spark, profilerProperties, readerProperties);    Assert.assertEquals(100, telemetry.filter(new IsValidJSON()).count());}
public void metron_f892_0()
{    parser = new TimestampParser();}
public void metron_f893_0()
{    Optional<Long> millis = parser.parse("");    assertFalse(millis.isPresent());}
public void metron_f894_0()
{    Optional<Long> millis = parser.parse("      ");    assertFalse(millis.isPresent());}
public void metron_f895_0()
{        Optional<Long> millis = parser.parse("2011-12-03T10:15:30Z");    assertTrue(millis.isPresent());    assertEquals(1322907330000L, millis.get().longValue());}
public void metron_f896_0()
{    parser.parse("1537502400000");    fail("Expected exception");}
public void metron_f897_0(Exception e)
{    collector.reportError(e);    for (Tuple t : tupleBatch) {        collector.fail(t);    }    tupleBatch.clear();    forceFlush = false;}
public void metron_f898_0()
{    for (Tuple t : tupleBatch) {        collector.ack(t);    }    tupleBatch.clear();    forceFlush = false;}
public boolean metron_f899_1(Tuple tuple)
{    if (isTick(tuple)) {                forceFlush = true;        return false;    } else {        return true;    }}
public void metron_f900_0(Tuple tuple)
{    tupleBatch.add(tuple);    if (tupleBatch.size() >= batchSize) {        forceFlush = true;    }}
public List<Tuple> metron_f901_0()
{    return this.tupleBatch;}
public int metron_f902_0()
{    return this.batchSize;}
public boolean metron_f903_0()
{    return forceFlush && !tupleBatch.isEmpty();}
public boolean metron_f904_0(Tuple tuple)
{    return tuple != null && Constants.SYSTEM_COMPONENT_ID.equals(tuple.getSourceComponent()) && Constants.SYSTEM_TICK_STREAM_ID.equals(tuple.getSourceStreamId());}
public HBaseBolt metron_f905_0(boolean writeToWAL)
{    this.writeToWAL = writeToWAL;    return this;}
public HBaseBolt metron_f906_0(String tableProvider)
{    this.tableProviderClazzName = tableProvider;    return this;}
public HBaseBolt metron_f907_0(TableProvider tableProvider)
{    this.tableProvider = tableProvider;    return this;}
public HBaseBolt metron_f908_0(int batchSize)
{    this.batchSize = batchSize;    return this;}
public HBaseBolt metron_f909_0(int flushIntervalSecs)
{    this.flushIntervalSecs = flushIntervalSecs;    return this;}
public void metron_f910_0(HBaseClient hbaseClient)
{    this.hbaseClient = hbaseClient;}
public Map<String, Object> metron_f911_1()
{        Config conf = new Config();    conf.put(Config.TOPOLOGY_TICK_TUPLE_FREQ_SECS, flushIntervalSecs);    return conf;}
public void metron_f912_0(Map map, TopologyContext topologyContext, OutputCollector collector)
{    this.collector = collector;    this.batchHelper = new BatchHelper(batchSize, collector);    TableProvider provider;    if (this.tableProvider == null) {        provider = createTableProvider(tableProviderClazzName);    } else {        provider = this.tableProvider;    }    hbaseClient = new HBaseClient(provider, HBaseConfiguration.create(), tableName);}
public void metron_f914_0(Tuple tuple)
{    LOG.trace("Received a tuple.");    try {        if (batchHelper.shouldHandle(tuple)) {            save(tuple);        }        if (batchHelper.shouldFlush()) {            flush();        }    } catch (Exception e) {        batchHelper.fail(e);        hbaseClient.clearMutations();    }}
private void metron_f916_1()
{        this.hbaseClient.mutate();    batchHelper.ack();}
private static TableProvider metron_f917_0(String connectorImpl)
{    LOG.trace("Creating table provider; className={}", connectorImpl);        if (StringUtils.isEmpty(connectorImpl) || connectorImpl.charAt(0) == '$') {        return new HTableProvider();    }        try {        Class<? extends TableProvider> clazz = (Class<? extends TableProvider>) Class.forName(connectorImpl);        return clazz.getConstructor().newInstance();    } catch (InstantiationException | IllegalAccessException | IllegalStateException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {        throw new IllegalStateException("Unable to instantiate connector", e);    }}
public void metron_f918_1()
{    minTime = Long.MAX_VALUE;    maxTime = Long.MIN_VALUE;    }
public void metron_f919_0(long timestamp)
{    if (LOG.isWarnEnabled()) {        checkIfOutOfOrder(timestamp);    }    if (timestamp < minTime) {        minTime = timestamp;    }    if (timestamp > maxTime) {        maxTime = timestamp;    }}
private void metron_f920_1(long timestamp)
{        if (maxTime > Long.MIN_VALUE) {        long outOfOrderBy = maxTime - timestamp;        if (Math.abs(outOfOrderBy) > flushFrequency) {                    }    }}
public long metron_f922_0()
{    return maxTime;}
public void metron_f923_0(OutputFieldsDeclarer declarer)
{    declarer.declareStream(getStreamId(), new Fields("measurement"));}
public String metron_f925_0()
{    return streamId;}
public void metron_f926_0(String streamId)
{    this.streamId = streamId;}
public void metron_f927_0(OutputFieldsDeclarer declarer)
{        declarer.declareStream(getStreamId(), new Fields("message"));}
private JSONObject metron_f930_0(ProfileMeasurement measurement)
{    JSONObject message = new JSONObject();    message.put(PROFILE_FIELD, measurement.getDefinition().getProfile());    message.put(ENTITY_FIELD, measurement.getEntity());    message.put(PERIOD_ID_FIELD, measurement.getPeriod().getPeriod());    message.put(PERIOD_START_FIELD, measurement.getPeriod().getStartTimeMillis());    message.put(PERIOD_END_FIELD, measurement.getPeriod().getEndTimeMillis());    message.put(TIMESTAMP_FIELD, System.currentTimeMillis());    message.put(Constants.SENSOR_TYPE, sourceType);    message.put(ALERT_FIELD, "true");    message.put(Constants.GUID, UUID.randomUUID().toString());    return message;}
private boolean metron_f931_0(Object value)
{    return value != null && (value instanceof String || ClassUtils.isPrimitiveOrWrapper(value.getClass()));}
public String metron_f932_0()
{    return streamId;}
public void metron_f933_0(String streamId)
{    this.streamId = streamId;}
public String metron_f934_0()
{    return sourceType;}
public void metron_f935_0(String sourceType)
{    this.sourceType = sourceType;}
public void metron_f936_0(boolean flushNow)
{    this.flushNow = flushNow;}
public boolean metron_f937_0()
{    return flushNow;}
public long metron_f940_0()
{        return 0;}
public void metron_f941_0(Map stormConf, TopologyContext context, OutputCollector collector)
{    super.prepare(stormConf, context, collector);    if (periodDurationMillis <= 0) {        throw new IllegalArgumentException("expect 'profiler.period.duration' >= 0");    }    if (profileTimeToLiveMillis <= 0) {        throw new IllegalArgumentException("expect 'profiler.ttl' >= 0");    }    if (profileTimeToLiveMillis < periodDurationMillis) {        throw new IllegalArgumentException("expect 'profiler.ttl' >= 'profiler.period.duration'");    }    if (maxNumberOfRoutes <= 0) {        throw new IllegalArgumentException("expect 'profiler.max.routes.per.bolt' > 0");    }    if (windowDurationMillis <= 0) {        throw new IllegalArgumentException("expect 'profiler.window.duration' > 0");    }    if (windowDurationMillis > periodDurationMillis) {        throw new IllegalArgumentException("expect 'profiler.period.duration' >= 'profiler.window.duration'");    }    if (periodDurationMillis % windowDurationMillis != 0) {        throw new IllegalArgumentException("expect 'profiler.period.duration' % 'profiler.window.duration' == 0");    }    this.collector = collector;    this.parser = new JSONParser();    this.messageDistributor = new DefaultMessageDistributor(periodDurationMillis, profileTimeToLiveMillis, maxNumberOfRoutes);    this.configurations = new ProfilerConfigurations();    this.activeFlushSignal = new FixedFrequencyFlushSignal(periodDurationMillis);    setupZookeeper();    startFlushingExpiredProfiles();}
public void metron_f942_1()
{    try {        zookeeperCache.close();        zookeeperClient.close();        flushExpiredExecutor.shutdown();    } catch (Throwable e) {            }}
private void metron_f943_1()
{    try {        if (zookeeperClient == null) {            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);            zookeeperClient = CuratorFrameworkFactory.newClient(zookeeperUrl, retryPolicy);        }        zookeeperClient.start();                        ConfigurationsUtils.setupStellarStatically(zookeeperClient);        if (zookeeperCache == null) {            ConfigurationsUpdater<ProfilerConfigurations> updater = createUpdater();            SimpleEventListener listener = new SimpleEventListener.Builder().with(updater::update, TreeCacheEvent.Type.NODE_ADDED, TreeCacheEvent.Type.NODE_UPDATED).with(updater::delete, TreeCacheEvent.Type.NODE_REMOVED).build();            zookeeperCache = new ZKCache.Builder().withClient(zookeeperClient).withListener(listener).withRoot(Constants.ZOOKEEPER_TOPOLOGY_ROOT).build();            updater.forceUpdate(zookeeperClient);            zookeeperCache.start();        }    } catch (Exception e) {                throw new RuntimeException(e);    }}
protected ConfigurationsUpdater<ProfilerConfigurations> metron_f944_0()
{    return new ProfilerUpdater(this, this::getConfigurations);}
public ProfilerConfigurations metron_f945_0()
{    return configurations;}
public void metron_f947_0(OutputFieldsDeclarer declarer)
{    if (emitters.size() == 0) {        throw new IllegalStateException("At least one destination handler must be defined.");    }        emitters.forEach(emitter -> emitter.declareOutputFields(declarer));}
private Context metron_f948_0()
{    Map<String, Object> global = getConfigurations().getGlobalConfig();    return new Context.Builder().with(Context.Capabilities.ZOOKEEPER_CLIENT, () -> zookeeperClient).with(Context.Capabilities.GLOBAL_CONFIG, () -> global).with(Context.Capabilities.STELLAR_CONFIG, () -> global).build();}
public void metron_f950_1(TupleWindow window)
{    if (LOG.isDebugEnabled()) {        log(window);    }    try {                for (Tuple tuple : window.get()) {            handleMessage(tuple);        }                if (activeFlushSignal.isTimeToFlush()) {            flushActive();        }    } catch (Throwable e) {                collector.reportError(e);    }}
protected void metron_f951_1()
{    activeFlushSignal.reset();        List<ProfileMeasurement> measurements;    synchronized (messageDistributor) {        measurements = messageDistributor.flush();        emitMeasurements(measurements);    }    }
protected void metron_f952_1()
{    List<ProfileMeasurement> measurements = null;    try {                synchronized (messageDistributor) {            measurements = messageDistributor.flushExpired();            emitMeasurements(measurements);        }    } catch (Throwable t) {                            }    }
private void metron_f953_1(Tuple input)
{        JSONObject message = getField(MESSAGE_TUPLE_FIELD, input, JSONObject.class);    ProfileConfig definition = getField(PROFILE_TUPLE_FIELD, input, ProfileConfig.class);    String entity = getField(ENTITY_TUPLE_FIELD, input, String.class);    Long timestamp = getField(TIMESTAMP_TUPLE_FIELD, input, Long.class);        activeFlushSignal.update(timestamp);        MessageRoute route = new MessageRoute(definition, entity, message, timestamp);    synchronized (messageDistributor) {        messageDistributor.distribute(route, getStellarContext());    }    }
private T metron_f955_0(String fieldName, Tuple tuple, Class<T> clazz)
{    T value = ConversionUtils.convert(tuple.getValueByField(fieldName), clazz);    if (value == null) {        throw new IllegalStateException(format("Invalid tuple: missing or invalid field '%s'", fieldName));    }    return value;}
private void metron_f956_0()
{    long initialDelay = profileTimeToLiveMillis;    long period = profileTimeToLiveMillis;    flushExpiredExecutor = Executors.newSingleThreadScheduledExecutor();    flushExpiredExecutor.scheduleAtFixedRate(() -> flushExpired(), initialDelay, period, TimeUnit.MILLISECONDS);}
public BaseWindowedBolt metron_f957_0(BaseWindowedBolt.Duration duration)
{        this.windowDurationMillis = duration.value;    return super.withTumblingWindow(duration);}
public long metron_f958_0()
{    return periodDurationMillis;}
public ProfileBuilderBolt metron_f959_0(long periodDurationMillis)
{    this.periodDurationMillis = periodDurationMillis;    return this;}
public ProfileBuilderBolt metron_f960_0(int duration, TimeUnit units)
{    return withPeriodDurationMillis(units.toMillis(duration));}
public ProfileBuilderBolt metron_f961_0(long timeToLiveMillis)
{    this.profileTimeToLiveMillis = timeToLiveMillis;    return this;}
public long metron_f962_0()
{    return windowDurationMillis;}
public ProfileBuilderBolt metron_f963_0(int duration, TimeUnit units)
{    return withProfileTimeToLiveMillis(units.toMillis(duration));}
public ProfileBuilderBolt metron_f964_0(ProfileMeasurementEmitter emitter)
{    this.emitters.add(emitter);    return this;}
public MessageDistributor metron_f965_0()
{    return messageDistributor;}
public ProfileBuilderBolt metron_f966_0(String zookeeperUrl)
{    this.zookeeperUrl = zookeeperUrl;    return this;}
public ProfileBuilderBolt metron_f967_0(CuratorFramework zookeeperClient)
{    this.zookeeperClient = zookeeperClient;    return this;}
public ProfileBuilderBolt metron_f968_0(ZKCache zookeeperCache)
{    this.zookeeperCache = zookeeperCache;    return this;}
public ProfileBuilderBolt metron_f969_0(ProfilerConfigurations configurations)
{    this.configurations = configurations;    return this;}
public ProfileBuilderBolt metron_f970_0(long maxNumberOfRoutes)
{    this.maxNumberOfRoutes = maxNumberOfRoutes;    return this;}
public ProfileBuilderBolt metron_f971_0(FlushSignal flushSignal)
{    this.activeFlushSignal = flushSignal;    return this;}
public ProfileBuilderBolt metron_f972_0(MessageDistributor messageDistributor)
{    this.messageDistributor = messageDistributor;    return this;}
public byte[] metron_f973_0(Tuple tuple)
{    ProfileMeasurement measurement = (ProfileMeasurement) tuple.getValueByField("measurement");    return rowKeyBuilder.rowKey(measurement);}
public ColumnList metron_f974_0(Tuple tuple)
{    ProfileMeasurement measurement = (ProfileMeasurement) tuple.getValueByField("measurement");    return columnBuilder.columns(measurement);}
public Optional<Long> metron_f975_0(Tuple tuple)
{    Optional<Long> expiresMillis = Optional.empty();    ProfileMeasurement measurement = (ProfileMeasurement) tuple.getValueByField("measurement");    ProfileConfig profileConfig = measurement.getDefinition();    if (profileConfig.getExpires() != null) {                long expiresDays = profileConfig.getExpires();        expiresMillis = Optional.of(TimeUnit.DAYS.toMillis(expiresDays));    }    return expiresMillis;}
public void metron_f976_0(RowKeyBuilder rowKeyBuilder)
{    this.rowKeyBuilder = rowKeyBuilder;}
public void metron_f977_0(ColumnBuilder columnBuilder)
{    this.columnBuilder = columnBuilder;}
public void metron_f978_0(Map stormConf, TopologyContext context, OutputCollector collector)
{    super.prepare(stormConf, context, collector);    this.collector = collector;    this.parser = new JSONParser();    this.router = new DefaultMessageRouter(getStellarContext());}
public Context metron_f979_0()
{    Map<String, Object> global = getConfigurations().getGlobalConfig();    return new Context.Builder().with(Context.Capabilities.ZOOKEEPER_CLIENT, () -> client).with(Context.Capabilities.GLOBAL_CONFIG, () -> global).with(Context.Capabilities.STELLAR_CONFIG, () -> global).build();}
private void metron_f981_1(Tuple input) throws ParseException, UnsupportedEncodingException
{        byte[] data = input.getBinaryByField(VALUE.getFieldName());    if (data == null) {                return;    }        ProfilerConfig config = getProfilerConfig();    if (config == null || getProfilerConfig().getProfiles().size() == 0) {                return;    }    JSONObject message = (JSONObject) parser.parse(new String(data, StandardCharsets.UTF_8));    routeMessage(input, message, config);}
public void metron_f983_0(OutputFieldsDeclarer declarer)
{        Fields fields = new Fields(MESSAGE_TUPLE_FIELD, TIMESTAMP_TUPLE_FIELD, ENTITY_TUPLE_FIELD, PROFILE_TUPLE_FIELD);    declarer.declare(fields);}
private Values metron_f984_0(MessageRoute route)
{        return new Values(route.getMessage(), route.getTimestamp(), route.getEntity(), route.getProfileDefinition());}
protected MessageRouter metron_f985_0()
{    return router;}
public void metron_f986_0(MessageRouter router)
{    this.router = router;}
public void metron_f987_0() throws Exception
{        widget1 = new Widget("widget1", 100);    when(tuple1.getValueByField(eq("widget"))).thenReturn(widget1);        widget2 = new Widget("widget2", 200);    when(tuple2.getValueByField(eq("widget"))).thenReturn(widget2);}
public void metron_f988_0() throws Exception
{    tuple1 = mock(Tuple.class);    tuple2 = mock(Tuple.class);    client = mock(HBaseClient.class);    provider = mock(TableProvider.class);}
private HBaseBolt metron_f989_0(int batchSize, WidgetMapper mapper) throws IOException
{    HBaseBolt bolt = new HBaseBolt(tableName, mapper).withBatchSize(batchSize).withTableProviderInstance(provider);    bolt.prepare(Collections.emptyMap(), topologyContext, outputCollector);    bolt.setClient(client);    return bolt;}
public void metron_f990_0() throws Exception
{    HBaseBolt bolt = createBolt(2, new WidgetMapper());    bolt.execute(tuple1);    bolt.execute(tuple2);        verify(client, times(2)).addMutation(any(), any(), any());    verify(client, times(1)).mutate();}
public void metron_f991_0() throws Exception
{    HBaseBolt bolt = createBolt(2, new WidgetMapper());    bolt.execute(tuple1);        verify(client, times(1)).addMutation(any(), any(), any());    verify(client, times(0)).mutate();}
public void metron_f992_0() throws Exception
{    HBaseBolt bolt = createBolt(2, new WidgetMapper());        bolt.execute(tuple1);    verify(client, times(1)).addMutation(any(), any(), any());    verify(client, times(0)).mutate();        bolt.execute(mockTickTuple());    verify(client, times(1)).mutate();}
public void metron_f993_0() throws Exception
{        final Long expectedTTL = 2000L;    WidgetMapper mapperWithTTL = new WidgetMapper(expectedTTL);        HBaseBolt bolt = createBolt(2, mapperWithTTL);    bolt.execute(tuple1);    bolt.execute(tuple2);        ArgumentCaptor<Long> ttlCaptor = ArgumentCaptor.forClass(Long.class);        verify(client, times(2)).addMutation(any(), any(), any(), ttlCaptor.capture());    Assert.assertEquals(expectedTTL, ttlCaptor.getValue());}
private static Tuple metron_f994_0(String componentId, String streamId)
{    Tuple tuple = mock(Tuple.class);    when(tuple.getSourceComponent()).thenReturn(componentId);    when(tuple.getSourceStreamId()).thenReturn(streamId);    return tuple;}
private static Tuple metron_f995_0()
{    return mockTuple(Constants.SYSTEM_COMPONENT_ID, Constants.SYSTEM_TICK_STREAM_ID);}
public String metron_f996_0()
{    return name;}
public void metron_f997_0(String name)
{    this.name = name;}
public int metron_f998_0()
{    return cost;}
public void metron_f999_0(int cost)
{    this.cost = cost;}
public boolean metron_f1000_0(Object o)
{    if (this == o)        return true;    if (o == null || getClass() != o.getClass())        return false;    Widget widget = (Widget) o;    if (cost != widget.cost)        return false;    return name != null ? name.equals(widget.name) : widget.name == null;}
public int metron_f1001_0()
{    int result = name != null ? name.hashCode() : 0;    result = 31 * result + cost;    return result;}
public String metron_f1002_0()
{    return "Widget{" + "name='" + name + '\'' + ", cost=" + cost + '}';}
public byte[] metron_f1003_0(Tuple tuple)
{    Widget w = (Widget) tuple.getValueByField("widget");    return Bytes.toBytes(w.getName());}
public ColumnList metron_f1004_0(Tuple tuple)
{    Widget w = (Widget) tuple.getValueByField("widget");    ColumnList cols = new ColumnList();    cols.addColumn(CF, QNAME, Bytes.toBytes(w.getName()));    cols.addColumn(CF, QCOST, Bytes.toBytes(w.getCost()));    return cols;}
public Optional<Long> metron_f1005_0(Tuple tuple)
{    return ttl;}
public void metron_f1006_0()
{    int flushFreq = 1000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        assertFalse(signal.isTimeToFlush());        signal.update(5000);    assertFalse(signal.isTimeToFlush());        signal.update(7000);    assertTrue(signal.isTimeToFlush());}
public void metron_f1007_0()
{    int flushFreq = 5000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        signal.update(5000);    assertFalse(signal.isTimeToFlush());        signal.update(1000);    assertFalse(signal.isTimeToFlush());        signal.update(7000);    assertTrue(signal.isTimeToFlush());        signal.update(3000);    assertTrue(signal.isTimeToFlush());        assertTrue(signal.isTimeToFlush());}
public void metron_f1008_0()
{    int flushFreq = 7000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        signal.update(5000);    assertFalse(signal.isTimeToFlush());        signal.update(1000);    assertFalse(signal.isTimeToFlush());        signal.update(7000);    assertFalse(signal.isTimeToFlush());        signal.update(3000);    assertFalse(signal.isTimeToFlush());}
public void metron_f1009_0()
{    int flushFreq = 3000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        signal.update(4100);    assertFalse(signal.isTimeToFlush());        signal.update(3000);    assertFalse(signal.isTimeToFlush());        signal.update(2000);    assertFalse(signal.isTimeToFlush());        signal.update(1000);    assertTrue(signal.isTimeToFlush());}
public void metron_f1010_0()
{    int flushFreq = 4000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        signal.update(4000);    assertFalse(signal.isTimeToFlush());        signal.update(3000);    assertFalse(signal.isTimeToFlush());        signal.update(2000);    assertFalse(signal.isTimeToFlush());        signal.update(1000);    assertFalse(signal.isTimeToFlush());}
public void metron_f1011_0()
{    int flushFreq = 3000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        signal.update(1000);    assertFalse(signal.isTimeToFlush());        signal.update(2000);    assertFalse(signal.isTimeToFlush());        signal.update(3000);    assertFalse(signal.isTimeToFlush());        signal.update(4000);}
public void metron_f1012_0()
{    int flushFreq = 4000;    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(flushFreq);        signal.update(1000);    assertFalse(signal.isTimeToFlush());        signal.update(2000);    assertFalse(signal.isTimeToFlush());        signal.update(3000);    assertFalse(signal.isTimeToFlush());        signal.update(4000);    assertFalse(signal.isTimeToFlush());}
public void metron_f1013_0()
{        new FixedFrequencyFlushSignal(-1000);}
public void metron_f1014_0()
{    FixedFrequencyFlushSignal signal = new FixedFrequencyFlushSignal(4000);    signal.update(1000);    signal.update(6000);        assertTrue(signal.isTimeToFlush());        signal.reset();    assertFalse(signal.isTimeToFlush());}
public void metron_f1015_0() throws Exception
{    emitter = new HBaseEmitter();    profile = createDefinition(profileDefinition);    collector = Mockito.mock(OutputCollector.class);}
public void metron_f1016_0() throws Exception
{        ProfileMeasurement measurement = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withDefinition(profile).withProfileValue(22);        emitter.emit(measurement, collector);        ProfileMeasurement actual = expectMeasurement(emitter, collector);    assertEquals(measurement, actual);}
private ProfileMeasurement metron_f1017_0(HBaseEmitter hbaseEmitter, OutputCollector collector)
{    ArgumentCaptor<Values> arg = ArgumentCaptor.forClass(Values.class);    verify(collector, times(1)).emit(eq(hbaseEmitter.getStreamId()), arg.capture());    Values values = arg.getValue();    assertTrue(values.get(0) instanceof ProfileMeasurement);    return (ProfileMeasurement) values.get(0);}
private ProfileConfig metron_f1018_0(String json) throws IOException
{    return JSONUtils.INSTANCE.load(json, ProfileConfig.class);}
public void metron_f1019_0() throws UnableToStartException
{    try {        upload();    } catch (Exception e) {        throw new UnableToStartException(e.getMessage(), e);    }}
public void metron_f1021_0() throws UnableToStartException
{    try {        upload();    } catch (Exception e) {        throw new UnableToStartException(e.getMessage(), e);    }}
private void metron_f1022_0() throws Exception
{    final String zookeeperUrl = topologyProperties.getProperty(ZKServerComponent.ZOOKEEPER_PROPERTY);    try (CuratorFramework client = getClient(zookeeperUrl)) {        if (client.getState() != CuratorFrameworkState.STARTED) {            client.start();        }        uploadGlobalConfig(client);        uploadProfilerConfig(client);    }}
private void metron_f1023_0(CuratorFramework client) throws Exception
{    byte[] configBytes = null;    if (profilerConfigurationPath != null) {        configBytes = readProfilerConfigFromFile(profilerConfigurationPath);    } else if (profilerConfig != null) {        configBytes = profilerConfig.toJSON().getBytes(StandardCharsets.UTF_8);    }    if (ArrayUtils.getLength(configBytes) > 0) {        writeProfilerConfigToZookeeper(configBytes, client);    }}
private void metron_f1024_0(CuratorFramework client) throws Exception
{    if (globalConfiguration != null) {        byte[] globalConfig = readGlobalConfigFromFile(globalConfiguration);        if (globalConfig.length > 0) {            writeGlobalConfigToZookeeper(readGlobalConfigFromFile(globalConfiguration), client);        }    }}
public ConfigUploadComponent metron_f1025_0(Properties topologyProperties)
{    this.topologyProperties = topologyProperties;    return this;}
public ConfigUploadComponent metron_f1026_0(String path)
{    this.globalConfiguration = path;    return this;}
public ConfigUploadComponent metron_f1027_0(String path)
{    this.profilerConfigurationPath = path;    return this;}
public ConfigUploadComponent metron_f1028_0(ProfilerConfig profilerConfig)
{    this.profilerConfig = profilerConfig;    return this;}
public MessageBuilder metron_f1029_0(JSONObject prototype)
{    prototype.forEach((key, val) -> this.fields.put(key, val));    return this;}
public MessageBuilder metron_f1030_0(String key, Object value)
{    this.fields.put(key, value);    return this;}
public JSONObject metron_f1031_0()
{    return new JSONObject(fields);}
public void metron_f1032_1() throws Exception
{    uploadConfigToZookeeper(ProfilerConfig.fromJSON(processingTimeProfile));        fluxComponent.submitTopology();    kafkaComponent.writeMessages(inputTopic, message1);    kafkaComponent.writeMessages(inputTopic, message2);    kafkaComponent.writeMessages(inputTopic, message3);        String profileGetExpression = "PROFILE_GET('processing-time-test', '10.0.0.1', PROFILE_FIXED('15', 'MINUTES'))";    List<Integer> measurements = execute(profileGetExpression, List.class);        int attempt = 0;    while (measurements.size() == 0 && attempt++ < 10) {                long sleep = windowDurationMillis;                Thread.sleep(sleep);                                kafkaComponent.writeMessages(inputTopic, message2);                measurements = execute(profileGetExpression, List.class);    }            assertTrue(measurements.size() > 0);            assertTrue(measurements.get(0) >= 3);}
public void metron_f1033_1() throws Exception
{    uploadConfigToZookeeper(ProfilerConfig.fromJSON(processingTimeProfile));        fluxComponent.submitTopology();    kafkaComponent.writeMessages(inputTopic, message1);    kafkaComponent.writeMessages(inputTopic, message2);    kafkaComponent.writeMessages(inputTopic, message3);            long sleep = windowLagMillis + periodDurationMillis;        Thread.sleep(sleep);    kafkaComponent.writeMessages(inputTopic, message3);        assertEventually(() -> {        List<Integer> results = execute("PROFILE_GET('processing-time-test', '10.0.0.1', PROFILE_FIXED('15', 'MINUTES'))", List.class);        assertThat(results, hasItem(3));    }, timeout);}
public void metron_f1034_1() throws Exception
{    uploadConfigToZookeeper(ProfilerConfig.fromJSON(eventTimeProfile));        fluxComponent.submitTopology();    List<String> messages = FileUtils.readLines(new File("src/test/resources/telemetry.json"));    kafkaComponent.writeMessages(inputTopic, messages);    long timestamp = System.currentTimeMillis();        kafkaComponent.writeMessages(inputTopic, getMessage("192.168.66.1", timestamp));    kafkaComponent.writeMessages(inputTopic, getMessage("192.168.138.158", timestamp));        assign("maxTimestamp", "1530978728982L");    assign("window", "PROFILE_WINDOW('from 5 hours ago', maxTimestamp)");                    assertEventually(() -> {        List<Integer> results = execute("PROFILE_GET('count-by-ip', '192.168.66.1', window)", List.class);        assertThat(results, hasItems(14, 12));    }, timeout);        assertEventually(() -> {        List<Integer> results = execute("PROFILE_GET('count-by-ip', '192.168.138.158', window)", List.class);        assertThat(results, hasItems(36, 38));    }, timeout);        assertEventually(() -> {        List<Integer> results = execute("PROFILE_GET('total-count', 'total', window)", List.class);        assertThat(results, hasItems(50, 50));    }, timeout);}
public void metron_f1035_0() throws Exception
{    uploadConfigToZookeeper(ProfilerConfig.fromJSON(profileWithStats));        fluxComponent.submitTopology();    List<String> messages = FileUtils.readLines(new File("src/test/resources/telemetry.json"));    kafkaComponent.writeMessages(inputTopic, messages);    assertEventually(() -> {                        assign("maxTimestamp", "1530978728982L");        assign("window", "PROFILE_WINDOW('from 5 hours ago', maxTimestamp)");                List results = execute("PROFILE_GET('profile-with-stats', 'global', window)", List.class);        assertTrue(results.size() > 0);        assertTrue(results.get(0) instanceof OnlineStatisticsProvider);    }, timeout);}
public void metron_f1036_0() throws Exception
{    uploadConfigToZookeeper(ProfilerConfig.fromJSON(profileWithTriageResult));        fluxComponent.submitTopology();    List<String> telemetry = FileUtils.readLines(new File("src/test/resources/telemetry.json"));    kafkaComponent.writeMessages(inputTopic, telemetry);        assertEventually(() -> {        outputMessages = kafkaComponent.readMessages(outputTopic);        assertEquals(1, outputMessages.size());    }, timeout);        JSONObject message = (JSONObject) new JSONParser().parse(new String(outputMessages.get(0), StandardCharsets.UTF_8));    assertEquals("profile-with-triage", message.get(PROFILE_FIELD));    assertEquals("global", message.get(ENTITY_FIELD));    assertEquals(76548935L, message.get(PERIOD_ID_FIELD));    assertEquals(1530978700000L, message.get(PERIOD_START_FIELD));    assertEquals(1530978720000L, message.get(PERIOD_END_FIELD));    assertEquals("profiler", message.get(Constants.SENSOR_TYPE));    assertEquals("true", message.get(ALERT_FIELD));    assertEquals(1.0, message.get("min"));    assertEquals(1.0, message.get("max"));    assertEquals(1.0, message.get("mean"));    assertTrue(message.containsKey(TIMESTAMP_FIELD));    assertTrue(message.containsKey(Constants.GUID));}
private static String metron_f1037_0(String ipSource, long timestamp)
{    return new MessageBuilder().withField("ip_src_addr", ipSource).withField("timestamp", timestamp).build().toJSONString();}
public static void metron_f1038_0() throws UnableToStartException
{        message1 = getMessage(entity, startAt);    message2 = getMessage(entity, startAt + 100);    message3 = getMessage(entity, startAt + (windowDurationMillis * 2));        final Properties topologyProperties = new Properties() {        {                        setProperty("profiler.workers", "1");            setProperty("profiler.executors", "0");            setProperty(Config.TOPOLOGY_AUTO_CREDENTIALS, "[]");            setProperty(Config.TOPOLOGY_MESSAGE_TIMEOUT_SECS, "60");            setProperty(Config.TOPOLOGY_MAX_SPOUT_PENDING, "100000");                                    setProperty(Config.TOPOLOGY_TESTING_ALWAYS_TRY_SERIALIZE, "true");            setProperty(Config.TOPOLOGY_FALL_BACK_ON_JAVA_SERIALIZATION, "false");            setProperty(Config.TOPOLOGY_KRYO_REGISTER, kryoSerializers);                        setProperty("profiler.input.topic", inputTopic);            setProperty("profiler.output.topic", outputTopic);            setProperty("kafka.start", "EARLIEST");            setProperty("kafka.security.protocol", "PLAINTEXT");                        setProperty("profiler.hbase.salt.divisor", Integer.toString(saltDivisor));            setProperty("profiler.hbase.table", tableName);            setProperty("profiler.hbase.column.family", columnFamily);            setProperty("profiler.hbase.batch", "10");            setProperty("profiler.hbase.flush.interval.seconds", "1");            setProperty("hbase.provider.impl", "" + MockHBaseTableProvider.class.getName());                        setProperty("profiler.period.duration", Long.toString(periodDurationMillis));            setProperty("profiler.period.duration.units", "MILLISECONDS");            setProperty("profiler.ttl", Long.toString(profileTimeToLiveMillis));            setProperty("profiler.ttl.units", "MILLISECONDS");            setProperty("profiler.window.duration", Long.toString(windowDurationMillis));            setProperty("profiler.window.duration.units", "MILLISECONDS");            setProperty("profiler.window.lag", Long.toString(windowLagMillis));            setProperty("profiler.window.lag.units", "MILLISECONDS");            setProperty("profiler.max.routes.per.bolt", Long.toString(maxRoutesPerBolt));        }    };        profilerTable = (MockHTable) MockHBaseTableProvider.addToCache(tableName, columnFamily);    zkComponent = getZKServerComponent(topologyProperties);        kafkaComponent = getKafkaComponent(topologyProperties, Arrays.asList(new KafkaComponent.Topic(inputTopic, 1), new KafkaComponent.Topic(outputTopic, 1)));        configUploadComponent = new ConfigUploadComponent().withTopologyProperties(topologyProperties);        fluxComponent = new FluxTopologyComponent.Builder().withTopologyLocation(new File(FLUX_PATH)).withTopologyName("profiler").withTopologyProperties(topologyProperties).build();        runner = new ComponentRunner.Builder().withComponent("zk", zkComponent).withComponent("kafka", kafkaComponent).withComponent("config", configUploadComponent).withComponent("storm", fluxComponent).withMillisecondsBetweenAttempts(15000).withNumRetries(10).withCustomShutdownOrder(new String[] { "storm", "config", "kafka", "zk" }).build();    runner.start();}
public static void metron_f1039_0() throws Exception
{    MockHBaseTableProvider.clear();    if (runner != null) {        runner.stop();    }}
public void metron_f1040_0()
{        profilerTable = (MockHTable) MockHBaseTableProvider.addToCache(tableName, columnFamily);        Map<String, Object> global = new HashMap<String, Object>() {        {            put(PROFILER_HBASE_TABLE.getKey(), tableName);            put(PROFILER_COLUMN_FAMILY.getKey(), columnFamily);            put(PROFILER_HBASE_TABLE_PROVIDER.getKey(), MockHBaseTableProvider.class.getName());                        put(PROFILER_PERIOD.getKey(), Long.toString(periodDurationMillis));            put(PROFILER_PERIOD_UNITS.getKey(), "MILLISECONDS");                        put(PROFILER_SALT_DIVISOR.getKey(), saltDivisor);        }    };        executor = new DefaultStellarStatefulExecutor(new SimpleFunctionResolver().withClass(GetProfile.class).withClass(FixedLookback.class).withClass(WindowLookback.class), new Context.Builder().with(Context.Capabilities.GLOBAL_CONFIG, () -> global).build());}
public void metron_f1041_0() throws Exception
{    MockHBaseTableProvider.clear();    profilerTable.clear();    if (runner != null) {        runner.reset();    }}
public void metron_f1042_0(ProfilerConfig profilerConfig) throws Exception
{    configUploadComponent.withProfilerConfiguration(profilerConfig).update();}
private void metron_f1043_0(String var, String expression)
{    executor.assign(var, expression, Collections.emptyMap());}
private T metron_f1044_1(String expression, Class<T> clazz)
{    T results = executor.execute(expression, Collections.emptyMap(), clazz);        return results;}
public void metron_f1045_0() throws Exception
{    kafkaEmitter = new KafkaEmitter();    profile = createDefinition(profileDefinitionWithTriage);    collector = Mockito.mock(OutputCollector.class);}
public void metron_f1046_0() throws Exception
{        ProfileMeasurement measurement = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withDefinition(profile).withTriageValues(Collections.singletonMap("triage-key", "triage-value"));        kafkaEmitter.emit(measurement, collector);        verify(collector, times(1)).emit(eq(kafkaEmitter.getStreamId()), any());}
public void metron_f1047_0() throws Exception
{        ProfileMeasurement measurement = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withDefinition(profile);        kafkaEmitter.emit(measurement, collector);        verify(collector, times(0)).emit(eq(kafkaEmitter.getStreamId()), any());}
public void metron_f1048_0() throws Exception
{        ProfileMeasurement measurement = new ProfileMeasurement().withDefinition(profile).withProfileName(profile.getProfile()).withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withTriageValues(Collections.singletonMap("triage-key", "triage-value"));        kafkaEmitter.emit(measurement, collector);    JSONObject actual = expectJsonObject(kafkaEmitter, collector);        assertEquals(measurement.getProfileName(), actual.get("profile"));    assertEquals(measurement.getEntity(), actual.get("entity"));    assertEquals(measurement.getPeriod().getPeriod(), actual.get("period"));    assertEquals(measurement.getPeriod().getStartTimeMillis(), actual.get("period.start"));    assertEquals(measurement.getPeriod().getEndTimeMillis(), actual.get("period.end"));    assertEquals("profiler", actual.get("source.type"));    assertNotNull(actual.get("timestamp"));    assertNotNull(actual.get(Constants.GUID));        assertEquals(measurement.getTriageValues().get("triage-key"), actual.get("triage-key"));}
public void metron_f1049_0() throws Exception
{        Map<String, Object> triageValues = ImmutableMap.of("x", 2, "y", "4", "z", 6.0);        ProfileMeasurement measurement = new ProfileMeasurement().withDefinition(profile).withProfileName(profile.getProfile()).withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withTriageValues(triageValues);        kafkaEmitter.emit(measurement, collector);    JSONObject actual = expectJsonObject(kafkaEmitter, collector);        assertEquals(measurement.getTriageValues().get("x"), actual.get("x"));    assertEquals(measurement.getTriageValues().get("y"), actual.get("y"));    assertEquals(measurement.getTriageValues().get("z"), actual.get("z"));}
public void metron_f1050_0() throws Exception
{        Map<String, Object> triageValues = ImmutableMap.of("invalid", new OnlineStatisticsProvider(), "valid", 4);        ProfileMeasurement measurement = new ProfileMeasurement().withDefinition(profile).withProfileName(profile.getProfile()).withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withTriageValues(triageValues);        kafkaEmitter.emit(measurement, collector);    JSONObject actual = expectJsonObject(kafkaEmitter, collector);        assertEquals(measurement.getProfileName(), actual.get("profile"));    assertEquals(measurement.getEntity(), actual.get("entity"));    assertEquals(measurement.getPeriod().getPeriod(), actual.get("period"));    assertEquals(measurement.getPeriod().getStartTimeMillis(), actual.get("period.start"));    assertEquals(measurement.getPeriod().getEndTimeMillis(), actual.get("period.end"));    assertEquals("profiler", actual.get("source.type"));    assertNotNull(actual.get("timestamp"));    assertNotNull(actual.get(Constants.GUID));        assertFalse(actual.containsKey("invalid"));        assertEquals(triageValues.get("valid"), actual.get("valid"));}
public void metron_f1051_0() throws Exception
{        ProfileMeasurement measurement = new ProfileMeasurement().withDefinition(profile).withProfileName(profile.getProfile()).withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withTriageValues(Collections.singletonMap("triage-key", 123));        kafkaEmitter.emit(measurement, collector);    JSONObject actual = expectJsonObject(kafkaEmitter, collector);        assertEquals(measurement.getTriageValues().get("triage-key"), actual.get("triage-key"));}
public void metron_f1052_0() throws Exception
{        ProfileMeasurement measurement = new ProfileMeasurement().withDefinition(profile).withProfileName(profile.getProfile()).withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withTriageValues(Collections.singletonMap("triage-key", "value"));        kafkaEmitter.emit(measurement, collector);    JSONObject actual = expectJsonObject(kafkaEmitter, collector);        assertEquals(measurement.getTriageValues().get("triage-key"), actual.get("triage-key"));}
private JSONObject metron_f1053_0(KafkaEmitter kafkaEmitter, OutputCollector collector)
{    ArgumentCaptor<Values> arg = ArgumentCaptor.forClass(Values.class);    verify(collector, times(1)).emit(eq(kafkaEmitter.getStreamId()), arg.capture());    Values values = arg.getValue();    assertTrue(values.get(0) instanceof JSONObject);    return (JSONObject) values.get(0);}
private ProfileConfig metron_f1054_0(String json) throws IOException
{    return JSONUtils.INSTANCE.load(json, ProfileConfig.class);}
public void metron_f1055_0() throws Exception
{    message1 = new MessageBuilder().withField("ip_src_addr", "10.0.0.1").withField("value", "22").build();    message2 = new MessageBuilder().withField("ip_src_addr", "10.0.0.2").withField("value", "22").build();    profile1 = new ProfileConfig().withProfile("profile1").withForeach("ip_src_addr").withInit("x", "0").withUpdate("x", "x + 1").withResult("x");    profile2 = new ProfileConfig().withProfile("profile2").withForeach("ip_src_addr").withInit(Collections.singletonMap("x", "0")).withUpdate(Collections.singletonMap("x", "x + 1")).withResult("x");    measurement = new ProfileMeasurement().withEntity("entity1").withProfileName("profile1").withPeriod(1000, 500, TimeUnit.MILLISECONDS).withProfileValue(22);    flushSignal = new ManualFlushSignal();    flushSignal.setFlushNow(false);}
public void metron_f1056_0() throws Exception
{    ProfileBuilderBolt bolt = createBolt();        MessageDistributor distributor = mock(MessageDistributor.class);    bolt.withMessageDistributor(distributor);        final long timestamp1 = 100000000L;    Tuple tuple1 = createTuple("entity1", message1, profile1, timestamp1);        TupleWindow tupleWindow = createWindow(tuple1);    bolt.execute(tupleWindow);        verify(distributor).distribute(any(MessageRoute.class), any());}
public void metron_f1057_0() throws Exception
{    ProfileBuilderBolt bolt = createBolt();        MessageDistributor distributor = mock(MessageDistributor.class);    when(distributor.flush()).thenReturn(Collections.singletonList(measurement));    bolt.withMessageDistributor(distributor);        flushSignal.setFlushNow(true);        Tuple tuple1 = createTuple("entity1", message1, profile1, 1000L);    TupleWindow tupleWindow = createWindow(tuple1);    bolt.execute(tupleWindow);        List<ProfileMeasurement> measurements = getProfileMeasurements(outputCollector, 1);    assertEquals(1, measurements.size());    assertEquals(measurement, measurements.get(0));}
public void metron_f1058_0() throws Exception
{    ProfileBuilderBolt bolt = createBolt();        MessageDistributor distributor = mock(MessageDistributor.class);    when(distributor.flush()).thenReturn(Collections.singletonList(measurement));    bolt.withMessageDistributor(distributor);        flushSignal.setFlushNow(false);        Tuple tuple1 = createTuple("entity1", message1, profile1, 1000L);    TupleWindow tupleWindow = createWindow(tuple1);    bolt.execute(tupleWindow);        getProfileMeasurements(outputCollector, 0);}
public void metron_f1059_0() throws Exception
{    ProfileBuilderBolt bolt = createBolt();        MessageDistributor distributor = mock(MessageDistributor.class);    when(distributor.flushExpired()).thenReturn(Collections.singletonList(measurement));    bolt.withMessageDistributor(distributor);        bolt.flushExpired();        List<ProfileMeasurement> measurements = getProfileMeasurements(outputCollector, 1);    assertEquals(1, measurements.size());    assertEquals(measurement, measurements.get(0));}
public void metron_f1060_0() throws Exception
{        ProfilerConfigurations configurations = new ProfilerConfigurations();    configurations.updateGlobalConfig(Collections.emptyMap());        ProfileBuilderBolt bolt = (ProfileBuilderBolt) new ProfileBuilderBolt().withProfileTimeToLive(30, TimeUnit.MINUTES).withPeriodDuration(10, TimeUnit.MINUTES).withMaxNumberOfRoutes(Long.MAX_VALUE).withZookeeperClient(client).withZookeeperCache(cache).withEmitter(new TestEmitter("destination1")).withEmitter(new TestEmitter("destination2")).withEmitter(new TestEmitter("destination3")).withProfilerConfigurations(configurations).withTumblingWindow(new BaseWindowedBolt.Duration(10, TimeUnit.MINUTES));    bolt.prepare(new HashMap<>(), topologyContext, outputCollector);        bolt.withFlushSignal(flushSignal);    flushSignal.setFlushNow(true);        Tuple tuple1 = createTuple("entity", message1, profile1, System.currentTimeMillis());    TupleWindow window = createWindow(tuple1);    bolt.execute(window);        verify(outputCollector, times(1)).emit(eq("destination1"), any());    verify(outputCollector, times(1)).emit(eq("destination2"), any());    verify(outputCollector, times(1)).emit(eq("destination3"), any());}
public void metron_f1061_0() throws Exception
{        ProfileMeasurementEmitter badEmitter = mock(ProfileMeasurementEmitter.class);    doThrow(new RuntimeException("flushExpired() should catch this exception")).when(badEmitter).emit(any(), any());        MessageDistributor distributor = mock(MessageDistributor.class);    when(distributor.flushExpired()).thenReturn(Collections.singletonList(measurement));        ProfileBuilderBolt bolt = (ProfileBuilderBolt) new ProfileBuilderBolt().withEmitter(badEmitter).withMessageDistributor(distributor);        bolt.flushExpired();}
private List<ProfileMeasurement> metron_f1062_0(OutputCollector collector, int expected)
{        final String streamId = emitter.getStreamId();        ArgumentCaptor<Values> argCaptor = ArgumentCaptor.forClass(Values.class);    verify(collector, times(expected)).emit(eq(streamId), argCaptor.capture());        return argCaptor.getAllValues().stream().map(val -> (ProfileMeasurement) val.get(0)).collect(Collectors.toList());}
private Tuple metron_f1063_0(String entity, JSONObject message, ProfileConfig profile, long timestamp)
{    Tuple tuple = mock(Tuple.class);    when(tuple.getValueByField(eq(ProfileSplitterBolt.MESSAGE_TUPLE_FIELD))).thenReturn(message);    when(tuple.getValueByField(eq(ProfileSplitterBolt.TIMESTAMP_TUPLE_FIELD))).thenReturn(timestamp);    when(tuple.getValueByField(eq(ProfileSplitterBolt.ENTITY_TUPLE_FIELD))).thenReturn(entity);    when(tuple.getValueByField(eq(ProfileSplitterBolt.PROFILE_TUPLE_FIELD))).thenReturn(profile);    return tuple;}
private ProfileBuilderBolt metron_f1064_0() throws IOException
{        ProfilerConfigurations configurations = new ProfilerConfigurations();    configurations.updateGlobalConfig(Collections.emptyMap());    emitter = new HBaseEmitter();    ProfileBuilderBolt bolt = (ProfileBuilderBolt) new ProfileBuilderBolt().withProfileTimeToLive(30, TimeUnit.MINUTES).withMaxNumberOfRoutes(Long.MAX_VALUE).withZookeeperClient(client).withZookeeperCache(cache).withEmitter(emitter).withProfilerConfigurations(configurations).withPeriodDuration(1, TimeUnit.MINUTES).withTumblingWindow(new BaseWindowedBolt.Duration(30, TimeUnit.SECONDS));    bolt.prepare(new HashMap<>(), topologyContext, outputCollector);        bolt.withFlushSignal(flushSignal);    return bolt;}
private TupleWindow metron_f1065_0(Tuple... tuples)
{    TupleWindow window = mock(TupleWindow.class);    when(window.get()).thenReturn(Arrays.asList(tuples));    return window;}
public String metron_f1066_0()
{    return streamId;}
public void metron_f1067_0(OutputFieldsDeclarer declarer)
{    declarer.declareStream(getStreamId(), new Fields("measurement"));}
public void metron_f1068_0(ProfileMeasurement measurement, OutputCollector collector)
{    collector.emit(getStreamId(), new Values(measurement));}
public void metron_f1069_0()
{    rowKeyBuilder = mock(RowKeyBuilder.class);    mapper = new ProfileHBaseMapper();    mapper.setRowKeyBuilder(rowKeyBuilder);    profile = new ProfileConfig("profile", "ip_src_addr", new ProfileResult("2 + 2"));    measurement = new ProfileMeasurement().withProfileName("profile").withEntity("entity").withPeriod(20000, 15, TimeUnit.MINUTES).withProfileValue(22).withDefinition(profile);        tuple = mock(Tuple.class);    when(tuple.getValueByField(eq("measurement"))).thenReturn(measurement);}
public void metron_f1070_0() throws Exception
{    final Long expiresDays = 30L;    profile.setExpires(expiresDays);    Optional<Long> actual = mapper.getTTL(tuple);    Assert.assertTrue(actual.isPresent());    Assert.assertEquals(expiresDays, (Long) TimeUnit.MILLISECONDS.toDays(actual.get()));}
public void metron_f1071_0() throws Exception
{        Optional<Long> actual = mapper.getTTL(tuple);    Assert.assertFalse(actual.isPresent());}
