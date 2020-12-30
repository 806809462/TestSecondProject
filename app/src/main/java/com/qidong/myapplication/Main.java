package com.qidong.myapplication;

import android.util.Log;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;
import com.qidong.myapplication.com.baidu.translate.demo.TransApi;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20201218000650291";
    private static final String SECURITY_KEY = "KAyAq7YGHLO_sGTq_cfQ";
    private static Translate translate;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                TransApi api = new TransApi(APP_ID, SECURITY_KEY);

                String query = "姐姐是p一名7教师";

                System.out.println(api.getTransResult(query, "zh", "en"));
            }
        }).start();
        //testTranslateTextWithModel();
        //googleTranslate();
    }

    private static void googleTranslate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Translate translate = TranslateOptions.getDefaultInstance().getService();
                Translate translate = TranslateOptions.newBuilder().setApiKey("AIzaSyAuPO3rl-CClveK6XulCapCITeSONanpVA").build().getService();
                String sourceLanguage = "en";
                String targetLanguage = "zh-CN";
                Translate.TranslateOption srcLang = Translate.TranslateOption.sourceLanguage(sourceLanguage);
                Translate.TranslateOption tgtLang = Translate.TranslateOption.targetLanguage(targetLanguage);
                // Use translate `model` parameter with `base` and `nmt` options.
                Translate.TranslateOption model = Translate.TranslateOption.model("nmt");

                String sourceText = "Robinson Crusoe is a real hero. " +
                        "He almost has everything needed for becoming a successful man, " +
                        "such as his excellent creativity, great working capacity, courage, and persistence in overcoming obstacles. " +
                        "However, Robinson Crusoe is not a perfect man. " +
                        "He also has shortcomings. " +
                        "He was such a coward when he encountered a storm the first time. " +
                        "He sweared and repented yet ate his words and sailed on after the storm. " +
                        "By showing Robinson’s shortcomings, Daniel Defoe made Robinson a real person. " +
                        "After all, no one is perfect. " +
                        "Robinson Crusoe can not only lead the ambitious ones to success, but also guide average people to face up to life. " +
                        "This is the significance of the study of Robinson Crusoe";
                //Log.e("MainActivityApp", "googleTranslate.............................1");
                Translation translation = translate.translate(sourceText, srcLang, tgtLang, model);
                Log.e("MainActivityApp", "Source Text:.............................." + sourceLanguage + "..............." + sourceText);
                Log.e("MainActivityApp", "TranslatedText.............................." + targetLanguage + "............" + translation.getTranslatedText());
            }
        }).start();
    }

    public static void testTranslateTextWithModel() {
        // [START translate_text_with_model]
        RemoteTranslateHelper helper = RemoteTranslateHelper.create();
        translate = helper.getOptions().getService();

        Translation translation =
                translate.translate(
                        "Hola Mundo!",
                        Translate.TranslateOption.sourceLanguage("es"),
                        Translate.TranslateOption.targetLanguage("de"),
                        // Use "base" for standard edition, "nmt" for the premium model.
                        Translate.TranslateOption.model("nmt"));

        System.out.printf("TranslatedText:\nText: %s\n", translation.getTranslatedText());
    }
}
