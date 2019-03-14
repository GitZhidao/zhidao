
(function($){
    stay = {
        start:$('#startDate'),
        end:$('#endDate'),
        today:(new Date()),
        init:function(){
            stay.inputVal();
            stay.endFun();
            stay.startFun();
        },
        startFun:function(){
            stay.start.datepicker({
                dateFormat : 'yy-mm-dd',
                dayNamesMin : ['日','一','二','三','四','五','六'],
                monthNames : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                altFormat : 'yy-mm-dd',
                yearSuffix:'年',
                showMonthAfterYear:true,
                appendText : '',
                firstDay : 1,
                showOtherMonths:true,
                minDate : 0,
                maxDate:180,
                onSelect:function(dateText,inst){
                    stay.end.datepicker('option', 'minDate', new Date(moment(dateText).add('days', 1)));
                    stay.end.datepicker('option', 'maxDate', new Date(moment(dateText).add('days', 180)));
                    var strDay =  stay.compare($(this));
                    stay.start.datepicker('option', 'appendText', strDay);
                    if((new Date(stay.end.val()) - new Date(dateText)) <= (24*60*60*1000)){
                        stay.end.datepicker('option', 'appendText', stay.compare(stay.end));
                    }
                }

            });
        },
        endFun:function(){
            stay.end.datepicker('refresh');
            stay.end.datepicker({
                dateFormat : 'yy-mm-dd',
                dayNamesMin : ['日','一','二','三','四','五','六'],
                monthNames : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
                altFormat : 'yy-mm-dd',
                yearSuffix:'年',
                showMonthAfterYear:true,
                appendText : '',
                firstDay : 1,
                showOtherMonths:true,
                minDate : 1,
                maxDate:180,
                    onSelect:function(){
                        stay.end.datepicker('option', 'appendText', stay.compare($(this)));
                    }
            });
        },
        transformStr:function(day,strDay){
            switch (day){

                }
            return strDay;
        },
        compare:function(obj){
            var strDay = '';
            var myDate = new Date(stay.today.getFullYear(),stay.today.getMonth(),stay.today.getDate());
            var day = (obj.datepicker('getDate') - myDate)/(24*60*60*1000);
            day == 0 ? strDay: day == 1?
                (strDay = '') : day == 2?
                (strDay = '') : (strDay = stay.transformStr(obj.datepicker('getDate').getDay(),strDay));
            return strDay;
        },
        inputVal:function(){
            stay.inputTimes(stay.start,1);
            stay.inputTimes(stay.end,2);
        },
        inputTimes:function(obj,day){
            var m = new Date(moment(stay.today).add('days', day));
            obj.val(m.getFullYear() + "-" + stay.addZero((m.getMonth()+1)) + "-" + stay.addZero(m.getDate()));
        },
        addZero:function(num){
            num < 10 ? num = "0" + num : num ;
            return num;
        }
    }
    stay.init();
})(jQuery);