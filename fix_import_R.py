import os
import re

base_dir = r"c:\Users\eslio\AndroidStudioProjects\RentaMobiliarioApp\app\src\main\java\com\tuempresa\rentaapp"

for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.kt'):
            filepath = os.path.join(root, f)
            with open(filepath, 'r', encoding='utf-8') as file:
                content = file.read()
            
            # Find the package declaration line
            match = re.search(r'^package\s+([a-zA-Z0-9_.]+)', content, re.MULTILINE)
            if not match: continue
            
            pkg = match.group(1)
            
            # If the package is NOT the root package where R lives:
            if pkg != 'com.tuempresa.rentaapp':
                # Check if it's already importing R
                if 'import com.tuempresa.rentaapp.R' not in content:
                    # Check if the file actually uses R
                    if re.search(r'\bR\.', content):
                        # Add it
                        lines = content.split('\n')
                        out_lines = []
                        for line in lines:
                            out_lines.append(line)
                            if line.startswith('package '):
                                out_lines.append('')
                                out_lines.append('import com.tuempresa.rentaapp.R')
                                
                        with open(filepath, 'w', encoding='utf-8') as out:
                            out.write('\n'.join(out_lines))
