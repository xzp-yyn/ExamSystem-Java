<template>
  <div class="box center">
    <dv-border-box-1 class="border-box center-top">
      <div id="top"
           style="width:100%;height: 100%;">

      </div>
    </dv-border-box-1>
    <dv-border-box-1 class="border-box center-bottom">
      <dv-capsule-chart :config="config9"
                        class="charts1"
                        style="" />
    </dv-border-box-1>
  </div>

</template>
<script>
import Charts from '@jiaminghi/charts'
import { getPercentage, stuqueRanking } from '@/api/data/dataview'
import { config5, config9 } from './config.js'
export default {
  name: 'mapcenter',
  data: function () {
    return {
      config5,
      config9,
      option: {},
    }
  },
  mounted() {
    this.topinit()
    this.bottominit()
  },
  created() {},
  methods: {
    bottominit() {
      stuqueRanking().then((res) => {
        this.config9 = {
          data: res.data,
          colors: ['#e062ae', '#fb7293', '#e690d1', '#32c5e9', '#96bfff'],
          unit: '答题总数',
          showValue: true,
        }
      })
    },
    topinit() {
      const container = document.getElementById('top')
      const myChart = this.$echarts.init(container)
      getPercentage().then((res) => {
        myChart.setOption({
          title: {
            text: '错题占比饼状图',
            left: 'center',
            top: 5,
            textStyle: {
              color: '#fb7293',
            },
          },
          tooltip: {
            trigger: 'item',
            formatter: '{b} : {c} ({d}%)',
          },
          toolbox: {
            show: true,
            feature: {
              mark: { show: true },
              dataView: { show: true, readOnly: false },
              restore: { show: true },
              saveAsImage: { show: true },
            },
          },

          series: [
            {
              type: 'pie',
              // 高亮样式。
              emphasis: {
                itemStyle: {
                  // 高亮时点的颜色
                  color: 'red',
                },
              },
              data: res.data,
              insideLabel: {
                show: true,
              },
              roseType: true,
              textStyle: {
                color: '#fb7293',
              },
            },
          ],
        })
      })
    },
  },
}
</script>

<style scoped>
#top {
}
.center {
  width: 50%;
  height: 85%;
}
.center-bottom {
  bottom: 1%;
  height: 45%;
}
.center-top {
  align-items: center;
  text-align: center;
  height: 108%;
}
.box {
  display: flex;
  flex-direction: column;
}
.charts {
  width: 90%;
  height: 400px;
  margin: 3%;
}
.charts1 {
  margin: 1%;
  margin-top: 5%;
  margin-bottom: 5%;
}
</style>