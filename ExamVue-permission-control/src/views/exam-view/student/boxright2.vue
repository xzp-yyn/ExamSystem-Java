<template>
  <div class="center-cmp">
    <div class="cc-header">
      <dv-decoration-1 style="width:200px;height:50px;" />
      <div>xx</div>
      <dv-decoration-1 style="width:200px;height:50px;" />
    </div>

    <div class="cc-details">
      <div>Time</div>
      <div class="card">
        {{ time.h }}
      </div>:
      <div class="card">
        {{ time.m }}
      </div>:
      <div class="card">
        {{ time.s }}
      </div>
    </div>
    <dv-border-box-1 class="right-bottom"
                     id="main">

    </dv-border-box-1>

  </div>
</template>
<script>
import { wrongCount } from '@/api/data/dataview'
import { getToken } from '@/utils/auth'
export default {
  name: 'right',
  data: function () {
    return {
      config: {},
      timer: null,
      time: {
        h: new Date().getHours(),
        m:
          new Date().getMinutes() < 10
            ? '0' + new Date().getMinutes()
            : new Date().getMinutes(),
        s:
          new Date().getSeconds() < 10
            ? '0' + new Date().getSeconds()
            : new Date().getSeconds(),
      },
      option: {},
    }
  },
  mounted() {
    this.createData()
    this.refreshtime()
    this.bottomdata()
  },
  beforeDestroy() {
    clearInterval(this.timer)
  },

  methods: {
    refreshtime() {
      this.timer = setInterval(() => {
        this.time = {
          h: new Date().getHours(),
          m:
            new Date().getMinutes() < 10
              ? '0' + new Date().getMinutes()
              : new Date().getMinutes(),
          s:
            new Date().getSeconds() < 10
              ? '0' + new Date().getSeconds()
              : new Date().getSeconds(),
        }
      }, 1000)
    },
    createData() {
      this.config = {
        data: [
          {
            name: '收费站',
            value: 1315,
          },
          {
            name: '监控中心',
            value: 415,
          },
          {
            name: '道路外场',
            value: 90,
          },
          {
            name: '其他',
            value: 317,
          },
        ],
        color: ['#00baff', '#3de7c9', '#fff', '#ffc530', '#469f4b'],
        lineWidth: 30,
        radius: '55%',
        activeRadius: '60%',
      }
    },
    bottomdata() {
      var chartDom = document.getElementById('main')
      var myChart = this.$echarts.init(chartDom)

      var token = getToken()
      // debugger
      wrongCount(token).then((res) => {
        this.option = {
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)',
          },
          legend: {
            data: res.data.legenddata,
          },
          series: [
            {
              name: 'Access From',
              type: 'pie',
              selectedMode: 'single',
              radius: [0, '30%'],
              label: {
                position: 'inner',
                fontSize: 14,
              },
              labelLine: {
                show: false,
              },
              data: res.data.seriesdata,
            },
            {
              name: 'Access From',
              type: 'pie',
              radius: ['45%', '60%'],
              labelLine: {
                length: 30,
              },
              label: {
                formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                backgroundColor: '#F6F8FC',
                borderColor: '#8C8D8E',
                borderWidth: 1,
                borderRadius: 4,
                rich: {
                  a: {
                    color: '#6E7079',
                    lineHeight: 22,
                    align: 'center',
                  },
                  hr: {
                    borderColor: '#8C8D8E',
                    width: '100%',
                    borderWidth: 1,
                    height: 0,
                  },
                  b: {
                    color: '#4C5058',
                    fontSize: 14,
                    fontWeight: 'bold',
                    lineHeight: 33,
                  },
                  per: {
                    color: '#fff',
                    backgroundColor: '#4C5058',
                    padding: [3, 4],
                    borderRadius: 4,
                  },
                },
              },
              data: res.data.seriesdata,
            },
          ],
        }
        this.option && myChart.setOption(this.option)
      })
    },
  },
}
</script>
<style scoped>
.center-cmp {
  width: 33%;
  height: 100%;
  margin: 0px;
  padding: 0px;
  display: flex;
  flex-direction: column;
}
.cc-header {
  height: 70px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 30px;
}
.cc-details {
  height: 120px;
  display: flex;
  justify-content: center;
  font-size: 32px;
  align-items: center;
}
.card {
  background-color: rgba(4, 49, 128, 0.6);
  color: #08e5ff;
  height: 70px;
  width: 100px;
  font-size: 45px;
  font-weight: bold;
  line-height: 70px;
  text-align: center;
  margin: 10px;
}
.ccmc-middle {
  width: 50%;
  height: 90%;
}
.active-ring-name {
  font-size: 20px !important;
}
.right_bottom {
  height: 52% !important;
}
</style>