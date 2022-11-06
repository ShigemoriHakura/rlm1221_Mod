# RLM_1221_Mod
A jar package for null

## Why
* Made for fun

## After 4.2.0.0
* As they added file SHA-256 check, we have to patch the main jar
* Use jadx and other tools to locate the CEAppDef file (in 4.2.0.1 it's g.class)
* modify the checksum (using 010 editor or other tool, original checksum is 6b80a0f06acb44524d65d72edf4a097062f41edab54a53063f926d553f9647fa)
* Remove the .RSA .SF and MANIFEST.MF file in META-INF
* Move back the main jar and the rlm1221.jar
* Done~ just enjoy!

## Custom jar
* Plz get SHA-256 and convert to lower-case, and follow the instruction