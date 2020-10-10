import request from '@/utils/request'

// 查询项目预算列表
export function listBusProjectBudget(query) {
  return request({
    url: '/project/busProjectBudget/list',
    method: 'get',
    params: query
  })
}

// 查询项目预算详细
export function getBusProjectBudget(id) {
  return request({
    url: '/project/busProjectBudget/' + id,
    method: 'get'
  })
}

// 新增项目预算
export function addBusProjectBudget(data) {
  return request({
    url: '/project/busProjectBudget',
    method: 'post',
    data: data
  })
}

// 修改项目预算
export function updateBusProjectBudget(data) {
  return request({
    url: '/project/busProjectBudget',
    method: 'put',
    data: data
  })
}

// 删除项目预算
export function delBusProjectBudget(id) {
  return request({
    url: '/project/busProjectBudget/' + id,
    method: 'delete'
  })
}

// 导出项目预算
export function exportBusProjectBudget(query) {
  return request({
    url: '/project/busProjectBudget/export',
    method: 'get',
    params: query
  })
}