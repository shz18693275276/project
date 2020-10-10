import request from '@/utils/request'

// 查询项目可行性报告列表
export function listBusProjectReport(query) {
  return request({
    url: '/project/busProjectReport/list',
    method: 'get',
    params: query
  })
}

// 查询项目可行性报告详细
export function getBusProjectReport(id) {
  return request({
    url: '/project/busProjectReport/' + id,
    method: 'get'
  })
}

// 新增项目可行性报告
export function addBusProjectReport(data) {
  return request({
    url: '/project/busProjectReport',
    method: 'post',
    data: data
  })
}

// 修改项目可行性报告
export function updateBusProjectReport(data) {
  return request({
    url: '/project/busProjectReport',
    method: 'put',
    data: data
  })
}

// 删除项目可行性报告
export function delBusProjectReport(id) {
  return request({
    url: '/project/busProjectReport/' + id,
    method: 'delete'
  })
}

// 导出项目可行性报告
export function exportBusProjectReport(query) {
  return request({
    url: '/project/busProjectReport/export',
    method: 'get',
    params: query
  })
}

// 根据项目id查询可行性报告
export function getReportProjectId(projectId) {
  return request({
    url: '/project/busProjectReport/getReportProjectId/' + projectId,
    method: 'get'
  })
}