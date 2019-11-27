package kr.noegul.android.noeguluniv.dialog;

import android.app.Activity;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;

import kr.noegul.android.noeguluniv.NeogulUnivApp;
import kr.noegul.android.noeguluniv.course.Course;
import kr.noegul.android.noeguluniv.course.comparecoins.CompareCoinsActivity;
import kr.noegul.android.noeguluniv.course.countblocks.CountBlocksActivity;
import kr.noegul.android.noeguluniv.course.matchthepicture.MatchThePictureActivity;
import kr.noegul.android.noeguluniv.course.remembercards.RememberCardsActivity;
import kr.noegul.android.noeguluniv.player.PlayerData;

public class Scripts {
    public static final int TUTORIAL = 0;
    public static final int START_COMPARE_COINS = 1;
    public static final int START_MATCH_THE_PICTURE = 2;
    public static final int START_COUNT_BLOCKS = 3;
    public static final int START_REMEMBER_CARDS = 4;
    public static final int START_GRADUATE_EXAM = 5;
    public static final int FAIL_GRADUATE_EXAM = 6;
    public static final int PASS_GRADUATE_EXAM = 7;
    private static final Map<Integer, Script> scriptMap = new HashMap<>();

    private Scripts() {
    }

    static {
        scriptMap.put(TUTORIAL, new Script.Builder()
                .putSpeech("뇌굴교수", "크흠흠")
                .putSpeech("뇌굴교수", "새내기 여러분\n" +
                        "뇌굴 대학에 오신것을 환영해요")
                .putSpeech("뇌굴교수", "뇌굴 새내기 여러분들은 뇌굴 대학에 입학하기 위해")
                .putSpeech("뇌굴교수", "저어기 뭐냐... 그..\n" +
                        "입학 시험이란 걸 봐야합니다")
                .putSpeech("뇌굴교수", "갑작스런 시험이지만 그래도 저는 여러분들이 잘 풀어줄 것이라 믿습니다")
                .putSpeech("뇌굴교수", "왜냐면 여러분은..\n" +
                        "지금 '개 강'하니깐!")
                .putSpeech("뇌굴교수", "껄-껄")
                .putSpeech("뇌굴교수", "그럼 시험을 시작하겠습니다\n" +
                        "제한시간은 강의 당 1분이고 조기 퇴실은 없습니다")
                .putSpeech("뇌굴교수", "성적에는 안 들어가지만 열심히 풀도록 하세요")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        PlayerData playerData = NeogulUnivApp.getInstance().getPlayerData();
                        playerData.setPlayedTutorial(true);
                    }
                })
                .build());

        scriptMap.put(START_COMPARE_COINS, new Script.Builder()
                .putSpeech("뇌굴교수", "동전 비교는 두 선택지 중 더 큰 금액을 갖는 쪽을 택하는 수업이겠어요.")
                .putSpeech("뇌굴교수", "제한시간은 1분.\n결'코 인'기있는 과목은 아니지만 힘내들. 껄-껄")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        Intent intent = new Intent(activity, CompareCoinsActivity.class);
                        activity.startActivity(intent);
                    }
                })
                .build());

        scriptMap.put(START_MATCH_THE_PICTURE, new Script.Builder()
                .putSpeech("뇌굴교수", "같은 그림 찾기는 여러 개의 과일 그림 중 같은 거 두 개 골라내는 수업이에요.")
                .putSpeech("뇌굴교수", "제한시간은 1분.\n꽤나 헷갈릴 '수 박'에 없을 껄? 껄-껄")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        Intent intent = new Intent(activity, MatchThePictureActivity.class);
                        activity.startActivity(intent);
                    }
                })
                .build());

        scriptMap.put(START_COUNT_BLOCKS, new Script.Builder()
                .putSpeech("뇌굴교수", "블록 세기 정도는 알지? 나이가 몇인데. 블록이 몇 갠지 세면 돼.")
                .putSpeech("뇌굴교수", "제한시간은 1분.\n그나저나 자꾸 과일만 봤더니, 뭘 안 먹어도 배'블록'.. 껄-껄")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        Intent intent = new Intent(activity, CountBlocksActivity.class);
                        activity.startActivity(intent);
                    }
                })
                .build());

        scriptMap.put(START_REMEMBER_CARDS, new Script.Builder()
                .putSpeech("뇌굴교수", "이번 수업에선 주어진 과일 카드들을 기억해 맞추기만 하면 됩니다.")
                .putSpeech("뇌굴교수", "제한시간은 1분.\n이'참외' 기억력을 시험해봐요~ 껄-껄")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        Intent intent = new Intent(activity, RememberCardsActivity.class);
                        activity.startActivity(intent);
                    }
                })
                .build());

        scriptMap.put(START_GRADUATE_EXAM, new Script.Builder()
                .putSpeech("뇌굴교수", "음, 뭐. 졸업을 하고싶다고?")
                .putSpeech("뇌굴교수", "어디보자..\n용캐 요건은 다 맞췄네")
                .putSpeech("뇌굴교수", "졸업 시험만 잘 보면 졸업 할 수 있겠네.\n준비는 됐지?")
                .putSpeech("뇌굴교수", "지금까지 치른 네 가지 시험을 무작위 순서로 보게 될거야")
                .putSpeech("뇌굴교수", "평균이 B+ 이상만 나온다면 합격")
                .putSpeech("뇌굴교수", "물론 보통은 그러질 못 해서 '그 강'을 건너게 되지..")
                .putSpeech("뇌굴교수", "'재수강'말이야.")
                .putSpeech("뇌굴교수", "껄-껄")
                .putSpeech("뇌굴교수", "그럼 시험 시작")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        NeogulUnivApp game = NeogulUnivApp.getInstance();
                        game.startGraduateExam();

                        Intent intent = new Intent(activity, DialogActivity.class);

                        int scriptNum = getCourseScriptNum(game.getOngoingExam().getCurrentCourse());
                        intent.putExtra("script-num", scriptNum);
                        activity.startActivity(intent);
                    }
                })
                .build());

        scriptMap.put(FAIL_GRADUATE_EXAM, new Script.Builder()
                .putSpeech("뇌굴교수", "하하하")
                .putSpeech("뇌굴교수", "쉽지 않지?")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        /* Do nothing */
                    }
                })
                .build());

        scriptMap.put(PASS_GRADUATE_EXAM, new Script.Builder()
                .putSpeech("뇌굴교수", "졸업 시험 성공 스크립트입니다.")
                .setOnDialogEndListener(new OnDialogEndListener() {
                    @Override
                    public void onDialogEnd(Activity activity) {
                        /* Do nothing */
                    }
                })
                .build());
    }

    public static Script findScript(int scriptNum) {
        if (!scriptMap.containsKey(scriptNum))
            throw new IllegalStateException("Invalid script number");

        return scriptMap.get(scriptNum);
    }

    public static int getCourseScriptNum(Course course) {
        switch (course) {
            case COMPARE_COINS:
                return START_COMPARE_COINS;
            case MATCH_THE_PICTURE:
                return START_MATCH_THE_PICTURE;
            case COUNT_BLOCKS:
                return START_COUNT_BLOCKS;
            case REMEMBER_CARDS:
                return START_REMEMBER_CARDS;
            default:
                throw new IllegalArgumentException("Invalid course");
        }
    }
}
