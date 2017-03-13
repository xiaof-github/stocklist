/**
 * Created by xiaof on 2017/2/18.
 */
'use strict';

var listController = function ($scope, $http) {
    $scope.fetchStockList = function () {
        $http.get('api/list', {code: "000024"} ).success(function(stockList){
             $scope.stock = stockList;
             console.log(stocklist);
             //jiexi stock
        })

    }

    $scope.fetchStockList();
}
