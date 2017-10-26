package cz.adamh.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class NativeUtilsTest {

    @Test(expected=IllegalArgumentException.class)
    public void testLoadLibraryIllegalPath() throws IOException {
        NativeUtils.loadLibraryFromJar("libtest.so");
    }

    @Test(expected=IllegalArgumentException.class)
    public void testLoadLibraryIllegalPrefix() throws IOException {
        NativeUtils.loadLibraryFromJar("/l");
    }

    @Test(expected= FileNotFoundException.class)
    public void testLoadLibraryNonExistentPath() throws IOException {
        NativeUtils.loadLibraryFromJar("/libtest.so");
    }

    @Test(expected=NullPointerException.class)
    public void testLoadLibraryNullPath() throws IOException {
        NativeUtils.loadLibraryFromJar(null);
    }
}
