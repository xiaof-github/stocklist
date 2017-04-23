/**
 * Created by xiaof on 2017/2/18.
 */
'use strict';

Vue.component('app', {
    template: '#app-template',
    data: function () {
        return {
            msg: 'Welcome to Vue.js World'
        }
    }
});

Vue.component('clock', {
    template: '#clock-template',
    data: function () {
        return { time: "00:00:00"}
    },
    mounted: function () {
        this.startTime()
    },
    methods: {
        startTime: function () {
            var today = new Date();
            var h = today.getHours();
            var m = today.getMinutes();
            var s = today.getSeconds();
            m = this.checkTime(m);
            s = this.checkTime(s);

            this.time = h + ":" + m + ":" + s;
            var t = setTimeout(this.startTime, 500);
        },
        checkTime: function(i) {
            if (i < 10) {
                i = "0" + i
            };
            return i;
        }
    }
});

new Vue({
    el: '#app'
})