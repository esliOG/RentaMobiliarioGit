import os
import re

base_dir = r"c:\Users\eslio\AndroidStudioProjects\RentaMobiliarioApp\app\src\main\java\com\tuempresa\rentaapp"

class_locations = {
    'Producto': 'com.tuempresa.rentaapp.models.Producto',
    'AdminProductoAdapter': 'com.tuempresa.rentaapp.adapters.AdminProductoAdapter',
    'PedidoAdapter': 'com.tuempresa.rentaapp.adapters.PedidoAdapter',
    'ProductoAdapter': 'com.tuempresa.rentaapp.adapters.ProductoAdapter',
    'AdminInventarioFragment': 'com.tuempresa.rentaapp.ui.admin.AdminInventarioFragment',
    'AdminPedidosFragment': 'com.tuempresa.rentaapp.ui.admin.AdminPedidosFragment',
    'AdminMainActivity': 'com.tuempresa.rentaapp.ui.admin.AdminMainActivity',
    'CatalogoFragment': 'com.tuempresa.rentaapp.ui.user.CatalogoFragment',
    'ConfirmacionFragment': 'com.tuempresa.rentaapp.ui.user.ConfirmacionFragment',
    'MainActivity': 'com.tuempresa.rentaapp.ui.user.MainActivity',
    'RentasFragment': 'com.tuempresa.rentaapp.ui.user.RentasFragment',
    'LoginActivity': 'com.tuempresa.rentaapp.ui.auth.LoginActivity',
    'RegistroActivity': 'com.tuempresa.rentaapp.ui.auth.RegistroActivity',
    'PerfilFragment': 'com.tuempresa.rentaapp.ui.common.PerfilFragment'
}

for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.kt'):
            filepath = os.path.join(root, f)
            with open(filepath, 'r', encoding='utf-8') as file:
                content = file.read()
            
            match = re.search(r'^package\s+([a-zA-Z0-9_.]+)', content, re.MULTILINE)
            if not match: continue
            
            pkg = match.group(1)
            imports_to_add = []
            
            for class_name, full_pkg in class_locations.items():
                target_pkg = full_pkg.rsplit('.', 1)[0]
                if target_pkg == pkg:
                    continue
                
                # Exclude if it's just the file name itself without being used elsewhere
                if f == class_name + '.kt':
                    pass # actually wait, a class file might reference the class itself? better to just exclude self.
                
                if re.search(r'\b' + class_name + r'\b', content):
                    # check if not already imported
                    if f'import {full_pkg}' not in content:
                        imports_to_add.append(f'import {full_pkg}')
            
            if imports_to_add:
                lines = content.split('\n')
                out_lines = []
                for line in lines:
                    out_lines.append(line)
                    if line.startswith('package '):
                        out_lines.append('')
                        out_lines.extend(imports_to_add)
                
                with open(filepath, 'w', encoding='utf-8') as out:
                    out.write('\n'.join(out_lines))
