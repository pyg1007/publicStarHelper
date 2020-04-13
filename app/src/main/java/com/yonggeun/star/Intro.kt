package com.yonggeun.star

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yonggeun.become_star.R
import com.yonggeun.star.room.Colleague
import com.yonggeun.star.room.ColleagueViewModel

class Intro : AppCompatActivity() {

    var nextActivityHandler : NextActivityHandler? = null
    var sharedPreferences : SharedPreferences? = null
    private lateinit var model: ColleagueViewModel
    private var thread : Thread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        model = ViewModelProvider(this).get(ColleagueViewModel::class.java)

        nextActivityHandler = NextActivityHandler()
        sharedPreferences = getSharedPreferences("First_Start", 0)

        thread = ThreadClass()
        (thread as ThreadClass).start()
    }

    inner class ThreadClass : Thread(){
        override fun run() {
            SystemClock.sleep(3000)
            val check : Boolean = sharedPreferences!!.getBoolean("First", true)

            if (check){
                first()
                sharedPreferences!!.edit().putBoolean("First", false).apply()
                nextActivityHandler?.sendEmptyMessage(1000)
            }else
                nextActivityHandler?.sendEmptyMessage(1000)
        }
    }

    private fun first(){
        //TODO : 초월 Transcendence 패왕 Defeat 신위 Deity
        model.insert(
            Colleague(
                "Warrior",
                "Transcendence",
                "그람왕",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Deity",
                "호루스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Transcendence",
                "크로노스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Deity",
                "러스트",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Defeat",
                "지크프리드",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Defeat",
                "아이사",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Deity",
                "로크",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Warrior",
                "Transcendence",
                "스톰베어",
                "초월",
                0
            )
        )

        model.insert(
            Colleague(
                "Samurai",
                "Transcendence",
                "그라엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Transcendence",
                "데스크라운",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Deity",
                "프라이드",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Defeat",
                "클레이",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Deity",
                "하츠헬싱",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Defeat",
                "리",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Deity",
                "세트",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Transcendence",
                "디오네",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Deity",
                "라그나로크",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Deity",
                "에르헨",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Defeat",
                "반",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Samurai",
                "Transcendence",
                "쉐도우하울",
                "초월",
                0
            )
        )

        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "윈드러너",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Defeat",
                "이실리엔",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Defeat",
                "이온",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Deity",
                "바이올렛리스크",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Defeat",
                "롤로노아",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Defeat",
                "시즈",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "셀레네",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "히페리온",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Deity",
                "누트",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "에로우티거",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Deity",
                "타나토스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Deity",
                "라스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "폴라트레이시",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "블러드윈드",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Archer",
                "Transcendence",
                "리우엘",
                "초월",
                0
            )
        )

        model.insert(
            Colleague(
                "Priests",
                "Transcendence",
                "마나랜디",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Transcendence",
                "파라엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Transcendence",
                "페르세스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Deity",
                "시바",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Deity",
                "블레이즈이터",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Defeat",
                "챈",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Deity",
                "엔비",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Defeat",
                "나이아",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Transcendence",
                "테티스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Transcendence",
                "메르세데스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Defeat",
                "앤",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Defeat",
                "뷔네타",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Deity",
                "이시스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Transcendence",
                "블랙헤븐",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Priests",
                "Defeat",
                "알레리아",
                "패왕",
                0
            )
        )

        model.insert(
            Colleague(
                "Wizard",
                "Deity",
                "글러트니",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Defeat",
                "벨다",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Defeat",
                "랑랑",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Transcendence",
                "레아",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Defeat",
                "다르칸",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Deity",
                "퍼스트크라운",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Transcendence",
                "터크",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Deity",
                "메르엔",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Defeat",
                "제인",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Transcendence",
                "프로메테우스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Transcendence",
                "피요엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Defeat",
                "세이",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Transcendence",
                "화이트헬",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Deity",
                "모르가나",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Transcendence",
                "블리즈폭시",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Wizard",
                "Deity",
                "하토르",
                "ARCH",
                0
            )
        )

        model.insert(
            Colleague(
                "thief",
                "Deity",
                "티르",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Defeat",
                "아슈레이",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "루시엔",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Defeat",
                "크리스토퍼",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "아틀라스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Deity",
                "아누비스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Deity",
                "슬로스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "미유MK5",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Deity",
                "게브",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "마카엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "그레이소울",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "헬호크",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Defeat",
                "인헤리",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Defeat",
                "카이헨",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "thief",
                "Transcendence",
                "크리오스",
                "초월",
                0
            )
        )

        model.insert(
            Colleague(
                "Paladin",
                "Defeat",
                "테레나스",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Transcendence",
                "카미엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Transcendence",
                "헬리오스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Defeat",
                "애시",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Transcendence",
                "드렁큰팔콘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Deity",
                "오시리스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Transcendence",
                "모모",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Deity",
                "블리즈 더 윈터",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Defeat",
                "티히",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Transcendence",
                "티엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Paladin",
                "Deity",
                "아스크",
                "ARCH",
                0
            )
        )

        model.insert(
            Colleague(
                "Summoner",
                "Deity",
                "그리드",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Deity",
                "샤샤",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Transcendence",
                "마그리트",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Defeat",
                "아린",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Deity",
                "네프티스",
                "ARCH",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Transcendence",
                "메티스",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Defeat",
                "라스테아",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Defeat",
                "제르엘",
                "패왕",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Transcendence",
                "벨스노우",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Transcendence",
                "리브가엘",
                "초월",
                0
            )
        )
        model.insert(
            Colleague(
                "Summoner",
                "Deity",
                "엘",
                "ARCH",
                0
            )
        )
    }

    @SuppressLint("HandlerLeak")
    inner class NextActivityHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.what == 1000){
                val intent = Intent(this@Intro, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onBackPressed() {

    }

    override fun onDestroy() {
        if(thread!!.isAlive)
            thread!!.interrupt()
        super.onDestroy()
    }
}
