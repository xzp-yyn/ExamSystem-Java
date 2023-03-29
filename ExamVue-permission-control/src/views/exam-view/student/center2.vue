<template>
  <div class="box center">
    <dv-scroll-board :config="config"
                     class="top" />

    <div id="water-level-chart">
      <div class="water-level-chart-title">计划资金累计完成情况</div>
      <div class="chart-container">
        <dv-water-level-pond :config="config1" />
      </div>
    </div>
  </div>

</template>
<script>
import Charts from '@jiaminghi/charts'
export default {
  name: 'mapcenter',
  data: function () {
    return {
      config: {},
      config1: {},
    }
  },
  mounted() {
    this.topinit()
  },
  created() {},
  methods: {
    topinit() {
      this.config = {
        header: ['时间', '病害信息', '数量', '标段'],
        data: [
          ['2019-07-01 19:25:00', '路面危害-松散', '5', 'xxxxxxx'],
          ['2019-07-02 17:25:00', '路面危害-路面油污清理', '13', 'xxxxxxx'],
          ['2019-07-03 16:25:00', '交安设施-交通标志牌结构', '6', 'xxxxxxx'],
          ['2019-07-04 15:25:00', '路基危害-防尘网', '2', 'xxxxxxx'],
          ['2019-07-05 14:25:00', '交安设施-交通标志牌结构', '1', 'xxxxxxx'],
          ['2019-07-06 13:25:00', '路面危害-松散', '3', 'xxxxxxx'],
          ['2019-07-07 12:25:00', '路基危害-防尘网', '4', 'xxxxxxx'],
          ['2019-07-08 11:25:00', '路面危害-路面油污清理', '2', 'xxxxxxx'],
          ['2019-07-09 10:25:00', '交安设施-交通标志牌结构', '5', 'xxxxxxx'],
          ['2019-07-10 09:25:00', '路基危害-防尘网', '3', 'xxxxxxx'],
        ],
        index: true,
        columnWidth: [50, 170, 300],
        align: ['center'],
        rowNum: 7,
        headerBGC: '#1981f6',
        headerHeight: 45,
        oddRowBGC: 'rgba(0, 44, 81, 0.8)',
        evenRowBGC: 'rgba(10, 29, 50, 0.8)',
      }
      this.config1 = {
        data: [45, 55],
        shape: 'round',
        waveHeight: 25,
        waveNum: 2,
      }
    },
  },
}
</script>

<style scoped>
#water-level-chart {
  width: 90%;
  box-sizing: border-box;
  margin: 0 2%;
  background-color: rgba(6, 30, 93, 0.5);
  border-top: 2px solid rgba(1, 153, 209, 0.5);
  display: flex;
  flex-direction: column;
}
.water-level-chart-title {
  font-weight: bold;
  height: 50px;
  display: flex;
  align-items: center;
  font-size: 20px;
  justify-content: center;
}
.water-level-chart-details {
  height: 15%;
  display: flex;
  justify-content: center;
  font-size: 17px;
  align-items: flex-end;
}
span {
  font-size: 35px;
  font-weight: bold;
  color: #58a1ff;
  margin: 0 5px;
  margin-bottom: -5px;
}
.chart-container {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
}
.dv-water-pond-level {
  max-width: 90%;
  width: 200px;
  height: 200px;
  border: 10px solid #19c3eb;
  border-radius: 50%;
}
ellipse {
  stroke: transparent !important;
}
text {
  font-size: 40px;
}
.center {
  width: 50%;
  height: 80%;
  margin: 0 1%;
}
.center-bottom {
  bottom: 1%;
  height: min-content;
}
.center-top {
  align-items: center;
  text-align: center;
  height: 100%;
}
.box {
  display: flex;
  flex-direction: column;
}
.top {
  width: 90%;
  height: 400px;
  margin: 0 2%;
}
.bottom {
  margin: 1%;
  margin-top: 5%;
  margin-bottom: 5%;
}
</style>