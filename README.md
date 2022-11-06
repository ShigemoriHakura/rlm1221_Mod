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

## Way 2 (WTF is this way lol)
* As they added the SHA-256 check, we can also change the .bat file
* Modify the CLASS_PATH, rename the app\lib\rlm1221.jar to rlm1221_mod
* Also modify your jar file to rlm1221_mod.jar and copy that into app\lib
* Change all 4 .bat files and you are ready to go 
* LOL

## Custom jar
* Plz get SHA-256 and convert to lower-case, and follow the instruction