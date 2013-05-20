#!/usr/bin/env python

from suds.client import Client

import logging
import sys

logging.basicConfig(level=logging.CRITICAL)

args = sys.argv
if len(args) < 3 or len(args) % 2 != 1:
    print >> sys.stderr, "\nThis must have three fixed arguments: hostname, port and plugin mnemonic\nfollowed by pairs of arguments to represent the credentials. For example\n\n    ", args[0], "example.com 8181 db username root password guess\n"
    sys.exit(1)

hostAndPort = args[1]
plugin = args[2]

client = Client("https://" + hostAndPort + "/ICATService/ICAT?wsdl")
service = client.service
factory = client.factory

credentials = factory.create("credentials")
for i in range (3, len(args), 2):
    entry = factory.create("credentials.entry")
    entry.key = args[i]
    entry.value = args[i + 1]
    credentials.entry.append(entry)

sessionId = service.login(plugin, credentials,)
print "Logged in with", service.getRemainingMinutes(sessionId), "minutes to go"

groups = service.search(sessionId, "Group[name='annoying animals']")
if len(groups): 
    print "Groups 'annoying animals' already exist - they will be deleted"
    for group in groups:
        service.delete(sessionId, group)
        
group = factory.create("group")
group.name = "annoying animals"
service.create(sessionId, group)

groups = service.search(sessionId, "Group[name='annoying animals']")
if len(groups) != 1:
    print >> sys.stderr, "There are now", len(groups), "groups instead of 1 - something is wrong"
    sys.exit(1)
    
for group in groups:
    service.delete(sessionId, group)
    
groups = service.search(sessionId, "Group[name='annoying animals']")
if len(groups):
    print >> sys.stderr, "There are now", len(groups), "groups instead of 0 - something is wrong"
    sys.exit(1)
    
service.logout(sessionId)
    
print "Login, search, create, delete and logout operations were all successful."
