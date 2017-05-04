package io.mart.xstream.references;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

public class TestDrive {
    public static void main(String[] args) {
        Cd bj = new Cd("basement_jaxx_singles");

        List order = new ArrayList();
        // adds the same cd twice (two references to the same object)
        order.add(bj);
        order.add(bj);

        // adds itself (cycle)
        order.add(order);

        XStream xstream = new XStream();
        xstream.alias("cd", Cd.class);
        xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES); // default mode
        System.out.println(xstream.toXML(order));
        /**
         * This is default mode called XPATH_RELATIVE_REFERENCES
         * excpilit usage xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
         * <list>
         * <cd>
         * <id>basement_jaxx_singles</id>
         * </cd>
         * <cd reference="../cd"/>
         * <list reference=".."/>
         * </list>
         */

        xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES); // absolute mode
        System.out.println(xstream.toXML(order));
        /** Absolute mode
         * <list>
         <cd>
         <id>basement_jaxx_singles</id>
         </cd>
         <cd reference="/list/cd"/>
         <list reference="/list"/>
         </list>
         */

        xstream.setMode(XStream.SINGLE_NODE_XPATH_ABSOLUTE_REFERENCES);
        System.out.println(xstream.toXML(order));
        /**
         * <list>
         <cd>
         <id>basement_jaxx_singles</id>
         </cd>
         <cd reference="/list[1]/cd[1]"/>
         <list reference="/list[1]"/>
         </list>
         */

        xstream.setMode(XStream.SINGLE_NODE_XPATH_RELATIVE_REFERENCES);
        System.out.println(xstream.toXML(order));
        /**
         * <list>
         <cd>
         <id>basement_jaxx_singles</id>
         </cd>
         <cd reference="../cd[1]"/>
         <list reference=".."/>
         </list>
         */

        xstream.setMode(XStream.ID_REFERENCES);
        System.out.println(xstream.toXML(order));
        /**
         * <list id="1">
         <cd id="2">
         <id>basement_jaxx_singles</id>
         </cd>
         <cd reference="2"/>
         <list reference="1"/>
         </list>
         */

        //xstream.setMode(XStream.NO_REFERENCES);
        //System.out.println(xstream.toXML(order));
        // CircularReferenceException: Recursive reference to parent object. !!! recursive references are forbidden in this mode

    }
}
