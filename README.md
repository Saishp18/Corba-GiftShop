# Corba-GiftShop
IDL:	idlj -fAll -oldImplBase shop.idl

Compile all files using the command: javac *.java 

Start ordb from terminal using command: orbd -ORBInitialPort 1050

Start Server using the command: java Server -ORBInitialPort 1050 -ORBInitialHost localhost

Start Client using the command: java Client -ORBInitialPort 1050 -ORBInitialHost localhost
