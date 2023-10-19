# Docx4j4Android4-vll.4.9
Android Studio docx4j sample app #in development

This app is a proof of concept of docx4j 11.4.9 running on Android.

Tested on API 31 hardware 

It is using JAXB Reference Implementation, compiled for Java 7,
with https://github.com/gf-metro/jaxb/pull/34 so things work even
though org.apache.harmony.xml.parsers.SAXParser doesn't support
http://javax.xml.XMLConstants/feature/secure-processing

Please Note the following: n/

#1 This demo app doesn't actually show anything in the Android UI. 

#2 Currently generates empty document in selected file path. 



WARNING:
Note https://github.com/plutext/Docx4j4Android4/issues/1 ; this POC uses --core-library flag


