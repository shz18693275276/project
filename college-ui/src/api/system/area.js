import request from '@/utils/request'

// 查询部门列表
export function listArea(query) {
  return request({
    url: '/system/area/list',
    method: 'get',
    params: query
  })
}

// 查询部门列表（排除节点）
export function listDeptExcludeChild(deptId) {
  return request({
    url: '/system/area/list/exclude/' + deptId,
    method: 'get'
  })
}

// 查询部门详细
export function getArea(deptId) {
  return request({
    url: '/system/area/' + deptId,
    method: 'get'
  })
}

// 查询部门下拉树结构
export function treeselect() {
  return request({
    url: '/system/area/treeselect',
    method: 'get'
  })
}

// 根据角色ID查询部门树结构
export function roleDeptTreeselect(roleId) {
  return request({
    url: '/system/area/roleDeptTreeselect/' + roleId,
    method: 'get'
  })
}

// 新增部门
export function addArea(data) {
  return request({
    url: '/system/area',
    method: 'post',
    data: data
  })
}

// 修改部门
export function updateArea(data) {
  return request({
    url: '/system/area',
    method: 'put',
    data: data
  })
}

// 删除部门
export function delArea(deptId) {
  return request({
    url: '/system/area/' + deptId,
    method: 'delete'
  })
}
