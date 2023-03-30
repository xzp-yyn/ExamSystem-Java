<template>
  <div class="box center">
    <dv-scroll-board :config="config"
                     class="top" />

    <div id="water-level-chart">
      <div class="water-level-chart-title">考试累计完成情况</div>
      <div class="chart-container">
        <dv-water-level-pond :config="config1" />
      </div>
    </div>
  </div>

</template>
<script>
import Charts from '@jiaminghi/charts'
import { getToken } from '@/utils/auth'
import { examRanking, getMyExamCount } from '@/api/data/dataview'
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
      var token = getToken()
      examRanking().then((res) => {
        this.config = {
          header: ['截止时间', '考试信息', '题目数量', '及格分数'],
          data: res.data,
          index: true,
          columnWidth: [50, 170, 200, 100],
          align: ['center'],
          rowNum: 6,
          headerBGC: '#1981f6',
          headerHeight: 45,
          oddRowBGC: 'rgba(0, 44, 81, 0.8)',
          evenRowBGC: 'rgba(10, 29, 50, 0.8)',
        }
      })
      getMyExamCount(token).then((res) => {
        this.config1 = {
          data: res.data,
          shape: 'round',
          waveHeight: 25,
          waveNum: 2,
        }
      })
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
  height: 85%;
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