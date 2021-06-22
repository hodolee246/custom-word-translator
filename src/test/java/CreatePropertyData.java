import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jeon InWoo
 */
public class CreatePropertyData {
    /* regex */
    private final String SPACE = " ";
    private final String EMPTY_STR = "";
    private final String COMMA = ",";
    private final String NEW_LINE = System.getProperty("line.separator");
    private final String NEW_LINE2 = "\n";
    private final String OPEN_PARENTHESIS = "\\(";
    private final String CLOSE_PARENTHESIS = "\\)";
    private final String TAB = "\t";
    private final String EQUALS = "=";
    private final String VALUE_DOT = "value.";
    private final String TAB_ALL_TAB = "\t.+\t";
    private final String AT_THE_FRONT = "^([^\b]+)";

    private String keyData = "co2\n" +
            "cool down\n" +
            "faq\n" +
            "heat up\n" +
            "ID\n" +
            "lee\n" +
            "pband\n" +
            "가로\n" +
            "각도\n" +
            "간격\n" +
            "값\n" +
            "강우, 비\n" +
            "개화\n" +
            "건조, 건구\n" +
            "게시물\n" +
            "게시판\n" +
            "경간\n" +
            "경고\n" +
            "경도\n" +
            "경로\n" +
            "계산\n" +
            "고장\n" +
            "공급\n" +
            "관, 파이프, 통\n" +
            "구분\n" +
            "구역\n" +
            "권한\n" +
            "권한자(관리자)\n" +
            "그룹\n" +
            "그룹\n" +
            "급액\n" +
            "기간\n" +
            "기본\n" +
            "기타\n" +
            "길이\n" +
            "난방\n" +
            "난방\n" +
            "난방관\n" +
            "난방관제어\n" +
            "날씨\n" +
            "낮\n" +
            "내림값\n" +
            "내부\n" +
            "내외부\n" +
            "설명\n" +
            "년\n" +
            "농도\n" +
            "농민\n" +
            "높이\n" +
            "누적\n" +
            "단계\n" +
            "단위\n" +
            "닫힘\n" +
            "담당자\n" +
            "답변\n" +
            "당\n" +
            "대\n" +
            "대기\n" +
            "대상\n" +
            "댓글\n" +
            "도표\n" +
            "동시\n" +
            "동작\n" +
            "동파\n" +
            "등급\n" +
            "등록\n" +
            "로그인\n" +
            "링크\n" +
            "만족도\n" +
            "메뉴\n" +
            "메일\n" +
            "면적\n" +
            "명\n" +
            "목표\n" +
            "문자메시지\n" +
            "물\n" +
            "미세 조정\n" +
            "바람, 풍\n" +
            "밤\n" +
            "방식\n" +
            "방지\n" +
            "방향\n" +
            "밸브\n" +
            "밸브제어\n" +
            "번호\n" +
            "범위\n" +
            "법인대표자\n" +
            "변경\n" +
            "보고서\n" +
            "보상\n" +
            "보온\n" +
            "보정\n" +
            "보호\n" +
            "복호화\n" +
            "부모\n" +
            "분\n" +
            "분류\n" +
            "분무\n" +
            "비례\n" +
            "비율\n" +
            "사업\n" +
            "사역대\n" +
            "사용\n" +
            "사용자\n" +
            "사이즈\n" +
            "사진기\n" +
            "삭제\n" +
            "산\n" +
            "산도\n" +
            "상대\n" +
            "상대습도\n" +
            "상세\n" +
            "상위\n" +
            "상태, 현황\n" +
            "생산\n" +
            "생육, 생장\n" +
            "정렬\n" +
            "선택\n" +
            "설정\n" +
            "세부제어\n" +
            "센서\n" +
            "셀\n" +
            "소\n" +
            "소속\n" +
            "속도\n" +
            "수, 횟수\n" +
            "수량\n" +
            "수신\n" +
            "수정, 업데이트\n" +
            "수증기포화압\n" +
            "수집\n" +
            "수치\n" +
            "수확\n" +
            "일련번호\n" +
            "스위치\n" +
            "슬라브\n" +
            "습구\n" +
            "습도\n" +
            "습도부족분\n" +
            "시\n" +
            "시간\n" +
            "시간\n" +
            "시뮬레이션\n" +
            "시스템\n" +
            "시작\n" +
            "실습, 연습\n" +
            "썸네일\n" +
            "쓰기\n" +
            "아이피, IP\n" +
            "알고리즘\n" +
            "알림\n" +
            "암호, 비밀번호\n" +
            "암호화\n" +
            "앞\n" +
            "양\n" +
            "양식\n" +
            "에러, 오류\n" +
            "여부\n" +
            "연속\n" +
            "열림\n" +
            "영농, 농업, 농사\n" +
            "영향\n" +
            "엽, 잎\n" +
            "오프셋\n" +
            "온도\n" +
            "온실\n" +
            "올림값\n" +
            "외기온도\n" +
            "외부\n" +
            "요소\n" +
            "용마루\n" +
            "우편번호\n" +
            "운영체제, OS\n" +
            "원본, 원시\n" +
            "월\n" +
            "위도\n" +
            "위력\n" +
            "위치\n" +
            "유동\n" +
            "유형, 타입\n" +
            "의사소통\n" +
            "이격\n" +
            "이랑\n" +
            "이력\n" +
            "이론\n" +
            "이미지\n" +
            "이전\n" +
            "인증\n" +
            "일\n" +
            "일몰\n" +
            "일사(량)\n" +
            "일시\n" +
            "일일\n" +
            "일자\n" +
            "일출\n" +
            "일출일몰\n" +
            "일평균\n" +
            "읽기\n" +
            "임시\n" +
            "작동\n" +
            "작물\n" +
            "장비\n" +
            "재배\n" +
            "재배형태\n" +
            "적용\n" +
            "전화\n" +
            "전화기\n" +
            "절대\n" +
            "절대습도\n" +
            "정도\n" +
            "정보\n" +
            "정지\n" +
            "제목\n" +
            "제어\n" +
            "제어기\n" +
            "조직, 기관\n" +
            "존재\n" +
            "종료\n" +
            "종업원\n" +
            "종자\n" +
            "주기\n" +
            "주소\n" +
            "주야간 온도차\n" +
            "주요, 메인\n" +
            "주의\n" +
            "줄기\n" +
            "중\n" +
            "증가\n" +
            "증발\n" +
            "증산\n" +
            "지붕\n" +
            "지역\n" +
            "지연\n" +
            "진척\n" +
            "질문\n" +
            "차광\n" +
            "차단\n" +
            "차이\n" +
            "착과\n" +
            "천창, 천장, 상부\n" +
            "체적\n" +
            "총합\n" +
            "최고\n" +
            "최대\n" +
            "최소\n" +
            "최저\n" +
            "최종\n" +
            "최초, 처음\n" +
            "추천\n" +
            "측면\n" +
            "측정\n" +
            "카테고리\n" +
            "코드\n" +
            "코드\n" +
            "내용\n" +
            "키\n" +
            "통신\n" +
            "파일\n" +
            "판매\n" +
            "팬\n" +
            "펌프제어\n" +
            "페이지\n" +
            "편차\n" +
            "평균\n" +
            "포화수분함량\n" +
            "포화수증기량\n" +
            "포화습도비\n" +
            "폭\n" +
            "표준\n" +
            "품종\n" +
            "풍속\n" +
            "프로세스\n" +
            "하부, 최저부, 아래쪽\n" +
            "하위\n" +
            "학습\n" +
            "합\n" +
            "해발고도\n" +
            "해제\n" +
            "현재\n" +
            "호스트\n" +
            "홈페이지\n" +
            "확률\n" +
            "확장자\n" +
            "환경\n" +
            "환기\n" +
            "활동\n" +
            "회사\n" +
            "복합\n" +
            "데이터\n" +
            "항목\n" +
            "게시\n" +
            "사전\n" +
            "영문\n" +
            "약어\n" +
            "데이터\n" +
            "전화번호\n" +
            "휴대전화번호\n" +
            "학생\n" +
            "교사,선생님\n" +
            "컨설턴트\n" +
            "서브\n" +
            "조회\n" +
            "대기압\n" +
            "이슬점온도\n" +
            "관리자\n" +
            "링크\n" +
            "만료\n" +
            "학과\n" +
            "학년\n" +
            "반(학급)\n" +
            "레벨\n" +
            "노출\n" +
            "순번\n" +
            "프로그램\n" +
            "체크\n" +
            "학적\n" +
            "연도\n" +
            "상단\n" +
            "고정\n" +
            "학교\n" +
            "발급\n" +
            "아이디\n" +
            "담당\n" +
            "문의\n" +
            "강의\n" +
            "유효\n" +
            "목적\n" +
            "장\n" +
            "토론\n" +
            "진행\n" +
            "검색\n" +
            "작업\n" +
            "열람\n" +
            "작성\n" +
            "컨설팅\n" +
            "요청\n" +
            "차시\n" +
            "자료\n" +
            "확인\n" +
            "개요\n" +
            "방법\n" +
            "과목\n" +
            "강사\n" +
            "난이도\n" +
            "연관\n" +
            "지침\n" +
            "모바일\n" +
            "순서\n" +
            "수강\n" +
            "완료\n" +
            "학력\n" +
            "생일\n" +
            "역량\n" +
            "증명\n" +
            "시나리오\n" +
            "월\n" +
            "시간대\n" +
            "평가\n" +
            "결로\n" +
            "커튼\n" +
            "에너지\n" +
            "품목\n" +
            "주\n" +
            "분석\n" +
            "화방\n" +
            "시설\n" +
            "규모\n" +
            "도입\n" +
            "작기\n" +
            "노트\n" +
            "관찰\n" +
            "병충해\n" +
            "발생\n" +
            "비교\n" +
            "주야\n" +
            "통계\n" +
            "뱃지\n" +
            "획득\n" +
            "조건\n" +
            "랭킹\n" +
            "부여\n" +
            "기준\n" +
            "포인트\n" +
            "사유\n" +
            "컨텐츠\n" +
            "재\n" +
            "점수\n" +
            "배치\n" +
            "기본\n" +
            "연동\n" +
            "상세\n" +
            "아이콘\n" +
            "미션, 임무\n" +
            "연차\n" +
            "초세\n" +
            "도전\n" +
            "경영\n" +
            "정답\n" +
            "최근\n" +
            "수행\n" +
            "다음\n" +
            "공휴일\n" +
            "반복\n" +
            "매년\n" +
            "출석\n" +
            "팝업\n" +
            "트리\n" +
            "담임\n" +
            "교육\n" +
            "과정\n" +
            "이러닝\n" +
            "동영상\n" +
            "영상\n" +
            "도움말\n" +
            "결과\n" +
            "전체\n" +
            "농장\n" +
            "로딩\n" +
            "라인\n" +
            "그래프\n" +
            "매뉴얼\n" +
            "참고\n" +
            "기술\n" +
            "지원\n" +
            "설치\n" +
            "커뮤니티\n" +
            "개인\n" +
            "저작권\n" +
            "약관\n" +
            "종합\n" +
            "내역\n" +
            "이력서\n" +
            "관리\n" +
            "디폴트\n" +
            "회차\n" +
            "실시간\n" +
            "표본\n" +
            "보광\n" +
            "분무\n" +
            "유동팬\n" +
            "양액\n" +
            "감점\n" +
            "조원\n" +
            "입력\n" +
            "출력\n" +
            "오답\n" +
            "차감\n" +
            "팁\n" +
            "가중치\n" +
            "조절\n" +
            "텍스트\n" +
            "포맷\n" +
            "용어\n" +
            "초\n" +
            "특별\n" +
            "퀴즈\n" +
            "문제\n" +
            "해설\n" +
            "정식\n" +
            "ph\n" +
            "ec\n" +
            "농가\n" +
            "엽병\n" +
            "식물\n" +
            "열매\n" +
            "마디\n" +
            "관부\n" +
            "직경\n" +
            "꽃\n" +
            "굵기\n" +
            "연계\n" +
            "키워드\n" +
            "도\n" +
            "시구\n" +
            "시군\n" +
            "시군구\n" +
            "배지\n" +
            "종류\n" +
            "재식\n" +
            "밀도\n" +
            "적심\n" +
            "업체\n" +
            "매출금액\n" +
            "월일\n" +
            "정책\n" +
            "제한\n" +
            "희망\n" +
            "생리\n" +
            "장애\n" +
            "접속\n" +
            "초기화\n" +
            "일련번호(BIGINT)\n" +
            "가상\n" +
            "도메인\n" +
            "세대\n" +
            "현장\n" +
            "구름";

    private String valueData = "co2\tco2\tco2\n" +
            "cool down\tcool down\tcooldown\n" +
            "faq\tfrequently asked question\tfaq\n" +
            "heat up\theat up\theatup\n" +
            "ID\tid\tid\n" +
            "lee\tlee\tlee\n" +
            "pband\tpband\tpband\n" +
            "가로\twidth\twidth\n" +
            "각도\tangle\tangle\n" +
            "간격\tinterval\tintv\n" +
            "값\tvalue\tval\n" +
            "강우, 비\training\train\n" +
            "개화\tblooming\tblmng\n" +
            "건조, 건구\tdryness\tdry\n" +
            "게시물\tpost\tpost\n" +
            "게시판\tboard\tbrd\n" +
            "경간\tspan\tspan\n" +
            "경고\twarning\twarn\n" +
            "경도\tlongitude\tlngi\n" +
            "경로\tpath\tpath\n" +
            "계산\tcalculation\tcalc\n" +
            "고장\tdefect\tdefect\n" +
            "공급\tsupply\tsuply\n" +
            "관, 파이프, 통\tpipe\tpipe\n" +
            "구분\tsection\tse\n" +
            "구역\tzone\tzone\n" +
            "권한\tauthority\tauth\n" +
            "권한자(관리자)\tauthority\tauthory\n" +
            "그룹\tgroup\tgrop\n" +
            "그룹\tgroup\tgrop\n" +
            "급액\twater supply\twtrsply\n" +
            "기간\tperiod\tpd\n" +
            "기본\tbase\tb\n" +
            "기타\tetc\tetc\n" +
            "길이\tlength\tlt\n" +
            "난방\theating\theating\n" +
            "난방\theating\tht\n" +
            "난방관\theating pump\thp\n" +
            "난방관제어\theating pipe control\thc\n" +
            "날씨\tweather\twethr\n" +
            "낮\tdaytime\tdaytm\n" +
            "내림값\tfloor\tfloor\n" +
            "내부\tinternal\tint\n" +
            "내외부\tin and out\tinout\n" +
            "설명\tdescription\tds\n" +
            "년\tyear\ty\n" +
            "농도\tdensity\tdnsty\n" +
            "농민\tfarmer\tfamr\n" +
            "높이\theight\theight\n" +
            "누적\taccumulate\taccmlt\n" +
            "단계\tstep\tstep\n" +
            "단위\tunit\tunit\n" +
            "닫힘\tclose\tclose\n" +
            "담당자\tporson in charge\tcharger\n" +
            "답변\tanswer\tanswer\n" +
            "당\tsugar\tsgr\n" +
            "대\tlarge\tl\n" +
            "대기\twaiting\twait\n" +
            "대상\ttarget\ttrgt\n" +
            "댓글\treply\trply\n" +
            "도표\tchart\tchrt\n" +
            "동시\tsame time\tsmtm\n" +
            "동작\tmotion\tmotn\n" +
            "동파\tfrozen to burst\tfrzbur\n" +
            "등급\tgrade\tgrad\n" +
            "등록\tregistration\treg\n" +
            "로그인\tlogin\tlgn\n" +
            "링크\tuniform resource locator\turl\n" +
            "만족도\tsatisfaction\tsatsfc\n" +
            "메뉴\tmenu\tmenu\n" +
            "메일\temail\temail\n" +
            "면적\tarea\tar\n" +
            "명\tname\tnm\n" +
            "목표\tgoal\tgoal\n" +
            "문자메시지\tshort message service\tsms\n" +
            "물\twater\twater\n" +
            "미세 조정\tfine tune\tfine tune\n" +
            "바람, 풍\twind\twind\n" +
            "밤\tnighttime\tnighttm\n" +
            "방식\tmethod\tmthd\n" +
            "방지\tprevention\tprvn\n" +
            "방향\tdirection\tdrc\n" +
            "밸브\tvalve\tvalve\n" +
            "밸브제어\tvalve control\tvc\n" +
            "번호\tnumber\tno\n" +
            "범위\tscope\tscope\n" +
            "법인대표자\tchief executive officer\tceo\n" +
            "변경\tchange\tchage\n" +
            "보고서\treport\trport\n" +
            "보상\treward\treward\n" +
            "보온\twarm\twarm\n" +
            "보정\trevision\trevisn\n" +
            "보호\tprotection\tprtc\n" +
            "복호화\tdecoding\tdec\n" +
            "부모\tparents\tparnts\n" +
            "분\tminute\tmi\n" +
            "분류\tclassification\tcls\n" +
            "분무\tspray\tspray\n" +
            "비례\tproportion\tprport\n" +
            "비율\trate\trate\n" +
            "사업\tbusiness\tbsns\n" +
            "사역대\tdeadzone\tdeadzone\n" +
            "사용\tuse\tuse\n" +
            "사용자\tuser\tuser\n" +
            "사이즈\tsize\tsize\n" +
            "사진기\tcamera\tcamera\n" +
            "삭제\tdelete\tdel\n" +
            "산\tacid\tacid\n" +
            "산도\tacidity\tacdt\n" +
            "상대\trelative\trl\n" +
            "상대습도\trelative humidity\trh\n" +
            "상세\tdetail\td\n" +
            "상위\tupper\tupper\n" +
            "상태, 현황\tstatus\tsttus\n" +
            "생산\tproduction\tprdctn\n" +
            "생육, 생장\tgrowth\tgrth\n" +
            "정렬\torder\torder\n" +
            "선택\tselection\tsel\n" +
            "설정\tsetup\tsetup\n" +
            "세부제어\tdetail control\tdc\n" +
            "센서\tsensor\tsensor\n" +
            "셀\tcell\tcell\n" +
            "소\tsmall\ts\n" +
            "소속\tbelong\tblng\n" +
            "속도\tspeed\tsped\n" +
            "수, 횟수\tcount\tcnt\n" +
            "수량\tquantity\tquan\n" +
            "수신\treception\trecptn\n" +
            "수정, 업데이트\tupdate\tupdt\n" +
            "수증기포화압\twater vapor saturation pressure\twsp\n" +
            "수집\tcollection\tcolct\n" +
            "수치\tnumeric\tncl\n" +
            "수확\tharvest\thrvst\n" +
            "일련번호\tsequence\tseq\n" +
            "스위치\tswitch\tswitch\n" +
            "슬라브\tslab\tslab\n" +
            "습구\twetness\twet\n" +
            "습도\thumidity\thmdt\n" +
            "습도부족분\thd\thd\n" +
            "시\thour\thr\n" +
            "시간\ttime\ttm\n" +
            "시간\ttime\ttime\n" +
            "시뮬레이션\tsimulation\tsmlt\n" +
            "시스템\tsystem\tsys\n" +
            "시작\tstart\tstart\n" +
            "실습, 연습\tpractice\tprct\n" +
            "썸네일\tthumbnail\tthmb\n" +
            "쓰기\twriting\twrt\n" +
            "아이피, IP\tip\tip\n" +
            "알고리즘\talgorithm\talgr\n" +
            "알림\tnotification\tntcn\n" +
            "암호, 비밀번호\tpassword\tpswd\n" +
            "암호화\tencription\tenc\n" +
            "앞\tpre\tpre\n" +
            "양\tamount\tamt\n" +
            "양식\tform\tform\n" +
            "에러, 오류\terror\terr\n" +
            "여부\talternative\tyn\n" +
            "연속\tcontinuation\tctnu\n" +
            "열림\topen\topen\n" +
            "영농, 농업, 농사\tfarming\tfarmng\n" +
            "영향\taffection\taffc\n" +
            "엽, 잎\tleaf\tleaf\n" +
            "오프셋\toffset\toffst\n" +
            "온도\ttemperature\ttemp\n" +
            "온실\tgreen house\tgren hous\n" +
            "올림값\tround\tround\n" +
            "외기온도\toutdoor temperature\toutTemp\n" +
            "외부\texternal\text\n" +
            "요소\tfactor\tfactor\n" +
            "용마루\tridge roof\trdgroof\n" +
            "우편번호\tzip code\tzip\n" +
            "운영체제, OS\toperation system\tos\n" +
            "원본, 원시\toriginal\torg\n" +
            "월\tmonth\tm\n" +
            "위도\tlatitude\tlati\n" +
            "위력\tpower\tpowr\n" +
            "위치\tlocation\tlc\n" +
            "유동\tflow\tflow\n" +
            "유형, 타입\ttype\ttype\n" +
            "의사소통\tcommunication\tcmnct\n" +
            "이격\tgap\tgap\n" +
            "이랑\tridge and furrow\trdgfu\n" +
            "이력\thistory\thist\n" +
            "이론\ttheory\ttheory\n" +
            "이미지\timages\timg\n" +
            "이전\tbefore\tbfe\n" +
            "인증\tcertification\tcrtfc\n" +
            "일\tday\td\n" +
            "일몰\tsunset\tsunset\n" +
            "일사(량)\tsolar radiation\tsola\n" +
            "일시\tdate and time\tdtm\n" +
            "일일\tdaily\tdail\n" +
            "일자\tdate\tdt\n" +
            "일출\tsunrise\tsunrise\n" +
            "일출일몰\tsunrise and sunset\tsun\n" +
            "일평균\tday average\tdyrg\n" +
            "읽기\tread\tread\n" +
            "임시\ttemporary\ttmp\n" +
            "작동\tfunctioning\tfnctng\n" +
            "작물\tcrops\tcrops\n" +
            "장비\tequipment\teqpmn\n" +
            "재배\tcultivation\tctvt\n" +
            "재배형태\tcultivation\tcltv\n" +
            "적용\tapplication\tapplc\n" +
            "전화\ttelephone\ttel\n" +
            "전화기\tphone\tphone\n" +
            "절대\tabsolute\tab\n" +
            "절대습도\tabsolute humidity\tah\n" +
            "정도\tcontent\tcntn\n" +
            "정보\tinformation\tinfo\n" +
            "정지\tstop\tstop\n" +
            "제목\ttitle\ttitle\n" +
            "제어\tcontrol\tctrl\n" +
            "제어기\tcontroller\tcntlr\n" +
            "조직, 기관\torganization\torgn\n" +
            "존재\texists\texists\n" +
            "종료\tend\tend\n" +
            "종업원\temployees\templ\n" +
            "종자\tseed\tseed\n" +
            "주기\tcycle\tcycle\n" +
            "주소\taddress\tadr\n" +
            "주야간 온도차\tdif\tdif\n" +
            "주요, 메인\tmain\tmain\n" +
            "주의\tattention\tattn\n" +
            "줄기\tstem\tstem\n" +
            "중\tmiddle\tm\n" +
            "증가\tincrease\tincrs\n" +
            "증발\tevaporation\tevprt\n" +
            "증산\ttranspiration\ttrns\n" +
            "지붕\troot\trf\n" +
            "지역\tarea\tarea\n" +
            "지연\tdelay\tdelay\n" +
            "진척\tprogress\tprgs\n" +
            "질문\tquestion\tqestn\n" +
            "차광\tshades\tshade\n" +
            "차단\tinterception\tintrcp\n" +
            "차이\tdifference\tdiff\n" +
            "착과\tfruiting\tfruit\n" +
            "천창, 천장, 상부\ttop\ttop\n" +
            "체적\tvolume\tvl\n" +
            "총합\ttotal\ttot\n" +
            "최고\thigh\thgh\n" +
            "최대\tmaximum\tmax\n" +
            "최소\tminimum\tmin\n" +
            "최저\tlow\tlow\n" +
            "최종\tfinal\tfnl\n" +
            "최초, 처음\tfirst\tfrst\n" +
            "추천\trecommend\trecomend\n" +
            "측면\tside\tsd\n" +
            "측정\tmeasurement\tmeas\n" +
            "카테고리\tcategory\tctgr\n" +
            "코드\tcode\tcode\n" +
            "코드\tcode\tcd\n" +
            "내용\tcontents\tcn\n" +
            "키\tkey\tkey\n" +
            "통신\tcommunication\tcomm\n" +
            "파일\tfile\tfile\n" +
            "판매\tsale\tsale\n" +
            "팬\tfan\tfan\n" +
            "펌프제어\tpump control\tpc\n" +
            "페이지\tpage\tpage\n" +
            "편차\tdeclination\tdcln\n" +
            "평균\taverage\tavg\n" +
            "포화수분함량\tsaturated moisture content\tsmc\n" +
            "포화수증기량\tsmc\tsmc\n" +
            "포화습도비\tsaturated humidity ratio\tshr\n" +
            "폭\tbreadth\tbt\n" +
            "표준\tstandard\tstd\n" +
            "품종\tvariety\tvrit\n" +
            "풍속\twind speed\tws\n" +
            "프로세스\tprocess\tprocs\n" +
            "하부, 최저부, 아래쪽\tbottom\tbot\n" +
            "하위\tlower part\tlwprt\n" +
            "학습\tlearning\tlrnng\n" +
            "합\tsum\tsum\n" +
            "해발고도\taltitude\taltitude\n" +
            "해제\trelease\trelis\n" +
            "현재\tcurrent\tcurr\n" +
            "호스트\thost\thost\n" +
            "홈페이지\thomepage\thmpg\n" +
            "확률\tprobability\trpblty\n" +
            "확장자\textension\textsn\n" +
            "환경\tenvironment\tenvrn\n" +
            "환기\tventilation\tventl\n" +
            "활동\taction\tact\n" +
            "회사\tcompany\tcmpny\n" +
            "복합\tcompound\tcmpnd\n" +
            "데이터\tdata\tdata\n" +
            "항목\titem\tiem\n" +
            "게시\tpost\tpst\n" +
            "사전\tdictionary\tdic\n" +
            "영문\tenglish\teng\n" +
            "약어\tabbreviation\tabr\n" +
            "데이터\tdata\tdata\n" +
            "전화번호\ttelephone number\ttelno\n" +
            "휴대전화번호\tmobile phone number\tmoblphono\n" +
            "학생\tstudent\tstdn\n" +
            "교사,선생님\tteacher\ttchr\n" +
            "컨설턴트\tconsultant\tcnstnt\n" +
            "서브\tsub\tsub\n" +
            "조회\tview\tview\n" +
            "대기압\tatmospheric pressure\tap\n" +
            "이슬점온도\tdew point\tdp\n" +
            "관리자\tmanager\tmngr\n" +
            "링크\tlink\tlink\n" +
            "만료\texpiration\texp\n" +
            "학과\tdepartment\tdept\n" +
            "학년\tgrade\tgrade\n" +
            "반(학급)\tclass\tclass\n" +
            "레벨\tlevel\tlevel\n" +
            "노출\texposure\texpsr\n" +
            "순번\tserial number\tsn\n" +
            "프로그램\tprogram\tprgrm\n" +
            "체크\tcheck\tchk\n" +
            "학적\tschool register\tsknrgs\n" +
            "연도\tyear\tyear\n" +
            "상단\tupper end\tupend\n" +
            "고정\tfixing\tfixing\n" +
            "학교\tschool\tschul\n" +
            "발급\tissue\tissu\n" +
            "아이디\tid\tid\n" +
            "담당\tcharge\tchrg\n" +
            "문의\tinquiry\tinqry\n" +
            "강의\tlecture\tlctre\n" +
            "유효\tvalidity\tvalid\n" +
            "목적\tpurpose\tpurps\n" +
            "장\thead\thed\n" +
            "토론\tdiscussion\tdscsn\n" +
            "진행\tprogress\tprogrs\n" +
            "검색\tsearch\tsearch\n" +
            "작업\toperation\topert\n" +
            "열람\treading\treadng\n" +
            "작성\twriting\twritng\n" +
            "컨설팅\tconsulting\tcnsl\n" +
            "요청\trequest\trequst\n" +
            "차시\thour\thour\n" +
            "자료\tdata\tdta\n" +
            "확인\tconfirm\tcnfirm\n" +
            "개요\tsummary\tsumry\n" +
            "방법\tmethod\tmth\n" +
            "과목\tsubject\tsbject\n" +
            "강사\tinstructor\tinstrctr\n" +
            "난이도\tdegree of difficulty\tdffly\n" +
            "연관\trelation\trelate\n" +
            "지침\tmanual\tmanual\n" +
            "모바일\tmobile\tmobile\n" +
            "순서\torder\tordr\n" +
            "수강\tattendance lecture\tatnlc\n" +
            "완료\tcompletion\tcompt\n" +
            "학력\tacademic career\tacdmcr\n" +
            "생일\tbirthday\tbrthdy\n" +
            "역량\tability\tability\n" +
            "증명\tproof\tproof\n" +
            "시나리오\tscenario\tsenario\n" +
            "월\tmonth\tmt\n" +
            "시간대\ttime zone\ttmzon\n" +
            "평가\tevaluation\tevl\n" +
            "결로\tcondensation\tcond\n" +
            "커튼\tcurtain\tcurtain\n" +
            "에너지\tenergy\tenergy\n" +
            "품목\titem\titem\n" +
            "주\tweek\tweek\n" +
            "분석\tanalysis\tanals\n" +
            "화방\tflower cluster\tfclustr\n" +
            "시설\tfacility\tfclty\n" +
            "규모\tscale\tscale\n" +
            "도입\tinduction\tindc\n" +
            "작기\tcropping season\tcrpsn\n" +
            "노트\tnote\tnote\n" +
            "관찰\tobservation\tobserv\n" +
            "병충해\tdamages by blight and harmful insects\tdlthts\n" +
            "발생\toccurrence\toccrrnc\n" +
            "비교\tcomparision\tcmpr\n" +
            "주야\tday and night\tdght\n" +
            "통계\tstatistics\tstats\n" +
            "뱃지\tbadge\tbadge\n" +
            "획득\tobtain\tobtain\n" +
            "조건\tcondition\tcnd\n" +
            "랭킹\tranking\trankng\n" +
            "부여\tallowance\talwnc\n" +
            "기준\tstandard\tstdr\n" +
            "포인트\tpoint\tpoint\n" +
            "사유\treason\tresn\n" +
            "컨텐츠\tcontents\tcntnts\n" +
            "재\tre\tre\n" +
            "점수\tscore\tscore\n" +
            "배치\tbatch\tbatch\n" +
            "기본\tbasis\tbass\n" +
            "연동\tinterlock\tintrlck\n" +
            "상세\tdetail\tdetail\n" +
            "아이콘\ticon\ticon\n" +
            "미션, 임무\tmission\tmisn\n" +
            "연차\tannual\tanl\n" +
            "초세\tplant vigor\tplt vigor\n" +
            "도전\tchallenge\tchlng\n" +
            "경영\tmanagement\tmngmt\n" +
            "정답\tcorrect answer\tcnsr\n" +
            "최근\trecent\trecent\n" +
            "수행\texecution\texc\n" +
            "다음\tnext\tnext\n" +
            "공휴일\tholiday\thldy\n" +
            "반복\trepetition\treptit\n" +
            "매년\tevery year\teveyr\n" +
            "출석\tattendance\tatend\n" +
            "팝업\tpopup\tpopup\n" +
            "트리\ttree\ttr\n" +
            "담임\thomeroom\thomeroom\n" +
            "교육\teducation\tedc\n" +
            "과정\tcourse\tcrse\n" +
            "이러닝\te-learning\telrnng\n" +
            "동영상\tmoving picture\tmvp\n" +
            "영상\tvideo\tvido\n" +
            "도움말\thelp comment\thpcm\n" +
            "결과\tresult\tresult\n" +
            "전체\tall\tall\n" +
            "농장\tfarm\tfarm\n" +
            "로딩\tloading\tldadng\n" +
            "라인\tline\tline\n" +
            "그래프\tgraph\tgraph\n" +
            "매뉴얼\tmanual\tmnl\n" +
            "참고\treference\trefer\n" +
            "기술\ttechnology\ttchnlgy\n" +
            "지원\tsupport\tsport\n" +
            "설치\tinstallation\tinstl\n" +
            "커뮤니티\tcommunity\tcmmnty\n" +
            "개인\tindividual\tindvdl\n" +
            "저작권\tcopyright\tcpyrht\n" +
            "약관\tstipulation\tstplat\n" +
            "종합\tgeneralization\tgnrlz\n" +
            "내역\tdetails\tdtls\n" +
            "이력서\tresume\tresume\n" +
            "관리\tmanagement\tmanage\n" +
            "디폴트\tdefault\tdflt\n" +
            "회차\ttime\ttme\n" +
            "실시간\treal time\trltm\n" +
            "표본\tsample\tsample\n" +
            "보광\tsupplemental lighting\tsplemntllght\n" +
            "분무\tmist\tmist\n" +
            "유동팬\tcirculation fan\tcirclfan\n" +
            "양액\tnutrient solution\tntrntslutn\n" +
            "감점\tdemerit mark\tdmrtr\n" +
            "조원\tmember\tmber\n" +
            "입력\tinput\tinput\n" +
            "출력\toutput\toutpt\n" +
            "오답\tincorrect answer\ticrct\n" +
            "차감\tdeduction\tddct\n" +
            "팁\ttip\ttip\n" +
            "가중치\tweight value\twghtval\n" +
            "조절\tadjustment\tadjst\n" +
            "텍스트\ttext\ttext\n" +
            "포맷\tformat\tfrmat\n" +
            "용어\tword\tword\n" +
            "초\tseconds\tsecnd\n" +
            "특별\tspecial\tspecl\n" +
            "퀴즈\tquiz\tquiz\n" +
            "문제\tquestion\tques\n" +
            "해설\texplanation\texplna\n" +
            "정식\tplanting\tpltng\n" +
            "ph\tph\tph\n" +
            "ec\tec\tec\n" +
            "농가\tfarmhouse\tfrmhs\n" +
            "엽병\tpetiole\tpetiole\n" +
            "식물\tplant\tplnt\n" +
            "열매\tfruit\tfrt\n" +
            "마디\tnode\tnode\n" +
            "관부\tcrown\tcrown\n" +
            "직경\tdiameter\tdm\n" +
            "꽃\tflower\tflwr\n" +
            "굵기\tthickness\tthck\n" +
            "연계\tcontact\tcntc\n" +
            "키워드\tkey word\tkwrd\n" +
            "도\tdo\tdo\n" +
            "시구\tsi gu\tsigu\n" +
            "시군\tsi gun\tsigun\n" +
            "시군구\tsi gun gu\tsigngu\n" +
            "배지\tculture medium\tclturmd\n" +
            "종류\tkind\tknd\n" +
            "재식\tplanting\tplntng\n" +
            "밀도\tdensity\tdn\n" +
            "적심\ttopping\ttoppng\n" +
            "업체\tenterprise\tentrps\n" +
            "매출금액\tmonth and day\tmd\n" +
            "월일\tpolicy\tpolicy\n" +
            "정책\tlimitation\tlmtt\n" +
            "제한\tlimitation\tlmtt\n" +
            "희망\thope\thope\n" +
            "생리\tphysiology\tpysiclg\n" +
            "장애\ttrouble\ttrobl\n" +
            "접속\tconnection\tconect\n" +
            "초기화\tinitialization\tinitl\n" +
            "일련번호(BIGINT)\tbig sequence\tbseq\n" +
            "가상\tvirtual\tvirtl\n" +
            "도메인\tdomain\tdomn\n" +
            "세대\tgeneration\tgnr\n" +
            "현장\tspot\tspt\n" +
            "구름\tcloud\tcloud";

    @Test
    void getPropertyKeyData() {
        replaceKeyDataLogic(keyData);
    }

    @Test
    void getPropertyValueData() {
        replaceValueDataLogic(valueData);
    }

    /**
     * targetData 안에는 용어의 key 컬럼 1열의 데이터를 복사하여 넣어 실행한 후 콘솔에 출력된 정보를 KeyAndValueData.properties 에 넣어주세요
     * @param targetData
     */
    private void replaceKeyDataLogic(String targetData) {
        // 콤마(",") 및 괄호("(") 를 개행으로 치환 후 개행을 탭으로 치환
        targetData = targetData.replaceAll(SPACE, EMPTY_STR);
        targetData = targetData.replaceAll(COMMA, NEW_LINE);
        targetData = targetData.replaceAll(OPEN_PARENTHESIS, NEW_LINE);
        targetData = targetData.replaceAll(CLOSE_PARENTHESIS, EMPTY_STR);
        targetData = targetData.replaceAll(NEW_LINE, TAB);
        targetData = targetData.replaceAll(NEW_LINE2, TAB);

//      key1, key2... 형식으로 구분한 데이터
        List<String> tempList = new ArrayList<>(Arrays.asList(targetData.split("\\t")));
        List<String> list = tempList.stream()
                .distinct()
                .collect(Collectors.toList());
        // key1=a 형식으로 출력
        for(int i =1; i<= list.size(); i++) {
            System.out.println("key" + i + "=" + list.get(i-1));
        }
    }

    /**
     * targetData 안에 용어의 key 부터 value 까지 3열의 데이터를 넣어 실행한 후 콘솔에 출력된 정보를 KeyAndValueData.properties 에 넣어주세요
     * @param targetData
     */
    private void replaceValueDataLogic(String targetData) {
        // 콤마(",") 및 괄호("(") 를 개행으로 치환 후 개행을 탭으로 치환
        targetData = targetData.replaceAll(SPACE, EMPTY_STR);
        targetData = targetData.replaceAll(COMMA, NEW_LINE);
        targetData = targetData.replaceAll(OPEN_PARENTHESIS, NEW_LINE2);
        targetData = targetData.replaceAll(CLOSE_PARENTHESIS, EMPTY_STR);
        targetData = targetData.replaceAll(TAB_ALL_TAB, EQUALS);
        targetData = targetData.replaceAll(NEW_LINE, TAB + VALUE_DOT);
        targetData = targetData.replaceAll(NEW_LINE2, TAB + VALUE_DOT);
        // 탭을 기준으로 split
        List<String> list = new ArrayList<>(Arrays.asList(targetData.split(TAB)));
        // 리스트 첫 번째 데이터에 "value." 붙인 정보로 수정
        String result = list.get(0).replaceAll(AT_THE_FRONT, VALUE_DOT);
        String result2 = list.get(0);
        list.set(0, result + result2);

        // 개행되어 value 값이 없는 데이터들 value 값 추가
        list = insertDataAtSplitData(list);

        // key, value 모두 동일한 데이터 삭제
        List<String> valueList = list.stream()
                .distinct()
                .collect(Collectors.toList());
        // value 데이터 통합 리스트 ex) 일련번호=seq, bseq
        List<String> valueSuperpositionData = valueSuperpositionDataExtraction(valueList);
        // 기존 리스트와 데이터 통합 리스트의 취합 후 동일정보 삭제
        List<String> resultList = deleteSame(valueList, valueSuperpositionData)
                .stream()
                .distinct()
                .collect(Collectors.toList());
        resultList.forEach(System.out::println);
    }

    private List<String> insertDataAtSplitData(List<String> list) {
        for (int j=0; j<=1; j++) {
            for (int i =1; i<= list.size(); i++) {
                String str = list.get(i-1);
                String str2 = "";
                if (! str.contains("=")) {
                    str2 = list.get(i);
                }
                Pattern pattern = Pattern.compile("(?<=\\=).+");
                Matcher matcher = pattern.matcher(str2);
                if (matcher.find() && ! str.contains("=")) {
                    list.add(i-1, list.get(i-1) + "=" + matcher.group());
                    list.remove(i);
                }
            }
        }
        return list;
    }

    private List<String> valueSuperpositionDataExtraction(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            for (int j=i+1; j<list.size(); j++) {
                Pattern pattern = Pattern.compile(".+=");
                Matcher matcher1 = pattern.matcher(list.get(i));
                Matcher matcher2 = pattern.matcher(list.get(j));

                if (matcher1.find() && matcher2.find() && matcher1.group().equals(matcher2.group())) {
                    Pattern valuePattern = Pattern.compile("(?<=[=]).+");
                    Matcher valueMatcher = valuePattern.matcher(list.get(j));
                    if (valueMatcher.find()) {
                        String tempData = list.get(i) + ", " + valueMatcher.group();
                        resultList.add(tempData);
                    }
                }
            }
        }
        return resultList;
    }

    private List<String> deleteSame(List<String> valueList, List<String> superCellList) {
        boolean flag;
        List<String> resultList = new ArrayList<>();
        for (int i=0; i<valueList.size(); i++) {
            flag = true;
            for (int j=0; j<superCellList.size(); j++) {
                // 둘다 처음부터 =까지 값을 추출 후 동일한지 확인
                Pattern pattern = Pattern.compile(".+=");
                Matcher matcher1 = pattern.matcher(valueList.get(i));
                Matcher matcher2 = pattern.matcher(superCellList.get(j));

                if (matcher1.find() && matcher2.find() && matcher1.group().equals(matcher2.group())) {
                    resultList.add(superCellList.get(j));
                    flag = false;
                }
            }
            if (flag == true) {
                resultList.add(valueList.get(i));
            }
        }
        return resultList;
    }

    private void copyInClipboard(List<String> list) {
        String result = "";
        for (int i=0; i<= list.size(); i++) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            result += "key" + i + "=" + list.get(i-1);
            if(result != null) {
                StringSelection contents = new StringSelection(result);
                clipboard.setContents(contents, null);
            }
        }
    }

}

