import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'nhan-vien',
        data: { pageTitle: 'todoApp2App.nhanVien.home.title' },
        loadChildren: () => import('./nhan-vien/nhan-vien.module').then(m => m.NhanVienModule),
      },
      {
        path: 'role',
        data: { pageTitle: 'todoApp2App.role.home.title' },
        loadChildren: () => import('./role/role.module').then(m => m.RoleModule),
      },
      {
        path: 'don-vi',
        data: { pageTitle: 'todoApp2App.donVi.home.title' },
        loadChildren: () => import('./don-vi/don-vi.module').then(m => m.DonViModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class EntityRoutingModule {}
