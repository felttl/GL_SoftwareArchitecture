package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatternPrototypeTest {
    
    @Test
    public void testClickXYValidCoordinates() {
        SystemDraw draw = new SystemDraw();
        draw.clickXY(10, 10);
        assertEquals(0  , draw.formSelected);
    }
    
}