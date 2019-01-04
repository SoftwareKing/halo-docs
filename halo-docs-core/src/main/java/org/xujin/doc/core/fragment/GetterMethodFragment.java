package org.xujin.doc.core.fragment;

import org.xujin.doc.core.type.HDType;

/**
 * Getter方法碎片
 *
 * @author
 * @date 2018-04-27 16:34
 **/
public class GetterMethodFragment extends MethodFragment {

    public GetterMethodFragment(HDType type, String name) {
        this.resultFragment = new ResultFragment(type);
        this.name = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        this.blockFragment = new BlockFragment("return " + name + ";");
    }

}
