package com.example.has.asapp.module.textview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.has.asapp.R;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.BulletSpan;
import android.text.style.DrawableMarginSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.IconMarginSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by has on 2018/3/29.
 * textview 特效
 */
public class MainAct extends Activity {
    private Context context =MainAct.this;
    TextView mTextView = null;

    SpannableString msp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_textview);
        textview1();
        textview2();
        webLoadText();
        tvLoadHtmlAndImg();
        showDrawableTextView();

    }

    /**
     * TextVew显示图片
     */
    private void showDrawableTextView() {
        TextView youview = (TextView) findViewById(R.id.text5);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        // 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        youview.setCompoundDrawables(drawable, null, null, null);
        youview.setText("左边显示图片");
    }

    private void tvLoadHtmlAndImg() {
        TextView vMeDec = (TextView) findViewById(R.id.text4);
        vMeDec.setText(Html.fromHtml(descString(), getImageGetterInstance(),
                null));
    }

    public Html.ImageGetter getImageGetterInstance() {
        Html.ImageGetter imgGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                int id = Integer.parseInt(source);
                Drawable d = getResources().getDrawable(id);
                int wdp = dip2px(context, 20);
                int hdp = dip2px(context, 20);
                d.setBounds(0, 0, wdp, hdp);
                return d;
            }
        };
        return imgGetter;
    }
    public static int dip2px(Context context, float dpValue) {

        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    private String descString() {
        return "生活不止眼前的苟且，还有诗和远方的苟且 " + "<img src='" + R.mipmap.ic_launcher + "'/>";
    }

    /**
     * webView 加载文字
     */
    private void webLoadText() {
        WebView webview = (WebView) findViewById(R.id.webview);
        WebView webview2 = (WebView) findViewById(R.id.webview2);
        webview.loadData("adb<sub>3</sub>","text/html","utf-8");
        webview2.loadData("adb<sup>3</sup>","text/html","utf-8");
    }

    /**
     * html加载文字
     */
    private void textview2() {
        TextView t3 = (TextView) findViewById(R.id.text3);
        t3.setText(Html.fromHtml("text3: Text with a  " + "<a href=\"http://www.baidu.com\">link</a>" +
                "created in the Java source code using HTML."));
        t3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * 加载字体特效
     */
    private void textview1() {
        mTextView = (TextView) findViewById(R.id.myTextView);

        //创建一个 SpannableString对象
        msp = new SpannableString("字体测试字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2电话邮件网站短信彩信地图X轴综合/bot");

        //设置字体(default,default-bold,monospace,serif,sans-serif)
        msp.setSpan(new TypefaceSpan("monospace"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        msp.setSpan(new TypefaceSpan("serif"), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置字体大小(绝对值,单位：像素)
        msp.setSpan(new AbsoluteSizeSpan(20), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new AbsoluteSizeSpan(20, true), 6, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //第二个参数boolean dip，如果为true，表示前面的字体大小单位为dip，否则为像素，同上。

        //设置字体大小(相对值,单位：像素) 参数表示为默认字体大小的多少倍
        msp.setSpan(new RelativeSizeSpan(0.5f), 8, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //0.5f表示默认字体大小的一半
        msp.setSpan(new RelativeSizeSpan(2.0f), 10, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体大小的两倍

        //设置字体前景色
        msp.setSpan(new ForegroundColorSpan(Color.MAGENTA), 12, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //设置前景色为洋红色

        //设置字体背景色
        msp.setSpan(new BackgroundColorSpan(Color.CYAN), 15, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //设置背景色为青色

        //设置字体样式正常，粗体，斜体，粗斜体
        msp.setSpan(new StyleSpan(android.graphics.Typeface.NORMAL), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //正常
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //粗体
        msp.setSpan(new StyleSpan(android.graphics.Typeface.ITALIC), 22, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //斜体
        msp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 24, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //粗斜体

        //设置下划线
        msp.setSpan(new UnderlineSpan(), 27, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置删除线
        msp.setSpan(new StrikethroughSpan(), 30, 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置上下标
        msp.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //下标
        msp.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //上标

        //超级链接(需要添加setMovementMethod方法附加响应)
        msp.setSpan(new URLSpan("tel:4155551212"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //电话
        msp.setSpan(new URLSpan("mailto:webmaster@google.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //邮件
        msp.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //网络
        msp.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //短信 使用sms:或者smsto:
        msp.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //彩信 使用mms:或者mmsto:
        msp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //地图

        //设置字体大小(相对值,单位：像素) 参数表示为默认字体宽度的多少倍
        msp.setSpan(new ScaleXSpan(2.0f), 49, 51, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变

        //设置字体(依次包括字体名称，字体大小，字体样式，字体颜色，链接颜色)
//        ColorStateList csllink = null;
//        ColorStateList csl = null;
//        XmlResourceParser xppcolor=getResources().getXml (R.color.color);
//        try {
//            csl= ColorStateList.createFromXml(getResources(),xppcolor);
//
//        }catch(XmlPullParserException e){
//            // TODO: handle exception
//            e.printStackTrace();
//
//        }catch(IOException e){
//            // TODO: handle exception
//            e.printStackTrace();
//
//        }
//
//        XmlResourceParser xpplinkcolor=getResources().getXml(R.color.linkcolor);
//        try {
//            csllink= ColorStateList.createFromXml(getResources(),xpplinkcolor);
//
//        }catch(XmlPullParserException e){
//            // TODO: handle exception
//            e.printStackTrace();
//
//        }catch(IOException e){
//            // TODO: handle exception
//            e.printStackTrace();
//
//        }
//        msp.setSpan(new TextAppearanceSpan("monospace",android.graphics.Typeface.BOLD_ITALIC, 30, csl, csllink), 51, 53, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //设置项目符号
        msp.setSpan(new BulletSpan(BulletSpan.STANDARD_GAP_WIDTH, Color.GREEN), 0, msp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //第一个参数表示项目符号占用的宽度，第二个参数为项目符号的颜色

        //设置图片
        Drawable drawable = getResources().getDrawable(R.drawable.market_floating_service_press_img);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        msp.setSpan(new ImageSpan(drawable), 53, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextView.setText(msp);
        mTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}