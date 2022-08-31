#!/bin/bash

javac Main.java
cat in | java Main > out
diff out ans
