package com.javacore.file4.javawords.frequency;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class JavaKeywordFrequency extends KeywordFrequency {

    private static final List<String> reservedWords = Lists.newArrayList(("abstract\tcontinue\tfor\tnew\tswitch\t" +
            "assert\tdefault\tgoto\tpackage\tsynchronized\tboolean\tdo\tif\tprivate\tthis\t" +
            "break\tdouble\timplements\tprotected\tthrow\tbyte\telse\timport\tpublic\tthrows\t" +
            "case\tenum\tinstanceof\treturn\ttransient\tcatch\textends\tint\tshort\ttry\t" +
            "char\tfinal\tinterface\tstatic\tvoid\tclass\tfinally\tlong\tstrictfp\tvolatile\t" +
            "const\tfloat\tnative\tsuper\twhile")
            .split("\t"));

    public Map<String, Integer> find(String lines) {
        return super.find(lines, reservedWords);
    }
}
