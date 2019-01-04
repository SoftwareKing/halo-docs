package org.xujin.doc.core.fragment;

import org.xujin.doc.core.Preference;
import org.xujin.doc.core.appender.LineAppender;

import java.io.IOException;

/**
 * 静待代码块碎片
 *
 * @author
 * @date 2018-04-27 16:38
 **/
public class StaticBlockFragment extends BlockFragment {

    @Override
    public <T extends LineAppender<T>> void joinTo(T appender, Preference preference) throws IOException {
        appender.append("static");
        super.joinTo(appender, preference);
    }
}
