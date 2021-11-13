/**
 * @param {number[]} temperatures
 * @return {number[]}
 */
var dailyTemperatures = function(temperatures) {
    var n = temperatures.length;
    var result = new Array(n);
    for(var i = n-1, maxi = n-1; i >= 0; i--){
        if(temperatures[i] >= temperatures[maxi]){
            result[i] = 0;
            maxi = i;
        }
        else{ // temp[i] < temp[maxi]
            // use the calculated result to find next warmer temp for cur temp
            var step = 1;
            while(temperatures[i+step] <= temperatures[i]){
                step += result[i+step];
            }
            result[i] = step;
        }
    }
    return result;
};
