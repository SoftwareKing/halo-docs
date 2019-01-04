package org.xujin.doc.core.strategy;

import org.xujin.doc.core.Claxx;
import org.xujin.doc.core.Preference;
import org.xujin.doc.core.Src;
import org.xujin.doc.core.appender.WriterAppender;
import org.xujin.doc.core.kit.IOKit;

import java.io.*;

/**
 * 覆盖策略
 *
 * @author
 * @date 2018-07-04 20:34
 **/
public class OverrideStrategy implements Strategy {

    @Override
    public void execute(Task task) throws IOException {
        String directory = task.getDirectory();
        for (Claxx claxx : task) {
            OutputStream out = null;
            Writer writer = null;
            try {
                String path = directory + claxx.getPath();
                File file = new File(path);
                File folder = file.getParentFile();
                if (!folder.exists() && !folder.mkdirs()) throw new IOException("could not create directory : " + folder);
                out = new FileOutputStream(file);
                writer = new OutputStreamWriter(out);
                Src<Preference> src = claxx.getSrc();
                Preference preference = claxx.getPreference();
                WriterAppender appender = new WriterAppender(writer);
                src.joinTo(appender, preference);
                writer.flush();
                out.flush();
            } finally {
                IOKit.close(writer);
                IOKit.close(out);
            }
        }
    }

}
