package englishmuffin.example.com.englishmuffin;

import android.provider.MediaStore;

public class Words {


    private String word;
    private String define;
    private MediaStore.Audio sound;

    public Words(String word, String define) {
        this.word = word;
        this.define = define;
    }

    public Words(String word, String define, MediaStore.Audio sound) {
        this.word = word;
        this.define = define;
        this.sound = sound;
    }

    public String getWord() {
        return word;
    }

    public String getDefine() {
        return define;
    }

    public MediaStore.Audio getSound() {
        return sound;
    }


}
