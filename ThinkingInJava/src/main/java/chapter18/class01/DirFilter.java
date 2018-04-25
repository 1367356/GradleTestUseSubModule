package chapter18.class01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFilter implements FilenameFilter {

    private Pattern pattern;
    public DirFilter(String arg) {
        pattern = Pattern.compile(arg);
    }

    @Override
    public boolean accept(File file, String s) {
        return pattern.matcher(s).matches();
    }
}
