<template>
  <div class="box right">
    <el-dropdown size="medium"
                 @command="handleCommand"
                 split-button
                 class="dropdown">
      {{ firstmenu }}
      <el-dropdown-menu slot="dropdown">
        <template v-for="e in menu">
          <el-dropdown-item :command=e>{{ e }}</el-dropdown-item>
        </template>

      </el-dropdown-menu>
    </el-dropdown>
    <dv-border-box-1 class="border-box right-top"
                     ref="box">
      <span class="exampass">考试及格率</span>
      <dv-charts :option="config8"></dv-charts>
    </dv-border-box-1>
    <dv-border-box-3 class="border-box right-bottom"
                     ref="box">
      <dv-active-ring-chart :config="config10"
                            style="width:300px;height:300px;margin: auto;" />
    </dv-border-box-3>

  </div>

</template>
<script>
import { config8, config10 } from './config.js'
import {
  passingPercentage,
  perstuPercentage,
  examNames,
  examPassPercen,
} from '@/api/data/dataview'
export default {
  name: 'right',
  data: function () {
    return {
      config8,
      config10,
      menu: [],
      firstmenu: '',
    }
  },
  mounted() {
    this.init()
    setTimeout(() => {
      this.$refs.box.initWH()
    }, 100)
    this.initmenu()
  },
  methods: {
    initmenu() {
      examNames().then((res) => {
        this.menu = res.data
        this.firstmenu = res.data[0]
      })
    },
    handleCommand(command) {
      this.firstmenu = command
      examPassPercen(this.firstmenu).then((res) => {
        this.config8 = {
          series: [
            {
              type: 'gauge',
              name: 'x',
              details: {
                offset: [100, 10],
                // show: true,
                // style: {
                //   fontSize: 20,
                //   fontWeight: 'bold',
                //   textAlign: 'center',
                //   textBaseline: 'middle',
                // },
              },
              radius: '90%',
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
    },
    init() {
      passingPercentage().then((res) => {
        this.config8 = {
          // title: {
          //   text: '考试及格率',
          //   style: {
          //     fill: '#fff',
          //   },
          // },

          series: [
            {
              type: 'gauge',
              name: 'x',
              details: {
                offset: [100, 10],
                // show: true,
                // style: {
                //   fontSize: 20,
                //   fontWeight: 'bold',
                //   textAlign: 'center',
                //   textBaseline: 'middle',
                // },
              },
              radius: '90%',
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
.exampass {
  width: inherit;
  text-align: center;
  display: inline-block;
}
.dropdown {
  display: flex;
  position: relative;
  margin: 3% auto;
}
.box {
  display: flex;
  flex-direction: column;
}
.right-top {
  margin-bottom: 5%;
  display: flex;
  /* position: unset; */
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