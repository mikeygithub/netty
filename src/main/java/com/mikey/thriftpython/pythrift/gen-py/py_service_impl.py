# -*- coding:utf-8-*-
__author__ = "mikey"

from py.thrift.generated import ttypes

class py_person_service_impl:
    def getPersonByUsername(self, username):
        print "Got Client Params: " + username
        person = ttypes.Person()
        person.username = username
        person.age = 10
        person.married = False

        return person

    def savePerson(self, person):
        print "Got Client Params:"
        print person.username
        print person.age
        print person.married