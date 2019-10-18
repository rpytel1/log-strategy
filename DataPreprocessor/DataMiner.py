from py4j.java_gateway import JavaGateway, GatewayParameters

if __name__ == '__main__':
    gateway = JavaGateway(gateway_parameters=GatewayParameters(port=25335))
    java_extractor = gateway.entry_point

    success = java_extractor.extractMethods("repositories", "data/")

