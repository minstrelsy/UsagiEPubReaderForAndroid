package com.kujirahand.KCSS;

import com.kujirahand.utils.KFile;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kujira on 2016/04/18.
 */
public class CSSParserTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testSetSource() throws Exception {
        CSSItems css = CSSParser.parseString("p { color: red; } ");
        StyleMap map = css.getStyleItem("p");
        String v = map.get("color");
        assertEquals("red", v);
    }

    @Test
    public void testSetSource2() throws Exception {
        String a = "em { color:black; }\np { color: red; padding-top: 8px; } ";
        CSSItems css = CSSParser.parseString(a);
        //
        StyleMap map = css.getStyleItem("p");
        assertEquals("8px", map.get("padding-top"));
        assertEquals("red", map.get("color"));
        //
        StyleMap em = css.getStyleItem("em");
        assertEquals("black", em.get("color"));
    }

    @Test
    public void testSetSourceHaveError() throws Exception {
        String a = "em { color:black }\np { color: red; padding-top: 8px } ";
        CSSItems css = CSSParser.parseString(a);
        //
        StyleMap map = css.getStyleItem("p");
        assertEquals("8px", map.get("padding-top"));
        assertEquals("red", map.get("color"));
        //
        StyleMap em = css.getStyleItem("em");
        assertEquals("black", em.get("color"));
    }

    @Test
    public void testSetSourceWithComment() throws Exception {
        String a = "/* comment */ em { color:black; /* comment */ }\np { /*comment */ color: red; padding-top: 8px } ";
        CSSItems css = CSSParser.parseString(a);
        //
        StyleMap map = css.getStyleItem("p");
        assertEquals("8px", map.get("padding-top"));
        assertEquals("red", map.get("color"));
        //
        StyleMap em = css.getStyleItem("em");
        assertEquals("black", em.get("color"));
    }

    @Test
    public void testParse() throws Exception {

    }
}
