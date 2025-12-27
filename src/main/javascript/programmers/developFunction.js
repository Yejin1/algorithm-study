
// 프로그래머스
// 기능개발
// 유형 : 스택
// https://school.programmers.co.kr/learn/courses/30/lessons/42586?language=javascript




function solution(progresses, speeds) {
    var days = new Array(progresses.length);
    var answer = new Array();

    for(var i=0; i<progresses.length; i++) {
        var remains = 100 - progresses[i];
        var num = Math.ceil(remains/speeds[i]);

        days[i] = num;
    }

    var cur = days[0];
    var cnt = 1;

    for(var i=1; i<days.length; i++) {
        if (cur >= days[i]) {
            cnt++;
        } else {
            answer.push(cnt);
            cur = days[i];
            cnt = 1;
        }
    }

    answer.push(cnt);



    return answer;
}