<template>
  <div id="digital-flop">
    <div class="digital-flop-item"
         v-for="item in digitalFlopData"
         :key="item.title">
      <div class="digital-flop-title">{{ item.title }}</div>
      <div class="digital-flop">
        <dv-digital-flop :config="item.number"
                         style="width:100px;height:50px;" />
        <div class="unit">{{ item.unit }}</div>
      </div>
    </div>

    <dv-decoration-10 />
  </div>
</template>

<script>
import { stuHeadData } from '@/api/data/dataview'
import { getToken } from '@/utils/auth'
import { parseTime } from '@/utils'
export default {
  name: 'DigitalFlop',
  data() {
    return {
      digitalFlopData: [],
    }
  },
  methods: {
    createData() {
      // const { randomExtend } = this
      var token = getToken()
      // console.log(token)
      stuHeadData(token).then((res) => {
        this.digitalFlopData = [
          {
            title: '系统访问量',
            number: {
              number: [res.data.viewcount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#4d99fc',
                fontWeight: 'bold',
              },
            },
            unit: '次',
          },
          {
            title: '系统运行时长',
            number: {
              number: [res.data.runtime],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#40faee',
                fontWeight: 'bold',
              },
            },
            unit: '小时',
          },
          {
            title: '在线人数',
            number: {
              number: [res.data.onlineperson],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#f46827',
                fontWeight: 'bold',
              },
            },
            unit: '人',
          },
          {
            title: '我的考试次数',
            number: {
              number: [res.data.myexamcount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#40faee',
                fontWeight: 'bold',
              },
            },
            unit: '次',
          },
          {
            title: '我的及格次数',
            number: {
              number: [res.data.passcount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#4d99fc',
                fontWeight: 'bold',
              },
            },
            unit: '次',
          },
          {
            title: '最近一次考试',
            number: {
              number: res.data.lasttime,
              content: '{nt}.{nt}.{nt}',
              textAlign: 'center',
              style: {
                fill: '#f46827',
                fontWeight: 'bold',
              },
            },
            unit: '',
          },
          {
            title: '现有考试',
            number: {
              number: [res.data.examcount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#4d99fc',
                fontWeight: 'bold',
              },
            },
            unit: '场',
          },
        ]
      })
    },
    randomExtend(minNum, maxNum) {
      if (arguments.length === 1) {
        return parseInt(Math.random() * minNum + 1, 10)
      } else {
        return parseInt(Math.random() * (maxNum - minNum + 1) + minNum, 10)
      }
    },
  },
  mounted() {
    const { createData } = this
    createData()
    setInterval(createData, 300000)
  },
}
</script>

<style lang="less">
#digital-flop {
  position: relative;
  height: 10%;
  flex-shrink: 0;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: rgba(6, 30, 93, 0.5);
  .dv-decoration-10 {
    position: absolute;
    width: 95%;
    left: 2.5%;
    height: 5px;
    bottom: 0px;
  }
  .digital-flop-item {
    width: 11%;
    height: 80%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    border-left: 3px solid rgb(6, 30, 93);
    border-right: 3px solid rgb(6, 30, 93);
  }
  .digital-flop-title {
    font-size: 20px;
    margin-bottom: 20px;
  }
  .digital-flop {
    display: flex;
  }
  .unit {
    margin-left: 10px;
    display: flex;
    align-items: flex-end;
    box-sizing: border-box;
    padding-bottom: 13px;
  }
}
</style>