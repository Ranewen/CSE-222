JC = javac
JFLAGS = -classpath .
JD = javadoc
JDFLAGS = -protected -splitindex -use -authot -version -d ./javadoc
RM = rm
JR = java

CLASSES = \
		Inventory.java \
		Main.java \
		Device.java \
		Laptop.java \
		Tv.java \
		Headphones.java \
		SmartWatch.java \
		SmartPhone.java

all : Main.class

run :
	$(JR) Main

classes : $(CLASSES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) $<

doc:
	$(JD) $(JDFLAGS) *.java

clean:
	$(RM) *.class

cleandoc:
	$(RM) -r ./javadoc