# wco-automation-framework
a proof of concept for a test framework

# Introduction
This is a proof of concept implementation of a testing framework.
The framwoek consists of 3 main parts that are subdivided by modules and submodules.

# WCO-Domain Module
In this module its where we store all modules that represent the Subdomains interfaces together with the feature files associated to them. 
We also created a common module where we 
store all the common functionalities between the Subdomains.
Its important to say that this is where we store the attributes, Commands and Queries specific for each Domain/Subdomain, therefore,
this should be in sync with the glossary or we should be able to generate the glossary from here.

# WCO-Dummy-Client Module

In this module its where we store the concrete implementation the Subdomain and Commands and Queries interfaces.
This module will have sub modules for Browser and API implementations for the Subdomains.

# Test Framework
In this module is where we store the classes for Given, When and Then.


