<template>
  <div class="box right">
    <dv-border-box-11 class="border-box right-top">
      <dv-charts :option="config8"></dv-charts>
    </dv-border-box-11>
    <dv-border-box-3 class="border-box right-bottom">
      <dv-active-ring-chart :config="config10"
                            style="width:300px;height:300px;margin: auto;" />
    </dv-border-box-3>

  </div>

</template>
<script>
import { config8, config10 } from './config.js'
import { passingPercentage, perstuPercentage } from '@/api/data/dataview'
export default {
  name: 'right',
  data: function () {
    return {
      config8,
      config10,
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      passingPercentage().then((res) => {
        this.config8 = {
          title: {
            text: '考试及格率',
            style: {
              fill: '#fff',
            },
          },

          series: [
            {
              type: 'gauge',
              name: 'xx',
              details: {
                offset: [100, 10],
                show: true,
                // style: {
                //   fontSize: 20,
                //   fontWeight: 'bold',
                //   textAlign: 'center',
                //   textBaseline: 'middle',
                // },
              },
              data: [
                {
                  name: 'itemA',
                  value: res.data,
                  gradient: ['#e7bcf3', '#e690d1', '#fb7293'],
                  localGradient: true,
                },
              ],
              center: ['50%', '55%'],
              axisLabel: {
                formatter: '{value}%',
                style: {
                  fill: '#fff',
                },
              },
              axisTick: {
                style: {
                  stroke: '#fff',
                },
              },
              animationCurve: 'easeInOutBack',
            },
          ],
        }
      })
      perstuPercentage().then((res) => {
        this.config10 = {
          data: res.data,
          radius: '40%',
          activeRadius: '45%',
          digitalFlopStyle: {
            fontSize: 20,
          },
          showOriginValue: true,
        }
      })
    },
  },
}
</script>

<style scoped>
.box {
  display: flex;
  flex-direction: column;
}
.right-top {
  margin-bottom: 5%;
  display: flex;
}
.right-bottom {
  margin-top: 5%;
  bottom: 1%;
}
.right {
  height: 90%;
  width: 25%;
}
.dv-border-box-3 {
  height: 150% !important;
}
</style>