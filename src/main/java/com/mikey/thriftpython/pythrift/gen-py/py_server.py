# -*- coding:utf-8-*-
__author__ = "mikey"
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol
from py.thrift.generated import PersonService
from py_service_impl import py_person_service_impl
from thrift import Thrift
from thrift.server import TServer


try:
    personServiceHandler = py_person_service_impl()
    processor = PersonService.Processor(personServiceHandler)
    serverSocket = TSocket.TServerSocket(port=8899)
    transportFactory = TTransport.TFramedTransportFactory()
    protocolFactory = TCompactProtocol.TCompactProtocolFactory()
    server = TServer.TSimpleServer(processor, serverSocket, transportFactory, protocolFactory)
    server.serve()

except Thrift.TException, ex:
    print '%s' % ex.message