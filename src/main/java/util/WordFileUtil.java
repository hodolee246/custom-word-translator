package util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WordFileUtil {

    private final static String WORD_FILE_NAME = "customwordtranslator.txt";

    public static void createSettingFile() {
        File rootLocationFolder = new File(getRootPath());

        try {
            if (! rootLocationFolder.exists()) {
                if (rootLocationFolder.mkdir()) {
                    createWordFile(rootLocationFolder);
                }
            } else {
                createWordFile(rootLocationFolder);
            }
        } catch (IOException ignored) {}
    }

    public static String getRootPath() {
        return System.getProperty("user.home") + System.getProperty("file.separator") + ".customwordtranslator";
    }

    private static void createWordFile(File rootLocationFolder) throws IOException {
        File wordFile = new File(rootLocationFolder, WORD_FILE_NAME);

        if (! wordFile.exists()) {
            wordFile.createNewFile();
            insertInitData(wordFile);
        }
    }

    private static void insertInitData(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(WORD_INIT_DATA);
            writer.flush();
        } catch (IOException ignored) {}
    }

    public static String getWordInitData() {
        return WORD_INIT_DATA;
    }

    private final static String WORD_INIT_DATA = "BIGINT\tbseq\n" +
            "ID\tid\n" +
            "IP\tip\n" +
            "OS\tos\n" +
            "co2\tco2\n" +
            "cooldown\tcooldown\n" +
            "ec\tec\n" +
            "faq\tfaq\n" +
            "heatup\theatup\n" +
            "lee\tlee\n" +
            "pband\tpband\n" +
            "ph\tph\n" +
            "가로\twidth\n" +
            "가상\tvirtl\n" +
            "가중치\twghtval\n" +
            "각도\tangle\n" +
            "간격\tintv\n" +
            "감점\tdmrtr\n" +
            "값\tval\n" +
            "강사\tinstrctr\n" +
            "강우\train\n" +
            "강의\tlctre\n" +
            "개요\tsumry\n" +
            "개인\tindvdl\n" +
            "개화\tblmng\n" +
            "건구\tdry\n" +
            "건조\tdry\n" +
            "검색\tsearch\n" +
            "게시\tpst\n" +
            "게시물\tpost\n" +
            "게시판\tbrd\n" +
            "결과\tresult\n" +
            "결로\tcond\n" +
            "경간\tspan\n" +
            "경고\twarn\n" +
            "경도\tlngi\n" +
            "경로\tpath\n" +
            "경영\tmngmt\n" +
            "계산\tcalc\n" +
            "고장\tdefect\n" +
            "고정\tfixing\n" +
            "공급\tsuply\n" +
            "공휴일\thldy\n" +
            "과목\tsbject\n" +
            "과정\tcrse\n" +
            "관\tpipe\n" +
            "관리\tmanage\n" +
            "관리자\tauthory, mngr\n" +
            "관부\tcrown\n" +
            "관찰\tobserv\n" +
            "교사\ttchr\n" +
            "교육\tedc\n" +
            "구름\tcloud\n" +
            "구분\tse\n" +
            "구역\tzone\n" +
            "굵기\tthck\n" +
            "권한\tauth\n" +
            "권한자\tauthory\n" +
            "규모\tscale\n" +
            "그래프\tgraph\n" +
            "그룹\tgrop\n" +
            "급액\twtrsply\n" +
            "기간\tpd\n" +
            "기관\torgn\n" +
            "기본\tb, bass\n" +
            "기술\ttchnlgy\n" +
            "기준\tstdr\n" +
            "기타\tetc\n" +
            "길이\tlt\n" +
            "꽃\tflwr\n" +
            "난방\theating, ht\n" +
            "난방관\thp\n" +
            "난방관제어\thc\n" +
            "난이도\tdffly\n" +
            "날씨\twethr\n" +
            "낮\tdaytm\n" +
            "내림값\tfloor\n" +
            "내부\tint\n" +
            "내역\tdtls\n" +
            "내외부\tinout\n" +
            "내용\tcn\n" +
            "년\ty\n" +
            "노출\texpsr\n" +
            "노트\tnote\n" +
            "농가\tfrmhs\n" +
            "농도\tdnsty\n" +
            "농민\tfamr\n" +
            "농사\tfarmng\n" +
            "농업\tfarmng\n" +
            "농장\tfarm\n" +
            "높이\theight\n" +
            "누적\taccmlt\n" +
            "다음\tnext\n" +
            "단계\tstep\n" +
            "단위\tunit\n" +
            "닫힘\tclose\n" +
            "담당\tchrg\n" +
            "담당자\tcharger\n" +
            "담임\thomeroom\n" +
            "답변\tanswer\n" +
            "당\tsgr\n" +
            "대\tl\n" +
            "대기\twait\n" +
            "대기압\tap\n" +
            "대상\ttrgt\n" +
            "댓글\trply\n" +
            "데이터\tdata\n" +
            "도\tdo\n" +
            "도메인\tdomn\n" +
            "도움말\thpcm\n" +
            "도입\tindc\n" +
            "도전\tchlng\n" +
            "도표\tchrt\n" +
            "동시\tsmtm\n" +
            "동영상\tmvp\n" +
            "동작\tmotn\n" +
            "동파\tfrzbur\n" +
            "등급\tgrad\n" +
            "등록\treg\n" +
            "디폴트\tdflt\n" +
            "라인\tline\n" +
            "랭킹\trankng\n" +
            "량\tsola\n" +
            "레벨\tlevel\n" +
            "로그인\tlgn\n" +
            "로딩\tldadng\n" +
            "링크\tlink, url\n" +
            "마디\tnode\n" +
            "만료\texp\n" +
            "만족도\tsatsfc\n" +
            "매년\teveyr\n" +
            "매뉴얼\tmnl\n" +
            "매출금액\tmd\n" +
            "메뉴\tmenu\n" +
            "메인\tmain\n" +
            "메일\temail\n" +
            "면적\tar\n" +
            "명\tnm\n" +
            "모바일\tmobile\n" +
            "목적\tpurps\n" +
            "목표\tgoal\n" +
            "문의\tinqry\n" +
            "문자메시지\tsms\n" +
            "문제\tques\n" +
            "물\twater\n" +
            "미세조정\tfinetune\n" +
            "미션\tmisn\n" +
            "밀도\tdn\n" +
            "바람\twind\n" +
            "반\tclass\n" +
            "반복\treptit\n" +
            "발급\tissu\n" +
            "발생\toccrrnc\n" +
            "밤\tnighttm\n" +
            "방법\tmth\n" +
            "방식\tmthd\n" +
            "방지\tprvn\n" +
            "방향\tdrc\n" +
            "배지\tclturmd\n" +
            "배치\tbatch\n" +
            "밸브\tvalve\n" +
            "밸브제어\tvc\n" +
            "뱃지\tbadge\n" +
            "번호\tno\n" +
            "범위\tscope\n" +
            "법인대표자\tceo\n" +
            "변경\tchage\n" +
            "병충해\tdlthts\n" +
            "보고서\trport\n" +
            "보광\tsplemntllght\n" +
            "보상\treward\n" +
            "보온\twarm\n" +
            "보정\trevisn\n" +
            "보호\tprtc\n" +
            "복합\tcmpnd\n" +
            "복호화\tdec\n" +
            "부모\tparnts\n" +
            "부여\talwnc\n" +
            "분\tmi\n" +
            "분류\tcls\n" +
            "분무\tmist, spray\n" +
            "분석\tanals\n" +
            "비\train\n" +
            "비교\tcmpr\n" +
            "비례\tprport\n" +
            "비밀번호\tpswd\n" +
            "비율\trate\n" +
            "사업\tbsns\n" +
            "사역대\tdeadzone\n" +
            "사용\tuse\n" +
            "사용자\tuser\n" +
            "사유\tresn\n" +
            "사이즈\tsize\n" +
            "사전\tdic\n" +
            "사진기\tcamera\n" +
            "삭제\tdel\n" +
            "산\tacid\n" +
            "산도\tacdt\n" +
            "상단\tupend\n" +
            "상대\trl\n" +
            "상대습도\trh\n" +
            "상부\ttop\n" +
            "상세\td, detail\n" +
            "상위\tupper\n" +
            "상태\tsttus\n" +
            "생리\tpysiclg\n" +
            "생산\tprdctn\n" +
            "생육\tgrth\n" +
            "생일\tbrthdy\n" +
            "생장\tgrth\n" +
            "서브\tsub\n" +
            "선생님\ttchr\n" +
            "선택\tsel\n" +
            "설명\tds\n" +
            "설정\tsetup\n" +
            "설치\tinstl\n" +
            "세대\tgnr\n" +
            "세부제어\tdc\n" +
            "센서\tsensor\n" +
            "셀\tcell\n" +
            "소\ts\n" +
            "소속\tblng\n" +
            "속도\tsped\n" +
            "수\tcnt\n" +
            "수강\tatnlc\n" +
            "수량\tquan\n" +
            "수신\trecptn\n" +
            "수정\tupdt\n" +
            "수증기포화압\twsp\n" +
            "수집\tcolct\n" +
            "수치\tncl\n" +
            "수행\texc\n" +
            "수확\thrvst\n" +
            "순번\tsn\n" +
            "순서\tordr\n" +
            "스위치\tswitch\n" +
            "슬라브\tslab\n" +
            "습구\twet\n" +
            "습도\thmdt\n" +
            "습도부족분\thd\n" +
            "시\thr\n" +
            "시간\ttime, tm\n" +
            "시간대\ttmzon\n" +
            "시구\tsigu\n" +
            "시군\tsigun\n" +
            "시군구\tsigngu\n" +
            "시나리오\tsenario\n" +
            "시뮬레이션\tsmlt\n" +
            "시설\tfclty\n" +
            "시스템\tsys\n" +
            "시작\tstart\n" +
            "식물\tplnt\n" +
            "실습\tprct\n" +
            "실시간\ttime, tm\n" +
            "썸네일\tthmb\n" +
            "쓰기\twrt\n" +
            "아래쪽\tbot\n" +
            "아이디\tid\n" +
            "아이콘\ticon\n" +
            "아이피\tip\n" +
            "알고리즘\talgr\n" +
            "알림\tntcn\n" +
            "암호\tpswd\n" +
            "암호화\tenc\n" +
            "앞\tpre\n" +
            "약관\tstplat\n" +
            "약어\tabr\n" +
            "양\tamt\n" +
            "양식\tform\n" +
            "양액\tntrntslutn\n" +
            "업데이트\tupdt\n" +
            "업체\tentrps\n" +
            "에너지\tenergy\n" +
            "에러\terr\n" +
            "여부\tyn\n" +
            "역량\tability\n" +
            "연계\tcntc\n" +
            "연관\trelate\n" +
            "연도\tyear\n" +
            "연동\tintrlck\n" +
            "연속\tctnu\n" +
            "연습\tprct\n" +
            "연차\tanl\n" +
            "열람\treadng\n" +
            "열림\topen\n" +
            "열매\tfrt\n" +
            "엽\tleaf\n" +
            "엽병\tpetiole\n" +
            "영농\tfarmng\n" +
            "영문\teng\n" +
            "영상\tvido\n" +
            "영향\taffc\n" +
            "오답\ticrct\n" +
            "오류\terr\n" +
            "오프셋\toffst\n" +
            "온도\ttemp\n" +
            "온실\tgrenhous\n" +
            "올림값\tround\n" +
            "완료\tcompt\n" +
            "외기온도\toutTemp\n" +
            "외부\text\n" +
            "요소\tfactor\n" +
            "요청\trequst\n" +
            "용마루\trdgroof\n" +
            "용어\tword\n" +
            "우편번호\tzip\n" +
            "운영체제\tos\n" +
            "원본\torg\n" +
            "원시\torg\n" +
            "월\tm, mt\n" +
            "월일\tpolicy\n" +
            "위도\tlati\n" +
            "위력\tpowr\n" +
            "위치\tlc\n" +
            "유동\tflow\n" +
            "유동팬\tcirclfan\n" +
            "유형\ttype\n" +
            "유효\tvalid\n" +
            "의사소통\tcmnct\n" +
            "이격\tgap\n" +
            "이랑\trdgfu\n" +
            "이러닝\telrnng\n" +
            "이력\thist\n" +
            "이력서\tresume\n" +
            "이론\ttheory\n" +
            "이미지\timg\n" +
            "이슬점온도\tdp\n" +
            "이전\tbfe\n" +
            "인증\tcrtfc\n" +
            "일\td\n" +
            "일련번호\tbseq, seq\n" +
            "일몰\tsunset\n" +
            "일사\tsola\n" +
            "일시\tdtm\n" +
            "일일\tdail\n" +
            "일자\tdt\n" +
            "일출\tsunrise\n" +
            "일출일몰\tsun\n" +
            "일평균\tdyrg\n" +
            "읽기\tread\n" +
            "임무\tmisn\n" +
            "임시\ttmp\n" +
            "입력\tinput\n" +
            "잎\tleaf\n" +
            "자료\tdta\n" +
            "작기\tcrpsn\n" +
            "작동\tfnctng\n" +
            "작물\tcrops\n" +
            "작성\twritng\n" +
            "작업\topert\n" +
            "장\thed\n" +
            "장비\teqpmn\n" +
            "장애\ttrobl\n" +
            "재\tre\n" +
            "재배\tctvt\n" +
            "재배형태\tcltv\n" +
            "재식\tplntng\n" +
            "저작권\tcpyrht\n" +
            "적심\ttoppng\n" +
            "적용\tapplc\n" +
            "전체\tall\n" +
            "전화\ttel\n" +
            "전화기\tphone\n" +
            "전화번호\ttelno\n" +
            "절대\tab\n" +
            "절대습도\tah\n" +
            "점수\tscore\n" +
            "접속\tconect\n" +
            "정답\tcnsr\n" +
            "정도\tcntn\n" +
            "정렬\torder\n" +
            "정보\tinfo\n" +
            "정식\tpltng\n" +
            "정지\tstop\n" +
            "정책\tlmtt\n" +
            "제목\ttitle\n" +
            "제어\tctrl\n" +
            "제어기\tcntlr\n" +
            "제한\tlmtt\n" +
            "조건\tcnd\n" +
            "조원\tmber\n" +
            "조절\tadjst\n" +
            "조직\torgn\n" +
            "조회\tview\n" +
            "존재\texists\n" +
            "종료\tend\n" +
            "종류\tknd\n" +
            "종업원\templ\n" +
            "종자\tseed\n" +
            "종합\tgnrlz\n" +
            "주\tweek\n" +
            "주기\tcycle\n" +
            "주소\tadr\n" +
            "주야\tdght\n" +
            "주야간온도차\tdif\n" +
            "주요\tmain\n" +
            "주의\tattn\n" +
            "줄기\tstem\n" +
            "중\tm\n" +
            "증가\tincrs\n" +
            "증명\tproof\n" +
            "증발\tevprt\n" +
            "증산\ttrns\n" +
            "지붕\trf\n" +
            "지역\tarea\n" +
            "지연\tdelay\n" +
            "지원\tsport\n" +
            "지침\tmanual\n" +
            "직경\tdm\n" +
            "진척\tprgs\n" +
            "진행\tprogrs\n" +
            "질문\tqestn\n" +
            "차감\tddct\n" +
            "차광\tshade\n" +
            "차단\tintrcp\n" +
            "차시\thour\n" +
            "차이\tdiff\n" +
            "착과\tfruit\n" +
            "참고\trefer\n" +
            "처음\tfrst\n" +
            "천장\ttop\n" +
            "천창\ttop\n" +
            "체적\tvl\n" +
            "체크\tchk\n" +
            "초\tsecnd\n" +
            "초기화\tinitl\n" +
            "초세\tpltvigor\n" +
            "총합\ttot\n" +
            "최고\thgh\n" +
            "최근\trecent\n" +
            "최대\tmax\n" +
            "최소\tmin\n" +
            "최저\tlow\n" +
            "최저부\tbot\n" +
            "최종\tfnl\n" +
            "최초\tfrst\n" +
            "추천\trecomend\n" +
            "출력\toutpt\n" +
            "출석\tatend\n" +
            "측면\tsd\n" +
            "측정\tmeas\n" +
            "카테고리\tctgr\n" +
            "커뮤니티\tcmmnty\n" +
            "커튼\tcurtain\n" +
            "컨설턴트\tcnstnt\n" +
            "컨설팅\tcnsl\n" +
            "컨텐츠\tcntnts\n" +
            "코드\tcd, code\n" +
            "퀴즈\tquiz\n" +
            "키\tkey\n" +
            "키워드\tkwrd\n" +
            "타입\ttype\n" +
            "텍스트\ttext\n" +
            "토론\tdscsn\n" +
            "통\tpipe\n" +
            "통계\tstats\n" +
            "통신\tcomm\n" +
            "트리\ttr\n" +
            "특별\tspecl\n" +
            "팁\ttip\n" +
            "파이프\tpipe\n" +
            "파일\tfile\n" +
            "판매\tsale\n" +
            "팝업\tpopup\n" +
            "팬\tfan\n" +
            "펌프제어\tpc\n" +
            "페이지\tpage\n" +
            "편차\tdcln\n" +
            "평가\tevl\n" +
            "평균\tavg\n" +
            "포맷\tfrmat\n" +
            "포인트\tpoint\n" +
            "포화수분함량\tsmc\n" +
            "포화수증기량\tsmc\n" +
            "포화습도비\tshr\n" +
            "폭\tbt\n" +
            "표본\tsample\n" +
            "표준\tstd\n" +
            "품목\titem\n" +
            "품종\tvrit\n" +
            "풍\twind\n" +
            "풍속\tws\n" +
            "프로그램\tprgrm\n" +
            "프로세스\tprocs\n" +
            "하부\tbot\n" +
            "하위\tlwprt\n" +
            "학과\tdept\n" +
            "학교\tschul\n" +
            "학급\tclass\n" +
            "학년\tgrade\n" +
            "학력\tacdmcr\n" +
            "학생\tstdn\n" +
            "학습\tlrnng\n" +
            "학적\tsknrgs\n" +
            "합\tsum\n" +
            "항목\tiem\n" +
            "해발고도\taltitude\n" +
            "해설\texplna\n" +
            "해제\trelis\n" +
            "현장\tspt\n" +
            "현재\tcurr\n" +
            "현황\tsttus\n" +
            "호스트\thost\n" +
            "홈페이지\thmpg\n" +
            "화방\tfclustr\n" +
            "확률\trpblty\n" +
            "확인\tcnfirm\n" +
            "확장자\textsn\n" +
            "환경\tenvrn\n" +
            "환기\tventl\n" +
            "활동\tact\n" +
            "회사\tcmpny\n" +
            "회차\ttme\n" +
            "획득\tobtain\n" +
            "횟수\tcnt\n" +
            "휴대전화번호\tmoblphono\n" +
            "희망\thope\n";

}
