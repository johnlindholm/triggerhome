package com.home.security.onewire.util;

import com.home.security.onewire.container.*;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OneWireCreator {
    private static String ASCII = "a";
    private static String DATE = "d";
    private static String PRESSURE = "p";
    private static String TEMPERATURE = "t";
    private static String DELTA_TEMPERATURE = "g";
    private static String YES_NO = "y";
    private static String ALIAS = "l";
    private static String BINARY = "b";
    private static String UNSIGNED_INT = "u";
    private static String FLOAT = "f";
    private static String INT = "i";

    private static String READ_ONLY = "ro";
    private static String READ_WRITE = "rw";
    private File srcDir;

    private OneWireCreator(String srcDir) {
        this.srcDir = new File(srcDir);
        createConstantsClass();
    }

    public static int pathToSize(String family, String path) {
        if (family.equals("01"))
            return OneWireContainer01.pathToSize(path);
        if (family.equals("02"))
            return OneWireContainer02.pathToSize(path);
        if (family.equals("04"))
            return OneWireContainer04.pathToSize(path);
        if (family.equals("05"))
            return OneWireContainer05.pathToSize(path);
        if (family.equals("06"))
            return OneWireContainer06.pathToSize(path);
        if (family.equals("08"))
            return OneWireContainer08.pathToSize(path);
        if (family.equals("09"))
            return OneWireContainer09.pathToSize(path);
        if (family.equals("0A"))
            return OneWireContainer0A.pathToSize(path);
        if (family.equals("0B"))
            return OneWireContainer0B.pathToSize(path);
        if (family.equals("0C"))
            return OneWireContainer0C.pathToSize(path);
        if (family.equals("0F"))
            return OneWireContainer0F.pathToSize(path);
        if (family.equals("10"))
            return OneWireContainer10.pathToSize(path);
        if (family.equals("12"))
            return OneWireContainer12.pathToSize(path);
        if (family.equals("14"))
            return OneWireContainer14.pathToSize(path);
        if (family.equals("18"))
            return OneWireContainer18.pathToSize(path);
        if (family.equals("1A"))
            return OneWireContainer1A.pathToSize(path);
        if (family.equals("1B"))
            return OneWireContainer1B.pathToSize(path);
        if (family.equals("1C"))
            return OneWireContainer1C.pathToSize(path);
        if (family.equals("1D"))
            return OneWireContainer1D.pathToSize(path);
        if (family.equals("1E"))
            return OneWireContainer1E.pathToSize(path);
        if (family.equals("1F"))
            return OneWireContainer1F.pathToSize(path);
        if (family.equals("20"))
            return OneWireContainer20.pathToSize(path);
        if (family.equals("21"))
            return OneWireContainer21.pathToSize(path);
        if (family.equals("22"))
            return OneWireContainer22.pathToSize(path);
        if (family.equals("23"))
            return OneWireContainer23.pathToSize(path);
        if (family.equals("24"))
            return OneWireContainer24.pathToSize(path);
        if (family.equals("26"))
            return OneWireContainer26.pathToSize(path);
        if (family.equals("27"))
            return OneWireContainer27.pathToSize(path);
        if (family.equals("28"))
            return OneWireContainer28.pathToSize(path);
        if (family.equals("29"))
            return OneWireContainer29.pathToSize(path);
        if (family.equals("2C"))
            return OneWireContainer2C.pathToSize(path);
        if (family.equals("2D"))
            return OneWireContainer2D.pathToSize(path);
        if (family.equals("2E"))
            return OneWireContainer2E.pathToSize(path);
        if (family.equals("30"))
            return OneWireContainer30.pathToSize(path);
        if (family.equals("31"))
            return OneWireContainer31.pathToSize(path);
        if (family.equals("32"))
            return OneWireContainer32.pathToSize(path);
        if (family.equals("35"))
            return OneWireContainer35.pathToSize(path);
        if (family.equals("36"))
            return OneWireContainer36.pathToSize(path);
        if (family.equals("37"))
            return OneWireContainer37.pathToSize(path);
        if (family.equals("3A"))
            return OneWireContainer3A.pathToSize(path);
        if (family.equals("3B"))
            return OneWireContainer3B.pathToSize(path);
        if (family.equals("3D"))
            return OneWireContainer3D.pathToSize(path);
        if (family.equals("41"))
            return OneWireContainer41.pathToSize(path);
        if (family.equals("42"))
            return OneWireContainer42.pathToSize(path);
        if (family.equals("43"))
            return OneWireContainer43.pathToSize(path);
        if (family.equals("51"))
            return OneWireContainer51.pathToSize(path);
        if (family.equals("81"))
            return OneWireContainer81.pathToSize(path);
        if (family.equals("82"))
            return OneWireContainer82.pathToSize(path);
        if (family.equals("89"))
            return OneWireContainer89.pathToSize(path);
        if (family.equals("8B"))
            return OneWireContainer8B.pathToSize(path);
        if (family.equals("8F"))
            return OneWireContainer8F.pathToSize(path);
        if (family.equals("EE"))
            return OneWireContainerEE.pathToSize(path);
        if (family.equals("FC"))
            return OneWireContainerFC.pathToSize(path);
        if (family.equals("FF")) {
            return OneWireContainerFF.pathToSize(path);
        }
        return -1;
    }

    public static OneWireDevice createDevice(String family) {
        if (family.equals("01"))
            return new OneWireContainer01();
        if (family.equals("02"))
            return new OneWireContainer02();
        if (family.equals("04"))
            return new OneWireContainer04();
        if (family.equals("05"))
            return new OneWireContainer05();
        if (family.equals("06"))
            return new OneWireContainer06();
        if (family.equals("08"))
            return new OneWireContainer08();
        if (family.equals("09"))
            return new OneWireContainer09();
        if (family.equals("0A"))
            return new OneWireContainer0A();
        if (family.equals("0B"))
            return new OneWireContainer0B();
        if (family.equals("0C"))
            return new OneWireContainer0C();
        if (family.equals("0F"))
            return new OneWireContainer0F();
        if (family.equals("10"))
            return new OneWireContainer10();
        if (family.equals("12"))
            return new OneWireContainer12();
        if (family.equals("14"))
            return new OneWireContainer14();
        if (family.equals("18"))
            return new OneWireContainer18();
        if (family.equals("1A"))
            return new OneWireContainer1A();
        if (family.equals("1B"))
            return new OneWireContainer1B();
        if (family.equals("1C"))
            return new OneWireContainer1C();
        if (family.equals("1D"))
            return new OneWireContainer1D();
        if (family.equals("1E"))
            return new OneWireContainer1E();
        if (family.equals("1F"))
            return new OneWireContainer1F();
        if (family.equals("20"))
            return new OneWireContainer20();
        if (family.equals("21"))
            return new OneWireContainer21();
        if (family.equals("22"))
            return new OneWireContainer22();
        if (family.equals("23"))
            return new OneWireContainer23();
        if (family.equals("24"))
            return new OneWireContainer24();
        if (family.equals("26"))
            return new OneWireContainer26();
        if (family.equals("27"))
            return new OneWireContainer27();
        if (family.equals("28"))
            return new OneWireContainer28();
        if (family.equals("29"))
            return new OneWireContainer29();
        if (family.equals("2C"))
            return new OneWireContainer2C();
        if (family.equals("2D"))
            return new OneWireContainer2D();
        if (family.equals("2E"))
            return new OneWireContainer2E();
        if (family.equals("30"))
            return new OneWireContainer30();
        if (family.equals("31"))
            return new OneWireContainer31();
        if (family.equals("32"))
            return new OneWireContainer32();
        if (family.equals("35"))
            return new OneWireContainer35();
        if (family.equals("36"))
            return new OneWireContainer36();
        if (family.equals("37"))
            return new OneWireContainer37();
        if (family.equals("3A"))
            return new OneWireContainer3A();
        if (family.equals("3B"))
            return new OneWireContainer3B();
        if (family.equals("3D"))
            return new OneWireContainer3D();
        if (family.equals("41"))
            return new OneWireContainer41();
        if (family.equals("42"))
            return new OneWireContainer42();
        if (family.equals("43"))
            return new OneWireContainer43();
        if (family.equals("51"))
            return new OneWireContainer51();
        if (family.equals("81"))
            return new OneWireContainer81();
        if (family.equals("82"))
            return new OneWireContainer82();
        if (family.equals("89"))
            return new OneWireContainer89();
        if (family.equals("8B"))
            return new OneWireContainer8B();
        if (family.equals("8F"))
            return new OneWireContainer8F();
        if (family.equals("EE"))
            return new OneWireContainerEE();
        if (family.equals("FC"))
            return new OneWireContainerFC();
        if (family.equals("FF")) {
            return new OneWireContainerFF();
        }
        return null;
    }

    public static void main(String[] args) {
        new OneWireCreator("/mnt/1wire/structure");
    }

    private void createConstantsClass() {
        String[] constantsClass = new String[2];
        constantsClass[0] = "package se.lth.cs.palcom.onewire.util;\n\n";
        int tmp13_12 = 0;
        String[] tmp13_11 = constantsClass;
        tmp13_11[tmp13_12] = (tmp13_11[tmp13_12] + "/**\n *\n * @author John Lindholm\n *\n */\n");
        int tmp38_37 = 0;
        String[] tmp38_36 = constantsClass;
        tmp38_36[tmp38_37] = (tmp38_36[tmp38_37] + "public class OneWireDeviceConstants {\n\n");
        int tmp63_62 = 0;
        String[] tmp63_61 = constantsClass;
        tmp63_61[tmp63_62] = (tmp63_61[tmp63_62] + "\t/**\n\t * The file to read for temperature values.\n\t */\n");
        int tmp88_87 = 0;
        String[] tmp88_86 = constantsClass;
        tmp88_86[tmp88_87] = (tmp88_86[tmp88_87] + "\tpublic static String FILENAME_TEMPERATURE = \"temperature\";\n\n");
        int tmp113_112 = 0;
        String[] tmp113_111 = constantsClass;
        tmp113_111[tmp113_112] = (tmp113_111[tmp113_112] + "\t/**\n\t * The file to read for pressure values.\n\t */\n");
        int tmp138_137 = 0;
        String[] tmp138_136 = constantsClass;
        tmp138_136[tmp138_137] = (tmp138_136[tmp138_137] + "\tpublic static String FILENAME_PRESSURE = \"pressure\";\n\n");
        int tmp163_162 = 0;
        String[] tmp163_161 = constantsClass;
        tmp163_161[tmp163_162] = (tmp163_161[tmp163_162] + "\t/**\n\t * The file to read for humidity values.\n\t */\n");
        int tmp188_187 = 0;
        String[] tmp188_186 = constantsClass;
        tmp188_186[tmp188_187] = (tmp188_186[tmp188_187] + "\tpublic static String FILENAME_HUMIDITY = \"humidity\";\n\n");
        int tmp213_212 = 0;
        String[] tmp213_211 = constantsClass;
        tmp213_211[tmp213_212] = (tmp213_211[tmp213_212] + "\t/**\n\t * The file to read for switch values.\n\t */\n");
        int tmp238_237 = 0;
        String[] tmp238_236 = constantsClass;
        tmp238_236[tmp238_237] = (tmp238_236[tmp238_237] + "\tpublic static String FILENAME_SWITCH = \"sensed.BYTE\";\n\n");
        int tmp263_262 = 0;
        String[] tmp263_261 = constantsClass;
        tmp263_261[tmp263_262] = (tmp263_261[tmp263_262] + "\t/**\n\t * The file to read for voltage values.\n\t */\n");
        int tmp288_287 = 0;
        String[] tmp288_286 = constantsClass;
        tmp288_286[tmp288_287] = (tmp288_286[tmp288_287] + "\tpublic static String FILENAME_VOLTAGE = \"volt.ALL\";\n\n");
        constantsClass[1] = "\t/**\n\t * Calculates the expected size for the path given the family.\n\t *\n\t * @param family\n\t* @param path\n\t * @return The expected size.\n\t*/\n";
        int tmp319_318 = 1;
        String[] tmp319_317 = constantsClass;
        tmp319_317[tmp319_318] = (tmp319_317[tmp319_318] + "\tpublic static int pathToSize(String family, String path){\n");
        File[] familyDirs = this.srcDir.listFiles();

        for (int i = 0; i < familyDirs.length; i++) {
            String family = familyDirs[i].getName();
            HashMap nameFormatMap = new HashMap();
            File[] params0 = familyDirs[i].listFiles();
            for (int j = 0; j < params0.length; j++) {
                if (params0[j].isDirectory()) {
                    File[] params1 = params0[j].listFiles();
                    for (int k = 0; k < params1.length; k++)
                        if (params1[k].isDirectory()) {
                            File[] params2 = params1[k].listFiles();
                            for (int l = 0; l < params2.length; l++)
                                if (params2[l].isDirectory()) {
                                    System.err.println(params2[l].getAbsolutePath() + " is a directory");
                                    System.exit(-1);
                                } else {
                                    nameFormatMap.put(params0[j].getName() + "/" + params1[k].getName() + "/" +
                                            params2[l].getName(), readFormatFromFile(params2[l]));
                                }
                        } else {
                            nameFormatMap.put(params0[j].getName() + "/" + params1[k].getName(),
                                    readFormatFromFile(params1[k]));
                        }
                } else {
                    nameFormatMap.put(params0[j].getName(), readFormatFromFile(params0[j]));
                }
            }
            createOneWireDeviceContainer(family, nameFormatMap);
        }
        int tmp695_694 = 0;
        String[] tmp695_693 = constantsClass;
        tmp695_693[tmp695_694] = (tmp695_693[tmp695_694] + "\n");
        int tmp720_719 = 1;
        String[] tmp720_718 = constantsClass;
        tmp720_718[tmp720_719] = (tmp720_718[tmp720_719] + "\n\t\treturn -1;\n");
        int tmp745_744 = 1;
        String[] tmp745_743 = constantsClass;
        tmp745_743[tmp745_744] = (tmp745_743[tmp745_744] + "\t}\n}");
        writeClassToFile("src/se/lth/cs/palcom/onewire/util/", "OneWireDeviceConstants.java", constantsClass[0] +
                constantsClass[1]);
    }

    private void createOneWireDeviceContainer(String family, HashMap<String, String> nameFormatMap) {
        String packageAndImports = "package se.lth.cs.palcom.onewire.container;\n\n";
        packageAndImports = packageAndImports + "import se.lth.cs.palcom.onewire.OWFSClient;\n\n";
        packageAndImports = packageAndImports + "import java.io.IOException;\n\n";
        String classStr = "/**\n *\n * @author John Lindholm\n *\n */\n";
        classStr = classStr + "public class OneWireContainer" + family + " extends OneWireDevice ";
        String[] nameStatsAndMethod = createStaticsAndAddToNameToSizeMethod(true, family, nameFormatMap);
        boolean isTempDevice = false;
        boolean isPressureDevice = false;
        boolean isHumidityDevice = false;
        boolean isSwitchDevice = false;
        boolean isClockDevice = false;
        boolean isVoltageDevice = false;
        boolean first = true;
        if (nameFormatMap.containsKey("temperature")) {
            isTempDevice = true;
            classStr = classStr + "implements OneWireTemperatureContainer";
            first = false;
        }
        if (nameFormatMap.containsKey("pressure")) {
            isPressureDevice = true;
            if (!first) {
                classStr = classStr + ", OneWirePressureContainer";
                first = false;
            } else {
                classStr = classStr + "implements OneWirePressureContainer";
                first = false;
            }
        }
        if (nameFormatMap.containsKey("humidity")) {
            isHumidityDevice = true;
            if (!first) {
                classStr = classStr + ", OneWireHumidityContainer";
                first = false;
            } else {
                classStr = classStr + "implements OneWireHumidityContainer";
                first = false;
            }
        }
        if (nameFormatMap.containsKey("sensed.BYTE")) {
            isSwitchDevice = true;
            if (!first) {
                classStr = classStr + ", OneWireSwitchContainer";
                first = false;
            } else {
                classStr = classStr + "implements OneWireSwitchContainer";
                first = false;
            }
        }
        if (nameFormatMap.containsKey("volt.ALL")) {
            isVoltageDevice = true;
            if (!first) {
                classStr = classStr + ", OneWireVoltageSensorContainer";
                first = false;
            } else {
                classStr = classStr + "implements OneWireVoltageSensorContainer";
                first = false;
            }
        }
        if (nameFormatMap.containsKey("date")) {
            isClockDevice = true;
            packageAndImports = packageAndImports + "import java.util.GregorianCalendar;\n";
            packageAndImports = packageAndImports + "import se.lth.cs.palcom.onewire.util.DateUtils;\n";
            packageAndImports = packageAndImports + "import java.util.Date;\n\n";
            if (!first) {
                classStr = classStr + ", OneWireClockContainer";
                first = false;
            } else {
                classStr = classStr + "implements OneWireClockContainer";
                first = false;
            }
        }
        classStr = classStr + " {\n\n";

        classStr = classStr + nameStatsAndMethod[0] + "\n\n";

        classStr = classStr + "\t/**\n\t *\n\t */\n";
        classStr = classStr + "\tpublic OneWireContainer" + family + "() {\n";
        classStr = classStr + "\t\tsuper();\n";
        classStr = classStr + "\t}\n\n";
        classStr = classStr + "\t/**\n\t *\n\t * @param owfsClient\n\t * @param address\n\t * @param alias\n\t * @param crc8\n\t * @param family\n\t * @param id\n\t * @param locator\n\t * @param r_address\n\t * @param r_id\n\t * @param r_locator\n\t * @param type\n\t */\n";

        classStr = classStr + "\tpublic OneWireContainer" +
                family +
                "(OWFSClient owfsClient, String address, String alias, String crc8, String family, " +
                "String id, String locator,String r_address, String r_id, String r_locator, String type){\n";
        classStr = classStr + "\t\tsuper(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);\n";
        classStr = classStr + "\t}\n\n";

        if (isTempDevice) {
            classStr = classStr + "\t/**\n\t *\n\t * @return The temperature.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic String getTemperature() throws IOException {\n";
            classStr = classStr + "\t\treturn readValue(\"temperature\", true);\n";
            classStr = classStr + "\t}\n\n";

            if ((nameFormatMap.containsKey("templow")) && (nameFormatMap.containsKey("temphigh"))) {
                classStr = classStr + "\t/**\n\t *\n\t * @return If it has temperature resolution.\n\t */\n";
                classStr = classStr + "\tpublic boolean hasTemperatureResolution() {\n";
                classStr = classStr + "\t\treturn true;\n";
                classStr = classStr + "\t}\n\n";
            } else {
                classStr = classStr + "\t/**\n\t *\n\t * @return If it has temperature resolution.\n\t */\n";
                classStr = classStr + "\tpublic boolean hasTemperatureResolution() {\n";
                classStr = classStr + "\t\treturn false;\n";
                classStr = classStr + "\t}\n\n";
            }

            classStr = classStr + "\t/**\n\t *\n\t * @return The high temperature.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic String getTemperatureHigh() throws IOException {\n";
            classStr = classStr + "\t\tif(!hasTemperatureResolution()) return null;\n";
            classStr = classStr + "\t\treturn readValue(\"temphigh\", true);\n";
            classStr = classStr + "\t}\n\n";

            classStr = classStr + "\t/**\n\t *\n\t * @return The low temperature.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic String getTemperatureLow() throws IOException {\n";
            classStr = classStr + "\t\tif(!hasTemperatureResolution()) return null;\n";
            classStr = classStr + "\t\treturn readValue(\"templow\", true);\n";
            classStr = classStr + "\t}\n\n";

            classStr = classStr + "\t/**\n\t *\n\t * @param templow\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic void setTemperatureLow(String templow) throws IOException {\n";
            classStr = classStr + "\t\tif(!hasTemperatureResolution()) return;\n";
            classStr = classStr + "\t\twriteValue(\"templow\",templow);\n";
            classStr = classStr + "\t}\n\n";

            classStr = classStr + "\t/**\n\t *\n\t * @param temphigh\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic void setTemperatureHigh(String temphigh) throws IOException {\n";
            classStr = classStr + "\t\tif(!hasTemperatureResolution()) return;\n";
            classStr = classStr + "\t\twriteValue(\"temphigh\", temphigh);\n";
            classStr = classStr + "\t}\n\n";
        }

        if (isPressureDevice) {
            classStr = classStr + "\t/**\n\t *\n\t * @return The pressure.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic String getPressure() throws IOException {\n";
            classStr = classStr + "\t\treturn readValue(\"pressure\", true);\n";
            classStr = classStr + "\t}\n\n";
        }

        if (isHumidityDevice) {
            classStr = classStr + "\t/**\n\t *\n\t * @return The humidity.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic String getHumidity() throws IOException {\n";
            classStr = classStr + "\t\treturn readValue(\"humidity\", true);\n";
            classStr = classStr + "\t}\n\n";
        }

        if (isSwitchDevice) {
            classStr = classStr + "\t/**\n\t *\n\t * @return True if is on, false otherwise.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic boolean isOn() throws IOException {\n";
            classStr = classStr + "\t\tString response = readValue(\"sensed.BYTE\", true);\n";
            classStr = classStr + "\t\tif(response != null) {\n";
            classStr = classStr + "\t\t\tint value = Integer.parseInt(response);\n";
            classStr = classStr + "\t\t\treturn value == 0 ? false : true;\n";
            classStr = classStr + "\t\t}\n";
            classStr = classStr + "\t\treturn false;\n";
            classStr = classStr + "\t}\n\n";

            classStr = classStr + "\t/**\n\t *\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic void turnAllOn() throws IOException {\n";
            classStr = classStr + "\t\twriteValue(\"PIO.BYTE\", \"3\");\n";
            classStr = classStr + "\t}\n\n";

            classStr = classStr + "\t/**\n\t *\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic void turnAllOff() throws IOException {\n";
            classStr = classStr + "\t\twriteValue(\"PIO.BYTE\", \"0\");\n";
            classStr = classStr + "\t}\n\n";
        }

        if (isVoltageDevice) {
            classStr = classStr + "\t/**\n\t *\n\t * @return the voltage.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic String getVoltageAll() throws IOException {\n";
            classStr = classStr + "\t\treturn readValue(\"volt.ALL\", true);\n";
            classStr = classStr + "\t}\n\n";
        }

        if (isClockDevice) {
            classStr = classStr + "\t/**\n\t *\n\t * @return The date.\n\t * @throws IOException\n\t */\n";
            classStr = classStr + "\tpublic Date getDate() throws IOException {\n";
            classStr = classStr + "\t\tString response = readValue(\"date\", true);\n";
            classStr = classStr + "\t\tif(response == null) return null;\n";
            classStr = classStr + "\t\tString[] ss = response.split(\" \");\n";
            classStr = classStr + "\t\tif(ss == null || ss.length <= 0 || ss.length != 6) return null;\n";
            classStr = classStr + "\t\tint year = Integer.parseInt(ss[5]);\n";
            classStr = classStr + "\t\tint month = DateUtils.monthStringToCalendarInt(ss[1]);\n";
            classStr = classStr + "\t\tint date = Integer.parseInt(ss[3]);\n";
            classStr = classStr + "\t\tss = ss[4].split(\":\");\n";
            classStr = classStr + "\t\tint hour = Integer.parseInt(ss[0]);\n";
            classStr = classStr + "\t\tint minute = Integer.parseInt(ss[1]);\n";
            classStr = classStr + "\t\tint second = Integer.parseInt(ss[2]);\n";
            classStr = classStr + "\t\tGregorianCalendar calendar = (GregorianCalendar)GregorianCalendar.getInstance();\n";
            classStr = classStr + "\t\tcalendar.set(year, month, date, hour, minute, second);\n";
            classStr = classStr + "\t\treturn calendar.getTime();\n";
            classStr = classStr + "\t}\n\n";
        }

        classStr = classStr + "\t/**\n\t *\n\t * @param path to value\n\t * @return The size of the value\n\t */\n";

        classStr = classStr + "\tpublic static int pathToSize(String path){\n";
        classStr = classStr + nameStatsAndMethod[1] + "\n\t\treturn -1;\n\t}\n";
        classStr = classStr + "}\n";

        writeClassToFile("src/se/lth/cs/palcom/onewire/container/", "OneWireContainer" + family + ".java", packageAndImports +
                classStr);
    }

    private String readFormatFromFile(File file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            return in.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeClassToFile(String pathToPackage, String fileName, String classStr) {
        try {
            FileOutputStream out = new FileOutputStream(pathToPackage + fileName);
            out.write(classStr.getBytes());
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] formatToTypePermissionSize(String format) {
        String[] ss = format.split(",");
        String[] result = new String[3];
        result[0] = ss[0].trim();
        result[1] = ss[3].trim();
        result[2] = ss[4].trim();
        return result;
    }

    private String trimSizeString(String size) {
        boolean fin = false;
        while (!fin) {
            if (size.charAt(0) == '0')
                size = size.substring(1);
            else {
                fin = true;
            }
        }
        return size.trim();
    }

    private String[] createStaticsAndAddToNameToSizeMethod(boolean first, String family, HashMap<String, String> nameFormatMap) {
        String nameStatics = "";
        String sizeStatics = "";
        String method = "";
        Set set = nameFormatMap.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry e = (Map.Entry) itr.next();
            System.out.println("name:" + (String) e.getKey() + ", value:" + (String) e.getValue());
            String name = (String) e.getKey();
            String size = trimSizeString(formatToTypePermissionSize((String) e.getValue())[2]);
            String nameVar = ("FAM_" + family + "_" + pathToVariableName(name)).toUpperCase();
            nameStatics = nameStatics + "\tprivate static String " + nameVar + " = \"" + name + "\";\n";
            sizeStatics = sizeStatics + "\tprivate static int " + nameVar + "_SIZE = " + size + ";\n";
            if (first) {
                method = method + "\t\tif(path.equals(" + nameVar + ")){\n\t\t\treturn " + nameVar + "_SIZE;\n\t\t}";
                first = false;
            } else {
                method = method + " else if(path.equals(" + nameVar + ")){\n\t\t\treturn " + nameVar + "_SIZE;\n\t\t}";
            }
        }
        return new String[]{nameStatics + sizeStatics, method};
    }

    private String[] createStaticsAndAddToNameToSizeMethod_OLD(boolean first, String family, HashMap<String, String> nameFormatMap) {
        String nameStatics = "";
        String sizeStatics = "";
        String method = "";
        Set set = nameFormatMap.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry e = (Map.Entry) itr.next();
            System.out.println("name:" + (String) e.getKey() + ", value:" + (String) e.getValue());
            String name = (String) e.getKey();
            String size = trimSizeString(formatToTypePermissionSize((String) e.getValue())[2]);
            String nameVar = ("FAM_" + family + "_" + pathToVariableName(name)).toUpperCase();
            nameStatics = nameStatics + "\tprivate static String " + nameVar + " = \"" + name + "\";\n";
            sizeStatics = sizeStatics + "\tprivate static int " + nameVar + "_SIZE = " + size + ";\n";
            if (first) {
                method = method + "\t\tif(family.equals(\"" + family + "\") && path.equals(" + nameVar +
                        ")){\n\t\t\treturn " + nameVar + "_SIZE;\n\t\t}";
                first = false;
            } else {
                method = method + " else if(family.equals(\"" + family + "\") && path.equals(" + nameVar +
                        ")){\n\t\t\treturn " + nameVar + "_SIZE;\n\t\t}";
            }
        }
        return new String[]{nameStatics + sizeStatics, method};
    }

    private String pathToVariableName(String path) {
        path = path.replace('.', '_');
        path = path.replace('-', '_');
        path = path.replace('/', '_');
        return path;
    }

    private String createFieldAndMethods(String name, String type, String permission, String size) {
        String classType = typeToClass(type);
        String fieldName = pathToVariableName(name);
        String methodNamePart = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        String field = new String("\tprivate " + classType + " " + fieldName + ";\n");
        String methods = "\tpublic " + classType + " get" + methodNamePart + "(){\n\t\treturn " + fieldName +
                ";\n\t}\n";
        if (permission.equals(READ_WRITE)) {
            methods = methods + "\tpublic void set" + methodNamePart + "(" + classType + " " + fieldName +
                    "){\n\t\tthis." + fieldName + " = " + fieldName + ";\n\t}\n";
        }
        return field + methods;
    }

    private String typeToClass(String type) {
        if (type.equals(ASCII))
            return "String";
        if (type.equals(YES_NO))
            return "boolean";
        if (type.equals(ALIAS))
            return "String";
        if (type.equals(BINARY))
            return "byte[]";
        if (type.equals(UNSIGNED_INT))
            return "int";
        if (type.equals(FLOAT))
            return "float";
        if (type.equals(DATE))
            return "String";
        if (type.equals(PRESSURE))
            return "float";
        if (type.equals(TEMPERATURE))
            return "float";
        if (type.equals(DELTA_TEMPERATURE))
            return "float";
        if (type.equals(INT)) {
            return "int";
        }
        return null;
    }
}