<template>
  <div id="ranking-board">
    <div class="ranking-board-title">考试正确数量</div>
    <dv-scroll-ranking-board :config="config" />
  </div>
</template>
<script>
import { stuExamCount } from '@/api/data/dataview'
import { getToken } from '@/utils/auth'
export default {
  name: 'Boxleft',
  name: 'RankingBoard',
  data() {
    return {
      config: {
        data: [
          {
            name: '日常养护',
            value: 55,
          },
          {
            name: '交通事故',
            value: 120,
          },
          {
            name: '路面',
            value: 78,
          },
          {
            name: '桥通',
            value: 66,
          },
          {
            name: '计日工',
            value: 80,
          },
          {
            name: '路基',
            value: 45,
          },
          {
            name: '交安设施',
            value: 29,
          },
          {
            name: '除雪',
            value: 29,
          },
          {
            name: '绿化',
            value: 29,
          },
        ],
      },
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      var token = getToken()
      stuExamCount(token).then((res) => {
        this.config = {
          data: res.data,
        }
      })
    },
  },
}
</script>
<style scoped>
#ranking-board {
  width: 20%;
  height: 85%;
  margin-left: 1%;
  box-shadow: 0 0 3px blue;
  display: flex;
  flex-direction: column;
  background-color: rgba(6, 30, 93, 0.5);
  border-top: 2px solid rgba(1, 153, 209, 0.5);
  box-sizing: border-box;
  padding: 0px 30px;
  border-bottom: 2px solid blue;
  border-left: 1px solid red;
  border-right: 1px solid red;
}
.ranking-board-title {
  font-weight: bold;
  height: 50px;
  display: flex;
  align-items: center;
  font-size: 20px;
  margin: 0 auto;
  text-align: center;
}
.dv-scroll-ranking-board {
  flex: 1;
}
</style>