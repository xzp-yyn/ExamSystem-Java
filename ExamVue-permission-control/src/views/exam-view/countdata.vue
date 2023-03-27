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
import { getviewdata } from '@/api/data/dataview'

export default {
  name: 'DigitalFlop',
  data() {
    return {
      data: {
        viewcount: 0,
      },
      digitalFlopData: [],
    }
  },
  created() {},
  methods: {
    createData() {
      const { randomExtend } = this
      getviewdata().then((res) => {
        this.data = res.data
        console.log(this.data)
        this.digitalFlopData = [
          {
            title: '系统访问量',
            number: {
              number: [this.data.viewcount],
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
              number: [this.data.runtime],
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
              number: [this.data.onlineperson],
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
            title: '题库种类',
            number: {
              number: [this.data.repocount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#40faee',
                fontWeight: 'bold',
              },
            },
            unit: '个',
          },
          {
            title: '题目数量',
            number: {
              number: [this.data.questioncount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#4d99fc',
                fontWeight: 'bold',
              },
            },
            unit: '个',
          },
          {
            title: '已有试卷',
            number: {
              number: [this.data.papercount],
              content: '{nt}',
              textAlign: 'right',
              style: {
                fill: '#f46827',
                fontWeight: 'bold',
              },
            },
            unit: '套',
          },
          {
            title: '已发布考试',
            number: {
              number: [this.data.examcount],
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
  height: 15%;
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